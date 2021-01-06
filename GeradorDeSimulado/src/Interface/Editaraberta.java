package Interface;

import Logica.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Editaraberta extends AbstractCadastroQuestoes {

    private JTextArea t;
    private final int questaoSelecionada;
    private JScrollPane scroll;

    public Editaraberta(ArrayList<Questao> questao, ActionListener menu, Assunto assunto, int questaoSelecionada) {
        super(questao, menu, assunto);
        this.questaoSelecionada = questaoSelecionada;
        pergunta.setText(questao.get(questaoSelecionada).getPergunta());
        t.setText(questao.get(questaoSelecionada).imprimeResposta());
        this.show();
    }

    @Override
    JPanel painelResposta() {
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        t.setPreferredSize(new Dimension(400, 75));
        scroll = new JScrollPane(t);
        JPanel painel = new JPanel();
        painel.setLayout(new FlowLayout());
        painel.add(new JLabel("RESPOSTA"));
        painel.add(scroll);
        return painel;
    }

    @Override
    void initializeComponents() {
        t = new JTextArea();
    }

    @Override
    void newButtons(JPanel panel, ArrayList<Questao> questao) {
        JButton editar = new JButton("EDITAR");
        editar.setIcon(new ImageIcon(getClass().getResource("/Interface/editar.png")));
        panel.add(editar);
        editar.addActionListener((ActionEvent ae) -> {
            if (!pergunta.getText().equals("") && !t.getText().equals("")) {
                if (questao.set(questaoSelecionada, new QuestaoAberta(pergunta.getText(), t.getText(), assunto)) == null) {
                    JOptionPane.showMessageDialog(null, null, "Questao já cadastrada!", JOptionPane.WARNING_MESSAGE);
                } else {
                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Digite os dados corretamente");
            }
        });
    }

    @Override
    JLabel titulo() {
        return new JLabel("EDITAR QUESTÃO ABERTA");
    }
}
