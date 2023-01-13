package Producer_Consumer;


public class demo {
	public static void main(String[] args) throws InterruptedException {
		 circuler_queue buff = new circuler_queue();
		// TODO Auto-generated method stub
		producer p = new producer(buff);
		consumer c = new consumer(buff);
		c.start();
		p.start();
      }

}
