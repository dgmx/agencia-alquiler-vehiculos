public class Auto extends Vehiculo {
    private boolean esDeLujo;

    public Auto(String matricula, String marca, String modelo, int anio, double precioBasePorDia, boolean esDeLujo) {
        super(matricula, marca, modelo, anio, precioBasePorDia);
        this.esDeLujo = esDeLujo;
    }

    @Override
    public double calcularPrecioAlquiler(int dias) {
        double precio = precioBasePorDia * dias;
        if (esDeLujo) {
            precio *= 1.5;
        }
        return precio;
    }

    @Override
    public String toString() {
        return (esDeLujo ? "Auto de lujo" : "Auto") + " - " + super.toString();
    }
}
