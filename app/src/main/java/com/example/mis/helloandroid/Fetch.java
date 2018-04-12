package com.example.mis.helloandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import org.apache.http.conn.ConnectTimeoutException;

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
import java.net.UnknownServiceException;

public class Fetch extends AsyncTask<URL,Void,String>{
    String data;
    private Context myContext;
    public Fetch(Context context){
        myContext = context;
    }

    @Override
    protected String doInBackground(URL...urls) {
        String id;
        try{
            HttpURLConnection httpURLConnection = (HttpURLConnection) urls[0].openConnection();
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
                id = "Not renderable";
            } catch (UnknownServiceException e) {
                id = "Unknown service";
            } finally {
                httpURLConnection.disconnect();
            }
        } catch (MalformedURLException e) {
            id = "Incorrect URL";
        } catch (SyncFailedException e) {
            id = "Cannot contact the server";
        } catch (UnsupportedEncodingException e) {
            id = "Unsupported Encoding of the selected link";
        } catch (ConnectTimeoutException e) {
            id = "Timeout";
        } catch (ConnectException e) {
            id = "Connection failed";
        } catch (IOException e) {
            id = "Generic error";
        }
        return id;
    }

    @Override
    protected void onPostExecute(String id) {
        super.onPostExecute(id);
        switch (id) {
            case "Incorrect URL":
                Toast toast1 = Toast.makeText(myContext, id, Toast.LENGTH_SHORT);
                toast1.setGravity(Gravity.CENTER, 0, 0);
                toast1.show();
                break;
            case "Cannot contact the server":
                Toast toast2 = Toast.makeText(myContext, id, Toast.LENGTH_SHORT);
                toast2.setGravity(Gravity.CENTER, 0, 0);
                toast2.show();
                break;
            case "Unsupported Encoding of the selected link":
                Toast toast3 = Toast.makeText(myContext, id, Toast.LENGTH_SHORT);
                toast3.setGravity(Gravity.CENTER, 0, 0);
                toast3.show();
                break;
            case "Timeout":
                Toast toast4 = Toast.makeText(myContext, id, Toast.LENGTH_SHORT);
                toast4.setGravity(Gravity.CENTER, 0, 0);
                toast4.show();
                break;
            case "Connection failed":
                Toast toast5 = Toast.makeText(myContext, id, Toast.LENGTH_SHORT);
                toast5.setGravity(Gravity.CENTER, 0, 0);
                toast5.show();
                break;
            case "Generic error":
                Toast toast6 = Toast.makeText(myContext, id, Toast.LENGTH_SHORT);
                toast6.setGravity(Gravity.CENTER, 0, 0);
                toast6.show();
                break;
            case "Unknown service":
                Toast toast7 = Toast.makeText(myContext, id, Toast.LENGTH_SHORT);
                toast7.setGravity(Gravity.CENTER, 0, 0);
                toast7.show();
                break;
            default:
                MainActivity.result.setText(Html.fromHtml(this.data));
        }
    }
}
