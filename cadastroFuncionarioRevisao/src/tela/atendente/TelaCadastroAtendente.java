package tela.atendente;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.atendente.TelaCadastroAtendenteControlador;
import enuns.SetorEnum;

public class TelaCadastroAtendente {

	public void chamarTelaCadastroAtendente() {

		GridLayout grid = new GridLayout(0, 1);
		String primeiroCampo = "Digite o nome do Atendente";
		String segundoCampo = "Digite o cpf do Atendente";
		String terceiroCampo = "Digite  setor do Atendente";
		String quartoCampo = "Digite a Quantidade de horas";
		String  cepLabel = "Digite o CEP";
		
		JFrame frameTelaCadastroAtendente = new JFrame();// Instanciando um JFrame Vazio

		frameTelaCadastroAtendente.setSize(200, 250); // Altura e largura
		JPanel panelTelaCadastroAtendente = new JPanel();// Cria o objeto painel

		
		JLabel labelSegundoCampo = new JLabel(segundoCampo);
		panelTelaCadastroAtendente.add(labelSegundoCampo);

		JTextField caixaTextoSegundoCampo = new JTextField(10);
		panelTelaCadastroAtendente.add(caixaTextoSegundoCampo);
		
		JLabel labelPrimeiroCampo = new JLabel(primeiroCampo);
		panelTelaCadastroAtendente.add(labelPrimeiroCampo);

		panelTelaCadastroAtendente.setLayout(grid);

		JTextField caixaTextoPrimeiroCampo = new JTextField(10);
		panelTelaCadastroAtendente.add(caixaTextoPrimeiroCampo);

		

		JLabel labelTerceiroCampo = new JLabel(terceiroCampo);
		panelTelaCadastroAtendente.add(labelTerceiroCampo);

		//JTextField caixaTextoTerceiroCampo = new JTextField(10);
		//panelTelaCadastroAtendente.add(caixaTextoTerceiroCampo);
		// Agora Vai ser uma caixa de seleção
		JComboBox<SetorEnum> caixaSelecaoSetor = new JComboBox<>(SetorEnum.values());
		panelTelaCadastroAtendente.add(caixaSelecaoSetor);
		
		
		JLabel labelQuartoCampo = new JLabel(quartoCampo);
		panelTelaCadastroAtendente.add(labelQuartoCampo);

		JTextField caixaTextolabelQuartoCampo = new JTextField(10);
		panelTelaCadastroAtendente.add(caixaTextolabelQuartoCampo);
		
		JLabel jlabelCepLabel = new JLabel(cepLabel);
		panelTelaCadastroAtendente.add(jlabelCepLabel);

		JTextField caixaTextoCep = new JTextField(10);
		panelTelaCadastroAtendente.add(caixaTextoCep);

		JButton botaoCadastrar = new JButton("Cadastrar Atendente");
		panelTelaCadastroAtendente.add(botaoCadastrar);

		frameTelaCadastroAtendente.add(panelTelaCadastroAtendente);
		frameTelaCadastroAtendente.setVisible(true);

		TelaCadastroAtendenteControlador atendenteControlador = new TelaCadastroAtendenteControlador(
				caixaTextoPrimeiroCampo, caixaTextoSegundoCampo, caixaSelecaoSetor, frameTelaCadastroAtendente, caixaTextolabelQuartoCampo, caixaTextoCep );
		botaoCadastrar.addActionListener(atendenteControlador);
	}
}
