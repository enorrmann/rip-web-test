package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import modelo.organismos.Pais;
import ar.com.norrmann.remote.interfaces.PaisService;



@Path("/test")
@Stateless
public class TestController {


	@GET
	public String test(){
		try {
			PaisService service = new ProductorUtil().getService(PaisService.class);
			Pais pais = service.findPais(2L);
			
			pais.setPais("Volkod");
			service.guardar(pais);
			
			List<Pais> paises = service.listar();
			
			return paises.toString();
		} catch (Exception e){
			e.printStackTrace();
			return "error";
		}
	}

}
