/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Assunto;
import Logica.EnviarMail;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class EnviarEmailGUI extends JPanel implements ComponentListener {

    boolean salvo = false;
    Assunto assunto = new Assunto("");
    JTextField textoAssuntoEmail = new JTextField();
    JTextField localArquivo = new JTextField();
    JScrollPane scroll = new JScrollPane();
    JTextArea destinatario = new JTextArea();
    JButton enviar = new JButton("ENVIAR");
    JLabel labelAjuda = new JLabel("?");
    JButton buscar = new JButton();

    EnviarEmailGUI(ActionListener acaoVoltar) {
        this.addComponentListener(this);
        JLabel labelAssunto = new JLabel("Assunto");
        JLabel labelLocalArquivo = new JLabel();
        JLabel labelEmail = new JLabel("ENVIAR EMAIL");
        JLabel labelDestinatario = new JLabel("Email dos destinatarios");

        JButton menu = new JButton("MENU");
        menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        JPanel painel = new JPanel();
        labelLocalArquivo.setText("Local do arquivo");
        buscar.setText("Localizar");
        buscar.setIcon(new ImageIcon(getClass().getResource("/Interface/pesquisa.png")));
        enviar.setIcon(new ImageIcon(getClass().getResource("/Interface/email.png")));
        labelEmail.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        scroll.setViewportView(destinatario);
        labelAjuda.setFont(new java.awt.Font("Arial Black", 1, 12));
        labelAjuda.setToolTipText("Digite os emails separados por ';'");

        scroll.setPreferredSize(new Dimension(250, 60));
        localArquivo.setPreferredSize(new Dimension(250, 20));
        textoAssuntoEmail.setPreferredSize(new Dimension(250, 20));

        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(138)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(labelEmail)
                                        .addGap(140))))
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(30)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(labelLocalArquivo)
                                                                .addComponent(labelAssunto))
                                                        .addGap(20))
                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(10)
                                                        .addComponent(labelDestinatario)
                                                        .addGap(20)))
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(localArquivo, GroupLayout.Alignment.LEADING)
                                                .addComponent(textoAssuntoEmail, GroupLayout.Alignment.LEADING))
                                        .addGap(10)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(labelAjuda, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(buscar)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(158)
                                        .addComponent(menu))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(enviar)
                                        .addGap(158)))
                        .addGap(10))
        );
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(30)
                        .addComponent(labelEmail)
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textoAssuntoEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelAssunto))
                        .addGap(20)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(localArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelLocalArquivo))
                                .addComponent(buscar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(20)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(scroll, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelAjuda)))
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(32)
                                        .addComponent(labelDestinatario)))
                        .addGap(10)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(enviar)
                                .addComponent(menu))
                )
        );
        buscar.addActionListener((ActionEvent ae) -> {
            JFileChooser o = new JFileChooser();
            o.setAcceptAllFileFilterUsed(false);
            o.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File file) {
                    if (file.isDirectory()) {
                        return true;
                    }
                    if (file.getPath().endsWith(".pdf")) {
                        return true;
                    }
                    return false;
                }

                @Override
                public String getDescription() {
                    return null;
                }
            });
            if (o.showOpenDialog(EnviarEmailGUI.this) == 0) {
                localArquivo.setText(o.getSelectedFile().getAbsolutePath());
            }
        });
        enviar.addActionListener((ActionEvent ae) -> {
            if (!localArquivo.getText().equals("")) {
                if (localArquivo.getText().endsWith(".pdf")) {
                    if (!destinatario.getText().equals("")) {
                        if (!EnviarMail.sendMail(destinatario.getText().split(";"), textoAssuntoEmail.getText(), localArquivo.getText())) {
                            JOptionPane.showMessageDialog(EnviarEmailGUI.this, "Erro a enviar. Verifique se há conexão", "Erro", JOptionPane.WARNING_MESSAGE);
                        } else {
                            limpa();
                        }
                    } else {
                        JOptionPane.showMessageDialog(EnviarEmailGUI.this, "Sem destinatario", "Erro", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(EnviarEmailGUI.this, "Arquivo incorreto", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(EnviarEmailGUI.this, "Sem localização", "Erro", JOptionPane.WARNING_MESSAGE);
            }
        });
        menu.addActionListener(acaoVoltar);
        this.add(painel);
        this.setPreferredSize(new Dimension(610, 500));
    }

    private void limpa() {
        textoAssuntoEmail.setText("");
        localArquivo.setText("");
        destinatario.setText("");
        scroll.setViewportView(destinatario);
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
        limpa();
    }
}
