package androidstudio.yudi.jokenpov2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_rock;
    private Button btn_paper;
    private Button btn_scissors;
    //
    private ImageView img_player;
    private ImageView img_computer;
    //
    private TextView tv_player_count;
    private TextView tv_computer_count;
    //
    int scorePlayer = 0;
    int scoreComputer = 0;
    //
    private static int NOTIFICATION_PUSH_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokenpo_screen);

        TextView tv_username = (TextView) findViewById(R.id.tv_player);
        tv_username.setText(" "+getIntent().getExtras().getString("username"));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentNotification = new Intent(getBaseContext(), JokenpoNotification.class);
                intentNotification.putExtra(JokenpoNotification.EXTRA_MESSAGE,getResources().getString(R.string.jokenponotification));
                startService(intentNotification);
            }
        }, NOTIFICATION_PUSH_OUT);

        btn_rock = (Button) findViewById(R.id.btn_rock);
        btn_paper = (Button) findViewById(R.id.btn_paper);
        btn_scissors = (Button) findViewById(R.id.btn_scissors);
        //
        img_player = (ImageView) findViewById(R.id.img_player);
        img_computer = (ImageView) findViewById(R.id.img_computer);
        //
        tv_player_count = (TextView) findViewById(R.id.tv_player_count);
        tv_computer_count = (TextView) findViewById(R.id.tv_computer_count);
        //
        //
        btn_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choiceComputer = (int) (Math.random()*3) + 1;
                if (choiceComputer == 1){
                    img_player.setImageResource(R.drawable.rock1);
                    img_computer.setImageResource(R.drawable.rock2);
                    Toast.makeText(getBaseContext(), "DRAW!", Toast.LENGTH_SHORT).show();

                }else if (choiceComputer == 2){
                    img_player.setImageResource(R.drawable.rock1);
                    img_computer.setImageResource(R.drawable.paper2);
                    Toast.makeText(getBaseContext(), "COMPUTER WINS!", Toast.LENGTH_SHORT).show();
                    scoreComputer++;
                    tv_computer_count.setText(String.valueOf(scoreComputer));

                }else if(choiceComputer == 3){
                    img_player.setImageResource(R.drawable.rock1);
                    img_computer.setImageResource(R.drawable.scissors2);
                    Toast.makeText(getBaseContext(), "PLAYER WINS!", Toast.LENGTH_SHORT).show();
                    scorePlayer++;
                    tv_player_count.setText(String.valueOf(scorePlayer));
                }
            }
        });

        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choiceComputer = (int) (Math.random()*3) + 1;
                if (choiceComputer == 1){
                    img_player.setImageResource(R.drawable.paper1);
                    img_computer.setImageResource(R.drawable.paper2);
                    Toast.makeText(getBaseContext(), "DRAW!", Toast.LENGTH_SHORT).show();

                }else if (choiceComputer == 2){
                    img_player.setImageResource(R.drawable.paper1);
                    img_computer.setImageResource(R.drawable.scissors2);
                    Toast.makeText(getBaseContext(), "COMPUTER WINS!", Toast.LENGTH_SHORT).show();
                    scoreComputer++;
                    tv_computer_count.setText(String.valueOf(scoreComputer));

                }else if(choiceComputer == 3){
                    img_player.setImageResource(R.drawable.paper1);
                    img_computer.setImageResource(R.drawable.rock2);
                    Toast.makeText(getBaseContext(), "PLAYER WINS!", Toast.LENGTH_SHORT).show();
                    scorePlayer++;
                    tv_player_count.setText(String.valueOf(scorePlayer));
                }
            }
        });

        btn_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int choiceComputer = (int) (Math.random()*3) + 1;
                if (choiceComputer == 1){
                    img_player.setImageResource(R.drawable.scissors1);
                    img_computer.setImageResource(R.drawable.scissors2);
                    Toast.makeText(getBaseContext(), "DRAW!", Toast.LENGTH_SHORT).show();

                }else if (choiceComputer == 2){
                    img_player.setImageResource(R.drawable.scissors1);
                    img_computer.setImageResource(R.drawable.rock2);
                    Toast.makeText(getBaseContext(), "COMPUTER WINS!", Toast.LENGTH_SHORT).show();
                    scoreComputer++;
                    tv_computer_count.setText(String.valueOf(scoreComputer));

                }else if(choiceComputer == 3){
                    img_player.setImageResource(R.drawable.scissors1);
                    img_computer.setImageResource(R.drawable.paper2);
                    Toast.makeText(getBaseContext(), "PLAYER WINS!", Toast.LENGTH_SHORT).show();
                    scorePlayer++;
                    tv_player_count.setText(String.valueOf(scorePlayer));
                }
            }
        });
    }
}
