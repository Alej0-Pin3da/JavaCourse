/**
 * ARCHIVO 02: Estructura y conceptos de memoria en Java
 * 
 * CONCEPTOS EXPLICADOS:
 * - Variables estáticas vs de instancia
 * - Pool de Strings vs creación explícita
 * - Stack vs Heap en memoria
 * - Autoboxing y unboxing
 * - Referencias vs objetos
 * - Comparación de objetos
 */
public class EstructuraBasica {
    
    /*
     * CONCEPTO 1: VARIABLES DE CLASE (STATIC)
     * 
     * - static: Pertenece a la clase, no a instancias específicas
     * - final: Es una constante (no puede cambiar después de inicialización)
     * - private: Solo accesible dentro de esta clase
     * 
     * Las variables static se almacenan en el área de métodos de la JVM
     * y son compartidas por todas las instancias de la clase.
     */
    private static final String MENSAJE = "Repaso Java"; // Constante de clase
    private static int contador = 0; // Variable de clase (compartida)
    
    /*
     * CONCEPTO 2: ARGUMENTOS DE LÍNEA DE COMANDOS
     * 
     * args[] es un array de Strings que contiene los parámetros
     * pasados al programa al ejecutarlo:
     * 
     * java EstructuraBasica param1 param2
     * args[0] = "param1"
     * args[1] = "param2"
     * args.length = 2
     */
    public static void main(String[] args) {
        System.out.println("=== CONCEPTOS DE MEMORIA Y REFERENCIAS ===\n");
        
        // Demostración de argumentos
        if (args.length > 0) {
            System.out.println("Argumento recibido: " + args[0]);
        } else {
            System.out.println("No se recibieron argumentos");
        }
        
        /*
         * CONCEPTO 3: POOL DE STRINGS (STRING INTERNING)
         * 
         * Java optimiza el uso de memoria con un "pool" de strings.
         * Los strings literales se almacenan en una área especial 
         * y se reutilizan.
         */
        String texto1 = new String("Texto"); // Crea NUEVO objeto en heap
        String texto2 = "Texto";             // Usa/crea en pool de strings
        String texto3 = "Texto";             // Reutiliza del pool
        
        System.out.println("\n--- POOL DE STRINGS ---");
        System.out.println("texto1 == texto2: " + (texto1 == texto2)); // false (diferentes objetos)
        System.out.println("texto2 == texto3: " + (texto2 == texto3)); // true (mismo objeto del pool)
        System.out.println("texto1.equals(texto2): " + texto1.equals(texto2)); // true (mismo contenido)
        
        /*
         * CONCEPTO 4: STACK VS HEAP
         * 
         * STACK (Pila):
         * - Variables locales (primitivas)
         * - Referencias a objetos
         * - Rápido acceso
         * - Limitado en tamaño
         * - Se limpia automáticamente al salir del scope
         * 
         * HEAP (Montículo):
         * - Objetos
         * - Arrays
         * - Más lento que stack
         * - Mayor tamaño
         * - Limpiado por Garbage Collector
         */
        
        int primitivo = 42;        // STACK: valor directo
        Integer objetoInteger = 42; // HEAP: objeto Integer (autoboxing)
        
        System.out.println("\n--- STACK VS HEAP ---");
        System.out.println("Primitivo (stack): " + primitivo);
        System.out.println("Objeto (heap): " + objetoInteger);
        
        /*
         * CONCEPTO 5: AUTOBOXING Y UNBOXING
         * 
         * AUTOBOXING: primitivo → objeto wrapper automáticamente
         * UNBOXING: objeto wrapper → primitivo automáticamente
         * 
         * Ocurre automáticamente desde Java 5
         */
        
        // Autoboxing (primitivo a objeto)
        Integer auto1 = 100;      // Equivale a: Integer auto1 = Integer.valueOf(100);
        Double auto2 = 3.14;      // Equivale a: Double auto2 = Double.valueOf(3.14);
        
        // Unboxing (objeto a primitivo)
        int valor = auto1;        // Equivale a: int valor = auto1.intValue();
        double decimal = auto2;   // Equivale a: double decimal = auto2.doubleValue();
        
        System.out.println("\n--- AUTOBOXING/UNBOXING ---");
        System.out.println("Autoboxing Integer: " + auto1);
        System.out.println("Unboxing a int: " + valor);
        
        /*
         * CONCEPTO 6: CUIDADO CON AUTOBOXING
         * 
         * Problemas potenciales:
         * 1. Performance: crear objetos es más lento
         * 2. NullPointerException: objetos wrapper pueden ser null
         * 3. Comparación con == puede fallar
         */
        
        Integer a = 127;  // Pool de integers (-128 a 127)
        Integer b = 127;  // Mismo objeto del pool
        Integer c = 128;  // Nuevo objeto
        Integer d = 128;  // Otro nuevo objeto
        
        System.out.println("\n--- CUIDADOS CON INTEGER POOL ---");
        System.out.println("127 == 127: " + (a == b));     // true (pool)
        System.out.println("128 == 128: " + (c == d));     // false (objetos diferentes)
        System.out.println("128.equals(128): " + c.equals(d)); // true (contenido)
        
        // Llamada a método estático
        mostrarInfo();
    }
    
    /*
     * CONCEPTO 7: MÉTODOS ESTÁTICOS
     * 
     * - No requieren instancia de la clase para ser llamados
     * - Solo pueden acceder directamente a miembros static
     * - Útiles para utilidades y funciones auxiliares
     * - Se cargan cuando se carga la clase por primera vez
     */
    private static void mostrarInfo() {
        System.out.println("\n--- INFORMACIÓN DE CLASE ---");
        System.out.printf("Mensaje: %s, Contador: %d\n", MENSAJE, ++contador);
        
        /*
         * CONCEPTO 8: MIEMBROS STATIC COMPARTIDOS
         * 
         * El contador es compartido entre todas las llamadas
         * porque es una variable de clase (static).
         * Cada llamada a este método incrementa el mismo contador.
         */
        System.out.println("Nota: contador se comparte entre todas las ejecuciones");
    }
}
