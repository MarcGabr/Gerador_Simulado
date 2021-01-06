package Interface;

import Logica.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class EditorVouF extends AbstractCadastroQuestoes implements ComponentListener {

    private JRadioButton botaoVerdadeiro;
    private JRadioButton botaoFalso;
    private ButtonGroup grupoRadio;
    private final int questaoEditar;

    public EditorVouF(ArrayList<Questao> questao, ActionListener menu, Assunto assunto, int questaoEditar) {
        super(questao, menu, assunto);
        this.questaoEditar = questaoEditar;
        this.pergunta.setText(questao.get(questaoEditar).getPergunta());
        this.barraRolagem.setViewportView(pergunta);
        this.botaoFalso.setSelected(!((QuestaoVouF) questao.get(questaoEditar)).getResposta());
        this.botaoVerdadeiro.setSelected(((QuestaoVouF) questao.get(questaoEditar)).getResposta());
        this.show();
    }

    @Override
    JPanel painelResposta() {
        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoVerdadeiro)
                        .addGap(250)
                        .addComponent(botaoFalso))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(botaoVerdadeiro)
                        .addComponent(botaoFalso))
        );
        return painel;
    }

    private void limpa() {
        this.pergunta.setText("");
        grupoRadio.clearSelection();
    }

    @Override
    JLabel titulo() {
        return new JLabel("EDITAR QUESTÃO\nVERDADEIRO OU FALSO");
    }

    @Override
    void initializeComponents() {
        botaoVerdadeiro = new JRadioButton("Verdadeiro");
        botaoFalso = new JRadioButton("Falso");
        grupoRadio = new ButtonGroup();
        grupoRadio.add(botaoVerdadeiro);
        grupoRadio.add(botaoFalso);
    }

    @Override
    void newButtons(JPanel panel, ArrayList<Questao> questao) {
        JButton editar = new JButton("EDITAR");
        editar.setIcon(new ImageIcon(getClass().getResource("/Interface/editar.png")));
        panel.add(editar);
        editar.addActionListener((ActionEvent ae) -> {
            if (!pergunta.getText().equals("") && grupoRadio.getSelection() != null) {
                if (questao.set(questaoEditar, new QuestaoVouF(pergunta.getText(), botaoVerdadeiro.isSelected(), assunto)) != null) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Questao já cadastrada!", null, JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Impossivel cadastrar\nDigite TODOS os dados corretamente", null, JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {

    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }
}
