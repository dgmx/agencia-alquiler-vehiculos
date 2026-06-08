public abstract class Vehiculo implements Alquilable {
    protected String matricula;
    protected String marca;
    protected String modelo;
    protected int anio;
    protected double precioBasePorDia;
    protected boolean alquilado;

    public Vehiculo(String matricula, String marca, String modelo, int anio, double precioBasePorDia) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precioBasePorDia = precioBasePorDia;
        this.alquilado = false;
    }

    @Override
    public boolean isAlquilado() {
        return alquilado;
    }

    @Override
    public void alquilar() {
        if (alquilado) {
            throw new IllegalStateException("El vehículo " + matricula + " ya está alquilado.");
        }
        alquilado = true;
    }

    @Override
    public void devolver() {
        if (!alquilado) {
            throw new IllegalStateException("El vehículo " + matricula + " no está alquilado.");
        }
        alquilado = false;
    }

    @Override
    public String toString() {
        return marca + " " + modelo + " (" + anio + ") - Mat: " + matricula;
    }
}
