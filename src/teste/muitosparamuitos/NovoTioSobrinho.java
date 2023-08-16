package teste.muitosparamuitos;

import infra.DAO;
import modelo.muitosparamuitos.Sobrinho;
import modelo.muitosparamuitos.Tio;

public class NovoTioSobrinho {
	public static void main(String[] args) {
		DAO<Object> dao = new DAO<>();
		
		Tio tio1=new Tio("Marlene");
		Tio tio2=new Tio("joao");
		
		Sobrinho sobrinho1=new Sobrinho("marcos");
		Sobrinho sobrinho2=new Sobrinho("maria");
		
		tio1.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tio1);
		
		tio1.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tio1);
		
		tio2.getSobrinhos().add(sobrinho1);
		sobrinho1.getTios().add(tio2);
		
		tio2.getSobrinhos().add(sobrinho2);
		sobrinho2.getTios().add(tio2);
		
		dao.abrirTransacao().Incluir(tio1).Incluir(tio2).Incluir(sobrinho1).Incluir(sobrinho2).FecharTransacao().fechar();
	}
}
