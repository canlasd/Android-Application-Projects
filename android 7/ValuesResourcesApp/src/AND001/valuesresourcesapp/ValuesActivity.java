package AND001.valuesresourcesapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ValuesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_values);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.values, menu);
		return true;
	}

}
