package tela;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.TelaFormularioAlterarCobraController;
import entidade.Cobra;

public class TelaFormularioAlterarCobra {

	public void chamarTelaCadastroCobra(Cobra cobra) {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome da Cobra";
		String terceiroCampo = "Digite a espécie da Cobra";

		JFrame frameTelaCadastroCobra = new JFrame(); // Instanciando um JFrame Vazio

		frameTelaCadastroCobra.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroCobra = new JPanel(); // Cria o objeto painel
		
		JLabel labelSegundoCampo = new JLabel("CAF: " + cobra.getCaf()); // AQUI A GENTE APRESENTA O CAF DA COBRA SEM A OPÇÃO DE ALTERAR
		panelTelaCadastroCobra.add(labelSegundoCampo);

		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroCobra.add(labelPrimeiroCampo);

		panelTelaCadastroCobra.setLayout(grid);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		caixaTextoPrimeiroCampo.setText(cobra.getNome()); // AQUI A GENTE COLOCA O NOME DA COBRA QUE VAI SER ALTERADO
		panelTelaCadastroCobra.add(caixaTextoPrimeiroCampo);

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroCobra.add(labelTerceiroCampo);

		JTextField caixaTextoTerceiroCampo = new JTextField(10);
		caixaTextoTerceiroCampo.setText(cobra.getEspecie()); // AQUI A GENTE COLOCA A ESPÉCIE DA COBRA QUE VAI SER ALTERADA
		panelTelaCadastroCobra.add(caixaTextoTerceiroCampo);

		JButton botaoCadastrar = new JButton("Alterar Cobra");
		panelTelaCadastroCobra.add(botaoCadastrar);

		frameTelaCadastroCobra.add(panelTelaCadastroCobra);
		frameTelaCadastroCobra.setVisible(true);
		
		TelaFormularioAlterarCobraController alterarCobraController = new TelaFormularioAlterarCobraController(caixaTextoPrimeiroCampo, cobra.getCaf(), caixaTextoTerceiroCampo, frameTelaCadastroCobra);
		botaoCadastrar.addActionListener(alterarCobraController);
	}
}
