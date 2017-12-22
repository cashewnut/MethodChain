package com.fudanse.methodchain.persistence;

import com.fudanse.methodchain.model.Method;
import com.fudanse.methodchain.model.MethodSearch;

public interface IMethodChainDAO {

	public Method saveMethod(Method method);

	public boolean saveChain(int left, int right);
	
	public Method searchMethod(MethodSearch ms);

}
