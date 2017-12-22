package com.fudanse.methodchain;

import java.io.File;
import java.net.StandardSocketOptions;
import java.util.List;

import com.fudanse.methodchain.model.Method;
import com.fudanse.methodchain.util.ProjectUtil;

public class GenerateGraph {

	private List<String> packages;
	private File file;

	public GenerateGraph(File file) {
		this.file = file;
		packages = ProjectUtil.getPackageList(file);
	}

	private Method st2Method(String st) {
		st = st.substring(1, st.length() - 1);// 去掉<>
		String pgAndClass = st.split(":")[0];
		String nameAndFields = st.split(":")[1];
		String className = null;
		String packageName = null;
		if (pgAndClass.contains("[.]")) {
			String[] str = pgAndClass.split("[.]");
			className = str[str.length - 1];
			packageName = pgAndClass.substring(0, pgAndClass.length() - className.length() - 1);
		} else {
			className = pgAndClass;
		}
		if(className.contains("$")){
			className.substring(0, className.indexOf("$"));
		}
		nameAndFields = nameAndFields.split(" ")[2];
		
		return new Method.Builder().build();
	}
	
	public static void main(String[] args) {
		String str = " hello world";
		System.out.println(str.split(" ")[1]);
	}

}
