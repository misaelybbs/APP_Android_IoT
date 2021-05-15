package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SPanelDeControl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_panel_de_control);
    }

    public void pantallaSCorazon(View view){
        //startActivity( Utils.setBundleUser(usuario, this, PanelDeControl.class));
        Intent i = new Intent(this, SCorazon.class );
        startActivity(i);
    }

    public void pantallaSTermometro(View view){
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, STermometro.class );
        startActivity(i);
    }

    public void pantallaPanelDeControl(View view){
        //startActivity( Utils.setBundleUser(usuario, this, PanelDeControl.class));
        Intent i = new Intent(this, PanelDeControl.class );
        startActivity(i);
    }

    public void pantallaLogin(View view){
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }
}