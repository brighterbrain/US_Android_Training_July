/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdp.observers;

/**
 *
 * @author kalpesh
 */
public class Subscriber2 implements Observer {

	@Override
	public void update(String  edition) {
		System.out.println("New Edition from Subscriber2");
	}
}