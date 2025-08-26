/**
 * ARCHIVO 05: Variaciones del Hello World y práctica adicional
 * 
 * CONCEPTOS EXPLICADOS:
 * - Diferentes enfoques para crear programas simples
 * - Uso avanzado de argumentos de línea de comandos
 * - Formateo de strings con printf()
 * - Organización de código en múltiples métodos
 * - Instrucciones detalladas de compilación y ejecución
 * - Manejo de errores comunes
 * 
 * Este archivo sirve como práctica y refuerzo de conceptos previos.
 */
public class VariacionesHelloWorld {
    
    /*
     * CONCEPTO 1: VARIACIONES PARA REFORZAR APRENDIZAJE
     * 
     * Este archivo presenta diferentes enfoques para crear programas simples,
     * cada uno enfocando aspectos específicos de Java que hemos aprendido.
     * 
     * Propósito educativo:
     * - Reforzar conceptos de archivos anteriores
     * - Mostrar flexibilidad en el diseño de programas
     * - Practicar diferentes formas de salida
     * - Demostrar uso de métodos auxiliares
     */
    
    public static void main(String[] args) {
        
        System.out.println("=== VARIACIONES DEL HELLO WORLD ===\n");
        
        // ===========================================
        // VARIACIÓN 1: Hello World básico mejorado
        // ===========================================
        
        /*
         * CONCEPTO 2: SALIDA BÁSICA MEJORADA
         * 
         * Usando diferentes métodos de System.out para mostrar
         * las opciones disponibles de salida de datos.
         */
        System.out.println("1. Hello World básico mejorado:");
        System.out.println("   ¡Hola Mundo desde Java 8!");
        System.out.println("   Este es un programa de ejemplo.\n");
        
        // ===========================================
        // VARIACIÓN 2: Con variables y concatenación
        // ===========================================
        
        /*
         * CONCEPTO 3: USO DE VARIABLES Y CONCATENACIÓN
         * 
         * Demostración de:
         * - Declaración de variables String
         * - Concatenación con operador +
         * - Diferencia entre concatenación y StringBuilder (para casos simples)
         */
        System.out.println("2. Con variables y concatenación:");
        
        String saludo = "Hola";
        String objetivo = "Estudiantes de Java";
        String mensaje = saludo + " " + objetivo + "!";
        
        System.out.println("   " + mensaje);
        System.out.println("   Saludo: '" + saludo + "', Objetivo: '" + objetivo + "'\n");
        
        // ===========================================
        // VARIACIÓN 3: Argumentos de línea de comandos
        // ===========================================
        
        /*
         * CONCEPTO 4: MANEJO DE ARGUMENTOS DE LÍNEA DE COMANDOS
         * 
         * Los argumentos se pasan al ejecutar: java VariacionesHelloWorld nombre edad
         * 
         * Características importantes:
         * - args.length da el número de argumentos
         * - Los argumentos siempre son String (hay que convertir si necesitas otros tipos)
         * - Los índices empiezan en 0
         * - Siempre verificar args.length antes de acceder a elementos
         */
        System.out.println("3. Con argumentos de línea de comandos:");
        System.out.println("   Número de argumentos recibidos: " + args.length);
        
        if (args.length >= 1) {
            System.out.println("   ¡Hola " + args[0] + "!");
            
            if (args.length >= 2) {
                // Demostración de conversión de tipos
                try {
                    int edad = Integer.parseInt(args[1]);
                    System.out.println("   Tienes " + edad + " años.");
                    
                    // Lógica condicional basada en argumento
                    if (edad >= 18) {
                        System.out.println("   Eres mayor de edad.");
                    } else {
                        System.out.println("   Eres menor de edad.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("   El segundo argumento debe ser un número (edad).");
                }
            }
            
            // Mostrar todos los argumentos
            if (args.length > 2) {
                System.out.print("   Argumentos adicionales: ");
                for (int i = 2; i < args.length; i++) {
                    System.out.print("'" + args[i] + "'");
                    if (i < args.length - 1) System.out.print(", ");
                }
                System.out.println();
            }
            
        } else {
            System.out.println("   ¡Hola Usuario Anónimo!");
            System.out.println("   Tip: Ejecuta con argumentos -> java VariacionesHelloWorld TuNombre TuEdad");
        }
        System.out.println();
        
        // ===========================================
        // VARIACIÓN 4: Formateo avanzado con printf
        // ===========================================
        
        /*
         * CONCEPTO 5: FORMATEO CON PRINTF
         * 
         * printf() permite formateo similar a C:
         * %s = String
         * %d = entero decimal  
         * %f = float/double
         * %c = char
         * %b = boolean
         * %n = nueva línea (independiente del SO)
         * 
         * Modificadores:
         * %10s = String de 10 caracteres (rellena con espacios)
         * %-10s = String alineado a la izquierda
         * %.2f = float con 2 decimales
         * %05d = entero con ceros a la izquierda (5 dígitos)
         */
        System.out.println("4. Formateo avanzado con printf:");
        
        String lenguaje = "Java";
        int version = 8;
        double pi = Math.PI;
        boolean esGenial = true;
        
        // Formateo básico
        System.out.printf("   Lenguaje: %s, Versión: %d%n", lenguaje, version);
        System.out.printf("   Pi con 3 decimales: %.3f%n", pi);
        System.out.printf("   ¿Es genial? %b%n", esGenial);
        
        // Formateo con alineación y relleno
        System.out.printf("   |%10s|%5d|%8.2f|%n", lenguaje, version, pi);
        System.out.printf("   |%-10s|%05d|%8.2f|%n", lenguaje, version, pi);
        System.out.println();
        
        // ===========================================
        // VARIACIÓN 5: ASCII Art y texto decorativo
        // ===========================================
        
        /*
         * CONCEPTO 6: ASCII ART Y STRINGS MULTILÍNEA
         * 
         * Demostración de:
         * - Strings con caracteres especiales
         * - Organización visual del código
         * - Uso creativo de System.out.println()
         */
        System.out.println("5. ASCII Art decorativo:");
        imprimirBanner();
        System.out.println();
        
        // ===========================================
        // VARIACIÓN 6: Información del sistema
        // ===========================================
        
        /*
         * CONCEPTO 7: PROPIEDADES DEL SISTEMA
         * 
         * Java proporciona información sobre el entorno de ejecución
         * a través de System.getProperty()
         */
        System.out.println("6. Información del sistema:");
        mostrarInfoSistema();
        System.out.println();
        
        // ===========================================
        // VARIACIÓN 7: Interacción simple
        // ===========================================
        
        /*
         * CONCEPTO 8: MÉTODOS AUXILIARES Y ORGANIZACIÓN
         * 
         * Demostración de cómo organizar código en métodos separados
         * para mejor legibilidad y reutilización.
         */
        System.out.println("7. Demostración de métodos auxiliares:");
        saludarConEstilo();
        mostrarEstadisticas();
        despedirse();
    }
    
    /*
     * CONCEPTO 9: MÉTODO AUXILIAR PARA ASCII ART
     * 
     * Este método demuestra:
     * - Separación de responsabilidades
     * - Método static (puede ser llamado desde main sin crear instancia)
     * - Strings con escape characters
     */
    private static void imprimirBanner() {
        System.out.println("   ╔══════════════════════════════════════╗");
        System.out.println("   ║           ¡HOLA JAVA 8!              ║");
        System.out.println("   ║                                      ║");
        System.out.println("   ║   ╦  ╔═╗  ╦  ╦  ╔═╗     ┌─┐         ║");
        System.out.println("   ║   ║  ╠═╣  ╚╗╔╝  ╠═╣     └─┐         ║");
        System.out.println("   ║  ╚╝  ╩ ╩   ╚╝   ╩ ╩     └─┘         ║");
        System.out.println("   ║                                      ║");
        System.out.println("   ╚══════════════════════════════════════╝");
        
        /*
         * NOTA TÉCNICA: Los caracteres especiales (╔, ═, ╗, etc.) son Unicode
         * y funcionan correctamente en la mayoría de terminales modernas.
         */
    }
    
    /*
     * CONCEPTO 10: INFORMACIÓN DEL SISTEMA Y PROPIEDADES
     * 
     * Java proporciona acceso a muchas propiedades del sistema
     * a través de System.getProperty()
     */
    private static void mostrarInfoSistema() {
        System.out.println("   --- Información del entorno ---");
        System.out.println("   Java Version: " + System.getProperty("java.version"));
        System.out.println("   Java Vendor: " + System.getProperty("java.vendor"));
        System.out.println("   Sistema Operativo: " + System.getProperty("os.name"));
        System.out.println("   Arquitectura: " + System.getProperty("os.arch"));
        System.out.println("   Usuario: " + System.getProperty("user.name"));
        System.out.println("   Directorio actual: " + System.getProperty("user.dir"));
        
        /*
         * CONCEPTO 11: RUNTIME INFORMATION
         * 
         * La clase Runtime proporciona información sobre el entorno
         * de ejecución actual de la JVM.
         */
        Runtime runtime = Runtime.getRuntime();
        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;
        
        System.out.printf("   Memoria total: %d MB%n", memoriaTotal / 1024 / 1024);
        System.out.printf("   Memoria usada: %d MB%n", memoriaUsada / 1024 / 1024);
        System.out.printf("   Memoria libre: %d MB%n", memoriaLibre / 1024 / 1024);
        System.out.println("   Procesadores disponibles: " + runtime.availableProcessors());
    }
    
    /*
     * CONCEPTO 12: MÉTODOS CON DIFERENTES PROPÓSITOS
     * 
     * Estos métodos demuestran diferentes estilos de salida
     * y organización de código.
     */
    private static void saludarConEstilo() {
        String[] saludos = {
            "¡Hola desde Java!",
            "¡Welcome to Java World!",
            "¡Bonjour du monde Java!",
            "¡Hola desde el mundo de la programación!"
        };
        
        // Usar Math.random() para selección aleatoria
        int indiceAleatorio = (int) (Math.random() * saludos.length);
        System.out.println("   " + saludos[indiceAleatorio]);
    }
    
    private static void mostrarEstadisticas() {
        System.out.println("   --- Estadísticas de este programa ---");
        System.out.println("   Líneas de código (aprox): 200+");
        System.out.println("   Conceptos demostrados: 12+");
        System.out.println("   Métodos definidos: 6");
        System.out.println("   Variaciones de Hello World: 7");
    }
    
    private static void despedirse() {
        System.out.println("   --- ¡Hasta la vista! ---");
        System.out.println("   Gracias por explorar las variaciones de Java.");
        System.out.println("   ¡Sigue practicando y mejorando tus habilidades!");
        
        // Timestamp simple
        System.out.println("   Programa ejecutado el: " + new java.util.Date());
    }
}

/*
 * INSTRUCCIONES DETALLADAS DE COMPILACIÓN Y EJECUCIÓN:
 * 
 * =====================================================
 * 1. COMPILACIÓN:
 * =====================================================
 * 
 * Opción A - Compilar solo este archivo:
 *   javac VariacionesHelloWorld.java
 * 
 * Opción B - Compilar todos los archivos Java:
 *   javac *.java
 * 
 * Resultado: Se genera VariacionesHelloWorld.class
 * 
 * =====================================================
 * 2. EJECUCIÓN BÁSICA:
 * =====================================================
 * 
 *   java VariacionesHelloWorld
 * 
 * =====================================================
 * 3. EJECUCIÓN CON ARGUMENTOS:
 * =====================================================
 * 
 * Un argumento (nombre):
 *   java VariacionesHelloWorld Juan
 * 
 * Dos argumentos (nombre y edad):
 *   java VariacionesHelloWorld Juan 25
 * 
 * Múltiples argumentos:
 *   java VariacionesHelloWorld Juan 25 Estudiante Mexico
 * 
 * Con espacios (usar comillas):
 *   java VariacionesHelloWorld "Juan Carlos" 25
 * 
 * =====================================================
 * 4. VERIFICACIÓN DE ARCHIVOS:
 * =====================================================
 * 
 * Windows:
 *   dir *.java    (archivos fuente)
 *   dir *.class   (archivos compilados)
 * 
 * Linux/Mac:
 *   ls *.java     (archivos fuente)
 *   ls *.class    (archivos compilados)
 * 
 * =====================================================
 * 5. ERRORES COMUNES Y SOLUCIONES:
 * =====================================================
 * 
 * ERROR: "javac no se reconoce como comando"
 * CAUSA: Java JDK no instalado o no está en PATH
 * SOLUCIÓN: 
 *   - Instalar JDK 8 o superior
 *   - Agregar bin de Java al PATH del sistema
 *   - Verificar con: javac -version
 * 
 * ERROR: "No se pudo encontrar la clase principal"
 * CAUSA: Nombre incorrecto al ejecutar
 * SOLUCIÓN: Usar exactamente: java VariacionesHelloWorld
 * 
 * ERROR: "NoClassDefFoundError"
 * CAUSA: Archivo .class no existe
 * SOLUCIÓN: Compilar primero con javac
 * 
 * ERROR: Error de compilación
 * CAUSA: Error de sintaxis en el código
 * SOLUCIÓN: 
 *   - Revisar mensajes de error del compilador
 *   - Verificar paréntesis, llaves, punto y coma
 *   - Verificar mayúsculas/minúsculas
 * 
 * =====================================================
 * 6. EJERCICIOS SUGERIDOS:
 * =====================================================
 * 
 * A. Modificar el ASCII art para mostrar tu nombre
 * B. Agregar una nueva variación que muestre la fecha actual
 * C. Crear un método que calcule algo basado en argumentos
 * D. Experimentar con diferentes formatos en printf()
 * E. Agregar validación más robusta para los argumentos
 * 
 * =====================================================
 * 7. PRÓXIMO PASO:
 * =====================================================
 * 
 * Una vez que domines estos conceptos, es hora de avanzar a:
 * - Variables y tipos de datos más avanzados
 * - Operadores y expresiones
 * - Estructuras de control más complejas
 * - Programación Orientada a Objetos
 */
