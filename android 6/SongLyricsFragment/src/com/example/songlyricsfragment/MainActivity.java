package com.example.songlyricsfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity implements
		ArtistFragment.OnArtistsSelectedListener {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.artists_view);

		// note that the layout artists_view is in the res/layout and
		// res/layout-large

		// The activity will determine which layout to use based on
		// the screen size of the device the app is running on.
		// If the device is a small screen, the fragment_container layout
		// res/layout will be used

		if (findViewById(R.id.fragment_container) != null) {

			// If we're being restored from a previous state, we'll do nothing
			// because we could end up with overlapping fragments.
			if (savedInstanceState != null) {
				return;
			}
			// Create an instance of ArtistFragment
			ArtistFragment firstFragment = new ArtistFragment();

			// In case this activity was started with special instructions from
			// an
			// Intent,
			// pass the Intent's extras to the fragment as arguments
			firstFragment.setArguments(getIntent().getExtras());

			// Add the fragment to the 'fragment_container' FrameLayout
			getSupportFragmentManager().beginTransaction()
					.add(R.id.fragment_container, firstFragment).commit();
		}
	}

	public void onSongSelected(int position) {
		// The user selected the artist to display the song lyrics too
		SongsFragment songsFrag = (SongsFragment) getSupportFragmentManager()
				.findFragmentById(R.id.songs_fragment);

		if (songsFrag != null) {
			// If article frag is available, we're in two-pane layout...

			// Call a method in the ArtistFragment to update its content
			songsFrag.updateSongsView(position);

		} else {
			// If the frag is not available, we're in the one-pane layout and
			// must
			// swap frags...

			// Create fragment and give it an argument for the selected article
			SongsFragment newFragment = new SongsFragment();
			Bundle args = new Bundle();
			args.putInt(SongsFragment.ARG_POSITION, position);
			newFragment.setArguments(args);
			FragmentTransaction transaction = getSupportFragmentManager()
					.beginTransaction();

			// Replace whatever is in the fragment_container view with this
			// fragment,
			// and add the transaction to the back stack so the user can
			// navigate
			// back
			transaction.replace(R.id.fragment_container, newFragment);
			transaction.addToBackStack(null);

			// Commit the transaction
			transaction.commit();
		}
	}
}
