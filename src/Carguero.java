public class Carguero extends Nave {

    private float cargaMaxima;

    public Carguero(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa, float cargaMaxima) {
        super(numeroRegistro, propietario, sistemasPropulsion, numeroTripulantes, sistemasDefensa, 1);
        this.cargaMaxima = cargaMaxima;
    }

    public float getCargaMaxima() {
        return cargaMaxima;
    }

    public static void setCargaMaxima(float cargaMaxima) {
        this.cargaMaxima = cargaMaxima;
    }

    public float getTotalPotenciaArmas() {
        return 0.0f;
    }

}
//Hola