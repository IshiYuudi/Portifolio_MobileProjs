package androidstudio.yudi.supertrunfo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayPower3Activity extends AppCompatActivity {
    private TextView tv_valor;
    private ImageView iv_computer;
    private TextView tv_power_computer;
    private static int TIMER = 6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playpower3_screen);
        tv_valor = (TextView) findViewById(R.id.tv_valor);
        iv_computer = (ImageView) findViewById(R.id.iv_computer);
        tv_power_computer = (TextView) findViewById(R.id.tv_power_computer);
        //
        Intent i = getIntent();
        Bundle valor = i.getExtras();

        String getValor = (String) valor.get("valor");
        int valorJogador = Integer.valueOf(getValor);
        tv_valor.setText(getValor);

        int escolhaComputador = (int) (Math.random()*150)+1;
        int personagemComputador = (int) (Math.random()*3)+1;

        if(personagemComputador == 1){
            iv_computer.setImageResource(R.drawable.mini);
        }else if(personagemComputador == 2){
            iv_computer.setImageResource(R.drawable.suv);
        }else if(personagemComputador == 3) {
            iv_computer.setImageResource(R.drawable.sedan);
        }

        tv_power_computer.setText(Integer.toString(escolhaComputador));

        if(escolhaComputador == valorJogador){
            Toast.makeText(getBaseContext(),
                    "DRAW",Toast.LENGTH_LONG).show();
        }else if(escolhaComputador < valorJogador){
            Toast.makeText(getBaseContext(),
                    "YOU WIN!",Toast.LENGTH_LONG).show();
            Score.score += 268;
        }else{
            Toast.makeText(getBaseContext(),
                    "YOU LOSE!",Toast.LENGTH_LONG).show();
            Score.score -= 234;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(i);
                finish();
            }
        },TIMER);

    }
}
