package com.example.listfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Fragment1 extends ListFragment {

	// Create variable String[] mdogbreedsarray
	String[] mdogbreedsarray;

	// Create the OnCreate Method

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// mdogbreedsarray uses getStringArray method to get dog breeds array
		// from the arrays.xml file

		// Access layout with anroid.R.layout with simple_list_item1,
		// mdogbreedsarray

		mdogbreedsarray = getResources().getStringArray(R.array.dog_names);
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, mdogbreedsarray));

	}

	// Create method onCreateView
	// Use LayoutInflator to access the fragment1.xml view

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment1, container, false);
	}

	// Create method onListItemClick
	@Override
	public void onListItemClick(ListView parent, View v, int position, long id) {

		// Create toast within the method letting user know which dog breed they
		// clicked on
		Toast.makeText(getActivity(),
				"You have selected " + mdogbreedsarray[position],
				Toast.LENGTH_SHORT).show();
	}

}
