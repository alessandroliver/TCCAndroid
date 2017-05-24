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

import static com.example.alessandro.tcc.AlunoDBOpenHelper.TABLE_ALUNO;

/**
 * Created by Alessandro on 23/05/2017.
 */

public class AlunoDBController {

    private SQLiteDatabase db;
    private AlunoDBOpenHelper alunoDB;

    public AlunoDBController(Context context){
        alunoDB = new AlunoDBOpenHelper(context);
    }

    public List<Aluno> getAllAluno() throws ParseException {
        List<Aluno> alunoList = new ArrayList<Aluno>();
        Cursor cursor = loadItems();

        if (cursor.moveToFirst()) {
            do {
                Endereco end = new Endereco(cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getString(9),
                        cursor.getString(10),cursor.getString(11),cursor.getString(12));
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date date = df.parse(cursor.getString(13));
                Telefone tel = new Telefone(cursor.getString(14),cursor.getInt(15),cursor.getInt(16));
                boolean cot = false;
                if (cursor.getInt(19) == 1){
                    cot = true;
                }
                DateFormat dft = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date dt = dft.parse(cursor.getString(22));
                Disciplina dis = new Disciplina(cursor.getString(25),cursor.getInt(26),date,dt,cursor.getDouble(27),
                        cursor.getDouble(28),cursor.getDouble(29),cursor.getDouble(30),cursor.getInt(31),cursor.getDouble(32));
                Boletim bol = new Boletim(cursor.getDouble(33),cursor.getDouble(34),cursor.getDouble(35),cursor.getDouble(36),
                        cursor.getDouble(37),cursor.getDouble(38),dis);
                Aluno alu = new Aluno(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                        cursor.getString(4),cursor.getString(5),end,date,tel,cursor.getString(17),cursor.getString(18),cot,
                        cursor.getString(20), cursor.getInt(21),dt,cursor.getDouble(22),cursor.getInt(23),cursor.getInt(24),
                        dis,bol);

                alunoList.add(alu);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return alunoList;
    }

    public Cursor loadItems(){
        Cursor cursor;
        db = alunoDB.getReadableDatabase();
        cursor = db.query(alunoDB.TABLE_ALUNO, alunoDB.COLUNA, null, null, null, null, null, null);

        if(cursor!=null && cursor.getCount() > 0){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public String insert(Aluno aluno){
        long check =0;
        SQLiteDatabase db = alunoDB.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(AlunoDBOpenHelper.NOME, aluno.getNome());
        values.put(AlunoDBOpenHelper.CPF, aluno.getCpf());
        values.put(AlunoDBOpenHelper.RG, aluno.getRg());
        values.put(AlunoDBOpenHelper.NACIONALIDADE, aluno.getNacionalidade());
        values.put(AlunoDBOpenHelper.NATURALIDADE, aluno.getNaturalidade());
        values.put(AlunoDBOpenHelper.SEXO, aluno.getSexo());
        values.put(AlunoDBOpenHelper.RUAENDERECO, aluno.getEndereco().getRua_av());
        values.put(AlunoDBOpenHelper.BAIRROENDERECO, aluno.getEndereco().getBairro());
        values.put(AlunoDBOpenHelper.NUMEROENDERECO, aluno.getEndereco().getNum());
        values.put(AlunoDBOpenHelper.CIDADEENDERECO, aluno.getEndereco().getCidade());
        values.put(AlunoDBOpenHelper.CEPENDERECO, aluno.getEndereco().getCep());
        values.put(AlunoDBOpenHelper.ESTADOENDERECO, aluno.getEndereco().getEstado());
        values.put(AlunoDBOpenHelper.COMPLEMENTOENDERECO, aluno.getEndereco().getComplemento());

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportDate = df.format(aluno.getData_nascimento());

        values.put(AlunoDBOpenHelper.DATA_NASCIMENTO, reportDate);
        values.put(AlunoDBOpenHelper.OPERADORATELEFONE, aluno.getTelefone().getOperadora());
        values.put(AlunoDBOpenHelper.NUMEROTELEFONE, aluno.getTelefone().getNumero());
        values.put(AlunoDBOpenHelper.DDDTELEFONE, aluno.getTelefone().getDdd());
        values.put(AlunoDBOpenHelper.EMAIL, aluno.getEmail());
        values.put(AlunoDBOpenHelper.TURMA, aluno.getTurma());
        values.put(AlunoDBOpenHelper.COTA, aluno.getCota());
        values.put(AlunoDBOpenHelper.CURSO, aluno.getCurso());
        values.put(AlunoDBOpenHelper.MATRICULA, aluno.getMatricula());

        DateFormat dft = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportDt = dft.format(aluno.getData_matricula());

        values.put(AlunoDBOpenHelper.DATAMATRICULA, reportDt);
        values.put(AlunoDBOpenHelper.NOTAENTRADA, aluno.getNota_entrada());
        values.put(AlunoDBOpenHelper.HORASCURSADAS, aluno.getHoras_cursadas());
        values.put(AlunoDBOpenHelper.HORASRESTANTES, aluno.getHoras_restantes());
        values.put(AlunoDBOpenHelper.NOMEDISCIPLINA, aluno.getDisciplina().getNome());
        values.put(AlunoDBOpenHelper.CODIGODISCIPLINA, aluno.getDisciplina().getCodigo());

        DateFormat dfr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportD = dfr.format(aluno.getDisciplina().getData_inicio());

        values.put(AlunoDBOpenHelper.DATAINICIODISCIPLINA, reportD);

        DateFormat dfm = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportDe = dfm.format(aluno.getDisciplina().getData_fim());

        values.put(AlunoDBOpenHelper.DATAFIMDISCIPLINA, reportDe);
        values.put(AlunoDBOpenHelper.NOTA1DISCIPLINA, aluno.getDisciplina().getNota1());
        values.put(AlunoDBOpenHelper.NOTA2DISCIPLINA, aluno.getDisciplina().getNota2());
        values.put(AlunoDBOpenHelper.NOTA3DISCIPLINA, aluno.getDisciplina().getNota3());
        values.put(AlunoDBOpenHelper.NOTA4DISCIPLINA, aluno.getDisciplina().getNota4());
        values.put(AlunoDBOpenHelper.FALTASDISCIPLINA, aluno.getDisciplina().getFaltas());
        values.put(AlunoDBOpenHelper.CARGAHORARIADISCIPLINA, aluno.getDisciplina().getCarga_horaria());
        values.put(AlunoDBOpenHelper.MEDIA1BOLETIM, aluno.getBoletim().getMedia1());
        values.put(AlunoDBOpenHelper.MEDIA2BOLETIM, aluno.getBoletim().getMedia2());
        values.put(AlunoDBOpenHelper.MEDIA3BOLETIM, aluno.getBoletim().getMedia3());
        values.put(AlunoDBOpenHelper.MEDIA4BOLETIM, aluno.getBoletim().getMedia4());
        values.put(AlunoDBOpenHelper.MEDIAGERALBOLETIM, aluno.getBoletim().getMedia_geral());
        values.put(AlunoDBOpenHelper.RECUPERACAOBOLETIM, aluno.getBoletim().getRecuperacao());

        check = db.insert(TABLE_ALUNO, null, values);


        db.close();

        if(check == -1){
            return "Error";
        } else{
            return "DB created";
        }
    }

    public void clearAll(){

        alunoDB.getWritableDatabase().delete(TABLE_ALUNO,null,null);
        db.close();

    }

    public int updateSite(Aluno aluno){
        SQLiteDatabase db = alunoDB.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AlunoDBOpenHelper.NOME, aluno.getNome());
        values.put(AlunoDBOpenHelper.CPF, aluno.getCpf());
        values.put(AlunoDBOpenHelper.RG, aluno.getRg());
        values.put(AlunoDBOpenHelper.NACIONALIDADE, aluno.getNacionalidade());
        values.put(AlunoDBOpenHelper.NATURALIDADE, aluno.getNaturalidade());
        values.put(AlunoDBOpenHelper.SEXO, aluno.getSexo());
        values.put(AlunoDBOpenHelper.RUAENDERECO, aluno.getEndereco().getRua_av());
        values.put(AlunoDBOpenHelper.BAIRROENDERECO, aluno.getEndereco().getBairro());
        values.put(AlunoDBOpenHelper.NUMEROENDERECO, aluno.getEndereco().getNum());
        values.put(AlunoDBOpenHelper.CIDADEENDERECO, aluno.getEndereco().getCidade());
        values.put(AlunoDBOpenHelper.CEPENDERECO, aluno.getEndereco().getCep());
        values.put(AlunoDBOpenHelper.ESTADOENDERECO, aluno.getEndereco().getEstado());
        values.put(AlunoDBOpenHelper.COMPLEMENTOENDERECO, aluno.getEndereco().getComplemento());

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportDate = df.format(aluno.getData_nascimento());

        values.put(AlunoDBOpenHelper.DATA_NASCIMENTO, reportDate);
        values.put(AlunoDBOpenHelper.OPERADORATELEFONE, aluno.getTelefone().getOperadora());
        values.put(AlunoDBOpenHelper.NUMEROTELEFONE, aluno.getTelefone().getNumero());
        values.put(AlunoDBOpenHelper.DDDTELEFONE, aluno.getTelefone().getDdd());
        values.put(AlunoDBOpenHelper.EMAIL, aluno.getEmail());
        values.put(AlunoDBOpenHelper.TURMA, aluno.getTurma());
        values.put(AlunoDBOpenHelper.COTA, aluno.getCota());
        values.put(AlunoDBOpenHelper.CURSO, aluno.getCurso());
        values.put(AlunoDBOpenHelper.MATRICULA, aluno.getMatricula());

        DateFormat dft = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportDt = dft.format(aluno.getData_matricula());

        values.put(AlunoDBOpenHelper.DATAMATRICULA, reportDt);
        values.put(AlunoDBOpenHelper.NOTAENTRADA, aluno.getNota_entrada());
        values.put(AlunoDBOpenHelper.HORASCURSADAS, aluno.getHoras_cursadas());
        values.put(AlunoDBOpenHelper.HORASRESTANTES, aluno.getHoras_restantes());
        values.put(AlunoDBOpenHelper.NOMEDISCIPLINA, aluno.getDisciplina().getNome());
        values.put(AlunoDBOpenHelper.CODIGODISCIPLINA, aluno.getDisciplina().getCodigo());

        DateFormat dfr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportD = dfr.format(aluno.getDisciplina().getData_inicio());

        values.put(AlunoDBOpenHelper.DATAINICIODISCIPLINA, reportD);

        DateFormat dfm = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        String reportDe = dfm.format(aluno.getDisciplina().getData_fim());

        values.put(AlunoDBOpenHelper.DATAFIMDISCIPLINA, reportDe);
        values.put(AlunoDBOpenHelper.NOTA1DISCIPLINA, aluno.getDisciplina().getNota1());
        values.put(AlunoDBOpenHelper.NOTA2DISCIPLINA, aluno.getDisciplina().getNota2());
        values.put(AlunoDBOpenHelper.NOTA3DISCIPLINA, aluno.getDisciplina().getNota3());
        values.put(AlunoDBOpenHelper.NOTA4DISCIPLINA, aluno.getDisciplina().getNota4());
        values.put(AlunoDBOpenHelper.FALTASDISCIPLINA, aluno.getDisciplina().getFaltas());
        values.put(AlunoDBOpenHelper.CARGAHORARIADISCIPLINA, aluno.getDisciplina().getCarga_horaria());
        values.put(AlunoDBOpenHelper.MEDIA1BOLETIM, aluno.getBoletim().getMedia1());
        values.put(AlunoDBOpenHelper.MEDIA2BOLETIM, aluno.getBoletim().getMedia2());
        values.put(AlunoDBOpenHelper.MEDIA3BOLETIM, aluno.getBoletim().getMedia3());
        values.put(AlunoDBOpenHelper.MEDIA4BOLETIM, aluno.getBoletim().getMedia4());
        values.put(AlunoDBOpenHelper.MEDIAGERALBOLETIM, aluno.getBoletim().getMedia_geral());
        values.put(AlunoDBOpenHelper.RECUPERACAOBOLETIM, aluno.getBoletim().getRecuperacao());
        int update = db.update(TABLE_ALUNO, values, AlunoDBOpenHelper.MATRICULA + " = ?",
                new String[]{String.valueOf(aluno.getMatricula())});
        db.close();
        return update;

    }

}