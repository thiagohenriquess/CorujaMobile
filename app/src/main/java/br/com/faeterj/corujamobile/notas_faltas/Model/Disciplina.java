package br.com.faeterj.corujamobile.notas_faltas.Model;

import java.util.ArrayList;

/**
 * Created by Danilo on 10/06/2016.
 */
public class Disciplina {


    private int _id;
    private String nome;
    private ArrayList<Turma> listaTurmas; //verificar como modelar representar isso no banco. FK?


    public int get_id(){

        return _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
