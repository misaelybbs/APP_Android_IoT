package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class APanelDeControl extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_a_panel_de_control);
        //this.setTextview(R.id.textViewAPanelDeControl);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_panel_de_control);
    }

    public void pantallaAGlobalLuces(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, AGlobalLuces.class));
        Intent i = new Intent(this, AGlobalLuces.class );
        startActivity(i);

    }

    public void pantallaAGlobalHuemedad(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CGlobalLuces.class));
        Intent i = new Intent(this, AGlobalHumedad.class );
        startActivity(i);

    }

    public void pantallaAGlobalAcciones(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, AGlobalAcciones.class));
        Intent i = new Intent(this, AGlobalAcciones.class );
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
