package ar.gov.santafe.meduc.lce.ui.util.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;




public class ProductorUtil {

	
	public <T> T getService(Class<T> t) {
	
		@SuppressWarnings("unchecked")
		T implementing = (T) java.lang.reflect.Proxy.newProxyInstance(t.getClassLoader(), new java.lang.Class[] { t }, new java.lang.reflect.InvocationHandler() {
	
	            
	     @Override   
		 public Object invoke(Object proxy, java.lang.reflect.Method method, Object[] args) throws java.lang.Throwable {
	        	 CallDescriptor cd = MethodMapper.getDescriptor(method,args);
	     		 Client client = ClientBuilder.newClient();
	     		 Response response = client.target("http://localhost:8080/lce-persistence")
	     		 .path(cd.getPath())
	     		 .resolveTemplates(cd.getParameters())
	     		 .request(MediaType.APPLICATION_JSON).get();
	                return response.readEntity(cd.getReturnType());
	            }
	        });
		return implementing;
	}

	
}
