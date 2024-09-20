package bussines.Services;
import java.util.List;
import java.util.Optional;

import jakarta.ejb.Local;
import models.*;

@Local
public interface IHechosService {
	
	public abstract Hecho agregarHecho(Hecho hecho); 
	
	public abstract List<Hecho> obtenerHechos();
	
	public abstract Optional<Hecho> buscarHechoPorDescripcion(String descripcion);
}
