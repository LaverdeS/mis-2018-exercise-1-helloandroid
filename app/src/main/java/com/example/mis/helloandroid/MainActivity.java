package com.example.mis.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
    public static WebView webViewresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.ask);
        button=(Button) findViewById(R.id.button);
        result =(TextView) findViewById(R.id.result);
        webViewresult =(WebView) findViewById(R.id.webViewResult);
        webViewresult.setWebViewClient(new WebViewClient());
        webViewresult.getSettings().setJavaScriptEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String txtUrl = editText.getText().toString();
                    webViewresult.loadUrl(txtUrl);
                    URL url = new URL(txtUrl);
                    Fetch process = new Fetch(getApplicationContext());
                    process.execute(url);
                } catch (MalformedURLException e) {
                    Toast toast = Toast.makeText(MainActivity.this, "Invalid URL", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0 ,0);
                    toast.show();
                }

                /*Toast toast = Toast.makeText(MainActivity.this, "hey there", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0 ,0);
                toast.show();*/
            }
        });
    }
}