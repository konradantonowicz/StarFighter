package pakiet.konrad.starfighter;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable myRunnable1 = new MyRunnableClass();
        new Handler().postDelayed(myRunnable1,3000);


    }

    private class MyRunnableClass implements Runnable {
        @Override
        public void run() {

            Intent mainMenu = new Intent(MainActivity.this,SFMainMenu.class);
            MainActivity.this.startActivity(mainMenu);

            overridePendingTransition(R.layout.fadein,R.layout.fadeout);
            MainActivity.this.finish();

        }
    }
}
