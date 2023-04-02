package smu.it.try1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WorkeraddActivity extends AppCompatActivity {

    Button btn_findid;
    Button btn_send1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workeradd);

        btn_findid = (Button) findViewById(R.id.btn_widsearch);
        btn_send1 = (Button) findViewById(R.id.btn_wsend1);

        btn_findid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //아이디찾기 버튼을 누르면
            }
        });

        btn_send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WorkeraddActivity.this, RealMainActivity.class);
                startActivity(intent);
            }
        });
    }
}
