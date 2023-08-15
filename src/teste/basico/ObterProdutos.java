package teste.basico;

import java.util.List;

import infra.DAO;
import modelo.basico.Produto;

public class ObterProdutos {
	public static void main(String[] args) {
		DAO<Produto> dao=new DAO<>(Produto.class);
		
		List<Produto> prod= dao.obterTodos(10,0);
		
		for(Produto e:prod) {
			System.out.println("Nome"+e.getNome());
		}
		
		double precoTotal=prod.stream().map(p -> p.getPreco()).reduce(0.0,(t,p) -> t+p).doubleValue();
		
		System.out.println("total:"+(int)precoTotal);
		
	}
}
