package com.剑指offer;

import com.util.BinaryTree;
import com.util.BinaryTree.Node;

/**
 * 把二叉树打印成多行
 * 使用一个队列
 * @author Seki
 *
 */
public class PrintLevelOfBinaryTree {
	
	public void print(Node rootNode){
		if (rootNode == null) {
			return;
		}
		
	}
	
	
	public static void main(String[] args) {
		Integer[] init_array = {8,6,10,5,7,9,11};
		BinaryTree<Integer> binaryTree = new BinaryTree<>();
		binaryTree.createBinaryTree(init_array);
		Node rootNode = binaryTree.rootNode;
	}
}
