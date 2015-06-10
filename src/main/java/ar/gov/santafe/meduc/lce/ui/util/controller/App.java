package ar.gov.santafe.meduc.lce.ui.util.controller;

import org.glassfish.jersey.server.ResourceConfig;

//@ApplicationPath("/")
public class App extends ResourceConfig {
	public App() {
		packages("ar.gov.santafe.meduc.lce.ui.util.controller");
	}
}
