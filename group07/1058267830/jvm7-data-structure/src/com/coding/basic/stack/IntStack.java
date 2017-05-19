package com.coding.basic.stack;

import java.util.ArrayList;
import java.util.List;


public class IntStack{
	private List<Integer> list = new ArrayList<Integer>();
	private Integer minElement;
	
	public void push(Integer o){		
		if(list.size() == 0){
			minElement = o;
		}else{
			if(o < minElement){
				minElement = o;
			}
		}
		
		list.add(o);
		
	}
	
	public Integer pop(){
		if(list.size() == 0)
			return null;
		Integer result = list.get(0);
		list.remove(0);
		if(minElement.equals(result)){// minElement被pop出去了，要重新选出最小值
			minElement = list.get(0);
			for(int i=1;i<list.size(); i++){
				if(list.get(i) < minElement)
					minElement = list.get(i);
			}
		}
		return result;
	}

	public Integer peek(){
		if(list.size() == 0)
			return null;
		return list.get(0);
	}
	public boolean isEmpty(){
		return list.size() == 0;
	}
	public int size(){
		return list.size();
	}
	
	public Integer findMinElement(){
		return minElement;
	}

}
