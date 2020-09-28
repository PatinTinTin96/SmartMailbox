package Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.smartmailbox.Control.InteractionOn;
import com.example.smartmailbox.Control.InteractionOff;
import com.example.smartmailbox.R;

public class Control_Mailbox extends AppCompatActivity {
Button btnOn,btnOff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control__mailbox);
        btnOn=findViewById(R.id.btnOn);
        btnOff=findViewById(R.id.btnOff);

        btnOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InteractionOn on = new InteractionOn();
                on.execute();
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InteractionOff off = new InteractionOff();
                off.execute();
            }
        });
    }





}