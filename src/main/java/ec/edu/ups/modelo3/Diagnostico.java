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
public class Diagnostico {
    private int codigoDiagnostico;
    private String descripcionDiagnostico;
    private TipoOrden tipoOrden;

    public Diagnostico(int codigoDiagnostico, String descripcionDiagnostico, TipoOrden tipoOrden) {
        this.codigoDiagnostico = codigoDiagnostico;
        this.descripcionDiagnostico = descripcionDiagnostico;
        this.tipoOrden = tipoOrden;
    }

    public int getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico(int codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getDescripcionDiagnostico() {
        return descripcionDiagnostico;
    }

    public void setDescripcionDiagnostico(String descripcionDiagnostico) {
        this.descripcionDiagnostico = descripcionDiagnostico;
    }

    public TipoOrden getTipoOrden() {
        return tipoOrden;
    }

    public void setTipoOrden(TipoOrden tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    @Override
    public String toString() {
        return "Diagnostico{" + "codigoDiagnostico=" + codigoDiagnostico + ", descripcionDiagnostico=" + descripcionDiagnostico + ", tipoOrden=" + tipoOrden + '}';
    }
        
}
