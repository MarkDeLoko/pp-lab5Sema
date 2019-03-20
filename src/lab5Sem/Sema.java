package lab5Sem;

import java.util.concurrent.Semaphore;

public class Sema {

	static Semaphore semaphore = new Semaphore(5);

	static class MyATMThread extends Thread {

		String name = "";
		MyATMThread(String name) {
			this.name = name;
		}

		public void run() {

			try {	
				System.out.println(name + " : Пытается занять кабинку");
				System.out.println(name + " : Узнал, что доступно " 
								+ semaphore.availablePermits() + " кабинок");				
				semaphore.acquire();
				System.out.println(name + " : Занял кабинку");

				try {
						System.out.println(name + " : Выполняет операцию" + ", на данный момент доступно : "
								+ semaphore.availablePermits()  + " кабинок");
						Thread.sleep(10000);
					}

				finally {

					System.out.println(name + " : Освобождает кабинку");
					semaphore.release();
					System.out.println(name + " : Узнал, что после его ухода стало доступно " 
							+ semaphore.availablePermits() + " кабинок");

				}

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

	public static void main(String[] args) {

		System.out.println("Доступные кабинки : " 
				+ semaphore.availablePermits());
	
		MyATMThread t1 = new MyATMThread("Наталья");
		t1.start();

		MyATMThread t2 = new MyATMThread("Александр");
		t2.start();

		MyATMThread t3 = new MyATMThread("Варфаламей");
		t3.start();

		MyATMThread t4 = new MyATMThread("Дмитрий");
		t4.start();

		MyATMThread t5 = new MyATMThread("Денчик");
		t5.start();

		MyATMThread t6 = new MyATMThread("Фёдор");
		t6.start();

		MyATMThread t7 = new MyATMThread("Екатерина");
		t7.start();
		
		MyATMThread t8 = new MyATMThread("Адольф");
		t8.start();
		
		MyATMThread t9 = new MyATMThread("Максим");
		t9.start();
		
		MyATMThread t10 = new MyATMThread("Елена");
		t10.start();
	}
}