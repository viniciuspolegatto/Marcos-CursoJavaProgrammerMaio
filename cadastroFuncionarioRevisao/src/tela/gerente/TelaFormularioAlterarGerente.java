package tela.gerente;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.gerente.TelaFormularioAlterarGerenteControlador;
import entidade.Gerente;

public class TelaFormularioAlterarGerente {

	public void chamarTelaCadastroGerente(Gerente gerente) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Gerente";
		String terceiroCampo = "Digite a gerencia do Gerente";

		JFrame frameTelaCadastroGerente = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroGerente.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroGerente = new JPanel();// Cria o objeto painel
		
		JLabel labelSegundoCampo = new JLabel("CPF: " + gerente.getCpf() ); // AQUI A GENTE APRESENTA O CPF DO GERENTE SEM A OPÇÃO DE ALTERAR
		panelTelaCadastroGerente.add(labelSegundoCampo);

	
		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroGerente.add(labelPrimeiroCampo);

		panelTelaCadastroGerente.setLayout(grid);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(gerente.getNome());//AQUI A GENTE COLOCA O NOME DO GERENTE QUE VAI SER ALTERADO
		panelTelaCadastroGerente.add(caixaTextoPrimeiroCampo);

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroGerente.add(labelTerceiroCampo);

		JTextField caixaTextoTerceiroCampo = new JTextField(10);
		caixaTextoTerceiroCampo.setText(gerente.getGerencia());// AQUI A GENTE COLOCAR A GERENCIA DO GERENTE QUE VAI SER ALTERADO
		panelTelaCadastroGerente.add(caixaTextoTerceiroCampo);

		JButton botaoCadastrar = new JButton("Alterar Gerente");
		panelTelaCadastroGerente.add(botaoCadastrar);

		frameTelaCadastroGerente.add(panelTelaCadastroGerente);
		frameTelaCadastroGerente.setVisible(true);
		
		TelaFormularioAlterarGerenteControlador alterarGerenteControlador = new TelaFormularioAlterarGerenteControlador(caixaTextoPrimeiroCampo, gerente.getCpf(), caixaTextoTerceiroCampo, frameTelaCadastroGerente);
		botaoCadastrar.addActionListener(alterarGerenteControlador);
		
		

	
	}
}
