package com.example.actionbartabs;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BirdFragment extends ListFragment {

	/** An array of items to display in ArrayList */
	String Birds[] = new String[] { "Little Grebe", "Flamingo", "Stork",
			"Heron", "Pelican", "Vulture", "Duck", "Goose", "Crane", "Wader",
			"Gull", "Auk", "Pigeon", "Dove" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		/** Creating array adapter to set data in listview */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
				.getBaseContext(),
				android.R.layout.simple_list_item_multiple_choice, Birds);

		/** Setting the array adapter to the listview */
		setListAdapter(adapter);

		return super.onCreateView(inflater, container, savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();

		/** Setting the multiselect choice mode for the listview */
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

	}

}
