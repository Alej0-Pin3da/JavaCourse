/**
 * CONCEPTO 4: CASE SENSITIVITY
 * 
 * Ejemplo: Errores comunes y mejores prácticas
 * Demuestra errores típicos relacionados con case sensitivity y cómo evitarlos
 */
public class ErroresComunesCaseSensitive {
    
    // Variables que demuestran problemas comunes
    static String usuario = "admin";
    static String Usuario = "guest"; 
    static String USUARIO = "root";
    
    // Constantes con naming correcto
    static final String SERVIDOR_PRINCIPAL = "192.168.1.100";
    static final String SERVIDOR_BACKUP = "192.168.1.101";
    
    // Variables con naming inconsistente (MAL EJEMPLO)
    static int contador = 0;
    static int Contador = 10;
    static int CONTADOR = 100;
    static int ContaDor = 200;  // ¡Muy confuso!
    
    public static void main(String[] args) {
        System.out.println("=== ERRORES COMUNES CON CASE SENSITIVITY ===");
        
        demostrarErroresDeNombrado();
        demostrarProblemasDeComparacion();
        demostrarConfusionDeVariables();
        demostrarBuenasPracticas();
        demostrarConvencionesJava();
        
        System.out.println("\n=== RESUMEN DE MEJORES PRÁCTICAS ===");
        mostrarResumen();
    }
    
    public static void demostrarErroresDeNombrado() {
        System.out.println("\n1. ERRORES COMUNES DE NOMBRADO:");
        
        // ERROR: Variables con nombres muy similares
        String nombre = "Juan";
        String Nombre = "María";    // Confuso!
        String NOMBRE = "Carlos";   // Muy confuso!
        
        System.out.println("❌ PROBLEMÁTICO:");
        System.out.println("nombre = " + nombre);
        System.out.println("Nombre = " + Nombre);  
        System.out.println("NOMBRE = " + NOMBRE);
        System.out.println("→ Es difícil distinguir cuál usar en cada caso");
        
        // MEJOR: Nombres descriptivos diferentes
        String nombreUsuario = "Juan";
        String nombreAdmin = "María";
        String nombreSistema = "Carlos";
        
        System.out.println("\n✅ MEJOR PRÁCTICA:");
        System.out.println("nombreUsuario = " + nombreUsuario);
        System.out.println("nombreAdmin = " + nombreAdmin);
        System.out.println("nombreSistema = " + nombreSistema);
        System.out.println("→ Cada variable tiene propósito claro");
    }
    
    public static void demostrarProblemasDeComparacion() {
        System.out.println("\n2. PROBLEMAS DE COMPARACIÓN:");
        
        String input1 = "Hola";
        String input2 = "hola";
        String input3 = "HOLA";
        
        System.out.println("❌ COMPARACIONES PROBLEMÁTICAS:");
        System.out.println("\"Hola\".equals(\"hola\") = " + input1.equals(input2));  // false
        System.out.println("\"hola\".equals(\"HOLA\") = " + input2.equals(input3));  // false
        System.out.println("\"Hola\".equals(\"HOLA\") = " + input1.equals(input3));  // false
        
        System.out.println("\n✅ SOLUCIONES:");
        System.out.println("Ignorar case con equalsIgnoreCase():");
        System.out.println("\"Hola\".equalsIgnoreCase(\"hola\") = " + input1.equalsIgnoreCase(input2));  // true
        System.out.println("\"hola\".equalsIgnoreCase(\"HOLA\") = " + input2.equalsIgnoreCase(input3));  // true
        
        System.out.println("\nNormalizar antes de comparar:");
        System.out.println("\"Hola\".toLowerCase().equals(\"hola\".toLowerCase()) = " + 
                          input1.toLowerCase().equals(input2.toLowerCase()));  // true
    }
    
    public static void demostrarConfusionDeVariables() {
        System.out.println("\n3. CONFUSIÓN DE VARIABLES:");
        
        // Ejemplo de error común en principiantes
        int edad = 25;
        int Edad = 30;  // Variable diferente!
        
        System.out.println("❌ ERROR TÍPICO DE PRINCIPIANTES:");
        System.out.println("int edad = 25;");
        System.out.println("int Edad = 30;  // ¡Variable DIFERENTE!");
        
        // El programador piensa que está usando la misma variable
        System.out.println("\nValores actuales:");
        System.out.println("edad = " + edad);    // 25
        System.out.println("Edad = " + Edad);    // 30
        
        // Modificando una, la otra no cambia
        edad = 40;
        System.out.println("\nDespués de 'edad = 40':");
        System.out.println("edad = " + edad);    // 40
        System.out.println("Edad = " + Edad);    // 30 (¡No cambió!)
        
        System.out.println("\n✅ MEJOR PRÁCTICA:");
        System.out.println("Usar nombres completamente diferentes:");
        
        int edadUsuario = 25;
        int edadMinima = 18;
        int edadMaxima = 65;
        
        System.out.println("edadUsuario = " + edadUsuario);
        System.out.println("edadMinima = " + edadMinima);
        System.out.println("edadMaxima = " + edadMaxima);
        System.out.println("→ Propósito claro para cada variable");
    }
    
    public static void demostrarBuenasPracticas() {
        System.out.println("\n4. BUENAS PRÁCTICAS:");
        
        // ✅ Convenciones correctas
        System.out.println("✅ CONVENCIONES CORRECTAS:");
        
        // Variables y métodos: camelCase
        String nombreCompleto = "Juan Pérez";
        int edadActual = 30;
        boolean estaActivo = true;
        
        System.out.println("Variables camelCase:");
        System.out.println("- nombreCompleto: " + nombreCompleto);
        System.out.println("- edadActual: " + edadActual);
        System.out.println("- estaActivo: " + estaActivo);
        
        // Constantes: UPPER_SNAKE_CASE
        final String MENSAJE_BIENVENIDA = "¡Bienvenido!";
        final int LIMITE_MAXIMO = 100;
        final double PI_VALOR = 3.14159;
        
        System.out.println("\nConstantes UPPER_SNAKE_CASE:");
        System.out.println("- MENSAJE_BIENVENIDA: " + MENSAJE_BIENVENIDA);
        System.out.println("- LIMITE_MAXIMO: " + LIMITE_MAXIMO);
        System.out.println("- PI_VALOR: " + PI_VALOR);
        
        // Métodos: camelCase
        System.out.println("\nMétodos camelCase:");
        System.out.println("- " + obtenerMensajeBienvenida());
        System.out.println("- " + calcularAreaCirculo(5.0));
        System.out.println("- " + validarDatos("test", 25));
    }
    
    public static void demostrarConvencionesJava() {
        System.out.println("\n5. CONVENCIONES ESTÁNDAR DE JAVA:");
        
        System.out.println("📋 GUÍA DE NOMENCLATURA:");
        System.out.println("\n• CLASES: PascalCase");
        System.out.println("  Ejemplo: MiClase, UsuarioController, BaseDatos");
        
        System.out.println("\n• VARIABLES Y MÉTODOS: camelCase");
        System.out.println("  Ejemplo: miVariable, calcularTotal, obtenerNombre");
        
        System.out.println("\n• CONSTANTES: UPPER_SNAKE_CASE");
        System.out.println("  Ejemplo: MAX_SIZE, DEFAULT_VALUE, PI_VALUE");
        
        System.out.println("\n• PAQUETES: minúsculas");
        System.out.println("  Ejemplo: com.empresa.proyecto, util.helpers");
        
        System.out.println("\n❌ EVITAR:");
        System.out.println("- Variables que solo difieren en mayúsculas/minúsculas");
        System.out.println("- Mezclar convenciones inconsistentemente");
        System.out.println("- Usar nombres confusos como: item vs Item vs ITEM");
        
        System.out.println("\n✅ RECOMENDADO:");
        System.out.println("- Nombres descriptivos y únicos");
        System.out.println("- Convenciones consistentes en todo el proyecto");
        System.out.println("- Propósito claro para cada identificador");
    }
    
    // Métodos auxiliares con naming correcto
    public static String obtenerMensajeBienvenida() {
        return "Mensaje generado con método camelCase";
    }
    
    public static double calcularAreaCirculo(double radio) {
        final double PI = 3.14159;
        return PI * radio * radio;
    }
    
    public static boolean validarDatos(String nombre, int edad) {
        return nombre != null && !nombre.isEmpty() && edad > 0;
    }
    
    public static void mostrarResumen() {
        System.out.println("🎯 PUNTOS CLAVE PARA RECORDAR:");
        System.out.println("\n1. Java ES completamente case sensitive");
        System.out.println("2. edad ≠ Edad ≠ EDAD (son variables diferentes)");
        System.out.println("3. método() ≠ Método() ≠ MÉTODO() (son métodos diferentes)");
        System.out.println("4. \"texto\" ≠ \"Texto\" ≠ \"TEXTO\" (son strings diferentes)");
        
        System.out.println("\n💡 CONSEJOS PRÁCTICOS:");
        System.out.println("• Usa nombres descriptivos y únicos");
        System.out.println("• Sigue convenciones estándar de Java");
        System.out.println("• Evita nombres que solo difieren en mayúsculas/minúsculas");
        System.out.println("• Para comparaciones de texto, considera equalsIgnoreCase()");
        System.out.println("• Usa herramientas de IDE para autocompletado y evitar errores");
        
        System.out.println("\n⚠️ ERRORES A EVITAR:");
        System.out.println("• Definir variables como: nombre, Nombre, NOMBRE");
        System.out.println("• Confundir métodos por diferencias de mayúsculas");
        System.out.println("• Inconsistencias en convenciones de naming");
        System.out.println("• Asumir que Java ignora diferencias de case");
        
        System.out.println("\n🏆 OBJETIVO:");
        System.out.println("Escribir código limpio, consistente y fácil de mantener");
        System.out.println("respetando las convenciones estándar de Java.");
    }
}

/*
RESUMEN COMPLETO: CASE SENSITIVITY EN JAVA

🔍 QUÉ ES CASE SENSITIVITY:
- Java distingue entre mayúsculas y minúsculas en TODOS los identificadores
- Aplica a: variables, métodos, clases, constantes, paquetes
- No aplica a: palabras clave (if, while, class, etc.)

📝 CONVENCIONES ESTÁNDAR:
• Clases: PascalCase (MiClase)
• Variables/Métodos: camelCase (miVariable, miMetodo)  
• Constantes: UPPER_SNAKE_CASE (MI_CONSTANTE)
• Paquetes: minúsculas (com.empresa.proyecto)

❌ PROBLEMAS COMUNES:
1. Variables confusas: edad, Edad, EDAD
2. Métodos similares: mostrar(), Mostrar(), MOSTRAR()
3. Comparaciones fallidas: "Hola" vs "hola"
4. Errores de escritura en nombres

✅ MEJORES PRÁCTICAS:
1. Nombres descriptivos y únicos
2. Convenciones consistentes  
3. Evitar nombres que solo difieren en case
4. Usar equalsIgnoreCase() para comparaciones de texto
5. Aprovechar autocompletado del IDE

🎯 OBJETIVO FINAL:
Código limpio, mantenible y que siga las convenciones estándar de Java,
evitando confusiones y errores relacionados con case sensitivity.
*/
