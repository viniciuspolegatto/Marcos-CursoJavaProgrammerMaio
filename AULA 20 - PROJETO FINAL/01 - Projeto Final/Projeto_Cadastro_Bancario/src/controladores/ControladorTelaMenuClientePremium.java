package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import telasClienteGeral.TelaMenuClienteGeral;
import telasClientePremium.TelaCadastroPremium;
import telasClientePremium.TelaDeletePremium;
import telasClientePremium.TelaMenuClientePremium;


public class ControladorTelaMenuClientePremium implements ActionListener {
		
	//ESSES SÃO OS ATRIBUTOS DA CLASSE ANTERIOR, SERVEM PARA LIGAR O CONTROLADOR COM AS ESTÂNCIAS DA TELA 
	JFrame frameTelaMenuClientePremium;
	JButton botaoCadastrarPremium;
	JButton botaoListarPremium;
	JButton botaoEditarPremium;
	JButton botaoDeletarPremium;
	
	
	//ESTANCIANDO OS ELEMENTOS - ESSA AÇÃO VAI TRAZER AS REFERÊNCIAS ONDE SERÃO OS DIRECIONAMENTOS
	// PARA OS PRÓXIMOS PASSOS
	TelaCadastroPremium telaCadastroPremium = new TelaCadastroPremium();
	TelaDeletePremium telaDeletePremium = new TelaDeletePremium();
	
	
	//CHAMANDO UM MÉTODO PARA TRABALHAR NA CLASSE CONTROLADOR DO MENU INICIAL
	public ControladorTelaMenuClientePremium (JFrame frameTelaMenuClientePremium) {
		this.frameTelaMenuClientePremium = frameTelaMenuClientePremium;
	}
	
	//AÇÃO DE POLIMORFISMO DEVIDO AO USAR IMPLEMENTS NA DEFINIÇÃO DA CLASSE
	  @Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();
	        if ("CADASTRAR_PREMIUM".equals(command)) {
	            telaCadastroPremium.chamarTelaCadastroPremium();
	            System.out.println("Direcione para tela do Cadastro Premium");
	            frameTelaMenuClientePremium.setVisible(false);
	        } else if ("DELETAR_PREMIUM".equals(command)) {
	            telaDeletePremium.chamarTelaDeletePremium();
	            System.out.println("Direcione para tela Deletar Premium");
	            frameTelaMenuClientePremium.setVisible(false);
	        } else if ("ENTER".equals(command)) {
	         	JOptionPane.showMessageDialog(null, "A opção não é válida");   
	        } else {
	        	JOptionPane.showMessageDialog(null, "A opção não é válida");
	        }
	    }
	  
}