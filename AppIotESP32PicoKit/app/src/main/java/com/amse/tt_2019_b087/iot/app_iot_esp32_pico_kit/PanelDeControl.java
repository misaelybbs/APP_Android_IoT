package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.dto.Permisos;
import com.amse.tt_2019_b087.iot.dto.Usuario;
import com.amse.tt_2019_b087.iot.enums.Roles;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class PanelDeControl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

       // this.setLayout(R.layout.activity_panel_de_control);
       // this.setTextview(R.id.textViewPanelDeControlUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel_de_control);
        /*
        if (this.usuario != null) {

            if (this.usuario != null) {
                for (Permisos p : this.usuario.getPermisos()) {
                    if (p.getId() == Roles.ADMIN.getCodigo()) {
                    } else if (p.getId() == Roles.HOGAR.getCodigo()) {
                        LinearLayout campoAgricultura = findViewById(R.id.linearLayoutPanelDeControlMenuAgicultura);
                        campoAgricultura.setEnabled(false);
                    } else if (p.getId() == Roles.AGRICULTOR.getCodigo()) {
                        LinearLayout campoHogar = findViewById(R.id.linearLayoutPanelDeControlMenuCasa);
                        campoHogar.setEnabled(false);
                    }
                }
            }
        }
        */
    }

    public void pantallaAPanelDeControl(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, APanelDeControl.class));

            Intent i = new Intent(this, APanelDeControl.class);
            startActivity(i);
            finish();

    }

    public void pantallaLogin(View view){
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

    public void pantallaCPanelDeControl(View view) {
       // startActivity( Utils.setBundleUser(usuario, this, CPanelDeControl.class));
        Intent i = new Intent(this, CPanelDeControl.class);
        startActivity(i);
        finish();
    }

    public void pantallaSPanelDeControl(View view) {
        // startActivity( Utils.setBundleUser(usuario, this, CPanelDeControl.class));
        Intent i = new Intent(this, SPanelDeControl.class);
        startActivity(i);
        finish();
    }

}
