package and001.learn.intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ThirdActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.third_activity);
		Bundle myInput = this.getIntent().getExtras();

		TextView t = new TextView(this);
		t = (TextView) findViewById(R.id.textView2);
		t.setText("Dog Breed Entered: " + myInput.getString("uname"));
	}
}