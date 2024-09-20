package bussines.Controllers;

import java.util.List;
import java.util.Optional;

import bussines.Services.HechosService;
import jakarta.ejb.Local;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import models.Hecho;

@Stateless
@Local(IHechosControllerLocal.class)
@LocalBean
public class HechosControllerLocal implements IHechosControllerLocal {
	
	
	@Inject
	private HechosService hechoService;	
	
	

	@Override
	public List<Hecho> obtenerHechos() {
		return this.hechoService.obtenerHechos();
	}

	@Override
	public Optional<Hecho> buscarHechoPorDescripcion(String descripcion) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	public Hecho agregarHecho(Hecho hecho) {
		// TODO Auto-generated method stub
		return this.hechoService.agregarHecho(hecho);
	}
	
	
}
