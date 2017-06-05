package androidstudio.yudi.tictactoev2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int TOTAL_PLAYED = 9;
    private Game l1, l2, l3, c1, c2, c3, d1, d2;
    //
    private ImageButton[] iB = new ImageButton[9];
    private int played;
    private int player = 0;
    //
    private String[] pl = {"X", "O"};
    //
    private int[] img = {R.drawable.x2, R.drawable.o2};
    //
    public void clickListener(View view){
        ImageButton b = (ImageButton) view;
        b.setImageResource(img[player]);
        Game g = ((Games) b.getTag()).gamesAddSerie(player);

        TextView text = (TextView) findViewById(R.id.tv_played);
        text.setText((g != null) ? endGame (g.getImageButtons(), player): verifyTtt(++played));
    }
    public void restart(View view){
        finish();
        startActivity(getIntent());
    }
    //
    private static int NOTIFICATION_PUSH_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictactoe_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentNotification = new Intent(getBaseContext(), TicTacToeNotification.class);
                intentNotification.putExtra(TicTacToeNotification.EXTRA_MESSAGE,getResources().getString(R.string.tictactoenotification));
                startService(intentNotification);
            }
        }, NOTIFICATION_PUSH_OUT);

        iB[0] = (ImageButton) findViewById(R.id.b0);
        iB[1] = (ImageButton) findViewById(R.id.b1);
        iB[2] = (ImageButton) findViewById(R.id.b2);
        iB[3] = (ImageButton) findViewById(R.id.b3);
        iB[4] = (ImageButton) findViewById(R.id.b4);
        iB[5] = (ImageButton) findViewById(R.id.b5);
        iB[6] = (ImageButton) findViewById(R.id.b6);
        iB[7] = (ImageButton) findViewById(R.id.b7);
        iB[8] = (ImageButton) findViewById(R.id.b8);
        //
        //
        l1 = new Game(iB[0], iB[1], iB[2]);
        l2 = new Game(iB[3], iB[4], iB[5]);
        l3 = new Game(iB[6], iB[7], iB[8]);
        //
        c1 = new Game(iB[0], iB[3], iB[6]);
        c2 = new Game(iB[1], iB[4], iB[7]);
        c3 = new Game(iB[2], iB[5], iB[8]);
        //
        d1 = new Game(iB[0], iB[4], iB[8]);
        d2 = new Game(iB[2], iB[4], iB[6]);
        //
        //
        iB[0].setTag(new Games(l1, c1, d1));
        iB[1].setTag(new Games(l1, c2));
        iB[2].setTag(new Games(l1, c3, d2));
        //
        iB[3].setTag(new Games(l2, c1));
        iB[4].setTag(new Games(l2, c2, d1, d2));
        iB[5].setTag(new Games(l2, c3));
        //
        iB[6].setTag(new Games(l3, c1, d2));
        iB[7].setTag(new Games(l3, c2));
        iB[8].setTag(new Games(l3, c3, d1));

    }
    private String endGame(List<ImageButton> buttons, int player){
        for (ImageButton button : buttons)
            button.animate().rotationY(360).setDuration(1000);
        disableButtons();
        return getResources().getString(R.string.win, pl[player]);
    }

    private void disableButtons() {
        for (int b = 0; b < 9; b++)
            iB[b].setEnabled(false);
    }

    private String verifyTtt(int played){
        player = (player == 0) ? 1 : 0;
        if (played == TOTAL_PLAYED)
            disableButtons();
        return (played == TOTAL_PLAYED) ? "DRAW!" : getResources().getString(R.string.player, pl[player]);
    }
}