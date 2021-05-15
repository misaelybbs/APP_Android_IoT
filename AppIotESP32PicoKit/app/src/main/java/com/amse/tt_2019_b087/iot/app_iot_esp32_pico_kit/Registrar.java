package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.model.login.Login;
import com.amse.tt_2019_b087.iot.model.registro.Registro;
import com.amse.tt_2019_b087.iot.service.impl.ServicesImpl;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class Registrar extends AppCompatActivity {

    private RadioButton radioButtonRegistarAgricultura, radioButtonRegistarCasa, radioButtonRegistarAmbos, radioButtonRegistarFemenino, radioButtonRegistarMasculino;

    String rolId, sexo = null;
    ServicesImpl servicesImpl;
    private Context context;

/*
    public Registrar(Context context) {
        this.context = context;
    }
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_registrar);
        //this.setTextview(R.id.textViewCGlobalUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        servicesImpl = new ServicesImpl(this);

        radioButtonRegistarAgricultura = (RadioButton) findViewById(R.id.simpleRadioButtonRegistrarAgricultura);
        radioButtonRegistarCasa = (RadioButton) findViewById(R.id.simpleRadioButtonRegistrarCasa);
        radioButtonRegistarAmbos = (RadioButton) findViewById(R.id.simpleRadioButtonRegistrarAmbas);
        radioButtonRegistarFemenino = (RadioButton) findViewById(R.id.simpleRadioButtonRegistrarFemenino);
        radioButtonRegistarMasculino = (RadioButton) findViewById(R.id.simpleRadioButtonRegistrarMasculino);
    }

    public void pantallaLogin(View view) {

        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void pantallaRegistro(View view) {

        //final Context context = this;

        final EditText txtRegistrarNickUsuario = (EditText) findViewById(R.id.txtRegistrarNickUsuario);
        final EditText txtRegistrarPassword = (EditText) findViewById(R.id.txtRegistrarPassword);
        final EditText txtRegistrarNombre = (EditText) findViewById(R.id.txtRegistrarUsuario);
        final EditText txtRegistrarApellido = (EditText) findViewById(R.id.txtRegistrarApellido);
        final EditText txtRegistrarEmail = (EditText) findViewById(R.id.txtRegistrarCorreo);

        Registro registro = new Registro();

        if (radioButtonRegistarAgricultura.isChecked() == true) {
            rolId = "1";
        } else if (radioButtonRegistarCasa.isChecked() == true) {
            rolId = "2";
        } else if (radioButtonRegistarAmbos.isChecked() == true) {
            rolId = "3";
        }

        if (radioButtonRegistarFemenino.isChecked() == true) {
            sexo = "F";
        } else if (radioButtonRegistarMasculino.isChecked() == true) {
            sexo = "M";
        }

        String idUser = "0";
        String userName = txtRegistrarNickUsuario.getText().toString().trim();
        String password = txtRegistrarPassword.getText().toString().trim();
        String name = txtRegistrarNombre.getText().toString().trim();
        String lastName = txtRegistrarApellido.getText().toString().trim();
        String rol = rolId;
        String activo = "1";
        String email = txtRegistrarEmail.getText().toString().trim();
        String sex = sexo;

        if (!TextUtils.isEmpty(idUser) && !TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(name)
                && !TextUtils.isEmpty(lastName) && !rol.isEmpty() && !activo.isEmpty() && !TextUtils.isEmpty(email)
                && !sex.isEmpty()) {

            registro.setIdUser(idUser);
            registro.setUserName(userName);
            registro.setPassword(password);
            registro.setName(name);
            registro.setLastName(lastName);
            registro.setRolIdRol(rol);
            registro.setActivo(activo);
            registro.setEmail(email);
            registro.setSex(sex);

            servicesImpl.sendRegistro(registro, this);

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(Registrar.this);
            builder.setTitle("Error");
            builder.setMessage("Asegurese de llenar todos los campos.");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            /*
            builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            */
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
    }
}
