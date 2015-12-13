package br.ufc.banco.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ufc.banco.bb.BancoBrasil;

public class MenuFrame extends JFrame {

	JTextField numContaField;
	BancoBrasil banco;
	
	public MenuFrame(BancoBrasil banco) {
		super("Banco do Brasil");
		
		this.banco = banco;
		
		criarMenu();
		login();
	}

	private void criarMenu() {
		
		// Menu Contas
		
		JMenu menuContas = new JMenu("Contas");
		
		NovoCadastroAction novoCadastroAction = new NovoCadastroAction();
		SairAction sairAction = new SairAction();
		
		JMenuItem menuItemCadastrar = new JMenuItem("Cadastrar Nova Conta");
		menuItemCadastrar.addActionListener(novoCadastroAction);
		menuContas.add(menuItemCadastrar);
		
		JMenuItem menuItemSair = new JMenuItem("Sair");
		menuItemSair.addActionListener(sairAction);
		menuContas.add(menuItemSair);
		
		// Menu Ajuda
		
		JMenu menuAjuda = new JMenu("Ajuda");
		
		SobreAction sobreAction = new SobreAction();
		
		JMenuItem menuItemSobre = new JMenuItem("Sobre");
		menuItemSobre.addActionListener(sobreAction);
		menuAjuda.add(menuItemSobre);
		
		// Barra
		
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.add(menuContas);
		barra.add(menuAjuda);
		
	}
	
	
	private void login() {
		
		EntrarAction entrarAction = new EntrarAction();
		SairAction sairAction = new SairAction();
		
		setLayout(new BorderLayout());
		
		// Título
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.PAGE_AXIS));
		
		JLabel titulo1 = new JLabel("Bem Vindo ao Banco do Brasil");
		titulo1.setFont(new Font("Verdana", Font.PLAIN, 16));
		titulo1.setAlignmentX(CENTER_ALIGNMENT);
		JLabel titulo2 = new JLabel("Terminal de Auto-Atendimento");
		titulo2.setFont(new Font("Verdana", Font.PLAIN, 14));
		titulo2.setAlignmentX(CENTER_ALIGNMENT);
		
		panelTitulo.add(titulo1);
		panelTitulo.add(titulo2);
		
		// Formulário de Cadastro
		
		JPanel panelNumConta = new JPanel();
		panelNumConta.setLayout(new FlowLayout());
		
		JLabel numContaLabel = new JLabel("Número da Conta");
		numContaField = new JTextField(30);
		
		panelNumConta.add(numContaLabel);
		panelNumConta.add(numContaField);
		
		// Botões
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		JButton botaoEntrar = new JButton("Entrar");
		JButton botaoSair = new JButton("Sair");
		
		botaoEntrar.addActionListener(entrarAction);
		botaoSair.addActionListener(sairAction);
		
		panelBotoes.add(botaoEntrar);
		panelBotoes.add(botaoSair);
		
		// Posicionamento
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelNumConta, BorderLayout.CENTER);
		add(panelBotoes, BorderLayout.SOUTH);
	}
	
	private class NovoCadastroAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			NovoCadastroFrame novoCadastroFrame = new NovoCadastroFrame(banco);
			novoCadastroFrame.setSize(800,200);
			novoCadastroFrame.setVisible(true);
		}
		
	}
	
	private class SairAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
	
	private class EntrarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Login feito com sucesso.", "Login", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
	private class SobreAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "O Sistema Bancário é um sistema Java simples, de caráter acadêmico, utilizado na disciplina de Técnicas de Programação II da Universidade Federal do Ceará.\n\nFeito por Lincoln Rocha e Ismália Santiago.", "Sobre", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
