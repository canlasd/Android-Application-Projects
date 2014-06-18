/*package and001.EditTextFieldApp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TextViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

 */

package and001.EditTextFieldApp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class TextViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		Resources myResources = getResources();
		String[] dogsArray = myResources.getStringArray(R.array.dogs_array);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, dogsArray);

		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.dogs);

		textView.setThreshold(3);
		textView.setAdapter(adapter);

		// ---ToggleButton---
		ToggleButton toggleButton = (ToggleButton) findViewById(R.id.dog_found);
		toggleButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (((ToggleButton) v).isChecked()) {
					DisplayToast("Toggle button is On");
				} else {
					DisplayToast("Toggle button is Off");
				}
			}
		});
	}

	private void DisplayToast(String msg) {
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
	}
}
