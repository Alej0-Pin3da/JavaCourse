/**
 * CONCEPTO 5: VARIABLES ESTÁTICAS VS DE INSTANCIA
 * 
 * Ejemplo: Comparación directa entre variables estáticas y de instancia
 * Demuestra las diferencias clave y cuándo usar cada tipo
 */
public class ComparacionEstaticaVsInstancia {
    
    // ===== VARIABLES ESTÁTICAS (COMPARTIDAS) =====
    static String nombreEmpresa = "TechCorp Solutions";
    static String direccionEmpresa = "Av. Principal 123";
    static int totalEmpleados = 0;
    static double salarioPromedio = 0.0;
    static final String CODIGO_EMPRESA = "TC-001";  // Constante estática
    static boolean empresaActiva = true;
    
    // ===== VARIABLES DE INSTANCIA (INDIVIDUALES) =====
    private int idEmpleado;
    private String nombreEmpleado;
    private String departamento;
    private double salario;
    private int anosExperiencia;
    private boolean activo;
    private String email;
    
    // Contador estático para generar IDs únicos
    private static int contadorId = 1001;
    
    // CONSTRUCTOR
    public ComparacionEstaticaVsInstancia(String nombre, String departamento, double salario, int experiencia) {
        // Asignar valores a variables DE INSTANCIA (específicas de este objeto)
        this.idEmpleado = contadorId++;
        this.nombreEmpleado = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.anosExperiencia = experiencia;
        this.activo = true;
        this.email = generarEmail(nombre);
        
        // Actualizar variables ESTÁTICAS (compartidas por todos)
        totalEmpleados++;
        actualizarSalarioPromedio();
        
        System.out.println("✅ Empleado creado: " + nombre + " (ID: " + this.idEmpleado + ")");
    }
    
    // MÉTODO ESTÁTICO - solo puede acceder a variables estáticas
    public static void mostrarInfoEmpresa() {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║                    INFORMACIÓN EMPRESA                 ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ Nombre: " + String.format("%-42s", nombreEmpresa) + " ║");
        System.out.println("║ Dirección: " + String.format("%-39s", direccionEmpresa) + " ║");
        System.out.println("║ Código: " + String.format("%-42s", CODIGO_EMPRESA) + " ║");
        System.out.println("║ Total Empleados: " + String.format("%-33d", totalEmpleados) + " ║");
        System.out.println("║ Salario Promedio: $" + String.format("%-32.2f", salarioPromedio) + " ║");
        System.out.println("║ Estado: " + String.format("%-42s", empresaActiva ? "Activa" : "Inactiva") + " ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.println("→ Esta información es COMPARTIDA por todos los empleados");
    }
    
    // MÉTODO DE INSTANCIA - puede acceder a ambos tipos de variables
    public void mostrarInfoEmpleado() {
        System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│                  INFORMACIÓN EMPLEADO                   │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│ ID: " + String.format("%-50d", this.idEmpleado) + " │");
        System.out.println("│ Nombre: " + String.format("%-46s", this.nombreEmpleado) + " │");
        System.out.println("│ Departamento: " + String.format("%-40s", this.departamento) + " │");
        System.out.println("│ Salario: $" + String.format("%-45.2f", this.salario) + " │");
        System.out.println("│ Experiencia: " + String.format("%-41d", this.anosExperiencia) + " años │");
        System.out.println("│ Email: " + String.format("%-47s", this.email) + " │");
        System.out.println("│ Estado: " + String.format("%-46s", this.activo ? "Activo" : "Inactivo") + " │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│                  DATOS COMPARTIDOS                      │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│ Empresa: " + String.format("%-45s", nombreEmpresa) + " │");
        System.out.println("│ Oficina: " + String.format("%-45s", direccionEmpresa) + " │");
        System.out.println("│ Total Empleados: " + String.format("%-37d", totalEmpleados) + " │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
        System.out.println("→ Datos individuales + datos compartidos");
    }
    
    // MÉTODO ESTÁTICO para cambiar datos de empresa (afecta a TODOS)
    public static void cambiarDatosEmpresa(String nuevoNombre, String nuevaDireccion) {
        String anteriorNombre = nombreEmpresa;
        String anteriorDireccion = direccionEmpresa;
        
        nombreEmpresa = nuevoNombre;
        direccionEmpresa = nuevaDireccion;
        
        System.out.println("🏢 CAMBIO EN DATOS DE EMPRESA:");
        System.out.println("  Nombre: '" + anteriorNombre + "' → '" + nuevoNombre + "'");
        System.out.println("  Dirección: '" + anteriorDireccion + "' → '" + nuevaDireccion + "'");
        System.out.println("  ⚠️ Este cambio afecta a TODOS los empleados");
    }
    
    // MÉTODO DE INSTANCIA para cambiar datos individuales (afecta solo a este empleado)
    public void cambiarDatosPersonales(String nuevoNombre, String nuevoDepartamento, double nuevoSalario) {
        String anteriorNombre = this.nombreEmpleado;
        String anteriorDepartamento = this.departamento;
        double anteriorSalario = this.salario;
        
        this.nombreEmpleado = nuevoNombre;
        this.departamento = nuevoDepartamento;
        this.salario = nuevoSalario;
        this.email = generarEmail(nuevoNombre);
        
        // Actualizar salario promedio (variable estática)
        actualizarSalarioPromedio();
        
        System.out.println("👤 CAMBIO EN DATOS PERSONALES (ID: " + this.idEmpleado + "):");
        System.out.println("  Nombre: '" + anteriorNombre + "' → '" + nuevoNombre + "'");
        System.out.println("  Departamento: '" + anteriorDepartamento + "' → '" + nuevoDepartamento + "'");
        System.out.println("  Salario: $" + anteriorSalario + " → $" + nuevoSalario);
        System.out.println("  ✅ Este cambio afecta SOLO a este empleado");
    }
    
    // Métodos auxiliares
    private String generarEmail(String nombre) {
        return nombre.toLowerCase().replace(" ", ".") + "@techcorp.com";
    }
    
    private static void actualizarSalarioPromedio() {
        // En un caso real, esto sería más complejo
        // Por simplicidad, asumimos un cálculo básico
        if (totalEmpleados > 0) {
            salarioPromedio = (salarioPromedio * (totalEmpleados - 1) + 50000) / totalEmpleados;
        }
    }
    
    // Método estático para obtener estadísticas
    public static String obtenerEstadisticasEmpresa() {
        return String.format("Empresa: %s | Empleados: %d | Salario Promedio: $%.2f", 
                           nombreEmpresa, totalEmpleados, salarioPromedio);
    }
    
    // Getters para variables de instancia
    public int getIdEmpleado() { return this.idEmpleado; }
    public String getNombreEmpleado() { return this.nombreEmpleado; }
    public String getDepartamento() { return this.departamento; }
    public double getSalario() { return this.salario; }
    
    public static void main(String[] args) {
        System.out.println("🔄 COMPARACIÓN: VARIABLES ESTÁTICAS VS DE INSTANCIA");
        System.out.println("═══════════════════════════════════════════════════════════════");
        
        // 1. Estado inicial (solo variables estáticas existen)
        System.out.println("\n1. ESTADO INICIAL (sin empleados):");
        mostrarInfoEmpresa();
        System.out.println();
        
        // 2. Crear empleados (variables de instancia se crean)
        System.out.println("2. CREANDO EMPLEADOS:");
        ComparacionEstaticaVsInstancia emp1 = new ComparacionEstaticaVsInstancia("Ana García", "Desarrollo", 55000, 3);
        ComparacionEstaticaVsInstancia emp2 = new ComparacionEstaticaVsInstancia("Carlos López", "Marketing", 45000, 2);
        ComparacionEstaticaVsInstancia emp3 = new ComparacionEstaticaVsInstancia("María Rodríguez", "Ventas", 48000, 4);
        
        System.out.println("\nEstado después de crear empleados:");
        mostrarInfoEmpresa();
        System.out.println();
        
        // 3. Mostrar información individual
        System.out.println("3. INFORMACIÓN INDIVIDUAL DE CADA EMPLEADO:");
        emp1.mostrarInfoEmpleado();
        System.out.println();
        emp2.mostrarInfoEmpleado();
        System.out.println();
        emp3.mostrarInfoEmpleado();
        System.out.println();
        
        // 4. Demostrar cambios en variables estáticas (afectan a todos)
        System.out.println("4. CAMBIOS EN VARIABLES ESTÁTICAS (afectan a TODOS):");
        cambiarDatosEmpresa("TechCorp Advanced", "Av. Innovación 456");
        
        System.out.println("\nCómo afectó a todos los empleados:");
        System.out.println("Empleado 1 - Empresa: " + nombreEmpresa);
        System.out.println("Empleado 2 - Empresa: " + nombreEmpresa);
        System.out.println("Empleado 3 - Empresa: " + nombreEmpresa);
        System.out.println("→ ¡El cambio se refleja en TODAS las instancias!");
        System.out.println();
        
        // 5. Demostrar cambios en variables de instancia (afectan solo al objeto específico)
        System.out.println("5. CAMBIOS EN VARIABLES DE INSTANCIA (afectan solo al objeto específico):");
        emp2.cambiarDatosPersonales("Carlos Alberto López", "Recursos Humanos", 52000);
        
        System.out.println("\nCómo afectó a cada empleado:");
        System.out.printf("Empleado 1 - Nombre: %s, Departamento: %s%n", emp1.getNombreEmpleado(), emp1.getDepartamento());
        System.out.printf("Empleado 2 - Nombre: %s, Departamento: %s (CAMBIÓ)%n", emp2.getNombreEmpleado(), emp2.getDepartamento());
        System.out.printf("Empleado 3 - Nombre: %s, Departamento: %s%n", emp3.getNombreEmpleado(), emp3.getDepartamento());
        System.out.println("→ ¡Solo cambió el empleado 2!");
        System.out.println();
        
        // 6. Tabla comparativa
        System.out.println("6. TABLA COMPARATIVA:");
        mostrarTablaComparativa();
        
        // 7. Demostración de acceso
        System.out.println("\n7. DEMOSTRACIÓN DE ACCESO:");
        demostracionAcceso(emp1, emp2, emp3);
        
        // 8. Análisis de memoria
        System.out.println("\n8. ANÁLISIS DE MEMORIA:");
        analisisMemoria(emp1, emp2, emp3);
        
        // 9. Cuándo usar cada tipo
        System.out.println("\n9. CUÁNDO USAR CADA TIPO:");
        guiaUso();
    }
    
    public static void mostrarTablaComparativa() {
        System.out.println("┌─────────────────────────┬─────────────────────────┬─────────────────────────┐");
        System.out.println("│        ASPECTO          │    VARIABLES ESTÁTICAS  │  VARIABLES DE INSTANCIA │");
        System.out.println("├─────────────────────────┼─────────────────────────┼─────────────────────────┤");
        System.out.println("│ Número de copias        │ 1 por clase             │ 1 por objeto            │");
        System.out.println("│ Memoria                 │ Área de métodos         │ Heap                    │");
        System.out.println("│ Compartidas             │ Sí, entre todas         │ No, individuales        │");
        System.out.println("│ Inicialización          │ Al cargar la clase      │ Al crear objeto         │");
        System.out.println("│ Acceso sin objeto       │ Sí (Clase.variable)     │ No                      │");
        System.out.println("│ Modificación            │ Afecta a todos          │ Solo al objeto          │");
        System.out.println("│ Ejemplo de uso          │ Contadores, constantes  │ Atributos personales    │");
        System.out.println("│ Palabra clave           │ static                  │ (ninguna)               │");
        System.out.println("└─────────────────────────┴─────────────────────────┴─────────────────────────┘");
    }
    
    public static void demostracionAcceso(ComparacionEstaticaVsInstancia emp1, ComparacionEstaticaVsInstancia emp2, ComparacionEstaticaVsInstancia emp3) {
        System.out.println("🔑 FORMAS DE ACCESO:");
        
        System.out.println("\n✅ ACCESO A VARIABLES ESTÁTICAS:");
        System.out.println("• Desde la clase: ComparacionEstaticaVsInstancia.nombreEmpresa = \"" + ComparacionEstaticaVsInstancia.nombreEmpresa + "\"");
        System.out.println("• Desde instancia (no recomendado): emp1.nombreEmpresa = \"" + emp1.nombreEmpresa + "\"");
        System.out.println("• Sin crear objeto: totalEmpleados = " + ComparacionEstaticaVsInstancia.totalEmpleados);
        
        System.out.println("\n✅ ACCESO A VARIABLES DE INSTANCIA:");
        System.out.println("• Solo desde instancia: emp1.nombreEmpleado = \"" + emp1.getNombreEmpleado() + "\"");
        System.out.println("• Solo desde instancia: emp2.nombreEmpleado = \"" + emp2.getNombreEmpleado() + "\"");
        System.out.println("• Solo desde instancia: emp3.nombreEmpleado = \"" + emp3.getNombreEmpleado() + "\"");
        
        System.out.println("\n❌ ACCESOS INCORRECTOS:");
        System.out.println("• ComparacionEstaticaVsInstancia.nombreEmpleado (ERROR: no existe sin instancia)");
        System.out.println("• Desde método estático acceder directamente a variables de instancia (ERROR)");
    }
    
    public static void analisisMemoria(ComparacionEstaticaVsInstancia emp1, ComparacionEstaticaVsInstancia emp2, ComparacionEstaticaVsInstancia emp3) {
        System.out.println("💾 DISTRIBUCIÓN EN MEMORIA:");
        
        System.out.println("\n🔹 ÁREA DE MÉTODOS (Method Area):");
        System.out.println("├── static nombreEmpresa: \"" + nombreEmpresa + "\" (1 COPIA TOTAL)");
        System.out.println("├── static direccionEmpresa: \"" + direccionEmpresa + "\" (1 COPIA TOTAL)");
        System.out.println("├── static totalEmpleados: " + totalEmpleados + " (1 COPIA TOTAL)");
        System.out.println("└── static CODIGO_EMPRESA: \"" + CODIGO_EMPRESA + "\" (1 COPIA TOTAL)");
        
        System.out.println("\n🔹 HEAP:");
        System.out.println("├── Objeto emp1:");
        System.out.println("│   ├── idEmpleado: " + emp1.getIdEmpleado());
        System.out.println("│   ├── nombreEmpleado: \"" + emp1.getNombreEmpleado() + "\"");
        System.out.println("│   └── departamento: \"" + emp1.getDepartamento() + "\"");
        System.out.println("│");
        System.out.println("├── Objeto emp2:");
        System.out.println("│   ├── idEmpleado: " + emp2.getIdEmpleado());
        System.out.println("│   ├── nombreEmpleado: \"" + emp2.getNombreEmpleado() + "\"");
        System.out.println("│   └── departamento: \"" + emp2.getDepartamento() + "\"");
        System.out.println("│");
        System.out.println("└── Objeto emp3:");
        System.out.println("    ├── idEmpleado: " + emp3.getIdEmpleado());
        System.out.println("    ├── nombreEmpleado: \"" + emp3.getNombreEmpleado() + "\"");
        System.out.println("    └── departamento: \"" + emp3.getDepartamento() + "\"");
        
        System.out.println("\n📊 RESUMEN DE MEMORIA:");
        System.out.println("• Variables estáticas: 4 variables × 1 copia = 4 copias total");
        System.out.println("• Variables de instancia: ~6 variables × 3 objetos = ~18 copias total");
        System.out.println("• Total aproximado: ~22 variables en memoria");
    }
    
    public static void guiaUso() {
        System.out.println("📋 GUÍA: CUÁNDO USAR CADA TIPO");
        
        System.out.println("\n🔸 USA VARIABLES ESTÁTICAS cuando:");
        System.out.println("  ✅ Los datos deben ser compartidos entre TODAS las instancias");
        System.out.println("  ✅ Necesitas contadores globales (ej: totalUsuarios)");
        System.out.println("  ✅ Defines constantes de clase (ej: PI, VERSION)");
        System.out.println("  ✅ Almacenas configuraciones compartidas (ej: nombreEmpresa)");
        System.out.println("  ✅ Quieres acceder sin crear objetos");
        
        System.out.println("\n🔸 USA VARIABLES DE INSTANCIA cuando:");
        System.out.println("  ✅ Los datos son específicos de cada objeto");
        System.out.println("  ✅ Cada instancia necesita sus propios valores");
        System.out.println("  ✅ Representas atributos individuales (ej: nombre, edad)");
        System.out.println("  ✅ El estado puede variar entre objetos");
        System.out.println("  ✅ Implementas encapsulación por objeto");
        
        System.out.println("\n⚠️ EVITA:");
        System.out.println("  ❌ Usar static para datos que deberían ser individuales");
        System.out.println("  ❌ Usar instancia para datos que deberían ser compartidos");
        System.out.println("  ❌ Mezclar ambos tipos sin clara justificación");
        System.out.println("  ❌ Sobreuso de variables estáticas (dificulta testing)");
        
        System.out.println("\n🎯 REGLA DE ORO:");
        System.out.println("  Si cambia para cada objeto → Variable de INSTANCIA");
        System.out.println("  Si es igual para todos los objetos → Variable ESTÁTICA");
    }
}

/*
RESUMEN DEFINITIVO: ESTÁTICAS VS INSTANCIA

🎯 DIFERENCIAS CLAVE:

┌─────────────────────┬─────────────────────┬─────────────────────┐
│       ASPECTO       │      ESTÁTICAS      │     INSTANCIA       │
├─────────────────────┼─────────────────────┼─────────────────────┤
│ Palabra clave       │ static              │ (ninguna)           │
│ Copias en memoria   │ 1 por clase         │ 1 por objeto        │
│ Ubicación memoria   │ Method Area         │ Heap                │
│ Compartidas         │ Sí                  │ No                  │
│ Acceso sin objeto   │ Sí                  │ No                  │
│ Inicialización      │ Al cargar clase     │ Al crear objeto     │
│ Modificación        │ Afecta a todos      │ Solo al objeto      │
└─────────────────────┴─────────────────────┴─────────────────────┘

🔍 IDENTIFICACIÓN RÁPIDA:

ESTÁTICAS (static):
• ¿Es igual para todos? → static
• ¿Necesitas sin objeto? → static  
• ¿Contador global? → static
• ¿Constante universal? → static

INSTANCIA (no static):
• ¿Diferente por objeto? → instancia
• ¿Estado individual? → instancia
• ¿Atributo personal? → instancia
• ¿Valor único por objeto? → instancia

💡 EJEMPLOS PRÁCTICOS:

ESTÁTICAS:
• nombreEmpresa, direccionOficina
• contadorUsuarios, totalVentas
• PI, VERSION_APP, CODIGO_PAIS
• configuraciones compartidas

INSTANCIA:
• nombre, edad, salario (de empleado)
• saldo (de cuenta bancaria)
• posicionX, posicionY (de objeto gráfico)
• estado, configuraciones personales

🎯 OBJETIVO FINAL:
Elegir el tipo correcto de variable según si los datos
deben ser compartidos (static) o individuales (instancia).
*/
