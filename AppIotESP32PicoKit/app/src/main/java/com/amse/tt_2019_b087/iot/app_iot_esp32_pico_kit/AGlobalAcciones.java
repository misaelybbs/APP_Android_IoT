package com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.amse.tt_2019_b087.iot.model.pines1.Pines1;
import com.amse.tt_2019_b087.iot.service.impl.ServicesImpl;
import com.amse.tt_2019_b087.iot.utils.Handle;
import com.amse.tt_2019_b087.iot.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AGlobalAcciones extends AppCompatActivity {

    private Switch sw1, sw2;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";
    ServicesImpl servicesImpl;
    static final int TIME_OUT = 55000; //ms

    static final int MSG_DISMISS_DIALOG = 0;

    private AlertDialog mAlertDialog;

    private ListView listView;
    private ProgressDialog progressDialog;
    //private static String url = "http://192.168.1.76";
    ArrayList<HashMap<String, String>> nameList;



    String url = "http://192.168.1.76";
    Document doc = Jsoup.parse(url);
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //this.setLayout(R.layout.activity_a_global_acciones);
        //this.setTextview(R.id.textViewAGlobalAccionesUsuario);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_global_acciones);


        servicesImpl = new ServicesImpl(this);

        redLocal = ServicesImpl.urlLocal(AGlobalAcciones.this, redLocal);
        redPublica = ServicesImpl.urlPublica(AGlobalAcciones.this, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(AGlobalAcciones.this, wifiLocal);

        WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
        sw1 = findViewById(R.id.switchAGlobalAccionesControlTejado);
        sw2 = findViewById(R.id.switchAGlobalAccionesControlRiego);

        listView = findViewById(R.id.listView1);
        nameList = new ArrayList<>();




        //new Description().execute();

        sw1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                if (sw1.isChecked()) {
                    redTipo = Utils.chkStatus(AGlobalAcciones.this, redTipo);
                    nombreRed = Utils.getWifiName(AGlobalAcciones.this, nombreRed);
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/25/on");
                                webView1.loadUrl(redLocal + ":80/25/on");
                                abriendoMotor();

                            } else {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/25/on");
                                webView1.loadUrl(redPublica + ":80/25/on");
                                abriendoMotor();
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/25/on");
                            webView1.loadUrl(redPublica + ":80/25/on");
                            abriendoMotor();
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/25/off");
                                webView1.loadUrl(redLocal + ":80/25/off");
                                cerrandoMotor();
                            } else {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/25/off");
                                webView1.loadUrl(redPublica + ":80/25/off");
                                cerrandoMotor();
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/25/off");
                            webView1.loadUrl(redPublica + ":80/25/off");
                            cerrandoMotor();
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
                    redTipo = Utils.chkStatus(AGlobalAcciones.this, redTipo);
                    nombreRed = Utils.getWifiName(AGlobalAcciones.this, nombreRed);
/*
                    Pines1 pines1 = new Pines1();

                    String a = String.valueOf(pines1.getPin25());
                    int a1 = pines1.getPin25();
                    Object c1 = pines1.getPin25();
                    String x = pines1.toString();

                    String a11 = String.valueOf(pines1.getPin2());
                    Object c11 = pines1.getPin2();
                    int s = pines1.getPin2();

                    int b = pines1.getPin32();
                    Object c = pines1.getPin2();

                    JsonObject jsonObject = new JsonObject();

                    jsonObject.getAsJsonObject("pines1");
                    jsonObject.getAsJsonPrimitive("pines");
                    jsonObject.get(String.valueOf(pines1));
                    jsonObject.getAsJsonObject(String.valueOf(pines1));
                    pines1.getPin4();

                    //pines1 =  AGlobalAcciones.getPines1(s);

                    //pines1 = AGlobalAcciones.getPines12(a1);


                    //servicesImpl.leerPines1(pines1);
*/
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://192.168.1.82/26/on");
                                webView1.loadUrl(redLocal + ":80/26/on");

                            } else {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/26/on");
                                webView1.loadUrl(redPublica + ":80/26/on");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/26/on");
                            webView1.loadUrl(redPublica + ":80/26/on");
                            break;

                        default:
                            break;
                    }
                } else {
                    switch (redTipo) {
                        case 1:
                            if (nombreRed.equals(wifiLocal)) {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                ///webView1.loadUrl("http://192.168.1.82/26/off");
                                webView1.loadUrl(redLocal + ":80/26/off");
                            } else {
                                WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                                webView1.getSettings().setJavaScriptEnabled(true);
                                //webView1.loadUrl("http://189.139.52.253/26/off");
                                webView1.loadUrl(redPublica + ":80/26/off");
                            }
                            break;

                        case 2:
                            WebView webView1 = findViewById(R.id.webViewAGlobalAcciones);
                            webView1.getSettings().setJavaScriptEnabled(true);
                            //webView1.loadUrl("http://189.139.52.253/26/off");
                            webView1.loadUrl(redPublica + ":80/26/off");
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

    private static Pines1 getPines1(int jsonBody) {
        Gson gson = new Gson();
        return gson.fromJson(String.valueOf(jsonBody), Pines1.class);
    }

    private static Pines1 getPines12(String jsonBody) {
        Gson gson = new Gson();
        return gson.fromJson(jsonBody, Pines1.class);
        //return gson.fromJson(String.valueOf(jsonBody), Pines1.class);
    }


    public void pantallaAGlobal(View view) {
        //startActivity(Utils.setBundleUser(usuario, this, APanelDeControl.class));
        Intent i = new Intent(this, APanelDeControl.class);
        startActivity(i);
        finish();


    }

    public void pantallaLogin(View view) {
        //startActivity(Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }


    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case MSG_DISMISS_DIALOG:
                    if (mAlertDialog != null && mAlertDialog.isShowing()) {
                        mAlertDialog.dismiss();
                    }
                    break;

                default:
                    break;
            }
        }
    };

    private void abriendoMotor() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("\nPor favor espere un momento \n a que termine de abir el tejado\n");
        builder.setTitle("Abriendo Tejado");
        builder.setCancelable(false);
        mAlertDialog = builder.create();
        mAlertDialog.show();
        mHandler.sendEmptyMessageDelayed(MSG_DISMISS_DIALOG, TIME_OUT);
    }

    private void cerrandoMotor() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("\nPor favor espere un momento \n a que termine de cerrar el tejado\n");
        builder.setTitle("Cerrando Tejado");
        builder.setCancelable(false);
        mAlertDialog = builder.create();
        mAlertDialog.show();
        mHandler.sendEmptyMessageDelayed(MSG_DISMISS_DIALOG, TIME_OUT);
    }

    private class getPines extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

            ListAdapter listAdapter = new SimpleAdapter(AGlobalAcciones.this,
                    nameList, R.layout.activity_a_global_acciones, new String[]{"pin25"}, new int[]{R.id.textViewAcciones1});

            listView.setAdapter(listAdapter);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = new ProgressDialog(AGlobalAcciones.this);
            progressDialog.setMessage("Cargando...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Handle handle = new Handle();

            String jsonString = handle.httpServiceCall(url);
            if (jsonString != null) {
                try {
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray pines = jsonObject.getJSONArray("Pines1");

                    for (int i = 0; i < pines.length(); i++) {
                        JSONObject jsonObject1 = pines.getJSONObject(i);
                        String pin = jsonObject1.getString("pin25");
                        String out = jsonObject1.getString("out");

                        HashMap<String, String> nameMap = new HashMap<>();

                        nameMap.put("pin25", pin);
                        nameMap.put("out", out);

                        nameList.add(nameMap);
                    }

                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "Error al obtener Json", Toast.LENGTH_LONG).show();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Error al obtener Json", Toast.LENGTH_LONG).show();

                        }
                    });
                }
            } else {
                Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Server Error", Toast.LENGTH_LONG).show();

                    }
                });
            }

            return null;
        }
    }









    // Title AsyncTask
    private class Title extends AsyncTask<Void, Void, Void> {
        String title;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(AGlobalAcciones.this);
            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                //Document document = Jsoup.connect(url).get();
                Document document = Jsoup.connect(url).ignoreContentType(true).get();
                // Get the html document title
                title = document.title();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            TextView txttitle = (TextView) findViewById(R.id.textView22);
            txttitle.setText(title);
            mProgressDialog.dismiss();
        }
    }



    // Description AsyncTask
    private class Description extends AsyncTask<Void, Void, Void> {
        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(AGlobalAcciones.this);
            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                //Document document = Jsoup.connect(url).get();
                Document document = Jsoup.connect(url).ignoreContentType(true).get();
                // Using Elements to get the Meta data
                Elements description = document
                        .select("meta[name=description]");
                // Locate the content attribute
                desc = description.attr("content");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set description into TextView
            TextView txtdesc = (TextView) findViewById(R.id.textView22);
            txtdesc.setText(desc);
            mProgressDialog.dismiss();
        }


    }


}
