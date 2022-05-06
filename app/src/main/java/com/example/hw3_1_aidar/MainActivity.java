package com.example.hw3_1_aidar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etView1;
    private EditText etView2;
    private EditText etView3;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etView1= findViewById(R.id.et_view_1);
        etView2= findViewById(R.id.et_view_2);
        etView3= findViewById(R.id.et_view_3);
        button= findViewById(R.id.btn_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!(etView1.getText().toString().isEmpty()&& etView2.getText().toString().isEmpty()&& etView3.getText().toString().isEmpty())){
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{etView1.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, etView2.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT,etView3.getText().toString());
                    intent.setData(Uri.parse("mailto:"));
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this,"Заполните все поля",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}