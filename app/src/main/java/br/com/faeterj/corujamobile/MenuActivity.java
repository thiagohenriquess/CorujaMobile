package br.com.faeterj.corujamobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import br.com.faeterj.corujamobile.grade.GradeExtra;
import br.com.faeterj.corujamobile.historico.ActHistorico;
import br.com.faeterj.corujamobile.links.ActLink;
import br.com.faeterj.corujamobile.mensagens.mensagens;
import br.com.faeterj.corujamobile.professores.ActProfessor;
import br.com.faeterj.corujamobile.notas_faltas.ActNotaFalta;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void irParaLinks(View view)
    {
        Intent intencao = new Intent(this, ActLink.class);
        startActivity(intencao);
    }

    public void irParaHistorico(View view)
    {
        Intent intencao = new Intent(this, ActHistorico.class);
        startActivity(intencao);
    }

    public void irParaTurmas(View view)
    {
        Intent intencao = new Intent(this, ActNotaFalta.class);
        startActivity(intencao);
    }

    public void irParaGrade(View view)
    {
        Intent intencao = new Intent(this, GradeExtra.class);
        startActivity(intencao);
    }

    public void irParaProfessores(View view)
    {
        Intent intencao = new Intent(this, ActProfessor.class);
        startActivity(intencao);
    }

    public void irParaMensagens(View view)
    {
        Intent intencao = new Intent(this, mensagens.class);
        startActivity(intencao);
    }

}
