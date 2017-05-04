package br.com.impacta.impactamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usuario = (EditText) findViewById(R.id.usuario);

        final EditText senha = (EditText) findViewById(R.id.senha);
        Button botaoLogin = (Button) findViewById(R.id.botaoLogin);

        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String testUsuario = usuario.getText().toString();
                Intent intent = new Intent(Login.this, TelaInicial.class);
                Toast.makeText(Login.this, "Bem vindo " + testUsuario, Toast.LENGTH_LONG).show();
                startActivity(intent);

            }
        });
    }
}
