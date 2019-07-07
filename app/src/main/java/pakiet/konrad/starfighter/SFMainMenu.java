package pakiet.konrad.starfighter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;




public class SFMainMenu extends Activity {
    ImageButton start,exit;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfmain_menu);



        SFEngine.musicThread = new Thread(){
            public void run()
            {
                Intent bgmusic = new Intent(getApplicationContext(),SFMusic.class);
                startService(bgmusic);
                SFEngine.context= getApplicationContext();
            }
        };
        SFEngine.musicThread.start();


       final SFEngine engine = new SFEngine();
       start = findViewById(R.id.btnStart);
       exit = findViewById(R.id.btnExit);
       start.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
       start.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);
       exit.getBackground().setAlpha(SFEngine.MENU_BUTTON_ALPHA);
       exit.setHapticFeedbackEnabled(SFEngine.HAPTIC_BUTTON_FEEDBACK);


      start.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              boolean clean = false;
              clean = engine.onExit(v);
              if(clean){
                  int pid = android.os.Process.myPid();
                  android.os.Process.killProcess(pid);
              }
          }
      });

    }
}
