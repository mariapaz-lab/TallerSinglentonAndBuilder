package Main;

import App.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) {

        ConsecutiveFactura a = ConsecutiveFactura.getInstancia();
        ConsecutiveFactura b = ConsecutiveFactura.getInstancia();

        System.out.println("¿a == b?: " + (a == b));
        System.out.println("Siguiente factura: " + a.siguiente());
        System.out.println("Siguiente factura: " + b.siguiente());


        // Esto NO compila porque el constructor es private:
        // ConsecutivoFactura c = new ConsecutivoFactura();


        Cliente cliente = new Cliente("Nikol", "123456789");
        Pelicula pelicula = new Pelicula("Avengers", "Acción");
        Funcion funcion = new Funcion(pelicula, "7:00 PM");
        Asiento asiento1 = new Asiento("A", "1");
        Asiento asiento2 = new Asiento("A", "2");
        Asiento asiento3 = new Asiento("A", "3");
        Combo combo = new Combo("Combo Grande", 25000);


        Compra compraMinima = new Compra.Builder()
                .conCliente(cliente)
                .conFuncion(funcion)
                .conAsientos(List.of(asiento1))
                .build();

        System.out.println("Compra mínima creada correctamente.");


        Compra compraCompleta = new Compra.Builder()
                .conCliente(cliente)
                .conFuncion(funcion)
                .conAsientos(List.of(asiento1, asiento2, asiento3))
                .conCombo(combo)
                .conPuntosRedimidos(100)
                .build();

        System.out.println("Compra completa creada correctamente.");


        // Compra compra1 = new Compra();
        // No funciona porque necesita el Builder.


        Compra compra2 = new Compra.Builder()
                // Acá lanza una excepción porque es necesario cliente
                .conFuncion(funcion)
                .conAsientos(List.of(asiento1, asiento2, asiento3))
                .conCombo(combo)
                .conPuntosRedimidos(100)
                .build();


        // Prueba: pedir 1000 números desde 10 hilos

        Set<Integer> numeros = ConcurrentHashMap.newKeySet();
        List<Thread> hilos = new ArrayList<>();

        ConsecutiveFactura consecutivoFactura =
                ConsecutiveFactura.getInstancia();

        for (int i = 0; i < 10; i++) {

            Thread hilo = new Thread(() -> {

                for (int j = 0; j < 100; j++) {
                    numeros.add(consecutivoFactura.siguiente());
                }

            });

            hilos.add(hilo);
            hilo.start();
        }

        for (Thread hilo : hilos) {

            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println(
                "¿Hay números repetidos?: "
                        + (numeros.size() < 1000 ? "Sí" : "No")
        );
    }
}
