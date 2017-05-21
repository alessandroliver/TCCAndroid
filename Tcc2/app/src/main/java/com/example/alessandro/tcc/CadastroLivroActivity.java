package com.example.alessandro.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class CadastroLivroActivity extends Activity {
    private EditText titulo, autor, editora, edicao, area, data_publicacao, indioma, id;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_livro);
        autor = (EditText) findViewById(R.id.et_autor_livro);
        editora = (EditText) findViewById(R.id.et_editora_livro);
        edicao = (EditText) findViewById(R.id.et_edicao_livro);
        area = (EditText) findViewById(R.id.et_area_livro);
        data_publicacao = (EditText) findViewById(R.id.et_dp_livro);
        indioma = (EditText) findViewById(R.id.et_indioma_livro);
        id = (EditText) findViewById(R.id.et_id_livro);

    }

}
