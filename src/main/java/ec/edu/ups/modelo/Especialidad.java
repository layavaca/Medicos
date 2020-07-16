/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

public class Especialidad {
    
    public int espe_id;
    public String espe_especialidad;

    public Especialidad(int espe_id, String espe_especialidad) {
        this.espe_id = espe_id;
        this.espe_especialidad = espe_especialidad;
    }

    public int getEspe_id() {
        return espe_id;
    }

    public void setEspe_id(int espe_id) {
        this.espe_id = espe_id;
    }

    public String getEspe_especialidad() {
        return espe_especialidad;
    }

    public void setEspe_especialidad(String espe_especialidad) {
        this.espe_especialidad = espe_especialidad;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "espe_id=" + espe_id + ", espe_especialidad=" + espe_especialidad + '}';
    }
    
    
}
