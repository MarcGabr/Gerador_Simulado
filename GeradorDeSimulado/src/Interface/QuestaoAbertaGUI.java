/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Assunto;
import Logica.Questao;
import Logica.QuestaoAberta;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public class QuestaoAbertaGUI extends AbstractCadastroQuestoes {
    private JTextArea t;
    public QuestaoAbertaGUI(ArrayList<Questao> questao, ActionListener menu, Assunto assunto) {
        super(questao, menu, assunto);
        this.show();
    }

    @Override
    JPanel painelResposta() {
        
        t.setLineWrap(true);
        t.setWrapStyleWord(true);
        t.setPreferredSize(new Dimension(400, 75));
        JScrollPane scroll = new JScrollPane(t);
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
    void newButtons(JPanel panel,ArrayList<Questao>questao) {
        JButton cadastrar = new JButton("CADASTRAR");
        cadastrar.setIcon(new ImageIcon(getClass().getResource("/Interface/ok.png")));
        panel.add(cadastrar);
        cadastrar.addActionListener((ActionEvent ae) -> {
            if (!pergunta.getText().equals("") && !t.getText().equals("")) {
                if (!questao.add(new QuestaoAberta(pergunta.getText(), t.getText(), assunto))){
                    JOptionPane.showMessageDialog(null,"Questao já cadastrada!",null,JOptionPane.WARNING_MESSAGE);
                }else{
                    this.dispose();
                }
            }else{
                 JOptionPane.showMessageDialog(this, "Impossivel cadastrar\nDigite TODOS os dados corretamente", null, JOptionPane.WARNING_MESSAGE);
            }
            pergunta.setText("");
            t.setText("");
        });
    }

    @Override
    JLabel titulo() {
        return new JLabel("CADASTRO QUESTÃO ABERTA"); //To change body of generated methods, choose Tools | Templates.
    } 




}
