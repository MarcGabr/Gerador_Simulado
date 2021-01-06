package Logica;

public abstract class Questao {
    String pergunta;
    Assunto assunto;
    public Questao(String pergunta,Assunto assunto) {
        this.pergunta = pergunta;
        this.assunto=assunto;
    }
    public void setPergunta(String pergunta){
        this.pergunta=pergunta;
    }
    public Assunto getAssunto(){
        return assunto;
    }
    public boolean isEqualsPergunta(Questao o){
        return this.pergunta.equals(o.pergunta);
    }
    public String imprimeQuestao(){
        return pergunta+"\n"+imprimeAlternativa();
    }
    @Override
    public abstract boolean equals(Object questao);
    public abstract String imprimeResposta(); 
    public abstract String imprimeAlternativa(); 
    public abstract String getTipo();
    public String getPergunta() {
        return pergunta; //To change body of generated methods, choose Tools | Templates.
    }
}
