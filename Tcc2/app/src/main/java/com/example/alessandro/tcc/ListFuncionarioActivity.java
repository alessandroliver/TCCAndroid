package com.example.alessandro.tcc;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.util.List;

public class ListFuncionarioActivity extends Activity {
    private List<Funcionario> funcionariolista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_funcionario);
        try {
            funcionariolista = new FuncionarioDBController(this).getAllFunc();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ListView funcionariolista = (ListView) findViewById(R.id.funcionario_list);
        ArrayAdapter<Funcionario> adapter = new ArrayAdapter<Funcionario>(this,
                android.R.layout.simple_list_item_1, (List<Funcionario>) funcionariolista);
    }

}
