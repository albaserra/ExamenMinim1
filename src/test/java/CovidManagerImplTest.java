import Managers.CovidManager;
import Managers.CovidManagerImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import org.apache.log4j.Logger;

public class CovidManagerImplTest {

    final static Logger logger = Logger.getLogger(CovidManagerImpl.class);

    CovidManager cm;
    @Before
    public void setUp() {
        this.cm = new CovidManagerImpl();

        this.cm.nuevoPaciente("001", "Victor", "Fernandez", "10/10/2001", "A");
        this.cm.nuevoPaciente("002", "Marc", "Moran", "28/10/2001", "B");
        this.cm.nuevoPaciente("003", "Eloi", "Moncho", "28/08/2001", "C");

        this.cm.nuevoLaboratorio("L01", "Laboratori de Castelldefels");
        this.cm.nuevoLaboratorio("L02", "Laboratori de Gavà");
        this.cm.nuevoLaboratorio("L03", "Laboratori de Vilanova");

        this.cm.muestrasProcesadas("M01", "Debe hacer estar en cuarentena 15 días", 0);
        this.cm.muestrasProcesadas("M02", "Puede hacer vida normal", 1);
    }

    // ----------------------------------------------------------------------------------------------------

    @After
    public void tearDown() {
        this.cm = null;
    }

    // ----------------------------------------------------------------------------------------------------

    @Test
    public void testNuevoPaciente() {
        Assert.assertEquals(3, this.cm.numPacientes());
    }

    @Test
    public void testEnvioLaboratorio() {
    }

    @Test
    public void testProcesoMuestra() {
        Assert.assertEquals(2, this.cm.numInformes());
    }

    @Test
    public void testMuestraProcesada() {
        Assert.assertEquals(2, this.cm.numInformes());
    }

    @Test
    public void testNuevoLaboratorio() {
        Assert.assertEquals(2, this.cm.numLaboratorios());
    }
}
