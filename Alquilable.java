public interface Alquilable {
    double calcularPrecioAlquiler(int dias);
    boolean isAlquilado();
    void alquilar();
    void devolver();
}
