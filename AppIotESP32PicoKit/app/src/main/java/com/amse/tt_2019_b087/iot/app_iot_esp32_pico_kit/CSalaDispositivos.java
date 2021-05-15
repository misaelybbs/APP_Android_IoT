package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Switch;

import com.amse.tt_2019_b087.iot.activity.App;
import com.amse.tt_2019_b087.iot.service.impl.ServicesImpl;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CSalaDispositivos extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica =  "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_sala_dispositivos);
        //this.setTextview(R.id.textViewCSalaDispositivosUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_sala_dispositivos);

        redLocal = ServicesImpl.urlLocal2(CSalaDispositivos.this, redLocal);
        redPublica = ServicesImpl.urlPublica2(CSalaDispositivos.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CSalaDispositivos.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
        sw1 = findViewById(R.id.switchCSalaDispositivosControlVentilador);
        sw2 = findViewById(R.id.switchCSalaDispositivosControlPantalla);

        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CSalaDispositivos.this, redTipo);
                    nombreRed = Utils.getWifiName(CSalaDispositivos.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/15/on");
                                webView1.loadUrl(redLocal + ":83/9/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/15/on");
                                webView1.loadUrl(redPublica + ":83/9/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/15/on");
                            webView1.loadUrl(redPublica + ":83/9/on");
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
                                webView1.loadUrl(redLocal + ":83/9/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/15/off");
                                webView1.loadUrl(redPublica + ":83/9/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/15/off");
                            webView1.loadUrl(redPublica + ":83/9/off");
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        sw2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw2.isChecked()) {
                    redTipo = Utils.chkStatus(CSalaDispositivos.this, redTipo);
                    nombreRed = Utils.getWifiName(CSalaDispositivos.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/4/on");
                                webView1.loadUrl(redLocal + ":83/19/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/4/on");
                                webView1.loadUrl(redPublica + ":83/19/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/4/on");
                            webView1.loadUrl(redPublica + ":83/19/on");
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
                                ///webView1.loadUrl("http://192.168.1.82/4/off");
                                webView1.loadUrl(redLocal + ":83/19/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/4/off");
                                webView1.loadUrl(redPublica + ":83/19/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/4/off");
                            webView1.loadUrl(redPublica + ":83/19/off");
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        webView1.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return false;
            }
        });
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
