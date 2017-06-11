package com.example.alessandro.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroDisciplinaActivity extends Activity {
    private EditText nome, cargaHoraria, codigo;
    private Button cadastrar;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_disciplina);
        nome = (EditText) findViewById(R.id.et_nome_disciplina);
        codigo = (EditText) findViewById(R.id.et_codigo_disciplina);
        cargaHoraria = (EditText) findViewById(R.id.et_ch_disciplina);



        //esperando o clique do usuário
        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disciplina disciplina = new Disciplina(nome.getText().toString(),Integer.parseInt(codigo.getText().toString()),null,null,
                        0,0,0,0,0,Double.parseDouble(cargaHoraria.getText().toString()));

                DisciplinaDBController disciplinaDBController = new DisciplinaDBController(CadastroDisciplinaActivity.this);

                disciplinaDBController.insert(disciplina);

                Intent intent = new Intent (CadastroDisciplinaActivity.this, ListDisciplinaActivity.class);
                startActivity(intent);

            }
        });

    }

}
