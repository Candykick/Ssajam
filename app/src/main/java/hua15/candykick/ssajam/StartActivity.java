package hua15.candykick.ssajam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        final String userid = "User01";
        final String userpw = "Hanyang";
        final String sellerid = "Seller01";
        final String sellerpw = "Wangsimni";

        Button btLogin = (Button)findViewById(R.id.btLogin);
        Button btJoin = (Button)findViewById(R.id.btJoin);
        final EditText etId = (EditText)findViewById(R.id.etId);
        final EditText etPw = (EditText)findViewById(R.id.etPw);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etId.getText().toString().equals(userid) && etPw.getText().toString().equals(userpw)) {
                    Intent i = new Intent(StartActivity.this, MapActivity.class);
                    startActivity(i);
                    finish();
                }
                else if(etId.getText().toString().equals(sellerid) && etPw.getText().toString().equals(sellerpw)) {
                    Intent i = new Intent(StartActivity.this, SellerMainActivity.class);
                    startActivity(i);
                    finish();
                }
                else {
                    Toast.makeText(StartActivity.this, "아이디나 비밀번호가 맞지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartActivity.this, ClauseActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
