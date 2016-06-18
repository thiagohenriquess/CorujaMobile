package br.com.faeterj.corujamobile.professores.model;

import java.io.Serializable;

/**
 * Created by pc 2015 on 04/06/2016.
 */
public class Professor implements Serializable{

    public static String ID = "_id";
    public static String NOME = "NOME";
    public static String EMAIL = "EMAIL";
    public static String MATERIAS = "MATERIAS";
    public static String DIASMANHA = "DIASNOITE";
    public static String DIASNOITE = "DIASNOITE";

    private long id;
    private String nome;
    private String email;
    private String materias;
    private String diasManha;
    private String diasNoite;

    public Professor(){
        setId(0);
    }

    public Professor( long id,String nome,String email, String materias,String diasManha, String diasNoite) {

        this.id = id;
        this.nome = nome;
        this.email = email;
        this.materias = materias;
        this.diasManha = diasManha;
        this.diasNoite = diasNoite;
    }
    public long getId() { return id;
    }

    public void setId(long id) { this.id = id;
    }

    public String getNome() { return nome;
    }

    public void setNome(String nome) { this.nome = nome;
    }

    public String getEmail() { return email;
    }

    public void setEmail(String email) { this.email = email;
    }

    public String getMaterias() { return materias;
    }

    public void setMaterias(String materias) { this.materias = materias;
    }

    public String getDiasManha() { return diasManha;
    }

    public void setDiasManha(String diasManha) { this.diasManha = diasManha;
    }

    public String getDiasNoite() { return diasNoite;
    }

    public void setDiasNoite(String diasNoite) {  this.diasNoite = diasNoite;
    }

    @Override
    public String toString(){
        return nome;
    }
}


