package com.jaffar.practice.datastructure;

public class Stack<T> {

	private StackNode<T> stack;
	private int size;
	
	public void push(T data){
		if(isEmpty()){
			stack = new StackNode<T>(data);
		}else{
			stack = new StackNode<T>(data,stack);
		}
		size++;
	}
	
	public T pop(){
		T data = null;
		if(!isEmpty()){
			data = stack.data;
			stack = stack.bottomNode;
			size--;
		}
		return data;
	}
	
	public boolean isEmpty(){
		return size()==0;
	}
	
	public int size(){
		return size;
	}
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("Qasim");
		stack.push("Farwah");
		stack.push("Nina");
		stack.push("Jaffar");
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
	}
}

class StackNode<T>{
	
	T data;
	StackNode<T> bottomNode;
	
	public StackNode(T data){
		this(data,null);
	}

	public StackNode(T data, StackNode<T> bottomNode){
		this.data = data;
		this.bottomNode = bottomNode;
	}
	
	
}