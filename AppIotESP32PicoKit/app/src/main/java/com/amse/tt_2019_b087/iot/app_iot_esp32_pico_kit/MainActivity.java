package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import com.amse.tt_2019_b087.iot.model.login.Login;
import com.amse.tt_2019_b087.iot.service.impl.ServicesImpl;

public class MainActivity extends AppCompatActivity {

    ServicesImpl servicesImpl;

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servicesImpl = new ServicesImpl(this);

        redLocal = ServicesImpl.urlLocal2(MainActivity.this, redLocal);
        redPublica = ServicesImpl.urlPublica2(MainActivity.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(MainActivity.this, wifiLocal);

    }

    public void pantallaPanelDeControl(View view) {

        final EditText txtLoginUsuario = (EditText) findViewById(R.id.editTextLoginUsuario);
        final EditText txtLoginPassword = (EditText) findViewById(R.id.editTextLoginPassword);
        String LoginUsuario = txtLoginUsuario.getText().toString().trim();
        String LoginPassword = txtLoginPassword.getText().toString().trim();

        if ( !TextUtils.isEmpty(LoginUsuario) && !TextUtils.isEmpty(LoginPassword)) {

            Login login = new Login(LoginUsuario, LoginPassword);
            servicesImpl.login(this, login);


            //this.usuario.addPermisos(new Permisos(Roles.HOGAR.getCodigo(), Roles.HOGAR.getNombre()));
            //Intent i = new Intent(this, PanelDeControl.class );
            //startActivity(i);
            //startActivity( Utils.setBundleUser(this, this, PanelDeControl.class));

        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Error")
                    .setMessage("Asegurese de llenar todos los campos correctamente.")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Toast.makeText(MainActivity.this,"Selected Option: YES",Toast.LENGTH_SHORT).show();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();

        }

        /*
        EditText userLogin = (EditText)findViewById(R.id.editTextLoginUsuario);
        EditText userPass = (EditText)findViewById(R.id.editTextLoginPassword);

        String usuario = userLogin.getText().toString();
        String password = userPass.getText().toString();

        this.usuario = new Usuario(usuario, password);
        this.usuario.addPermisos(new Permisos(Roles.HOGAR.getCodigo(), Roles.HOGAR.getNombre()));

        if(this.usuario.getPassword().equals("alan")){
            startActivity( Utils.setBundleUser(this.usuario, this, PanelDeControl.class));
        }

        else{
            Context context = getApplicationContext();
            CharSequence text = "Contraseña Incorrecta";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


         */
    }

    public void pantallaRegistrar(View view){
        //startActivity( Utils.setBundleUser(usuario, this, Registrar.class));
        Intent i = new Intent(this, Registrar.class );
        startActivity(i);
    }

    public void pantallaRecuperarContrasenia(View view){
        //startActivity( Utils.setBundleUser(usuario, this, RecuperarContrasenia.class));
        Intent i = new Intent(this, RecuperarContrasenia.class );
        startActivity(i);
    }

}
