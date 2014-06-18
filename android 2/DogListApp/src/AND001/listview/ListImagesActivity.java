package AND001.listview;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListImagesActivity extends ListActivity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// access the dog names array
		Resources myResources = getResources();
		String[] breeds = myResources.getStringArray(R.array.dog_names);

		/*
		 * Initiates List. Make sure to add the textview ID where the array
		 * string values will be placed. In this case, R.id.name which is found
		 * on the list_main layout
		 */

		setListAdapter(new ArrayAdapter<String>(this, R.layout.list_main,
				R.id.name, breeds));

		// display view
		ListView myListView = getListView();

		// set onclick listener to activate ItemDetailsActivity

		myListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent detailsIntent = new Intent(ListImagesActivity.this,
						ItemDetailsActivity.class);
				detailsIntent.putExtra("position", position);
				startActivity(detailsIntent);
			}
		});
	}
}