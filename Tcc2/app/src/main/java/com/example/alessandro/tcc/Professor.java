package com.example.alessandro.tcc;

import java.util.Date;

/**
 * Created by Alessandro on 08/05/2017.
 */

public class Professor extends Funcionario {
    private int matricua;
    private double hora_aula;
    private Disciplina disciplina;

    public Professor(String nome, String cpf, String rg, String nacionalidade, char sexo, String naturalidade, Endereco endereco,
                     Date data_nascimento, Telefone telefone, double salario, int id, double carga_horaria, String cargo,
                     int matricula, double hora_aula, Disciplina disciplina){
        super(nome, cpf, rg, nacionalidade, sexo, naturalidade, endereco, data_nascimento, telefone, salario, id, carga_horaria,
                cargo);

        this.matricua = matricula;
        this.hora_aula = hora_aula;
        this.disciplina = disciplina;
    }

    public int getMatricua(){
        return matricua;
    }
    public void setMatricua(int matricua){
        this.matricua = matricua;
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
