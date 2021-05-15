package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.webkit.WebView;
import android.widget.Switch;

import com.amse.tt_2019_b087.iot.service.impl.ServicesImpl;
import com.amse.tt_2019_b087.iot.utils.Utils;

public class CGlobalLuces extends AppCompatActivity{

    private Switch sw1, sw2;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redLocal2= "";
    String redPublica =  "";
    String redPublica2 ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setTextview(R.id.textViewAGlobalHumedadUsuario);
        //setContentView(R.layout.activity_c_global_luces);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_global_luces);

        redLocal = ServicesImpl.urlLocal(CGlobalLuces.this, redLocal);
        redLocal2 = ServicesImpl.urlLocal2(CGlobalLuces.this, redLocal2);
        redPublica = ServicesImpl.urlPublica(CGlobalLuces.this, redPublica);
        redPublica2 = ServicesImpl.urlPublica(CGlobalLuces.this, redPublica2);
        wifiLocal = ServicesImpl.wifiLocal(CGlobalLuces.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
        WebView webView2 = findViewById(R.id.webViewCGlobalLuces2);
        sw1 = findViewById(R.id.switchCGlobalLucesExteriorControl);
        sw2 = findViewById(R.id.switchCGlobalLucesInteriorControl);

        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CGlobalLuces.this, redTipo);
                    nombreRed = Utils.getWifiName(CGlobalLuces.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/23/on");
                                webView1.loadUrl(redLocal + ":80/22/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/23/on");
                                webView1.loadUrl(redPublica + ":80/22/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/23/on");
                            webView1.loadUrl(redPublica + ":80/22/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/23/off");
                                webView1.loadUrl(redLocal + ":80/22/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/23/off");
                                webView1.loadUrl(redPublica + ":80/22/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/23/off");
                            webView1.loadUrl(redPublica + ":80/22/off");
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
                    redTipo = Utils.chkStatus(CGlobalLuces.this, redTipo);
                    nombreRed = Utils.getWifiName(CGlobalLuces.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                WebView webView2 = findViewById(R.id.webViewCGlobalLuces2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/23/on");
                                webView1.loadUrl(redLocal + ":80/19/on");
                                webView2.loadUrl(redLocal2 + ":83/2/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                WebView webView2 = findViewById(R.id.webViewCGlobalLuces2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/23/on");
                                webView1.loadUrl(redPublica + ":80/19/on");
                                webView2.loadUrl(redLocal2 + ":83/2/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            WebView webView2 = findViewById(R.id.webViewCGlobalLuces2);
                            webView2.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/23/on");
                            webView1.loadUrl(redPublica + ":80/19/on");
                            webView2.loadUrl(redLocal2 + ":83/2/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                WebView webView2 = findViewById(R.id.webViewCGlobalLuces2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/23/off");
                                webView1.loadUrl(redLocal + ":80/19/off");
                                webView2.loadUrl(redLocal2 + ":83/2/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                WebView webView2 = findViewById(R.id.webViewCGlobalLuces2);
                                webView2.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/23/off");
                                webView1.loadUrl(redPublica + ":80/19/off");
                                webView2.loadUrl(redLocal2 + ":83/2/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCGlobalLuces);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            WebView webView2 = findViewById(R.id.webViewCGlobalLuces2);
                            webView2.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/23/off");
                            webView1.loadUrl(redPublica + ":80/19/off");
                            webView2.loadUrl(redLocal2 + ":83/2/off");
                            break;

                        default:
                            break;
                    }
                }
            }
        });

    }

    public void pantallaAGlobal(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, APanelDeControl.class));
        Intent i = new Intent(this, CGlobal.class );
        startActivity(i);
        finish();
    }

    public void pantallaLogin(View view){
        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
        finish();
    }
}
