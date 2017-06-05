package androidstudio.yudi.tictactoev2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SplashTicTacToeActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashtictactoe_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
                finish();

            }
        },SPLASH_TIME_OUT);
        Toast.makeText(getBaseContext(), "Tic Tac Toe", Toast.LENGTH_SHORT).show();
    }
}