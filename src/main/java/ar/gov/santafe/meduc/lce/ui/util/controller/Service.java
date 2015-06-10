package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.io.Serializable;

public class Service<T> implements Serializable{
	public final T call;

	public Service(T call) {
		this.call = call;
	}
}