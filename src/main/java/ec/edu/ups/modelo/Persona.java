package ec.edu.ups.modelo;

import java.sql.Date;

public class Persona {

	
	public int id;
	public String cedula;
	public String nombres;
	public String apellidos;
	public String email;
	public String telefono;
	public String direccion;
	public Date fecha_nacimiento;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Persona [Id=" + id + ", Cedula=" + cedula + ", Nombres=" + nombres + ", Apellidos=" + apellidos + ", Email="
				+ email + ", Direccion=" + direccion + ", Telefono=" + telefono  + ", Fecha_Nacimiento=" + fecha_nacimiento + "]";
	}

	
	
	
}
