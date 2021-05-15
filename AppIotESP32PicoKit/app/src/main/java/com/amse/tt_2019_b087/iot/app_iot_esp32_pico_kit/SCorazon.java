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

public class SCorazon extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_corazon);

        redLocal = ServicesImpl.urlLocal3(SCorazon.this, redLocal);
        redPublica = ServicesImpl.urlPublica2(SCorazon.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(SCorazon.this, wifiLocal);

        WebView webViewTemperatura = findViewById(R.id.webViewSCorazon);
        webViewTemperatura.loadUrl(redLocal + ":82/");

        redTipo = Utils.chkStatus(SCorazon.this, redTipo);
        nombreRed = Utils.getWifiName(SCorazon.this, nombreRed);

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

        WebView webView1 = findViewById(R.id.webViewSCorazon);
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