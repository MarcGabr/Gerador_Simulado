/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Assunto;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class EditarAssunto extends JDialog{
    private JTextArea nomeAssunto=new JTextArea();
    public EditarAssunto(ArrayList<Assunto> assuntos, int selectedRow, ModeloTabela modelo) {
        this.nomeAssunto.setText(assuntos.get(selectedRow).toString());
        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        JLabel labelCadastro = new JLabel("EDITAR ASSUNTO");
        JLabel labelAssunto = new JLabel("ASSUNTO :");
        nomeAssunto.setAlignmentY(JTextArea.CENTER_ALIGNMENT);
        nomeAssunto.setLineWrap(true);
        nomeAssunto.setWrapStyleWord(true);
        JScrollPane o = new JScrollPane(nomeAssunto);
        o.setPreferredSize(new Dimension(200, 20));
        JButton botaoCadastrar= new JButton("Editar");
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelCadastro)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelAssunto)
                        .addGap(10)
                        .addComponent(o,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoCadastrar)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelCadastro)
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelAssunto)
                        .addComponent(o,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(botaoCadastrar)
                )
                .addGap(10)
        );
        botaoCadastrar.addActionListener((ActionEvent ae) -> {
            if (!nomeAssunto.getText().equals("")) {
                if (assuntos.set(selectedRow,new Assunto(nomeAssunto.getText()))==null) {
                    JOptionPane.showMessageDialog(null, "Assunto já esta cadastrado\n Tente novamente");
                }else{
                    modelo.fireTableDataChanged();
                    nomeAssunto.setText("");
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados Invalidos\n Tente novamente");
            }
            nomeAssunto.setText(assuntos.get(selectedRow).toString());
        });
        this.add(painel);
        this.pack();
        this.setResizable(false);
        this.setModal(true);
        this.show();
    }
}
