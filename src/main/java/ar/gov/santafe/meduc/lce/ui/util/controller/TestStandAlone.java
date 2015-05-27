package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.util.List;

import modelo.organismos.Pais;
import ar.com.norrmann.remote.interfaces.PaisService;

public class TestStandAlone {

	public static void main(String[] args) {
		PaisService service = new ProductorUtil().getService(PaisService.class);
List<Pais> paises = service.listar();
//		Pais pais = new Pais();
//		pais.setPais("Volkod");
//		service.guardar(pais);


	}

}
