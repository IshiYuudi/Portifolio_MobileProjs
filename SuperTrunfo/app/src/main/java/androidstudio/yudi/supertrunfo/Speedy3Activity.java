package androidstudio.yudi.supertrunfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Speedy3Activity extends AppCompatActivity {
    private SeekBar sk_speedy;
    private Button btn_play;
    int valor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speedy3_screen);
        btn_play = (Button) findViewById(R.id.btn_jogar);
        sk_speedy = (SeekBar) findViewById(R.id.sk_speedy3);

        sk_speedy.setMax(300);
        sk_speedy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                valor = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String valorTexto = Integer.toString(valor);
                Intent i = new Intent(getBaseContext(), PlaySpeedy3Activity.class);
                i.putExtra("valor", valorTexto);
                startActivity(i);
            }
        });
    }
}
