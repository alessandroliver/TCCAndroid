package com.example.alessandro.tcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 21/05/2017.
 */

public class LivroDBOpenHelper extends SQLiteOpenHelper {

    static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "DBLivro";

    static final String TABLE_LIVRO = "TableLivro";

    static final String INDIOMA = "indioma";
    static final String TITULO = "titulo";
    static final String AREA = "area";
    static final String AUTOR = "autor";
    static final String EDITORA = "editora";
    static final String EDICAO = "edicao";
    static final String DATA_PUBLICACAO = "dataPub";
    static final String _ID = "_id";
    static final String[]COLUNA = {INDIOMA, TITULO, AREA, AUTOR, EDITORA, EDICAO, DATA_PUBLICACAO, _ID};
    final private Context mContext;

    public LivroDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_LIVRO+"(" + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + INDIOMA + " TEXT,"
                + TITULO + " TEXT NOT NULL," + AREA + " TEXT," + AUTOR
                + " TEXT," + EDITORA + " TEXT," + EDICAO + "INTEGER,"
                + DATA_PUBLICACAO + "TEXT" +")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIVRO);

        onCreate(db);

    }

    void deleteDatabase() {
        mContext.deleteDatabase(TABLE_LIVRO);
    }

}
