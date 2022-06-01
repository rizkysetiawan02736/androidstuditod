package com.rizky_02736.desemar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Kirim extends AppCompatActivity {

    Button button;
    EditText Edtusername, Edtpassword, Edtnumber, Edtdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kirim);

        Edtusername = findViewById(R.id.editusername);
        Edtpassword = findViewById(R.id.editpassword);
        Edtnumber = findViewById(R.id.editnumber);
        Edtdescription = findViewById(R.id.editdescription);

        button = findViewById(R.id.btnkirim);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://api.whatsapp.com/send?phone="+Edtnumber.getText().toString()+"&text="+"Username:"+Edtusername.getText().toString()+"\n" + "Password:"+Edtpassword.getText().toString()+ "\n" + "Description:" + Edtdescription.getText().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}