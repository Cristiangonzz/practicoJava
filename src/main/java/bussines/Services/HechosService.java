package bussines.Services;

import data.HechosRepository;
import jakarta.ejb.EJB;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import models.Hecho;

import java.util.List;
import java.util.Optional;


@Stateful
@Local(IHechosService.class)
@LocalBean
public class HechosService implements IHechosService {

	@EJB
	private HechosRepository hechoRepositorio;

	@Override
	public Hecho agregarHecho(Hecho hecho) {
		if (hecho.getDescription() == null || hecho.getDescription().isEmpty()) {
			throw new IllegalArgumentException("La descripción del hecho no puede estar vacía.");
		}
		hechoRepositorio.agregarHecho(hecho);
		return hecho;
	}

	@Override
	public List<Hecho> obtenerHechos() {
		return hechoRepositorio.listarHechos();
	}

	@Override
	public Optional<Hecho> buscarHechoPorDescripcion(String descripcion) {
		return hechoRepositorio.buscarHechoPorDescripcion(descripcion);
	}
}
