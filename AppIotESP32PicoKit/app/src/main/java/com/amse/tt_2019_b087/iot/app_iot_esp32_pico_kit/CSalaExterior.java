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

public class CSalaExterior extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redLocal2 = "";
    String redPublica =  "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_sala_exterior);
        //this.setTextview(R.id.textViewCSalaExteriorUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_sala_exterior);

        redLocal = ServicesImpl.urlLocal(CSalaExterior.this, redLocal);
        redLocal2 = ServicesImpl.urlLocal2(CSalaExterior.this, redLocal2);
        redPublica = ServicesImpl.urlPublica2(CSalaExterior.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CSalaExterior.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCSalaExterior);
        WebView webView2 = findViewById(R.id.webViewCSalaExterior2);
        sw1 = findViewById(R.id.switchCSalaExteriorLucesControl);

        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CSalaExterior.this, redTipo);
                    nombreRed = Utils.getWifiName(CSalaExterior.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCSalaExterior);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                WebView webView2 = findViewById(R.id.webViewCSalaExterior2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/21/on");
                                webView1.loadUrl(redLocal2 + ":83/23/on");
                                webView2.loadUrl(redLocal + ":80/22/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaExterior);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/21/on");
                                WebView webView2 = findViewById(R.id.webViewCSalaExterior2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                webView1.loadUrl(redPublica + ":83/23/on");
                                webView2.loadUrl(redPublica + ":80/22/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaExterior);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/21/on");
                            WebView webView2 = findViewById(R.id.webViewCSalaExterior2);
                            webView2.getSettings().setJavaScriptEnabled(true);
                            webView1.loadUrl(redPublica + ":83/23/on");
                            webView2.loadUrl(redPublica + ":80/22/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCSalaExterior);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/21/off");
                                WebView webView2 = findViewById(R.id.webViewCSalaExterior2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                webView1.loadUrl(redLocal2 + ":83/23/off");
                                webView2.loadUrl(redLocal + ":80/22/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCSalaExterior);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/21/off");
                                WebView webView2 = findViewById(R.id.webViewCSalaExterior2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                webView1.loadUrl(redPublica + ":83/23/off");
                                webView2.loadUrl(redPublica + ":80/22/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCSalaExterior);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/21/off");
                            WebView webView2 = findViewById(R.id.webViewCSalaExterior2);
                            webView2.getSettings().setJavaScriptEnabled(true);
                            webView1.loadUrl(redPublica + ":83/23/off");
                            webView2.loadUrl(redPublica + ":80/22/off");
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
