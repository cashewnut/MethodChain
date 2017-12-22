package com.fudanse.methodchain.enums;

import com.fudanse.methodchain.model.Method;
import com.fudanse.methodchain.model.MethodSearch;

public class CypherStatment {

	public static String getInsertCypher(Method method) {
		String insertCypher = "create(n:methodcall{"
				+ (method.getProjectName() == null ? "" : "projectName:'" + method.getProjectName() + "',")
				+ (method.getPackageName() == null ? "" : "packageName:'" + method.getPackageName() + "',")
				+ (method.getClassName() == null ? "" : "className:'" + method.getClassName() + "',")
				+ (method.getMethodName() == null ? "" : "methodName:'" + method.getMethodName() + "',")
				+ (method.getField() == null ? "" : "field:'" + method.getField().toString() + "'") + ")";
		return insertCypher;
	}

	public static String getInsertCypher(Integer left, Integer right) {
		return "Start a=node(" + left + "),b=node(" + right + ") create (a)-[r:call]->(b)";
	}

	public static String getSearchCypher(MethodSearch ms) {
		String cypher = "";
		return cypher;
	}

}
