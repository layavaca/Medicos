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
public class BalanceGeneral {
    
    private int codigoBalance;
    private Date fechaBalance;
    private double cajaBalance;
    private double bancoBalance;
    private double PacienteBalance;
    private double mercanciaBalance;
    private double deudoresBalance;

    public BalanceGeneral(int codigoBalance, Date fechaBalance, double cajaBalance, double bancoBalance, double PacienteBalance, double mercanciaBalance, double deudoresBalance) {
        this.codigoBalance = codigoBalance;
        this.fechaBalance = fechaBalance;
        this.cajaBalance = cajaBalance;
        this.bancoBalance = bancoBalance;
        this.PacienteBalance = PacienteBalance;
        this.mercanciaBalance = mercanciaBalance;
        this.deudoresBalance = deudoresBalance;
    }

    public int getCodigoBalance() {
        return codigoBalance;
    }

    public void setCodigoBalance(int codigoBalance) {
        this.codigoBalance = codigoBalance;
    }

    public Date getFechaBalance() {
        return fechaBalance;
    }

    public void setFechaBalance(Date fechaBalance) {
        this.fechaBalance = fechaBalance;
    }

    public double getCajaBalance() {
        return cajaBalance;
    }

    public void setCajaBalance(double cajaBalance) {
        this.cajaBalance = cajaBalance;
    }

    public double getBancoBalance() {
        return bancoBalance;
    }

    public void setBancoBalance(double bancoBalance) {
        this.bancoBalance = bancoBalance;
    }

    public double getPacienteBalance() {
        return PacienteBalance;
    }

    public void setPacienteBalance(double PacienteBalance) {
        this.PacienteBalance = PacienteBalance;
    }

    public double getMercanciaBalance() {
        return mercanciaBalance;
    }

    public void setMercanciaBalance(double mercanciaBalance) {
        this.mercanciaBalance = mercanciaBalance;
    }

    public double getDeudoresBalance() {
        return deudoresBalance;
    }

    public void setDeudoresBalance(double deudoresBalance) {
        this.deudoresBalance = deudoresBalance;
    }

    @Override
    public String toString() {
        return "BalanceGeneral{" + "codigoBalance=" + codigoBalance + ", fechaBalance=" + fechaBalance + ", cajaBalance=" + cajaBalance + ", bancoBalance=" + bancoBalance + ", PacienteBalance=" + PacienteBalance + ", mercanciaBalance=" + mercanciaBalance + ", deudoresBalance=" + deudoresBalance + '}';
    }
    
    
    
}
