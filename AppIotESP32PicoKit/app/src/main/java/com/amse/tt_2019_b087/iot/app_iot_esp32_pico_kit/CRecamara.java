package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CRecamara extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_recamara);
        //this.setTextview(R.id.textViewCRecamaraUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_recamara);
    }

    public void pantallaCRecamaraLuces(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CRecamaraLuces.class));
        Intent i = new Intent(this, CRecamaraLuces.class);
        startActivity(i);
        finish();
    }


    public void pantallaCRecamaraDispositivos(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CRecamaraDispositivos.class));
        Intent i = new Intent(this, CRecamaraDispositivos.class);
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
}
