package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CSala extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_sala);
        //this.setTextview(R.id.textViewCSalaUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_sala);
    }

    public void pantallaCSalaLuces(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CSalaLuces.class));
        Intent i = new Intent(this, CSalaLuces.class);
        startActivity(i);
        finish();
    }

    public void pantallaCSalaTemperatura(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CSalaTemperatura.class));
        Intent i = new Intent(this, CSalaTemperatura.class);
        startActivity(i);
        finish();
    }

    public void pantallaCSalaDispositivos(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CSalaDispositivos.class));
        Intent i = new Intent(this, CSalaDispositivos.class);
        startActivity(i);
        finish();
    }

    public void pantallaCSalaExterior(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CSalaExterior.class));
        Intent i = new Intent(this, CSalaExterior.class);
        startActivity(i);
        finish();
    }

    public void pantallaCPanelDeControl(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CPanelDeControl.class));
        Intent i = new Intent(this, CPanelDeControl.class);
        startActivity(i);
        finish();
    }

    public void pantallaLogin(View view){
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void pantallaCSalaSeguridad(View view){
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, CSalaSeguridad.class);
        startActivity(i);
        finish();
    }

}
