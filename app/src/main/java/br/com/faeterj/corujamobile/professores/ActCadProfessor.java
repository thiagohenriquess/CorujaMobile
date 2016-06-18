package br.com.faeterj.corujamobile.professores;

import android.app.Activity;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.*;

import br.com.faeterj.corujamobile.R;
import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;
import br.com.faeterj.corujamobile.professores.controller.ProfessorController;
import br.com.faeterj.corujamobile.professores.model.Professor;
import br.com.faeterj.corujamobile.professores.repository.ProfessorRepository;

public class ActCadProfessor extends Activity{

    private TextView txtNome;
    private TextView txtEmail;
    private TextView txtMaterias;
    private TextView txtDiasManha;
    private TextView txtDiasNoite;

    private ProfessorRepository professorRepository;
    private SQLiteDatabase conn;
    private ProfessorController professorController;
    private Professor professor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_professor);

        txtNome      = (TextView)findViewById(R.id.txtNome);
        txtEmail     = (TextView)findViewById(R.id.txtEmail);
        txtMaterias  = (TextView)findViewById(R.id.txtMaterias);
        txtDiasManha = (TextView)findViewById(R.id.txtDiasManha);
        txtDiasNoite = (TextView)findViewById(R.id.txtDiasNoite);

            professor = new Professor();

        Bundle bundle = getIntent().getExtras();

        if ((bundle != null) && (bundle.containsKey(ActProfessor.PAR_PROFESSOR)))
        {
            professor = (Professor)bundle.getSerializable(ActProfessor.PAR_PROFESSOR);
            preencheDados();
        }

        try {

            professorRepository = new ProfessorRepository(this);
            conn = professorRepository.getReadableDatabase();

            professorController = new ProfessorController(conn);

        } catch (SQLException ex) {

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao Criar o banco: " + ex);
            dlg.setNeutralButton("ok", null);
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

    private void preencheDados()
    {
        txtNome.setText( professor.getNome() );
        txtEmail.setText( professor.getEmail() );
        txtMaterias.setText( professor.getMaterias() );
        txtDiasManha.setText( professor.getDiasManha() );
        txtDiasNoite.setText( professor.getDiasNoite() );
    }

}
