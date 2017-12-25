package com.fudanse.methodchain;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fudanse.methodchain.gexfparser.GexfParser;
import com.fudanse.methodchain.gexfparser.SourceTargetPair;
import com.fudanse.methodchain.model.Method;
import com.fudanse.methodchain.service.IMethodChainService;
import com.fudanse.methodchain.service.impl.MethodChainService;
import com.fudanse.methodchain.util.ProjectUtil;

public class GenerateGraph {

	private Set<String> packages;
	private IMethodChainService service = new MethodChainService();

	public GenerateGraph() {
		packages = new HashSet<>();
	}

	public GenerateGraph(File project) {
		packages = ProjectUtil.getPackageList(project);
	}

	public void create(File file) {
		List<SourceTargetPair> stps = new GexfParser(file).getSourceTargetPairList();
		for (SourceTargetPair stp : stps) {
			Method source = st2Method(stp.getSource());
			if (!packages.contains(source.getPackageName()))
				continue;
			if(source.getMethodName().startsWith("<") && source.getMethodName().endsWith(">"))
				continue;
			source.setProjectName(stp.getProject());
			source = service.saveMethod(source);
			Method target = st2Method(stp.getTarget());
			target.setProjectName(stp.getProject());
			target = service.saveMethod(target);
			if(source.getId() != null && target.getId() != null)
				service.saveChain(source.getId(), target.getId());
		}
	}

	private Method st2Method(String st) {
		st = st.substring(1, st.length() - 1);// 去掉<>
		String pgAndClass = st.split(":")[0];
		String nameAndFields = st.split(":")[1];
		String className = null;
		String packageName = null;
		if (pgAndClass.contains(".")) {
			String[] str = pgAndClass.split("[.]");
			className = str[str.length - 1];
			packageName = pgAndClass.substring(0, pgAndClass.length() - className.length() - 1);
		} else {
			className = pgAndClass;
		}
		if (className.contains("$"))
			className = className.substring(0, className.indexOf("$"));
		nameAndFields = nameAndFields.split(" ")[2];
		String str[] = nameAndFields.split("\\(");
		String name = str[0];
		if (name.contains("$"))
			name = name.substring(0, name.indexOf("$"));
		String fieldString = str[1].substring(0, str[1].length() - 1);
		String fields = null;
		if (fieldString.length() != 0)
			fields = fieldString;
		return new Method.Builder().packageName(packageName).className(className).methodName(name).field(fields)
				.build();
	}

	public static void main(String[] args) {
		File pjFile = new File("/Users/xiyaoguo/Desktop/WorldClock");
		File gexfFile = new File("/Users/xiyaoguo/Desktop/WorldClock.gexf");
		new GenerateGraph(pjFile).create(gexfFile);
	}

}
