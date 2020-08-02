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
public class BalanceResultado {
    
    private int codigoBalanceResultado;
    private Date fechaBalanceResultado;
    private double ventasBalanceResultado;
    private double utilidadbrutaBalanceResultado;
    private double gastoOpereracionBalanceResultado;
    private double utilidadOperacionalBalanceResultado;
    private double otrosProductosBalanceResultado;
    private double otrosGastosBalanceResultado;
    private double utilidadNetaBalanceResultado;

    public BalanceResultado(int codigoBalanceResultado, Date fechaBalanceResultado, double ventasBalanceResultado, double utilidadbrutaBalanceResultado, double gastoOpereracionBalanceResultado, double utilidadOperacionalBalanceResultado, double otrosProductosBalanceResultado, double otrosGastosBalanceResultado, double utilidadNetaBalanceResultado) {
        this.codigoBalanceResultado = codigoBalanceResultado;
        this.fechaBalanceResultado = fechaBalanceResultado;
        this.ventasBalanceResultado = ventasBalanceResultado;
        this.utilidadbrutaBalanceResultado = utilidadbrutaBalanceResultado;
        this.gastoOpereracionBalanceResultado = gastoOpereracionBalanceResultado;
        this.utilidadOperacionalBalanceResultado = utilidadOperacionalBalanceResultado;
        this.otrosProductosBalanceResultado = otrosProductosBalanceResultado;
        this.otrosGastosBalanceResultado = otrosGastosBalanceResultado;
        this.utilidadNetaBalanceResultado = utilidadNetaBalanceResultado;
    }

    public int getCodigoBalanceResultado() {
        return codigoBalanceResultado;
    }

    public void setCodigoBalanceResultado(int codigoBalanceResultado) {
        this.codigoBalanceResultado = codigoBalanceResultado;
    }

    public Date getFechaBalanceResultado() {
        return fechaBalanceResultado;
    }

    public void setFechaBalanceResultado(Date fechaBalanceResultado) {
        this.fechaBalanceResultado = fechaBalanceResultado;
    }

    public double getVentasBalanceResultado() {
        return ventasBalanceResultado;
    }

    public void setVentasBalanceResultado(double ventasBalanceResultado) {
        this.ventasBalanceResultado = ventasBalanceResultado;
    }

    public double getUtilidadbrutaBalanceResultado() {
        return utilidadbrutaBalanceResultado;
    }

    public void setUtilidadbrutaBalanceResultado(double utilidadbrutaBalanceResultado) {
        this.utilidadbrutaBalanceResultado = utilidadbrutaBalanceResultado;
    }

    public double getGastoOpereracionBalanceResultado() {
        return gastoOpereracionBalanceResultado;
    }

    public void setGastoOpereracionBalanceResultado(double gastoOpereracionBalanceResultado) {
        this.gastoOpereracionBalanceResultado = gastoOpereracionBalanceResultado;
    }

    public double getUtilidadOperacionalBalanceResultado() {
        return utilidadOperacionalBalanceResultado;
    }

    public void setUtilidadOperacionalBalanceResultado(double utilidadOperacionalBalanceResultado) {
        this.utilidadOperacionalBalanceResultado = utilidadOperacionalBalanceResultado;
    }

    public double getOtrosProductosBalanceResultado() {
        return otrosProductosBalanceResultado;
    }

    public void setOtrosProductosBalanceResultado(double otrosProductosBalanceResultado) {
        this.otrosProductosBalanceResultado = otrosProductosBalanceResultado;
    }

    public double getOtrosGastosBalanceResultado() {
        return otrosGastosBalanceResultado;
    }

    public void setOtrosGastosBalanceResultado(double otrosGastosBalanceResultado) {
        this.otrosGastosBalanceResultado = otrosGastosBalanceResultado;
    }

    public double getUtilidadNetaBalanceResultado() {
        return utilidadNetaBalanceResultado;
    }

    public void setUtilidadNetaBalanceResultado(double utilidadNetaBalanceResultado) {
        this.utilidadNetaBalanceResultado = utilidadNetaBalanceResultado;
    }

    @Override
    public String toString() {
        return "BalanceResultado{" + "codigoBalanceResultado=" + codigoBalanceResultado + ", fechaBalanceResultado=" + fechaBalanceResultado + ", ventasBalanceResultado=" + ventasBalanceResultado + ", utilidadbrutaBalanceResultado=" + utilidadbrutaBalanceResultado + ", gastoOpereracionBalanceResultado=" + gastoOpereracionBalanceResultado + ", utilidadOperacionalBalanceResultado=" + utilidadOperacionalBalanceResultado + ", otrosProductosBalanceResultado=" + otrosProductosBalanceResultado + ", otrosGastosBalanceResultado=" + otrosGastosBalanceResultado + ", utilidadNetaBalanceResultado=" + utilidadNetaBalanceResultado + '}';
    }
         
}
