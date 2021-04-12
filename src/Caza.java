public class Caza extends Nave {

    private static Arma[] armas = new Arma[2];

    /**
     * Crea una nave normal, falta realizar setArmas o agregarArma
     */
    public Caza(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa, int maxSistemasDefensa) {
        super(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 1);
    }

    /**
     * @return suma potencia armas del caza
     */
    public float getTotalPotenciaArmas() {
        return armas[0].getPotencia() + armas[1].getPotencia();
    }

    public Arma[] getArmas() {
        return armas;
    }

    public static void setArmas(Arma[] armas) {
        for (int i = 0; i < this.armas.length; i++) {
            this.armas[i] = armas[i];
        }
    }

    /**
     * reemplaza el arma de la posicion dada por el arma dada
     *
     * @param index: int
     * @param arma:  Arma
     */
    public static void reemplazarArma(int index, Arma arma) {
        if (index < armas.length) {
            armas[index] = arma;
        }
    }

}
//hola