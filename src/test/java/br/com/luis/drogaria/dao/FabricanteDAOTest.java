package br.com.luis.drogaria.dao;

import org.junit.Test;
import br.com.luis.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Aché"); 
	
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}
}

