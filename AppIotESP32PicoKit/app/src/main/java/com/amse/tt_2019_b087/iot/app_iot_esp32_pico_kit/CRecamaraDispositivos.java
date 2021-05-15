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

public class CRecamaraDispositivos extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_recamara_dispositivos);
        //this.setTextview(R.id.textViewCRecamaraDispositivosUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_recamara_dispositivos);

        redLocal = ServicesImpl.urlLocal2(CRecamaraDispositivos.this, redLocal);
        redPublica = ServicesImpl.urlPublica2(CRecamaraDispositivos.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CRecamaraDispositivos.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
        sw1 = findViewById(R.id.switchCRecamaraDispositivosControVentilador);
        sw2 = findViewById(R.id.switchCRecamaraDispositivosControlPantalla);

        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CRecamaraDispositivos.this, redTipo);
                    nombreRed = Utils.getWifiName(CRecamaraDispositivos.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/18/on");
                                webView1.loadUrl(redLocal + ":83/10/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/18/on");
                                webView1.loadUrl(redPublica + ":83/10/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/18/on");
                            webView1.loadUrl(redPublica + ":83/10/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/18/off");
                                webView1.loadUrl(redLocal + ":83/10/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/18/off");
                                webView1.loadUrl(redPublica + ":83/10/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/18/off");
                            webView1.loadUrl(redPublica + ":83/10/off");
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
                    redTipo = Utils.chkStatus(CRecamaraDispositivos.this, redTipo);
                    nombreRed = Utils.getWifiName(CRecamaraDispositivos.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/10/on");
                                webView1.loadUrl(redLocal + ":83/13/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/10/on");
                                webView1.loadUrl(redPublica + ":83/13/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/10/on");
                            webView1.loadUrl(redPublica + ":83/13/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/10/off");
                                webView1.loadUrl(redLocal + ":83/13/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/10/off");
                                webView1.loadUrl(redPublica + ":83/13/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCRecamaraDispositivos);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/10/off");
                            webView1.loadUrl(redPublica + ":83/13/off");
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

    public void pantallaCRecamara(View view) {
        Intent pantallaCRecamara = new Intent(this, CRecamara.class);
        startActivity(pantallaCRecamara);
        finish();
    }

    public void pantallaLogin(View view) {
        Intent pantallaLogin = new Intent(this, MainActivity.class);
        startActivity(pantallaLogin);
        finish();
    }
}
