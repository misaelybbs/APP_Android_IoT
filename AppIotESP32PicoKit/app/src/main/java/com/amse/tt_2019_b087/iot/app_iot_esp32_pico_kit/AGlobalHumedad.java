package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Switch;

import com.amse.tt_2019_b087.iot.service.impl.ServicesImpl;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class AGlobalHumedad extends AppCompatActivity {

    private Switch sw1, sw2;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";
    ServicesImpl servicesImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_global_temperatura);

        servicesImpl = new ServicesImpl(this);

        redLocal = ServicesImpl.urlLocal(AGlobalHumedad.this, redLocal);
        redPublica = ServicesImpl.urlPublica(AGlobalHumedad.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(AGlobalHumedad.this, wifiLocal);

        WebView webViewTemperatura = findViewById(R.id.webViewAGlobalAccionesTemperatura);
        webViewTemperatura.loadUrl("http://192.168.1.89:82/");

        redTipo = Utils.chkStatus(AGlobalHumedad.this, redTipo);
        nombreRed = Utils.getWifiName(AGlobalHumedad.this, nombreRed);

        switch (redTipo) {

            case 1:
                if (nombreRed.equals(wifiLocal)) {
                    webViewTemperatura.loadUrl(redLocal + ":82/");

                } else {
                    webViewTemperatura.loadUrl(redPublica + ":82/");
                }
                break;

            case 2:
                webViewTemperatura.loadUrl(redPublica + ":82/");
                break;

            default:
                break;
        }

        webViewTemperatura.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
    }

    public void pantallaAPanelDeControl(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, APanelDeControl.class));
        Intent i = new Intent(this, APanelDeControl.class);
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