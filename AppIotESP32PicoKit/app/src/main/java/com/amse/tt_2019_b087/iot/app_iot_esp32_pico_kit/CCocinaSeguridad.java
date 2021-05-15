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

public class CCocinaSeguridad extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica =  "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_banio_gas);
        //this.setTextview(R.id.textViewCBanioaGasUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_cocina_seguridad);

        redLocal = ServicesImpl.urlLocal2(CCocinaSeguridad.this, redLocal);
        redPublica = ServicesImpl.urlPublica2(CCocinaSeguridad.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CCocinaSeguridad.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCCocinaSeguridad);
        sw1 = findViewById(R.id.switchCCocinaSeguridadControl);
        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CCocinaSeguridad.this, redTipo);
                    nombreRed = Utils.getWifiName(CCocinaSeguridad.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCCocinaSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/26/on");
                                webView1.loadUrl(redLocal + ":80/9/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCCocinaSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/26/on");
                                webView1.loadUrl(redPublica + ":80/9/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCCocinaSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/26/on");
                            webView1.loadUrl(redPublica + ":80/9/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCCocinaSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/26/off");
                                webView1.loadUrl(redLocal + ":80/9/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCCocinaSeguridad);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/26/off");
                                webView1.loadUrl(redPublica + ":80/9/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCCocinaSeguridad);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/26/off");
                            webView1.loadUrl(redPublica + ":80/9/off");
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

    public void pantallaCCocina(View view) {
        //startActivity( Utils.setBundleUser(usuario, this, CBanio.class));
        Intent i = new Intent(this, CCosina.class );
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
