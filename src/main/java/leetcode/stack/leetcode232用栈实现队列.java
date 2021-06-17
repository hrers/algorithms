package leetcode.stack;

import java.util.Stack;

class MyQueue {
	
	public static void main(String[] args) {
		MyQueue queue= new MyQueue();
		
	}
	Stack<Integer> stack=new Stack<Integer>();
    /** Initialize your data structure here. */
    public MyQueue() {
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	this.stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	Stack<Integer> temp = new Stack<>();
    	while(stack.size()>=2) {
    		temp.push(stack.pop());
    	}
    	int res=stack.pop();
    	while(temp.size()>=1){
    		stack.push(temp.pop());
    	}
      return res;
    }
    
    /** Get the front element. */
    public int peek() {
    	Stack<Integer> temp = new Stack<>();
    	while(stack.size()>=1) {
    		temp.push(stack.pop());
    	}
    	int res=temp.peek();
        while(temp.size()>=1) {
        	stack.push(temp.pop());
        }
        return res;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(this.stack.size()>=1)
        	return false;
        else
        	return true;
    	
    }
}