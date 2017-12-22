package com.fudanse.methodchain.persistence.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.alibaba.fastjson.JSON;
import com.fudanse.methodchain.enums.CypherStatment;
import com.fudanse.methodchain.model.Method;
import com.fudanse.methodchain.model.MethodSearch;
import com.fudanse.methodchain.persistence.IMethodChainDAO;
import com.fudanse.methodchain.util.DBUtil;

public class MethodChainDAO implements IMethodChainDAO {

	public Method saveMethod(Method method) {
		Method returnMethod = null;
		try {
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(CypherStatment.getInsertCypher(method));
			if (rs.next())
				returnMethod = JSON.parseObject(rs.getString("n"), Method.class);
			DBUtil.closeResultset(rs);
			DBUtil.closeStatement(stmt);
			DBUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		method = returnMethod;
		return method;
	}

	public boolean saveChain(int left, int right) {
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
	public Method searchMethod(MethodSearch ms) {
		Method method = null;
		try{
			Connection con = DBUtil.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(CypherStatment.getSearchCypher(ms));
			if(rs.next()){
				method = JSON.parseObject(rs.getString("n"),Method.class);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return method;
	}

}
