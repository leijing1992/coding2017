package com.coding.basic.queue;

import java.util.ArrayList;
import java.util.List;


/**
 * 用Queue来实现Josephus问题
 * 在这个古老的问题当中， N个深陷绝境的人一致同意用这种方式减少生存人数：  N个人围成一圈（位置记为0到N-1）， 
 * 并且从第一个人报数， 报到M的人会被杀死， 直到最后一个人留下来
 * 该方法返回一个List， 包含了被杀死人的次序
 * @author liuxin
 *
 */

/**
 * 思路：表面上看是报到M的人被杀死，其实是每报到M就要重新开始报数，所以第一个被杀死的必然是第M个人，第二个被杀死的必然是第2M个人，以此类推，只要取
 * 一个变量i,让i一直递增，只要i是M的倍数，则该人就被杀死；没有被杀死的人就重新入队列等待计数，直到队列为空为止，则所有人都被杀死
 * @author Administrator
 *
 */
public class Josephus {
	 
	public static List<Integer> execute(int n, int m){	
		if(n<0 || m<0)
			throw new RuntimeException("参数必须大于零...");
		if(n < m)
			throw new RuntimeException("n 必须大于m...");
		
		List<Integer> list = new ArrayList<Integer>();
		Queue<Integer> queue = new Queue<Integer>();
		
		for(int i=0; i<n; i++){
			queue.enQueue(i);
		}
		
		int i = 0;//表示第几个人报数，会一直递增的
		while(!queue.isEmpty()){
			int tmp = queue.deQueue();
			if((i+1)%m != 0){
				queue.enQueue(tmp);
				i++;
			}else{
				list.add(tmp);
				i++;
			}
		}
		
		return list;
	}
	
}
