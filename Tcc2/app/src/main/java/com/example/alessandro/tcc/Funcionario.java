package com.example.alessandro.tcc;

import java.util.Date;

/**
 * Created by Alessandro on 08/05/2017.
 */

public class Funcionario extends Pessoa {
    private double salario;
    private int id;
    private double carga_horaria;
    private String cargo;

    public Funcionario(String nome, String cpf, String rg, String nacionalidade, String sexo, String naturalidade, Endereco endereco,
                       Date data_nascimento, Telefone telefone, String email, double salario, int id, double carga_horaria,
                       String cargo){
        super(nome, cpf, rg, nacionalidade, sexo, naturalidade, endereco, data_nascimento, telefone, email);

        this.salario = salario;
        this.id = id;
        this.carga_horaria = carga_horaria;
        this.cargo = cargo;
    }

    public double getSalario(){
        return salario;
    }
    public void setSalario(double salario){
        this.salario = salario;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public double getCarga_horaria(){
        return carga_horaria;
    }
    public void setCarga_horaria(double carga_horaria){
        this.carga_horaria = carga_horaria;
    }

    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
}