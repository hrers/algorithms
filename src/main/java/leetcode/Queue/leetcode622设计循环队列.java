package leetcode.Queue;

public class leetcode622设计循环队列 {

	public static void main(String[] args) {
		leetcode622设计循环队列 queue= new leetcode622设计循环队列(6);
		System.out.println(queue.enQueue(6));
		System.out.println(queue.Rear());
		System.out.println(queue.Rear());
		System.out.println(queue.deQueue());
		System.out.println(queue.enQueue(5));
		System.out.println(queue.Rear());
		System.out.println(queue.deQueue());
		System.out.println(queue.Front());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}

	int size;
	int queue[];
	//头尾指针
	int head=0;
	int tail=0;
	
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public leetcode622设计循环队列(int k) {
    	this.size=k;
    	this.queue=new int[k];
    }
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
    	if(tail-head<size) {
    		queue[(tail++)%size]=value;
    		return true;
    	}
    	return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(tail-head>0)
        {
        	head++;
        	return true; }
        	return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(tail-head>0)
    		return queue[head%size];
    	return -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        
    	if(tail-head>0)
    		return queue[(tail-1)%size];
    	return -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
       return head==tail ;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
    return tail-head>=size;
    }
}
