package Interface;

import Logica.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class QuestaoSemMultiplaGUI extends AbstractCadastroQuestoes {

    private ArrayList<JRadioButton> respostaJRadioButton;
    private ArrayList<JTextArea> alternativasJTextArea;
    private ButtonGroup grupo;
    private JPanel painelDeRespostas;
    private JPanel boxDeAlternativas;
    private JScrollPane barrarolagenAlternativas;
    private boolean [] resposta;
    private String[] alternativasQuestao;
    private JComboBox<Integer> boxQuantidade;
    private int numero=0;

    public QuestaoSemMultiplaGUI(ArrayList<Questao> questao, ActionListener menu, Assunto assunto) {
        super(questao, menu, assunto);
        this.show();
    }

    @Override
    void initializeComponents() {
        grupo = new ButtonGroup();
        this.alternativasJTextArea = new ArrayList<JTextArea>() {
            @Override
            public JTextArea remove(int i) {
                grupo.remove(respostaJRadioButton.remove(i));
                boxDeAlternativas.remove(i);
                return super.remove(i);
            }
        };
        this.respostaJRadioButton = new ArrayList<>();
        this.boxDeAlternativas = new JPanel();
        this.boxDeAlternativas.setLayout(new BoxLayout(boxDeAlternativas, BoxLayout.Y_AXIS));
        this.painelDeRespostas = new JPanel();
        
        this.boxQuantidade = new JComboBox<>();
        maxQuetoesPorAssunto(10);
        barrarolagenAlternativas = new JScrollPane();
        barrarolagenAlternativas.setPreferredSize(new Dimension(500, 240));
        boxQuantidade.setPreferredSize(new Dimension(40, 20));
        barrarolagenAlternativas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    @Override
    JPanel painelResposta() {
        JLabel labelQTDPergunta = new JLabel("QUANTIDADE DE ALTERNATIVAS: ");
        JButton botaoOK = new JButton("OK");
        botaoOK.addActionListener((ActionEvent e) -> {
            if (boxQuantidade.getSelectedIndex() != 0) {
                numero=boxQuantidade.getSelectedIndex();
                atualizaAlternativa();
                barrarolagenAlternativas.setViewportView(painelDeRespostas);
            } else {
                alternativasJTextArea.removeAll(alternativasJTextArea);
                respostaJRadioButton.removeAll(respostaJRadioButton);
                boxDeAlternativas.removeAll();
                painelDeRespostas.removeAll();
                barrarolagenAlternativas.setViewportView(painelDeRespostas);
                numero=0;
            }
        });
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

            if (numero != 0) {
                if (isValido()) {
                    if (questao.add(new QuestaoMultiplaEscolhaSem(pergunta.getText(), resposta, alternativasQuestao, assunto))) {
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
        return new JLabel("MULTIPLA ESCOLHA COM UNICA RESPOSTA");
    }

    private void maxQuetoesPorAssunto(int max) {
        for (int il = 0; il <= max; il++) {
            this.boxQuantidade.addItem(il);
        }
    }

    private boolean isValido() {
        int al = numero;
        alternativasQuestao = new String[al];
        resposta=new boolean[al];
        boolean op = false;
        for (int a = 0; a < al; a++) {
            alternativasQuestao[a] = alternativasJTextArea.get(a).getText();
            if (alternativasJTextArea.get(a).getText().equals("")) {
                return false;
            }
            resposta[a]=respostaJRadioButton.get(a).isSelected();
            if(resposta[a]){
                op=true;
            }
        }
        return op;
    }

    protected void atualizaAlternativa() {
        int a = (int) boxQuantidade.getSelectedItem();
        if (a > respostaJRadioButton.size()) {
            aumentaQuantidadeDeAlternativas(a);
        } else {
            if (a < respostaJRadioButton.size()) {
                diminuiQuantidadeDeAlternativas(a);
            }
        }
        renomear();
        painelDeRespostas.removeAll();
        painelDeRespostas.add(boxDeAlternativas);
    }

    private void diminuiQuantidadeDeAlternativas(int a) {
        int e = respostaJRadioButton.size();
        for (int i = 0; i < e; i++) {
            if (alternativasJTextArea.get(i).getText().equals("")) {
                alternativasJTextArea.remove(i);
                e--;
                if (e == a) {
                    renomear();
                    break;
                }
                i--;
            }
        }
        if (e > a) {
            JPanel painelRespostaRemover = new JPanel();
            JCheckBox boxExcluir;
            JTextArea o;
            JPanel painel;
            JScrollPane srcoll;
            painelRespostaRemover.setLayout(new BoxLayout(painelRespostaRemover, BoxLayout.Y_AXIS));
            for (int i = 0; i < alternativasJTextArea.size(); i++) {
                o = new JTextArea(alternativasJTextArea.get(i).getText());
                o.setEditable(false);
                srcoll = new JScrollPane(o);
                srcoll.setPreferredSize(new Dimension(350, 30));
                boxExcluir = new JCheckBox();
                painel = new JPanel();
                painel.add(boxExcluir);
                painel.add(o);
                painelRespostaRemover.add(painel);
            }

            JLabel texto = new JLabel("Clique nas alternativas á remover");
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
            if (JOptionPane.showConfirmDialog(this, painelJDialog, "Remover Alternativa", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE) != 1) {
                for (int i = alternativasJTextArea.size() - 1; i >= 0; i--) {
                    if (((JCheckBox) ((JPanel) painelRespostaRemover.getComponent(i)).getComponent(0)).isSelected()) {
                        alternativasJTextArea.remove(i);
                    }
                }
            }
            if (alternativasJTextArea.size() > a) {
                 JOptionPane.showMessageDialog(null, "Numero inferior a quantidade a ser removida\nAlterando automaticamente para "+alternativasJTextArea.size()+" alternativa(s)");
                boxQuantidade.setSelectedIndex(alternativasJTextArea.size());
            } else {
                if (alternativasJTextArea.size() < a) {
                    aumentaQuantidadeDeAlternativas(a);
                }
            }
        }
    }

    private void renomear() {
        int e = 1;
        for (JRadioButton o : respostaJRadioButton) {
            o.setText("Alternativa " + e);
            e++;
        }
    }

    private void aumentaQuantidadeDeAlternativas(int a) {
        JTextArea edt;
        JRadioButton radioButtonAlternativa;
        int i = alternativasJTextArea.size();
        JScrollPane scroll;
        for (; i < a; i++) {
            radioButtonAlternativa = new JRadioButton();
            radioButtonAlternativa.setText("Alternativa " + (i + 1));
            edt = new JTextArea();
            edt.setLineWrap(true);
            edt.setWrapStyleWord(true);
            grupo.add(radioButtonAlternativa);
            alternativasJTextArea.add(edt);
            respostaJRadioButton.add(radioButtonAlternativa);
            scroll = new JScrollPane(edt);
            scroll.setPreferredSize(new Dimension(350, 30));
            JPanel temp = new JPanel();
            temp.add(radioButtonAlternativa, BorderLayout.WEST);
            temp.add(scroll, BorderLayout.EAST);
            temp.setMinimumSize(new Dimension(410, 30));
            boxDeAlternativas.add(temp);
        }
    }
}
