package com.example.alessandro.tcc;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.util.List;

public class ListProfessorActivity extends Activity {
    private List<Professor> professorlista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_professor);
        try {
            professorlista = new ProfessorDBController(this).getAllProf();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ListView professorlista = (ListView) findViewById(R.id.professor_list);
        ArrayAdapter<Professor> adapter = new ArrayAdapter<Professor>(this,
                android.R.layout.simple_list_item_1, (List<Professor>) professorlista);
    }

}