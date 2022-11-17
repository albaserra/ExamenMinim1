package Services;

import Entities.Laboratorio;
import Entities.Paciente;
import Entities.ValueObjects.Informe;
import Managers.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Api(value = "/covid", description = "Endpoint to Covid Service")
@Path("/covid")

public class CovidService {

    // ----------------------------------------------------------------------------------------------------

    private CovidManager cm;

    public CovidService() {
        this.cm = CovidManagerImpl.getInstance();
        if (cm.size()==0) {
            this.cm.nuevoPaciente("001", "Victor", "Fernandez", "10/10/2001", "A");
            this.cm.nuevoPaciente("002", "Marc", "Moran", "28/10/2001", "B");
            this.cm.nuevoPaciente("003", "Eloi", "Moncho", "28/08/2001", "C");

            this.cm.nuevoLaboratorio("L01", "Laboratori de Castelldefels");
            this.cm.nuevoLaboratorio("L02", "Laboratori de Gavà");
            this.cm.nuevoLaboratorio("L03", "Laboratori de Vilanova");
        }
    }

    // ----------------------------------------------------------------------------------------------------

    @POST
    @ApiOperation(value = "Crear un paciente", notes = "-")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "¡Creado correctamente!"),
            @ApiResponse(code = 404, message = "Fallo en la creación.")
    })
    @Path("/usuario")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevoPaciente(Paciente paciente) {
        this.cm.nuevoPaciente(paciente.getPacienteId(), paciente.getNombre(), paciente.getApellidos(), paciente.getFechaNacimiento(), paciente.getValoracion());

        if (this.cm.numPacientes() == 4){
            return Response.status(201).build();
        }
        else{
            return Response.status(404).build();
        }
    }

    @POST
    @ApiOperation(value = "Enviar una muestra a un laboratorio", notes = "-")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "¡Muestra enviada correctamente!"),
            @ApiResponse(code = 404, message = "Fallo en el envío de la muestra.")
    })
    @Path("/usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response envioLaboratorio() {
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "Procesar una muestra", notes = "-")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Muestra procesada correctamente", response= Informe.class),
            @ApiResponse(code = 500, message = "Fallo")

    })
    @Path("/tienda")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response procesarMuestras(String comentario, int resultado) {
        Informe informe = this.cm.procesoMuestra(comentario, resultado);
        return Response.status(201).entity(informe).build();
    }

    @GET
    @ApiOperation(value = "Obtener una lista de muestras procesadas", notes = "-")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Lista creada correctamente.", response = Informe.class, responseContainer="List")
    })
    @Path("/tienda")
    @Produces(MediaType.APPLICATION_JSON)
    public Response muestrasProcesadas(String muestra, String comentario, int resultado) {
        List<Informe> muestrasProcesadas = this.cm.muestrasProcesadas(muestra, comentario, resultado);
        GenericEntity<List<Informe>> adquisiciones = new GenericEntity<List<Informe>>(muestrasProcesadas) {};
        return Response.status(201).entity(adquisiciones).build(); // OK.
    }

    @POST
    @ApiOperation(value = "Nuevo Laboratorio", notes = "-")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "¡Laboratorio creado!"),
            @ApiResponse(code = 404, message = "No se creado el nuevo laboratorio.")
    })
    @Path("/tienda/{objectId}/{userId}")
    @Produces(MediaType.APPLICATION_JSON) // ESTO
    public Response nuevoLaboratorio(String laboratorioId, String nombre) {

        if (this.cm.numLaboratorios() == 3){
            return Response.status(201).build();
        }
        else{
            return Response.status(404).build();
        }
    }
}
