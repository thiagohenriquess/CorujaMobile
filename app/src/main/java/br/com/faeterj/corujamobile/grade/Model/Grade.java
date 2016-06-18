package br.com.faeterj.corujamobile.grade.Model;

import java.util.Date;

/**
 * Created by Willian on 02/06/2016.
 */
public class Grade {

    private String sigla;
    private String nome;
    private String horaInicial;
    private String horaFinal;
    private String diaSemana;

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(String horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    @Override
    public String toString()
    {
        return diaSemana + "   " + horaInicial + "  até  " + horaFinal + "  -  " + sigla;
    }
}
