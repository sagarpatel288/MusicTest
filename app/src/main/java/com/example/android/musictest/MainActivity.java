package com.example.android.musictest;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_play)
    Button btnPlay;
    @BindView(R.id.btn_pause)
    Button btnPause;
    @BindView(R.id.btn_vol_up)
    Button btnVolUp;
    @BindView(R.id.btn_vol_down)
    Button btnVolDown;
    @BindView(R.id.btn_next)
    Button btnNext;
    @BindView(R.id.btn_previous)
    Button btnPrevious;
    @BindView(R.id.btn_ff)
    Button btnFf;
    @BindView(R.id.btn_backward)
    Button btnBackward;
    @BindView(R.id.btn_stop)
    Button btnStop;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mediaPlayer = MediaPlayer.create(this, R.raw.audio_mark_petrie_a_new_day);
    }

    @OnClick({R.id.btn_play, R.id.btn_pause, R.id.btn_vol_up, R.id.btn_vol_down, R.id.btn_next, R.id.btn_previous, R.id.btn_ff, R.id.btn_backward, R.id.btn_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_play:
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                break;
            case R.id.btn_pause:
                mediaPlayer.pause();
                break;
            case R.id.btn_vol_up:
                mediaPlayer.setVolume(1, 1);
                break;
            case R.id.btn_vol_down:
                mediaPlayer.setVolume(0.2F, 0.2f);
                break;
            case R.id.btn_next:
                mediaPlayer = MediaPlayer.create(this, R.raw.audio_corrs);
                break;
            case R.id.btn_previous:
                mediaPlayer = MediaPlayer.create(this, R.raw.audio_mark_petrie_a_new_day);
                break;
            case R.id.btn_ff:
                mediaPlayer.seekTo(100);
                break;
            case R.id.btn_backward:
                mediaPlayer.seekTo(-100);
                break;
            case R.id.btn_stop:
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
                resetMediaPlayer();
                break;
        }
    }

    private void resetMediaPlayer(){
        if (mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this, R.raw.audio_now_we_free_gladiator_taylor_davis);
        }
    }
}
