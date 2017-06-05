package androidstudio.yudi.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText et_weight;
    private EditText et_height;
    private Button btn_calc;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        et_weight = (EditText) findViewById(R.id.et_weight);
        et_height = (EditText) findViewById(R.id.et_height);
        btn_calc = (Button) findViewById(R.id.btn_calc);
        tv_result = (TextView) findViewById(R.id.tv_result);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(et_weight.getText().toString());
                float height = Float.parseFloat(et_height.getText().toString());
                float result = weight / (height * height);
                String toastResult = String.valueOf(result);

                if (result < 19){
                    tv_result.setText("Underweight, see your doctor!");
                    Toast.makeText(getBaseContext(), toastResult, Toast.LENGTH_LONG).show();
                }else if (result > 32) {
                    tv_result.setText("Overweight, see your doctor!");
                    Toast.makeText(getBaseContext(), toastResult, Toast.LENGTH_LONG).show();
                }else {
                    tv_result.setText("Congratulations, you're at the right weight, even so keep visiting your doctor regularly!");
                    Toast.makeText(getBaseContext(), toastResult, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
