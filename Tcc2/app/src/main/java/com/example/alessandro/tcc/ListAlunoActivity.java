package com.example.alessandro.tcc;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.util.List;

public class ListAlunoActivity extends Activity {
private List<Aluno> alunoLista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_aluno);
        try {
            alunoLista = new AlunoDBController(this).getAllAluno();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ListView alunolista = (ListView) findViewById(R.id.aluno_list);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_list_item_1, alunoLista);
        alunolista.setAdapter(adapter);
    }


}
