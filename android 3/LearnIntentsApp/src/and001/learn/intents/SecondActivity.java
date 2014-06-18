package and001.learn.intents;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity implements
		android.view.View.OnClickListener {

	EditText name;
	Button button;

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent myIntent = new Intent(this, MainActivity.class);
		myIntent.putExtra("uname", name.getText().toString());

		this.startActivity(myIntent);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.second_activity);

		Resources myResources = getResources();
		String[] dogsArray = myResources.getStringArray(R.array.dogs_array);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, dogsArray);

		AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);

		textView.setThreshold(3);
		textView.setAdapter(adapter);

		// ---Click Save Button---

		name = (EditText) this.findViewById(R.id.autoCompleteTextView1);
		button = (Button) this.findViewById(R.id.button1);

		button.setOnClickListener(this);
		button.setOnClickListener(new View.OnClickListener() {
			/*
			 * @Override public void onClick(View v) { if (((ToggleButton)
			 * v).isChecked()) { DisplayToast("Toggle button is On"); } else {
			 * DisplayToast("Toggle button is Off"); } }
			 */

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent = new Intent(SecondActivity.this,
						ThirdActivity.class);

				myIntent.putExtra("uname", name.getText().toString());
				SecondActivity.this.startActivity(myIntent);
			}

		});

	}
	/*
	 * public void addListenerOnButton(){
	 * 
	 * name = (EditText) this.findViewById(R.id.autoCompleteTextView1); button =
	 * (Button) this.findViewById(R.id.button1);
	 * 
	 * button.setOnClickListener(this);
	 * 
	 * public void onClick(View arg0) { // TODO Auto-generated method stub
	 * Intent myIntent = new Intent(this,ThirdActivity.class);
	 * 
	 * myIntent.putExtra("uname",name.getText().toString());
	 * this.startActivity(myIntent); }
	 */

}
