package com.example.alessandro.tcc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroAlunoActivity extends Activity {
    private EditText nome, rua, numero, bairro, cidade, cep, estado, complemento, sexo, nacionalidade, naturalidade, cpf, rg,
            email, senha,cota;
    private Button proximo;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    @Override
    //carregando o layout
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        //permitir a localização do widget
        proximo = (Button) findViewById(R.id.bt_proximo_aluno);
        nome = (EditText) findViewById(R.id.et_nome_aluno);
        rua = (EditText) findViewById(R.id.et_rua_aluno);
        numero = (EditText) findViewById(R.id.et_numero_aluno);
        bairro = (EditText) findViewById(R.id.et_bairro_aluno);
        cidade = (EditText) findViewById(R.id.et_cidade_aluno);
        estado = (EditText) findViewById(R.id.et_estado_aluno);
        cep = (EditText) findViewById(R.id.et_cep_aluno);
        complemento = (EditText) findViewById(R.id.et_complemento_aluno);
        sexo = (EditText) findViewById(R.id.et_sexo_aluno);
        nacionalidade = (EditText) findViewById(R.id.et_nacionalidade_aluno);
        naturalidade = (EditText) findViewById(R.id.et_naturalidade_aluno);
        cpf = (EditText) findViewById(R.id.et_cpf_aluno);
        rg = (EditText) findViewById(R.id.et_rg_aluno);
        email = (EditText) findViewById(R.id.et_email_aluno);
        senha = (EditText) findViewById(R.id.et_senha_aluno);
        cota = (EditText) findViewById(R.id.et_cota_aluno);

        proximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //salvando as informações da primeira tela
                sharedPreferences = getPreferences(Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("nomealuno", nome.getText().toString());
                editor.commit();
                editor.putString("ruaaluno", rua.getText().toString());
                editor.commit();
                editor.putInt("numeroaluno", Integer.parseInt(numero.getText().toString()));
                editor.commit();
                editor.putString("bairroaluno", bairro.getText().toString());
                editor.commit();
                editor.putString("cidadealuno", cidade.getText().toString());
                editor.commit();
                editor.putString("estadoaluno", estado.getText().toString());
                editor.commit();
                editor.putString("cepaluno", cep.getText().toString());
                editor.commit();
                editor.putString("complementoaluno", complemento.getText().toString());
                editor.commit();
                editor.putString("sexoaluno", sexo.getText().toString());
                editor.commit();
                editor.putString("nacionalidadealuno", nacionalidade.getText().toString());
                editor.commit();
                editor.putString("naturalidadealuno", naturalidade.getText().toString());
                editor.commit();
                editor.putString("cpfaluno", cpf.getText().toString());
                editor.commit();
                editor.putString("rgaluno", rg.getText().toString());
                editor.commit();
                editor.putString("emailaluno", email.getText().toString());
                editor.commit();
                editor.putString("senhaaluno", senha.getText().toString());
                editor.commit();
                editor.putString("cotaaluno", cota.getText().toString());
                editor.commit();

                Intent intent = new Intent (CadastroAlunoActivity.this, CadastroAlunoActivity2.class);
                startActivity(intent);

            }
        });


    }

}
