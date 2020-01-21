package hua15.candykick.ssajam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ClauseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clause);

        Button btAgree = (Button)findViewById(R.id.btAgree);
        Button btDisagree = (Button)findViewById(R.id.btDisagree);
        TextView clausetxt = (TextView)findViewById(R.id.textView4);

        clausetxt.setText(Html.fromHtml("1.구매자의 경우, 판매자의 집의 물품을 파손하는 경우 금전적 배상을 해 주어야 하며, 판매자의 집을 불법적인 용도로 이용하는 경우 현 서비스에서 강제 탈퇴됨과 동시에 법적인 처벌을 받을 수 있다.<br>2.판매자의 경우, 허위 매물을 올리거나, 구매자의 사생활을 침해할 수 있는 행동을 하다가 적발될 경우(예를 들어, 방에 몰래카메라를 설치하거나 엿보는 등의) 똑같이 현 서비스에서 강제 탈퇴됨은 물론, 법적인 처벌을 받을 수 있다.<br>3.이 앱의 구매자는 한양대학교 학생만을 대상으로 하며, 판매자는 한양대학교 근처에서 자취를 하는 학생들이나 학생들에게 방을 제공할 수 있는 업자들을 대상으로 한다."));

        btAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClauseActivity.this, JoinActivity.class);
                startActivity(i);
                finish();
            }
        });
        btDisagree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClauseActivity.this, StartActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
