package br.com.faeterj.corujamobile.notas_faltas;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.*;


import android.database.sqlite.*;
import android.database.*;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.notas_faltas.Repository.AlunoTurmaRepository;
import br.com.faeterj.corujamobile.notas_faltas.Data.DataBase;
import br.com.faeterj.corujamobile.professores.ActProfessor;


public class ActNotaFalta extends AppCompatActivity    {

    private ListView lstDados;
    private TextView txtNome;

    private ArrayAdapter<String> adpDados;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private AlunoTurmaRepository alunoTurmaRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_falta);

        lstDados = (ListView) findViewById(R.id.lstDados);
        txtNome = (TextView) findViewById(R.id.txtNome);



        //11/06/2016- verificar como utilizar o arrayAdapter pegando dados do banco e exibindo no listView





        try{
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();


            alunoTurmaRepository = new AlunoTurmaRepository(conn);

            alunoTurmaRepository.testeInserirAlunoTurma();
            adpDados = alunoTurmaRepository.buscaDadosAlunoTurma(this);
            lstDados.setAdapter(adpDados);

            /*
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso!");
            dlg.setNeutralButton ("OK", null);
            dlg.show();
            */

        }catch(SQLException e){

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco: " + e.getMessage());
            dlg.setNeutralButton ("OK", null);
            dlg.show();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater é a classe responsável por realizar associação do arquivo de menu com a classe
        //da activity que terá o menu
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_navegacao,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it;
        switch (item.getItemId())
        {
            case R.id.mni_acao1:
                it = new Intent(this, ActNotaFalta.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao2:
                it = new Intent(this, GradeExtra.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao3:
                it = new Intent(this, mensagens.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao4:
                it = new Intent(this, ActHistorico.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao5:
                it = new Intent(this, ActProfessor.class);
                startActivity(it);
                finish();
                break;

            case R.id.mni_acao6:
                it = new Intent(this, ActLink.class);
                startActivity(it);
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    //método resonsável pela seleção de itens do menu
    //Necessário saber o nome da Activity principal para passá-la como parâmetro no construtor
    //da classe "Intent" e fazer a navegação para a tela principal.
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent home = new Intent(this, Home.class);
        startActivity(home);

        finish();

        return super.onOptionsItemSelected(item);
    }
    */


}
