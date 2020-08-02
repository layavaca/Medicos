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
public class Grupo {
    
    private int codigoGrupo;
    private String tipoGrupo;

    public Grupo(int codigoGrupo, String tipoGrupo) {
        this.codigoGrupo = codigoGrupo;
        this.tipoGrupo = tipoGrupo;
    }

    public int getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(int codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }
    
}
