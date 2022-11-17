package Entities;

public class Laboratorio {
    String laboratorioId;
    String nombre;

    public Laboratorio(String laboratorioId, String nombre) {
        this.laboratorioId = laboratorioId;
        this.nombre = nombre;
    }

    public String getLaboratorioId() {
        return laboratorioId;
    }

    public void setLaboratorioId(String laboratorioId) {
        this.laboratorioId = laboratorioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}