package pakiet.konrad.starfighter;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.media.SoundPool;
import android.os.IBinder;
import android.util.Log;

@SuppressLint("Registered")
public class SFMusic extends Service {



    private SoundPool soundPool;
    boolean loaded = false;
    private int soundIdGun;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();


setMusicOptions(this,SFEngine.LOOP_BACKGROUND_MUSIC,SFEngine.R_VOLUME,SFEngine.L_VOLUME,SFEngine.SPLASH_SCREEN_MUSIC);






    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {





        return super.onStartCommand(intent, flags, startId);



    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


public void setMusicOptions(Context context, final int isLooped, final int rVolume, final int lVolume, int soundFile)
{

    AudioAttributes audioAttrib = new AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build();

    SoundPool.Builder builder = new SoundPool.Builder();

    builder.setAudioAttributes(audioAttrib).setMaxStreams(2);
    this.soundPool = builder.build();
    this.soundIdGun = this.soundPool.load(this, soundFile, 1);


    this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
        @Override
        public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
            loaded = true;

            int streamId = soundPool.play(soundIdGun,lVolume, rVolume, 1, isLooped, 1f);
        }
    });



}




}
