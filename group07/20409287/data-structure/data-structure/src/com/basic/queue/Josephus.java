package com.basic.queue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 用Queue来实现Josephus问题
 * 在这个古老的问题当中， N个深陷绝境的人一致同意用这种方式减少生存人数：
 * N个人围成一圈（位置记为0到N-1）， 并且从第一个人报数， 报到M的人会被杀死， 直到最后一个人留下来
 * 该方法返回一个List， 包含了被杀死人的次序
 * @author liuxin
 *
 */
public class Josephus {

	private static Node head;

	private static Node tail;

	private static class Node {

		private Object data; // 数据域

		private Node next;  // 指针域

		public Node() {
		}

		private Node(Object data) {
			this.data = data;
			this.next = null;
		}

	}

	public static void add(Object e) {

		if (head == null) {
			tail = head = new Node(e);
			head.next = tail;
		} else {
			tail.next = new Node(e);
			tail = tail.next;
			tail.next = head;
		}
	}

	public static List<Object> execute(int n, int m){

		for (int i = 0; i < n; i++) {
			add(i);
		}

		Node kill = tail;
		List<Object> killedList = new ArrayList<>();
		Node pre = kill;

		while (n-- > 0) {
			for (int i = 0; i < m; i++) {
				pre = kill;
				kill = kill.next;
			}
			pre.next = kill.next;
			killedList.add(kill.data);
		}

		return killedList;

	}

}
