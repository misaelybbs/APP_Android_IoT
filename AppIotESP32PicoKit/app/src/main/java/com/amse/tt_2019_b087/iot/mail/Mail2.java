package com.amse.tt_2019_b087.iot.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.MainActivity;
import com.amse.tt_2019_b087.iot.app_iot_esp32_pico_kit.R;

public class Mail2 extends AppCompatActivity {


    private EditText email, subject, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail2);

        email = findViewById(R.id.editTextRecuperarContraseniaUsuario);
        subject = findViewById(R.id.editTextRecuperarContraseniaPassword);
        message = findViewById(R.id.txtRecuperarContraseniaCorreo);
    }

    private void senEmail() {
        String mEmail = email.getText().toString();
        String mSubject = subject.getText().toString();
        String mMessage = message.getText().toString();


        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mEmail, mSubject, mMessage);

        javaMailAPI.execute();
    }

    public void pantallaLogin(View view) {

        senEmail();

        //startActivity( Utils.setBundleUser(usuario, this, MainActivity.class));
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

}
