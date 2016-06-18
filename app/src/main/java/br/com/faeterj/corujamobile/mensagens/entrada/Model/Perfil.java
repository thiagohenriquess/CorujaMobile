package br.com.faeterj.corujamobile.mensagens.entrada.Model;
//Criada dia 02/06/2016 by Thiago

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.faeterj.corujamobile.R;

//implentado o Serializable para poder ser passado pelo Intent com o metodo putExtra
public class Perfil implements Serializable {
    
    private int matricula;
    private String nome;
    private int img;
    //transient serve para nao serializar esse atributo
    private transient List<Mensagem> cxSaida;

    
	//Sera modificado
    public Perfil(){
        matricula = 1;
        nome = "Zé Sem Nome";
        img = R.drawable.semfoto;
        cxSaida = new ArrayList<Mensagem>();
    }
    public Perfil(String nome){
        matricula = 1;
        this.nome = nome;
        img = R.drawable.semfoto;
        cxSaida = new ArrayList<Mensagem>();
    }

    public Perfil(String nome,int img){
        this.nome = nome;
        this.img = img;
        cxSaida = new ArrayList<Mensagem>();
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void enivarMensagem(Mensagem msg ){
        cxSaida.add(msg) ;
        msg.setRemetente(this);        
    }

    public List<Mensagem> getCxSaida() {
        return cxSaida;
    }

    public void setCxSaida(List<Mensagem> cxSaida) {
        this.cxSaida = cxSaida;
    }

    //pelo que procurei isso fazia com que a lista passase por desserialização, mas ela volta null
    private void readObject(ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        cxSaida = new ArrayList<Mensagem>();
    }


}
