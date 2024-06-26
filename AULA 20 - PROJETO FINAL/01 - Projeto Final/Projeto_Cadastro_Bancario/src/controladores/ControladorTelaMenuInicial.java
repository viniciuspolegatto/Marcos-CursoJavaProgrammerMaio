package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import telas.correntistaGeral.TelaMenuCorrentistaGeral;
import telas.correntistaPremium.TelaMenuCorrentistaPremium;

public class ControladorTelaMenuInicial implements ActionListener {
	
	//ESSES SÃO OS ATRIBUTOS DA CLASSE, SERVEM PARA ...
	JTextField opcaoTexto;
	JFrame frameTelaInicial;
	JButton botaoMenuPremium;
	JButton botaoMenuGeral;
	
	
	//ESTANCIANDO OS ELEMENTOS - ESSA AÇÃO VAI TRAZER AS REFERÊNCIAS ONDE SERÃO OS DIRECIONAMENTOS
	// PARA OS PRÓXIMOS PASSOS
	TelaMenuCorrentistaPremium telaMenuCorrentistaPremium = new TelaMenuCorrentistaPremium();
	TelaMenuCorrentistaGeral telaMenuCorrentistaGeral = new TelaMenuCorrentistaGeral();
	
	
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
	            telaMenuCorrentistaPremium.chamarTelaMenuCorrentistaPremium();
	            System.out.println("Direcione para tela do correntista premium");
	            frameTelaInicial.setVisible(false);
	        } else if ("MENU_STANDARD".equals(command)) {
	            telaMenuCorrentistaGeral.chamarTelaMenuCorrentistaGeral();
	            System.out.println("Direcione para tela do correntista standard");
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
	                telaMenuCorrentistaPremium.chamarTelaMenuCorrentistaPremium();
	                System.out.println("Direcione para tela do Correntista Premium");
	                frameTelaInicial.setVisible(false);
	                break;
	            case "2":
	                telaMenuCorrentistaGeral.chamarTelaMenuCorrentistaGeral();
	                System.out.println("Direcione para tela do correntista Geral");
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