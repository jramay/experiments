package com.jaffar.practice.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

	TreeNode<T> rootNode;
	
	public BinaryTree(){
		
	}
	
	public BinaryTree(T data){
		rootNode.setData(data); 
	}
	
	public boolean isEmpty(){
        return rootNode == null;
    }
	
	public void insert(T data)
    {
        rootNode = insert(rootNode, data);
    }
	
	private TreeNode<T> insert(TreeNode<T> node, T data){
        if (node == null)
            node = new TreeNode<T>(null,data,null);
        else
        {
            if (node.getRightNode() == null)
                node.rightNode = insert(node.rightNode, data);
            else
                node.leftNode = insert(node.leftNode, data);             
        }
        return node;
    }
	
	public int size(){
        return size(rootNode);
    }
    
    private int size(TreeNode<T> rootNode){
        if (rootNode == null)
            return 0;
        else
        {
            int l = 1;
            l += size(rootNode.getLeftNode());
            l += size(rootNode.getRightNode());
            return l;
        }
    }
	
    public void printTree(){
    	BTreePrinter.printNode(rootNode);
    }
    
	public static void main(String[] args) {
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		binaryTree.insert(1);
		binaryTree.insert(2);
		binaryTree.insert(3);
		binaryTree.insert(4);
		binaryTree.insert(4);
		binaryTree.insert(5);
		binaryTree.printTree();
		System.out.println("Size "+binaryTree.size());
	}
}

class TreeNode<T extends Comparable<T>>{
	
	TreeNode<T> leftNode;
	T data;
	TreeNode<T> rightNode;
	
	public TreeNode(TreeNode<T> leftNode, T data, TreeNode<T> rightNode){
		
		this.leftNode = leftNode;
		this.data = data;
		this.rightNode = rightNode;
		
	}

	public TreeNode<T> getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(TreeNode<T> leftNode) {
		this.leftNode = leftNode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public TreeNode<T> getRightNode() {
		return rightNode;
	}

	public void setRightNode(TreeNode<T> rightNode) {
		this.rightNode = rightNode;
	}
	
}

class BTreePrinter {

    public static <T extends Comparable<T>> void printNode(TreeNode<T> rootNode) {
        int maxLevel = BTreePrinter.maxLevel(rootNode);

        printNodeInternal(Collections.singletonList(rootNode), 1, maxLevel);
    }

    private static <T extends Comparable<T>> void printNodeInternal(List<TreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
        for (TreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.leftNode);
                newNodes.add(node.rightNode);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).leftNode != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).rightNode != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<T>> int maxLevel(TreeNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.leftNode), BTreePrinter.maxLevel(node.rightNode)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}