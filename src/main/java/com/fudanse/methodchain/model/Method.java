package com.fudanse.methodchain.model;

import java.util.ArrayList;
import java.util.List;

public class Method {

	private Long id;

	private List<String> label = new ArrayList<String>();

	private String projectName;

	private String packageName;

	private String className;

	private String methodName;

	private String field;

	public Method() {

	}

	public Long getId() {
		return id;
	}

	public List<String> getLabel() {
		return label;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getClassName() {
		return className;
	}

	public String getMethodName() {
		return methodName;
	}

	public String getField() {
		return field;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLabel(List<String> label) {
		this.label = label;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public void setField(String field) {
		this.field = field;
	}

	public static class Builder {

		private Method target;

		public Builder() {
			target = new Method();
		}

		public Builder label(String label) {
			target.label.add(label);
			return this;
		}

		public Builder label(List<String> labels) {
			if (labels != null)
				target.label.addAll(labels);
			return this;
		}

		public Builder projectName(String projectName) {
			target.projectName = projectName;
			return this;
		}

		public Builder packageName(String packageName) {
			target.packageName = packageName;
			return this;
		}

		public Builder className(String className) {
			target.className = className;
			return this;
		}

		public Builder methodName(String methodName) {
			target.methodName = methodName;
			return this;
		}

		public Builder field(String field) {
			if(field == null)
				return this;
			if (target.field == null)
				target.field = field;
			target.field = target.field + "," + field;
			return this;
		}

		public Method build() {
			return target;
		}
	}

}
