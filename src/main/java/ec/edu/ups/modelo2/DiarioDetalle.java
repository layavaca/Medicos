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
class DiarioDetalle {
    
    private int codigoDiarioDetalle;
    private String descripcionDiarioDetalle;
    private double debeDiarioDetalle;
    private double hablerDiarioDetalle;

    public DiarioDetalle(int codigoDiarioDetalle, String descripcionDiarioDetalle, double debeDiarioDetalle, double hablerDiarioDetalle) {
        this.codigoDiarioDetalle = codigoDiarioDetalle;
        this.descripcionDiarioDetalle = descripcionDiarioDetalle;
        this.debeDiarioDetalle = debeDiarioDetalle;
        this.hablerDiarioDetalle = hablerDiarioDetalle;
    }

    public int getCodigoDiarioDetalle() {
        return codigoDiarioDetalle;
    }

    public void setCodigoDiarioDetalle(int codigoDiarioDetalle) {
        this.codigoDiarioDetalle = codigoDiarioDetalle;
    }

    public String getDescripcionDiarioDetalle() {
        return descripcionDiarioDetalle;
    }

    public void setDescripcionDiarioDetalle(String descripcionDiarioDetalle) {
        this.descripcionDiarioDetalle = descripcionDiarioDetalle;
    }

    public double getDebeDiarioDetalle() {
        return debeDiarioDetalle;
    }

    public void setDebeDiarioDetalle(double debeDiarioDetalle) {
        this.debeDiarioDetalle = debeDiarioDetalle;
    }

    public double getHablerDiarioDetalle() {
        return hablerDiarioDetalle;
    }

    public void setHablerDiarioDetalle(double hablerDiarioDetalle) {
        this.hablerDiarioDetalle = hablerDiarioDetalle;
    }

    @Override
    public String toString() {
        return "DiarioDetalle{" + "codigoDiarioDetalle=" + codigoDiarioDetalle + ", descripcionDiarioDetalle=" + descripcionDiarioDetalle + ", debeDiarioDetalle=" + debeDiarioDetalle + ", hablerDiarioDetalle=" + hablerDiarioDetalle + '}';
    }
    
    
}
