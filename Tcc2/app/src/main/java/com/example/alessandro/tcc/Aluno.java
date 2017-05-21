package com.example.alessandro.tcc;

import java.util.Date;

/**
 * Created by Alessandro on 08/05/2017.
 */

public class Aluno extends Pessoa{
    private String turma;
    private boolean cota;
    private String curso;
    private int matricula;
    private Date data_matricula;
    private double nota_entrada;
    private int horas_cursadas;
    private int horas_restantes;
    private Disciplina disciplina;
    private Boletim boletim;

    public Aluno(String nome, String cpf, String rg, String nacionalidade, char sexo, String naturalidade, Endereco endereco,
                 Date data_nascimento, Telefone telefone, String email, String turma, boolean cota, String curso, int matricula,
                 Date data_matricula, double nota_entrada, int horas_cursadas, int horas_restantes, Disciplina disciplina,
                 Boletim boletim){
        super(nome, cpf, rg, nacionalidade, sexo, naturalidade, endereco, data_nascimento, telefone, email);

        this.turma = turma;
        this.cota = cota;
        this.curso = curso;
        this.matricula = matricula;
        this.data_matricula = data_matricula;
        this.nota_entrada = nota_entrada;
        this.horas_cursadas = horas_cursadas;
        this.horas_restantes = horas_restantes;
        this.disciplina = disciplina;
        this.boletim = boletim;
    }

    public String getTurma(){
        return turma;
    }
    public void setTurma(String turma){
        this.turma = turma;
    }

    public boolean getCota(){
        return cota;
    }
    public void setCota(boolean cota){
        this.cota = cota;
    }

    public String getCurso(){
        return curso;
    }
    public void setCurso(String curso){
        this.curso = curso;
    }

    public int getMatricula(){
        return matricula;
    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public Date getData_matricula(){
        return data_matricula;
    }
    public void setData_matricula(Date data_matricula){
        this.data_matricula = data_matricula;
    }

    public double getNota_entrada(){
        return nota_entrada;
    }
    public void setNota_entrada(double nota_entrada){
        this.nota_entrada = nota_entrada;
    }

    public int getHoras_cursadas(){
        return horas_cursadas;
    }
    public void setHoras_cursadas(int horas_cursadas){
        this.horas_cursadas = horas_cursadas;
    }

    public int getHoras_restantes(){
        return horas_restantes;
    }
    public void setHoras_restantes(int horas_restantes){
        this.horas_restantes = horas_restantes;
    }

    public Disciplina getDisciplina(){
        return disciplina;
    }
    public void setDisciplina(Disciplina disciplina){
        this.disciplina = disciplina;
    }

    public Boletim getBoletim(){
        return boletim;
    }
    public void setBoletim(Boletim boletim){
        this.boletim = boletim;
    }
}
