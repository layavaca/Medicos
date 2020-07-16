/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

public class Historial_Clinico {

    private int codigoHistorial;
    private String descripcion;
    private String tipo;
    private String fecha;
    private String PACIENTE_pa_cedula; 
    // private listaDiagnostico list<>;

    public Historial_Clinico() {
    }

    public Historial_Clinico(int codigoHistorial, String descripcion, String tipo, String  fecha, String PACIENTE_pa_cedula) {
        this.codigoHistorial = codigoHistorial;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.PACIENTE_pa_cedula = PACIENTE_pa_cedula;
    }

    
    
    public int getCodigoHistorial() {
        return codigoHistorial;
    }

    public void setCodigoHistorial(int codigoHistorial) {
        this.codigoHistorial = codigoHistorial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPACIENTE_pa_cedula() {
        return PACIENTE_pa_cedula;
    }

    public void setPACIENTE_pa_cedula(String PACIENTE_pa_cedula) {
        this.PACIENTE_pa_cedula = PACIENTE_pa_cedula;
    }

    @Override
    public String toString() {
        return "Historial_Clinico{" + "codigoHistorial=" + codigoHistorial + ", descripcion=" + descripcion + ", tipo=" + tipo + ", fecha=" + fecha + ", PACIENTE_pa_cedula=" + PACIENTE_pa_cedula + '}';
    }
    
    

    
    
}
