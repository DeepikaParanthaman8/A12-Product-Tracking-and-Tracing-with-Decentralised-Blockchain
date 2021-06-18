package com.project.supplychain;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class QRScanner extends AppCompatActivity {
    private Button newuser;
    private String contents,format,ipadd;
    private EditText Ip;
   // private DatabaseReference databaseReference;
    Map<String, String> valmap = new HashMap<>();
    List<String> val =new ArrayList<>();
    String getcode,mbl,uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qrscanner);
        newuser = findViewById(R.id.btn_newuser);
        Ip=findViewById(R.id.ip_address);
       //databaseReference = FirebaseDatabase.getInstance().getReference();

        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ipadd = Ip.getText().toString();
                    Log.e("ip",ipadd);
                if(!ipadd.equalsIgnoreCase("")){
                    IpAddress.Ip_Address = ipadd.trim();
                    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intent, 0);
                }else{
                    Toast.makeText(getApplicationContext(),"Please Enter Ip address",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        try {
            String dates = "";
            String time = "";
            if (requestCode == 0) {
                if (resultCode == RESULT_OK) {
                    contents = intent.getStringExtra("SCAN_RESULT");
                    format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                    //addChildEventListener();

                    String pnum = contents;
                    Log.e("code", pnum);
                    Intent it = new Intent(getApplicationContext(),MainActivity.class);
                    it.putExtra("code",pnum);
                    startActivity(it);
                }
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Toast.makeText(getApplicationContext(),
                        "Sorry Scan cancelled", Toast.LENGTH_LONG).show();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}



