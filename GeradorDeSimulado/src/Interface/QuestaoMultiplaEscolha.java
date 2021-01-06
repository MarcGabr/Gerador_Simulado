/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class QuestaoMultiplaEscolha extends AbstractCadastroQuestoes {

    private ArrayList<JRadioButton> alternativas;
    private ArrayList<JTextArea> respostas;
    private JPanel painelResposta;
    private JPanel boxAlternativa;
    private JScrollPane barrarolagenAlternativas;
    private boolean[] respostaQuestao = null;
    private String[] alternativasQuestao = null;
    private JButton botaoOK;
    private JComboBox<Integer> boxQuantidade;
    private int numero=0;

    public QuestaoMultiplaEscolha(ArrayList<Questao> questao, ActionListener menu, Assunto assunto) {
        super(questao, menu, assunto);
        this.show();
    }

    @Override
    void initializeComponents() {
        this.respostas = new ArrayList<JTextArea>() {
            final int size = this.size();

            @Override
            public JTextArea remove(int i) {
                alternativas.remove(i);
                boxAlternativa.remove(i);
                return super.remove(i);
            }
        };
        this.boxAlternativa = new JPanel();
        this.boxAlternativa.setLayout(new BoxLayout(boxAlternativa, BoxLayout.Y_AXIS));
        this.painelResposta = new JPanel();
        this.alternativas = new ArrayList<>();
        this.boxQuantidade = new JComboBox<>();

        maxQuetoesPorAssunto(10);
        botaoOK = new JButton("OK");
        botaoOK.addActionListener((ActionEvent e) -> {
            if (boxQuantidade.getSelectedIndex() != 0) {
                numero=boxQuantidade.getSelectedIndex();
                atualizaAlternativa();
                barrarolagenAlternativas.setViewportView(painelResposta);
            } else {
                painelResposta.removeAll();
                respostas.removeAll(respostas);
                alternativas.removeAll(alternativas);
                boxAlternativa.removeAll();
                barrarolagenAlternativas.setViewportView(painelResposta);
                numero=0;
            }
        });
        barrarolagenAlternativas = new JScrollPane();
        barrarolagenAlternativas.setPreferredSize(new Dimension(500, 240));
        boxQuantidade.setPreferredSize(new Dimension(40, 20));
        barrarolagenAlternativas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    @Override
    JPanel painelResposta() {
        JLabel labelQTDPergunta = new JLabel("QUANTIDADE QUESTÕES");
        JPanel painel = new JPanel();
        painel.setMinimumSize(new Dimension(520, 300));
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelQTDPergunta)
                        .addGap(10)
                        .addComponent(boxQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(botaoOK)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(barrarolagenAlternativas)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelQTDPergunta)
                        .addComponent(boxQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoOK)
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(barrarolagenAlternativas, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );
        return painel;
    }

    @Override
    void newButtons(JPanel panel, ArrayList<Questao> questao) {
        JButton cadastrar = new JButton("CADASTRAR");
        cadastrar.setIcon(new ImageIcon(getClass().getResource("/Interface/ok.png")));
        panel.add(cadastrar);
        cadastrar.addActionListener((ActionEvent ae) -> {
            if (numero!= 0) {
                if (isValido()) {
                    if (questao.add(new QuestaoMultiplaEscolhaCom(pergunta.getText(), respostaQuestao, alternativasQuestao, assunto))) {
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Questao já cadastrada!", null, JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Impossivel cadastrar\nDigite TODOS os dados corretamente", null, JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this,"Numero de alternativas invalido", null,JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    @Override
    JLabel titulo() {
        return new JLabel("MULTIPLA ESCOLHA COM VARIAS RESPOSTAS");
    }

    protected void maxQuetoesPorAssunto(int max) {
        for (int il = 0; il <= max; il++) {
            this.boxQuantidade.addItem(il);
        }
    }

    protected boolean isValido() {
        alternativasQuestao = new String[numero];
        respostaQuestao = new boolean[numero];
        boolean op = false;
        for (int a = 0; a < numero; a++) {
            alternativasQuestao[a] = respostas.get(a).getText();
            if (respostas.get(a).getText().equals("")) {
                return false;
            }
            respostaQuestao[a] = alternativas.get(a).isSelected();
            if (respostaQuestao[a]) {
                op = true;
            }
        }
        return op;
    }

    protected void atualizaAlternativa() {
        if (numero> alternativas.size()) {
            aumentaQuantidadeDeAlternativas(numero);
        } else {
            if (numero< alternativas.size()) {
                diminuiQuantidadeDeAlternativas(numero);
            }
        }
        renomearRadioButton();
        painelResposta.removeAll();
        painelResposta.add(boxAlternativa);
    }

    private void diminuiQuantidadeDeAlternativas(int a) {
        int e = alternativas.size();
        for (int i = 0; i < e; i++) {
            if (respostas.get(i).getText().equals("")) {
                respostas.remove(i);
                e--;
                i--;
                if (e == a) {
                    return;
                }
            }
        }
        if (e > a) { //Verifica se ainda há componentes a ser removidos
            JPanel painelRespostaRemover = new JPanel();
            JCheckBox boxExcluir;
            JTextArea o;
            JPanel painel;
            JScrollPane srcoll;
            painelRespostaRemover.setLayout(new BoxLayout(painelRespostaRemover, BoxLayout.Y_AXIS));
            for (int i = 0; i < respostas.size(); i++) {
                o = new JTextArea(respostas.get(i).getText());
                o.setEditable(false);
                srcoll = new JScrollPane(o);
                srcoll.setPreferredSize(new Dimension(350, 30));
                boxExcluir = new JCheckBox();
                painel = new JPanel();
                painel.add(boxExcluir);
                painel.add(o);
                painelRespostaRemover.add(painel);
            }
            JLabel texto = new JLabel("Clique em " + (e - a) + " alternativa(s) á remover");
            JPanel painelJDialog = new JPanel();
            GroupLayout layout = new GroupLayout(painelJDialog);
            painelJDialog.setLayout(layout);
            layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(texto)
                    .addComponent(painelRespostaRemover)
            );
            layout.setVerticalGroup(layout.createSequentialGroup()
                    .addGap(10)
                    .addComponent(texto)
                    .addGap(10)
                    .addComponent(painelRespostaRemover)
            );
            if (JOptionPane.showConfirmDialog(this, painelJDialog, "Remover Alternativa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) != 1) { //Exibe tela de remover componente
                for (int i = respostas.size() - 1; i >= 0; i--) {
                    if (((JCheckBox) ((JPanel) painelRespostaRemover.getComponent(i)).getComponent(0)).isSelected()) {
                        respostas.remove(i);
                    }
                }
                if (respostas.size() > a) {
                    JOptionPane.showMessageDialog(null, "Numero inferior a quantidade a ser removida\nAlterando automaticamente para " + respostas.size() + " alternativa(s)");
                    boxQuantidade.setSelectedIndex(respostas.size());
                    numero=boxQuantidade.getSelectedIndex();
                } else {
                    if (respostas.size() < a) {
                        aumentaQuantidadeDeAlternativas(a);
                    }
                }
            }
        }
    }

    private void aumentaQuantidadeDeAlternativas(int a) { //aumenta de acordo com a necessidade
        JTextArea edt;
        JRadioButton radioButtonAlternativa;
        int i = respostas.size();
        JScrollPane scroll;
        for (; i < a; i++) {
            radioButtonAlternativa = new JRadioButton();
            edt = new JTextArea();
            edt.setLineWrap(true);
            edt.setWrapStyleWord(true);
            respostas.add(edt);
            alternativas.add(radioButtonAlternativa);
            scroll = new JScrollPane(edt);
            scroll.setPreferredSize(new Dimension(350, 30));
            JPanel temp = new JPanel();
            temp.add(radioButtonAlternativa, BorderLayout.WEST);
            temp.add(scroll, BorderLayout.EAST);
            temp.setMinimumSize(new Dimension(410, 30));
            boxAlternativa.add(temp);
        }
    }

    private void renomearRadioButton() {//Renomeia o Radio Button apos a alteraçao na quantidade de alternativas
        int i = 1;
        for (JRadioButton o : alternativas) {
            o.setText("Alternativa " + i);
            i++;
        }
    }
}
