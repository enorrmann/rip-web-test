package ar.gov.santafe.meduc.lce.ui.util.controller;


import java.lang.reflect.ParameterizedType;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.proxy.WebResourceFactory;


public class ProductorUtil {

//	public <T> T getProxyFor(Class<T> t) {
//
//		@SuppressWarnings("unchecked")
//		T implementing = (T) java.lang.reflect.Proxy.newProxyInstance(
//				t.getClassLoader(), new java.lang.Class[] { t },
//				new RestInvocationHandler());
//		return implementing; 
//	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Produces
    public <T> Service<T> create(InjectionPoint p){ 
		 Class clazz = (Class)((ParameterizedType)p.getType()).getActualTypeArguments()[0];
		  WebTarget t = ClientBuilder.newClient().target("http://localhost:8080/lce-persistence/");
//		return new Service(getProxyFor(clazz));
		return new Service(WebResourceFactory.newResource(clazz, t));
		//  return null;
    }
}
