package com.scudata.expression.fn.math;

import com.scudata.common.MessageManager;
import com.scudata.common.RQException;
import com.scudata.dm.Context;
import com.scudata.expression.Function;
import com.scudata.resources.EngineMessage;
import com.scudata.util.Variant;

/**
 * ����ĳһ���ֵ�˫������ֵcosh(z)=(e^z+e^(-z))/2
 * @author yanjing
 *
 */
public class Cosh	extends Function {

	public Object calculate(Context ctx) {
		if (param == null || !param.isLeaf()) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("cosh" + mm.getMessage("function.invalidParam"));
		}
		Object result1 = param.getLeafExpression().calculate(ctx);
		if (result1 == null) {
			return result1;
		}
		if (! (result1 instanceof Number)) {
			MessageManager mm = EngineMessage.get();
			throw new RQException("cosh" + mm.getMessage("function.paramTypeError"));
		}
		double z=Variant.doubleValue(result1);
		return new Double(Math.cosh(z));
	}

}
