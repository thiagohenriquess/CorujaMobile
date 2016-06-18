package br.com.faeterj.corujamobile.mensagens.entrada.Model;

/**
 * Created by thiago on 01/06/16.
 */
public class Mensagem {
    private String titulo;
    private String conteudo;
    //private Date data;
	private Perfil remetente;

    public Mensagem(){
        this.titulo = "Titulo Vago";
        this.conteudo = "Sem conteudo";
    }

    public Mensagem(String titulo, String conteudo){
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

	//Constutor ainda tem que ser testado
	public Mensagem(String titulo, String conteudo, Perfil rementente){
		this.titulo = titulo;
        this.conteudo = conteudo;
        this.remetente = remetente;
        rementente.enivarMensagem(this);

	}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Perfil getRemetente() {
        return remetente;
    }

    public void setRemetente(Perfil remetente) {
        this.remetente = remetente;
    }
}

