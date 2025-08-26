/**
 * ARCHIVO 04: Repaso completo de tipos de datos y estructuras de control
 * 
 * CONCEPTOS EXPLICADOS:
 * - Los 8 tipos primitivos de Java y sus características
 * - Wrapper classes y autoboxing/unboxing
 * - Strings inmutables y StringBuilder
 * - Todas las estructuras de control (if, switch, loops)
 * - Arrays unidimensionales y multidimensionales
 * - Peculiaridades específicas de Java vs otros lenguajes
 * 
 * Este es el archivo MÁS IMPORTANTE de esta sección.
 */
public class RepasoSintaxis {
    
    public static void main(String[] args) {
        
        System.out.println("=== REPASO COMPLETO DE SINTAXIS JAVA ===\n");
        
        // ===========================================
        // SECCIÓN 1: TIPOS PRIMITIVOS EN JAVA
        // ===========================================
        
        /*
         * CONCEPTO 1: LOS 8 TIPOS PRIMITIVOS
         * 
         * Java tiene exactamente 8 tipos primitivos (no son objetos):
         * 
         * ENTEROS (4 tipos):
         * - byte:  8 bits,  rango -128 a 127
         * - short: 16 bits, rango -32,768 a 32,767  
         * - int:   32 bits, rango -2^31 a 2^31-1
         * - long:  64 bits, rango -2^63 a 2^63-1
         * 
         * PUNTO FLOTANTE (2 tipos):
         * - float:  32 bits, ~7 dígitos decimales precisos
         * - double: 64 bits, ~15 dígitos decimales precisos
         * 
         * OTROS (2 tipos):
         * - boolean: true o false (NO 0 y 1 como en C)
         * - char: 16 bits, Unicode UTF-16
         */
        
        System.out.println("--- TIPOS PRIMITIVOS ---");
        
        // Enteros con notación legible (Java 7+)
        byte b = 127;                    // Máximo valor para byte
        short s = 32_000;                // Underscore para legibilidad
        int i = 2_147_483_647;          // Máximo int
        long l = 9_223_372_036_854_775_807L; // L obligatorio para long
        
        // Punto flotante
        float f = 3.14159f;             // f obligatorio para float
        double d = 3.141592653589793;   // Tipo por defecto para decimales
        
        // Otros tipos
        boolean bool = true;            // Solo true/false, NO 0/1
        char c = 'A';                  // Comillas simples, Unicode
        
        // Mostrar valores y tamaños
        System.out.printf("byte: %d (%d bits)\n", b, Byte.SIZE);
        System.out.printf("short: %d (%d bits)\n", s, Short.SIZE);
        System.out.printf("int: %d (%d bits)\n", i, Integer.SIZE);
        System.out.printf("long: %d (%d bits)\n", l, Long.SIZE);
        System.out.printf("float: %.5f (%d bits)\n", f, Float.SIZE);
        System.out.printf("double: %.10f (%d bits)\n", d, Double.SIZE);
        System.out.printf("boolean: %b, char: %c (%d bits)\n", bool, c, Character.SIZE);
        
        /*
         * CONCEPTO 2: VALORES POR DEFECTO
         * 
         * Los campos de clase (no variables locales) tienen valores por defecto:
         * - Enteros: 0
         * - Flotantes: 0.0
         * - boolean: false  
         * - char: '\u0000' (carácter nulo)
         * - Referencias: null
         * 
         * IMPORTANTE: Las variables locales NO se inicializan automáticamente
         */
        
        // ===========================================
        // SECCIÓN 2: WRAPPER CLASSES Y BOXING
        // ===========================================
        
        /*
         * CONCEPTO 3: WRAPPER CLASSES
         * 
         * Cada tipo primitivo tiene una clase "wrapper" correspondiente:
         * byte    → Byte
         * short   → Short  
         * int     → Integer
         * long    → Long
         * float   → Float
         * double  → Double
         * boolean → Boolean
         * char    → Character
         * 
         * ¿Por qué existen?
         * - Las colecciones (List, Set, Map) NO aceptan primitivos
         * - Proveen métodos útiles (Integer.parseInt(), etc.)
         * - Permiten valores null
         * - Necesarios para genéricos
         */
        
        System.out.println("\n--- WRAPPER CLASSES Y BOXING ---");
        
        // Creación explícita (no recomendada)
        Integer intObj1 = new Integer(100); // Deprecated desde Java 9
        Integer intObj2 = Integer.valueOf(100); // Forma recomendada
        
        // Autoboxing (automático desde Java 5)
        Integer intObj3 = 100;           // Primitivo → Objeto automáticamente
        Double doubleObj = 3.14;         // Primitivo → Objeto automáticamente
        
        // Unboxing (automático)
        int primitivo1 = intObj3;        // Objeto → Primitivo automáticamente
        double primitivo2 = doubleObj;   // Objeto → Primitivo automáticamente
        
        System.out.println("Autoboxing: " + intObj3 + ", " + doubleObj);
        System.out.println("Unboxing: " + primitivo1 + ", " + primitivo2);
        
        /*
         * CONCEPTO 4: CUIDADOS CON INTEGER CACHE
         * 
         * Java mantiene un cache de Integer para valores -128 a 127
         * Fuera de este rango, cada autoboxing crea un nuevo objeto
         */
        Integer cache1 = 127;    // Usa cache
        Integer cache2 = 127;    // Mismo objeto del cache
        Integer noCache1 = 128;  // Crea nuevo objeto
        Integer noCache2 = 128;  // Crea OTRO nuevo objeto
        
        System.out.println("127 == 127: " + (cache1 == cache2));       // true
        System.out.println("128 == 128: " + (noCache1 == noCache2));   // false!
        System.out.println("Usar .equals(): " + noCache1.equals(noCache2)); // true
        
        // ===========================================
        // SECCIÓN 3: STRINGS Y MANIPULACIÓN DE TEXTO
        // ===========================================
        
        /*
         * CONCEPTO 5: STRINGS INMUTABLES
         * 
         * En Java, los Strings son INMUTABLES:
         * - Una vez creados, NO pueden modificarse
         * - Cada operación crea un nuevo String
         * - Esto es diferente a lenguajes como C++ donde strings son mutables
         */
        
        System.out.println("\n--- STRINGS INMUTABLES ---");
        
        String str1 = "Hola";
        String str2 = "Mundo";
        String str3 = str1 + " " + str2; // Crea NUEVO string
        
        System.out.println("String original: " + str1); // No ha cambiado
        System.out.println("String concatenado: " + str3);
        
        // Demostración de inmutabilidad
        String original = "Java";
        String mayuscula = original.toUpperCase(); // Crea nuevo String
        System.out.println("Original: " + original);     // "Java" (no cambió)
        System.out.println("Mayúscula: " + mayuscula);   // "JAVA" (nuevo)
        
        /*
         * CONCEPTO 6: STRINGBUILDER PARA CONCATENACIÓN EFICIENTE
         * 
         * Problema: str += "algo" en un loop crea muchos objetos temporales
         * Solución: StringBuilder es mutable y eficiente para concatenación
         */
        
        // Concatenación ineficiente (evitar en loops)
        String lento = "";
        for (int j = 0; j < 3; j++) {
            lento += j + " "; // Crea nuevo String en cada iteración
        }
        
        // Concatenación eficiente
        StringBuilder rapido = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            rapido.append(j).append(" "); // Modifica el mismo objeto
        }
        
        System.out.println("Concatenación ineficiente: '" + lento.trim() + "'");
        System.out.println("Concatenación eficiente: '" + rapido.toString().trim() + "'");
        
        // ===========================================
        // SECCIÓN 4: ESTRUCTURAS DE CONTROL
        // ===========================================
        
        System.out.println("\n--- ESTRUCTURAS DE CONTROL ---");
        
        /*
         * CONCEPTO 7: IF-ELSE (IGUAL QUE OTROS LENGUAJES)
         * 
         * Sintaxis idéntica a C/C++/C#/JavaScript
         * IMPORTANTE: La condición debe ser boolean (no int como en C)
         */
        int numero = 15;
        if (numero % 2 == 0) {
            System.out.println(numero + " es par");
        } else if (numero % 3 == 0) {
            System.out.println(numero + " es múltiplo de 3");
        } else {
            System.out.println(numero + " no es par ni múltiplo de 3");
        }
        
        /*
         * CONCEPTO 8: SWITCH STATEMENT (JAVA 8 - TRADICIONAL)
         * 
         * En Java 8 solo se permite: int, byte, short, char, String, enum
         * NO se permiten: long, float, double, boolean
         * 
         * IMPORTANTE: No olvidar break; o continuará con los siguientes casos
         */
        String dia = "LUNES";
        switch (dia) {
            case "LUNES":
            case "MARTES":
            case "MIÉRCOLES":
            case "JUEVES":
                System.out.println("Día laboral: " + dia);
                break; // IMPORTANTE: sin break continúa
            case "VIERNES":
                System.out.println("¡Por fin viernes!");
                break;
            case "SÁBADO":
            case "DOMINGO":
                System.out.println("Fin de semana: " + dia);
                break;
            default:
                System.out.println("Día no reconocido: " + dia);
                break; // Opcional en default al final
        }
        
        /*
         * CONCEPTO 9: BUCLE FOR TRADICIONAL
         * 
         * Sintaxis: for (inicialización; condición; incremento)
         * - Inicialización: se ejecuta una vez al inicio
         * - Condición: se evalúa antes de cada iteración
         * - Incremento: se ejecuta después de cada iteración
         */
        System.out.println("FOR tradicional:");
        for (int j = 0; j < 5; j++) {
            if (j == 2) continue;    // Salta a la siguiente iteración
            if (j == 4) break;       // Sale del bucle completamente
            System.out.println("  Iteración: " + j);
        }
        
        /*
         * CONCEPTO 10: FOR-EACH (ENHANCED FOR LOOP)
         * 
         * Introducido en Java 5, para iterar sobre arrays y colecciones
         * Sintaxis: for (tipo variable : colección)
         * 
         * Ventajas:
         * - Más legible
         * - No hay acceso a índices (previene errores)
         * - Funciona con cualquier Iterable
         */
        String[] frutas = {"Manzana", "Banana", "Cereza", "Durazno"};
        System.out.println("FOR-EACH:");
        for (String fruta : frutas) {
            System.out.println("  Fruta: " + fruta);
        }
        
        /*
         * CONCEPTO 11: WHILE Y DO-WHILE
         * 
         * while: evalúa condición ANTES de ejecutar
         * do-while: ejecuta AL MENOS UNA VEZ, luego evalúa condición
         */
        System.out.println("WHILE:");
        int contador = 0;
        while (contador < 3) {
            System.out.println("  While contador: " + contador);
            contador++;
        }
        
        System.out.println("DO-WHILE:");
        int contador2 = 0;
        do {
            System.out.println("  Do-while contador: " + contador2);
            contador2++;
        } while (contador2 < 3);
        
        // ===========================================
        // SECCIÓN 5: ARRAYS
        // ===========================================
        
        /*
         * CONCEPTO 12: ARRAYS EN JAVA
         * 
         * Características importantes:
         * - Son OBJETOS (no primitivos como en C)
         * - Tienen atributo .length (no método length())
         * - Tamaño FIJO una vez creados
         * - Se inicializan con valores por defecto
         * - Índices base 0
         */
        
        System.out.println("\n--- ARRAYS ---");
        
        // Declaración e inicialización
        int[] numeros1 = {1, 2, 3, 4, 5};              // Inicialización directa
        int[] numeros2 = new int[5];                    // Array de tamaño 5 (inicializado a 0)
        int[] numeros3 = new int[]{10, 20, 30};        // Inicialización con new
        
        // Asignación de valores
        numeros2[0] = 100;
        numeros2[1] = 200;
        
        System.out.println("Array 1 length: " + numeros1.length); // Atributo, no método
        System.out.println("Primer elemento de numeros2: " + numeros2[0]);
        System.out.println("Último elemento de numeros1: " + numeros1[numeros1.length - 1]);
        
        /*
         * CONCEPTO 13: ARRAYS MULTIDIMENSIONALES
         * 
         * En Java, los arrays multidimensionales son "arrays de arrays"
         * Cada "fila" puede tener diferente tamaño (jagged arrays)
         */
        
        // Array bidimensional (matriz)
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        // Array "jagged" (filas de diferentes tamaños)
        int[][] jagged = {
            {1, 2},
            {3, 4, 5},
            {6, 7, 8, 9}
        };
        
        System.out.println("Matriz[1][2]: " + matriz[1][2]); // Fila 1, Columna 2 = 6
        System.out.println("Jagged[2].length: " + jagged[2].length); // Fila 2 tiene 4 elementos
        
        // ===========================================
        // SECCIÓN 6: PECULIARIDADES DE JAVA
        // ===========================================
        
        System.out.println("\n--- PECULIARIDADES DE JAVA ---");
        
        /*
         * CONCEPTO 14: DIFERENCIAS CLAVE CON OTROS LENGUAJES
         */
        
        // 1. NO HAY PUNTEROS EXPLÍCITOS
        // En C: int* ptr = &variable;
        // En Java: Solo referencias, sin aritmética de punteros
        
        // 2. GARBAGE COLLECTION AUTOMÁTICO  
        // En C: malloc() y free()
        // En C++: new y delete
        // En Java: Solo new, el GC limpia automáticamente
        
        // 3. TODO PASA POR VALOR (incluso las referencias)
        String original2 = "Antes";
        cambiarString(original2);
        System.out.println("Después de cambiarString: " + original2); // No cambió
        
        // 4. ARRAYS SON OBJETOS CON ATRIBUTO LENGTH
        System.out.println("Array es objeto: " + (numeros1 instanceof Object));
        System.out.println("Array length es atributo: " + numeros1.length); // NO length()
        
        // 5. STRINGS SON INMUTABLES
        // (Ya lo vimos antes)
        
        // 6. AUTOBOXING/UNBOXING AUTOMÁTICO
        // (Ya lo vimos antes)
        
        System.out.println("\n¡REPASO COMPLETADO!");
        System.out.println("Ahora tienes las bases sólidas de Java para avanzar.");
    }
    
    /*
     * CONCEPTO 15: PASO DE PARÁMETROS
     * 
     * Java SIEMPRE pasa por valor:
     * - Primitivos: se pasa una copia del valor
     * - Objetos: se pasa una copia de la referencia (no el objeto)
     * 
     * Esto significa que NO puedes cambiar la referencia desde un método,
     * pero SÍ puedes cambiar el contenido del objeto referenciado.
     */
    private static void cambiarString(String str) {
        str = "Modificado"; // Solo cambia la copia local de la referencia
        // La variable original en main() NO se afecta
    }
}

/*
 * RESUMEN FINAL DE CONCEPTOS CLAVE:
 * 
 * 1. TIPOS PRIMITIVOS: 8 tipos básicos, no son objetos
 * 2. WRAPPER CLASSES: Objetos que envuelven primitivos
 * 3. AUTOBOXING: Conversión automática primitivo ↔ objeto
 * 4. STRINGS INMUTABLES: Una vez creados no cambian
 * 5. STRINGBUILDER: Para concatenación eficiente
 * 6. ESTRUCTURAS DE CONTROL: if, switch, for, while, do-while
 * 7. ARRAYS: Objetos de tamaño fijo con atributo .length
 * 8. PASO POR VALOR: Siempre se pasan copias
 * 9. GARBAGE COLLECTION: Limpieza automática de memoria
 * 10. CASE SENSITIVE: Distingue mayúsculas/minúsculas
 * 
 * DIFERENCIAS IMPORTANTES CON OTROS LENGUAJES:
 * - No punteros explícitos (solo referencias)
 * - No gestión manual de memoria
 * - Todo debe estar en clases
 * - boolean es tipo específico (no int 0/1)
 * - String es objeto inmutable
 * - Arrays son objetos con .length
 */
