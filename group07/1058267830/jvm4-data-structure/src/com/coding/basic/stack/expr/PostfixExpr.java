package com.coding.basic.stack.expr;

import java.util.List;
import java.util.Stack;

public class PostfixExpr {
	String expr = null;
	TokenParser tokenParser = new TokenParser();
	public PostfixExpr(String expr) {
		this.expr = expr;
	}

	public float evaluate() {
		List<Token> list = tokenParser.parse(expr);
		if(list == null)
			throw new RuntimeException("input error...");
		
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0 ;i<list.size(); i++){
			if(list.get(i).isNumber()){
				stack.push(list.get(i).getIntValue());
			}else{
				Token token = list.get(i);
				int a1 = stack.pop();
				int a2 = stack.pop();
				int res = operate(a1, a2, token);
				stack.push(res);
			}
		}
		return stack.peek();
		
	}
	
	private int operate(int a1, int a2, Token token) {
		String s = token.toString();
		if(s.equals("+"))
			return a1 + a2;
		else if(s.equals("-"))
			return a1 - a2;
		else if(s.equals("*"))
			return a1 * a2;
		else if(s.equals("/"))
			return a1/a2;
		else
			throw new RuntimeException("解析符号错误...");
	}
	
	
}
