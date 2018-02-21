package com.example.ist_mac_01.lab6;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText editT1 = (EditText)findViewById(R.id.editText1);
    TextView text1 = (TextView) findViewById(R.id.textView1);
    Button btn1 = (Button)findViewById(R.id.button1);
    Button btn2 = (Button)findViewById(R.id.button2);
    String fileName = "myFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        File file = new File(this.getFilesDir(),fileName);
//write file
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try{
                    FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String inputStr  = editT1.getText().toString();
                    fos.write(inputStr.getBytes());
                    fos.close();
                }
                catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
        //read file
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    InputStream is = this.openFileInput(fileName);
                    if (is != null) {
                        InputStreamReader isr = new InputStreamReader(is);
                        BufferedReader br = new BufferedReader(isr);
                        String rs = "";
                        StringBuffer sb = new StringBuffer();

                        while ((rs = br.readLine()) != null) {
                            sb.append(rs);
                        }
                        is.close();
                        String ret = sb.toString();
                        //text1[0] = (TextView) findViewById(R.id.textView1);
                        text1.setText(ret);
                        }
                    } catch (IOException e) { }
                }
            });





    }
}
