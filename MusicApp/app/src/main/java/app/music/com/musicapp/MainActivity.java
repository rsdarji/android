package app.music.com.musicapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPlay(View view) {
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this,R.raw.s);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stop();
                }
            });
        }
        mediaPlayer.start();
    }

    public void onPause(View view) {
        if(mediaPlayer!=null){
            mediaPlayer.pause();

        }

    }

    public void onStop(View view) {
        stop();
    }

    public void stop(){
        if(mediaPlayer!=null){
            mediaPlayer.stop();
            mediaPlayer=null;
        }

    }
}
