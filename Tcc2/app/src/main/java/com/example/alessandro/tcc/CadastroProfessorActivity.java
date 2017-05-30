package com.example.alessandro.tcc;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class CadastroProfessorActivity extends Activity {
    private EditText nome, rg, cpf, rua, numero, bairro, cidade, estado, complemento, cep,
            sexo, email;
    private Button proximo;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor);

        proximo = (Button) findViewById(R.id.bt_proximo_professor);
        nome = (EditText) findViewById(R.id.et_nome_professor);
        rua = (EditText) findViewById(R.id.et_rua_professor);
        numero = (EditText) findViewById(R.id.et_numero_professor);
        bairro = (EditText) findViewById(R.id.et_bairro_professor);
        cidade = (EditText) findViewById(R.id.et_cidade_professor);
        estado = (EditText) findViewById(R.id.et_estado_professor);
        complemento = (EditText) findViewById(R.id.et_complemento_professor);
        cep = (EditText) findViewById(R.id.et_cep_professor);
        rg = (EditText) findViewById(R.id.et_rg_professor);
        cpf = (EditText) findViewById(R.id.et_cpf_professor);
        sexo = (EditText) findViewById(R.id.et_sexo_professor);
        email = (EditText) findViewById(R.id.et_email_professor);

        sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("nomeprofessor", nome.getText().toString());
        editor.commit();
        editor.putString("rgprofessor", rg.getText().toString());
        editor.commit();
        editor.putString("cpfprofessor", cpf.getText().toString());
        editor.commit();
        editor.putString("ruaprofessor", rua.getText().toString());
        editor.commit();
        editor.putInt("numeroprofessor", Integer.parseInt(numero.getText().toString()));
        editor.commit();
        editor.putString("bairroprofessor", bairro.getText().toString());
        editor.commit();
        editor.putString("cidadeprofessor", cidade.getText().toString());
        editor.commit();
        editor.putString("estadoprofessor", estado.getText().toString());
        editor.commit();
        editor.putString("complementoprofessor", complemento.getText().toString());
        editor.commit();
        editor.putInt("cepprofessor", Integer.parseInt(cep.getText().toString()));
        editor.commit();
        editor.putString("sexoprofessor", sexo.getText().toString());
        editor.commit();
        editor.putString("emailprofessor", email.getText().toString());
        editor.commit();

    }

}
