package androidstudio.yudi.supertrunfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose3Activity extends AppCompatActivity {
    private Button btn_speedy3;
    private Button btn_power3;
    private Button btn_weight3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose3_screen);
        btn_speedy3 = (Button) findViewById(R.id.btn_speedy3);
        btn_speedy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Speedy3Activity.class);
                startActivity(ir);
            }
        });
        btn_power3 = (Button) findViewById(R.id.btn_power3);
        btn_power3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Power3Activity.class);
                startActivity(ir);
            }
        });
        btn_weight3 = (Button) findViewById(R.id.btn_weight3);
        btn_weight3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Weight3Activity.class);
                startActivity(ir);
            }
        });
    }
}
