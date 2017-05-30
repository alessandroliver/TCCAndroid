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
 * Created by Alessandro on 27/05/2017.
 */

public class ProfessorDBOpenHelper extends SQLiteOpenHelper {

    static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "DBProfessor";

    static final String TABLE_PROFESSOR = "TableProfessor";

    static final String NOME = "nome";
    static final String CPF = "cpf";
    static final String RG = "rg";
    static final String NACIONALIDADE = "nacionalidade";
    static final String NATURALIDADE = "naturalidade";
    static final String SEXO = "sexo";
    static final String RUAENDERECO = "ruaEnd";
    static final String BAIRROENDERECO = "bairroEnd";
    static final String NUMEROENDERECO = "numeroEnd";
    static final String CIDADEENDERECO = "cidadeEnd";
    static final String CEPENDERECO = "cepEnd";
    static final String ESTADOENDERECO = "estadoEnd";
    static final String COMPLEMENTOENDERECO = "complementoEnd";
    static final String DATA_NASCIMENTO = "dataNas";
    static final String OPERADORATELEFONE = "operadoraTel";
    static final String NUMEROTELEFONE = "numTel";
    static final String DDDTELEFONE = "dddTel";
    static final String EMAIL = "email";
    static final String SENHA = "senha";
    static final String SALARIO = "salario";
    static final String _ID = "_id";
    static final String CARGA_HORARIA = "cargaHr";
    static final String CARGO = "cargo";
    static final String DISCIPLINA = "disciplina";
    static final String[]COLUNA = {NOME, CPF, RG, NACIONALIDADE, NATURALIDADE, SEXO, RUAENDERECO,
            BAIRROENDERECO, NUMEROENDERECO, CIDADEENDERECO, CEPENDERECO, ESTADOENDERECO, COMPLEMENTOENDERECO,
            DATA_NASCIMENTO, OPERADORATELEFONE, NUMEROTELEFONE, DDDTELEFONE, EMAIL, SENHA, SALARIO, _ID,
            CARGA_HORARIA, CARGO, DISCIPLINA};
    final private Context mContext;

    public ProfessorDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + TABLE_PROFESSOR+"(" + _ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + CPF + " TEXT,"
                + NOME + " TEXT NOT NULL," + RG + " TEXT," + NACIONALIDADE
                + " TEXT," + NATURALIDADE + " TEXT," + SEXO + " TEXT,"
                + RUAENDERECO + " TEXT," + BAIRROENDERECO + " TEXT," + NUMEROENDERECO
                + " INTEGER," + CIDADEENDERECO + " TEXT," + CEPENDERECO + " TEXT,"
                + ESTADOENDERECO + " TEXT," + COMPLEMENTOENDERECO + " TEXT,"
                + DATA_NASCIMENTO + " TEXT," + OPERADORATELEFONE + " TEXT,"
                + NUMEROTELEFONE + " INTEGER," + DDDTELEFONE + " INTEGER,"
                + EMAIL + " TEXT," + SENHA + " TEXT," + SALARIO + " REAL," + CARGA_HORARIA
                + " REAL," + CARGO + " TEXT," + DISCIPLINA + " TEXT" +")";
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFESSOR);

        onCreate(db);

    }

    void deleteDatabase() {
        mContext.deleteDatabase(TABLE_PROFESSOR);
    }

}
