package com.coding.basic.stack.expr;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPostfix {
	
	public static List<Token> convert(String expr) {
		if(expr == null)
			throw new RuntimeException("表达式为空...");
		List<Token> list = new TokenParser().parse(expr);
		List<Token> result = new ArrayList<Token>();
		Stack<Token> stack = new Stack<Token>();
		
		for(int i=0; i<list.size(); i++){
			Token token = list.get(i);
			
			if(token.isNumber()){
				result.add(token);
			}
			
			if(token.isOperator() && token.value.equals(")")){
				while(!stack.peek().value.equals("(")) {
					result.add(stack.pop());
				}
				stack.pop();
			}else{
				if(stack.size() == 0){
					stack.push(token);
				}else{
					while(token.hasHigherPriority(stack.peek())){
						result.add(stack.pop());
						if(stack.size() == 0)
							break;
					}
				}
			}
		}
		
		return result;
	}
	
	

}
