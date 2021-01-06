package Interface;

import Logica.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class EditarMultiplaEscolha extends AbstractCadastroQuestoes {

    protected ArrayList<JRadioButton> alternativas;
    protected JPanel boxResposta;
    protected ArrayList<JTextArea> respostas;
    protected JScrollPane barrarolagenAlternativas;
    protected boolean[] respostaQuestao = null;
    protected String[] alternativasQuestao = null;
    int indexQuestao;
    int QuantidadeAlternativa;

    public EditarMultiplaEscolha(ArrayList<Questao> questao, ActionListener menu, Assunto assunto, int indexQuestao) {
        super(questao, menu, assunto);
        QuestaoMultiplaEscolhaCom o = (QuestaoMultiplaEscolhaCom) questao.get(indexQuestao);
        this.indexQuestao = indexQuestao;
        this.QuantidadeAlternativa = o.getAlternativa().length;
        pergunta.setText(o.getPergunta());
        atualizaAlternativa(o.getAlternativa(), o.getResposta());
        this.show();
    }

    @Override
    void initializeComponents() {
        this.respostas = new ArrayList<>();
        this.boxResposta = new JPanel();
        this.alternativas = new ArrayList<>();
        barrarolagenAlternativas = new JScrollPane();
        barrarolagenAlternativas.setPreferredSize(new Dimension(500, 240));
        barrarolagenAlternativas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    @Override
    JPanel painelResposta() {
        JPanel painel = new JPanel();
        painel.setMinimumSize(new Dimension(520, 300));
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(barrarolagenAlternativas)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(barrarolagenAlternativas, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
        );
        return painel;
    }

    @Override
    void newButtons(JPanel panel, ArrayList<Questao> questao) {
        JButton editar = new JButton("EDITAR");
        editar.setIcon(new ImageIcon(getClass().getResource("/Interface/editar.png")));
        panel.add(editar);
        editar.addActionListener((ActionEvent ae) -> {
            if (isValido()) {
                if (questao.set(indexQuestao, new QuestaoMultiplaEscolhaCom(pergunta.getText(), respostaQuestao, alternativasQuestao, assunto)) != null) {
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Questao já cadastrada!", null, JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Impossivel cadastrar\nDigite TODOS os dados corretamente", null, JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    @Override
    JLabel titulo() {
        return new JLabel("EDITAR QUESTÃO MULTIPLA ESCOLHA COM VARIAS RESPOSTAS");
    }

    protected boolean isValido() {
        alternativasQuestao = new String[QuantidadeAlternativa];
        respostaQuestao = new boolean[QuantidadeAlternativa];
        boolean op = false;
        for (int a = 0; a < QuantidadeAlternativa; a++) {
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

    private void atualizaAlternativa(String[] alternativa, boolean[] resposta) {
        JTextArea edt;
        JRadioButton radioButtonAlternativa;
        JScrollPane scroll;
        JPanel painelResposta = new JPanel();
        painelResposta.setLayout(new BoxLayout(painelResposta, BoxLayout.Y_AXIS));
        for (int i = 0; i < alternativa.length; i++) {
            radioButtonAlternativa = new JRadioButton();
            radioButtonAlternativa.setText("Alternativa " + (i + 1));
            edt = new JTextArea();
            edt.setLineWrap(true);
            edt.setWrapStyleWord(true);
            edt.setText(alternativa[i]);
            radioButtonAlternativa.setSelected(resposta[i]);
            respostas.add(edt);
            alternativas.add(radioButtonAlternativa);
            scroll = new JScrollPane(edt);
            scroll.setPreferredSize(new Dimension(350, 30));
            JPanel temp = new JPanel();
            temp.add(radioButtonAlternativa, BorderLayout.WEST);
            temp.add(scroll, BorderLayout.EAST);
            temp.setMinimumSize(new Dimension(410, 30));
            painelResposta.add(temp);
        }
        boxResposta.add(painelResposta);
        barrarolagenAlternativas.setViewportView(boxResposta);
    }
}
