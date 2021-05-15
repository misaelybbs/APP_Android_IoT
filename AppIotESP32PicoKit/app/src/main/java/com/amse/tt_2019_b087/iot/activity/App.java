package com.amse.tt_2019_b087.iot.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.R;
import com.amse.tt_2019_b087.iot.dto.Usuario;
import com.amse.tt_2019_b087.iot.utils.Utils;

public abstract class App extends AppCompatActivity {
    protected Usuario usuario;
    protected int layout, textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayout());
        this.usuario = Utils.getBundleUser(getIntent().getExtras());

        if (this.usuario != null) {
            Utils.setTextUser(this.getTextview(), this, this.usuario.getUser());
            Utils.setMessage("usuario", getApplicationContext());
        }
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public int getTextview() {
        return textview;
    }

    public void setTextview(int textview) {
        this.textview = textview;
    }
}
