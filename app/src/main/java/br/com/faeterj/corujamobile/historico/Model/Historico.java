package br.com.faeterj.corujamobile.historico.Model;

/**
 * Created by Felipe on 07/06/2016.
 */
public class Historico {
    private String periodo;
    private String disc;
    private String media;
    private String falta;
    private String situacao;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getFalta() {
        return falta;
    }

    public void setFalta(String falta) {
        this.falta = falta;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString(){
        return this.getPeriodo() + "            "
                + this.getDisc() + "            "
                + this.getMedia() + "           "
                + this.getFalta() + "           "
                + this.getSituacao();
    }
}
