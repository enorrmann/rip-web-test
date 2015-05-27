package ar.gov.santafe.meduc.lce.ui.util.controller;

import modelo.organismos.Pais;

public class TestStandAlone {

	public static void main(String[] args) {
		CrudService service = new ProductorUtil().getService(CrudService.class);
		Pais pais= service.findPais(2L);
		//System.out.println(unTipo.getNombres());

	}

}
