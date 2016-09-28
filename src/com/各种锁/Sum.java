package com.各种锁;

import java.util.LinkedList;
import java.util.List;




public class Sum {
	
	/**
	 * 创建二叉树的节点
	 * @author zhuangzhewei
	 *
	 */
	 private static class Node {  
	        Node leftChild;  
	        Node rightChild;  
	        int sum;  
	        int leftfrom;
	  
	        Node(int newData) {  
	            leftChild = null;  
	            rightChild = null;  
	            sum = newData;  
	        }  
	 }  
	
	private static List<Node> nodeList= null;
	static int[] array = new int[]{6,4,16,10,16,14,2,8};
	//初始化树的长度
	static int length = array.length*2 - 1;
	
	//初始化节点为空的二叉树
	 public static void createBinarryTree() {  
		 	
		 	
		 
	        nodeList = new LinkedList<Node>();  
	        // 将一个数组的值依次转换为Node节点  
	        for (int nodeIndex = 0; nodeIndex < length; nodeIndex++) {  
	            nodeList.add(new Node(0));  
	        }  
	        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
	        for (int parentIndex = 0; parentIndex < length / 2 - 1; parentIndex++) {  
	            // 左孩子  
	            nodeList.get(parentIndex).leftChild = nodeList  
	                    .get(parentIndex * 2 + 1);  
	            // 右孩子  
	            nodeList.get(parentIndex).rightChild = nodeList  
	                    .get(parentIndex * 2 + 2);  
	        }  
	        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
	        int lastParentIndex = length / 2 - 1;  
	        // 左孩子  
	        nodeList.get(lastParentIndex).leftChild = nodeList  
	                .get(lastParentIndex * 2 + 1);  
	        // 右孩子,如果数组的长度为奇数才建立右孩子  
	        if (length % 2 == 1) {  
	            nodeList.get(lastParentIndex).rightChild = nodeList  
	                    .get(lastParentIndex * 2 + 2);  
	        }  
	    }  
	 
	 
	 
	 public static void preOrder(Node node){
			if(node==null){
				return;
			}
			System.out.print(node.sum+" ");
			preOrder(node.leftChild);
			preOrder(node.rightChild);
			
		}
	
	public static void main(String[] args) {
		
		createBinarryTree();
		//自底向上遍历二叉树,
		//完成sum的计算。
		int index = 0;
		for(int i = length/2;i<length;i++){
			nodeList.get(i).sum = array[index];
			index++;
		}
		for(int i = length/2 - 1;i>=0;i--){
			nodeList.get(i).sum = nodeList.get(i).leftChild.sum+
								  nodeList.get(i).rightChild.sum;
		}
		
		nodeList.get(0).leftfrom = 0;
		//自顶向下完成fromleft的计算
		for(int i = 1;i< length ;i++){
			int father = (int)Math.ceil((double)i/2)-1;
			if(nodeList.get(father).leftChild == null){
				nodeList.get(i).leftfrom = nodeList.get(father).leftfrom;
			}else{
				nodeList.get(i).leftfrom = nodeList.get(father).leftfrom+
										   nodeList.get(father).leftChild.sum;
			}
		}
		
	
		Node node = nodeList.get(0);
		preOrder(node);
		
		
	}
	
	
	
}
