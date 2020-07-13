package Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.smartmailbox.Control.ControlComuna;
import com.example.smartmailbox.Control.ControlUsuario;
import com.example.smartmailbox.R;
import com.google.android.material.textfield.TextInputLayout;

public class RegistroUsuario extends AppCompatActivity {

 Spinner ddlComunas;
 TextInputLayout edtNombreUsuario,edtNickUsuario,edtEmailUsuario,edtTelefonoUsuario,edtDireccionUsuario,edtContraseña,edtConfirmarContraseña;
Button btnRegistrar;
int comuna;
static int mailbox = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registro_usuario);

        edtNombreUsuario = findViewById(R.id.nombreUsuario);
        edtNickUsuario = findViewById(R.id.nickUsuario);
        edtEmailUsuario = findViewById(R.id.correoUsuario);
        edtTelefonoUsuario = findViewById(R.id.telefonoUsuario);
        edtDireccionUsuario = findViewById(R.id.direccionUsuario);
        edtContraseña = findViewById(R.id.contraseñaUsuario);
        edtConfirmarContraseña = findViewById(R.id.confirmarContraseña);
        ddlComunas = findViewById(R.id.ddlComuna);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        ArrayAdapter<CharSequence> arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, ControlComuna.listado());
        ddlComunas.setAdapter(arrayAdapter);


        ddlComunas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position!=0){
                    comuna = position;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "Seleccione una comuna", Toast.LENGTH_LONG).show();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = edtNombreUsuario.getEditText().getText().toString();
                String nick = edtNickUsuario.getEditText().getText().toString();
                String email = edtEmailUsuario.getEditText().getText().toString();
                String tel = edtTelefonoUsuario.getEditText().getText().toString();
                String dir = edtDireccionUsuario.getEditText().getText().toString();
                String pass = edtContraseña.getEditText().getText().toString();
                String chpass = edtConfirmarContraseña.getEditText().getText().toString();

                if (nombre.equals("") || nick.equals("") || email.equals("") || tel.equals("") || dir.equals("") || comuna==0 || pass.equals("") || chpass.equals("")){
                    Toast.makeText(getApplicationContext(), "Rellene todos los campos", Toast.LENGTH_LONG).show();
                }else{
                    if (pass.equals(chpass)){
                        if (ControlUsuario.agregarUsuario(nombre, nick, email, tel, dir, pass, comuna, mailbox)) {
                            Toast.makeText(getApplicationContext(), "Registrado Correctamente", Toast.LENGTH_LONG).show();
                            Intent r = new Intent(RegistroUsuario.this, IngresoUsuario.class);
                            startActivity(r);
                        } else {

                            Toast.makeText(getApplicationContext(), "Error al ingresar", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                    }
                }





            }
        });


    }





}
