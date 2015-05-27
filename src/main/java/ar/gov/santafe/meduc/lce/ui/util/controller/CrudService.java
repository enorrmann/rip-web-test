package ar.gov.santafe.meduc.lce.ui.util.controller;


import javax.ejb.Local;
import javax.ws.rs.PathParam;

import modelo.organismos.Pais;
@Local
@Ruta("/crud")
public interface CrudService{
	
	@Ruta("/pais/{id}")
	public Pais findPais(@PathParam("id") Long id) ;

	
}
