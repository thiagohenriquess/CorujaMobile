package br.com.faeterj.corujamobile.notas_faltas.Model;

/**
 * Created by Danilo on 21/05/2016.
 */
public class Aluno {

    private int _id;
    private String nome;
    private String matricula;


    public Aluno(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;

    }

    public int get_id(){

        return _id;
    }

    public String getNome() {


        return nome;
    }

    public void setNome(String nome) {


        this.nome = nome;
    }

    public String getMatricula() {


        return matricula;
    }

    public void setMatricula(String matricula) {


        this.matricula = matricula;
    }


}
