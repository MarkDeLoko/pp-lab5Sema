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
				System.out.println(name + " : �������� ������ �������");
				System.out.println(name + " : �����, ��� �������� " 
								+ semaphore.availablePermits() + " �������");				
				semaphore.acquire();
				System.out.println(name + " : ����� �������");

				try {
						System.out.println(name + " : ��������� ��������" + ", �� ������ ������ �������� : "
								+ semaphore.availablePermits()  + " �������");
						Thread.sleep(10000);
					}

				finally {

					System.out.println(name + " : ����������� �������");
					semaphore.release();
					System.out.println(name + " : �����, ��� ����� ��� ����� ����� �������� " 
							+ semaphore.availablePermits() + " �������");

				}

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

	public static void main(String[] args) {

		System.out.println("��������� ������� : " 
				+ semaphore.availablePermits());
	
		MyATMThread t1 = new MyATMThread("�������");
		t1.start();

		MyATMThread t2 = new MyATMThread("���������");
		t2.start();

		MyATMThread t3 = new MyATMThread("����������");
		t3.start();

		MyATMThread t4 = new MyATMThread("�������");
		t4.start();

		MyATMThread t5 = new MyATMThread("������");
		t5.start();

		MyATMThread t6 = new MyATMThread("Ը���");
		t6.start();

		MyATMThread t7 = new MyATMThread("���������");
		t7.start();
		
		MyATMThread t8 = new MyATMThread("������");
		t8.start();
		
		MyATMThread t9 = new MyATMThread("������");
		t9.start();
		
		MyATMThread t10 = new MyATMThread("�����");
		t10.start();
	}
}