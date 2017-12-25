package com.fudanse.methodchain.service.impl;

import com.fudanse.methodchain.model.Method;
import com.fudanse.methodchain.persistence.IMethodChainDAO;
import com.fudanse.methodchain.persistence.impl.MethodChainDAO;
import com.fudanse.methodchain.service.IMethodChainService;

public class MethodChainService implements IMethodChainService {

	IMethodChainDAO mcDAO = new MethodChainDAO();

	@Override
	public Method saveMethod(Method method) {
		Method sm = mcDAO.searchMethod(method);
		if (sm == null)
			return mcDAO.saveMethod(method);
		else
			return sm;
	}

	@Override
	public boolean saveChain(long left, long right) {			
		if (!mcDAO.searchChain(left, right))
			mcDAO.saveChain(left, right);
		return true;
	}

}
