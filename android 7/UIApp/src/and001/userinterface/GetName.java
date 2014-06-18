package and001.userinterface;


 


import android.app.Activity; 
import android.content.Intent; 
import android.os.Bundle; 
import android.view.View; 
import android.widget.Button; 

import android.widget.EditText; 

public class GetName extends Activity implements android.view.View.OnClickListener{ 
 
 EditText name; 
 Button button; 
 
 public void onClick(View arg0) { 
 // TODO Auto-generated method stub 
 Intent myIntent = new Intent(this,MainActivity.class); 
 myIntent.putExtra("uname",name.getText().toString()); 
 
 this.startActivity(myIntent); 
 } 
 
 public void onCreate(Bundle savedInstanceState) { 
 super.onCreate(savedInstanceState); 
 this.setContentView(R.layout.get_name); 
 
 name = (EditText) this.findViewById(R.id.uiEditText); 
 button = (Button) this.findViewById(R.id.uiButton); 
 
 button.setOnClickListener(this); 
 } 
 
 
}
