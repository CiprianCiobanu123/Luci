package com.ciprian.luci;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    Button btnPlay;
    private AdView mBannerAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBannerAd = (AdView) findViewById(R.id.mBannerAd);
        showBannerAd();

        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setBackgroundResource(R.mipmap.ic_stop);

        mp = MediaPlayer.create(this, R.raw.doitluci);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp.isPlaying()) {
                    mp.pause();
                    btnPlay.setBackgroundResource(R.mipmap.ic_stop);
                } else {
                    mp.start();
                    btnPlay.setBackgroundResource(R.mipmap.ic_play);
                }
            }
        });


        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {

                mp.start();

            }
        });
    }



    private void showBannerAd() {
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mBannerAd.loadAd(adRequest);


    }
}
