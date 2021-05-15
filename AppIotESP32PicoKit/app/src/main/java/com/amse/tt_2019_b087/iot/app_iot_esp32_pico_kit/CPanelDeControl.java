package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CPanelDeControl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_panel_de_control);
        //this.setTextview(R.id.textViewCPanelControlUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_panel_de_control);
    }

    public void pantallaLogin(View view){
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
    }

    public void pantallaCGlobal(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CGlobal.class));
        Intent i = new Intent(this, CGlobal.class);
        startActivity(i);
    }

    public void pantallaCCosina(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CCosina.class));
        Intent i = new Intent(this, CCosina.class );
        startActivity(i);

    }

    public void pantallaCBanio(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CBanio.class));
        Intent i = new Intent(this, CBanio.class );
        startActivity(i);

    }

    public void pantallaCSala(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CSala.class));
        Intent i = new Intent(this, CSala.class );
        startActivity(i);

    }

    public void pantallaCRecamara(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CRecamara.class));
        Intent i = new Intent(this, CRecamara.class );
        startActivity(i);

    }

    public void pantallaPanelDeControl(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, PanelDeControl.class));
        Intent i = new Intent(this, PanelDeControl.class );
        startActivity(i);
    }

}
