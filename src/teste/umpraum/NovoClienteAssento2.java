package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {
	public static void main(String[] args) {
	
		
		DAO<Cliente> dao =new DAO<>(Cliente.class);
		
		Cliente cliente =dao.obterPorId(1l);	
		System.out.println(cliente.getAssento().getNome());
		
		dao.fechar();
		
		DAO<Assento> dao2 =new DAO<>(Assento.class);
		Assento assento =dao2.obterPorId(1l);	
		System.out.println(assento.getCliente().getNome());
		
		dao2.fechar();
		
	}
}
