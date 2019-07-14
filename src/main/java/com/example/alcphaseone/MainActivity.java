package com.example.alcphaseone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button about_alc_button,my_profile_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about_alc_button = (Button) findViewById(R.id.about_alc_button);
        my_profile_button = (Button) findViewById(R.id.my_profile_button);

        about_alc_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AboutALC.class);
                startActivity(intent);

            }
        });

        my_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyProfile.class);
                startActivity(intent);
            }
        });
    }
}
