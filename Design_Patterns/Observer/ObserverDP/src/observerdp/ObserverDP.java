/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdp;
import observerdp.observers.Observer;
import observerdp.observers.Subscriber1;
import observerdp.observers.Subscriber2;
/**
 *
 * @author kalpesh
 */
public class ObserverDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /* News Publisher */
		Subject publisher = new Publisher();
		
		/* registering observers */
		Observer subscriber1 = new Subscriber1();
		publisher.registerObserver(subscriber1);
		
		Observer subscriber2 = new Subscriber2();
		publisher.registerObserver(subscriber2);
		
		/* Notify observers */
		publisher.notifyObservers();
		
		/* Delete observers */
		publisher.removeObserver(subscriber2);
		
		/* Notify observers */
		publisher.notifyObservers();
        
    }
    
}
