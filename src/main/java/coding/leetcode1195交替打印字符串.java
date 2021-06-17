package coding;

import java.util.function.IntConsumer;

public class leetcode1195交替打印字符串 {
	private int n;
	private int i=1;
	Object lock=new Object();

	public leetcode1195交替打印字符串(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {

		synchronized (lock) {
			while(n%3!=0&&i<=n) {
				lock.wait();
			}
			printFizz.run() ;
			i++;
			lock.notifyAll();
		}
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		synchronized (lock) {
			while(n%5!=0&&i<=n) {
				lock.wait();
			}
			printBuzz.run() ;
			i++;
			lock.notifyAll();
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		synchronized (lock) {
			while(!(n%5==0&&n%3==0)&&i<=n) {
				lock.wait();
			}
			printFizzBuzz.run() ;
			i++;
			lock.notifyAll();
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		if(i<=n)
			printNumber.accept(i++);
		lock.notifyAll();
	}

}
