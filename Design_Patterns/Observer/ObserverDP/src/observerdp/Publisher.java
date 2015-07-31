/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdp;
import observerdp.observers.Observer;
import java.util.ArrayList;
import java.util.List;
import observerdp.Subject;
import observerdp.Subject;
import observerdp.observers.Observer;
/**
 *
 * @author kalpesh
 */
public class Publisher implements Subject {

	private List<Observer> _observers = new ArrayList<Observer>();

	@Override
	public void registerObserver(Observer observer) {
		System.out.println("Registered observer");		
		_observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		System.out.println("Deregister observer");
		_observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		
		for (Observer observer : _observers) {
			observer.update("Weekly Edition");
		}
	}
}
