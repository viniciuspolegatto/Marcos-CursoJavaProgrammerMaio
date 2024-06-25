package telasClientePremium;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;

import controladores.ControladorTelaMenuClientePremium;


public class TelaMenuClientePremium {

    public void chamarTelaMenuClientePremium() {
        JFrame frameTelaMenuCLientePremium = new JFrame("MENU CLIENTE PREMIUM"); // Instanciando um JFrame com título

        // Definir comportamento de fechamento
        frameTelaMenuCLientePremium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurar o layout do painel
        JPanel panelTelaMenuClientePremium = new JPanel(new GridLayout(0, 1, 5, 5)); // 5 pixels de espaço entre os componentes
        panelTelaMenuClientePremium.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Margem ao redor do painel

        JLabel labelMensagemTopo = new JLabel("<html><div style='text-align: center;'>APERTE O BOTÃO PARA <br> SEGUIR NA OPÇÃO DESEJADA</div></html>", SwingConstants.CENTER);
        panelTelaMenuClientePremium.add(labelMensagemTopo);

        JLabel labelEspaco1 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaMenuClientePremium.add(labelEspaco1);
        
        JButton botaoCadastrarPremium = new JButton("CADASTRAR CLIENTE PREMIUM");
        panelTelaMenuClientePremium.add(botaoCadastrarPremium);

        JButton botaoEditarPremium = new JButton("EDITAR CLIENTE PREMIUM");
        panelTelaMenuClientePremium.add(botaoEditarPremium);
        
        JButton botaoListarPremium = new JButton("LISTAR CLIENTES PREMIUM");
        panelTelaMenuClientePremium.add(botaoListarPremium);
        
        JButton botaoDeletarPremium = new JButton("DELETAR CLIENTE PREMIUM");
        panelTelaMenuClientePremium.add(botaoDeletarPremium);

        JLabel labelEspaco2 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaMenuClientePremium.add(labelEspaco2);

        JLabel labelEspaco3 = new JLabel("<html><div style='text-align: center;'> <br> </div></html>", SwingConstants.CENTER);
        panelTelaMenuClientePremium.add(labelEspaco3);
        
        JButton botaoVoltarInicio = new JButton("VOLTAR");
        panelTelaMenuClientePremium.add(botaoVoltarInicio);


        frameTelaMenuCLientePremium.add(panelTelaMenuClientePremium); // Adiciona o painel no frame
        frameTelaMenuCLientePremium.setSize(300, 350); // Define o tamanho da janela (largura x altura)

        // Posicionar a janela no centro da tela
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frameTelaMenuCLientePremium.setLocation(dim.width / 2 - frameTelaMenuCLientePremium.getSize().width / 2,
                                     dim.height / 2 - frameTelaMenuCLientePremium.getSize().height / 2);

        frameTelaMenuCLientePremium.setVisible(true); // Torna visível

        // Controlador para tratar evento do botão
        ControladorTelaMenuClientePremium controladorTelaMenuClientePremium = new ControladorTelaMenuClientePremium (frameTelaMenuCLientePremium);
        botaoCadastrarPremium.addActionListener(controladorTelaMenuClientePremium);
        botaoListarPremium.addActionListener(controladorTelaMenuClientePremium);
        botaoEditarPremium.addActionListener(controladorTelaMenuClientePremium);
        botaoDeletarPremium.addActionListener(controladorTelaMenuClientePremium);

        botaoCadastrarPremium.setActionCommand("CADASTRAR_PREMIUM");
        botaoListarPremium.setActionCommand("LISTAR_PREMIUM");
        botaoEditarPremium.setActionCommand("EDITAR_PREMIUM");
        botaoDeletarPremium.setActionCommand("DELETAR_PREMIUM");
    
        
    }
}