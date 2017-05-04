package br.com.impacta.impactamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CadastroProduto extends AppCompatActivity {

    TextView nomeProduto, valorProduto, categoriaProduto;
    CheckBox favoritoCheckBox;
    Button botaoSalvar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        nomeProduto = (TextView) findViewById(R.id.nomeProduto);
        valorProduto = (TextView) findViewById(R.id.valorProduto);
        categoriaProduto = (TextView) findViewById(R.id.categoriaProduto);
        favoritoCheckBox = (CheckBox) findViewById(R.id.favorito);
        botaoSalvar = (Button) findViewById(R.id.botaoCadastro);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CadastroProduto.this, TelaInicial.class);
                Bundle dados = new Bundle();
                dados.putString("nomeProduto", nomeProduto.getText().toString());
                dados.putString("valorProduto", valorProduto.getText().toString());
                dados.putString("categoriaProduto", categoriaProduto.getText().toString());
                if (favoritoCheckBox.isChecked()) {
                    dados.putBoolean("favorito", true);
                } else {
                    dados.putBoolean("favorito", false);
                }
                it.putExtras(dados);
                setResult(RESULT_OK, it);
                finish();
            }
        });

    }
}



