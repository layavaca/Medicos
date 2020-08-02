/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo4;
import ec.edu.ups.modelo.Medico;

/**
 *
 * @author Usuario
 */
public class Cuenta {
    private int numeroCuenta;
    private Medico medico;

    public Cuenta(int numeroCuenta, Medico medico) {
        this.numeroCuenta = numeroCuenta;
        this.medico = medico;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "numeroCuenta=" + numeroCuenta + ", medico=" + medico + '}';
    }
    
    
    
    
}
