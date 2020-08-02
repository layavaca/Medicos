/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo3;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Consulta {
    private int codigoConsulta;
    private Date FechaConsulta;

    public Consulta(int codigoConsulta, Date FechaConsulta) {
        this.codigoConsulta = codigoConsulta;
        this.FechaConsulta = FechaConsulta;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public Date getFechaConsulta() {
        return FechaConsulta;
    }

    public void setFechaConsulta(Date FechaConsulta) {
        this.FechaConsulta = FechaConsulta;
    }

    @Override
    public String toString() {
        return "Consulta{" + "codigoConsulta=" + codigoConsulta + ", FechaConsulta=" + FechaConsulta + '}';
    }
    
}
