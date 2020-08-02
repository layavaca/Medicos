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
public class DiarioCabecera {
    private int codigoDiarioCabecera;
    private Date fechaDiarioCabecera;
    private Cuenta Cuenta;
    private DiarioDetalle DiarioDetalle;

    public DiarioCabecera(int codigoDiarioCabecera, Date fechaDiarioCabecera, Cuenta Cuenta, DiarioDetalle DiarioDetalle) {
        this.codigoDiarioCabecera = codigoDiarioCabecera;
        this.fechaDiarioCabecera = fechaDiarioCabecera;
        this.Cuenta = Cuenta;
        this.DiarioDetalle = DiarioDetalle;
    }

    public int getCodigoDiarioCabecera() {
        return codigoDiarioCabecera;
    }

    public void setCodigoDiarioCabecera(int codigoDiarioCabecera) {
        this.codigoDiarioCabecera = codigoDiarioCabecera;
    }

    public Date getFechaDiarioCabecera() {
        return fechaDiarioCabecera;
    }

    public void setFechaDiarioCabecera(Date fechaDiarioCabecera) {
        this.fechaDiarioCabecera = fechaDiarioCabecera;
    }

    public Cuenta getCuenta() {
        return Cuenta;
    }

    public void setCuenta(Cuenta Cuenta) {
        this.Cuenta = Cuenta;
    }

    public DiarioDetalle getDiarioDetalle() {
        return DiarioDetalle;
    }

    public void setDiarioDetalle(DiarioDetalle DiarioDetalle) {
        this.DiarioDetalle = DiarioDetalle;
    }

    @Override
    public String toString() {
        return "DiarioCabecera{" + "codigoDiarioCabecera=" + codigoDiarioCabecera + ", fechaDiarioCabecera=" + fechaDiarioCabecera + ", Cuenta=" + Cuenta + ", DiarioDetalle=" + DiarioDetalle + '}';
    }     
}
