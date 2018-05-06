package com.example.merve.mediaplayerdemo;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    boolean isPlaying =false;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startStop(View view) {
        if(mediaPlayer==null)
            mediaPlayer=new MediaPlayer();

        if(isPlaying)
        {
            mediaPlayer.stop();
            isPlaying=false;
        }
        else
        {
            try
            {
                mediaPlayer.setDataSource("https://content.cdbaby.com/audio/samples/37a91e3d/stephaniequinn-09.mp3");
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.prepare();
                mediaPlayer.start();
                isPlaying=true;
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer!=null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();//bırak
            mediaPlayer=null;
        }
        super.onDestroy();
    }
}
