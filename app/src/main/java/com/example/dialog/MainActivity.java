package com.example.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.dummy_txt);
    }

    public void btn_show(View view) {

        final AlertDialog.Builder  alert=new AlertDialog.Builder(MainActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog,null);

        final EditText txt_inputText= (EditText) mView.findViewById(R.id.txt_input);
        Button btn_cancel = (Button) mView.findViewById(R.id.btn_cancel);
        Button btn_ok =(Button) mView.findViewById(R.id.btn_ok);

        alert.setView(mView);

        final AlertDialog alertDialog=alert.create();
        alertDialog.setCanceledOnTouchOutside(false);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(txt_inputText.getText().toString().trim());

            }
        });
        alertDialog.show();
    }
}