package com.example.supermarket_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link weight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class weight extends Fragment {
    private static final String TAG = "UsingThingspeakAPI";
    private static final String THINGSPEAK_CHANNEL_ID = "1214354";
    private static final String THINGSPEAK_API_KEY = "KA0B3FYOEFR5R4ON"; //GARBAGE KEY
    private static final String THINGSPEAK_API_KEY_STRING = "KA0B3FYOEFR5R4ON";
    private static final String THINGSPEAK_FIELD1 = "weight";
    private static final String THINGSPEAK_UPDATE_URL = "https://api.thingspeak.com/update?";
    private static final String THINGSPEAK_CHANNEL_URL = "https://api.thingspeak.com/channels/";
    private static final String THINGSPEAK_FEEDS_LAST = "/feeds/last?";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    TextView t1,t2;
    Button b1;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public weight() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment weight.
     */
    // TODO: Rename and change types and number of parameters
    public static weight newInstance(String param1, String param2) {
        weight fragment = new weight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        t1=findViewById(R.id.textView2);
        t2=findViewById(R.id.textView3);
        b1=(Button) findViewById(R.id.button);
        t2.setText("");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    new FetchThingspeakTask().execute();
                }
                catch(Exception e){
                    Log.e("ERROR", e.getMessage(), e);
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weight, container, false);
    }
}