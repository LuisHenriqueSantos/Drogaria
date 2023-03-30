package br.com.luis.drogaria.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import antlr.collections.Stack;
import br.com.luis.drogaria.dao.FabricanteDAO;
import br.com.luis.drogaria.domain.Fabricante;

//http://127.0.0.1:8080/Drogaria/rest/fabricante
@Path("fabricante")

public class FabricanteService {
	// http://127.0.0.1:8080/Drogaria/rest/fabricante
	@GET
	public String listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> fabricantes = fabricanteDAO.listar("descricao");

		Gson gson = new Gson();
		String json = gson.toJson(fabricantes);

		return json;
	}

	// http://127.0.0.1:8080/Drogaria/rest/fabricante/10
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(fabricante);

		return json;

	}

	// http://127.0.0.1:8080/Drogaria/rest/fabricante
	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Fabricante fabricante = gson.fromJson(json, Fabricante.class);

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.merge(fabricante);
		
		String jsonSaida = gson.toJson(fabricante);
		return jsonSaida;
	}

	public void editar() {

	}

	public void excluir() {

	}

}