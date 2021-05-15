package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CBanio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_banio);
        //this.setTextview(R.id.textViewCBanioUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_banio);
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

    public void pantallaCBanioLuces(View view){
        //startActivity( Utils.setBundleUser(usuario, this, CBanioLuces.class));
        Intent i = new Intent(this, CBanioLuces.class );
        startActivity(i);
        finish();
    }

}
