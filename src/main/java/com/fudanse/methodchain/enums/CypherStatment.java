package com.fudanse.methodchain.enums;

import com.fudanse.methodchain.model.Method;

public class CypherStatment {

	public static String getInsertCypher(Method method) {
		String insertCypher = "create(n:methodcall{"
				+ (method.getProjectName() == null ? "" : "projectName:'" + method.getProjectName() + "',")
				+ (method.getPackageName() == null ? "" : "packageName:'" + method.getPackageName() + "',")
				+ (method.getClassName() == null ? "" : "className:'" + method.getClassName() + "',")
				+ (method.getMethodName() == null ? "" : "methodName:'" + method.getMethodName() + "',")
				+ (method.getField() == null ? "" : "field:'" + method.getField().toString() + "'") + "}) return n";
		if (insertCypher.endsWith(",}) return n"))
			insertCypher = insertCypher.substring(0, insertCypher.length() - 12) + "}) return n";
		return insertCypher;
	}

	public static String getInsertCypher(long left, long right) {
		return "Start a=node(" + left + "),b=node(" + right + ") create (a)-[r:call]->(b)";
	}

	public static String getSearchCypher(Method method) {

		String cypher = "match(n:methodcall) where "
				+ (method.getProjectName() == null ? "" : "n.projectName='" + method.getProjectName() + "' AND ")
				+ (method.getPackageName() == null ? "" : "n.packageName='" + method.getPackageName() + "' AND ")
				+ (method.getClassName() == null ? "" : "n.className='" + method.getClassName() + "' AND ")
				+ (method.getMethodName() == null ? "" : "n.methodName='" + method.getMethodName() + "' AND ")
				+ (method.getField() == null ? "" : "n.field='" + method.getField() + "'") + "return n";
		if (cypher.endsWith("AND return n")) {
			cypher = cypher.substring(0, cypher.length() - 12) + "return n";
		}
		return cypher;
	}

	public static String getSearchCypher(long left, long right) {
		String cypher = "Start a=node(" + left + "),b=node(" + right + ") match(a)-[r:call]->(b) return r";
		return cypher;
	}

}
