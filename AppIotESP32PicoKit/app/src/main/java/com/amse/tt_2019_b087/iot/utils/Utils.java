package com.amse.tt_2019_b087.iot.utils;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.MainActivity;
import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.PanelDeControl;
import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.Registrar;
import com.amse.tt_2019_b087.iot.dto.Usuario;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Properties;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {

    private static final int ACCESS_FINE_LOCATION_PERMISSION_CODE = 101;
    private static int tipoRed;
    private static String red = "";
    public static final String EMAIL = "misaelybbs@gmail.com";
    public static final String PASS = "arxrwzqjjzebypop";

    public static void checkPermission(String permission, int requestCode, AppCompatActivity context) {
        //if (ContextCompat.checkSelfPermission(MainActivity.this, permission)
        if (ContextCompat.checkSelfPermission(context, permission)
                == PackageManager.PERMISSION_DENIED) {

            //ActivityCompat.requestPermissions(MainActivity.this, new String[]{permission}, requestCode);
            ActivityCompat.requestPermissions(context, new String[]{permission}, requestCode);

        } else {
            //Toast.makeText(MainActivity.this, "Permission already granted", Toast.LENGTH_SHORT).show();
            //Toast.makeText(context, "Permission already granted", Toast.LENGTH_SHORT).show();

        }
    }

    public static int chkStatus(AppCompatActivity context, int tipo) {
        checkPermission(Manifest.permission.ACCESS_FINE_LOCATION, ACCESS_FINE_LOCATION_PERMISSION_CODE, context);

        //final ConnectivityManager connMgr = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if (wifi.isConnected()) {
            //Toast.makeText(context, "Conexión Wifi", Toast.LENGTH_LONG).show();
            wifi.isConnected();
            tipoRed = 1;
            return tipoRed;

        } else if (mobile.isConnected()) {
            //Toast.makeText(context, "Conexión 4G", Toast.LENGTH_LONG).show();
            tipoRed = 2;
            return tipoRed;
        } else {
            //Toast.makeText(this, "No existe una conexión a internet", Toast.LENGTH_LONG).show();
            //Toast.makeText(context, "No existe una conexión a internet", Toast.LENGTH_LONG).show();

            //AlertDialog.Builder builder = new AlertDialog.Builder(this);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle("Error");
            builder.setMessage("No se detectó una conexión mediante Wifi o Datos.\n\nLa aplicación no funcionará correctamente.");
            builder.setPositiveButton("Aceptar", null);

            AlertDialog dialog = builder.create();
            dialog.show();
            tipoRed = 3;
        }
        return tipo;
    }

    public static String getWifiName(Context context, String nombreRed) {
        WifiManager manager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = manager.getConnectionInfo();
        if (manager.isWifiEnabled()) {
            if (wifiInfo != null) {
                NetworkInfo.DetailedState state = WifiInfo.getDetailedStateOf(wifiInfo.getSupplicantState());
                if (state == NetworkInfo.DetailedState.CONNECTED || state == NetworkInfo.DetailedState.OBTAINING_IPADDR) {
                    red = wifiInfo.getSSID();
                    return red;
                }
            }
        }
        return nombreRed;
    }


    public static Object getBuilder(String urlBase, Class clazz) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        return retrofit.create(clazz);
    }

    public static String getProperty(String key, Context context) throws IOException {
        try {
            Properties properties = new Properties();
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open("app.properties");
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.fillInStackTrace();
        }
        return null;
    }

    public static Intent setBundleUser(Usuario usuario, Context context, Class clazz) {
        Intent i = new Intent(context, clazz);
        i.putExtra("usuario", usuario);
        return i;
    }

    public static Usuario getBundleUser(Bundle bundle) {
        Usuario usuario = null;
        if (bundle != null) {
            Object o = bundle.get("usuario");
            usuario = (Usuario) o;
        }
        return usuario;
    }

    public static void setTextUser(int objectId, AppCompatActivity context, String string) {
        TextView textVUsuario = (TextView) context.findViewById(objectId);
        textVUsuario.setText(string);
    }

    public static void setMessage(String string, Context context) {
        CharSequence text = string;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public static void showPantalla(Context context, Class clazz) {
        Intent i = new Intent(context, clazz);
        context.startActivity(i);
    }

    public static void registroExitoso(final Context context, Class clazz) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Registro Exitoso");
        builder.setMessage("Usuario Registrado Exitosamente");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showPantalla(context, MainActivity.class);
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void registroError(final Context context, Class clazz) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error");
        builder.setMessage("Nickname ya registrado. \n\nIntente nuevamente con otro diferente");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showPantalla(context, MainActivity.class);
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public static void loginError(final Context context, Class clazz) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Error");
        builder.setMessage("Usuario o contraseña incorrecta \n\nIntente nuevamente");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Utils.showPantalla(context, MainActivity.class);
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }






}
