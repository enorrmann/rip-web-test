package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import modelo.organismos.Pais;
import ar.com.norrmann.remote.interfaces.PaisService;
import ar.gov.santafe.meduc.rip.Service;



@Path("/test")
@Stateless
public class TestController {

	@Inject
	Service<PaisService> paisService;
	
	@GET
	public String test(){
		try {
			List<Pais> paises = paisService.call.listar();
			
			return paises.toString();
		} catch (Exception e){
			e.printStackTrace();
			return "error";
		}
	}

}
