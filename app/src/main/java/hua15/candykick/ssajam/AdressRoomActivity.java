package hua15.candykick.ssajam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;

public class AdressRoomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress_room);

        final EditText et1 = (EditText)findViewById(R.id.editText);
        final EditText et2 = (EditText)findViewById(R.id.editText2);
        final EditText et3 = (EditText)findViewById(R.id.editText3);
        final EditText et4 = (EditText)findViewById(R.id.editText4);
        final RadioButton rb3 = (RadioButton)findViewById(R.id.radioButton3);
        final RadioButton rb4 = (RadioButton)findViewById(R.id.radioButton4);
        final RadioButton rb5 = (RadioButton)findViewById(R.id.radioButton5);
        Button btnadress = (Button)findViewById(R.id.button);
        Button btncc = (Button)findViewById(R.id.button2);
        Button btpic = (Button)findViewById(R.id.button3);

        btnadress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(AdressRoomActivity.this)
                        .setTitle("확인질문")
                        .setMessage("방을 등록하시겠습니까?")
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                                Toast.makeText(AdressRoomActivity.this, "등록을 취소했습니다.", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int sumthin) {
                                Toast.makeText(AdressRoomActivity.this, "새로운 방을 등록했습니다.", Toast.LENGTH_SHORT).show();
                                et1.setText("");
                                et2.setText("");
                                et3.setText("");
                                et4.setText("");
                                rb3.setChecked(false);
                                rb4.setChecked(false);
                                rb5.setChecked(false);
                                ImageView image = (ImageView)findViewById(R.id.imageView);
                                image.setImageResource(0);
                                ImageView image2 = (ImageView)findViewById(R.id.imageView2);
                                image2.setImageResource(0);
                            }
                        })
                        .show();

            }
        });

        btncc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdressRoomActivity.this, SellerMainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 100);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 100)
        {
            if(resultCode== Activity.RESULT_OK)
            {
                try {
                    //Uri에서 이미지 이름을 얻어온다.
                    //String name_Str = getImageNameToUri(data.getData());

                    //이미지 데이터를 비트맵으로 받아온다.
                    Bitmap image_bitmap 	= MediaStore.Images.Media.getBitmap(getContentResolver(), data.getData());
                    ImageView image = (ImageView)findViewById(R.id.imageView);
                    ImageView image2 = (ImageView)findViewById(R.id.imageView2);

                    //배치해놓은 ImageView에 set
                    if(null!=image.getDrawable()) {
                        image2.setImageBitmap(image_bitmap);
                    }else{
                        image.setImageBitmap(image_bitmap);
                    }
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
