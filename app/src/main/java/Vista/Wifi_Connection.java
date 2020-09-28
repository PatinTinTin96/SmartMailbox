package Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.smartmailbox.R;

public class Wifi_Connection extends AppCompatActivity {
EditText edtIp;
Button btnConectar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi__connection);
        edtIp=findViewById(R.id.edtIp);
        btnConectar=findViewById(R.id.btnConnect);
        btnConectar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connect();
            }
        });

    }

    private void connect() {
        Intent led = new Intent(this,Control_Mailbox.class);
        startActivity(led);
    }


}