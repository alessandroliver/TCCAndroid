package com.example.alessandro.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroProfessorActivity2 extends Activity {
    private EditText ddd, telefone, operadora, id, nacionalidade, naturalidade, data_nascimento, salario, disciplina, senha;
    private Button cadastrar, proximo;
    private String nome;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;
    private String complemento;
    private String sexo;
    private String cpf;
    private String rg;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_professor2);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_aluno);
        ddd = (EditText) findViewById(R.id.et_ddd_aluno);
        telefone = (EditText) findViewById(R.id.et_telefone_aluno);
        operadora = (EditText) findViewById(R.id.et_operadora_aluno);
        id = (EditText) findViewById(R.id.et_id_funcionario);
        nacionalidade = (EditText) findViewById(R.id.et_nacionalidade_funcionario);
        naturalidade = (EditText) findViewById(R.id.et_naturalidade_funcionario);
        data_nascimento = (EditText) findViewById(R.id.et_dn_funcionario);
        salario = (EditText) findViewById(R.id.et_salario_funcionario);
        disciplina = (EditText) findViewById(R.id.et_disciplina_professor);
        senha = (EditText) findViewById(R.id.et_senha_funcionario);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nome = CadastroProfessorActivity.sharedPreferences.getString("nomeprofessor", "");
                rua = CadastroProfessorActivity.sharedPreferences.getString("ruaprofessor", "");
                numero = CadastroProfessorActivity.sharedPreferences.getInt("numeroprofessor", 0);
                bairro = CadastroProfessorActivity.sharedPreferences.getString("bairroprofessor", "");
                cidade = CadastroProfessorActivity.sharedPreferences.getString("cidadeprofessor", "");
                cep = CadastroProfessorActivity.sharedPreferences.getString("cepprofessor", "");
                estado = CadastroProfessorActivity.sharedPreferences.getString("estadoprofessor", "");
                complemento = CadastroProfessorActivity.sharedPreferences.getString("complementoprofessor", "");
                sexo = CadastroProfessorActivity.sharedPreferences.getString("sexoprofessor", "");
                cpf = CadastroProfessorActivity.sharedPreferences.getString("cpfprofessor", "");
                rg = CadastroProfessorActivity.sharedPreferences.getString("rgprofessor", "");
                email = CadastroProfessorActivity.sharedPreferences.getString("emailprofessor", "");

                DateFormat dft = new SimpleDateFormat("MM/dd/yyyy");
                Date dt = null;
                try {
                    dt = dft.parse(data_nascimento.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Endereco endereco = new Endereco(rua,bairro,numero,cidade,cep,estado,complemento);
                Telefone tel = new Telefone(operadora.getText().toString(),Integer.parseInt(telefone.getText().toString()),
                        Integer.parseInt(ddd.getText().toString()));
                Disciplina dis = new Disciplina(nome,0,null,null,0,0,0,0,0,0);
                Professor professor = new Professor(nome,cpf,rg,nacionalidade.getText().toString(),sexo,
                        naturalidade.getText().toString(),endereco,dt,tel,email,senha.getText().toString(),
                        Double.parseDouble(salario.getText().toString()),Integer.parseInt(id.getText().toString()),0,"Professor",
                        dis);

                ProfessorDBController professorDBController = new ProfessorDBController(CadastroProfessorActivity2.this);

                professorDBController.insert(professor);

                Intent intent = new Intent (CadastroProfessorActivity2.this, ListProfessorActivity.class);
                startActivity(intent);

            }
        });



    }

}
