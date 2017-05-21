package com.example.alessandro.tcc;

import java.util.Date;

/**
 * Created by Alessandro on 08/05/2017.
 */

public class Professor extends Funcionario {
    private double hora_aula;
    private Disciplina disciplina;

    public Professor(String nome, String cpf, String rg, String nacionalidade, char sexo, String naturalidade, Endereco endereco,
                     Date data_nascimento, Telefone telefone, String email, double salario, int id, double carga_horaria,
                     String cargo, double hora_aula, Disciplina disciplina){
        super(nome, cpf, rg, nacionalidade, sexo, naturalidade, endereco, data_nascimento, telefone, email, salario, id,
                carga_horaria, cargo);

        this.hora_aula = hora_aula;
        this.disciplina = disciplina;
    }

    public double getHora_aula(){
        return hora_aula;
    }
    public void setHora_aula(double hora_aula){
        this.hora_aula = hora_aula;
    }

    public Disciplina getDisciplina(){
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
    }
}
