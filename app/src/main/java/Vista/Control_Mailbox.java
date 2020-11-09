package Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartmailbox.Control.InteractionOn;
import com.example.smartmailbox.Control.InteractionOff;
import com.example.smartmailbox.R;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

public class Control_Mailbox extends AppCompatActivity {
Button btnOn,btnOff;
    String IpAddress = "192.168.0.5";
    int Port = 80;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control__mailbox);
        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String on = "on";
                MyClientTask myClientTask = new MyClientTask(on);
               myClientTask.execute();
            }
        });

                       
        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String off = "off";
                MyClientTask myClientTask = new MyClientTask(off);
               myClientTask.execute();
            }
        });
    }



    @SuppressLint("StaticFieldLeak")
    public class MyClientTask extends AsyncTask<Void, Void, Void> {
        String response = "";
        String msgToServer;

        MyClientTask(String msgTo) {
            msgToServer = msgTo;
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Socket socket = null;
            DataOutputStream dataOutputStream = null;
            DataInputStream dataInputStream = null;

            try {


                socket = new Socket(IpAddress, Port);
               dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                if(!msgToServer.equals(""))
                    dataOutputStream.writeUTF(msgToServer + "$");

                response = dataInputStream.readUTF();

            } catch (IOException e) { }
            finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {}
                }
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (IOException e) {}
                }
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {}
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //textResponse.setText(response);
            super.onPostExecute(result);
        }
    }


/*
    public class MyClientTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            URL url;
            HttpURLConnection urlConnection=null;


            try {
                url = new URL("http://192.168.0.12/led1on");

                urlConnection=(HttpURLConnection)url.openConnection();
                InputStream in = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(in);
                reader.ready();

                return null;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
        @Override
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
        }
    }
*/



}

