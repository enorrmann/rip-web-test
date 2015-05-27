package ar.gov.santafe.meduc.lce.ui.util.controller;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Ruta {
    String   value() default "";

}
