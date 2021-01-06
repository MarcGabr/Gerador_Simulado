package Logica;

public class QuestaoMultiplaEscolhaCom extends Questao{
    String []alternativa;
    boolean []resposta;
    public QuestaoMultiplaEscolhaCom(String pergunta,boolean []resposta,String []alternativa,Assunto assunto) {
        super(pergunta,assunto);
        this.alternativa=alternativa;
        this.resposta=resposta;
    }

    @Override
    public String imprimeResposta() {
        String temp="";
        for(int i=0;i<resposta.length;i++){
            if(resposta[i]){
           temp=temp+(char)(97+i)+") "+alternativa[i]+"\n"; 
            }
        }
        return temp;
    }

    @Override
    public String imprimeAlternativa() {
        String temp="";
        for(int i=0;i<alternativa.length;i++){
           temp=temp+(char)(i+97)+") "+alternativa[i]+"\n"; 
        }
        return temp;    
    }
    public int getItemCerto(String resposta){
        for(int i=0;i<alternativa.length;i++){
            if(alternativa[i].equals(resposta)){
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
        if(super.pergunta.equalsIgnoreCase(temp.pergunta)){
            if(questao instanceof QuestaoMultiplaEscolhaCom){
                 if(temp.imprimeAlternativa().equalsIgnoreCase(imprimeAlternativa())){
                if(temp.imprimeResposta().equalsIgnoreCase(imprimeResposta())){
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
        return "Questao multipla escolha com varias resposta"; 
    }
    
}
