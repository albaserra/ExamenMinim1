package Managers;

import Entities.Muestra;
import Entities.ValueObjects.Informe;

import java.util.List;

public interface CovidManager {

    public void nuevoPaciente(String pacienteId, String nombre, String apellidos, String fecha, String valoracion);

    public void envioLaboratorio(String laboratorioId);
    public Informe procesoMuestra(String comentario, int resultado);
    public List<Informe> muestrasProcesadas(String muestra, String comentario, int resultado);
    public int nuevoLaboratorio(String laboratorioId, String nombre);
    public int numPacientes();

    public int numMuestras();
    public int numLaboratorios();
    public int numInformes();
    public int size();
}
