package com.example.alessandro.tcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.alessandro.tcc.LivroDBOpenHelper.TABLE_LIVRO;


/**
 * Created by Alessandro on 23/05/2017.
 */

public class LivroDBController {

    private SQLiteDatabase db;
    private LivroDBOpenHelper livroDB;

    public LivroDBController(Context context){
        livroDB = new LivroDBOpenHelper(context);
    }

    public List<Livro> getAllLivro() throws ParseException {
        List<Livro> livroList = new ArrayList<Livro>();
        Cursor cursor = loadItens();
        if (cursor.moveToFirst()){
            do{

                DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
                Date date = df.parse(cursor.getString(6));
                boolean emp = false;
                if (cursor.getInt(8) == 1){
                    emp = true;
                }
                Livro liv = new Livro(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                        cursor.getString(4),cursor.getInt(5),date,cursor.getInt(7), emp);

                livroList.add(liv);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return livroList;
    }

    public Cursor loadItens(){
        Cursor cursor;
        db = livroDB.getReadableDatabase();
        cursor = db.query(livroDB.TABLE_LIVRO, livroDB.COLUNA, null, null, null, null, null, null);

        if(cursor!=null && cursor.getCount() > 0){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String insert(Livro livro){
        long check =0;
        SQLiteDatabase db = livroDB.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(LivroDBOpenHelper.IDIOMA, livro.getIdioma());
        values.put(LivroDBOpenHelper.TITULO, livro.getTitulo());
        values.put(LivroDBOpenHelper.AREA, livro.getArea());
        values.put(LivroDBOpenHelper.AUTOR, livro.getAutor());
        values.put(LivroDBOpenHelper.EDITORA, livro.getEditora());
        values.put(LivroDBOpenHelper.EDICAO, livro.getEdicao());

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String reportDate = df.format(livro.getData_publicacao());

        values.put(LivroDBOpenHelper.DATA_PUBLICACAO, reportDate);
        values.put(LivroDBOpenHelper._ID, livro.getId());
        values.put(LivroDBOpenHelper.EMPRESTADO, livro.getEmprestado());


        check = db.insert(TABLE_LIVRO, null, values);


        db.close();

        if(check == -1){
            return "Error";
        } else{
            return "DB created";
        }
    }

    public void clearAll(){

        livroDB.getWritableDatabase().delete(TABLE_LIVRO,null,null);
        db.close();

    }

    public int updateSite(Livro livro){
        SQLiteDatabase db = livroDB.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LivroDBOpenHelper.IDIOMA, livro.getIdioma());
        values.put(LivroDBOpenHelper.TITULO, livro.getTitulo());
        values.put(LivroDBOpenHelper.AREA, livro.getArea());
        values.put(LivroDBOpenHelper.AUTOR, livro.getAutor());
        values.put(LivroDBOpenHelper.EDITORA, livro.getEditora());
        values.put(LivroDBOpenHelper.EDICAO, livro.getEdicao());

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String reportDate = df.format(livro.getData_publicacao());

        values.put(LivroDBOpenHelper.DATA_PUBLICACAO, reportDate);
        values.put(LivroDBOpenHelper._ID, livro.getId());
        values.put(LivroDBOpenHelper.EMPRESTADO, livro.getEmprestado());

        int update = db.update(TABLE_LIVRO, values, LivroDBOpenHelper._ID + " = ?", new String[]{String.valueOf(livro.getId())});
        db.close();
        return update;

    }

}