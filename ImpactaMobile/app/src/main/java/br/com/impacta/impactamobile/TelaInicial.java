package br.com.impacta.impactamobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {

    private TextView nomeProduto;
    private TextView valorProduto;
    private TextView categoriaProduto;
    private ImageView imagemFavorito;
    private Button botaoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


        nomeProduto = (TextView) findViewById(R.id.nomeProduto);
        valorProduto = (TextView) findViewById(R.id.valorProduto);
        categoriaProduto = (TextView) findViewById(R.id.categoriaProduto);
        imagemFavorito = (ImageView) findViewById(R.id.favorito);
        botaoCadastro = (Button) findViewById(R.id.botaoCadastro);

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nomeProduto.setText("");
                valorProduto.setText("");
                categoriaProduto.setText("");

                nomeProduto.setVisibility(View.INVISIBLE);
                valorProduto.setVisibility(View.INVISIBLE);
                categoriaProduto.setVisibility(View.INVISIBLE);
                imagemFavorito.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(TelaInicial.this, CadastroProduto.class);
                startActivityForResult(intent, 1);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == -1) {
            String nome = data.getStringExtra("nomeProduto");
            String valor = data.getStringExtra("valorProduto");
            String categoria = data.getStringExtra("categoriaProduto");
            Boolean favorito = data.getExtras().getBoolean("favorito");

            nomeProduto.setVisibility(View.VISIBLE);
            valorProduto.setVisibility(View.VISIBLE);
            categoriaProduto.setVisibility(View.VISIBLE);
            imagemFavorito.setVisibility(View.VISIBLE);

            if (favorito) {
                imagemFavorito.setImageResource(android.R.drawable.btn_star_big_on);
            } else {
                imagemFavorito.setImageResource(android.R.drawable.btn_star_big_off);
            }

            nomeProduto.setText(nome);
            valorProduto.setText(valor);
            categoriaProduto.setText(categoria);

        }
    }
}
