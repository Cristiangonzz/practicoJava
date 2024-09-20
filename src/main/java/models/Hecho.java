package models;

import java.util.Date;
import java.util.UUID;

public class Hecho {

	private String id;
	private String description;
	private Date date;
	private String nivelExactitud;
	
	
	
	public Hecho(String description, Date date, String nivelExactitud) {
		
		this.description = description;
		this.date = date;
		this.nivelExactitud = nivelExactitud;
		this.id = UUID.randomUUID().toString();
	}
	public Hecho() {}



	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNivelExactitud() {
		return nivelExactitud;
	}
	public void setNivelExactitud(String nivelExactitud) {
		this.nivelExactitud = nivelExactitud;
	}

	
	
	
}
