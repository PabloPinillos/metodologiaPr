public abstract class IGestorNaves {

    public abstract Nave crearNave(String numeroRegistro, Cliente propietario, SistemaPropulsion[] sistemasPropulsion, int numeroTripulantes, SistemaDefensa[] sistemasDefensa);

    public boolean agregarSistemaDefensa(Nave nave, SistemaDefensa sistemaDefensa) {
        return nave.agregarSistemaDefensa(sistemaDefensa);
    }

    public boolean reemplazarSistemaDefensa(Nave nave, int index, SistemaDefensa sistemaDefensa) {
        return nave.reemplazarSistemaDefensa(index, sistemaDefensa);
    }

    public boolean eliminarSistemaDefensa(Nave nave, int index) {
        return nave.eliminarSistemaDefensa(index);
    }

    public boolean agregarSistemaPropulsion(Nave nave, SistemaPropulsion sistemaPropulsion) {
        return nave.agregarSistemaPropulsion(sistemaPropulsion);
    }

    public boolean reemplazarSistemaPropulsion(Nave nave, int index, SistemaPropulsion sistemaPropulsion) {
        return nave.reemplazarSistemaPropulsion(index, sistemaPropulsion);
    }

    public void eliminarSistemaPropulsionSecundario(Nave nave) {
        nave.eliminarSistemaPropulsionSecundario();
    }

}