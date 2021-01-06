
package Interface;
import Logica.PersistenciaDados;
import Logica.Prova;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;

public class TelaPrincipal extends JFrame implements WindowListener {
    private final Prova prova;

    public TelaPrincipal() {
        CardLayout layout = new CardLayout();
        JPanel painelPrincipal = new JPanel();
        JMenuBar menuBar;
        JMenu questao, assunto, gerarDoc, opcoes, enviarEmail;
        JMenuItem listarQuestoes, cadastrarQuestoes, listarAssunto,
                cadastrarAssunto, gerarProvaPdf, gerarTXT,
                sobre, salvar, gerarPlanilha, enviarEmailItem;

        this.addWindowListener(this);
        this.prova = PersistenciaDados.pegaDados();

        painelPrincipal.setLayout(layout);
        JScrollPane scroll=new JScrollPane(painelPrincipal);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
        //Inicializa a opcoes da barra de menu e algumas configuracoes 
        menuBar = new JMenuBar();
        questao = new JMenu("Questão");
        assunto = new JMenu("Assunto");
        gerarDoc = new JMenu("Gerar Documento");
        opcoes = new JMenu("Opções");
        enviarEmail = new JMenu("Enviar E-mail");

        menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //inicializa a opcoes de cada opcao contida bo menu bar principal 
        questao.add(cadastrarQuestoes = new JMenuItem("Cadastrar Questão"));
        questao.add(listarQuestoes = new JMenuItem("Listar Questão"));

        assunto.add(cadastrarAssunto = new JMenuItem("Cadastrar Assunto"));
        assunto.add(listarAssunto = new JMenuItem("Listar Assunto"));

        gerarDoc.add(gerarPlanilha = new JMenuItem("Gerar planilha (.csv)"));
        gerarDoc.add(gerarProvaPdf = new JMenuItem("Gerar prova (.pdf)"));
        gerarDoc.add(gerarTXT = new JMenuItem("Exportar questoes (.txt)"));

        enviarEmail.add(enviarEmailItem = new JMenuItem("Enviar Prova"));

        opcoes.add(salvar = new JMenuItem("Salvar"));
        opcoes.add(sobre = new JMenuItem("Sobre"));
        //Adiciona as opcoes do menu á barra de menu 
        menuBar.setBackground(Color.white);
        menuBar.add(questao);
        menuBar.add(assunto);
        menuBar.add(gerarDoc);
        menuBar.add(enviarEmail);
        menuBar.add(opcoes);

        //CONFIGURA CADA MENU
        questao.setFont(new Font("Arial", Font.PLAIN, 12));
        assunto.setFont(new Font("Arial", Font.PLAIN, 12));
        gerarDoc.setFont(new Font("Arial", Font.PLAIN, 12));
        opcoes.setFont(new Font("Arial", Font.PLAIN, 12));
        enviarEmail.setFont(new Font("Arial", Font.PLAIN, 12));

        //CONFIGURA CADA MENUITEM DE QUESTAO
        listarQuestoes.setIcon(new ImageIcon(getClass().getResource("/Interface/listar.png")));
        listarQuestoes.setFont(new Font("Arial", Font.PLAIN, 12));
        cadastrarQuestoes.setIcon(new ImageIcon(getClass().getResource("/Interface/cadastrar.png")));
        cadastrarQuestoes.setFont(new Font("Arial", Font.PLAIN, 12));

        //CONFIGURA CADA MENUITEM DE ASSUNTO
        listarAssunto.setIcon(new ImageIcon(getClass().getResource("/Interface/listar.png")));
        listarAssunto.setFont(new Font("Arial", Font.PLAIN, 12));
        cadastrarAssunto.setIcon(new ImageIcon(getClass().getResource("/Interface/cadastrar.png")));
        cadastrarAssunto.setFont(new Font("Arial", Font.PLAIN, 12));

        //CONFIGURA CADA MENUITEM DE GERAR DOCUMENTO
        gerarProvaPdf.setIcon(new ImageIcon(getClass().getResource("/Interface/pdf.png")));
        gerarProvaPdf.setFont(new Font("Arial", Font.PLAIN, 12));
        gerarTXT.setIcon(new ImageIcon(getClass().getResource("/Interface/txt.png")));
        gerarTXT.setFont(new Font("Arial", Font.PLAIN, 12));
        gerarPlanilha.setIcon(new ImageIcon(getClass().getResource("/Interface/planilha.png")));
        gerarPlanilha.setFont(new Font("Arial", Font.PLAIN, 12));
        
        //CONFIGURA CADA MENUITEM DE GERAR DOCUMENTO
        enviarEmailItem.setFont(new Font("Arial", Font.PLAIN, 12));
        enviarEmailItem.setIcon(new ImageIcon(getClass().getResource("/Interface/email.png")));
        
        //CONFIGURA CADA MENUITEM DE CONFIGURAÇÕES
        sobre.setFont(new Font("Arial", Font.PLAIN, 12));
        sobre.setIcon(new ImageIcon(getClass().getResource("/Interface/detalhes.png")));
        salvar.setFont(new Font("Arial", Font.PLAIN, 12));
        salvar.setIcon(new ImageIcon(getClass().getResource("/Interface/salvar.png")));

        //AÇÃO DE VOLTAR A TELA PRINCIPAL
        ActionListener acao = (ActionEvent ae) -> {
            layout.first(painelPrincipal);
        };

        painelPrincipal.add(new JPanel(), "TelaPrincipal");
        painelPrincipal.add(new CadastroAssunto(prova, acao), "CadastroAssunto");
        painelPrincipal.add(new CadastroQuestao(prova, acao), "CadastroQuestao");
        painelPrincipal.add(new ListaAssunto(prova, acao), "ListaAssunto");
        painelPrincipal.add(new ListarQuestoes(prova, acao), "ListarQuestoes");
        painelPrincipal.add(new GerarProvaGUI(prova, acao), "GerarProva");
        painelPrincipal.add(new GerarTxtGUI(prova, acao), "GerarTXT");
        painelPrincipal.add(new GerarPlanilhaGUI(prova, acao), "GerarPlanilha");
        painelPrincipal.add(new EnviarEmailGUI(acao), "Email");
        painelPrincipal.add(new Detalhes(acao),"info");

        layout.show(painelPrincipal, "TelaPrincipal");

        //AÇÕES DE CADA MENU ITEM
        cadastrarQuestoes.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "CadastroQuestao");
        });
        listarAssunto.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "ListaAssunto");
        });
        cadastrarAssunto.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "CadastroAssunto");
        });
        listarQuestoes.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "ListarQuestoes");
        });
        gerarTXT.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "GerarTXT");
        });
        gerarProvaPdf.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "GerarProva");
        });
        enviarEmailItem.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "Email");
        });
        gerarPlanilha.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "GerarPlanilha");
        });
        salvar.addActionListener((ActionEvent ae) -> {
            try {
                PersistenciaDados.guardaDados(prova);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        sobre.addActionListener((ActionEvent ae) -> {
            layout.show(painelPrincipal, "info");
        });

        //CONFIGURAÇÕES DO JFRAME
        this.setTitle("Gerenciador Questionario");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Interface/icone.png")));
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    public static void main(String[] argv) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
    }
    @Override
    public void windowOpened(WindowEvent we) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        try {
            PersistenciaDados.guardaDados(this.prova);
        } catch (IOException e) {
        }
    }

    @Override
    public void windowClosed(WindowEvent we) {
    }

    @Override
    public void windowIconified(WindowEvent we) {
    }

    @Override
    public void windowDeiconified(WindowEvent we) {
    }

    @Override
    public void windowActivated(WindowEvent we) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent we) {
    }
}
