package br.ufc.banco.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		cadastrarConta();
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
		
		JMenuItem menuItemSobre = new JMenuItem("Sobre");
		menuAjuda.add(menuItemSobre);
		
		// Barra
		
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.add(menuContas);
		barra.add(menuAjuda);
		
	}
	
	
	private void cadastrarConta() {
		
		SairAction fecharAction = new SairAction();
		CadastrarAction cadastrarAction = new CadastrarAction();
		
		setLayout(new BorderLayout());
		
		// Título
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Cadastrar Conta");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelTitulo.add(titulo);
		
		// Formulário de Cadastro
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(new FlowLayout());
		
		JLabel numContaLabel = new JLabel("Número da Conta");
		numContaField = new JTextField(40);
		
		panelCadastro.add(numContaLabel);
		panelCadastro.add(numContaField);
		
		// Botões
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		JButton botaoFechar = new JButton("Fechar");
		
		botaoCadastrar.addActionListener(cadastrarAction);
		botaoFechar.addActionListener(fecharAction);
		
		panelBotoes.add(botaoCadastrar);
		panelBotoes.add(botaoFechar);
		
		// Posicionamento
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelCadastro, BorderLayout.CENTER);
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
	
	private class CadastrarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "O cadastro foi salvo!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
}
