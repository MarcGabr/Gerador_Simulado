/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Logica.Assunto;
import Logica.PersistenciaDados;
import Logica.Prova;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class ListaAssunto extends JPanel implements ComponentListener {

    private JTable tabela;
    private ModeloTabela modelo;
    private final JButton detalhes = new JButton("DETALHES");
    private JButton excluir = new JButton("EXCLUIR");
    private JButton editar = new JButton("EDITAR");

    ListaAssunto(Prova prova, ActionListener acao) {
        this.addComponentListener(this);
        JButton menu = new JButton("MENU");
        menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        menu.addActionListener(acao);

        detalhes.setIcon(new ImageIcon(getClass().getResource("/Interface/detalhes.png")));

        excluir.setIcon(new ImageIcon(getClass().getResource("/Interface/excluir.png")));

        editar.setIcon(new ImageIcon(getClass().getResource("/Interface/editar.png")));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        JLabel labelTitulo = new JLabel("LISTA ASSUNTO", JLabel.CENTER);
        labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        tabela = new JTable();
        modelo = new ModeloTabela(prova.getAssuntos());
        tabela.setModel(modelo);
        tabela.getTableHeader().setBackground(Color.GRAY);
        tabela.getColumnModel().getColumn(1).setMinWidth(90);
        tabela.getColumnModel().getColumn(1).setMaxWidth(90);
        tabela.getColumnModel().getColumn(2).setMinWidth(110);
        tabela.getColumnModel().getColumn(2).setMaxWidth(110);
        tabela.getColumnModel().getColumn(3).setMinWidth(50);
        tabela.getColumnModel().getColumn(3).setMaxWidth(50);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getColumnModel().getColumn(3).setResizable(false);
        tabela.setDragEnabled(false);
        tabela.setColumnSelectionAllowed(false);
        tabela.setRowHeight(40);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane b = new JScrollPane(tabela);
        b.setPreferredSize(new Dimension(580, 350));

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelTitulo)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(b)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(10)
                        .addComponent(detalhes)
                        .addGap(10)
                        .addComponent(excluir)
                        .addGap(10)
                        .addComponent(editar)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(10)
                .addComponent(labelTitulo)
                .addGap(10)
                .addComponent(b)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(detalhes)
                        .addComponent(excluir)
                        .addComponent(editar)
                )
                .addGap(10)
        );
        detalhes.addActionListener((ActionEvent ae) -> {
            if (tabela.getSelectedRow() != -1) {
                Assunto assunto = modelo.getAssunto(tabela.getSelectedRow());
                JPanel painelInformacao = new JPanel();
                JPanel painel1 = new JPanel();
                painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
                painel1.add(new JLabel("NOME: " + assunto.toString()));
                painel1.add(new JLabel("QUANTIDAES DE QUESTÕES: " + Integer.toString(assunto.getQuantidade())));
                painel1.add(new JLabel("DATA: " + assunto.getData()));
                painel1.add(new JLabel("ESTADO: " + (assunto.getAtivo() ? "Ativo" : "Excluido")));
                GroupLayout layoutInformacao = new GroupLayout(painelInformacao);
                painelInformacao.setLayout(layoutInformacao);
                layoutInformacao.setHorizontalGroup(layoutInformacao.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(layoutInformacao.createSequentialGroup()
                                .addComponent(painel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                );
                layoutInformacao.setVerticalGroup(layoutInformacao.createSequentialGroup()
                        .addGap(10)
                        .addComponent(painel1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                );
                JOptionPane.showMessageDialog(tabela, painelInformacao, "Detalhes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um Assunto", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        excluir.addActionListener((ActionEvent ae) -> {
            if (tabela.getSelectedRow() != -1) {
                prova.getAssuntos().remove(tabela.getSelectedRow());
                try {
                    PersistenciaDados.guardaDados(prova);
                } catch (IOException ex) {
                }
                modelo.fireTableDataChanged();
                if (!modelo.getAssunto(tabela.getSelectedRow()).getAtivo()) {
                    editar.setEnabled(false);
                    excluir.setEnabled(false);
                } else {
                    editar.setEnabled(true);
                    excluir.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um Assunto", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        editar.addActionListener((ActionEvent ae) -> {
            if (tabela.getSelectedRow() != -1) {
                new EditarAssunto(prova.getAssuntos(), tabela.getSelectedRow(), modelo);
                try {
                    PersistenciaDados.guardaDados(prova);
                } catch (IOException ex) {
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um Assunto", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        tabela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (!modelo.getAssunto(tabela.getSelectedRow()).getAtivo()) {
                    editar.setEnabled(false);
                    excluir.setEnabled(false);
                } else {
                    editar.setEnabled(true);
                    excluir.setEnabled(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
        });
    }

    private void isEmpity() {
        if (modelo.getAssuntos().size() == 0) {
            detalhes.setEnabled(false);
            editar.setEnabled(false);
            excluir.setEnabled(false);
        } else {
            detalhes.setEnabled(true);
            editar.setEnabled(true);
            excluir.setEnabled(true);
        }
    }

    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
        modelo.fireTableDataChanged();
        isEmpity();
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
    }

    public void acoes() {

    }
}
