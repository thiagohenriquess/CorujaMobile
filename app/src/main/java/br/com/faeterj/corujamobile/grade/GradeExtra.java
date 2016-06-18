package br.com.faeterj.corujamobile.grade;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.Data.DataBase;
import br.com.faeterj.corujamobile.grade.Model.Grade;
import br.com.faeterj.corujamobile.grade.Repository.RepositorioGrade;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;
import br.com.faeterj.corujamobile.professores.ActProfessor;


public class GradeExtra extends AppCompatActivity {

    private ListView lstGradeExtra;
    private ArrayAdapter<Grade> adpGradeExtra;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioGrade repositorioGrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_extra);
        lstGradeExtra = (ListView) findViewById(R.id.lstGradeExtra);

        try
        {
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioGrade = new RepositorioGrade(conn);
            repositorioGrade.testeInserirMensagens();
            adpGradeExtra = repositorioGrade.buscaGrade(this);
            lstGradeExtra.setAdapter(adpGradeExtra);

            /*AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso!");
            dlg.setNeutralButton("Ok", null);
            dlg.show();*/
        }
        catch (SQLException ex)
        {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Error!" + ex.getMessage());
            dlg.setNeutralButton("Ok", null);
            dlg.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_navegacao, menu);
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
}
