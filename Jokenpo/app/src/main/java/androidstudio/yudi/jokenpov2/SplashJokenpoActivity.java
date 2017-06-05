package androidstudio.yudi.jokenpov2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashJokenpoActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashjokenpo_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), JokenpoNameActivity.class);
                startActivity(i);
                finish();

            }
        },SPLASH_TIME_OUT);
        Toast.makeText(getBaseContext(), "Jokenpo!", Toast.LENGTH_SHORT).show();
    }
}
