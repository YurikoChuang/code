package com.util;

import java.util.LinkedList;
import java.util.List;

import javax.xml.crypto.Data;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.各种锁.calculate_PI;

/**
 * 二叉树的相关
 * @author Seki
 * @param <T>
 * @param <T>
 * @param <T>
 *
 */
public class BinaryTree<T> {
	 public List<Node> nodeList = null;  			//用node 的链表实现二叉树
	
	 public Node rootNode = null;					//二叉树的根节点
	 
	/**
	 * 链表的结点
	 * @author Seki
	 *
	 */
	public class LinkNode{
		private String key;
		private Integer value;
		
		public LinkNode(String key , Integer value) {
			this.setKey(key);
			this.setValue(value);
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		LinkNode nextNode;
	}
	
	/**
	 * 二叉树结点
	 */
	public class Node{
	    public Node leftChild;  
	    public Node rightChild;  
	    public T data;  
		
	    public Node() 
	    {  
	    
	    }  
		public Node(Node leftChild,Node rightChild,T data)
		{
			this.leftChild = leftChild;
			this.rightChild = rightChild;
			this.data = data;
		}
		public Node(T data) {  
	        this(null,null,data);  
	    }
		
		
		
	}
	
	/**
	 * 把数组转化成二叉树   如果数组已经有序, 那么创建二叉查找树
	 * @param <T>
	 */
	public List<Node> createBinaryTree(T[] init_array)
	{
		T[] array = init_array;  	//要放进二叉树的数组  序号从0开始
		
		nodeList = new LinkedList<Node>();
		// 将一个数组的值依次转换为Node节点  
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new Node(array[nodeIndex]));
		}
		
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1 ; parentIndex++) {
			//左孩子
			nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);
			//右孩子
			nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2 );
		}
		
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理 
		
		int  lastParent = array.length / 2 - 1;
		//左孩子
		nodeList.get(lastParent).leftChild = nodeList.get(lastParent * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子  
        if (array.length % 2 == 1) {  
        	nodeList.get(lastParent).rightChild = nodeList.get(lastParent * 2 + 2);
        }
        
        rootNode = nodeList.get(0);
		return nodeList;
	}
	
    
    
	/**
	 * 先序遍历  输入头结点
	 * @param <T>
	 * @param node
	 */
    public void preOrderTraverse(Node node)
    {
    	//System.out.println("先序遍历");
    	if(node == null)
    		return;
    	System.out.println(node.data);
    	preOrderTraverse(node.leftChild);
    	preOrderTraverse(node.rightChild);
    }
    
    /** 
     * 中序遍历 
     * @param <T>
     */  
    public void inOrderTraverse(Node node) {  
        if (node == null)  
            return;  
        inOrderTraverse(node.leftChild);  
        System.out.print(node.data + " ");  
        inOrderTraverse(node.rightChild);  
    }  
    
    /** 
     * 后序遍历 
     * @param <T>
     */  
    public void postOrderTraverse(Node node) {  
        if (node == null)  
            return;  
        postOrderTraverse(node.leftChild);  
        postOrderTraverse(node.rightChild);  
        System.out.print(node.data + " ");  
    }  
    

    /**
     *  交换 两个 Node 的data值
     * @param node1
     * @param node2
     */
    //java是值传递, 不能直接交换int, integer也不行   必须封装成类
    public void swap(Node node1 , Node node2)
    {
    	//中间变量不能是Node类型  值传递
    	T temp = node1.data;
    	node1.data = node2.data;
    	node2.data = temp;
    	System.out.println("temp" + temp);
    	System.out.println("node2" + node2.data);
    } 
    
    /**
     * 获取二叉查找树的最小值
     * @param <T>
     * @param node
     * @return
     */
    public Node findMin(Node node)  
    {  
       if(node == null)  
       {  
           System.out.println("二叉树为空");  
           return null;  
       }
       else if (node.leftChild == null) {
		return node;
       }
       return node.leftChild;    
    }  
    
    public void insertNode(T insertData , Node node)
    {

    }
    

}
