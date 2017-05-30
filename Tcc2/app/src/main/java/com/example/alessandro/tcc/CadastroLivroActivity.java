package com.example.alessandro.tcc;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastroLivroActivity extends Activity {
    private EditText titulo, autor, editora, edicao, area, data_publicacao, indioma, id;
    private Button cadastrar;
    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_livro);

        cadastrar = (Button) findViewById(R.id.bt_cadastrar_livro);
        titulo = (EditText) findViewById(R.id.et_titulo_livro);
        autor = (EditText) findViewById(R.id.et_autor_livro);
        editora = (EditText) findViewById(R.id.et_editora_livro);
        edicao = (EditText) findViewById(R.id.et_edicao_livro);
        area = (EditText) findViewById(R.id.et_area_livro);
        data_publicacao = (EditText) findViewById(R.id.et_dp_livro);
        indioma = (EditText) findViewById(R.id.et_indioma_livro);
        id = (EditText) findViewById(R.id.et_id_livro);

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = df.parse(data_publicacao.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Livro livro = new Livro(indioma.getText().toString(),titulo.getText().toString(),area.getText().toString(),
                autor.getText().toString(),editora.getText().toString(),Integer.parseInt(edicao.getText().toString()),
                date ,Integer.parseInt(id.getText().toString()));

        LivroDBController livroDBController = new LivroDBController(this);

        livroDBController.insert(livro);

    }

}
