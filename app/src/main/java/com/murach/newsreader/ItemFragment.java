package com.murach.newsreader;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;




public class ItemFragment extends Fragment implements View.OnClickListener {






    public ItemFragment() {
    }
    private FileIO io;
        private TextView titleTextView;
    private TextView pubDateTextView;
    private TextView descriptionTextView;
    private TextView linkTextView;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                             //getActivity of a user defined
        io = new FileIO(getActivity().getApplicationContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);


        // get references to widgets
        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        pubDateTextView = (TextView) view.findViewById(R.id.pubDateTextView);
        descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        linkTextView = (TextView) view.findViewById(R.id.linkTextView);

        // get the intent
                            //getActivity user defined
        Intent intent = new Intent(getActivity(), ItemActivity.class);

        // get data from the intent
        String pubDate = intent.getStringExtra("pubdate");
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description").replace('\n', ' ');

        // display data on the widgets
        pubDateTextView.setText(pubDate);
        titleTextView.setText(title);
        descriptionTextView.setText(description);

        // set listener
        linkTextView.setOnClickListener(this);
return view;
    }



    @Override
    public void onClick(View v) {
// get the intent
        //getActivity user defined
        Intent intent = getActivity().getIntent();

        // get the Uri for the link
        String link = intent.getStringExtra("link");
        Uri viewUri = Uri.parse(link);

        // create the intent and start it
        Intent viewIntent = new Intent(Intent.ACTION_VIEW, viewUri);
        startActivity(intent);
    }
}