package smu.it.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class WorkernotiActivity extends AppCompatActivity {

    ImageButton btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workernoti);

        btn_home = (ImageButton) findViewById(R.id.btn_homenoti);

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkernotiActivity.this, RealMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
