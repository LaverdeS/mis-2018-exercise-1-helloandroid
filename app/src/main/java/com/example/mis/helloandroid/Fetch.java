package com.example.mis.helloandroid;

import android.content.Context;
import android.os.AsyncTask;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

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

public class Fetch extends AsyncTask<URL,Void,Void>{
    String data;
    private Context myContext;
    public void passContext (Context context){
        myContext = context;
    }
    @Override
    protected Void doInBackground(URL...urls) {
        try{
            //System.out.print(urls[]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urls[0].openConnection();
            try {
                //URL url=new URL();
                //httpURLConnection =
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    data = data + line;
                }
            }catch (UnknownServiceException e) {
                Toast toast = Toast.makeText(myContext, "Unknown Service", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0 ,0);
                toast.show();
            }
            finally{
                httpURLConnection.disconnect();
            }
        } /*catch (MalformedURLException e) {
            Toast toast = Toast.makeText(myContext, "Invalid URL", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 ,0);
            toast.show();
        }
        catch (SyncFailedException e) {
            Toast toast = Toast.makeText(myContext, "Sync Failed", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 ,0);
            toast.show();
        }
        catch (UnsupportedEncodingException e) {
            Toast toast = Toast.makeText(myContext, "Unsoported Enconding", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 ,0);
            toast.show();
        }
        catch (ConnectTimeoutException e) {
            Toast toast = Toast.makeText(myContext, "Timeout", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 ,0);
            toast.show();
        }
        catch (ConnectException e) {
            Toast toast = Toast.makeText(myContext, "Not posible to connect", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 ,0);
            toast.show();
        }*/
        catch (IOException e) {
            Toast toast = Toast.makeText(myContext, "Generic Exception", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 ,0);
            toast.show();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.result.setText(this.data);
    }
}
