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

public class CCosinaGas extends AppCompatActivity {

    private Switch sw1, sw2, sw3;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica =  "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_c_cosina_gas);
        //this.setTextview(R.id.textViewCCosinaGasUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_cosina_gas);

        redLocal = ServicesImpl.urlLocal(CCosinaGas.this, redLocal);
        redPublica = ServicesImpl.urlPublica(CCosinaGas.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(CCosinaGas.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewCCosinaGas);
        sw1 = findViewById(R.id.switchCCosinaGasControl);
        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(CCosinaGas.this, redTipo);
                    nombreRed = Utils.getWifiName(CCosinaGas.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCCosinaGas);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/5/on");
                                webView1.loadUrl(redLocal + ":80/18/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewCCosinaGas);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/5/on");
                                webView1.loadUrl(redPublica + ":80/18/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCCosinaGas);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/5/on");
                            webView1.loadUrl(redPublica + ":80/18/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewCCosinaGas);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/5/off");
                                webView1.loadUrl(redLocal + ":80/18/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewCCosinaGas);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/5/off");
                                webView1.loadUrl(redPublica + ":80/18/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewCCosinaGas);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/5/off");
                            webView1.loadUrl(redPublica + ":80/18/off");
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


    public void pantallaCCosina(View view) {
        //startActivity(Utils.setBundleUser(usuario, this, CCosina.class));
        Intent i = new Intent(this, CCosina.class );
        startActivity(i);
        finish();
    }

    public void pantallaLogin(View view) {
        //startActivity(Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class );
        startActivity(i);
        finish();
    }
}
