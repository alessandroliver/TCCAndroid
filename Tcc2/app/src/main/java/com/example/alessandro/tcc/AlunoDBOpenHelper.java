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

public class AlunoDBOpenHelper extends SQLiteOpenHelper {

    static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "DBAluno";

    static final String TABLE_RSS = "TableAluno";

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
    static final String TURMA = "turma";
    static final String COTA = "cota";
    static final String CURSO = "curso";
    static final String MATRICULA = "matricula";
    static final String DATAMATRICULA = "dataMat";
    static final String NOTAENTRADA = "notaEnt";
    static final String HORASCURSADAS = "horasCur";
    static final String HORASRESTANTES = "horasRes";
    static final String NOMEDISCIPLINA = "nomeDis";
    static final String CODIGODISCIPLINA = "codigoDis";
    static final String DATAINICIODISCIPLINA = "dataInicioDis";
    static final String DATAFIMDISCIPLINA = "dataFimDis";
    static final String NOTA1DISCIPLINA = "nota1Dis";
    static final String NOTA2DISCIPLINA = "nota2Dis";
    static final String NOTA3DISCIPLINA = "nota3Dis";
    static final String NOTA4DISCIPLINA = "nota4Dis";
    static final String FALTASDISCIPLINA = "faltasDis";
    static final String CARGAHORARIADISCIPLINA = "cargaHorDis";
    static final String MEDIA1BOLETIM = "media1Bol";
    static final String MEDIA2BOLETIM = "media2Bol";
    static final String MEDIA3BOLETIM = "media3Bol";
    static final String MEDIA4BOLETIM = "media4Bol";
    static final String MEDIAGERALBOLETIM = "mediaGerBol";
    static final String RECUPERACAOBOLETIM = "recuperacaoBol";
    final private Context mContext;

    public AlunoDBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_RSS_TABLE = "CREATE TABLE " + TABLE_RSS+"(" + MATRICULA
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + CPF + " TEXT,"
                + NOME + " TEXT NOT NULL," + RG + " TEXT," + NACIONALIDADE
                + " TEXT," + NATURALIDADE + " TEXT," + SEXO + " TEXT,"
                + RUAENDERECO + " TEXT," + BAIRROENDERECO + " TEXT," + NUMEROENDERECO
                + " INTEGER," + CIDADEENDERECO + " TEXT," + CEPENDERECO + " TEXT,"
                + ESTADOENDERECO + " TEXT," + COMPLEMENTOENDERECO + " TEXT,"
                + DATA_NASCIMENTO + " TEXT," + OPERADORATELEFONE + " TEXT,"
                + NUMEROTELEFONE + " INTEGER," + DDDTELEFONE + " INTEGER,"
                + EMAIL + " TEXT," + TURMA + " TEXT," + COTA + " INTEGER,"
                + CURSO + " TEXT," + DATAMATRICULA + " TEXT," + NOTAENTRADA + " REAL,"
                + HORASCURSADAS + " INTEGER," + HORASRESTANTES + " INTEGER," + CODIGODISCIPLINA
                + " INTEGER," + DATAINICIODISCIPLINA + " TEXT," + NOMEDISCIPLINA + " TEXT,"
                + DATAFIMDISCIPLINA + " TEXT," + NOTA1DISCIPLINA + " REAL," + NOTA2DISCIPLINA
                + " REAL," + NOTA3DISCIPLINA + " REAL," + NOTA4DISCIPLINA + " REAL,"
                + FALTASDISCIPLINA + " INTEGER," + CARGAHORARIADISCIPLINA + " REAL,"
                + MEDIA1BOLETIM + " REAL," + MEDIA2BOLETIM + " REAL," + MEDIA3BOLETIM + " REAL,"
                + MEDIA4BOLETIM + " REAL," + MEDIAGERALBOLETIM + " REAL,"+ RECUPERACAOBOLETIM
                + " REAL" +")";
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
