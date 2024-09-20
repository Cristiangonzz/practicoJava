package bussines.Controllers;

import java.util.List;
import java.util.Optional;

import jakarta.ejb.Local;
import models.Hecho;


@Local
public interface IHechosControllerLocal {
	
	public abstract Hecho agregarHecho(Hecho hecho); 
	
	public abstract List<Hecho> obtenerHechos();
	
	public abstract Optional<Hecho> buscarHechoPorDescripcion(String descripcion);
}
