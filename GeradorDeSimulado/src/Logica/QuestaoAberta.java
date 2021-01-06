package Logica;


public class QuestaoAberta extends Questao {
    
    private String resposta;
    public QuestaoAberta(String pergunta, String resposta, Assunto assunto) {
        super(pergunta,assunto);
        this.resposta=resposta;
    }
    @Override
    public String imprimeResposta() {
        return resposta;
    }

    @Override
    public String imprimeAlternativa() {
        return "" ;
    }

    @Override
    public boolean equals(Object questao) {
        Questao temp=(Questao)questao;
        if(pergunta.equalsIgnoreCase(temp.pergunta)){
            if(questao instanceof QuestaoAberta){
               if(temp.getAssunto().equals(getAssunto())){
                        return ((QuestaoAberta)temp).resposta.equalsIgnoreCase(resposta);
                }
            }
        }
        return false;
    }
        @Override
    public String getTipo() {
        return "Questao aberta"; 
    }
}
