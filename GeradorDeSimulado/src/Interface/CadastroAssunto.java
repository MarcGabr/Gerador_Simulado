package Interface;

import Logica.Assunto;
import Logica.PersistenciaDados;
import Logica.Prova;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class CadastroAssunto extends JPanel implements ComponentListener {

    private final JTextField nomeAssunto;

    CadastroAssunto(Prova prova, ActionListener acao) {
        this.addComponentListener(this);
        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        JLabel labelTitulo = new JLabel("CADASTRAR ASSUNTO");
        labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JLabel labelAssunto = new JLabel("ASSUNTO :");
        nomeAssunto = new JTextField();
        nomeAssunto.setPreferredSize(new Dimension(200, 20));
        JButton botaoCadastrar = new JButton("CADASTRAR");
        botaoCadastrar.setIcon(new ImageIcon(getClass().getResource("/Interface/ok.png")));
        botaoCadastrar.addActionListener((ActionEvent ae) -> {
            if (!nomeAssunto.getText().equals("")) {
                if (!prova.getAssuntos().add(new Assunto(nomeAssunto.getText()))) {
                    JOptionPane.showMessageDialog(this, "Assunto já esta cadastrado\n Tente novamente");
                }else{
                    try {
                        PersistenciaDados.guardaDados(prova);
                    }catch(IOException ex) {}
                }
            } else {
                JOptionPane.showMessageDialog(this, "Dados Invalidos\n Tente novamente");
            }
            nomeAssunto.setText("");
        });
        JButton menu = new JButton("MENU");
        menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        menu.addActionListener(acao);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelTitulo)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelAssunto)
                        .addGap(10)
                        .addComponent(nomeAssunto)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(20)
                        .addComponent(botaoCadastrar)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addGap(30)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelAssunto)
                        .addComponent(nomeAssunto))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(botaoCadastrar)
                )
                .addGap(10)
        );

        this.add(painel, BorderLayout.CENTER);
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
        nomeAssunto.setText("");
    }
}
