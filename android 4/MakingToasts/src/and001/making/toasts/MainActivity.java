package and001.making.toasts;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

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

	public void onShortClick(View view)
	{ 
		Toast.makeText(this, R.string.short_txt, Toast.LENGTH_LONG).show(); 
	}	
	
	public void onShortClick1(View view)
	{ 
		Toast.makeText(this, R.string.long_txt, Toast.LENGTH_LONG).show(); 
	}	
	
	public void onShortClick2(View view)
	{ 
		Toast.makeText(this, R.string.time_txt, Toast.LENGTH_LONG).show(); 
	}	
	
	public void onShortClick3(View view)
	{ 
		Toast.makeText(this, R.string.gravity_text, Toast.LENGTH_LONG).show(); 
	}	
	
	public void onShortClick4(View view)
	{ 
		Toast.makeText(this, R.string.custom_toast_text, Toast.LENGTH_LONG).show(); 
	}	
		

	public void onCustomClick(View view) { 
			 
			// Inflate custom toast view 
			
			LayoutInflater inflater = getLayoutInflater(); 
			View toastLayout = inflater.inflate(R.layout.custom_toast, (ViewGroup) 
			findViewById(R.id.toast_layout_root)); 
			 
			Toast toast = new Toast(getApplicationContext()); 
			toast.setDuration(Toast.LENGTH_LONG); 
			toast.setView(toastLayout); 
			toast.setGravity(Gravity.RIGHT, 20, 20);
			toast.show(); 
			}
		 
		
	
	
	
	
	
	
	
}
