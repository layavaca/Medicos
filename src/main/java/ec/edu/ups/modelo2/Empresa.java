/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo2;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Empresa {
    
    private int codigoEmpresa;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private Date fechaEmpresa;

    public Empresa(int codigoEmpresa, String nombreEmpresa, String direccionEmpresa, Date fechaEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.fechaEmpresa = fechaEmpresa;
    }

    public int getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(int codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public Date getFechaEmpresa() {
        return fechaEmpresa;
    }

    public void setFechaEmpresa(Date fechaEmpresa) {
        this.fechaEmpresa = fechaEmpresa;
    }

    @Override
    public String toString() {
        return "Empresa{" + "codigoEmpresa=" + codigoEmpresa + ", nombreEmpresa=" + nombreEmpresa + ", direccionEmpresa=" + direccionEmpresa + ", fechaEmpresa=" + fechaEmpresa + '}';
    }
    
    
}
