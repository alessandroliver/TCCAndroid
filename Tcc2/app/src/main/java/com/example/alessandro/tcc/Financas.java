package com.example.alessandro.tcc;

import java.util.Date;

/**
 * Created by Alessandro on 09/05/2017.
 */

public class Financas {

    private Date data_recebimento_dinheiro;
    private double valor_recebido;
    private double merenda;
    private double salario_funcionarios;
    private double servicos;
    private double manutencao;
    private double material;
    private double valor_restante;

    public Financas(Date data_recebimento_dinheiro, double valor_recebido, double merenda, double salario_funcionarios,
                    double servicos, double manutencao, double material, double valor_restante){
        this.data_recebimento_dinheiro = data_recebimento_dinheiro;
        this.valor_recebido = valor_recebido;
        this.merenda = merenda;
        this.salario_funcionarios = salario_funcionarios;
        this.servicos = servicos;
        this.manutencao = manutencao;
        this.material = material;
        this.valor_restante = valor_restante;
    }

    public Date getData_recebimento_dinheiro(){
        return data_recebimento_dinheiro;
    }
    public void setData_recebimento_dinheiro(Date data_recebimento_dinheiro){
        this.data_recebimento_dinheiro = data_recebimento_dinheiro;
    }

    public double getValor_recebido(){
        return valor_recebido;
    }
    public void setValor_recebido(double valor_recebido){
        this.valor_recebido = valor_recebido;
    }

    public double getMerenda(){
        return merenda;
    }
    public void setMerenda(double merenda){
        this.merenda = merenda;
    }

    public double getSalario_funcionarios(){
        return salario_funcionarios;
    }
    public void setSalario_funcionarios(double salario_funcionarios){
        this.salario_funcionarios = salario_funcionarios;
    }

    public double getServicos(){
        return servicos;
    }
    public void setServicos(double servicos){
        this.servicos = servicos;
    }

    public double getManutencao(){
        return manutencao;
    }
    public void setManutencao(double manutencao){
        this.manutencao = manutencao;
    }

    public double getMaterial(){
        return material;
    }
    public void setMaterial(double material){
        this.material = material;
    }

    public double getValor_restante(){
        return valor_restante;
    }
    public void setValor_restante(double valor_restante){
        this.valor_restante = valor_restante;
    }
}
