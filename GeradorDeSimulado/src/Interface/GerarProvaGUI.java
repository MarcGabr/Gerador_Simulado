package Interface;

import Logica.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GerarProvaGUI extends JPanel {

    private final JTextField textNome1 = new JTextField();
    private final JTextField textDisciplina = new JTextField();
    private final JTextField textData = new JTextField();
    private final JTextField textValor = new JTextField();
    private final JTextField textNomeArquivo = new JTextField();
    private final JComboBox<Assunto> comboAssuntos = new JComboBox<>();
    private final JComboBox<Integer> comboQuantidade = new JComboBox<>();

    GerarProvaGUI(Prova prova, ActionListener acao) {

        JLabel labelTitulo = new JLabel();
        JPanel painel = new JPanel();
        JLabel labelNome = new JLabel();
        JLabel labelDisciplina = new JLabel();
        JLabel labelData = new JLabel();
        JLabel labelValor = new JLabel();
        JLabel labelAssunto = new JLabel();
        JLabel labelQuantidade = new JLabel();
        JLabel labelNomeArquivo = new JLabel();
        JButton buttonMenu = new JButton();
        JButton gerar = new JButton();

        labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        labelTitulo.setText("GERAR PDF");
        labelNome.setText("Nome do Professor");
        labelDisciplina.setText("Disciplina");
        labelData.setText("Data da Prova");
        labelValor.setText("Valor");
        labelAssunto.setText("Assunto");
        labelQuantidade.setText("Quantidade de questões");
        labelNomeArquivo.setText("Nome do arquivo");

        buttonMenu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        buttonMenu.setText("MENU");
        buttonMenu.addActionListener(acao);
        gerar.setIcon(new ImageIcon(getClass().getResource("/Interface/pdf.png")));
        gerar.setText("GERAR");

        labelTitulo.setPreferredSize(new Dimension(180, 40));
        labelNome.setPreferredSize(new Dimension(120, 20));
        labelDisciplina.setPreferredSize(new Dimension(120, 20));
        labelData.setPreferredSize(new Dimension(120, 20));
        labelValor.setPreferredSize(new Dimension(120, 20));
        labelAssunto.setPreferredSize(new Dimension(120, 20));
        labelQuantidade.setPreferredSize(new Dimension(140, 20));
        labelNomeArquivo.setPreferredSize(new Dimension(120, 20));

        buttonMenu.setPreferredSize(new Dimension(100, 30));
        gerar.setPreferredSize(new Dimension(110, 30));

        textNome1.setPreferredSize(new Dimension(250, 20));
        textDisciplina.setPreferredSize(new Dimension(250, 20));
        textData.setPreferredSize(new Dimension(250, 20));
        textValor.setPreferredSize(new Dimension(250, 20));
        comboAssuntos.setPreferredSize(new Dimension(250, 20));
        comboQuantidade.setPreferredSize(new Dimension(120, 20));
        textNomeArquivo.setPreferredSize(new Dimension(250, 20));
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(textNome1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(textDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelData, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelValor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(comboAssuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(comboQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNomeArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                        .addComponent(textNomeArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addComponent(buttonMenu)
                        .addGap(20)
                        .addComponent(gerar))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(10)
                .addComponent(labelTitulo)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelNome, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(labelDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(labelData, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(labelValor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(labelAssunto, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(40)
                                .addComponent(labelNomeArquivo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(textNome1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(textDisciplina, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(textValor, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addComponent(comboAssuntos, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(10)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(labelQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboQuantidade)
                                )
                                .addGap(10)
                                .addComponent(textNomeArquivo)
                        )
                )
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(buttonMenu)
                        .addComponent(gerar)
                )
                .addGap(10)
        );

        gerar.addActionListener((ActionEvent evt) -> {
            if (comboAssuntos.getSelectedIndex() != 0
                    && comboQuantidade.getSelectedIndex() != 0
                    && !labelNomeArquivo.getText().equals("")
                    && !textData.getText().equals("")
                    && !textDisciplina.getText().equals("")
                    && !textValor.getText().equals("")) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fileChooser.showSaveDialog(GerarProvaGUI.this) == 0) {
                    if (fileChooser.getSelectedFile().isDirectory()) {
                        boolean existe = false;
                        for (String file : fileChooser.getSelectedFile().list()) {
                            if (file.endsWith(".pdf")) {
                                if (file.equals(textNomeArquivo.getText() + ".pdf")) {
                                    existe = true;
                                    break;
                                }
                            }
                        }
                        if (existe) {
                            if (JOptionPane.showConfirmDialog(fileChooser, "Arquivo já existente deseja substitui-lo?", null, JOptionPane.YES_NO_OPTION) != 0) {
                                return;
                            }
                        }
                        try {
                            if (!prova.geraProvaDoc((Assunto) comboAssuntos.getSelectedItem(), (int) comboQuantidade.getSelectedIndex(), textData.getText(), fileChooser.getSelectedFile().getAbsolutePath() + "\\" + textNomeArquivo.getText(), textDisciplina.getText(), Float.valueOf(textValor.getText()) ,textNome1.getText())) {
                                JOptionPane.showMessageDialog(GerarProvaGUI.this, "Questoes distintas insuficiente", "Erro", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(GerarProvaGUI.this, "Digite somente numero no lugar do valor", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                        limpa();
                        comboAssuntos.setSelectedIndex(0);
                        comboQuantidade.setSelectedIndex(0);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(GerarProvaGUI.this, "Digite TODOS os dados corretamente", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });

        comboAssuntos.addItemListener((ItemEvent ie) -> {
            Assunto aux = (Assunto) ie.getItem();
            if (!aux.equals(new Assunto(""))) {
                int y1 = aux.getQuantidade();
                comboQuantidade.removeAllItems();
                for (int i = 0; i <= y1; i++) {
                    comboQuantidade.addItem(i);
                }
            }
        });

        this.add(painel, BorderLayout.CENTER);
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent ce) {
            }

            @Override
            public void componentMoved(ComponentEvent ce) {
            }

            @Override
            public void componentShown(ComponentEvent ce) {
                comboAssuntos.addItem(new Assunto(""));
                prova.getAssuntos().stream().filter((o) -> (o.getQuantidade() > 0)).forEachOrdered((o) -> {
                    comboAssuntos.addItem(o);
                });
                comboQuantidade.addItem(0);
            }

            @Override
            public void componentHidden(ComponentEvent ce) {
                comboQuantidade.removeAllItems();
                comboAssuntos.removeAllItems();
                limpa();
            }
        });
    }

    private void limpa() {
        textNome1.setText("");
        textDisciplina.setText("");
        textData.setText("");
        textValor.setText("");
        textNomeArquivo.setText("");
    }
}
