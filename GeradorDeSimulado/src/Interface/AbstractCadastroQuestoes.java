/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Assunto;
import Logica.Questao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
public abstract class AbstractCadastroQuestoes extends JDialog {

    protected final JTextArea pergunta = new JTextArea();
    protected final JScrollPane barraRolagem;
    protected final Assunto assunto;
    protected final JPanel painelPrincipal = new JPanel();

    AbstractCadastroQuestoes(ArrayList<Questao> questao, ActionListener menu, Assunto assunto) {
        this.assunto = assunto;
        initializeComponents();
        JLabel labelAssunto = new JLabel("Assunto: " + assunto.toString());
        JPanel resposta = painelResposta();
        
        JLabel labelTipoQuestao = titulo();
        labelTipoQuestao.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel labelPergunta = new JLabel("PERGUNTA");
        pergunta.setWrapStyleWord(true);
        pergunta.setLineWrap(true);
        barraRolagem = new JScrollPane(pergunta);
        barraRolagem.setPreferredSize(new Dimension(400, 50));
        JPanel opcoes = new JPanel(); //PAINEL COM AS OPÇOES DE MENU, CANCELAR E CADASTRAR/EDITAR
        opcoes.setPreferredSize(new Dimension(570, 50));
        opcoes.setLayout(new FlowLayout());
        JButton menu1 = new JButton("MENU");
        menu1.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
//        menu1.addActionListener((ActionEvent ae) -> {
//            AbstractCadastroQuestoes.this.dispose();
//        });
        menu1.addActionListener(menu);
        menu1.addActionListener((ActionEvent ae) -> { AbstractCadastroQuestoes.this.dispose();});
        JButton cancelar = new JButton("CANCELAR");
        cancelar.setIcon(new ImageIcon(getClass().getResource("/Interface/cancelar.png")));
        cancelar.addActionListener((ActionEvent ae) -> { AbstractCadastroQuestoes.this.dispose();});
        opcoes.add(menu1);
        opcoes.add(cancelar);
        newButtons(opcoes, questao);
        
        JPanel painel = new JPanel();
        this.add(painel, BorderLayout.CENTER);
        
        //CONFIGURACAO DO LAYOUT 
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelTipoQuestao)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPergunta)
                        .addGap(10)
                        .addComponent(barraRolagem, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addComponent(labelAssunto)
                .addComponent(resposta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(opcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(20)
                .addComponent(labelTipoQuestao)
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelPergunta)
                        .addComponent(barraRolagem, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGap(10)
                .addComponent(labelAssunto)
                .addGap(10)
                .addComponent(resposta, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(opcoes, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
        );

        //CONFIGURAÇÃO DO JDIALOG;
        
        
        this.add(painel);
        this.pack();
        this.setResizable(false);
        this.setModal(true);

    }

    abstract void initializeComponents(); //INICIALIZAR OS COMPONENTES

    abstract JPanel painelResposta(); //INICIALIZAR UM PAINEL CONTENDO UM LAYOUT DE RESPOSTA DE ACORDO COM O TIPO DE PERGUNTA

    abstract void newButtons(JPanel panel, ArrayList<Questao> questao); //ADICIONAR O BOTAO AO PAINEL RESPOSTA PODENDO SER CADASTRAR OU 

    abstract JLabel titulo();
}
