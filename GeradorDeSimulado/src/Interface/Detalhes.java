package Interface;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Detalhes extends JPanel {

	public Detalhes(ActionListener acao) {
		
		JLabel Nomeg = new JLabel("PRODUZIDO POR: GJJM");
		Nomeg.setBounds(193, 69, 257, 24);
		Nomeg.setForeground(new Color(255, 0, 0));
		Nomeg.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel label = new JLabel("");
		label.setBounds(31, 50, 152, 80);
		label.setIcon(new ImageIcon(getClass().getResource("/Interface/logo.png")));
		
		JTextArea textoEquipe = new JTextArea();
		textoEquipe.setBounds(31, 136, 407, 208);
		textoEquipe.setFont(new Font("Times New Roman", Font.BOLD, 13));
		textoEquipe.setBackground(this.getBackground());
		textoEquipe.setText("GERENTE PROJETO: GETULIO DOS SANTOS\r\n\r\n\r\n"
                        + "EQUIPE: JOAO VICTOR\r\n"
                        + "                JOAN JOAQUIM\r\n"
                        + "                MARCOS GABRIEL"
                        + "  \r\n\r\nPROFESSOR: WOSLEY ARRUDA\r\n\r\n\r\n\t\t"
                        + "14/06/2018 \r\n\t\t"
                        + "UFT-PALMAS\r\n");
		
		JLabel lblGeradorDeSimulado = new JLabel("GERADOR DE SIMULADO");
		lblGeradorDeSimulado.setBounds(117, 11, 257, 24);
		lblGeradorDeSimulado.setForeground(Color.RED);
		lblGeradorDeSimulado.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton menu = new JButton("MENU");
                menu.addActionListener(acao);
                menu.setIcon(new ImageIcon(getClass().getResource("/Interface/menu.png")));
		menu.setBounds(174, 349, 100, 23);
		setLayout(null);
		add(textoEquipe);
		add(label);
		add(Nomeg);
		add(lblGeradorDeSimulado);
		add(menu);
		
	}
}
