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

public class CGlobalSeguridad extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_global_seguridad);
        //this.setTextview(R.id.textViewCGlobalSeguridadUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_global_seguridad);

        redLocal = ServicesImpl.urlLocal(CGlobalSeguridad.this, redLocal);
        redPublica = ServicesImpl.urlPublica(CGlobalSeguridad.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CGlobalSeguridad.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
        sw1 = findViewById(R.id.switchCGlobalSeguridadControlCerraduras);
        sw2 = findViewById(R.id.switchCGlobalSeguridadControlCamaras);
        sw3 = findViewById(R.id.switchCGlobalSeguridadControlAlarma);

        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CGlobalSeguridad.this, redTipo);
                    nombreRed = Utils.getWifiName(CGlobalSeguridad.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/2/on");
                                webView1.loadUrl(redLocal + ":80/15/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/2/on");
                                webView1.loadUrl(redPublica + ":80/15/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/2/on");
                            webView1.loadUrl(redPublica + ":80/15/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/2/off");
                                webView1.loadUrl(redLocal + ":80/15/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/2/off");
                                webView1.loadUrl(redPublica + ":80/15/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/2/off");
                            webView1.loadUrl(redPublica + ":80/15/off");
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
                    redTipo = Utils.chkStatus(CGlobalSeguridad.this, redTipo);
                    nombreRed = Utils.getWifiName(CGlobalSeguridad.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/4/on");
                                webView1.loadUrl(redLocal + ":80/2/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/4/on");
                                webView1.loadUrl(redPublica + ":80/2/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/4/on");
                            webView1.loadUrl(redPublica + ":80/2/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/4/off");
                                webView1.loadUrl(redLocal + ":80/2/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/4/off");
                                webView1.loadUrl(redPublica + ":80/2/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/4/off");
                            webView1.loadUrl(redPublica + ":80/2/off");
                            break;

                        default:
                            break;
                    }
                }
            }
        });

        sw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sw3.isChecked()) {
                    redTipo = Utils.chkStatus(CGlobalSeguridad.this, redTipo);
                    nombreRed = Utils.getWifiName(CGlobalSeguridad.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                webView1.loadUrl(redLocal + ":80/4/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                webView1.loadUrl(redPublica + ":80/4/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            webView1.loadUrl(redPublica + ":80/4/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                webView1.loadUrl(redLocal + ":80/4/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                webView1.loadUrl(redPublica + ":80/4/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            webView1.loadUrl(redPublica + ":80/4/off");
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

    public void pantallaCGlobal(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CGlobal.class));
        Intent i = new Intent(this, CGlobal.class);
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
