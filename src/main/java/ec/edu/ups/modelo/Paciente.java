/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import ec.edu.ups.modelo.Persona;
import java.util.Date;


public class Paciente {

    public String pac_cedula;
    public String pa_religion;
    public String pa_recidencia;
    public String pa_procedencia;
    public String pa_ocupacion;
    public String PERSONA_per_cedula;

    public Paciente(String pac_cedula, String pa_religion, String pa_recidencia, String pa_procedencia, String pa_ocupacion, String PERSONA_per_cedula) {
        this.pac_cedula = pac_cedula;
        this.pa_religion = pa_religion;
        this.pa_recidencia = pa_recidencia;
        this.pa_procedencia = pa_procedencia;
        this.pa_ocupacion = pa_ocupacion;
        this.PERSONA_per_cedula = PERSONA_per_cedula;
    }

    public Paciente() {
    }

    public String getPac_cedula() {
        return pac_cedula;
    }

    public void setPac_cedula(String pac_cedula) {
        this.pac_cedula = pac_cedula;
    }

    public String getPa_religion() {
        return pa_religion;
    }

    public void setPa_religion(String pa_religion) {
        this.pa_religion = pa_religion;
    }

    public String getPa_recidencia() {
        return pa_recidencia;
    }

    public void setPa_recidencia(String pa_recidencia) {
        this.pa_recidencia = pa_recidencia;
    }

    public String getPa_procedencia() {
        return pa_procedencia;
    }

    public void setPa_procedencia(String pa_procedencia) {
        this.pa_procedencia = pa_procedencia;
    }

    public String getPa_ocupacion() {
        return pa_ocupacion;
    }

    public void setPa_ocupacion(String pa_ocupacion) {
        this.pa_ocupacion = pa_ocupacion;
    }

    public String getPERSONA_per_cedula() {
        return PERSONA_per_cedula;
    }

    public void setPERSONA_per_cedula(String PERSONA_per_cedula) {
        this.PERSONA_per_cedula = PERSONA_per_cedula;
    }

    @Override
    public String toString() {
        return "Paciente{" + "pac_cedula=" + pac_cedula + ", pa_religion=" + pa_religion + ", pa_recidencia=" + pa_recidencia + ", pa_procedencia=" + pa_procedencia + ", pa_ocupacion=" + pa_ocupacion + ", PERSONA_per_cedula=" + PERSONA_per_cedula + '}';
    }

}
