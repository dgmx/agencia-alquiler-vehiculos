# Examen de Programación Orientada a Objetos

## Sistema de Gestión para una Agencia de Alquiler de Vehículos

Se desea desarrollar un sistema en Java para gestionar los vehículos de una
agencia de alquiler. La agencia ofrece dos tipos de vehículos: autos y motos.
Cada vehículo tiene una matrícula, marca, modelo, año de fabricación y un
precio base por día de alquiler.

El sistema debe permitir:

- Registrar que un vehículo ha sido alquilado o devuelto.
- Consultar si un vehículo está actualmente alquilado.
- Calcular el costo total de alquiler de un vehículo para una cantidad
  determinada de días. Las reglas de negocio son las siguientes:
  - Si el vehículo es un auto de lujo, el precio final tiene un recargo
    del 50 % sobre el precio base.
  - Si el vehículo es una moto y se alquila por 7 o más días, se aplica
    un descuento del 10 % sobre el precio base.
- Gestionar una flota de vehículos pudiendo agregar nuevos vehículos,
  listar todos los vehículos registrados y calcular el ingreso total que
  generaría alquilar toda la flota por una cantidad dada de días.

Se valorará el uso correcto de interfaces, clases abstractas, herencia,
polimorfismo y colecciones.

Escriba el código Java completo necesario para implementar el sistema
descrito, incluyendo una clase principal con un método `main` que demuestre
su funcionamiento con al menos cinco vehículos de distintos tipos.

### Diagrama UML

```mermaid
classDiagram
    class Alquilable {
        <<interface>>
        +calcularPrecioAlquiler(dias: int) double
        +isAlquilado() boolean
        +alquilar() void
        +devolver() void
    }

    class Vehiculo {
        <<abstract>>
        #matricula: String
        #marca: String
        #modelo: String
        #anio: int
        #precioBasePorDia: double
        #alquilado: boolean
        +Vehiculo(matricula, marca, modelo, anio, precioBase)
        +isAlquilado() boolean
        +alquilar() void
        +devolver() void
        +toString() String
        +calcularPrecioAlquiler(dias: int)* double
    }

    class Auto {
        -esDeLujo: boolean
        +Auto(matricula, marca, modelo, anio, precioBase, esDeLujo)
        +calcularPrecioAlquiler(dias: int) double
    }

    class Moto {
        +Moto(matricula, marca, modelo, anio, precioBase)
        +calcularPrecioAlquiler(dias: int) double
    }

    class AgenciaAlquiler {
        -vehiculos: ArrayList~Vehiculo~
        +agregarVehiculo(v: Vehiculo) void
        +listarFlota() void
        +calcularIngresoTotal(dias: int) double
    }

    Alquilable <|.. Vehiculo
    Vehiculo  <|-- Auto
    Vehiculo  <|-- Moto
    AgenciaAlquiler "1" --> "*" Vehiculo
```

---

# Sistema de Gestión de Vehículos — Agencia de Alquiler

## Enunciado

Se requiere modelar un sistema para una agencia de alquiler de vehículos.
La agencia debe poder gestionar distintos tipos de vehículos (autos y motos)
y calcular el costo de alquiler según el tipo de vehículo y la cantidad de días.

### Requisitos

1. **Interface `Alquilable`**: Define el contrato que todo vehículo alquilable debe cumplir:
   - `double calcularPrecioAlquiler(int dias)` — calcula el costo total del alquiler.
   - `boolean isAlquilado()` — indica si el vehículo está actualmente alquilado.
   - `void alquilar()` / `void devolver()` — cambian el estado del vehículo.

2. **Clase abstracta `Vehiculo`**: Implementa `Alquilable` y agrupa la lógica común:
   - Atributos: `matricula`, `marca`, `modelo`, `anio`, `precioBasePorDia`, `alquilado`.
   - Implementa `isAlquilado()`, `alquilar()`, `devolver()`.
   - Declara el método abstracto `calcularPrecioAlquiler(int dias)`.

3. **Clases concretas**:
   - `Auto`: Sobrescribe `calcularPrecioAlquiler` aplicando un recargo del 50% sobre el precio base si el auto es de lujo.
   - `Moto`: Sobrescribe `calcularPrecioAlquiler` aplicando un descuento del 10% si alquila por 7 o más días.

4. **Clase `AgenciaAlquiler`**: Gestiona una flota de vehículos usando un `ArrayList<Vehiculo>`.
   - Permite agregar vehículos, listar la flota completa, calcular el ingreso total
     simulando un alquiler de todos los vehículos por `n` días.

5. **Clase `Main`**: Demuestra el funcionamiento creando varios vehículos,
   agregándolos a la agencia y mostrando los resultados.

---

## Diagrama UML (Mermaid)

```mermaid
classDiagram
    class Alquilable {
        <<interface>>
        +calcularPrecioAlquiler(dias: int) double
        +isAlquilado() boolean
        +alquilar() void
        +devolver() void
    }

    class Vehiculo {
        <<abstract>>
        #matricula: String
        #marca: String
        #modelo: String
        #anio: int
        #precioBasePorDia: double
        #alquilado: boolean
        +Vehiculo(matricula, marca, modelo, anio, precioBase)
        +isAlquilado() boolean
        +alquilar() void
        +devolver() void
        +toString() String
        +calcularPrecioAlquiler(dias: int)* double
    }

    class Auto {
        -esDeLujo: boolean
        +Auto(matricula, marca, modelo, anio, precioBase, esDeLujo)
        +calcularPrecioAlquiler(dias: int) double
    }

    class Moto {
        +Moto(matricula, marca, modelo, anio, precioBase)
        +calcularPrecioAlquiler(dias: int) double
    }

    class AgenciaAlquiler {
        -vehiculos: ArrayList~Vehiculo~
        +agregarVehiculo(v: Vehiculo) void
        +listarFlota() void
        +calcularIngresoTotal(dias: int) double
    }

    Alquilable <|.. Vehiculo  : implements
    Vehiculo  <|-- Auto       : extends
    Vehiculo  <|-- Moto       : extends
    AgenciaAlquiler "1" --> "*" Vehiculo : gestiona
```
