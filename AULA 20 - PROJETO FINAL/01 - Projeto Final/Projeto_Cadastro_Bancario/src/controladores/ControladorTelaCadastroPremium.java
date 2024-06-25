package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import telasClienteGeral.TelaMenuClienteGeral;
import telasClientePremium.TelaMenuClientePremium;

public class ControladorTelaCadastroPremium implements ActionListener { {
	
	//ESSES SÃO OS ATRIBUTOS DA CLASSE, SERVEM PARA ...
	JTextField opcaoTexto;
	JTextField opcaoTexto3;
	JTextField opcaoTexto4;
	JTextField opcaoTexto5;
	JTextField opcaoTexto6;
	JTextField opcaoTexto7;
	JFrame frameTelaInicial;
	JButton botaoVoltarMenuPremium;
	JButton botaCadastrarPremium;
	
	
	//ESTANCIANDO OS ELEMENTOS - ESSA AÇÃO VAI TRAZER AS REFERÊNCIAS ONDE SERÃO OS DIRECIONAMENTOS
	// PARA OS PRÓXIMOS PASSOS
			//TelaMenuClientePremium telaMenuClientePremium = new TelaMenuClientePremium();

	
	
	//CHAMANDO UM MÉTODO PARA TRABALHAR NA CLASSE CONTROLADOR DO MENU INICIAL
	public ControladorTelaCadastroPremium (JTextField opcaoTexto, JTextField opcaoTexto3, JTextField opcaoTexto4, JTextField opcaoTexto5, JTextField opcaoTexto6, JTextField opcaoTexto7, JFrame frameTelaInicial) {
		this.opcaoTexto = opcaoTexto;
		this.opcaoTexto3 = opcaoTexto3;
		this.opcaoTexto4 = opcaoTexto4;
		this.opcaoTexto5 = opcaoTexto5;
		this.opcaoTexto6 = opcaoTexto6;
		this.opcaoTexto7 = opcaoTexto7;
		this.frameTelaInicial = frameTelaInicial;
	}
	
	
	//AÇÃO DE POLIMORFISMO DEVIDO AO USAR IMPLEMENTS NA DEFINIÇÃO DA CLASSE
	  @Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();
	        if ("CADASTRAR_PREMIUM".equals(command)) {
	            telaCadastroPremium.chamarTelaMenuClientePremium();
	            System.out.println("Direcione para tela do cliente premium");
	            frameTelaInicial.setVisible(false);
	        } else if ("VOLTAR_MENU_PREMIUM".equals(command)) {
	            telaCadastroPremium.chamarTelaMenuClienteGeral();
	            System.out.println("Direcione para tela do cliente standard");
	            frameTelaInicial.setVisible(false);
	        } else if ("ENTER".equals(command)) {
	            caixaDeTexto();   
	        } else {
	            caixaDeTexto();
	        }
	  }
}