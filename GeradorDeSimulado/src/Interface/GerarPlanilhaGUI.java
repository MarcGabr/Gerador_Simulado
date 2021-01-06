/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Prova;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

/**
 *
 * @author raykson santos
 */
public class GerarPlanilhaGUI extends JPanel implements ComponentListener {

    JTextField nomeDoArquivo = new JTextField();

    public GerarPlanilhaGUI(Prova prova, ActionListener acao) {
        JPanel painel = new JPanel();
        JLabel labelTitulo = new JLabel("GERAR PLANILHA");
        labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JLabel labelArquivo = new JLabel("Nome do arquivo");

        nomeDoArquivo.setPreferredSize(new Dimension(150, 20));
        labelArquivo.setPreferredSize(new Dimension(120, 20));

        JButton menu = new JButton("MENU");
        menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        menu.addActionListener(acao);
        JButton buttonok = new JButton("GERAR");
        buttonok.setIcon(new ImageIcon(getClass().getResource("/Interface/planilha.png")));
        buttonok.addActionListener((ActionEvent arg0) -> {
            try {
                if (!nomeDoArquivo.getText().equals("")) {
                    JFileChooser o = new JFileChooser();
                    o.setMultiSelectionEnabled(false);
                    o.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    if (o.showSaveDialog(GerarPlanilhaGUI.this) == 0) {
                        if (o.getSelectedFile().isDirectory()) {
                            boolean existe = false;
                            for (String file : o.getSelectedFile().list()) {
                                if (file.endsWith(".csv")) {
                                    if (file.equals(nomeDoArquivo.getText() + ".csv")) {
                                        existe = true;
                                        break;
                                    }
                                }
                            }
                            if (existe) {
                                if (JOptionPane.showConfirmDialog(o, "Arquivo já existente deseja substitui-lo?", null, JOptionPane.YES_NO_OPTION) != 0) {
                                    return;
                                }
                            }
                            prova.geraCSV(o.getSelectedFile().getAbsolutePath() + "\\" + nomeDoArquivo.getText()+".csv");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(GerarPlanilhaGUI.this, "Digite TODOS os dados corretamente");
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(GerarPlanilhaGUI.this, "Erro ao grava o arquivo");
            }
        });

        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(labelTitulo))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(nomeDoArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(20)
                        .addComponent(buttonok))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(20)
                        .addComponent(labelArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomeDoArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(buttonok))
        );
        this.add(painel, BorderLayout.CENTER);
        this.addComponentListener(this);
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
        nomeDoArquivo.setText("");
    }
}
