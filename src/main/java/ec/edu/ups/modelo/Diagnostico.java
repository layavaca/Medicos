/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;


public class Diagnostico {
    
    public int codigoDiagnostico;
    public String enfermedadActual;
    public String boca;
    public String torax;
    public String abdomen;
    public String extremidades;
    public String regionPerineal;
    public String valoracionNeurologica;
    public String ice10;
    public String tratamientos;
    public int HISTORIALCLINICO_hist_id;
    public int CITAMEDICA_cita_id;
    public String CITAMEDICA_MEDICO_med_id;
    public String CITAMEDICA_PACIENTE_pa_cedula;
    
    public Diagnostico(){}

    public Diagnostico(int codigoDiagnostico, String enfermedadActual, String boca, String torax, String abdomen, String extremidades, String regionPerineal, String valoracionNeurologica, String ice10, String tratamientos, int HISTORIALCLINICO_hist_id, int CITAMEDICA_cita_id, String CITAMEDICA_MEDICO_med_id, String CITAMEDICA_PACIENTE_pa_cedula) {
        this.codigoDiagnostico = codigoDiagnostico;
        this.enfermedadActual = enfermedadActual;
        this.boca = boca;
        this.torax = torax;
        this.abdomen = abdomen;
        this.extremidades = extremidades;
        this.regionPerineal = regionPerineal;
        this.valoracionNeurologica = valoracionNeurologica;
        this.ice10 = ice10;
        this.tratamientos = tratamientos;
        this.HISTORIALCLINICO_hist_id = HISTORIALCLINICO_hist_id;
        this.CITAMEDICA_cita_id = CITAMEDICA_cita_id;
        this.CITAMEDICA_MEDICO_med_id = CITAMEDICA_MEDICO_med_id;
        this.CITAMEDICA_PACIENTE_pa_cedula = CITAMEDICA_PACIENTE_pa_cedula;
    }

    public int getCodigoDiagnostico() {
        return codigoDiagnostico;
    }

    public void setCodigoDiagnostico(int codigoDiagnostico) {
        this.codigoDiagnostico = codigoDiagnostico;
    }

    public String getEnfermedadActual() {
        return enfermedadActual;
    }

    public void setEnfermedadActual(String enfermedadActual) {
        this.enfermedadActual = enfermedadActual;
    }

    public String getBoca() {
        return boca;
    }

    public void setBoca(String boca) {
        this.boca = boca;
    }

    public String getTorax() {
        return torax;
    }

    public void setTorax(String torax) {
        this.torax = torax;
    }

    public String getAbdomen() {
        return abdomen;
    }

    public void setAbdomen(String abdomen) {
        this.abdomen = abdomen;
    }

    public String getExtremidades() {
        return extremidades;
    }

    public void setExtremidades(String extremidades) {
        this.extremidades = extremidades;
    }

    public String getRegionPerineal() {
        return regionPerineal;
    }

    public void setRegionPerineal(String regionPerineal) {
        this.regionPerineal = regionPerineal;
    }

    public String getValoracionNeurologica() {
        return valoracionNeurologica;
    }

    public void setValoracionNeurologica(String valoracionNeurologica) {
        this.valoracionNeurologica = valoracionNeurologica;
    }

    public String getIce10() {
        return ice10;
    }

    public void setIce10(String ice10) {
        this.ice10 = ice10;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public int getHISTORIALCLINICO_hist_id() {
        return HISTORIALCLINICO_hist_id;
    }

    public void setHISTORIALCLINICO_hist_id(int HISTORIALCLINICO_hist_id) {
        this.HISTORIALCLINICO_hist_id = HISTORIALCLINICO_hist_id;
    }

    public int getCITAMEDICA_cita_id() {
        return CITAMEDICA_cita_id;
    }

    public void setCITAMEDICA_cita_id(int CITAMEDICA_cita_id) {
        this.CITAMEDICA_cita_id = CITAMEDICA_cita_id;
    }

    public String getCITAMEDICA_MEDICO_med_id() {
        return CITAMEDICA_MEDICO_med_id;
    }

    public void setCITAMEDICA_MEDICO_med_id(String CITAMEDICA_MEDICO_med_id) {
        this.CITAMEDICA_MEDICO_med_id = CITAMEDICA_MEDICO_med_id;
    }

    public String getCITAMEDICA_PACIENTE_pa_cedula() {
        return CITAMEDICA_PACIENTE_pa_cedula;
    }

    public void setCITAMEDICA_PACIENTE_pa_cedula(String CITAMEDICA_PACIENTE_pa_cedula) {
        this.CITAMEDICA_PACIENTE_pa_cedula = CITAMEDICA_PACIENTE_pa_cedula;
    }

    @Override
    public String toString() {
        return "Diagnostico{" + "codigoDiagnostico=" + codigoDiagnostico + ", enfermedadActual=" + enfermedadActual + ", boca=" + boca + ", torax=" + torax + ", abdomen=" + abdomen + ", extremidades=" + extremidades + ", regionPerineal=" + regionPerineal + ", valoracionNeurologica=" + valoracionNeurologica + ", ice10=" + ice10 + ", tratamientos=" + tratamientos + ", HISTORIALCLINICO_hist_id=" + HISTORIALCLINICO_hist_id + ", CITAMEDICA_cita_id=" + CITAMEDICA_cita_id + ", CITAMEDICA_MEDICO_med_id=" + CITAMEDICA_MEDICO_med_id + ", CITAMEDICA_PACIENTE_pa_cedula=" + CITAMEDICA_PACIENTE_pa_cedula + '}';
    }

   

}
