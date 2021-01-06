package Interface;

import Logica.Assunto;
import Logica.Questao;
import Logica.QuestaoVouF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class QuestaoVouFGUI extends AbstractCadastroQuestoes {

    private JRadioButton botaoVerdadeiro;
    private JRadioButton botaoFalso;
    private ButtonGroup grupoRadio;

    public QuestaoVouFGUI(ArrayList<Questao> questao, ActionListener menu, Assunto assunto) {
        super(questao, menu, assunto);
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
    
    @Override
    JLabel titulo() {
        return new JLabel("EDITAR VERDADEIRO OU FALSO");
    }

    @Override
    void initializeComponents(){
        botaoVerdadeiro = new JRadioButton("Verdadeiro");
        botaoFalso = new JRadioButton("Falso");
        grupoRadio = new ButtonGroup();
        grupoRadio.add(botaoVerdadeiro);
        grupoRadio.add(botaoFalso);
    }

    @Override
    void newButtons(JPanel panel, ArrayList<Questao> questao) {
        JButton cadaastrar = new JButton("CADASTRAR");
        cadaastrar.setIcon(new ImageIcon(getClass().getResource("/Interface/ok.png")));
        panel.add(cadaastrar);
        cadaastrar.addActionListener((ActionEvent ae) -> {
            if (!pergunta.getText().equals("") && grupoRadio.getSelection() != null) {
                if (questao.add(new QuestaoVouF(pergunta.getText(), botaoVerdadeiro.isSelected(), assunto))) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Questao já cadastrada!", null, JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Impossivel cadastrar\nDigite TODOS os dados corretamente", null, JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
