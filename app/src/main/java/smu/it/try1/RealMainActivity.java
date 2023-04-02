package smu.it.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class RealMainActivity extends AppCompatActivity {

    Button attend;
    Button report;
    Button info;
    Button noti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realmain);

        attend = (Button) findViewById(R.id.menu1);
        report = (Button) findViewById(R.id.menu2);
        info = (Button) findViewById(R.id.menu3);
        noti = (Button) findViewById(R.id.menu4);

        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealMainActivity.this, PatientinfoActivity.class);
                startActivity(intent);
            }
        });

        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RealMainActivity.this, WorkernotiActivity.class);
                startActivity(intent);
            }
        });
    }
}
