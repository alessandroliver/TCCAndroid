package com.example.alessandro.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroFuncionarioActivity2 extends Activity {
    private EditText ddd, telefone, operadora, nacionalidade, naturalidade, senha, id, data_nascimento, cargo, salario;
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
        setContentView(R.layout.activity_cadastro_funcionario2);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_aluno);
        ddd = (EditText) findViewById(R.id.et_ddd_aluno);
        telefone = (EditText) findViewById(R.id.et_telefone_aluno);
        operadora = (EditText) findViewById(R.id.et_operadora_aluno);
        nacionalidade = (EditText) findViewById(R.id.et_nacionalidade_funcionario);
        naturalidade = (EditText) findViewById(R.id.et_naturalidade_funcionario);
        senha = (EditText) findViewById(R.id.et_senha_funcionario);
        id = (EditText) findViewById(R.id.et_id_funcionario);
        data_nascimento = (EditText) findViewById(R.id.et_dn_funcionario);
        cargo = (EditText) findViewById(R.id.et_cargo_funcionario);
        salario = (EditText) findViewById(R.id.et_salario_funcionario);

        nome = CadastroFuncionarioActivity.sharedPreferences.getString("nomefuncionario", "");
        rua = CadastroFuncionarioActivity.sharedPreferences.getString("ruafuncionario", "");
        numero = CadastroFuncionarioActivity.sharedPreferences.getInt("numerofuncionario", 0);
        bairro = CadastroFuncionarioActivity.sharedPreferences.getString("bairrofuncionario", "");
        cidade = CadastroFuncionarioActivity.sharedPreferences.getString("cidadefuncionario", "");
        cep = CadastroFuncionarioActivity.sharedPreferences.getString("cepfuncionario", "");
        estado = CadastroFuncionarioActivity.sharedPreferences.getString("estadofuncionario", "");
        complemento = CadastroFuncionarioActivity.sharedPreferences.getString("complementofuncionario", "");
        sexo = CadastroFuncionarioActivity.sharedPreferences.getString("sexofuncionario", "");
        cpf = CadastroFuncionarioActivity.sharedPreferences.getString("cpffuncionario", "");
        rg = CadastroFuncionarioActivity.sharedPreferences.getString("rgfuncionario", "");
        email = CadastroFuncionarioActivity.sharedPreferences.getString("emailfuncionario", "");

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
        Funcionario funcionario = new Funcionario(nome,cpf,rg,nacionalidade.getText().toString(),sexo,
                naturalidade.getText().toString(),endereco,dt,tel,email,senha.getText().toString(),
                Double.parseDouble(salario.getText().toString()),Integer.parseInt(id.getText().toString()),0,
                cargo.getText().toString());

        FuncionarioDBController funcionarioDBController = new FuncionarioDBController(this);

        funcionarioDBController.insert(funcionario);
    }

}
