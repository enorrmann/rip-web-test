package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import modelo.organismos.Pais;
import modelo.personas.Persona;
import ar.com.norrmann.remote.interfaces.InscripcionesService;
import ar.com.norrmann.remote.interfaces.PaisService;



@Path("/test")
@Stateless
public class TestController {

	@Inject
	Service<PaisService> paisService;

	@Inject
	Service<InscripcionesService> inscripcionesService;
	
	@GET
	public String test(){
		try {
			Pais unPais = paisService.call.findPais(2L);
			Pais paisGuardado = paisService.call.guardar(unPais);
		
			List<Pais> paises = paisService.call.listar();
			
			inscripcionesService.call.inscribir(new Persona());
			
			return paises.toString();
			
		} catch (Exception e){
			e.printStackTrace();
			return "error";
		}
	}

}
