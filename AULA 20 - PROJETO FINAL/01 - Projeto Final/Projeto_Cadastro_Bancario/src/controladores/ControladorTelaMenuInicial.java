package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import telasClienteGeral.TelaMenuClienteGeral;
import telasClientePremium.TelaMenuClientePremium;

public class ControladorTelaMenuInicial implements ActionListener {
	
	//ESSES SÃO OS ATRIBUTOS DA CLASSE, SERVEM PARA ...
	JTextField opcaoTexto;
	JFrame frameTelaInicial;
	JButton botaoMenuPremium;
	JButton botaoMenuGeral;
	
	
	//ESTANCIANDO OS ELEMENTOS - ESSA AÇÃO VAI TRAZER AS REFERÊNCIAS ONDE SERÃO OS DIRECIONAMENTOS
	// PARA OS PRÓXIMOS PASSOS
	TelaMenuClientePremium telaMenuClientePremium = new TelaMenuClientePremium();
	TelaMenuClienteGeral telaMenuClienteGeral = new TelaMenuClienteGeral();
	
	
	//CHAMANDO UM MÉTODO PARA TRABALHAR NA CLASSE CONTROLADOR DO MENU INICIAL
	public ControladorTelaMenuInicial (JTextField opcaoTexto, JFrame frameTelaInicial) {
		this.opcaoTexto = opcaoTexto;
		this.frameTelaInicial = frameTelaInicial;
	}
	
	//AÇÃO DE POLIMORFISMO DEVIDO AO USAR IMPLEMENTS NA DEFINIÇÃO DA CLASSE
	  @Override
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();
	        if ("MENU_PREMIUM".equals(command)) {
	            telaMenuClientePremium.chamarTelaMenuClientePremium();
	            System.out.println("Direcione para tela do cliente premium");
	            frameTelaInicial.setVisible(false);
	        } else if ("MENU_STANDARD".equals(command)) {
	            telaMenuClienteGeral.chamarTelaMenuClienteGeral();
	            System.out.println("Direcione para tela do cliente standard");
	            frameTelaInicial.setVisible(false);
	        } else if ("ENTER".equals(command)) {
	            caixaDeTexto();   
	        } else {
	            caixaDeTexto();
	        }
	    }

	    public void caixaDeTexto() {
	        String input = opcaoTexto.getText();
	        switch (input) {
	            case "1":
	                telaMenuClientePremium.chamarTelaMenuClientePremium();
	                System.out.println("Direcione para tela do Cliente Premium");
	                frameTelaInicial.setVisible(false);
	                break;
	            case "2":
	                telaMenuClienteGeral.chamarTelaMenuClienteGeral();
	                System.out.println("Direcione para tela do cliente Geral");
	                frameTelaInicial.setVisible(false);
	                break;
	            case "3":
	                System.exit(0);
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "A opção " + opcaoTexto.getText() + " não é válida");
	                break;
	        }
	    }
	}