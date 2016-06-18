package br.com.faeterj.corujamobile.login.modelo;

/**
 * Created by AndreLuiz on 12/06/2016.
 */
public class Aluno {
    private int id;
    private long matricula;
    private String senha;
    private int logado = 0;
//logado = 0 ==== NÃO ESTA LOGADO
//logado = 1 ==== ESTA LOGADO


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLogado() {
        return logado;
    }

    public void setLogado(int logado) {
        this.logado = logado;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
