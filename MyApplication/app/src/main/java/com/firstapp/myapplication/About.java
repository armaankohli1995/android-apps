package com.firstapp.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * A simple {@link Fragment} subclass.
 */
public class About extends Fragment {

  ViewFlipper mViewFlipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        ImageView imageView = new ImageView(getContext());

        imageView.setImageResource(R.drawable.top2);
        mViewFlipper = (ViewFlipper)v.findViewById(R.id.viewFlipper);
        mViewFlipper.addView(imageView);


        mViewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewFlipper.setAutoStart(true);
                mViewFlipper.setFlipInterval(2500);
                mViewFlipper.startFlipping();

            }

        });
        return v;

    }


}
