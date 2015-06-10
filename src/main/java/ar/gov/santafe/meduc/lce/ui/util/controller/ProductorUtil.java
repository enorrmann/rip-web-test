package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.proxy.WebResourceFactory;

public class ProductorUtil {

	@SuppressWarnings({ "unchecked", "rawtypes" }) 
	@Produces
	public <T> Service<T> getService(InjectionPoint p) { 
		String url = "http://localhost:3000/";
		Class clazz = null;
		if (((ParameterizedType) p.getType()).getActualTypeArguments()[0] instanceof Class){
			clazz = (Class) ((ParameterizedType) p.getType()).getActualTypeArguments()[0];
		}
		WebTarget t = ClientBuilder.newClient().target(url);
		return new Service(WebResourceFactory.newResource(clazz, t));
	}
}
