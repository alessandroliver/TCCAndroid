package com.example.alessandro.tcc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alessandro on 21/05/2017.
 */

public class DisciplinaDBOpenHelper extends SQLiteOpenHelper {

    static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "DBDisciplina";

    static final String TABLE_RSS = "TableDisciplina";

    static final String NOME = "nome";
    static final String CODIGO = "codigo";
    static final String DATA_INICIO = "dataInicio";
    static final String DATA_FIM = "dataFim";
    static final String NOTA1 = "nota1";
    static final String NOTA2 = "nota2";
    static final String NOTA3 = "nota3";
    static final String NOTA4 = "nota4";
    static final String FALTAS = "faltas";
    static final String CARGAHORARIA = "cargaHoraria";
    final private Context mContext;

    public DisciplinaDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

        this.mContext = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_RSS_TABLE = "CREATE TABLE " + TABLE_RSS+"(" + CODIGO
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + DATA_INICIO + " TEXT,"
                + NOME + " TEXT NOT NULL," + DATA_FIM + " TEXT," + NOTA1
                + " REAL," + NOTA2 + " REAL," + NOTA3 + " REAL,"
                + NOTA4 + " REAL," + FALTAS + " INTEGER," + CARGAHORARIA + " REAL" +")";
        db.execSQL(CREATE_RSS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RSS);

        onCreate(db);

    }

    void deleteDatabase() {
        mContext.deleteDatabase(TABLE_RSS);
    }

}