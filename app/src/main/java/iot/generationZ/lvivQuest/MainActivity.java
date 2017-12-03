package iot.generationZ.lvivQuest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Tanya = (Button) findViewById(R.id.Tanya);
        Tanya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });
    }
    public void openCamera() {
    Intent intent = new Intent(this, Camera.class);
    startActivity(intent);
    }
}
