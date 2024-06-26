package telas.correntistaPremium;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import controladores.ControladorTelaMenuCorrentistaPremium;


public class TelaMenuCorrentistaPremium {

    public void chamarTelaMenuCorrentistaPremium() {
        JFrame frameTelaMenuCLientePremium = new JFrame("MENU CLIENTE PREMIUM"); // Instanciando um JFrame com título

        // Definir comportamento de fechamento
        frameTelaMenuCLientePremium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o layout do painel
        JPanel panelTelaMenuCorrentistaPremium = new JPanel(new GridLayout(0, 1, 5, 5)); // 5 pixels de espaço entre os componentes
        panelTelaMenuCorrentistaPremium.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do painel

        JLabel labelMensagemTopo = new JLabel("<html><div style='text-align: center;'>APERTE O BOTÃO PARA <br> SEGUIR NA OPÇÃO DESEJADA</div></html>", SwingConstants.CENTER);
        panelTelaMenuCorrentistaPremium.add(labelMensagemTopo);

        JLabel labelEspaco1 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaMenuCorrentistaPremium.add(labelEspaco1);
        
        JButton botaoCadastrarPremium = new JButton("CADASTRAR CLIENTE PREMIUM");
        panelTelaMenuCorrentistaPremium.add(botaoCadastrarPremium);

        JButton botaoEditarPremium = new JButton("EDITAR CLIENTE PREMIUM");
        panelTelaMenuCorrentistaPremium.add(botaoEditarPremium);
        
        JButton botaoListarPremium = new JButton("LISTAR CLIENTES PREMIUM");
        panelTelaMenuCorrentistaPremium.add(botaoListarPremium);
        
        JButton botaoDeletarPremium = new JButton("DELETAR CLIENTE PREMIUM");
        panelTelaMenuCorrentistaPremium.add(botaoDeletarPremium);

        JLabel labelEspaco2 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaMenuCorrentistaPremium.add(labelEspaco2);

        JLabel labelEspaco3 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaMenuCorrentistaPremium.add(labelEspaco3);
        
        JButton botaoVoltarInicio = new JButton("VOLTAR");
        panelTelaMenuCorrentistaPremium.add(botaoVoltarInicio);


        frameTelaMenuCLientePremium.add(panelTelaMenuCorrentistaPremium); // Adiciona o painel no frame
        frameTelaMenuCLientePremium.setSize(300, 350); // Define o tamanho da janela (largura x altura)

        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaMenuCLientePremium.setLocation(dim.width / 2 - frameTelaMenuCLientePremium.getSize().width / 2,
                                     dim.height / 2 - frameTelaMenuCLientePremium.getSize().height / 2);

        frameTelaMenuCLientePremium.setVisible(true); // Torna visível

        // Controlador para tratar evento do botão
        ControladorTelaMenuCorrentistaPremium controladorTelaMenuCorrentistaPremium = new ControladorTelaMenuCorrentistaPremium (frameTelaMenuCLientePremium);
        botaoCadastrarPremium.addActionListener(controladorTelaMenuCorrentistaPremium);
        botaoListarPremium.addActionListener(controladorTelaMenuCorrentistaPremium);
        botaoEditarPremium.addActionListener(controladorTelaMenuCorrentistaPremium);
        botaoDeletarPremium.addActionListener(controladorTelaMenuCorrentistaPremium);

        botaoCadastrarPremium.setActionCommand("CADASTRAR_PREMIUM");
        botaoListarPremium.setActionCommand("LISTAR_PREMIUM");
        botaoEditarPremium.setActionCommand("EDITAR_PREMIUM");
        botaoDeletarPremium.setActionCommand("DELETAR_PREMIUM");
    
        
    }
}