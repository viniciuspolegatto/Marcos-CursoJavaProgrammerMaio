package telasClientePremium;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import controladores.ControladorTelaCadastroPremium;
import controladores.ControladorTelaMenuInicial;


public class TelaCadastroPremium {

    public void chamarTelaCadastroPremium() {
        JFrame frameTelaCadastroPremium = new JFrame("CADASTRO PREMIUM"); // Instanciando um JFrame com título

        // Definir comportamento de fechamento
        frameTelaCadastroPremium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o layout do painel
        JPanel panelTelaCadastroPremium = new JPanel(new GridLayout(0, 1, 5, 5)); // 5 pixels de espaço entre os componentes
        panelTelaCadastroPremium.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do painel

        JLabel labelMensagemTopo = new JLabel("<html><div style='text-align: center;'>PREENCHA OS CAMPOS COM <br> OS DADOS DO(A) CLIENTE</div></html>", SwingConstants.CENTER);
        panelTelaCadastroPremium.add(labelMensagemTopo);

        JLabel labelEspaco1 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaCadastroPremium.add(labelEspaco1);
        
        JLabel labelEspaco2 = new JLabel("NOME:", SwingConstants.LEFT);
        panelTelaCadastroPremium.add(labelEspaco2);
        
        JTextField opcaoTexto = new JTextField(10);
        panelTelaCadastroPremium.add(opcaoTexto);

        JLabel labelEspaco3 = new JLabel("CPF", SwingConstants.LEFT);
        panelTelaCadastroPremium.add(labelEspaco3);
        
        JTextField opcaoTexto3 = new JTextField(10);
        panelTelaCadastroPremium.add(opcaoTexto3);
        
        JLabel labelEspaco4 = new JLabel("E-MAIL:", SwingConstants.LEFT);
        panelTelaCadastroPremium.add(labelEspaco4);
        
        JTextField opcaoTexto4 = new JTextField(10);
        panelTelaCadastroPremium.add(opcaoTexto4);
        
        JLabel labelEspaco5 = new JLabel("CEP", SwingConstants.LEFT);
        panelTelaCadastroPremium.add(labelEspaco5);
        
        JTextField opcaoTexto5 = new JTextField(10);
        panelTelaCadastroPremium.add(opcaoTexto5);

        JLabel labelEspaco6 = new JLabel("VALOR DA ANUIDADE (R$)", SwingConstants.LEFT);
        panelTelaCadastroPremium.add(labelEspaco6);
        
        JTextField opcaoTexto6 = new JTextField(10);
        panelTelaCadastroPremium.add(opcaoTexto6);
        
        JLabel labelEspaco7 = new JLabel("QUANTIDADE DE TRANSAÇÕES MENSAIS", SwingConstants.LEFT);
        panelTelaCadastroPremium.add(labelEspaco7);
        
        JTextField opcaoTexto7 = new JTextField(10);
        panelTelaCadastroPremium.add(opcaoTexto7);

        JLabel labelEspaco8 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.LEFT);
        panelTelaCadastroPremium.add(labelEspaco8);
        
        JButton botaoCadastrarPremium = new JButton("CONTINUAR");
        panelTelaCadastroPremium.add(botaoCadastrarPremium);
        
        JButton botaoVoltarMenuPremium = new JButton("VOLTAR");
        panelTelaCadastroPremium.add(botaoVoltarMenuPremium);

        frameTelaCadastroPremium.add(panelTelaCadastroPremium); // Adiciona o painel no frame
        frameTelaCadastroPremium.setSize(400, 600); // Define o tamanho da janela (largura x altura)

        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaCadastroPremium.setLocation(dim.width / 2 - frameTelaCadastroPremium.getSize().width / 2,
                                     dim.height / 2 - frameTelaCadastroPremium.getSize().height / 2);

        frameTelaCadastroPremium.setVisible(true); // Torna visível

        // Controlador para tratar evento do botão
        ControladorTelaCadastroPremium controladorTelaCadastroPremium = new ControladorTelaCadastroPremium(opcaoTexto, opcaoTexto3, opcaoTexto4, opcaoTexto5, opcaoTexto6, opcaoTexto7, frameTelaCadastroPremium);
        botaoCadastrarPremium.addActionListener(controladorTelaCadastroPremium);

        botaoCadastrarPremium.setActionCommand("CADASTRO_PREMIUM");
        botaoVoltarMenuPremium.setActionCommand("VOLTAR_MENU_PREMIUM");
        botaoCadastrarPremium.addActionListener(controladorTelaCadastroPremium);
        botaoVoltarMenuPremium.addActionListener(controladorTelaCadastroPremium);


    }
}