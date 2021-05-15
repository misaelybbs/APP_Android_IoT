package com.amse.tt_2019_b087.iot.service.impl;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.AGlobalAcciones;
import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.CSalaTemperatura;
import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.PanelDeControl;
import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.Registrar;
import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.SCorazon;
import com.amse.tt_2019_b087.iot.model.login.Login;
import com.amse.tt_2019_b087.iot.model.login.User;
import com.amse.tt_2019_b087.iot.model.pines1.Pines1;
import com.amse.tt_2019_b087.iot.model.pines1.ResponsePines1;
import com.amse.tt_2019_b087.iot.model.registro.Registro;
import com.amse.tt_2019_b087.iot.model.registro.RegistroUser;
import com.amse.tt_2019_b087.iot.service.UserInterface;
import com.amse.tt_2019_b087.iot.utils.Utils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServicesImpl extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static String token;
    private Context context;
    int redTipo = 0;
    String nombreRed;
    String wifiLocal = "";
    String redLocal = "";
    String redPublica = "";

    public ServicesImpl(Context context) {
        this.context = context;
    }

    public void login(final AppCompatActivity context, Login login) {

        redLocal = ServicesImpl.urlLocal2(context, redLocal);
        redPublica = ServicesImpl.urlPublica2(context, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(context, wifiLocal);

        redTipo = Utils.chkStatus(context, redTipo);
        nombreRed = Utils.getWifiName(context, nombreRed);

        switch (redTipo) {
            case 1:
                if (nombreRed.equals(wifiLocal)) {
                    //webViewTemperatura.loadUrl(redLocal + ":84/");

                    try {
                        String p = Utils.getProperty("url.base.services", this.context);
                        Log.d("JWT_DECODED", "Body: " + p);
                        //http://192.168.1.70:8761/api/login/authenticate
                        UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
                        //Login login = new Login("1", "1");
                        Call<User> call = userInterface.login(login);
                        call.enqueue(new Callback<User>() {

                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if (response.isSuccessful()) {
                                    //Toast.makeText(MainActivity.this, response.body().getCode(), Toast.LENGTH_LONG).show();
                                    token = response.body().getCode();
                                    System.out.println("Println ==" + token);
                                    // Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                                    Utils.showPantalla(context, PanelDeControl.class);

                                } else {

                                    Utils.loginError(context, Registrar.class);
                                    Toast.makeText(context, "Login not correct", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                // Toast.makeText(MainActivity.this, "Error :(", Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    //webViewTemperatura.loadUrl(redPublica + ":84/");
                    try {
                        String p = Utils.getProperty("url.base.services2", this.context);
                        Log.d("JWT_DECODED", "Body: " + p);
                        //http://192.168.1.70:8761/api/login/authenticate
                        UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
                        //Login login = new Login("1", "1");
                        Call<User> call = userInterface.login(login);
                        call.enqueue(new Callback<User>() {

                            @Override
                            public void onResponse(Call<User> call, Response<User> response) {
                                if (response.isSuccessful()) {
                                    //Toast.makeText(MainActivity.this, response.body().getCode(), Toast.LENGTH_LONG).show();
                                    token = response.body().getCode();
                                    System.out.println("Println ==" + token);
                                    // Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                                    Utils.showPantalla(context, PanelDeControl.class);

                                } else {

                                    Utils.loginError(context, Registrar.class);
                                    Toast.makeText(context, "Login not correct", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<User> call, Throwable t) {
                                // Toast.makeText(MainActivity.this, "Error :(", Toast.LENGTH_LONG).show();
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case 2:
                //webViewTemperatura.loadUrl(redPublica + ":84/");
                try {
                    String p = Utils.getProperty("url.base.services2", this.context);
                    Log.d("JWT_DECODED", "Body: " + p);
                    //http://192.168.1.70:8761/api/login/authenticate
                    UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
                    //Login login = new Login("1", "1");
                    Call<User> call = userInterface.login(login);
                    call.enqueue(new Callback<User>() {

                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if (response.isSuccessful()) {
                                //Toast.makeText(MainActivity.this, response.body().getCode(), Toast.LENGTH_LONG).show();
                                token = response.body().getCode();
                                System.out.println("Println ==" + token);
                                // Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                                Utils.showPantalla(context, PanelDeControl.class);

                            } else {

                                Utils.loginError(context, Registrar.class);
                                Toast.makeText(context, "Login not correct", Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            // Toast.makeText(MainActivity.this, "Error :(", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }

        /*
        try {
            String p = Utils.getProperty("url.base.services", this.context);
            Log.d("JWT_DECODED", "Body: " + p);
            //http://192.168.1.70:8761/api/login/authenticate
            UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
            //Login login = new Login("1", "1");
            Call<User> call = userInterface.login(login);
            call.enqueue(new Callback<User>() {

                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        //Toast.makeText(MainActivity.this, response.body().getCode(), Toast.LENGTH_LONG).show();
                        token = response.body().getCode();
                        System.out.println("Println ==" + token);
                        // Toast.makeText(context, token, Toast.LENGTH_SHORT).show();
                        Utils.showPantalla(context, PanelDeControl.class);

                    } else {

                        Utils.loginError(context, Registrar.class);
                        Toast.makeText(context, "Login not correct", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    // Toast.makeText(MainActivity.this, "Error :(", Toast.LENGTH_LONG).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        */
    }

    public void sendRegistro(Registro registro, final AppCompatActivity context) {

        redLocal = ServicesImpl.urlLocal2(context, redLocal);
        redPublica = ServicesImpl.urlPublica2(context, redPublica);
        wifiLocal = ServicesImpl.wifiLocal(context, wifiLocal);

        redTipo = Utils.chkStatus(context, redTipo);
        nombreRed = Utils.getWifiName(context, nombreRed);

        switch (redTipo) {
            case 1:
                if (nombreRed.equals(wifiLocal)) {
                    //webViewTemperatura.loadUrl(redLocal + ":82/");

                    try {
                        String p = Utils.getProperty("url.base.services", this.context);
                        UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
                        Call<RegistroUser> call = userInterface.savePost(registro);
                        call.enqueue(new Callback<RegistroUser>() {
                            @Override
                            public void onResponse(Call<RegistroUser> call, Response<RegistroUser> response) {
                                if (response.isSuccessful()) {
                                    Log.i(TAG, "post submitted to API." + response.body().toString());
                                    Utils.registroExitoso(context, Registrar.class);
                                    finish();

                                } else {
                                    Utils.registroError(context, Registrar.class);
                                }
                            }

                            @Override
                            public void onFailure(Call<RegistroUser> call, Throwable t) {
                                Log.e(TAG, "Unable to submit post to API.");
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    // webViewTemperatura.loadUrl(redPublica + ":82/");
                    try {
                        String p = Utils.getProperty("url.base.services2", this.context);
                        UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
                        Call<RegistroUser> call = userInterface.savePost(registro);
                        call.enqueue(new Callback<RegistroUser>() {
                            @Override
                            public void onResponse(Call<RegistroUser> call, Response<RegistroUser> response) {
                                if (response.isSuccessful()) {
                                    Log.i(TAG, "post submitted to API." + response.body().toString());
                                    Utils.registroExitoso(context, Registrar.class);
                                    finish();

                                } else {
                                    Utils.registroError(context, Registrar.class);
                                }
                            }

                            @Override
                            public void onFailure(Call<RegistroUser> call, Throwable t) {
                                Log.e(TAG, "Unable to submit post to API.");
                            }
                        });

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case 2:
                //webViewTemperatura.loadUrl(redPublica + ":82/");

                try {
                    String p = Utils.getProperty("url.base.services2", this.context);
                    UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
                    Call<RegistroUser> call = userInterface.savePost(registro);
                    call.enqueue(new Callback<RegistroUser>() {
                        @Override
                        public void onResponse(Call<RegistroUser> call, Response<RegistroUser> response) {
                            if (response.isSuccessful()) {
                                Log.i(TAG, "post submitted to API." + response.body().toString());
                                Utils.registroExitoso(context, Registrar.class);
                                finish();

                            } else {
                                Utils.registroError(context, Registrar.class);
                            }
                        }

                        @Override
                        public void onFailure(Call<RegistroUser> call, Throwable t) {
                            Log.e(TAG, "Unable to submit post to API.");
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }

        /*
        try {
            String p = Utils.getProperty("url.base.services", this.context);
            UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
            Call<RegistroUser> call = userInterface.savePost(registro);
            call.enqueue(new Callback<RegistroUser>() {
                @Override
                public void onResponse(Call<RegistroUser> call, Response<RegistroUser> response) {
                    if (response.isSuccessful()) {
                        Log.i(TAG, "post submitted to API." + response.body().toString());
                        Utils.registroExitoso(context, Registrar.class);
                        finish();

                    } else {
                        Utils.registroError(context, Registrar.class);
                    }
                }

                @Override
                public void onFailure(Call<RegistroUser> call, Throwable t) {
                    Log.e(TAG, "Unable to submit post to API.");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        */
    }

    public void leerPines1(Pines1 pines1) {
        try {
            String p = Utils.getProperty("url.base.ip.local", this.context);
            //Log.d("JWT_DECODED", "Body: " + p);
            UserInterface userInterface = (UserInterface) Utils.getBuilder(p, UserInterface.class);
            Call<ResponsePines1> call = userInterface.pines1(pines1);
            call.enqueue(new Callback<ResponsePines1>() {
                @Override
                public void onResponse(Call<ResponsePines1> call, Response<ResponsePines1> response) {
                    if (response.isSuccessful()) {
                        Log.i(TAG, "post submitted to API." + response.body().toString());
                        Utils.registroExitoso(context, AGlobalAcciones.class);
                        finish();

                    } else {
                        Utils.registroError(context, AGlobalAcciones.class);
                    }
                }

                @Override
                public void onFailure(Call<ResponsePines1> call, Throwable t) {
                    Log.e(TAG, "Unable to submit post to API.");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String urlLocal(AppCompatActivity context, String urlLocal) {
        try {
            String url = Utils.getProperty("url.base.ip.local", context);
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlLocal;
    }

    public static String urlLocal2(AppCompatActivity context, String urlLocal) {
        try {
            String url = Utils.getProperty("url.base.ip.local2", context);
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlLocal;
    }

    public static String urlLocal3(AppCompatActivity context, String urlLocal) {
        try {
            String url = Utils.getProperty("url.base.ip.local3", context);
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlLocal;
    }


    public static String urlPublica(AppCompatActivity context, String urlP) {
        try {
            String url = Utils.getProperty("url.base.ip.publica", context);
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlP;
    }

    public static String urlPublica2(AppCompatActivity context, String urlP) {
        try {
            String url = Utils.getProperty("url.base.ip.publica2", context);
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return urlP;
    }

    public static String wifiLocal(AppCompatActivity context, String wifiLocal) {
/*
        int redTipo = 0;
        String nombreRed = "";
        String wifiLocal2 = "";
        String redLocal = "";
        String redPublica = "";
        redLocal = ServicesImpl.urlLocal3(context, redLocal);
        redPublica = ServicesImpl.urlPublica2(context, redPublica);
        wifiLocal2 = ServicesImpl.wifiLocal(context, wifiLocal);


        switch (redTipo) {
            case 1:
                if (nombreRed.equals(wifiLocal)) {
                    //webViewTemperatura.loadUrl(redLocal + ":82/");

                    try {

                        String url = Utils.getProperty("url.base.services", context);
                        return url;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    //webViewTemperatura.loadUrl(redPublica + ":82/");
                    try {

                        String url = Utils.getProperty("url.base.services2", context);
                        return url;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case 2:
                //webViewTemperatura.loadUrl(redPublica + ":82/");
                try {

                    String url = Utils.getProperty("url.base.services2 ", context);
                    return url;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            default:
                break;
        }

        */

        try {

            String url = Utils.getProperty("url.base.nombre.wifiLocal", context);
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }


        return wifiLocal;
    }



}
