package com.molosoft.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void enviarMensaje(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        EditText subject = (EditText) findViewById(R.id.asunto);
        String asunto = subject.getText().toString();
        EditText message = (EditText) findViewById(R.id.mensaje);
        String mensaje = message.getText().toString();
        String uriText = "mailto:" + Uri.encode("email@gmail.com") +
                "?subject=" + Uri.encode(asunto)+
                "&body=" + Uri.encode(mensaje);
        Uri uri = Uri.parse(uriText);
        intent.setData(uri);
        startActivity(Intent.createChooser(intent,"Enviar el mensaje usando..."));

    }
}