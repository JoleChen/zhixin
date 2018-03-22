package cn.theblueearth.zhixin.thread;

public class ObjectSynchronized2 {
	private Object objectA = new Object();
	private Object objectB = new Object();

	public static void main(String[] args) {
		ObjectSynchronized2 objectSynchronized = new ObjectSynchronized2();
		
		System.out.println("Print Start0..."+Thread.currentThread());
		new Thread(objectSynchronized.new PrintA()).start();
		System.out.println("Print Start1..."+Thread.currentThread());
		new Thread(objectSynchronized.new PrintB()).start();
		System.out.println("Print Start2..."+Thread.currentThread());
	}
	
	private void ThreadSleep(){
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	class PrintA implements Runnable{
		public void run() {
			System.out.println("PrintA Start..."+Thread.currentThread());
			for(int i=1;i<4;i++){
				ThreadSleep();
				System.out.println("PrintA:"+i);
			}
			
			try {
				synchronized(objectA){
					synchronized(objectB){
						objectB.notify();
					}
					objectA.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("PrintA reStart..."+Thread.currentThread());
			for(int i=7;i<10;i++){
				ThreadSleep();
				System.out.println("PrintA:"+i);
			}
		}
	}
	
	class PrintB implements Runnable{
		public void run() {
//			try {
//				synchronized(objectB){
//					objectB.wait();
//				}
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			System.out.println("PrintB Start..."+Thread.currentThread());
			for(int i=4;i<7;i++){
				ThreadSleep();
				System.out.println("PrintB:"+i);
			}
			
			synchronized(objectA){
				objectA.notify();
			}
		}
		
	}
}
