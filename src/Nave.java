public abstract class Nave {

    private String numeroRegistro;
    private Cliente propietario;
    private SistemaPropulsion[] sistemasPropulsion = new SistemaPropulsion[2];
    private int numeroTripulantes;
    private SistemaDefensa[] sistemasDefensa;
    private final int maxSistemasDefensa;

    /**
     * @param numeroRegistro:     String que identifica a la Nave
     * @param propietario:        Cliente que posee la Nave
     * @param sistemasPropulsion: Array de SistemaPropulsion que tiene la Nave (min: 1, max: 2)
     * @param numeroTripulantes:  int que define el número de tripulantes que necesita la Nave
     * @param sistemasDefensa:    Array de SistemaDefensa que tiene la Nave (min: 1, max: maxSistemasDefensa)
     * @param maxSistemasDefensa: int que define el número máximo de sistemas de defensa que puede tener la Nave
     */
    public Nave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa, int maxSistemasDefensa) {
        this.numeroRegistro = numeroRegistro;
        this.propietario = propietario;
        this.sistemasPropulsion[0] = sistemasPropulsion[0];
        if (sistemasPropulsion.length > 1) {
            this.sistemasPropulsion[1] = sistemasPropulsion[1];
        }
        this.numeroTripulantes = numeroTripulantes;
        this.maxSistemasDefensa = maxSistemasDefensa;
        this.sistemasDefensa = new SistemaDefensa[maxSistemasDefensa];
        this.sistemasDefensa[0] = sistemasDefensa[0];
        for (int i = 1; i < Math.min(maxSistemasDefensa, sistemasDefensa.length); i++) {
            this.sistemasDefensa[i] = sistemasDefensa[i];
        }
    }

    public Nave() {

    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public SistemaPropulsion[] getSistemasPropulsion() {
        return sistemasPropulsion;
    }

    public int getNumeroTripulantes() {
        return numeroTripulantes;
    }

    public SistemaDefensa[] getSistemasDefensa() {
        return sistemasDefensa;
    }

    public int getMaxSistemasDefensa() {
        return maxSistemasDefensa;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public void setNumeroTripulantes(int numeroTripulantes) {
        this.numeroTripulantes = numeroTripulantes;
    }


    /**
     * Si hay hueco, agrega el SistemaDefensa dado a los sistemas de defensa de la nave
     *
     * @param sistemaDefensa a agregar
     */
    public boolean agregarSistemaDefensa(SistemaDefensa sistemaDefensa) {
        int i = 0;
        while (i < maxSistemasDefensa && sistemasDefensa[i] != null) {
            i++;
        }
        if (i < maxSistemasDefensa) {
            sistemasDefensa[i] = sistemaDefensa;
            return true;
        }
        return false;
    }

    /**
     * Elimina el sistema de defensa de la nave colocada en la posición dada (min: 1, max: maxSistemasDefensa - 1)
     *
     * @param index del sistema de defensa a eliminar
     */
    public boolean eliminarSistemaDefensa(int index) {
        if (0 <= index && index < maxSistemasDefensa && numeroSistemasDefensa() > 1) {
            for (int i = index; i < maxSistemasDefensa - 1; i++) {
                sistemasDefensa[i] = sistemasDefensa[i + 1];
            }
            sistemasDefensa[maxSistemasDefensa - 1] = null;
            return true;
        }
        return false;
    }

    public boolean reemplazarSistemaDefensa(int index, SistemaDefensa sistemaDefensa) {
        if (index < maxSistemasDefensa) {
            sistemasDefensa[index] = sistemaDefensa;
            return true;
        }
        return false;
    }

    /**
     * @return numero sistemas de defensa que tiene la nave
     */
    public int numeroSistemasDefensa() {
        int count = 0;
        for (SistemaDefensa sd : sistemasDefensa) {
            if (sd != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Si hay hueco, agrega el SistemaPropulsion dado a los sistemas de propulsion de la Nave
     *
     * @param sistemaPropulsion a agregar
     */
    public boolean agregarSistemaPropulsion(SistemaPropulsion sistemaPropulsion) {
        if (sistemasPropulsion[1] == null) {
            sistemasPropulsion[1] = sistemaPropulsion;
            return true;
        }
        return false;
    }

    /**
     * Elimina el sistema de propulsion secundario de la Nave
     */
    public void eliminarSistemaPropulsionSecundario() {
        sistemasPropulsion[1] = null;
    }

    public boolean reemplazarSistemaPropulsion(int index, SistemaPropulsion sistemaPropulsion) {
        if (index < sistemasPropulsion.length) {
            sistemasPropulsion[index] = sistemaPropulsion;
            return true;
        }
        return false;
    }

    /**
     * @return Suma de absorcion de daño total de la nave
     */
    public float getTotalAbsorcionDano() {
        float total = 0;
        for (SistemaDefensa sistemaDefensa : sistemasDefensa) {
            if (sistemaDefensa != null) {
                total += sistemaDefensa.getAbsorcionDano();
            }
        }
        return total;
    }

    /**
     * @return Suma de potencia total de las armas que hay en la Nave
     */
    public abstract float getTotalPotenciaArmas();

}