package com.firstapp.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;


public class TopSectionFragment extends Fragment{

    private static EditText toptextinput;
    private static EditText bottomtextinput;

    TopSectionListener activityCommander;

    public interface TopSectionListener{
        public void createMeme(String top,String Bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
                activityCommander = (TopSectionListener)activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment,container,false);

        toptextinput = (EditText) view.findViewById(R.id.topTextInput);
        bottomtextinput = (EditText) view.findViewById(R.id.bottomTextInput);
        final Button button =(Button) view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View V){
                    buttonClicked(V)  ;            }
                }
        );
        return view;
    }
    public void buttonClicked(View view){
        activityCommander.createMeme(toptextinput.getText().toString(),bottomtextinput.getText().toString());
    }
}
