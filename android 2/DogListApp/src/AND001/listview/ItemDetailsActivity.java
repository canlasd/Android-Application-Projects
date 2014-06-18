package AND001.listview;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailsActivity extends Activity {

	TextView dogRank, dogGroup, dogName, dogBreed;
	ImageView dogImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.item_details_view);

		Resources myResources = getResources();

		dogImage = (ImageView) findViewById(R.id.imageView1);
		dogName = (TextView) findViewById(R.id.breed);
		dogGroup = (TextView) findViewById(R.id.group);
		dogRank = (TextView) findViewById(R.id.rank);
		dogBreed = (TextView) findViewById(R.id.web);

		Intent myIntent = getIntent();
		int position = myIntent.getIntExtra("position", 0);

		TypedArray arrayImages = myResources.obtainTypedArray(R.array.images);
		Drawable myDrawable = arrayImages.getDrawable(position);
		arrayImages.recycle();
		dogImage.setImageDrawable(myDrawable);

		TypedArray arrayGroup = myResources
				.obtainTypedArray(R.array.dog_groups);
		String Group = arrayGroup.getString(position);

		arrayGroup.recycle();
		dogGroup.setText(Group);

		TypedArray arrayRank = myResources.obtainTypedArray(R.array.rank);
		String Rank = arrayRank.getString(position);
		arrayRank.recycle();
		dogRank.setText(Rank);

		TypedArray arrayDogs = myResources.obtainTypedArray(R.array.dog_names);
		String Breed = arrayDogs.getString(position);
		arrayDogs.recycle();
		dogName.setText(Breed);

		switch (position) {

		case 0:

			dogBreed.setText(Html.fromHtml(getString(R.string.labrador)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 1:

			dogBreed.setText(Html.fromHtml(getString(R.string.poodle)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 2:

			dogBreed.setText(Html.fromHtml(getString(R.string.labradoodle)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 3:

			dogBreed.setText(Html.fromHtml(getString(R.string.bulldog)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 4:

			dogBreed.setText(Html.fromHtml(getString(R.string.beagle)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 5:

			dogBreed.setText(Html.fromHtml(getString(R.string.beabull)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 6:

			dogBreed.setText(Html.fromHtml(getString(R.string.boxer)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 7:

			dogBreed.setText(Html.fromHtml(getString(R.string.bogle)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 8:

			dogBreed.setText(Html.fromHtml(getString(R.string.ckc_spaniel)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 9:

			dogBreed.setText(Html.fromHtml(getString(R.string.bichon_frise)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 10:

			dogBreed.setText(Html.fromHtml(getString(R.string.cavachon)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 11:

			dogBreed.setText(Html
					.fromHtml(getString(R.string.miniature_schnauzer)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 12:

			dogBreed.setText(Html.fromHtml(getString(R.string.schnoodle)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 13:

			dogBreed.setText(Html.fromHtml(getString(R.string.maltese)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		case 14:

			dogBreed.setText(Html.fromHtml(getString(R.string.maltipoo)));
			dogBreed.setMovementMethod(LinkMovementMethod.getInstance());
			dogBreed.setLinksClickable(true);

			break;

		}
	}
}
