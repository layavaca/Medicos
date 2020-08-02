/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo3;

/**
 *
 * @author Usuario
 */
public class TipoOrden {
    private int codigoTipoOrden;
    private String descripcionTipoOrden;

    public TipoOrden(int codigoTipoOrden, String descripcionTipoOrden) {
        this.codigoTipoOrden = codigoTipoOrden;
        this.descripcionTipoOrden = descripcionTipoOrden;
    }

    public int getCodigoTipoOrden() {
        return codigoTipoOrden;
    }

    public void setCodigoTipoOrden(int codigoTipoOrden) {
        this.codigoTipoOrden = codigoTipoOrden;
    }

    public String getDescripcionTipoOrden() {
        return descripcionTipoOrden;
    }

    public void setDescripcionTipoOrden(String descripcionTipoOrden) {
        this.descripcionTipoOrden = descripcionTipoOrden;
    }

    @Override
    public String toString() {
        return "TipoOrden{" + "codigoTipoOrden=" + codigoTipoOrden + ", descripcionTipoOrden=" + descripcionTipoOrden + '}';
    }        
    
}
