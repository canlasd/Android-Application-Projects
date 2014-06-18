package com.example.actionbartabs;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DogFragment extends ListFragment {

	/** An array of items to display in ArrayList */
	String Dogs[] = new String[] { "Afinpincher", "Afghan Hound",
			"Basset Hound", "Bichon Friche", "Bull Dog", "Chow Chow",
			"American Cocker Spaniel", "German Shepard", "Great Dane",
			"Grey Hound", "Poodle", "Labrador Retriever", "Maltese",
			"Yorkshire Terrier" };

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		/** Creating array adapter to set data in listview */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
				.getBaseContext(),
				android.R.layout.simple_list_item_multiple_choice, Dogs);

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
