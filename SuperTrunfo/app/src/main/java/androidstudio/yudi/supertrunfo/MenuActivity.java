package androidstudio.yudi.supertrunfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MenuActivity extends AppCompatActivity {
    private ViewFlipper vf_personagem;
    private Button btn_proximo;
    private Button btn_anterior;
    private TextView tv_score;

    private Button btn_car1;
    private Button btn_car2;
    private Button btn_car3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);

        vf_personagem = (ViewFlipper) findViewById(R.id.vf_character);

        btn_proximo = (Button) findViewById(R.id.btn_proximo);
        btn_anterior = (Button) findViewById(R.id.btn_anterior);

        btn_proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_personagem.showNext();
                vf_personagem.animate().rotationY(360).setDuration(500);
            }
        });
        btn_anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vf_personagem.showPrevious();
                vf_personagem.animate().rotationY(-360).setDuration(500);
            }
        });

        btn_car1 = (Button) findViewById(R.id.btn_car1);
        btn_car1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Choose1Activity.class);
                startActivity(ir);
                overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeoutl);
            }
        });

        btn_car2 = (Button) findViewById(R.id.btn_car2);
        btn_car2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Choose2Activity.class);
                startActivity(ir);
                overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeoutl);
            }
        });

        btn_car3 = (Button) findViewById(R.id.btn_car3);
        btn_car3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Choose3Activity.class);
                startActivity(ir);
                overridePendingTransition(R.anim.res_anim_fadein, R.anim.res_anim_fadeoutl);
            }
        });
        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_score.setText(Integer.toString(Score.score));
    }
}
