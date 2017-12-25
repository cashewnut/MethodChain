package com.fudanse.methodchain.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.alibaba.fastjson.JSON;
import com.fudanse.methodchain.enums.CypherStatment;
import com.fudanse.methodchain.model.Method;
import com.fudanse.methodchain.persistence.IMethodChainDAO;
import com.fudanse.methodchain.util.DBUtil;

public class MethodChainDAO implements IMethodChainDAO {

	public Method saveMethod(Method method) {
		Method returnMethod = null;
		try {
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(CypherStatment.getInsertCypher(method));
			if (rs.next()) {
				String json = rs.getString("n");
				returnMethod = JSON.parseObject(json, Method.class);
			}
			DBUtil.closeResultset(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		method = returnMethod;
		return method;
	}

	public boolean saveChain(long left, long right) {
		try {
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeQuery(CypherStatment.getInsertCypher(left, right));
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Method searchMethod(Method method) {
		Method m = null;
		try{
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(CypherStatment.getSearchCypher(method));
			if(rs.next()){
				String json = rs.getString("n");
				m = JSON.parseObject(json,Method.class);
			}
			DBUtil.closeResultset(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public boolean searchChain(long left, long right) {
		try {
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(CypherStatment.getSearchCypher(left, right));
			if (rs.next())
				return true;
			DBUtil.closeResultset(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		String json = "{'id':17388, 'labels':['methodcall'],'methodName':'<clinit>', 'className':'WorldClockActivity', 'packageName':'com.irahul.worldclock', 'projectName':'WorldClock'}";
		Method m = JSON.parseObject(json,Method.class);
		System.out.println();
	}

}
