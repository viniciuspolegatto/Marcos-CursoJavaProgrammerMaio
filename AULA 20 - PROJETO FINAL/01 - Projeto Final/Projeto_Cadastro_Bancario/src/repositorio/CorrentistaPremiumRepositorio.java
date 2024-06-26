
// A CLASSE CLIENTE PREMIUM REPOSITÓRIO É UMA CLASSE ESTRUTURADA
// PARA SER UM POLIMORFISMO - ELA SERÁ CHAMADA PARA ATENDER OPERAÇÕES
// NA CLASSE CorrentistaPremiumRepositorioIMPLEMENTAÇÃO

package repositorio;

import entidade.CorrentistaPremium;

public interface CorrentistaPremiumRepositorio {

	
		public boolean salvarCorrentistaPremiumRepositorio(CorrentistaPremium correntistaPremium, String transacoes);
		//public List<Atendente> listarAtendenteRepositorio();
		//public boolean deletaAtendenteRepositorio(String cpf);
		//public boolean alterarAtendenteRepositorio(Atendente atendente);
		

	}