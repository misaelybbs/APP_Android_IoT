package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CCosina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_cosina);
        //this.setTextview(R.id.textViewCCosinaUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_cosina);
    }

    public void pantallaCPanelDeControl(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CPanelDeControl.class));
        Intent i = new Intent(this, CPanelDeControl.class );
        startActivity(i);
        finish();
    }

    public void pantallaLogin(View view){
       //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
        finish();
    }

    public void pantallaCCosinaLuces(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CCosinaLuces.class));
        Intent i = new Intent(this, CCosinaLuces.class );
        startActivity(i);
        finish();
    }

    public void pantallaCCosinaGas(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CCosinaGas.class));
        Intent i = new Intent(this, CCosinaGas.class );
        startActivity(i);
        finish();
    }

    public void pantallaCCosinaSeguridad(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CCosinaGas.class));
        Intent i = new Intent(this, CCocinaSeguridad.class );
        startActivity(i);
        finish();
    }

}
