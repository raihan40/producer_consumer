package Producer_Consumer;
import java.util.*;

public class producer extends Thread {
circuler_queue buff;
	public producer(circuler_queue buff) {
		// TODO Auto-generated constructor stub
		this.buff = buff;
	}
 public void run() {
	while(true) {
		try {
			buff.produce();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	 try {
			Thread.sleep(1000);
	 	 } 
	 catch (InterruptedException e) {
		// TODO Auto-generated catch block
		 	e.printStackTrace();
	 		}
	 }
 }
 
 
 }

