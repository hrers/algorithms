package sort;


import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: zhangjianwu
 * @Date: 2021/12/2 23:10
 * @Desc:
 **/
public class OneShotLatch {

    public static void main(String[] args) {
        OneShotLatch oneShotLatch = new OneShotLatch();
        new Thread(() -> {
            try {
                oneShotLatch.await();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).start();
        new Thread(() -> {
            try {
                oneShotLatch.await();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }).start();
        new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            oneShotLatch.signal();
        }).start();
    }


    private final Sync sync = new Sync();

    public void signal(){
        sync.releaseShared(0);
    }

    public void await() throws InterruptedException {
        sync.acquireSharedInterruptibly(0);
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected int tryAcquireShared(int arg) {
            return (getState()==1)?1:-1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }
    }

}
