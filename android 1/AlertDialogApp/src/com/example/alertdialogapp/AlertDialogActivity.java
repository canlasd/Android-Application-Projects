package com.example.alertdialogapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button btnAlert = (Button) findViewById(R.id.btnAlert);
		Button btnAlertTwoBtns = (Button) findViewById(R.id.btnAlertWithTwoBtns);
		Button btnAlertThreeBtns = (Button) findViewById(R.id.btnAlertWithThreeBtns);

		btnAlert.setOnClickListener(new View.OnClickListener() {

			@SuppressWarnings("deprecation")
			public void onClick(View arg0) {
				// Creating alert Dialog with one Button

				AlertDialog alertDialog = new AlertDialog.Builder(

				AlertDialogActivity.this).create();

				// Setting Dialog Title
				alertDialog.setTitle(R.string.alert_title);

				// Setting Dialog Message
				alertDialog.setMessage("Do You Wish to Continue?");

				// Setting Icon to Dialog
				alertDialog.setIcon(R.drawable.ic_caution);

				// Setting Yes Button
				alertDialog.setButton("Yes",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// Write your code here to execute after dialog
								// closed
								Toast.makeText(getApplicationContext(),
										R.string.ok, Toast.LENGTH_SHORT).show();
							}
						});
				// Showing Alert Message
				alertDialog.show();

			}
		});

		/**
		 * Showing Alert Dialog with Two Buttons one Positive Button with Label
		 * "YES" one Negative Button with Label "NO"
		 */
		btnAlertTwoBtns.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {

				// Creating alert Dialog with two Buttons

				AlertDialog.Builder alertDialog = new AlertDialog.Builder(
						AlertDialogActivity.this);

				// Setting Dialog Title
				alertDialog.setTitle(R.string.confirm);

				// Setting Dialog Message
				alertDialog.setMessage(R.string.delete);

				// Setting Icon to Dialog
				alertDialog.setIcon(R.drawable.ic_action_delete);
				// Setting Positive "Yes" Button
				alertDialog.setPositiveButton("YES",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {

								Toast.makeText(getApplicationContext(),
										R.string.yes, Toast.LENGTH_SHORT)
										.show();
							}
						});
				// Setting Negative "NO" Button
				alertDialog.setNegativeButton("NO",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {

								Toast.makeText(getApplicationContext(),
										R.string.no, Toast.LENGTH_SHORT).show();

								dialog.cancel();
							}
						});
				// Showing Alert Message
				alertDialog.show();

			}
		});

		/**
		 * Showing Alert Dialog with Two Buttons one Positive Button with Label
		 * "YES" one Neutral Button with Label "NO" one Negative Button with
		 * label "Cancel"
		 */
		btnAlertThreeBtns.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				// Creating alert Dialog with three Buttons

				AlertDialog.Builder alertDialog = new AlertDialog.Builder(
						AlertDialogActivity.this);

				// Setting Dialog Title
				alertDialog.setTitle(R.string.title);
				// Setting Dialog Message
				alertDialog.setMessage(R.string.save_question);

				// Setting Icon to Dialog
				alertDialog.setIcon(R.drawable.content_save);

				// Setting Positive Yes Button
				alertDialog.setPositiveButton("YES",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// User pressed Cancel button. Write Logic Here

								Toast.makeText(getApplicationContext(),
										R.string.yes,

										Toast.LENGTH_SHORT).show();
							}
						});
				// Setting Positive Yes Button
				alertDialog.setNeutralButton("NO",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// User pressed No button. Write Logic Here

								Toast.makeText(getApplicationContext(),
										R.string.no, Toast.LENGTH_SHORT).show();
							}
						});
				// Setting Positive "Cancel" Button
				alertDialog.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {

							public void onClick(DialogInterface dialog,
									int which) {
								// User pressed Cancel button. Write Logic Here

								Toast.makeText(getApplicationContext(),
										R.string.cancel,

										Toast.LENGTH_SHORT).show();
							}
						});
				// Showing Alert Message
				alertDialog.show();

			}
		});
	}
}
