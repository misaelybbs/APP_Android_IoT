package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Switch;

import com.amse.tt_2019_b087.iot.service.impl.ServicesImpl;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CSalaSeguridad extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_sala_seguridad);

        redLocal = ServicesImpl.urlLocal2(CSalaSeguridad.this, redLocal);
        redPublica = ServicesImpl.urlPublica2(CSalaSeguridad.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CSalaSeguridad.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCSalaSeguridad);
        sw1 = findViewById(R.id.switchCSalaSeguridadSensorFuegoControl);

/*
        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CSalaSeguridad.this, redTipo);
                    nombreRed = Utils.getWifiName(CSalaSeguridad.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/15/on");
                                webView1.loadUrl(redLocal + "1/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/15/on");
                                webView1.loadUrl(redPublica + "21/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/15/on");
                            webView1.loadUrl(redPublica + "21/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/15/off");
                                webView1.loadUrl(redLocal + "21/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/15/off");
                                webView1.loadUrl(redPublica + "21/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/15/off");
                            webView1.loadUrl(redPublica + "21/off");
                            break;

                        default:
                            break;
                    }
                }
            }
        });
*/

    }

    public void pantallaCSala(View view) {
        //startActivity(Utils.setBundleUser(usuario, this, CSala.class));
        Intent i = new Intent(this, CSala.class);
        startActivity(i);
        finish();
    }

    public void pantallaLogin(View view) {
        //startActivity(Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}