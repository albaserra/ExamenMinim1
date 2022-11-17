package Entities;

import java.util.LinkedList;

public class Muestra {
    String muestraId;
    String pacienteId;
    String clinicoId;
    String laboratorioId;
    String fecha;

    public Muestra(String muestraId, String pacienteId, String clinicoId, String laboratorioId, String fecha) {
        this.muestraId = muestraId;
        this.pacienteId = pacienteId;
        this.clinicoId = clinicoId;
        this.laboratorioId = laboratorioId;
        this.fecha = fecha;
    }

    public String getMuestraId() {
        return muestraId;
    }

    public void setMuestraId(String muestraId) {
        this.muestraId = muestraId;
    }

    public String getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(String pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getClinicoId() {
        return clinicoId;
    }

    public void setClinicoId(String clinicoId) {
        this.clinicoId = clinicoId;
    }

    public String getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(String laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}

