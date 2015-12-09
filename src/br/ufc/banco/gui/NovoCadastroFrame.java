package br.ufc.banco.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.ufc.banco.bb.BancoBrasil;
import br.ufc.banco.conta.Conta;
import br.ufc.banco.conta.ContaAbstrata;
import br.ufc.banco.conta.ContaEspecial;
import br.ufc.banco.conta.ContaImposto;
import br.ufc.banco.conta.ContaPoupanca;
import br.ufc.banco.dados.excecoes.CEException;

public class NovoCadastroFrame extends JFrame {
	
	BancoBrasil banco;
	JTextField numContaField;
	ButtonGroup buttonGroup;

	public NovoCadastroFrame(BancoBrasil banco) {
		super("Cadastrar Nova Conta");
		
		this.banco = banco;
		
		cadastrarConta();
	}

	private void cadastrarConta() {
		
		setLayout(new BorderLayout());
		
		// Título
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new FlowLayout());
		
		JLabel titulo = new JLabel("Cadastrar Conta");
		titulo.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelTitulo.add(titulo);
		
		// Tipo de Conta
		
		JPanel panelTipo = new JPanel();
		panelTipo.setLayout(new FlowLayout());
		
		JLabel tipoLabel = new JLabel("Tipo");
		tipoLabel.setFont(new Font("Verdana", Font.PLAIN, 14));

		JRadioButton comumButton = new JRadioButton("Comum");
		comumButton.setMnemonic(KeyEvent.VK_C);
		comumButton.setActionCommand("Comum");

		JRadioButton especialButton = new JRadioButton("Especial");
		especialButton.setMnemonic(KeyEvent.VK_E);
		especialButton.setActionCommand("Especial");

		JRadioButton poupancaButton = new JRadioButton("Poupança");
		poupancaButton.setMnemonic(KeyEvent.VK_P);
		poupancaButton.setActionCommand("Poupança");

		JRadioButton impostoButton = new JRadioButton("Imposto");
		impostoButton.setMnemonic(KeyEvent.VK_I);
		impostoButton.setActionCommand("Imposto");
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(comumButton);
		buttonGroup.add(especialButton);
		buttonGroup.add(poupancaButton);
		buttonGroup.add(impostoButton);
		
		
		panelTipo.add(tipoLabel);
		panelTipo.add(comumButton);
		panelTipo.add(especialButton);
		panelTipo.add(poupancaButton);
		panelTipo.add(impostoButton);	
		
		
		// Número da Conta
		
		JPanel panelNumero = new JPanel();
		panelNumero.setLayout(new FlowLayout());
		
		JLabel numContaLabel = new JLabel("Número da Conta");
		numContaLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		
		numContaField = new JTextField(20);
		
			
		panelNumero.add(numContaLabel);
		panelNumero.add(numContaField);
		
		
		// Botões
		
		OkAction okAction = new OkAction();
		CancelarAction cancelarAction = new CancelarAction();
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setLayout(new FlowLayout());
		
		JButton botaoOK = new JButton("OK");
		JButton botaoCancelar = new JButton("Cancelar");
		
		botaoOK.addActionListener(okAction);
		botaoCancelar.addActionListener(cancelarAction);
		
		
		panelBotoes.add(botaoOK);
		panelBotoes.add(botaoCancelar);
		
		
		// Posicionamento
		
		add(panelTitulo, BorderLayout.NORTH);
		add(panelTipo, BorderLayout.WEST);
		add(panelNumero, BorderLayout.EAST);
		add(panelBotoes, BorderLayout.SOUTH);
		
	}
	
	private class OkAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if ((buttonGroup.getSelection() != null) && (!numContaField.getText().equals(""))) {			
				switch (buttonGroup.getSelection().getMnemonic()) {				
					case (KeyEvent.VK_C):
					{
						ContaAbstrata conta = new Conta(numContaField.getText());
					
						try {
							banco.cadastrar(conta);
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Comum " + conta.obterNumero() + " foi salvo.", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						} catch (CEException e) {
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Comum " + conta.obterNumero() + " não foi concluído. Motivo: " + e.getMessage(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
						}
					}
					break;
						
					case (KeyEvent.VK_E):
					{
						ContaAbstrata conta = new ContaEspecial(numContaField.getText());
					
						try {
							banco.cadastrar(conta);
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Especial " + conta.obterNumero() + " foi salvo.", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						} catch (CEException e) {
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Especial " + conta.obterNumero() + " não foi concluído. Motivo: " + e.getMessage(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
						}
					}
					break;
					
					case (KeyEvent.VK_P):
					{
						ContaAbstrata conta = new ContaPoupanca(numContaField.getText());
					
						try {
							banco.cadastrar(conta);
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Poupança " + conta.obterNumero() + " foi salvo.", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						} catch (CEException e) {
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Poupança " + conta.obterNumero() + " não foi concluído. Motivo: " + e.getMessage(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
						}
					}
					break;
					
					case (KeyEvent.VK_I):
					{
						ContaAbstrata conta = new ContaImposto(numContaField.getText());
					
						try {
							banco.cadastrar(conta);
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Imposto " + conta.obterNumero() + " foi salvo.", "Cadastro", JOptionPane.PLAIN_MESSAGE);
						} catch (CEException e) {
							JOptionPane.showMessageDialog(null, "O cadastro da Conta Imposto " + conta.obterNumero() + " não foi concluído. Motivo: " + e.getMessage(), "Cadastro", JOptionPane.PLAIN_MESSAGE);
						}
					}
					break;
				
				}			
			}
			else {	
				JOptionPane.showMessageDialog(null, "Erro: um ou mais campos não estão preenchidos.", "Cadastro", JOptionPane.PLAIN_MESSAGE);			
			}
			
		}
		
	}
	
	private class CancelarAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
		
	}

}