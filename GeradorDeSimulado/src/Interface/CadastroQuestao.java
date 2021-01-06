package Interface;

import Logica.Assunto;
import Logica.PersistenciaDados;
import Logica.Prova;
import Logica.Questao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class CadastroQuestao extends JPanel implements ComponentListener {

    private JComboBox<Assunto> boxAssunto;
    private final ArrayList<Assunto> assunto;
    private final JComboBox<Object> boxTipoQuestao;
    private final Prova prova;

    CadastroQuestao(Prova prova, ActionListener acao) {
        this.addComponentListener(this);
        JPanel painel = new JPanel();
        this.prova=prova;
        this.assunto = prova.getAssuntos();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);
        
        JLabel labelCadastro = new JLabel("CADASTRAR QUESTÃO");
        labelCadastro.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        JLabel labelTipo = new JLabel("TIPO DE QUESTÃO ;");
        JLabel labelAssunto = new JLabel("ASSUNTO :");
        JButton botaoOK = new JButton("OK");
        JButton menu = new JButton("MENU");
        menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
        botaoOK.setIcon(new ImageIcon(getClass().getResource("/Interface/ok.png")));
        
        boxAssunto = new JComboBox<>();
        boxAssunto.setPreferredSize(new Dimension(350,20));
        boxTipoQuestao = new JComboBox<>();

        atualizaAssuntoComboBox();
        boxTipoQuestao.addItem("");
        boxTipoQuestao.addItem("Questão Aberta");
        boxTipoQuestao.addItem("Questão Multipla Escolha com varias resposta");
        boxTipoQuestao.addItem("Questão Multipla Escolha com única resposta");
        boxTipoQuestao.addItem("Questão Verdadeiro ou Falso");

        menu.addActionListener(acao);
        botaoOK.addActionListener((ActionEvent ae) -> {
            if (boxAssunto.getSelectedIndex() != 0 && boxTipoQuestao.getSelectedIndex() != 0) {
                switch (boxTipoQuestao.getSelectedIndex()) {
                    case 1:
                        new QuestaoAbertaGUI(prova.getQuestoes(), acao, (Assunto) boxAssunto.getSelectedItem());
                        break;
                    case 2:
                        new QuestaoMultiplaEscolha(prova.getQuestoes(), acao, (Assunto) boxAssunto.getSelectedItem());
                        break;
                    case 3:
                        new QuestaoSemMultiplaGUI(prova.getQuestoes(), acao, (Assunto) boxAssunto.getSelectedItem());
                        break;
                    case 4:
                        new QuestaoVouFGUI(prova.getQuestoes(), acao, (Assunto) boxAssunto.getSelectedItem());
                        break;
                }
                try {
                    PersistenciaDados.guardaDados(prova);
                } catch (IOException ex) {}
                this.boxAssunto.setSelectedIndex(0);
                this.boxTipoQuestao.setSelectedIndex(0);
            }
        });
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(labelCadastro)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelAssunto)
                        .addGap(10)
                        .addComponent(boxAssunto,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE,GroupLayout.PREFERRED_SIZE)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addGap(10)
                        .addComponent(labelTipo)
                        .addGap(10)
                        .addComponent(boxTipoQuestao)
                        .addGap(10)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(20)
                        .addComponent(botaoOK)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(labelCadastro)
                .addGap(60)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelAssunto)
                        .addComponent(boxAssunto)
                )
                .addGap(20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(labelTipo)
                        .addComponent(boxTipoQuestao)
                )
                .addGap(100)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(menu)
                        .addComponent(botaoOK)
                )
        );
        this.add(painel,BorderLayout.CENTER);
    }

    /**
     * ADICIONA NO COMBO BOX SOMENTE OS ASSUNTOS CADASTRAVEIS, ISTO É, AQUELES
     * QUE NÃO ESTÃO EXCLUIDO.
     */
    private void atualizaAssuntoComboBox() {
        boxAssunto.removeAllItems();
        boxAssunto.addItem(new Assunto(""));
        assunto.forEach((Assunto temp) -> {
            if (temp.getAtivo()) {
                boxAssunto.addItem(temp);
            }
        });
    }

    @Override
    public void componentResized(ComponentEvent ce) {
    }

    @Override
    public void componentMoved(ComponentEvent ce) {
    }

    @Override
    public void componentShown(ComponentEvent ce) {
            atualizaAssuntoComboBox();
    }

    @Override
    public void componentHidden(ComponentEvent ce) {
        this.boxAssunto.setSelectedIndex(0);
        boxTipoQuestao.setSelectedIndex(0);
    }
}
