
package repositorio;

import entidade.CorrentistaPremium;
import persistencia.dao.DaoCorrentistaPremium;
import servicos.EntidadeDeDirecionamentos;

public class CorrentistaPremiumRepositorioImplementacao implements CorrentistaPremiumRepositorio {

		@Override
		public boolean salvarCorrentistaPremiumRepositorio(CorrentistaPremium correntistaPremium, String transacoes) {
			
			DaoCorrentistaPremium daoCorrentistaPremium = new DaoCorrentistaPremium();
			
			EntidadeDeDirecionamentos entidadeDeDirecionamentos = new EntidadeDeDirecionamentos();
			
			if (entidadeDeDirecionamentos.buscarTransacoesCorrentistaPremium(transacoes) == null) {
				return false;
			}else {
				correntistaPremium.setTransacoes(entidadeDeDirecionamentos.buscarTransacoesCorrentistaPremium(transacoes));
				return daoCorrentistaPremium.salvarCorrentistaPremium(correntistaPremium);
			}
		}
			
			
}