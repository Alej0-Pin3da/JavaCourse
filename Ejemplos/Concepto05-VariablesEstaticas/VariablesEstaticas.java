/**
 * CONCEPTO 5: VARIABLES ESTÁTICAS VS DE INSTANCIA
 * 
 * Ejemplo: Variables estáticas - compartidas entre todas las instancias
 * Demuestra el comportamiento y uso de variables static
 */
public class VariablesEstaticas {
    
    // VARIABLES ESTÁTICAS (static) - Compartidas por TODAS las instancias
    static String nombreEscuela = "Instituto Tecnológico";
    static int totalEstudiantes = 0;
    static final String CODIGO_PAIS = "CO";  // Constante estática
    static double promedioGeneral = 0.0;
    
    // VARIABLES DE INSTANCIA (no static) - Específicas de cada objeto
    String nombreEstudiante;
    int edad;
    double promedio;
    String codigo;
    
    // CONSTRUCTOR
    public VariablesEstaticas(String nombre, int edad, double promedio) {
        // Variables de instancia - cada objeto tiene sus propios valores
        this.nombreEstudiante = nombre;
        this.edad = edad;
        this.promedio = promedio;
        this.codigo = generarCodigo();
        
        // Variable estática - se incrementa para TODOS los objetos
        totalEstudiantes++;
        
        // Actualizar promedio general (variable estática)
        actualizarPromedioGeneral();
    }
    
    // MÉTODO ESTÁTICO - puede acceder solo a variables estáticas
    public static void mostrarInfoEscuela() {
        System.out.println("=== INFORMACIÓN DE LA ESCUELA (ESTÁTICA) ===");
        System.out.println("Nombre de la escuela: " + nombreEscuela);
        System.out.println("Total de estudiantes: " + totalEstudiantes);
        System.out.println("Código del país: " + CODIGO_PAIS);
        System.out.println("Promedio general: " + String.format("%.2f", promedioGeneral));
        
        // ❌ ERROR: No podemos acceder a variables de instancia desde método estático
        // System.out.println("Nombre estudiante: " + nombreEstudiante);  // Error!
        // System.out.println("Edad: " + edad);  // Error!
        
        System.out.println("→ Los datos estáticos son compartidos por TODAS las instancias");
    }
    
    // MÉTODO DE INSTANCIA - puede acceder a ambos tipos de variables
    public void mostrarInfoEstudiante() {
        System.out.println("--- Información del Estudiante ---");
        
        // ✅ Acceso a variables de instancia
        System.out.println("Nombre: " + this.nombreEstudiante);
        System.out.println("Edad: " + this.edad);
        System.out.println("Promedio: " + this.promedio);
        System.out.println("Código: " + this.codigo);
        
        // ✅ También puede acceder a variables estáticas
        System.out.println("Escuela: " + nombreEscuela);
        System.out.println("Total estudiantes en la escuela: " + totalEstudiantes);
        System.out.println("País: " + CODIGO_PAIS);
        System.out.println();
    }
    
    // MÉTODO ESTÁTICO para modificar variables estáticas
    public static void cambiarNombreEscuela(String nuevoNombre) {
        System.out.println("Cambiando nombre de escuela de '" + nombreEscuela + "' a '" + nuevoNombre + "'");
        nombreEscuela = nuevoNombre;
        System.out.println("¡Cambio aplicado para TODAS las instancias!");
    }
    
    // MÉTODO DE INSTANCIA que modifica variable estática
    private void actualizarPromedioGeneral() {
        // Recalcular promedio general usando la variable estática
        if (totalEstudiantes > 0) {
            // Simulación simple del cálculo (en un caso real sería más complejo)
            promedioGeneral = (promedioGeneral * (totalEstudiantes - 1) + this.promedio) / totalEstudiantes;
        }
    }
    
    // MÉTODO para generar código único
    private String generarCodigo() {
        return CODIGO_PAIS + "-" + String.format("%03d", totalEstudiantes);
    }
    
    // MÉTODO ESTÁTICO para obtener estadísticas
    public static String obtenerEstadisticas() {
        return String.format("Escuela: %s | Estudiantes: %d | Promedio: %.2f", 
                           nombreEscuela, totalEstudiantes, promedioGeneral);
    }
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN: VARIABLES ESTÁTICAS VS DE INSTANCIA ===\n");
        
        // 1. Mostrar estado inicial (sin instancias)
        System.out.println("1. ESTADO INICIAL (sin objetos creados):");
        mostrarInfoEscuela();
        System.out.println();
        
        // 2. Crear primera instancia
        System.out.println("2. CREANDO PRIMER ESTUDIANTE:");
        VariablesEstaticas estudiante1 = new VariablesEstaticas("Ana García", 20, 8.5);
        estudiante1.mostrarInfoEstudiante();
        
        System.out.println("Estado después del primer estudiante:");
        mostrarInfoEscuela();
        System.out.println();
        
        // 3. Crear segunda instancia
        System.out.println("3. CREANDO SEGUNDO ESTUDIANTE:");
        VariablesEstaticas estudiante2 = new VariablesEstaticas("Carlos Ruiz", 22, 9.2);
        estudiante2.mostrarInfoEstudiante();
        
        System.out.println("Estado después del segundo estudiante:");
        mostrarInfoEscuela();
        System.out.println();
        
        // 4. Crear tercera instancia
        System.out.println("4. CREANDO TERCER ESTUDIANTE:");
        VariablesEstaticas estudiante3 = new VariablesEstaticas("María López", 19, 7.8);
        estudiante3.mostrarInfoEstudiante();
        
        System.out.println("Estado final:");
        mostrarInfoEscuela();
        System.out.println();
        
        // 5. Demostrar que las variables estáticas son compartidas
        System.out.println("5. DEMOSTRANDO QUE LAS VARIABLES ESTÁTICAS SON COMPARTIDAS:");
        System.out.println("Información antes del cambio:");
        System.out.println("Estudiante 1 - Escuela: " + estudiante1.nombreEscuela);
        System.out.println("Estudiante 2 - Escuela: " + estudiante2.nombreEscuela);
        System.out.println("Estudiante 3 - Escuela: " + estudiante3.nombreEscuela);
        
        // Cambiar variable estática desde la clase (recomendado)
        VariablesEstaticas.cambiarNombreEscuela("Universidad Avanzada");
        
        System.out.println("\nInformación después del cambio:");
        System.out.println("Estudiante 1 - Escuela: " + estudiante1.nombreEscuela);
        System.out.println("Estudiante 2 - Escuela: " + estudiante2.nombreEscuela);
        System.out.println("Estudiante 3 - Escuela: " + estudiante3.nombreEscuela);
        System.out.println("→ ¡El cambio se refleja en TODAS las instancias!");
        System.out.println();
        
        // 6. Demostrar acceso a variables estáticas sin instancia
        System.out.println("6. ACCESO A VARIABLES ESTÁTICAS SIN CREAR OBJETOS:");
        System.out.println("Total estudiantes (sin objeto): " + VariablesEstaticas.totalEstudiantes);
        System.out.println("Nombre escuela (sin objeto): " + VariablesEstaticas.nombreEscuela);
        System.out.println("Código país (sin objeto): " + VariablesEstaticas.CODIGO_PAIS);
        System.out.println("Estadísticas: " + VariablesEstaticas.obtenerEstadisticas());
        System.out.println();
        
        // 7. Comparar variables de instancia
        System.out.println("7. COMPARANDO VARIABLES DE INSTANCIA (son diferentes para cada objeto):");
        System.out.println("Estudiante 1 - Nombre: " + estudiante1.nombreEstudiante + ", Edad: " + estudiante1.edad);
        System.out.println("Estudiante 2 - Nombre: " + estudiante2.nombreEstudiante + ", Edad: " + estudiante2.edad);  
        System.out.println("Estudiante 3 - Nombre: " + estudiante3.nombreEstudiante + ", Edad: " + estudiante3.edad);
        System.out.println("→ Cada objeto tiene sus propios valores de instancia");
        System.out.println();
        
        // 8. Demostrar memoria compartida
        System.out.println("8. DEMOSTRANDO MEMORIA COMPARTIDA:");
        demostracionMemoriaCompartida();
    }
    
    public static void demostracionMemoriaCompartida() {
        System.out.println("📊 ANÁLISIS DE MEMORIA:");
        System.out.println("\n🔹 VARIABLES ESTÁTICAS (static):");
        System.out.println("• Se almacenan en el ÁREA DE MÉTODOS de la JVM");
        System.out.println("• UNA SOLA COPIA para toda la clase");
        System.out.println("• Compartidas entre TODAS las instancias");
        System.out.println("• Existen desde que se carga la clase");
        System.out.println("• Se pueden acceder sin crear objetos");
        
        System.out.println("\n🔹 VARIABLES DE INSTANCIA (no static):");
        System.out.println("• Se almacenan en el HEAP de la JVM");
        System.out.println("• COPIA INDIVIDUAL para cada objeto");
        System.out.println("• Específicas de cada instancia");
        System.out.println("• Existen mientras exista el objeto");
        System.out.println("• Requieren una instancia para acceder");
        
        System.out.println("\n💡 EJEMPLO VISUAL:");
        System.out.println("Clase: VariablesEstaticas");
        System.out.println("├── static nombreEscuela ──→ UNA copia en memoria ['" + nombreEscuela + "']");
        System.out.println("├── static totalEstudiantes ──→ UNA copia en memoria [" + totalEstudiantes + "]");
        System.out.println("│");
        System.out.println("├── Objeto 1:");
        System.out.println("│   ├── nombreEstudiante ──→ Copia individual");
        System.out.println("│   └── edad ──→ Copia individual");
        System.out.println("│");
        System.out.println("├── Objeto 2:");
        System.out.println("│   ├── nombreEstudiante ──→ Copia individual");
        System.out.println("│   └── edad ──→ Copia individual");
        System.out.println("│");
        System.out.println("└── Objeto 3:");
        System.out.println("    ├── nombreEstudiante ──→ Copia individual");
        System.out.println("    └── edad ──→ Copia individual");
        
        System.out.println("\n🎯 RESULTADO:");
        System.out.println("• Variables estáticas: 1 copia × " + totalEstudiantes + " objetos = 1 copia total");
        System.out.println("• Variables de instancia: " + totalEstudiantes + " copias × " + totalEstudiantes + " objetos = " + (totalEstudiantes * totalEstudiantes) + " copias total");
    }
}

/*
CONCEPTOS CLAVE: VARIABLES ESTÁTICAS VS DE INSTANCIA

📋 DEFINICIONES:

1. VARIABLES ESTÁTICAS (static):
   • Pertenecen a la CLASE, no a instancias individuales
   • UNA SOLA COPIA compartida por todos los objetos
   • Se inicializan cuando se carga la clase
   • Accesibles sin crear objetos: NombreClase.variable
   • Útiles para datos compartidos, contadores, constantes

2. VARIABLES DE INSTANCIA (no static):
   • Pertenecen a cada OBJETO individual
   • COPIA SEPARADA para cada instancia
   • Se inicializan cuando se crea el objeto
   • Requieren una instancia para acceder: objeto.variable
   • Útiles para datos específicos de cada objeto

🔄 COMPORTAMIENTO:

• STATIC: Modificar en una parte afecta a TODAS las instancias
• INSTANCIA: Modificar en un objeto NO afecta a otros objetos

💾 MEMORIA:

• STATIC: Área de métodos de la JVM (Method Area)
• INSTANCIA: Heap de la JVM

⚡ INICIALIZACIÓN:

• STATIC: Al cargar la clase (antes de crear objetos)
• INSTANCIA: Al crear cada objeto (constructor)

🔍 ACCESO:

• STATIC: Clase.variable o instancia.variable (no recomendado)
• INSTANCIA: Solo instancia.variable

📊 CASOS DE USO:

STATIC:
• Contadores globales (totalUsuarios)
• Configuraciones compartidas (nombreEmpresa)
• Constantes (PI, VERSION)
• Métodos de utilidad (Math.abs())

INSTANCIA:
• Datos específicos del objeto (nombre, edad)
• Estado individual (saldo, posición)
• Características únicas (id, color)
*/
