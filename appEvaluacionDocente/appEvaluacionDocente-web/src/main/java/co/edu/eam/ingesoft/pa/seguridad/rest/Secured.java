package co.edu.eam.ingesoft.pa.seguridad.rest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ws.rs.NameBinding;

@Retention(RetentionPolicy.RUNTIME)// cuando se ejecuta, tiempo de ejecucion o tiempo de codificacion
@Target(value={ElementType.TYPE, ElementType.METHOD}) // que cosas verificara, metodo y clase
@NameBinding // indica que se usara como interceptor REST
public @interface Secured {

}
