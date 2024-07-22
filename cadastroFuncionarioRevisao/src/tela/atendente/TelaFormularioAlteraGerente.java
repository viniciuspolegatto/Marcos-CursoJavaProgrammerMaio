package tela.atendente;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.atendente.TelaFormularioAlteraGerenteControlador;
import entidade.Atendente;

public class TelaFormularioAlteraGerente {
	
	
	public void chamarTelaCadastroAtendente(Atendente atendente) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Atendente";
		String terceiroCampo = "Digite  setor do Atendente";

		JFrame frameTelaCadastroAtendente = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroAtendente.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroAtendente = new JPanel();// Cria o objeto painel
		
		JLabel labelCpf = new JLabel("CPF:" + atendente.getCpf());
		panelTelaCadastroAtendente.add(labelCpf);
		
		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroAtendente.add(labelPrimeiroCampo);

		panelTelaCadastroAtendente.setLayout(grid);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(atendente.getNome());
		panelTelaCadastroAtendente.add(caixaTextoPrimeiroCampo);

	
		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroAtendente.add(labelTerceiroCampo);

		JTextField caixaTextoTerceiroCampo = new JTextField(10);
		caixaTextoTerceiroCampo.setText(atendente.getSetor());
		panelTelaCadastroAtendente.add(caixaTextoTerceiroCampo);

		JButton botaoAlterar = new JButton("Alterar Atendente");
		panelTelaCadastroAtendente.add(botaoAlterar);

		frameTelaCadastroAtendente.add(panelTelaCadastroAtendente);
		frameTelaCadastroAtendente.setVisible(true);
		
		TelaFormularioAlteraGerenteControlador alteraGerenteControlador = new TelaFormularioAlteraGerenteControlador(frameTelaCadastroAtendente, caixaTextoPrimeiroCampo, caixaTextoTerceiroCampo, atendente.getCpf());
		botaoAlterar.addActionListener(alteraGerenteControlador);
		

	}
}
