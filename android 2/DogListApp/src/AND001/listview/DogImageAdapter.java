package AND001.listview;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class DogImageAdapter extends BaseAdapter {
	private final Context myContext;
	Resources myResources;
	Integer[] myThumbIds;

	public DogImageAdapter(Context context) {
		myContext = context;
		myResources = myContext.getResources();
		TypedArray arrayDogs = myResources.obtainTypedArray(R.array.images);
		myThumbIds = new Integer[arrayDogs.length()];
		for (int i = 0; i < arrayDogs.length(); i++) {
			myThumbIds[i] = arrayDogs.getResourceId(i, 0);
		}
		arrayDogs.recycle();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView myImageView;
		if (convertView == null) {
			myImageView = new ImageView(myContext);
			myImageView.setLayoutParams(new GridView.LayoutParams(120, 120));
			myImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			myImageView.setPadding(10, 10, 10, 10);
		} else {
			myImageView = (ImageView) convertView;
		}
		myImageView.setImageResource(myThumbIds[position]);
		return myImageView;
	}

	@Override
	public int getCount() {
		return myThumbIds.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}
}
