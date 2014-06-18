package com.example.persistentdialogapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */

	Button btnalert1, btnalertcheck, btnalertlist, btnalertcustom, click,
			finishbtn;
	CharSequence[] dogs = { "Lab", "Poodle", "Yorkie" };
	CharSequence[] items = { "Pure Breed", "Mutt", "Designer Dog" };
	boolean[] itemsChecked = new boolean[items.length];

	TextView txtv;
	ImageView imgv;
	Dialog myDialog;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btnalert1 = (Button) findViewById(R.id.btn_dialog);
		btnalert1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder1 = new AlertDialog.Builder(
						MainActivity.this);
				builder1.setMessage("Please Press Ok");
				builder1.setNeutralButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Toast.makeText(getApplicationContext(),
										"Ok is pressed", Toast.LENGTH_LONG)
										.show();
							}
						});
				builder1.show();
			}
		});

		btnalertlist = (Button) findViewById(R.id.btn_dialog2);
		btnalertlist.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder2 = new AlertDialog.Builder(
						MainActivity.this);
				builder2.setTitle("Choose a Puppy")
						.setIcon(R.drawable.ic_terrier)
						.setItems(dogs, new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Toast.makeText(getApplicationContext(),
										"You Chose A " + dogs[which],
										Toast.LENGTH_LONG).show();
							}
						});
				builder2.show();
			}
		});

		btnalertcheck = (Button) findViewById(R.id.btn_dialog3);
		btnalertcheck.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlertDialog.Builder builder3 = new AlertDialog.Builder(
						MainActivity.this);
				builder3.setTitle("Dog Preference")
						.setIcon(R.drawable.download)
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int whichButton) {
										Toast.makeText(getBaseContext(),
												"OK clicked!",
												Toast.LENGTH_SHORT).show();
									}
								})
						.setNegativeButton("Cancel",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int whichButton) {
										Toast.makeText(getBaseContext(),
												"Cancel clicked!",
												Toast.LENGTH_SHORT).show();
									}
								})
						.setMultiChoiceItems(
								items,
								itemsChecked,
								new DialogInterface.OnMultiChoiceClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which, boolean isChecked) {
										Toast.makeText(
												getBaseContext(),
												items[which]
														+ (isChecked ? " checked!"
																: "unchecked!"),
												Toast.LENGTH_SHORT).show();
									}
								});
				builder3.show();
			}
		});

		btnalertcustom = (Button) findViewById(R.id.btn_dialog4);
		btnalertcustom.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				// TODO Auto-generated method stub
				myDialog = new Dialog(MainActivity.this);
				myDialog.setContentView(R.layout.custom_layout);
				myDialog.setTitle("Custom Dialog");
				txtv = (TextView) myDialog.findViewById(R.id.tv);
				txtv.setText("My Custom Dialog Text");
				imgv = (ImageView) myDialog.findViewById(R.id.imgv);
				imgv.setImageResource(R.drawable.custom_dog);
				finishbtn = (Button) myDialog.findViewById(R.id.btnfinish1);
				finishbtn.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						myDialog.cancel();
					}
				});
				myDialog.show();
			}
		});
	}
}
