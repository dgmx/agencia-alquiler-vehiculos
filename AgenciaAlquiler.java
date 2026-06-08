import java.util.ArrayList;
import java.util.List;

public class AgenciaAlquiler {
    private List<Vehiculo> vehiculos;

    public AgenciaAlquiler() {
        vehiculos = new ArrayList<>();
    }

    public void agregarVehiculo(Vehiculo v) {
        vehiculos.add(v);
    }

    public void listarFlota() {
        System.out.println("=== FLOTA COMPLETA ===");
        for (int i = 0; i < vehiculos.size(); i++) {
            System.out.println((i + 1) + ". " + vehiculos.get(i));
        }
        System.out.println("Total de vehículos: " + vehiculos.size());
        System.out.println();
    }

    public double calcularIngresoTotal(int dias) {
        double total = 0;
        for (Vehiculo v : vehiculos) {
            total += v.calcularPrecioAlquiler(dias);
        }
        return total;
    }
}
