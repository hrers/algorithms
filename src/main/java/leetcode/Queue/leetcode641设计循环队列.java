package leetcode.Queue;

import java.util.ArrayList;
class Note{
	int val;
	Note next;
	Note pre;
	public Note(int val) {this.val=val;}
}
/**
 * 用链表实现循环队列
 * 也可以用循环数组实现（下标取余就可以得到循环队列）head=（head+1）%data.length
 * @author 张建武
 *
 */
class leetcode641设计循环队列 {
	int size;
	int count=0;
      static Note head = new Note(-1);
      static Note tail= new Note(-1);
      public static void main(String[] args) {
    	  leetcode641设计循环队列 myc = new leetcode641设计循环队列(5);
    	  System.out.println(myc.insertFront(1));
    	  System.out.println(  myc.getFront());
    	  System.out.println(  myc.isEmpty());
    	  System.out.println( myc.deleteFront());
    	  System.out.println(  myc.insertLast(23));
    	  System.out.println(	  myc.getRear());
    	  System.out.println(  myc.insertLast(23));
    	  System.out.println( myc.deleteLast() );
    	  System.out.println(  myc.insertLast(2));
    	  System.out.println(  	myc.isEmpty());
      }

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public leetcode641设计循环队列(int k) {
        this.size=k;
          }
	/** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
    	if(count==0) {
    	Note note = new Note(value);	
    	head.next=note;
    	note.pre=null;
    	tail.pre=note;
    	note.next=null;
    	count++;
    	return true;
    	}else {
    		if(count>=size)
    			return false;
    		Note note = new Note(value);
    		note.next=head.next;
    		head.next.pre=note;
    		head.next=note;
    		count++;
    		return true;
    	}
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if(count==0) {
    		Note note = new Note(value);
    		head.next=note;
    		tail.pre=note;
    		count++;
    		return true;
    	}else {
    		if(count>=size)
    			return false;
    		Note note = new Note(value);
//    		note.next=tail.pre;
    		tail.pre.next=note;
    		note.pre=tail.pre;
    		tail.pre=note;
    		count++;
    		return true;
    	}
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
    	if(count>1) {
    		head.next=head.next.next;
    		count--;
    		return true;
    	}else if(count>0) {
    		head.next=tail;
    		count--;
    		return true;
    	}else
    		return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
       if(count>1) {
    	   tail.pre=tail.pre.pre;
    	   count--;
    	   return true;
       }else if(count>0) {
   		head.next=tail;
   		count--;
   		return true;
   	}else
    	   return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
    	if(count>0) {
    		return head.next.val;
    	}else
    		return -1;
        
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    	if(count>0)
    		return tail.pre.val;
    	else
    		return -1;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
    	if(count==0)
    		return true;
    	else
    		return false;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
    	if(count==size)
    		return true;
    	else
    		return false;
    }
}

/**
 * Your leetcode641设计循环队列 object will be instantiated and called as such:
 * leetcode641设计循环队列 obj = new leetcode641设计循环队列(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */