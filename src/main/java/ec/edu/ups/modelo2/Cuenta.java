/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo2;

/**
 *
 * @author Usuario
 */
public class Cuenta {

    public Cuenta(int codigoCuenta, String tipoCuenta) {
        this.codigoCuenta = codigoCuenta;
        this.tipoCuenta = tipoCuenta;
    }

    public int getCodigoCuenta() {
        return codigoCuenta;
    }

    public void setCodigoCuenta(int codigoCuenta) {
        this.codigoCuenta = codigoCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    private int codigoCuenta;
    private String tipoCuenta;
    
}
