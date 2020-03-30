package com.kolliadit.customapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends FragmentActivity {
    String videoID;
    TextView Text;
    Map<String,String> qa;
    RadioButton val;
    Button sub;
    EditText responseText;
    TextView displayText;
    TextView qText;
    RadioGroup radio;
    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitial;
    int[] scores;
    SharedPreferences pref ; // 0 - for private mode
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//        mYouTubePlayerView=findViewById(R.id.view);

        radio = (RadioGroup) findViewById(R.id.radiogrou);
        pref= getApplicationContext().getSharedPreferences("MyPref", 0);
        editor = pref.edit();

        sub = findViewById(R.id.btnDisplay);
        scores = new int[]{0, 0, 0, 0};
        qa = new HashMap<String, String>();
        for (int num = 0; num < 4; num++)
            scores[num] = pref.getInt("" + num, 0);

    }
    public void onC(View v) {

                int most=0;
                String fav="";
                int temp=0;
                int selectedId = radio.getCheckedRadioButtonId();
                val = (RadioButton) findViewById(selectedId);
                String text = (String)( val.getResources().getResourceEntryName(selectedId));
                text = text.substring(5);
                if (text.equals("luka")) {
                    videoID="NzsCCQsM5YY";
                    selectedId = 0;
                    scores[selectedId]++;
                    temp=scores[selectedId];
                    editor.putInt(selectedId + "", scores[selectedId]);
                }
        selectedId = 0;
        temp=scores[selectedId];
                if (temp>most){
                    most=temp;
                    fav="Luka Doncic";
                }
                if (text.equals("giannis")) {
                    videoID="0rMxWWsG4CQ";
                    selectedId = 1;
                    scores[selectedId]++;
                    temp=scores[selectedId];
                    editor.putInt(selectedId + "", scores[selectedId]);
                }
        selectedId = 1;
        temp=scores[selectedId];
        if (temp>most){
            most=temp;
            fav="Giannis Antetekounmpo";
        }
                if (text.equals("poole")) {
                    videoID="cAKFewv6LAY";
                    selectedId = 2;
                    scores[selectedId]++;

                    editor.putInt(selectedId + "", scores[selectedId]);
                }
        selectedId = 2;
        temp=scores[selectedId];
        if (temp>most){
            most=temp;
            fav="Jordan Poole";
        }
                if (text.equals("lebron")) {
                    videoID="b117a8_jALE";
                    selectedId = 3;
                    scores[selectedId]++;
                    temp=scores[selectedId];
                    editor.putInt(selectedId + "", scores[selectedId]);
                }
        selectedId = 3;
        temp=scores[selectedId];
        if (temp>most){
            most=temp;
            fav="Lebron James";
        }
                editor.commit();

        Gson gson = new Gson();
        Person p = new Person(fav);
        String json = gson.toJson(p);
        Text=findViewById(R.id.Text);
        json=json.substring(9,json.length()-2);
        json="MVP Favorite: "+json;
        Text.setText(json);

//        mOnInitial= new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                youTubePlayer.loadVideo(videoID);
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };
//        mYouTubePlayerView.initialize(YouTubeConfig.getApiKey(),mOnInitial);
            }

public class Person{
        public String name;
        public Person(String nam){
            name=nam;
        }
    }



}
