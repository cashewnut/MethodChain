package com.fudanse.methodchain.persistence;

import com.fudanse.methodchain.model.Method;

public interface IMethodChainDAO {

	public Method saveMethod(Method method);

	public boolean saveChain(int left, int right);
	
	public Method searchMethod(Method method);

}
