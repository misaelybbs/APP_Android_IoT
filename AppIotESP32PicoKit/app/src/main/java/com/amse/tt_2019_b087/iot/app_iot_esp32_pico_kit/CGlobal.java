package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CGlobal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_global);
        //this.setTextview(R.id.textViewCGlobalUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_global);
    }

    public void pantallaCGlobalSeguridad(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CGlobalSeguridad.class));
        Intent i = new Intent(this, CGlobalSeguridad.class);
        startActivity(i);
        finish();
    }

    public void pantallaCGlobalExterior(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CGlobalExterior.class));
        Intent i = new Intent(this, CGlobalExterior.class );
        startActivity(i);
        finish();

    }

    public void pantallaCPanelDeControl(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CPanelDeControl.class));
        Intent i = new Intent(this, CPanelDeControl.class);
        startActivity(i);
        finish();
    }

    public void pantallaLogin(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public void pantallaCGlobalLuces(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CPanelDeControl.class));
        Intent i = new Intent(this, CGlobalLuces.class);
        startActivity(i);
        finish();
    }

}