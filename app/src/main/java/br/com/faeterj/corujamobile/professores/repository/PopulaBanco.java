package br.com.faeterj.corujamobile.professores.repository;


import android.database.sqlite.SQLiteDatabase;
import br.com.faeterj.corujamobile.professores.repository.ProfessorRepository;
import br.com.faeterj.corujamobile.professores.controller.ProfessorController;
import br.com.faeterj.corujamobile.professores.model.Professor;

/**
 * Created by pc 2015 on 05/06/2016.
 */
public class PopulaBanco {



    public void PopulaBanco(SQLiteDatabase conn) {

        ProfessorController prof = new ProfessorController(conn);

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
