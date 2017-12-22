package com.fudanse.methodchain.model;

import java.util.ArrayList;
import java.util.List;

public class MethodSearch {

	private String projectName;

	private String packageName;

	private String className;

	private String methodName;

	private List<String> field = new ArrayList<String>();

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void addField(String field) {
		this.field.add(field);
	}

	public List<String> getField() {
		return field;
	}

	public void setField(List<String> field) {
		this.field = field;
	}

}
