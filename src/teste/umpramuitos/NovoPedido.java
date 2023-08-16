package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuitos.ItemPedido;
import modelo.umpramuitos.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao=new DAO<>();
		
		Produto produto=new Produto("televisao",18900.90);
		
		Pedido pedido =new Pedido();
		
		ItemPedido item=new ItemPedido(10,pedido,produto);
		
		dao.abrirTransacao().Incluir(produto).Incluir(pedido).Incluir(item).FecharTransacao().fechar();
	}
}
