package cc.com.java8.funtionalprogramming.examples;

public class FP_02_Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//Implementation of Runnable in structural programming		
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					System.out.println(Thread.currentThread().getId() + ":" + i);

				}

			}

		};

//Implementation of Runnable in functional programming		

		Runnable runnable2 = () -> {
			for (int i = 0; i < 10000; i++) {
				System.out.println(Thread.currentThread().getId() + ":" + i);

			}
		};

// start thread
		Thread thread = new Thread(runnable2);
		thread.start();

		Thread thread1 = new Thread(runnable2);
		thread1.start();

		Thread thread2 = new Thread(runnable2);
		thread2.start();
		
	}

}
