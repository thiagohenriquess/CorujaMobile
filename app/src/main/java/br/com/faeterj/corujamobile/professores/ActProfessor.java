package br.com.faeterj.corujamobile.professores;

import android.app.Activity;
import android.content.*;

import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.database.sqlite.*;
import android.database.*;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;
import br.com.faeterj.corujamobile.professores.controller.ProfessorController;
import br.com.faeterj.corujamobile.professores.model.Professor;
import br.com.faeterj.corujamobile.professores.repository.ProfessorRepository;

public class ActProfessor extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private ListView lstProfessor;
    private ArrayAdapter<Professor> adpProfessor;

    private ProfessorRepository professorRepository;
    private SQLiteDatabase conn;
    private ProfessorController professorController;

    private int testa = 0;

    public static final String PAR_PROFESSOR = "PROFESSOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_professor);
        lstProfessor = (ListView) findViewById(R.id.lstProfessor);
        lstProfessor.setOnItemClickListener(this);
        try {

            professorRepository = new ProfessorRepository(this);
            conn = professorRepository.getReadableDatabase();

            professorController = new ProfessorController(conn);

            PopulaBanco(conn);

            adpProfessor = professorController.buscaProfessor(this);

            lstProfessor.setAdapter(adpProfessor);


        } catch (SQLException ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Criar o banco: " + ex);
            dlg.setNeutralButton("ok", null);
            dlg.show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adpProfessor = professorController.buscaProfessor(this);
        lstProfessor.setAdapter(adpProfessor);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Professor professor = adpProfessor.getItem(position);

        Intent it = new Intent(this, ActCadProfessor.class);

        it.putExtra(PAR_PROFESSOR, professor);

        startActivityForResult(it, 0);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, ActCadProfessor.class);
        startActivityForResult(it, 0);
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


    public void PopulaBanco(SQLiteDatabase conn) {

        ProfessorController prof = new ProfessorController(this.conn);

        Professor professor = new Professor(0, "Ana Cristina", "anaA@faeterj.com", "TRI - ME1", "ter - quar", "seg - qui");
        prof.inserir(professor);
        professor = new Professor(1, "Ana Claudia", "anaC@faeterj.com", "RD1 - RD2", "seg - quar", "seg - ter");
        prof.inserir(professor);
        professor = new Professor(2, "André Neves", "andre@faeterj.com", "PSW - APS", " ", "seg - sex");
        prof.inserir(professor);
        professor = new Professor(3, "Claudio Bispo", "claudio@faeterj.com", "MAT1 - MAT2", "ter - sex", "seg - sex");
        prof.inserir(professor);
        professor = new Professor(4, "Paulo Massilon", "paulo@faeterj.com", "AC1 - AC2", "qua - qui ", "seg - qui");
        prof.inserir(professor);
        professor = new Professor(5, "Leonardo Vianna", "leonardo@faeterj.com", "AL2 - ESD", "seg - sex", "seg - qui");
        prof.inserir(professor);
        professor = new Professor(6, "Marcio Belo", "marcio@faeterj.com", "OO1 - TAV", "seg - ter - sex", "seg - qui - sex");
        prof.inserir(professor);
        professor = new Professor(7, "Miguel Pinto", "miguel@faeterj.com", "OO1 - OO2", "seg", "seg");
        prof.inserir(professor);
        professor = new Professor(8, "Ricardo Portela", "ricardo@faeterj.com", "INS - ENG", "seg - sab", "seg - qui");
        prof.inserir(professor);
    }

}