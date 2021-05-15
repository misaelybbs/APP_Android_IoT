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

public class CRecamaraLuces extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica =  "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_recamara_luces);
        //this.setTextview(R.id.textViewCRecamaraLucesUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_recamara_luces);

        redLocal = ServicesImpl.urlLocal2(CRecamaraLuces.this, redLocal);
        redPublica = ServicesImpl.urlPublica2(CRecamaraLuces.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CRecamaraLuces.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCRecamaraLuces);
        sw1 = findViewById(R.id.switchCRecamaraLucesControl);

        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CRecamaraLuces.this, redTipo);
                    nombreRed = Utils.getWifiName(CRecamaraLuces.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/19/on");
                                webView1.loadUrl(redLocal + ":83/5/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/19/on");
                                webView1.loadUrl(redPublica + ":83/5/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCRecamaraLuces);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/19/on");
                            webView1.loadUrl(redPublica + ":83/5/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/19/off");
                                webView1.loadUrl(redLocal + ":83/5/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCRecamaraLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/19/off");
                                webView1.loadUrl(redPublica + ":83/5/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCRecamaraLuces);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/19/off");
                            webView1.loadUrl(redPublica + ":83/5/off");
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
        //startActivity(Utils.setBundleUser(usuario, this, CRecamara.class));
        Intent i = new Intent(this, CRecamara.class);
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
