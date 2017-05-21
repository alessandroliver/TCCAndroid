package com.example.alessandro.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class CadastroDisciplinaActivity extends Activity {
    private EditText nome, cargaHoraria, codigo;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_disciplina);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_disciplina);
        nome = (EditText) findViewById(R.id.et_nome_disciplina);
        codigo = (EditText) findViewById(R.id.et_codigo_disciplina);
        cargaHoraria = (EditText) findViewById(R.id.et_ch_disciplina);




    }

}
