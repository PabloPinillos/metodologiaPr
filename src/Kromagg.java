
import java.util.*;

/**
 *
 */
public class Kromagg extends Cliente {

    /**
     *
     */
    private boolean licenciaFE;

    /**
     * Constructor Kromagg
     */
    public Kromagg(String[] params) {
        super(params[0], params[1], params[2], params[3], params[4], params[5], params[6]);
        licenciaFE = false;
    }


    /**
     * @return licenciaFE
     */
    public boolean tieneLicenciaFE() {
        return licenciaFE;
    }

    /**
     * @param tieneLicencia
     */
    public void setLicenciaFE(boolean tieneLicencia) {
        licenciaFE = tieneLicencia;
    }

}