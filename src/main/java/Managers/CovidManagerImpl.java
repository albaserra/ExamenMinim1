package Managers;

import java.util.*;

import Entities.Laboratorio;
import Entities.Muestra;
import Entities.Paciente;
import Entities.ValueObjects.Informe;
import org.apache.log4j.Logger;

public class CovidManagerImpl implements CovidManager {

    List<Laboratorio> laboratorios;
    Queue<Muestra> muestras;
    List<Paciente> pacientes;
    List<Informe> informes;

    public CovidManagerImpl(List<Laboratorio> laboratorios, Queue<Muestra> muestras, List<Paciente> pacientes, List<Informe> informes) {
        this.laboratorios = laboratorios;
        this.muestras = muestras;
        this.pacientes = pacientes;
        this.informes = informes;
    }

    private static CovidManager instance;

    final static Logger logger = Logger.getLogger(CovidManagerImpl.class);

    public static CovidManager getInstance(){
        if (instance==null) instance = new CovidManagerImpl();
        return instance;
    }

    public int numPacientes() {
        return this.pacientes.size();
    }

    public int numMuestras() {
        return this.muestras.size();
    }

    public int numLaboratorios() {
        return this.laboratorios.size();
    }

    public int numInformes() {
        return this.informes.size();
    }

    public int size(){
        int ret = this.muestras.size();
        logger.info("size " + ret);
        return ret;
    }

    @Override
    public void nuevoPaciente(String pacienteId, String nombre, String apellidos, String fecha, String valoracion) {
        logger.info("Paciente añadido con la información: " + pacienteId + ", " + nombre + ", " + apellidos + ", " + fecha + ", " + valoracion);
        Paciente paciente = new Paciente(pacienteId, nombre, apellidos, fecha, valoracion);
        this.pacientes.add(paciente);
    }

    @Override
    public void envioLaboratorio(String laboratorioId) {
        logger.info("El laboratorio de destino es el siguiente: " + laboratorioId);

        Muestra muestra = this.muestras.poll();
        this.muestras.add(new Muestra(muestra.getMuestraId(), muestra.getPacienteId(), muestra.getClinicoId(), laboratorioId, muestra.getFecha()));
    }

    @Override
    public Informe procesoMuestra(String comentario, int resultado) {
        Muestra muestra = this.muestras.poll();
        String muestraid = muestra.getMuestraId();
        Informe informe = new Informe(resultado, comentario, muestraid);
        return informe;
    }

    public List<Informe> muestrasProcesadas(String muestra, String comentario, int resultado) {
        this.informes.add(new Informe(resultado, comentario, muestra));
        return informes;
    }

    public int nuevoLaboratorio(String laboratorioId, String nombre) {
        logger.info("Nuevo laboratorio con la información: " + laboratorioId + ", " + nombre);
        Laboratorio lab = new Laboratorio(laboratorioId, nombre);
        this.laboratorios.add(lab);
        return laboratorios.size();
    }
}

