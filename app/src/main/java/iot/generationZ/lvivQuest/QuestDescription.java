package iot.generationZ.lvivQuest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class QuestDescription extends AppCompatActivity {

    TextView nameView;
    TextView descriptionView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_description);

        nameView = findViewById(R.id.infa_about_quest);
        descriptionView = findViewById(R.id.descr);


        InputStream is = this.getResources().openRawResource(R.raw.desc);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        if (is != null) {
            String data = "";
            String json= "";
            try {
                while ((data = reader.readLine()) != null) {
                    json+=data;
                }
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try{
                JSONArray array = new JSONArray(json);
                JSONObject object = array.getJSONObject(0);
                String name = object.getString("name");
                String descript = object.getString("description");
                nameView.setText(name);
                descriptionView.setText(descript);
            }catch(Exception e){

            }
        }
    }
}
