package carehalcare.carehalcare.Feature_mainpage;


import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import carehalcare.carehalcare.Feature_write.EightMenuActivity;
import carehalcare.carehalcare.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button commute, write, info, noti;
    private ImageButton btn_more, btn_setting, btn_siren;
    private TextView tv_noti1, tv_noti2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_noti1 = (TextView)findViewById(R.id.tv_noti1);
        tv_noti2 = (TextView)findViewById(R.id.tv_noti2);
        commute = (Button) findViewById(R.id.menu1);
        write = (Button) findViewById(R.id.menu2);
        info = (Button) findViewById(R.id.menu3);
        noti = (Button) findViewById(R.id.menu4);
        btn_more = (ImageButton) findViewById(R.id.btn_morenoti);
        btn_setting = (ImageButton) findViewById(R.id.btn_setting);
        btn_siren = (ImageButton) findViewById(R.id.btn_siren);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.20.5.216:8080/")
                .addConverterFactory(GsonConverterFactory.create()) //파싱등록
                .build();

        NoticeApi noticeApi = retrofit.create(NoticeApi.class);

        Call<List<Notice>> call = noticeApi.getNotice("userid1");

        call.enqueue(new Callback<List<Notice>>() {
            @Override
            public void onResponse(Call<List<Notice>> call, Response<List<Notice>> response) {
                if (response.isSuccessful()) {

                    List<Notice> notices = response.body();
                    String content = "";
                    int count = 0;

                    for (Notice notice : notices) {

                        content += "내용: " + notice.getContent() + "\n";
                        content += "작성날짜: " + notice.getCreatedDate() + "\n";

                        if (count == 0) {
                            tv_noti1.setText(content);
                        } else if (count == 1) {
                            tv_noti2.append(content);
                            break;
                        }

                        count++;
                    }
                }
                else {
                    Log.d(TAG, "연결 실패 : " + response.code());
                }
            }
            @Override
            public void onFailure(Call<List<Notice>> call, Throwable t) {
                tv_noti1.setText(t.getMessage());
            }
        });

        /*
        commute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
         */
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EightMenuActivity.class);
                startActivity(intent);
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PatientinfoActivity.class);
                startActivity(intent);
            }
        });

        noti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PNoticeActivity.class);
                startActivity(intent);
            }
        });

        btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PNoticeActivity.class);
                startActivity(intent);
            }
        });
    }
}
