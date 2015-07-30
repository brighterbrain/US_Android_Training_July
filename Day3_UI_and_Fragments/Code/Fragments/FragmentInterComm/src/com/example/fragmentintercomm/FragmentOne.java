package com.example.fragmentintercomm;

import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOne extends Fragment  {
	Button btnClick;
	int counter=0;
	//STEP 1: ADD interface object
	//Interface variable can refer a subclass object
	//Dynamic Runtime Polymorphism
	Communicator com;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.fragment_one, container,false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		//STEP 2: Reference to Main Activity
		com=(Communicator) getActivity();
		btnClick=(Button) getActivity().findViewById(R.id.btn1);
		
		
		btnClick.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				counter++;
				//STEP 3:Call Interface Methods
				com.respond("The button was clicked"+counter+"times");
			}
		});
	}

	
}
