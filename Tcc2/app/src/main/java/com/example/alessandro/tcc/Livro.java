package com.example.alessandro.tcc;

import java.util.Date;

/**
 * Created by Alessandro on 08/05/2017.
 */

public class Livro {
    private String idioma;
    private String titulo;
    private String area;
    private String autor;
    private String editora;
    private int edicao;
    private Date data_publicacao;
    private int id;
    private boolean emprestado;

    public Livro(String idioma, String titulo, String area, String autor, String editora, int edicao, Date data_publicacao,
                 int id, boolean emprestado){
        this.idioma = idioma;
        this.titulo = titulo;
        this.area = area;
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.data_publicacao = data_publicacao;
        this.id = id;
        this.emprestado = emprestado;
    }

    public String getIdioma(){
        return idioma;
    }
    public void setIdioma(String indioma){
        this.idioma = idioma;
    }

    public String getTitulo(){
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getArea(){
        return area;
    }
    public void setArea(String area){
        this.area = area;
    }

    public String getAutor(){
        return autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public String getEditora(){
        return editora;
    }
    public void setEditora(String editora){
        this.editora = editora;
    }

    public int getEdicao(){
        return edicao;
    }
    public void setEdicao(int edicao){
        this.edicao = edicao;
    }

    public Date getData_publicacao(){
        return data_publicacao;
    }
    public void setData_publicacao(Date data_publicacao){
        this.data_publicacao = data_publicacao;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public boolean getEmprestado(){
        return emprestado;
    }
    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
}
