package Logica;

public class QuestaoMultiplaEscolhaSem extends Questao{
    String []alternativa;
    boolean[] resposta;
    public QuestaoMultiplaEscolhaSem(String pergunta,boolean[] resposta,String []alternativa,Assunto assunto) {
        super(pergunta,assunto);
        this.resposta=resposta;
        this.alternativa=alternativa;
    }

    @Override
    public String imprimeResposta() {
        int i=0;
        while(!resposta[i]){i++;}
        return (char)(i+97)+") "+alternativa[i]+"\n";
    }

    @Override
    public String imprimeAlternativa(){
        String temp="";
        for(int i=0;i<alternativa.length;i++){
           temp=temp+(char)(i+97)+") "+alternativa[i]+"\n"; 
        }
        return temp;
    }
    public int getItemCerto(){
        for(int i=0;i<resposta.length;i++){
            if(resposta[i]){
                return i;
            }
        }
        return -1;
    }
    public String[] getAlternativa(){
        return alternativa;
    }
    public boolean[] getResposta(){
        return resposta;
    }

    @Override
    public boolean equals(Object questao) {
        Questao temp=(Questao)questao;
        if(pergunta.equalsIgnoreCase(temp.pergunta)){
            if(questao instanceof QuestaoMultiplaEscolhaSem){
                if(temp.imprimeResposta().equalsIgnoreCase(imprimeResposta())){
                     if(temp.imprimeAlternativa().equalsIgnoreCase(imprimeAlternativa())){
                        if(temp.getAssunto().equals(getAssunto()))
                            return true;
                    }
                }
            }
        }
        return false;
    }
        @Override
    public String getTipo() {
        return "Questao multipla escolha com uma unica resposta"; 
    }
}
