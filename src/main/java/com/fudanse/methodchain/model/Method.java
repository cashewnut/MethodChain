package com.fudanse.methodchain.model;

import java.util.ArrayList;
import java.util.List;

public class Method {

	private Integer id;

	private List<String> label = new ArrayList<String>();

	private String projectName;

	private String packageName;

	private String className;

	private String methodName;

	private List<String> field = new ArrayList<String>();
	
	private Method(){
		
	}

	private Method(Method origin) {
		this.id = origin.id;
		this.projectName = origin.projectName;
		this.packageName = origin.packageName;
		this.className = origin.className;
		this.methodName = origin.methodName;
		this.field = origin.field;
	}

	public Integer getId() {
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

	public List<String> getField() {
		return field;
	}
	
	/*public String fieldString(){
		if(field.isEmpty())
			return null;
		String fieldString = field.stream().map((field)->field).reduce((sum,field)->sum + "," + field).get();
		return fieldString;
	}*/

	public static class Builder {

		private Method target;
		
		public Builder(){
			target = new Method();
		}

		public Builder label(String label) {
			target.label.add(label);
			return this;
		}

		public Builder label(List<String> labels) {
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
			target.field.add(field);
			return this;
		}

		public Builder field(List<String> fields) {
			target.field.addAll(fields);
			return this;
		}

		public Method build() {
			return target;
		}
	}
	
	

}
