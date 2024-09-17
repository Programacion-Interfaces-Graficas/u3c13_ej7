package u3c13_ej7;

//This program is not synchronized.
class mensaje{
	public void imprimir(String msg) {
		System.out.print("["+msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("]");
	}
}
class proceso implements Runnable{
	String msg;
	mensaje target;
	Thread hilo;
	public proceso(mensaje target, String msg) {
		super();
		this.target = target;
		this.msg = msg;
		hilo=new Thread(this);
	}
	public void run() {
		target.imprimir(msg);
	}
	
}
class ejemplo7 {
	public static void main(String[] args) {
		
		mensaje msg=new mensaje();
		proceso hilo1=new proceso(msg,"Hola");
		proceso hilo2=new proceso(msg,"Sincronizado");
		proceso hilo3=new proceso(msg,"Mundo");
		hilo1.hilo.start();
		hilo2.hilo.start();
		hilo3.hilo.start();
		try {
			hilo1.hilo.join();
			hilo2.hilo.join();
			hilo3.hilo.join();
		} catch(InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
}
