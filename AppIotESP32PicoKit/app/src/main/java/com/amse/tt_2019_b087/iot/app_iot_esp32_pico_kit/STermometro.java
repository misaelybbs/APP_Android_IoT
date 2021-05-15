package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class STermometro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_termometro);
    }

    public void pantallaSPanelDeControl(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, PanelDeControl.class));
        Intent i = new Intent(this, SPanelDeControl.class);
        startActivity(i);
    }

    public void pantallaLogin(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}