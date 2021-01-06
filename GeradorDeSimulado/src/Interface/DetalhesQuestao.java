package Interface;

import Logica.Questao;
import Logica.QuestaoMultiplaEscolhaCom;
import Logica.QuestaoMultiplaEscolhaSem;
import java.awt.Dimension;
import javax.swing.*;

public class DetalhesQuestao extends JPanel {

    public DetalhesQuestao(Questao questaoSelected) {
        JPanel painel2 = new JPanel();
        JPanel painel = new JPanel();
        JLabel labelTipo = new JLabel("TIPOS:");
        JLabel labelAssunto = new JLabel("ASSUNTO:");
        JLabel labelPergunta = new JLabel("PERGUNTA:");
        JLabel labelResposta = new JLabel("RESPOSTA:");
        labelTipo.setPreferredSize(new Dimension(100, 20));
        labelAssunto.setPreferredSize(new Dimension(100, 20));
        labelPergunta.setPreferredSize(new Dimension(100, 20));
        labelResposta.setPreferredSize(new Dimension(100, 20));

        JTextArea textTipo = new JTextArea(questaoSelected.getTipo());
        JTextArea textAssunto = new JTextArea(questaoSelected.getAssunto().toString());
        JTextArea textPergunta = new JTextArea(questaoSelected.getPergunta());
        textTipo.setBackground(this.getBackground());
        textAssunto.setBackground(this.getBackground());
        textPergunta.setBackground(this.getBackground());

        textTipo.setColumns(30);
        textAssunto.setColumns(30);
        textPergunta.setColumns(30);

        textTipo.setWrapStyleWord(true);
        textTipo.setLineWrap(true);
        textAssunto.setWrapStyleWord(true);
        textAssunto.setLineWrap(true);
        textPergunta.setWrapStyleWord(true);
        textPergunta.setLineWrap(true);

        textTipo.setEditable(false);
        textAssunto.setEditable(false);
        textPergunta.setEditable(false);

        if (questaoSelected instanceof QuestaoMultiplaEscolhaCom || questaoSelected instanceof QuestaoMultiplaEscolhaSem) {
            JTextArea area4 = new JTextArea(questaoSelected.imprimeAlternativa());
            area4.setWrapStyleWord(true);
            area4.setLineWrap(true);
            area4.setEditable(false);
            area4.setBackground(this.getBackground());
            area4.setColumns(30);
            JLabel jLabel7 = new JLabel("ALTERNATIVAS");
            JTextArea area5 = new JTextArea(questaoSelected.imprimeResposta());
            area5.setWrapStyleWord(true);
            area5.setLineWrap(true);
            area5.setEditable(false);
            area5.setBackground(this.getBackground());
            area5.setColumns(30);
            GroupLayout layout = new GroupLayout(painel2);
            painel2.setLayout(layout);
            layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(GroupLayout.Alignment.LEADING,layout.createSequentialGroup()
                            .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                            .addComponent(area4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(labelResposta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(area5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(area4, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(10)
                    )
                    .addGap(10)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelResposta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(area5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
            );
        } else {
            JTextArea area5 = new JTextArea(questaoSelected.imprimeResposta());
            area5.setWrapStyleWord(true);
            area5.setLineWrap(true);
            area5.setEditable(false);
            area5.setBackground(this.getBackground());
            area5.setColumns(30);
            GroupLayout layout = new GroupLayout(painel2);
            painel2.setLayout(layout);
            layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                            .addComponent(labelResposta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(area5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(layout.createSequentialGroup()
                    .addGap(10)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(labelResposta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(area5, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(10)
            );
        }

        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10))
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10))
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelPergunta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textPergunta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10))
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(painel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelPergunta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(textPergunta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(painel2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(10)
        );
        this.add(painel);
    }

}
