//Define los continentes y monedas.
import java.util.HashMap;
import java.util.Map;

public class MonedasDelMundo{

    public static Map<String, String> america = new HashMap<>();
    public static Map<String, String> europa = new HashMap<>();
    public static Map<String, String> asia = new HashMap<>();
    public static Map<String, String> africa = new HashMap<>();
    public static Map<String, String> oceania = new HashMap<>();

    static {
        america.put("Argentina", "ARS");
        america.put("Brasil", "BRL");
        america.put("Canadá", "CAD");
        america.put("Chile", "CLP");
        america.put("Colombia", "COP");
        america.put("Estados Unidos", "USD");
        america.put("México", "MXN");
        america.put("Perú", "PEN");
        america.put("Uruguay", "UYU");


        europa.put("Euro zona", "EUR");
        europa.put("Dinamarca", "DKK");
        europa.put("Noruega", "NOK");
        europa.put("Reino Unido", "GBP");
        europa.put("Suecia", "SEK");
        europa.put("Suiza", "CHF");


        asia.put("China", "CNY");
        asia.put("Corea del Sur", "KRW");
        asia.put("Filipinas", "PHP");
        asia.put("India", "INR");
        asia.put("Indonesia", "IDR");
        asia.put("Japón", "JPY");
        asia.put("Malasia", "MYR");
        asia.put("Tailandia", "THB");
        asia.put("Vietnam", "VND");

        africa.put("Egipto", "EGP");
        africa.put("Etiopía", "ETB");
        africa.put("Ghana", "GHS");
        africa.put("Kenia", "KES");
        africa.put("Marruecos", "MAD");
        africa.put("Nigeria", "NGN");
        africa.put("Sudáfrica", "ZAR");
        africa.put("Túnez", "TND");
        africa.put("Uganda", "UGX");


        oceania.put("Australia", "AUD");
        oceania.put("Fiyi", "FJD");
        oceania.put("Islas Salomón", "SBD");
        oceania.put("Kiribati", "AUD");
        oceania.put("Nueva Zelanda", "NZD");
        oceania.put("Papúa Nueva Guinea", "PGK");
        oceania.put("Samoa", "WST");
        oceania.put("Tonga", "TOP");
        oceania.put("Vanuatu", "VUV");
    }

    public static Map<String, String> obtenerPaisesPorContinente(int opcionContinente) {
        return switch (opcionContinente) {
            case 1 -> america;
            case 2 -> europa;
            case 3 -> asia;
            case 4 -> africa;
            case 5 -> oceania;
            default -> null;
        };
    }

    public static void inicializarDatos() {

    }
}


