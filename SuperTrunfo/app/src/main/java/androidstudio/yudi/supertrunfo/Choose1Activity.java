package androidstudio.yudi.supertrunfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose1Activity extends AppCompatActivity {
    private Button btn_speedy1;
    private Button btn_power1;
    private Button btn_weight1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose1_screen);
        btn_speedy1 = (Button) findViewById(R.id.btn_speedy1);
        btn_speedy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Speedy1Activity.class);
                startActivity(ir);
            }
        });
        btn_power1 = (Button) findViewById(R.id.btn_power1);
        btn_power1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Power1Activity.class);
                startActivity(ir);
            }
        });
        btn_weight1 = (Button) findViewById(R.id.btn_weight1);
        btn_weight1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Weight1Activity.class);
                startActivity(ir);
            }
        });
    }
}
