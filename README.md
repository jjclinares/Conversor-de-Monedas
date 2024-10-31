💱 <h1> Este programa es una solución al Challenge de Oracle Next Education (Conversor de Moneda)</h1>

    🌍 Este proyecto es una aplicación de consola en Java que permite la conversión de diversas monedas utilizando la ExchangeRate-API. La interfaz gráfica está basada en JOptionPane para capturar la entrada del usuario y mostrar los resultados.
    
## 🛠️ Requisitos

  **Java 8 o superior**.
  Dependencia de **Gson** para deserializar la respuesta JSON de la API.
🌐 Conexión a Internet para acceder a la API de conversión.


🛠️ Tecnologías y conceptos utilizados

Este proyecto requiere conocimientos de Java, incluyendo:

    Programación orientada a objetos
    Consumo de API REST
    Manejo de excepciones
    Estructuras de datos (Map, List)
    Serialización de datos en JSON

📂 Estructura del Proyecto

El proyecto se estructura en las siguientes clases:

    Principal: Controla la interacción con el usuario, solicita los datos de entrada y llama a las funciones de conversión.
    APIConversion: Se encarga de hacer la solicitud a la API ExchangeRate y devuelve los resultados.
    MonedasDelMundo: Define las monedas disponibles para la conversión, organizadas por continente.
    BaseDeDatos: Gestiona el almacenamiento y recuperación de datos de conversión en formato JSON.

📈 Ejecución del Proyecto

1. Asegúrate de tener **Java** instalado en tu sistema.
2. Importa el proyecto en tu IDE preferido.
3. Añade la biblioteca **Gson** a tu proyecto (puedes descargarla desde [aquí](https://github.com/google/gson)).
4. Ejecuta la clase `Logica.java` para iniciar la aplicación.


💾 Ejemplos de Uso

    Conversión de Monedas:
        Selecciona el continente y la moneda de origen.
        Selecciona el continente y la moneda de destino.
        Ingresa el monto a convertir.
        La aplicación mostrará el resultado de la conversión junto con la tasa de cambio aplicada.

    Almacenamiento de Conversión:
        Las conversiones realizadas se almacenan en un archivo JSON (conversion_result.json) para referencia futura.
        

![image](https://github.com/user-attachments/assets/6b29363a-bcdd-4f14-9dd2-2d0bb084af01)

JSON: 
![image](https://github.com/user-attachments/assets/84822dab-3d0f-43ab-8bb6-8d8d9b380302)


🔧 Estatus del Proyecto

Finalizado :black_nib:

## 👤 Autor

Proyecto desarrollado por Jamer Linares.

