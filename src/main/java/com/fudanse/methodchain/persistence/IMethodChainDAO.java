package com.fudanse.methodchain.persistence;

import com.fudanse.methodchain.model.Method;

public interface IMethodChainDAO {

	public Method saveMethod(Method method);

	public boolean saveChain(long left, long right);
	
	public Method searchMethod(Method method);
	
	public boolean searchChain(long left,long right);

}
