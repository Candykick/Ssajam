package hua15.candykick.ssajam;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class RoomInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        int phoneindex=7;

        float score[] = new float[]{3f,5f,2.5f};
        String tmp = "";
        tmp = readTxt();
        final String[] info = tmp.split(",");

        Intent in = this.getIntent();
        String tagname = in.getStringExtra("tag");

        ImageView ivRoom1 = (ImageView)findViewById(R.id.ivRoom1);
        ImageView ivRoom2 = (ImageView)findViewById(R.id.ivRoom2);
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        TextView tvPrice = (TextView)findViewById(R.id.tvPrice);
        TextView tvLocation = (TextView)findViewById(R.id.tvLocation);
        TextView tvSex = (TextView)findViewById(R.id.tvSex);
        TextView tvDay = (TextView)findViewById(R.id.tvDay);
        TextView tvTime = (TextView)findViewById(R.id.tvTime);
        TextView tvDetails = (TextView)findViewById(R.id.tvDetails);
        TextView tvSize = (TextView)findViewById(R.id.tvSize);
        Button btSign = (Button)findViewById(R.id.btSign);
        Button btForSearch = (Button)findViewById(R.id.btForSearch);

        if(tagname.equals("1")) {
            ivRoom1.setImageResource(R.drawable.room1);
            ivRoom2.setImageResource(R.drawable.room2);
            ratingBar.setRating(score[0]);
            tvPrice.setText(info[0]);
            tvLocation.setText(info[1]);
            tvSize.setText(info[2]);
            tvSex.setText(info[3]);
            tvDay.setText(info[4]);
            tvTime.setText(info[5]);
            tvDetails.setText(info[6]);
            phoneindex=7;
        }
        else if(tagname.equals("2")) {
            ivRoom1.setImageResource(R.drawable.room3);
            ivRoom2.setImageResource(R.drawable.room4);
            ratingBar.setRating(score[1]);
            tvPrice.setText(info[8]);
            tvLocation.setText(info[9]);
            tvSize.setText(info[10]);
            tvSex.setText(info[11]);
            tvDay.setText(info[12]);
            tvTime.setText(info[13]);
            tvDetails.setText(info[14]);
            phoneindex=15;
        }
        else if(tagname.equals("3")) {
            ivRoom1.setImageResource(R.drawable.room5);
            ivRoom2.setImageResource(R.drawable.room6);
            ratingBar.setRating(score[2]);
            tvPrice.setText(info[16]);
            tvLocation.setText(info[17]);
            tvSize.setText(info[18]);
            tvSex.setText(info[19]);
            tvDay.setText(info[20]);
            tvTime.setText(info[21]);
            tvDetails.setText(info[22]);
            phoneindex=23;
        }

        final int phoneindexf = phoneindex;

        btSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(RoomInfoActivity.this)
                        .setTitle("확인질문")
                        .setMessage("계약하시겠습니까?")
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                                Toast.makeText(RoomInfoActivity.this, "취소되었습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+info[phoneindexf]));
                                startActivity(intent);
                                Toast.makeText(RoomInfoActivity.this, "해당 방 주인의 연락처를 띄웠습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        btForSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RoomInfoActivity.this, MapActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private String readTxt() {
        String data = null;
        InputStream is = getResources().openRawResource(R.raw.roominfo);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = is.read();
            while(i != -1) {
                byteArrayOutputStream.write(i);
                i = is.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(),"UTF-8");
            is.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
