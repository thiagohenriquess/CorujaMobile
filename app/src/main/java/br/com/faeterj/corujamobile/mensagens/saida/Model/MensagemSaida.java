package br.com.faeterj.corujamobile.mensagens.saida.Model;

/**
 * Created by Willian on 02/06/2016.
 */
public class MensagemSaida {

    private String titulo;
    private String mensagem;
    private String remetente;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    @Override
    public String toString()
    {
        return remetente + "  -  " +titulo;
    }
}
