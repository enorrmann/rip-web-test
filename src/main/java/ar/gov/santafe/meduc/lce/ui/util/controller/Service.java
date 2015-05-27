package ar.gov.santafe.meduc.lce.ui.util.controller;

public class Service<T> {
	public final T call;

	public Service(T call) {
		this.call = call;
	}
}