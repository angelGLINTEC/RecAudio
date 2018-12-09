package com.glintec.app.grabaraudio;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPlay, btnGrab;
    Uri uri1;
    int peticion=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGrab = findViewById(R.id.btnRec);
        btnGrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rec();
            }
        });

        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play();
            }
        });


    }


    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == peticion && resultCode == RESULT_OK){
            uri1 = data.getData();
        }
    }
    public void play(){
        MediaPlayer mp = new MediaPlayer().create(this, uri1);
    }

    public void rec(){
        Intent i = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
        startActivityForResult(i,peticion);
    }
}
