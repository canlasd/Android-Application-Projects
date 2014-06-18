package com.example.actionbartabs;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.Toast;

public class MainActivity extends Activity {
	/** Called when the activity is first created. */
	private ShareActionProvider mShareActionProvider;
	public static Context appContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		appContext = getApplicationContext();

		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.setDisplayShowTitleEnabled(true);

		/** Creating Cat Tab */
		Tab tab = actionBar
				.newTab()
				.setText(" Cat")
				.setTabListener(
						new CustomTabListener<CatFragment>(this, "cat",
								CatFragment.class)).setIcon(R.drawable.cat_tab);

		actionBar.addTab(tab);
		/** Creating Dog Tab */
		tab = actionBar
				.newTab()
				.setText(" Dog")
				.setTabListener(
						new CustomTabListener<DogFragment>(this, "dog",
								DogFragment.class)).setIcon(R.drawable.dog_tab);

		actionBar.addTab(tab);

		/** Creating Bird Tab */
		tab = actionBar
				.newTab()
				.setText(" Bird")
				.setTabListener(
						new CustomTabListener<BirdFragment>(this, "bird",
								BirdFragment.class))
				.setIcon(R.drawable.bird_tab);

		actionBar.addTab(tab);

		/** Creating Snake Tab */
		tab = actionBar
				.newTab()
				.setText(" Snake")
				.setTabListener(
						new CustomTabListener<SnakeFragment>(this, "snake",
								SnakeFragment.class))
				.setIcon(R.drawable.snake_tab);

		actionBar.addTab(tab);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		/** Inflating the current activity's menu with res/menu/menu.xml */
		getMenuInflater().inflate(R.menu.main, menu);

		/**
		 * Get the ShareActionProvider associated with the menu item whose id is
		 * menuitem_share
		 */
		mShareActionProvider = (ShareActionProvider) menu.findItem(
				R.id.menuitem_share).getActionProvider();

		/** Setting a share intent */
		mShareActionProvider.setShareIntent(getDefaultShareIntent());

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menuitem_search:
			Toast.makeText(this, getString(R.string.menu_search),
					Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menuitem_send:
			Toast.makeText(this, getString(R.string.menu_send),
					Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menuitem_add:
			Toast.makeText(this, getString(R.string.menu_add),
					Toast.LENGTH_SHORT).show();
			return true;
		case R.id.menuitem_save:
			Toast.makeText(this, getString(R.string.menu_save),
					Toast.LENGTH_SHORT).show();

			return true;

		case R.id.menuitem_about:
			Toast.makeText(this, getString(R.string.action_bar),
					Toast.LENGTH_LONG).show();
			return true;
		case R.id.menuitem_quit:
			Toast.makeText(this, getString(R.string.menu_quit),
					Toast.LENGTH_SHORT).show();
			finish(); // close the activity
			return true;
		}
		return false;
	}

	/** Returns a share intent */
	private Intent getDefaultShareIntent() {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, "SUBJECT");
		intent.putExtra(Intent.EXTRA_TEXT, "Testing Easy Share Button");
		return intent;
	}
}
