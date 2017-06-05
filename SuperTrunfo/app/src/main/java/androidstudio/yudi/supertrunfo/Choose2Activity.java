package androidstudio.yudi.supertrunfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Choose2Activity extends AppCompatActivity {
    private Button btn_speedy2;
    private Button btn_power2;
    private Button btn_weight2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose2_screen);
        btn_speedy2 = (Button) findViewById(R.id.btn_speedy2);
        btn_speedy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Speedy2Activity.class);
                startActivity(ir);
            }
        });
        btn_power2 = (Button) findViewById(R.id.btn_power2);
        btn_power2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Power2Activity.class);
                startActivity(ir);
            }
        });
        btn_weight2 = (Button) findViewById(R.id.btn_weight2);
        btn_weight2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Weight2Activity.class);
                startActivity(ir);
            }
        });
    }
}
