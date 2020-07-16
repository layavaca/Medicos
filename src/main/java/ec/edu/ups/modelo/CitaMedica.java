/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.sql.Time;
import java.util.Date;

public class CitaMedica {

    public int    cita_id;
    public String cita_fecha;
    public String cita_hora;
    public String cita_motivo;
    public String MEDICO_med_id;
    public String PACIENTE_pa_cedula;

    public CitaMedica() {

    }
    
    

    

    public String getCita_hora() {
        return cita_hora;
    }

    public void setCita_hora(String cita_hora) {
        this.cita_hora = cita_hora;
    }

    public int getCita_id() {
        return cita_id;
    }

    public void setCita_id(int cita_id) {
        this.cita_id = cita_id;
    }

    public String getCita_fecha() {
        return cita_fecha;
    }

    public void setCita_fecha(String cita_fecha) {
        this.cita_fecha = cita_fecha;
    }

    public String getCita_motivo() {
        return cita_motivo;
    }

    public void setCita_motivo(String cita_motivo) {
        this.cita_motivo = cita_motivo;
    }

    public String getMEDICO_med_id() {
        return MEDICO_med_id;
    }

    public void setMEDICO_med_id(String MEDICO_med_id) {
        this.MEDICO_med_id = MEDICO_med_id;
    }

    public String getPACIENTE_pa_cedula() {
        return PACIENTE_pa_cedula;
    }

    public void setPACIENTE_pa_cedula(String PACIENTE_pa_cedula) {
        this.PACIENTE_pa_cedula = PACIENTE_pa_cedula;
    }

    @Override
    public String toString() {
        return "CitaMedica{" + "cita_id=" + cita_id + ", cita_fecha=" + cita_fecha + ", cita_hora=" + cita_hora + ", cita_motivo=" + cita_motivo + ", MEDICO_med_id=" + MEDICO_med_id + ", PACIENTE_pa_cedula=" + PACIENTE_pa_cedula + '}';
    }
 
    

}
