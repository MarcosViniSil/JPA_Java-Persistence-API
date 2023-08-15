package teste.umpraum;

import infra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	public static void main(String[] args) {
		Assento assento =new Assento("34t");
		Cliente cliente =new Cliente("maria",assento);
		
		DAO<Object> dao =new DAO<>();
		dao.abrirTransacao().Incluir(assento).Incluir(cliente).FecharTransacao().fechar();
	}
}
