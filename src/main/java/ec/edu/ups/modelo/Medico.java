package ec.edu.ups.modelo;

public class Medico {
	
	
	public String med_id;
	public int med_numeroconsultorio; 
	public String med_usuario;
	public String med_password;
	public String med_per_cedula;
	public int med_numero;

	public int getMed_numero() {
		return med_numero;
	}



	public void setMed_numero(int med_numero) {
		this.med_numero = med_numero;
	}



	public String getMed_id() {
		return med_id;
	}



	public void setMed_id(String med_id) {
		this.med_id = med_id;
	}




	public int getMed_numeroconsultorio() {
		return med_numeroconsultorio;
	}




	public void setMed_numeroconsultorio(int med_numeroconsultorio) {
		this.med_numeroconsultorio = med_numeroconsultorio;
	}




	public String getMed_usuario() {
		return med_usuario;
	}



	public void setMed_usuario(String med_usuario) {
		this.med_usuario = med_usuario;
	}




	public String getMed_password() {
		return med_password;
	}





	public void setMed_password(String med_password) {
		this.med_password = med_password;
	}



	public String getMed_per_cedula() {
		return med_per_cedula;
	}



	public void setMed_per_cedula(String med_per_cedula) {
		this.med_per_cedula = med_per_cedula;
	}






	@Override
	public String toString() {
		return "Medico [med_Id=" + med_id + ", numero_consultorio=" + med_numeroconsultorio + ", usuario=" + med_usuario + ", password=" + med_password +
				", med_per_cedula=" + med_per_cedula +  "med_numero=" + med_numero +"]";
	}
	

}
