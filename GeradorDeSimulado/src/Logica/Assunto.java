package Logica;

import java.util.Date;

public class Assunto {

    private String nome;
    private boolean ativo=true;
    int quantidade = 0;
    Date data = new Date() {
        @Override
        public String toString() {
            return  super.toLocaleString().substring(0, 16);
        }
    };

    public Assunto(String assunto) {
        this.nome = assunto;
    }

    public boolean getAtivo() {
        return ativo;
    }

    void setAtivo(boolean b) {
        ativo = b;
    }

    //public void cadastraQuestao
//    public boolean equals(String assunto){
//        return nome.equals(assunto);
//    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Assunto){
        return ((Assunto)o).nome.equals(nome);
        }
        return false;
    }

    public void setAssunto(String assunto) {
        this.nome = assunto;
    }

    public boolean addQuestao() {
        if (this.ativo){
            quantidade++;
            return true;
        }
        return false;
    }

    public boolean removeQuestao() {
        if (ativo){
            quantidade--;
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome; //To change body of generated methods, choose Tools | Templates.
    }

    public int getQuantidade() {
        return quantidade; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getData() {
        return data.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
