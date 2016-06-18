package br.com.faeterj.corujamobile.notas_faltas.Model;

/**
 * Created by Danilo on 10/06/2016.
 */
public class AlunoTurma {

    private String alunoNome;
    private String disciplinaNome;
    private int _id;
    private float av1;
    private float av2;
    private float avS;
    private float avF;
    private int faltas;



    private String status;

    public int get_id(){

        return _id;
    }

    public float getAv1() {
        return av1;
    }

    public void setAv1(float av1) {
        this.av1 = av1;
    }

    public float getAv2() {
        return av2;
    }

    public void setAv2(float av2) {
        this.av2 = av2;
    }

    public float getAvS() {
        return avS;
    }

    public void setAvS(float avS) {
        this.avS = avS;
    }

    public float getAvF() {
        return avF;
    }

    public void setAvF(float avF) {
        this.avF = avF;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
