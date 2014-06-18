package and001.userinterface;



import android.view.Menu;
import android.os.Bundle; 
import android.app.Activity; 
import android.widget.TextView; //API Library for creating buttons and text boxes on screen 
 
public class MainActivity extends Activity { 
 
 @Override 
 protected void onCreate(Bundle savedInstanceState) { 
 super.onCreate(savedInstanceState); 
 setContentView(R.layout.activity_main); 
 Bundle myInput = this.getIntent().getExtras(); 
 
 TextView t=new TextView(this); 
 t=(TextView)findViewById(R.id.act_mainTextView); 
 t.setText("Hello " + (myInput.getString("uname"))); 
 } 
 
 @Override 
 public boolean onCreateOptionsMenu(Menu menu) { 
 // Inflate the menu; this adds items to the action bar if it is present. 
 getMenuInflater().inflate(R.menu.activity_get_name, menu); 
 return true; 
 } 
 
} 

