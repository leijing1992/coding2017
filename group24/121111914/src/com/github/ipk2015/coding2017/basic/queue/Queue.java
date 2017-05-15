<<<<<<< HEAD:group24/121111914/src/com/github/ipk2015/coding2017/basic/Queue.java
package com.github.ipk2015.coding2017.basic;

import com.github.ipk2015.coding2017.basic.linkedlist.LinkedList;

public class Queue {
	private LinkedList elementDatas=new LinkedList();
	public void enQueue(Object o){		
		elementDatas.add(o);
	}
	public Object deQueue(){
		return elementDatas.removeFirst();
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public int size(){
		return elementDatas.size();
	}
}
=======
package com.github.ipk2015.coding2017.basic.queue;

import com.github.ipk2015.coding2017.basic.linkedlist.LinkedList;

public class Queue {
	private LinkedList elementDatas=new LinkedList();
	public void enQueue(Object o){		
		elementDatas.add(o);
	}
	public Object deQueue(){
		return elementDatas.removeFirst();
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public int size(){
		return elementDatas.size();
	}
}
>>>>>>> 457e0567c06deded14d510f237f4448f4b840dd0:group24/121111914/src/com/github/ipk2015/coding2017/basic/queue/Queue.java
