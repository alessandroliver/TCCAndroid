package com.example.alessandro.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class CadastroFuncionarioActivity extends Activity {
    private EditText nome, endereco, cargo, rg, cpf, nacionalidade, naturalidade, id, sexo, telefone, email, salario;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionario);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_funcionario);
        nome = (EditText) findViewById(R.id.et_nome_funcionario);
        endereco = (EditText) findViewById(R.id.et_endereco_funcionario);
        cargo = (EditText) findViewById(R.id.et_cargo_funcionario);
        rg = (EditText) findViewById(R.id.et_rg_funcionario);
        cpf = (EditText) findViewById(R.id.et_cpf_funcionario);
        nacionalidade = (EditText) findViewById(R.id.et_nacionalidade_funcionario);
        naturalidade = (EditText) findViewById(R.id.et_naturalidade_funcionario);
        id = (EditText) findViewById(R.id.et_id_funcionario);
        sexo = (EditText) findViewById(R.id.et_sexo_funcionario);
        telefone = (EditText) findViewById(R.id.et_telefone_funcionario);
        email = (EditText) findViewById(R.id.et_email_funcionario);
        salario = (EditText) findViewById(R.id.et_salario_funcionario);

    }

}
