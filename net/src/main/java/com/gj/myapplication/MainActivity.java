package com.gj.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.id.input;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    private HttpURLConnection conn;
    private InputStream input;
    private TextView text;
    private StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
//        HttpClient httpClient = new DefaultHttpClient();

        mThread.start();



//        text.setText(sb.toString());
    }

    public Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle b = msg.getData();
            String result = b.getString("result");
            text.setText(result);
        }
    };

    public Thread mThread = new Thread(){
        @Override
        public void run() {
            super.run();
            try {
                sb =  new StringBuilder();
                URL url = new URL("http://www.baidu.com");
                conn = (HttpURLConnection) url.openConnection();
                input = conn.getInputStream();
                byte[] buff = new byte[1024];
                int hasRead = 0;
                while((hasRead = input.read(buff)) > 0){
                    sb.append(new String(buff, 0, hasRead));
                }
            } catch (Exception e) {
                Log.i("gejun",""+e.toString());
                e.printStackTrace();
            } finally {
//            try {
//                input.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
                conn.disconnect();
            }
            Log.i("gejun",""+sb.toString());
            Message m = new Message();
            Bundle b = new Bundle();
            b.putString("result",sb.toString());
            m.setData(b);
            mHandler.sendMessage(m);
        }
    };
}
