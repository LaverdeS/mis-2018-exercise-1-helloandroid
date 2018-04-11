package com.example.mis.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.conn.ConnectTimeoutException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;
    String data;
    public static TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.ask);
        button=(Button) findViewById(R.id.butt);
        result =(TextView) findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                try {
                    String txtUrl=editText.getText().toString();
                    URL url = new URL(txtUrl);
                    Fetch process = new Fetch();
                    process.passContext(getApplicationContext());
                    process.execute(url);
                    /*httpURLConnection = (HttpURLConnection) url.openConnection();
                    InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line ="";
                    while(line!=null){
                        line = bufferedReader.readLine();
                        data = data + line;
                    }*/
                } catch (MalformedURLException e) {
                    Toast toast = Toast.makeText(MainActivity.this, "Invalid URL", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0 ,0);
                    toast.show();
                }
                /*
                catch (SyncFailedException e) {
                    Toast toast = Toast.makeText(MainActivity.this, "Sync Failed", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0 ,0);
                    toast.show();
                }
                catch (UnsupportedEncodingException e) {
                    Toast toast = Toast.makeText(MainActivity.this, "Unsoported Enconding", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0 ,0);
                    toast.show();
                }
                catch (ConnectTimeoutException e) {
                    Toast toast = Toast.makeText(MainActivity.this, "Timeout", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0 ,0);
                    toast.show();
                }
                catch (ConnectException e) {
                    Toast toast = Toast.makeText(MainActivity.this, "Not posible to connect", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0 ,0);
                    toast.show();
                }
                catch (IOException e) {
                    Toast toast = Toast.makeText(MainActivity.this, "Generic Exception", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0 ,0);
                    toast.show();
                }
*/
                Toast toast = Toast.makeText(MainActivity.this, "hey there", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0 ,0);
                toast.show();
            }
        });
    }
}