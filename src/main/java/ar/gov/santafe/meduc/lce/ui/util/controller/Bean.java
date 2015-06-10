package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import modelo.organismos.Pais;
import ar.com.norrmann.remote.interfaces.Dao;
import ar.com.norrmann.remote.interfaces.PaisService;

@Named
@SessionScoped
public class Bean implements Serializable {
	
	@Inject
	Service<PaisService> paisService;

	@Inject
	Service<Dao<Pais>> paisDao; 
	
	private Pais pais;
	private List<Pais> paises;
	
	@PostConstruct
	public void init(){
//		paises = paisDao.call.list();
		pais = paisDao.call.find(2L);
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		System.out.print("SET PAIS" +pais);
		this.pais = pais;
	}

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
	
	public String guardar(){
		Random r = new Random();
		pais.setId(r.nextLong());
		paisService.call.guardar(pais);
		paises = paisService.call.listar();
		return null;
	}
	public String borrar(){
		System.out.print("PAIS" +pais);
		paisService.call.borrar(pais.getId());
		paises = paisService.call.listar();
		return null;
	}
}
