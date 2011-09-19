package com.android.processing.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class PrefFragment extends Fragment {
    boolean mDualPane;
    int mCurCheckPosition = 0;
    int mShownCheckPosition = -1;
    PFrag sketch = new PFrag();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        // Populate list with our static array of titles.
//        setListAdapter(new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_activated_1, Shakespeare.TITLES));

        // Check to see if we have a frame in which to embed the details
        // fragment directly in the containing UI.
        View detailsFrame = getActivity().findViewById(R.id.sketch);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
            mShownCheckPosition = savedInstanceState.getInt("shownChoice", -1);
        }

        if (mDualPane) {
            // In dual-pane mode, the list view highlights the selected item.
//            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            // Make sure our UI is in the correct state.
            showDetails(mCurCheckPosition);
        }
    }

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout layout = new LinearLayout(this.getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		
		// red
		final TextView rtv = new TextView(this.getActivity());
		rtv.setText("Red Value: " + sketch.getRed());
		SeekBar rs = new SeekBar(this.getActivity());
		rs.setMax(255);
		rs.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar arg0, int value, boolean arg2) {
				rtv.setText("Red Value: " + value);
				sketch.setRed(value);
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				
			}
			
		});
		
		// green
		final TextView gtv = new TextView(this.getActivity());
		gtv.setText("Green Value: " + sketch.getGreen());
		SeekBar gs = new SeekBar(this.getActivity());
		gs.setMax(255);
		gs.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar arg0, int value, boolean arg2) {
				gtv.setText("Red Value: " + value);
				sketch.setGreen(value);
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				
			}
			
		});
		
		// blue
		final TextView btv = new TextView(this.getActivity());
		btv.setText("Blue Value: " + sketch.getBlue());
		SeekBar bs = new SeekBar(this.getActivity());
		bs.setMax(255);
		bs.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar arg0, int value, boolean arg2) {
				btv.setText("Blue Value: " + value);
				sketch.setBlue(value);
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				
			}
			
		});
		
		// alpha
		final TextView atv = new TextView(this.getActivity());
		atv.setText("Alpha Value: " + sketch.getAlpha());
		SeekBar as = new SeekBar(this.getActivity());
		as.setMax(255);
		as.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar arg0, int value, boolean arg2) {
				atv.setText("Alpha Value: " + value);
				sketch.setAlpha(value);
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0) {
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				
			}
			
		});
		
		
		// add them to the layout
		layout.addView(rtv);
		layout.addView(rs);
		layout.addView(gtv);
		layout.addView(gs);
		layout.addView(btv);
		layout.addView(bs);
		layout.addView(atv);
		layout.addView(as);
		
		layout.setPadding(50, 50, 50, 0);
		
		return layout;
	}
    
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
        outState.putInt("shownChoice", mShownCheckPosition);
    }


    /**
     * Helper function to show the details of a selected item, either by
     * displaying a fragment in-place in the current UI, or starting a
     * whole new activity in which it is displayed.
     */
    void showDetails(int index) {
        mCurCheckPosition = index;

        if (mDualPane) {
            // We can display everything in-place with fragments, so update
            // the list to highlight the selected item and show the data.
//            getListView().setItemChecked(index, true);

            if (mShownCheckPosition != mCurCheckPosition) {
                // If we are not currently showing a fragment for the new
                // position, we need to create and install a new one.


                // Execute a transaction, replacing any existing fragment
                // with this one inside the frame.
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.sketch, sketch);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                mShownCheckPosition = index;
            }

        } else {
        }
    }
}