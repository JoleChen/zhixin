package cn.theblueearth.zhixin.thread;

public class ObjectSynchronized {

	public static void main(String[] args) {
		ObjectSynchronized objectSynchronized = new ObjectSynchronized();
		Object printObjectA = new Object();
		Object printObjectB = new Object();
		System.out.println("Print Start0..."+Thread.currentThread());
		new Thread(objectSynchronized.new PrintA(printObjectA,printObjectB)).start();
		System.out.println("Print Start1..."+Thread.currentThread());
		new Thread(objectSynchronized.new PrintB(printObjectA,printObjectB)).start();
		System.out.println("Print Start2..."+Thread.currentThread());
	}
	
	class PrintA implements Runnable{
		private Object objectA = null;
		private Object objectB = null;
		public PrintA(Object printObjectA,Object printObjectB){
			objectA = printObjectA;
			objectB = printObjectB;
		}
		public void run() {
			System.out.println("PrintA Start..."+Thread.currentThread());
			for(int i=1;i<4;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("PrintA:"+i);
			}
		}
	}
	
	class PrintB implements Runnable{
		private Object objectA = null;
		private Object objectB = null;
		public PrintB(Object printObjectA,Object printObjectB){
			objectA = printObjectA;
			objectB = printObjectB;
		}
		public void run() {
			try {
				synchronized(objectB){
					objectB.wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("PrintB Start..."+Thread.currentThread());
			for(int i=4;i<7;i++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("PrintB:"+i);
			}
			
			synchronized(objectA){
				objectA.notify();
			}
		}
		
	}
}
