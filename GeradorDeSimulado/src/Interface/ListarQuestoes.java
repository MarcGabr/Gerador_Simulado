package Interface;

import Logica.Assunto;
import Logica.Prova;
import Logica.*;
import Logica.QuestaoAberta;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class ListarQuestoes extends JPanel implements ComponentListener, WindowFocusListener {

    private JTable tabela = new JTable();
    private final ModeloQuestao modelo;
    private final JComboBox comboOrdenacao;
    private final JButton excluir = new JButton("EXCLUIR");
    private final JButton editar = new JButton("EDITAR");
    private final JButton informacoes = new JButton("INFORMACÕES");

    ListarQuestoes(Prova prova, ActionListener acaoVoltarMenu) {
        JLabel labelTitulo = new JLabel("LISTA QUESTOES", JLabel.CENTER);
        labelTitulo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JButton menu = new JButton("MENU");
        menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        informacoes.setIcon(new ImageIcon(getClass().getResource("/Interface/detalhes.png")));
        excluir.setIcon(new ImageIcon(getClass().getResource("/Interface/excluir.png")));
        editar.setIcon(new ImageIcon(getClass().getResource("/Interface/editar.png")));
        //SETANDO MODELO DE TABELA 
        modelo = new ModeloQuestao(prova.getQuestoes());
        tabela.setModel(modelo);
        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.setDragEnabled(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.setRowHeight(40);
        JScrollPane b = new JScrollPane(tabela);
        b.setPreferredSize(new Dimension(580, 350));
        //ACOES DOS BOTOES
        excluir.addActionListener((ActionEvent ae) -> {
            if (tabela.getSelectedRow() != -1) {
                prova.getQuestoes().remove(modelo.getQuestaoSelected(tabela.getSelectedRow()));
                modelo.fireTableDataChanged();
                isEmpity();
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma Questão", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        editar.addActionListener((ActionEvent ae) -> {
            if (tabela.getSelectedRow() != -1) {
                if (modelo.getQuestaoSelected(tabela.getSelectedRow()) instanceof QuestaoAberta) {
                    new Editaraberta(modelo.getQuestao(), acaoVoltarMenu, modelo.getQuestaoSelected(tabela.getSelectedRow()).getAssunto(), tabela.getSelectedRow()).addWindowFocusListener(this);
                } else if (modelo.getQuestaoSelected(tabela.getSelectedRow()) instanceof QuestaoMultiplaEscolhaCom) {
                    new EditarMultiplaEscolha(modelo.getQuestao(), acaoVoltarMenu, modelo.getQuestaoSelected(tabela.getSelectedRow()).getAssunto(), tabela.getSelectedRow()).addWindowFocusListener(this);
                } else if (modelo.getQuestaoSelected(tabela.getSelectedRow()) instanceof QuestaoMultiplaEscolhaSem) {
                    new EditarSemMultiplaEscolha(modelo.getQuestao(), acaoVoltarMenu, modelo.getQuestaoSelected(tabela.getSelectedRow()).getAssunto(), tabela.getSelectedRow()).addWindowFocusListener(this);
                } else if (modelo.getQuestaoSelected(tabela.getSelectedRow()) instanceof QuestaoVouF) {
                    new EditorVouF(modelo.getQuestao(), acaoVoltarMenu, modelo.getQuestaoSelected(tabela.getSelectedRow()).getAssunto(), tabela.getSelectedRow()).addWindowFocusListener(this);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma Questão", null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        informacoes.addActionListener((ActionEvent ae) -> {
            if (tabela.getSelectedRow() >= 0) {
                JOptionPane.showMessageDialog(tabela, new DetalhesQuestao(modelo.getQuestaoSelected(tabela.getSelectedRow())), "Detalhes", JOptionPane.INFORMATION_MESSAGE, null);
            } else {
                JOptionPane.showMessageDialog(tabela, "Selecione uma Questão",null, JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.addActionListener(acaoVoltarMenu);
        //tipo de ordenacao
        comboOrdenacao = new JComboBox();
        comboOrdenacao.addItem("Todos");
        comboOrdenacao.addItem("Por pergunta");
        comboOrdenacao.addItem("Por Assunto");
        comboOrdenacao.setPreferredSize(new Dimension(100, 20));
        comboOrdenacao.addActionListener((ActionEvent ae) -> {
            switch ((String) comboOrdenacao.getSelectedItem()) {
                case "Todos":
                    modelo.setListQuestoes(prova.getQuestoes());
                    break;
                case "Por Assunto":
                    comboOrdenacao.setPopupVisible(false);
                    Assunto o = (Assunto) JOptionPane.showInputDialog(ListarQuestoes.this, "Selecione o assunto", "Listar por Assunto", JOptionPane.OK_CANCEL_OPTION, null, prova.getAssuntos().toArray(new Assunto[prova.getAssuntos().size()]), new Assunto(" "));
                    if (o != null) {
                        modelo.setListQuestoes(prova.getQuestoesAssunto(o));
                    }
                    break;
                case "Por pergunta":
                    comboOrdenacao.setPopupVisible(false);
                    String o1 = JOptionPane.showInputDialog(this, "Digite a pergunta");
                    if (o1 != null) {
                        if (!o1.equals("")) {
                            modelo.setListQuestoes(prova.getQuestoesPergunta(o1));
                        } else {
                            JOptionPane.showMessageDialog(ListarQuestoes.this, "Pergunta invalida", "Invalido", JOptionPane.WARNING_MESSAGE, null);
                            break;
                        }
                    }
                    if (tabela.getRowCount() == 0) {
                        JOptionPane.showMessageDialog(ListarQuestoes.this, "Pergunta não cadastradas");
                        break;
                    }
                    break;
            }
            isEmpity();
        });
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelTitulo)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10)
                                .addComponent(comboOrdenacao, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10)
                                .addComponent(b)
                                .addGap(10)
                        )
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(menu)
                        .addGap(10)
                        .addComponent(informacoes)
                        .addGap(10)
                        .addComponent(excluir)
                        .addGap(10)
                        .addComponent(editar)
                        .addGap(10)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGap(10)
                .addComponent(labelTitulo)
                .addGap(10)
                .addComponent(comboOrdenacao, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(b)
                .addGap(10)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(informacoes)
                        .addComponent(excluir)
                        .addComponent(editar)
                )
                .addGap(10)
        );
        tabela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (!modelo.getQuestaoSelected(tabela.getSelectedRow()).getAssunto().getAtivo()) {
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
        this.addComponentListener(this);
    }

    private void isEmpity() {
        if (modelo.getQuestao().size() == 0) {
            informacoes.setEnabled(false);
            editar.setEnabled(false);
            excluir.setEnabled(false);
        } else {
            informacoes.setEnabled(true);
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
        comboOrdenacao.setSelectedIndex(0);
    }

    @Override
    public void windowGainedFocus(WindowEvent we) {
    }

    @Override
    public void windowLostFocus(WindowEvent we) {
        modelo.fireTableDataChanged();
    }
}
