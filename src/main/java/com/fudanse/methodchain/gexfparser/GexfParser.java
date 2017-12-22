package com.fudanse.methodchain.gexfparser;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GexfParser {

	private File file;
	private String projectName;

	public GexfParser(String path) {
		this.file = new File(path);
		projectName = file.getName().split(".")[0];
	}

	public GexfParser(File file) {
		this.file = file;
		projectName = file.getName().split(".")[0];
	}

	public List<SourceTargetPair> getSourceTargetPairList() {
		List<SourceTargetPair> stps = new ArrayList<>();
		if (file == null)
			return stps;
		try {
			String source = "";
			String target = "";
			SAXReader reader = new SAXReader();
			Document document = reader.read(file);
			Element root = document.getRootElement();
			Element edgeselement = root.element("graph").element("edges");
			Iterator edges = edgeselement.elementIterator();
			while (edges.hasNext()) {
				Element edge = (Element) edges.next();
				List<Attribute> edgelist = edge.attributes();
				for (Attribute attr : edgelist) {
					if (attr.getName().equals("source"))
						source = attr.getValue();
					if (attr.getName().equals("target"))
						target = attr.getValue();
				}
				if (source.startsWith("<com.") || target.startsWith("<com.")) {
					SourceTargetPair stp = new SourceTargetPair();
					stp.setProject(projectName);
					stp.setSource(source);
					stp.setTarget(target);
					stps.add(stp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return stps;
	}

}
