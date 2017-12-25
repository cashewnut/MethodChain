package com.fudanse.methodchain.service;

import com.fudanse.methodchain.model.Method;

public interface IMethodChainService {
	
	public Method saveMethod(Method method);
	
	public boolean saveChain(long left, long right);
	
}
