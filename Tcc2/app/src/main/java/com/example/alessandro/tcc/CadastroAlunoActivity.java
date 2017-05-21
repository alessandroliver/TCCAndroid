package com.example.alessandro.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class CadastroAlunoActivity extends Activity {
    private EditText nome, endereco, matricula, sexo, nacionalidade, turma, naturalidade, cpf, rg, telefone, email, nota_entrada,
    curso, data_nascimnto, senha;
    private Spinner cota;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_aluno);
        nome = (EditText) findViewById(R.id.et_nome_aluno);
        endereco = (EditText) findViewById(R.id.et_endereco_aluno);
        matricula = (EditText) findViewById(R.id.et_matricula_aluno);
        sexo = (EditText) findViewById(R.id.et_sexo_aluno);
        nacionalidade = (EditText) findViewById(R.id.et_nacionalidade_aluno);
        turma = (EditText) findViewById(R.id.et_turma_aluno);
        naturalidade = (EditText) findViewById(R.id.et_naturalidade_aluno);
        cpf = (EditText) findViewById(R.id.et_cpf_aluno);
        rg = (EditText) findViewById(R.id.et_rg_aluno);
        telefone = (EditText) findViewById(R.id.et_telefone_aluno);
        email = (EditText) findViewById(R.id.et_email_aluno);
        nota_entrada = (EditText) findViewById(R.id.et_ne_aluno);
        curso = (EditText) findViewById(R.id.et_curso_aluno);
        data_nascimnto = (EditText) findViewById(R.id.et_dn_aluno);
        senha = (EditText) findViewById(R.id.et_senha_aluno);
        cota = (Spinner) findViewById(R.id.s_cota_aluno);



    }

}
