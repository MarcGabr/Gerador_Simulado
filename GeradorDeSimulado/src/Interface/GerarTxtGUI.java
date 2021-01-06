package Interface;

import Logica.Assunto;
import Logica.Prova;
import java.awt.*;
import java.io.IOException;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class GerarTxtGUI extends JPanel implements ComponentListener {

    private final JComboBox<Assunto> comboBoxAssuntos = new JComboBox<>();
    private final JTextField nomeDoArquivo = new JTextField();
    private final ArrayList<Assunto> assuntos;

    public GerarTxtGUI(Prova prova, ActionListener acao) {
        assuntos = prova.getAssuntos();
        JPanel painel = new JPanel();
        JLabel labelTitulo = new JLabel("EXPORTAR QUESTÕES");
        labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JLabel labelArquivo = new JLabel("Nome do arquivo");
        JLabel labelAssunto = new JLabel("Assunto");
        JLabel labelTipo = new JLabel("Tipo do conteudo");
        JComboBox<String> comboBoxOp = new JComboBox<>();

        comboBoxOp.addItem("");
        comboBoxOp.addItem("Questões com respostas");
        comboBoxOp.addItem("Questões sem respostas");

        comboBoxOp.setPreferredSize(new Dimension(150, 20));
        nomeDoArquivo.setPreferredSize(new Dimension(150, 20));
        comboBoxAssuntos.setPreferredSize(new Dimension(150, 20));

        labelArquivo.setPreferredSize(new Dimension(120, 20));
        labelAssunto.setPreferredSize(new Dimension(120, 20));
        labelTipo.setPreferredSize(new Dimension(120, 20));

        JButton menu = new JButton("MENU");
        menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        menu.addActionListener(acao);
        JButton btnGerarTxt = new JButton("GERAR");
        btnGerarTxt.setIcon(new ImageIcon(getClass().getResource("/Interface/txt.png")));
        btnGerarTxt.addActionListener((ActionEvent arg0) -> {
            try {
                if (comboBoxAssuntos.getSelectedIndex() != 0 && comboBoxOp.getSelectedIndex() != 0 && !nomeDoArquivo.getText().equals("")) {
                    JFileChooser o = new JFileChooser();
                    o.setMultiSelectionEnabled(false);
                    o.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    if (o.showSaveDialog(GerarTxtGUI.this) == 0) {
                        if (o.getSelectedFile().isDirectory()) {
                            boolean existe = false;
                            for (String file : o.getSelectedFile().list()) {
                                if (file.endsWith(".txt")) {
                                    if (file.equals(nomeDoArquivo.getText() + ".txt")) {
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
                            prova.geraTXT((Assunto) comboBoxAssuntos.getSelectedItem(), comboBoxOp.getSelectedIndex() == 1, o.getSelectedFile().getAbsolutePath() + "\\" + nomeDoArquivo.getText() + ".txt");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(GerarTxtGUI.this, "Digite TODOS os dados corretamente",null,JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(GerarTxtGUI.this, "Erro ao grava o arquivo","Erro",JOptionPane.ERROR_MESSAGE);
            }
        });

        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(labelTitulo))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(comboBoxAssuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(comboBoxOp, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(nomeDoArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(20)
                        .addComponent(btnGerarTxt))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelTitulo)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(labelTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(labelArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(comboBoxAssuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(comboBoxOp, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(nomeDoArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                )
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(btnGerarTxt))
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
        comboBoxAssuntos.addItem(new Assunto(""));
        if (!assuntos.isEmpty()) {
            for (int i = 0; i < assuntos.size(); i++) {
                if (assuntos.get(i).getQuantidade() > 0) {
                    comboBoxAssuntos.addItem(assuntos.get(i));
                }
            }
        }
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        nomeDoArquivo.setText("");
        comboBoxAssuntos.removeAllItems();
    }
}
