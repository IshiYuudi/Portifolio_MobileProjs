package androidstudio.yudi.jokenpov2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JokenpoNameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokenponame_screen);

        final EditText et_username = (EditText) findViewById(R.id.et_username);
        Button btn_username = (Button) findViewById(R.id.btn_username);

        btn_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("username", et_username.getText().toString());
                Toast.makeText(getBaseContext(), "Welcome, "+username, Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
            }
        });

    }
}