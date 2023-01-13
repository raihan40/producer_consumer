package Producer_Consumer;
import java.util.*;
public class circuler_queue {
	int buff[];
	int f = -1 ,r = -1;
	Random rand = new Random();
	public circuler_queue() {
		buff = new int[5];
	}
	boolean is_Full() {
		if(f == 0 && r == 4) {
		   return true;
		}
		if (f == r + 1) {
			return true;
	    }
		return false;
	}
	 boolean isEmpty() {
		    if (f == -1)
		      return true;
		    else
		      return false;
		  }
	 synchronized void produce() throws InterruptedException {
		    if (is_Full()) {
		      System.out.println("Buffer is full! Consumer please consumed....");
		      this.wait();  
		      System.out.println("Producer resumed....");
		    } 
		    else {
		      if (f == -1)
		           f = 0;
		      r = (r + 1) % 5;
		      buff[r] = rand.nextInt(1000);;
		      System.out.println("Producer produced "+buff[r]);
		    }
		    this.notify();
		  }
	 synchronized void consume() throws InterruptedException {
		  if (isEmpty()) {
		      System.out.println("Buffer is empty! Producer please produce....");
		      this.wait();
		      System.out.println("Consumer resumed....");
		    } 
		     else {
		      int element = buff[f];
		      System.out.println("consumer consumed "+buff[f]);
		      if (f == r) {
		        f = -1;
		        r = -1;
		      } /* Q has only one element, so we reset the queue after deleting it. */
		      else {
		        f = (f + 1) % 5;
		      }
		      
		    }
		   this.notify();
		  }
}
