public class Main {
    public static void main(String[] args) {
        AgenciaAlquiler agencia = new AgenciaAlquiler();

        agencia.agregarVehiculo(new Auto("ABC123", "Toyota", "Corolla", 2020, 50, false));
        agencia.agregarVehiculo(new Auto("XYZ789", "BMW", "X5", 2023, 120, true));
        agencia.agregarVehiculo(new Auto("DEF456", "Honda", "Civic", 2021, 55, false));
        agencia.agregarVehiculo(new Moto("MOT001", "Yamaha", "MT-07", 2022, 35));
        agencia.agregarVehiculo(new Moto("MOT002", "Kawasaki", "Ninja", 2023, 40));

        agencia.listarFlota();

        int dias = 5;
        System.out.println("Ingreso total alquilando toda la flota por " + dias + " días:");
        System.out.println("$" + String.format("%.2f", agencia.calcularIngresoTotal(dias)));

        System.out.println();

        dias = 10;
        System.out.println("Ingreso total alquilando toda la flota por " + dias + " días:");
        System.out.println("$" + String.format("%.2f", agencia.calcularIngresoTotal(dias)));
    }
}
