package ar.gov.santafe.meduc.lce.ui.util.controller;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import modelo.organismos.Pais;



@Path("/test")
@Stateless
public class TestController {


	@GET
	public String test(){
		try {
			CrudService service = new ProductorUtil().getService(CrudService.class);
			Pais pais = service.findPais(2L);
			return pais.getPais();
		} catch (Exception e){
			e.printStackTrace();
			return "error";
		}
	}

}
