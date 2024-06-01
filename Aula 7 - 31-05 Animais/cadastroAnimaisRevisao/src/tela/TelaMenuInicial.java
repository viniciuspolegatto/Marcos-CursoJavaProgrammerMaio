
package tela;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;


	public class TelaMenuInicial {
		
		
		public void chamarTelaMenuInicial() {
			
			JFrame frameTelaInicial = new JFrame();// Instanciando um JFrame Vazio
			
			frameTelaInicial.setSize(200 , 200); // Altura e largura
			JPanel panelTelaInicial = new JPanel();// Cria o objeto painel
			
			JLabel labelOpcaoCachorro = new JLabel(" 1 - MENU CACHORRO");//Cria a label 1
			panelTelaInicial.add(labelOpcaoCachorro);// Adiciona a label 1 no painel
			
			JLabel labelOpcaoCobra = new JLabel(" 2 - MENU COBRA");//Cria a label 1
			panelTelaInicial.add(labelOpcaoCobra);// Adiciona a label 1 no painel
			
			JTextField opcaoTexto = new JTextField(10);
			
			
			panelTelaInicial.add(opcaoTexto);
			
			JButton botaoEnviar = new JButton("Enviar");
			panelTelaInicial.add(botaoEnviar);
			
			
			

			frameTelaInicial.add(panelTelaInicial);//Adiciona o painel no frame
			frameTelaInicial.setVisible(true);//Deixa visivel
			
			
			
		}

	}