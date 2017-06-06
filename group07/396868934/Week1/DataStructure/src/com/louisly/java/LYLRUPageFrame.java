package com.louisly.java;
import java.util.ArrayList;
import java.lang.String;

public class LYLRUPageFrame {
	
	LYLRUPageFrameNode firstNode;
	LYLRUPageFrameNode lastNode;
	int capacity;
	int size = 0;
	
	public LYLRUPageFrame(int capacity) {
		this.capacity = capacity;
	}
	
	public void access(int value) {
		LYLRUPageFrameNode newNode = new LYLRUPageFrameNode(value);
		if (firstNode == null) {
			firstNode = newNode;
			lastNode = newNode;
		} else {
			LYLRUPageFrameNode node = firstNode;
			while (node != null) {
				if (node.value == value) {
					LYLRUPageFrameNode preNode = node.preNode;
					LYLRUPageFrameNode nextNode = node.nextNode;
					if (preNode == null) {
						if (nextNode == null) {
							firstNode = null;
							lastNode = null;
						} else {
							firstNode = nextNode;
							nextNode.preNode = null;
						}
						
					} else {
						if (nextNode == null) {
							preNode.nextNode = null;
							lastNode = preNode;
						} else {
							preNode.nextNode = nextNode;
							nextNode.preNode = preNode;
						}
					}
					
					node.preNode = null;
					node.nextNode = null;
					node = null;
					size--;
					break;
				}
				node = node.nextNode;
			}
			
			if (size == capacity) {
				LYLRUPageFrameNode currentFirstNode = firstNode;

				firstNode = firstNode.nextNode;
				firstNode.preNode = null;
				
				currentFirstNode.nextNode = null;
				currentFirstNode = null;
				size--;
			}
			
			newNode.preNode = lastNode;
			lastNode.nextNode = newNode;
			lastNode = newNode;
		}
		
		size++;
	}
	
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		LYLRUPageFrameNode node = lastNode;
		while (node != null) {
			buffer.append(node.value);
			node = node.preNode;
			if (node != null) {
				buffer.append(",");
			}
		}
		return buffer.toString();
	}
	
	private class LYLRUPageFrameNode {
		int value;
		LYLRUPageFrameNode preNode;
		LYLRUPageFrameNode nextNode;
		public LYLRUPageFrameNode(int value) {
			this.value = value;
		}
	}
}
