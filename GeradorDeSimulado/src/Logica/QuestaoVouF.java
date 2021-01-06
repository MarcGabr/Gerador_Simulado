package Logica;

public class QuestaoVouF extends Questao {

    boolean resposta;

    public QuestaoVouF(String pergunta, boolean resposta, Assunto assunto) {
        super(pergunta, assunto);
        this.resposta = resposta;
    }

    @Override
    public String imprimeResposta() {
        return resposta ? "Verdadeiro" : "Falso";
    }

    public boolean getResposta() {
        return resposta;
    }

    @Override
    public String imprimeAlternativa() {
        return "Verdadeiro\nFalso";
    }

    @Override
    public boolean equals(Object questao) {
        Questao temp = (Questao) questao;
        if (super.pergunta.equalsIgnoreCase(temp.pergunta)) {
            if (questao instanceof QuestaoVouF) {
                if (temp.imprimeResposta().equalsIgnoreCase(imprimeResposta())) {
                    if (temp.getAssunto().equals(getAssunto())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String getTipo() {
        return "Questao verdadeiro ou falso";
    }

}
