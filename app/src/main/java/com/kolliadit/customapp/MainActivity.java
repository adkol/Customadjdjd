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

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends FragmentActivity {

    Map<String,String> qa;
    RadioButton val;
    Button sub;
    EditText responseText;
    TextView displayText;
    TextView qText;
    RadioGroup radio;

    int[] scores;
    SharedPreferences pref ; // 0 - for private mode
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

                int selectedId = radio.getCheckedRadioButtonId();
                val = (RadioButton) findViewById(selectedId);
                String text = (String)( val.getResources().getResourceEntryName(selectedId));
                text = text.substring(5);
                if (text.equals("luka")) {
                    selectedId = 0;
                    scores[selectedId]++;
                    editor.putInt(selectedId + "", scores[selectedId]);
                }
                if (text.equals("giannis")) {
                    selectedId = 1;
                    scores[selectedId]++;
                    editor.putInt(selectedId + "", scores[selectedId]);
                }
                if (text.equals("poole")) {
                    selectedId = 2;
                    scores[selectedId]++;
                    editor.putInt(selectedId + "", scores[selectedId]);
                }
                if (text.equals("lebron")) {
                    selectedId = 3;
                    scores[selectedId]++;
                    editor.putInt(selectedId + "", scores[selectedId]);
                }
                editor.commit();


            }





}
