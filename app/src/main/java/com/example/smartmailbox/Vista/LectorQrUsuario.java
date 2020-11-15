package com.example.smartmailbox.Vista;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.example.smartmailbox.R;
import com.google.zxing.Result;

import androidx.annotation.NonNull;
import com.example.smartmailbox.Control.ControlBuzon;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class LectorQrUsuario extends AppCompatActivity {
    private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lector_qr);
        if (ContextCompat.checkSelfPermission(LectorQrUsuario.this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(LectorQrUsuario.this, new String[] {Manifest.permission.CAMERA}, 123);
        } else {
            startScanning();


        }

    }
    private void startScanning() {
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(result.getBarcodeFormat() != null){
                            Toast.makeText(LectorQrUsuario.this, result.getText(), Toast.LENGTH_SHORT).show();
                            Intent v = new Intent(LectorQrUsuario.this, Respuesta.class);
                            v.putExtra("serie", result.getText().toString());
                            startActivity(v);
                            //alert();
                            //res();
                        }
                    }

                });

            }

        });


        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();

    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();

    }



    private void alert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Asociar dispositivo a su cuenta");
        alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialog.setMessage("¿Desea asociar dispositivo?");

        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton("Sí", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {

            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                //código java si se ha pulsado no
            }
        });
        alertDialog.show();
    }
}