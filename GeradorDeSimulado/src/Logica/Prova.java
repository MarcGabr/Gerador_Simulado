package Logica;

import java.io.*;
import java.util.*;

public class Prova {

    private ArrayList<Assunto> assuntos = new ArrayList<Assunto>() {
        @Override
        public boolean add(Assunto e) {
            if (!super.contains(e)) {
                super.add(e);
                return true;
            }
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return super.contains(o);
        }

        @Override
        public boolean remove(Object o) {
            if (((Assunto) o).getAtivo()) {
                ((Assunto) o).setAtivo(false); //"Remoção dos assuntos"
                return true;
            }
            return false;
        }

        @Override
        public Assunto remove(int i) {
            if (this.get(i).getAtivo()) {
                this.get(i).setAtivo(false);
            }
            return this.get(i);
        }

        @Override
        public Assunto set(int i, Assunto e) {
            if (!this.contains(e)) {
                get(i).setAssunto(e.getNome());
                return get(i);
            }
            return null;
        }
    };
    private final ArrayList<Questao> questoes = new ArrayList<Questao>() {
        @Override
        public boolean add(Questao e) {
            if (!this.contains(e)) {
                if (e.getAssunto().addQuestao()) {
                    super.add(e);
                    return true;
                }
            }
            return false;
        }

        @Override
        public Questao set(int i, Questao e) {
            if (!this.contains(e) && e.getAssunto().getAtivo()) {
                return super.set(i, e);
            }
            return null;
        }

        @Override
        public boolean remove(Object o) {
            if (((Questao) o).getAssunto().removeQuestao()) {
                return super.remove(o);
            }
            return false;
        }
    };

    public ArrayList<Assunto> getAssuntos() {
        return assuntos;
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }

    public ArrayList<Questao> getQuestoesPergunta(String pergunta) {
        ArrayList<Questao> busca = new ArrayList<>();
        questoes.stream().filter((k) -> (k.getPergunta().equals(pergunta))).forEachOrdered(busca::add);
        return busca;
    }

    public ArrayList<Questao> getQuestoesAssunto(Assunto assunto) {
        ArrayList<Questao> porAssunto = new ArrayList<>();
        questoes.stream().filter((k) -> (k.getAssunto().equals(assunto))).forEachOrdered(porAssunto::add);
        return porAssunto;
    }

    public boolean geraProvaDoc(Assunto assunto, int qtdQuestoes, String data, String file, String disciplina, Float valor, String professor) {
        if (assunto.getQuantidade() < qtdQuestoes) {
            return false;
        }
        Random number = new Random();
        ArrayList<Questao> questaoProva = new ArrayList<>();
        ArrayList<Questao> questao = (ArrayList<Questao>) getQuestoesAssunto(assunto);
        //Usado para pegar os valores aletorio, sorteados;
        HashSet<Integer> numeros = new HashSet<Integer>();
        for (int j = 0; j < qtdQuestoes; j++) {
            boolean isV = false;
            int l = number.nextInt(questao.size());
            numeros.add(l);
            Questao temp = questao.get(l);
            for (Questao o : questaoProva) { //verifica se há perguntas iguais ja  sorteada
                if (temp.isEqualsPergunta(o)) {
                    isV = true;
                    break;
                }
            }
            if (!isV) {
                questaoProva.add(temp); //Adiciona questao
            } else {
                j--;
            }
            if (numeros.size() == questao.size()) { //Se a quantidade de numeros sorteados for igual a quantidade de questoes no assuno
                if (questaoProva.size() == qtdQuestoes) { //Se a quantidade de questoes da prova for igual a quantidade de questoes aleatoria "geradas"
                    break;  //Sai do loop
                } else {
                    return false;// Senao retorna false não é possivel fazer a prova
                }
            }
        }
        String[] prova = new String[questaoProva.size()];
        int i = 0;
        for (Questao temp : questaoProva) {
            prova[i] = Integer.toString(i + 1) + ") " + temp.imprimeQuestao();
            i++;
        }
        GeneratorPDF.gerar(prova, data, file, qtdQuestoes, disciplina, valor, professor); //Classe geradora de pdf
        return true;
    }

    public void geraTXT(Assunto assunto, boolean tipo, String arquivo) throws IOException {

        FileWriter arq = new FileWriter(arquivo);
        try (PrintWriter gravarArq = new PrintWriter(arq)) {
            int j;
            if (tipo) {
                gravarArq.println("Questões do assunto " + assunto.getNome() + ", com as respostas.\n");
                j = 1;
                for (Questao o : getQuestoesAssunto(assunto)) {
                    gravarArq.print((j++) + " )");
                    for (String k : o.imprimeQuestao().split("\n")) {
                        gravarArq.println(k);
                    }
                    gravarArq.println("Resposta:");
                    for (String k : o.imprimeResposta().split("\n")) {
                        gravarArq.println(k);
                    }
                    gravarArq.println();
                }
            } else {
                gravarArq.println("Questões do assunto " + assunto.getNome() + ", sem as respostas.\n");
                j = 1;
                for (Questao o : getQuestoesAssunto(assunto)) {
                    gravarArq.println((j++) + ")" + o.imprimeQuestao() + "\n");
                    for (String k : o.imprimeQuestao().split("\n")) {
                        gravarArq.println(k);
                    }
                    gravarArq.println();
                }
            }
        }
    }

    public void geraCSV(String file) throws IOException {
        FileWriter arq = new FileWriter(file);
        try (PrintWriter gravarArq = new PrintWriter(arq)) {
            gravarArq.println("Assunto,Estado,Quantidade Máxima,Quantidade atual,Data");
            assuntos.forEach((Assunto o) -> {
                gravarArq.println(o.getNome() + "," + (o.getAtivo() ? "Ativo" : "Excluído") + "," + o.getQuantidade() + "," + o.getQuantidade() + "," + o.getData());
            });
        }
    }

}
