package com.example.alessandro.tcc;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.util.List;

public class ListLivroActivity extends Activity {
    private List<Livro> livrolista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_livro);
        try {
            livrolista = new LivroDBController(this).getAllLivro();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        ListView livrolista = (ListView) findViewById(R.id.livro_list);
        ArrayAdapter<Livro> adapter = new ArrayAdapter<Livro>(this,
                android.R.layout.simple_list_item_1, (List<Livro>) livrolista);
    }

}
