package teste.umpramuitos;

import infra.DAO;
import modelo.muitosparamuitos.Ator;
import modelo.muitosparamuitos.Filme;

public class NovoFilmeAtor {
	public static void main(String[] args) {
		Filme filmea=new Filme("A espera de um milagre",9.8);
		Filme filmeb=new Filme("Prenda-me se for capaz",8.8);
		
		Ator atora=new Ator("Jim carry");
		Ator atorb=new Ator("chris rock");
		
		filmea.adicionarAtor(atora);
		filmea.adicionarAtor(atorb);
		
		filmeb.adicionarAtor(atora);
		
		DAO<Filme> dao=new DAO<>();
		dao.IncluirAtomico(filmea);
	}
}
