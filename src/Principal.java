//Controla el flujo principal de la aplicación y la interacción con el usuario.
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {

            // Primer menú: seleccionar continente y moneda inicial
            System.out.println("Seleccione el continente de la moneda de Origen");
            mostrarMenuContinentes();
            int opcionContinente1 = scanner.nextInt();
            if (opcionContinente1 == 0) {
                System.out.println("Saliendo de la Sesión...");
                return;
            }
            String currency1 = seleccionarMoneda(opcionContinente1, scanner);
            if (currency1 == null) {
                System.out.println("Selección de moneda no válida.");
                return;
            }

            // Segundo menú: seleccionar continente y moneda destino
            System.out.println("Seleccione el continente de la moneda de Destino:");
            mostrarMenuContinentes();
            int opcionContinente2 = scanner.nextInt();
            if (opcionContinente2 == 0) {
                System.out.println("Saliendo de la Sesión...");
                return;
            }
            String currency2 = seleccionarMoneda(opcionContinente2, scanner);
            if (currency2 == null) {
                System.out.println("Selección de moneda no válida.");
                return;
            }

            // Solicitar cantidad a convertir
            System.out.print("Ingrese la cantidad a convertir: ");
            float amountToChange = scanner.nextFloat();
            // Limpiar el salto de línea
            scanner.nextLine();

            // Realizar la conversión
            APIConversion.apiConversion(currency1, currency2, amountToChange);

            System.out.print("¿Desea realizar otra conversión? (s/n): ");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        }
        // Mensaje de finalización de sesión
        System.out.println("Sesión finalizada.");
    }

    private static void mostrarMenuContinentes() {
        System.out.println("1. AMERICA");
        System.out.println("2. EUROPA");
        System.out.println("3. ASIA");
        System.out.println("4. AFRICA");
        System.out.println("5. OCEANIA");
        System.out.println("0. Salir");
    }

    private static String seleccionarMoneda(int opcionContinente, Scanner scanner) {
        Map<String, String> paises = MonedasDelMundo.obtenerPaisesPorContinente(opcionContinente);
        if (paises != null) {
            System.out.println("Seleccione el país:");
            int i = 1;
            for (Map.Entry<String, String> entry : paises.entrySet()) {
                System.out.println(i + ". " + entry.getKey() + " (" + entry.getValue() + ")");
                i++;
            }
            int opcionPais = scanner.nextInt();
            String paisSeleccionado = (String) paises.keySet().toArray()[opcionPais - 1];
            return paises.get(paisSeleccionado); // Devuelve solo el código de la moneda
        } else {
            return null;
        }
    }
}

