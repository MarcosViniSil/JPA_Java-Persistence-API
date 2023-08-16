package modelo.consulta;

import infra.DAO;
import modelo.muitosparamuitos.Filme;

public class ObterMediaFilmes {
	public static void main(String[] args) {
		DAO<NotaFilme> dao =new DAO(NotaFilme.class);
		
		NotaFilme nota=dao.consultarum("mediaGeral");
		
		System.out.println(nota.getMedia());
		
		dao.fechar();
	}
}
