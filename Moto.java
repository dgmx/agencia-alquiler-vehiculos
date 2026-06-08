public class Moto extends Vehiculo {
    public Moto(String matricula, String marca, String modelo, int anio, double precioBasePorDia) {
        super(matricula, marca, modelo, anio, precioBasePorDia);
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        double precio = precioBasePorDia * dias;
        if (dias >= 7) {
            precio *= 0.9;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "Moto - " + super.toString();
    }
}
