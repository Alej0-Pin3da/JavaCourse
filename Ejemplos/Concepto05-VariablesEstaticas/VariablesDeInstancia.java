/**
 * CONCEPTO 5: VARIABLES ESTÁTICAS VS DE INSTANCIA
 * 
 * Ejemplo: Variables de instancia - específicas para cada objeto
 * Demuestra el comportamiento independiente de las variables de instancia
 */
public class VariablesDeInstancia {
    
    // VARIABLES DE INSTANCIA - cada objeto tiene su propia copia
    private String nombre;
    private int edad;
    private double altura;
    private String email;
    private boolean activo;
    private int numeroIdentificacion;
    
    // Variable estática para generar IDs únicos
    private static int contadorId = 1000;
    
    // CONSTRUCTOR - inicializa variables de instancia
    public VariablesDeInstancia(String nombre, int edad, double altura, String email) {
        // Cada instancia tiene sus propios valores
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.email = email;
        this.activo = true;  // Por defecto activo
        
        // Asignar ID único usando variable estática
        this.numeroIdentificacion = contadorId++;
        
        System.out.println("✅ Nuevo objeto creado con ID: " + this.numeroIdentificacion);
    }
    
    // MÉTODOS DE INSTANCIA - operan sobre las variables de instancia
    public void mostrarInformacion() {
        System.out.println("--- Información Personal ---");
        System.out.println("ID: " + this.numeroIdentificacion);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Edad: " + this.edad + " años");
        System.out.println("Altura: " + this.altura + " m");
        System.out.println("Email: " + this.email);
        System.out.println("Estado: " + (this.activo ? "Activo" : "Inactivo"));
        System.out.println();
    }
    
    // Métodos para modificar variables de instancia
    public void cambiarNombre(String nuevoNombre) {
        String nombreAnterior = this.nombre;
        this.nombre = nuevoNombre;
        System.out.println("ID " + this.numeroIdentificacion + ": Nombre cambiado de '" + nombreAnterior + "' a '" + nuevoNombre + "'");
    }
    
    public void cumplirAnios() {
        this.edad++;
        System.out.println("¡Feliz cumpleaños " + this.nombre + "! Ahora tienes " + this.edad + " años");
    }
    
    public void cambiarEstado() {
        this.activo = !this.activo;
        System.out.println(this.nombre + " ahora está: " + (this.activo ? "Activo" : "Inactivo"));
    }
    
    public void actualizarEmail(String nuevoEmail) {
        String emailAnterior = this.email;
        this.email = nuevoEmail;
        System.out.println(this.nombre + ": Email actualizado de '" + emailAnterior + "' a '" + nuevoEmail + "'");
    }
    
    // Métodos getter para acceder a variables de instancia
    public String getNombre() { return this.nombre; }
    public int getEdad() { return this.edad; }
    public double getAltura() { return this.altura; }
    public String getEmail() { return this.email; }
    public boolean isActivo() { return this.activo; }
    public int getNumeroIdentificacion() { return this.numeroIdentificacion; }
    
    // Método estático para mostrar el total de objetos creados
    public static int getTotalObjetosCreados() {
        return contadorId - 1000;  // Restamos el valor inicial
    }
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN: VARIABLES DE INSTANCIA ===\n");
        
        // 1. Crear múltiples objetos
        System.out.println("1. CREANDO MÚLTIPLES OBJETOS:");
        
        VariablesDeInstancia persona1 = new VariablesDeInstancia("Ana García", 25, 1.65, "ana@email.com");
        VariablesDeInstancia persona2 = new VariablesDeInstancia("Carlos López", 30, 1.78, "carlos@email.com");
        VariablesDeInstancia persona3 = new VariablesDeInstancia("María Rodríguez", 28, 1.60, "maria@email.com");
        
        System.out.println("Total de objetos creados: " + getTotalObjetosCreados());
        System.out.println();
        
        // 2. Mostrar que cada objeto tiene sus propias variables
        System.out.println("2. CADA OBJETO TIENE SUS PROPIAS VARIABLES:");
        persona1.mostrarInformacion();
        persona2.mostrarInformacion(); 
        persona3.mostrarInformacion();
        
        // 3. Modificar variables de instancia independientemente
        System.out.println("3. MODIFICANDO VARIABLES DE INSTANCIA INDEPENDIENTEMENTE:");
        
        System.out.println("--- Modificando solo persona1 ---");
        persona1.cambiarNombre("Ana María García");
        persona1.cumplirAnios();
        persona1.actualizarEmail("anamaria@newemail.com");
        
        System.out.println("\n--- Modificando solo persona2 ---");
        persona2.cumplirAnios();
        persona2.cambiarEstado();
        
        System.out.println("\n--- Modificando solo persona3 ---");
        persona3.cambiarNombre("María Elena Rodríguez");
        persona3.cambiarEstado();
        persona3.actualizarEmail("mariaelena@email.com");
        
        System.out.println();
        
        // 4. Verificar que los cambios son independientes
        System.out.println("4. VERIFICANDO QUE LOS CAMBIOS SON INDEPENDIENTES:");
        System.out.println("Después de las modificaciones:");
        
        persona1.mostrarInformacion();
        persona2.mostrarInformacion();
        persona3.mostrarInformacion();
        
        // 5. Demostrar independencia de memoria
        System.out.println("5. DEMOSTRACIÓN DE INDEPENDENCIA DE MEMORIA:");
        demostracionIndependenciaMemoria(persona1, persona2, persona3);
        
        // 6. Crear más objetos para demostrar que cada uno es independiente
        System.out.println("6. CREANDO MÁS OBJETOS PARA DEMOSTRAR INDEPENDENCIA:");
        
        VariablesDeInstancia persona4 = new VariablesDeInstancia("Roberto Silva", 35, 1.80, "roberto@email.com");
        VariablesDeInstancia persona5 = new VariablesDeInstancia("Laura Mendez", 22, 1.55, "laura@email.com");
        
        System.out.println("\nTodos los objetos actuales:");
        VariablesDeInstancia[] todasLasPersonas = {persona1, persona2, persona3, persona4, persona5};
        
        for (int i = 0; i < todasLasPersonas.length; i++) {
            System.out.printf("Objeto %d: ID=%d, Nombre=%s, Edad=%d%n", 
                            (i + 1), 
                            todasLasPersonas[i].getNumeroIdentificacion(),
                            todasLasPersonas[i].getNombre(),
                            todasLasPersonas[i].getEdad());
        }
        
        System.out.println("\nTotal de objetos creados: " + getTotalObjetosCreados());
        
        // 7. Demostrar que modificar uno no afecta a otros
        System.out.println("\n7. DEMOSTRANDO QUE MODIFICAR UNO NO AFECTA A OTROS:");
        System.out.println("Modificando persona4...");
        
        persona4.cambiarNombre("Roberto Carlos Silva");
        persona4.cumplirAnios();
        persona4.cumplirAnios();  // Dos cumpleaños
        persona4.cambiarEstado();
        
        System.out.println("\nEstado final de persona4:");
        persona4.mostrarInformacion();
        
        System.out.println("Estado de persona5 (SIN cambios):");
        persona5.mostrarInformacion();
        
        System.out.println("→ ¡Los cambios en persona4 NO afectaron a persona5!");
        
        // 8. Comparación final
        System.out.println("8. COMPARACIÓN FINAL:");
        compararObjetos(persona1, persona2, persona3, persona4, persona5);
    }
    
    public static void demostracionIndependenciaMemoria(VariablesDeInstancia p1, VariablesDeInstancia p2, VariablesDeInstancia p3) {
        System.out.println("📊 ANÁLISIS DE MEMORIA PARA VARIABLES DE INSTANCIA:");
        
        System.out.println("\n🔹 CADA OBJETO TIENE SU PROPIA COPIA:");
        System.out.printf("Persona 1 (ID: %d):%n", p1.getNumeroIdentificacion());
        System.out.printf("  ├── nombre: '%s' (su propia copia)%n", p1.getNombre());
        System.out.printf("  ├── edad: %d (su propia copia)%n", p1.getEdad());
        System.out.printf("  ├── altura: %.2f (su propia copia)%n", p1.getAltura());
        System.out.printf("  └── email: '%s' (su propia copia)%n", p1.getEmail());
        
        System.out.printf("%nPersona 2 (ID: %d):%n", p2.getNumeroIdentificacion());
        System.out.printf("  ├── nombre: '%s' (DIFERENTE copia)%n", p2.getNombre());
        System.out.printf("  ├── edad: %d (DIFERENTE copia)%n", p2.getEdad());
        System.out.printf("  ├── altura: %.2f (DIFERENTE copia)%n", p2.getAltura());
        System.out.printf("  └── email: '%s' (DIFERENTE copia)%n", p2.getEmail());
        
        System.out.printf("%nPersona 3 (ID: %d):%n", p3.getNumeroIdentificacion());
        System.out.printf("  ├── nombre: '%s' (DIFERENTE copia)%n", p3.getNombre());
        System.out.printf("  ├── edad: %d (DIFERENTE copia)%n", p3.getEdad());
        System.out.printf("  ├── altura: %.2f (DIFERENTE copia)%n", p3.getAltura());
        System.out.printf("  └── email: '%s' (DIFERENTE copia)%n", p3.getEmail());
        
        System.out.println("\n💡 REPRESENTACIÓN VISUAL:");
        System.out.println("HEAP DE MEMORIA:");
        System.out.println("┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐");
        System.out.println("│   Objeto p1     │    │   Objeto p2     │    │   Objeto p3     │");
        System.out.println("├─────────────────┤    ├─────────────────┤    ├─────────────────┤");
        System.out.printf("│ nombre: %-7s │    │ nombre: %-7s │    │ nombre: %-7s │%n", 
                         p1.getNombre().split(" ")[0], p2.getNombre().split(" ")[0], p3.getNombre().split(" ")[0]);
        System.out.printf("│ edad: %-9d │    │ edad: %-9d │    │ edad: %-9d │%n", p1.getEdad(), p2.getEdad(), p3.getEdad());
        System.out.printf("│ altura: %-7.2f │    │ altura: %-7.2f │    │ altura: %-7.2f │%n", p1.getAltura(), p2.getAltura(), p3.getAltura());
        System.out.printf("│ activo: %-7s │    │ activo: %-7s │    │ activo: %-7s │%n", p1.isActivo(), p2.isActivo(), p3.isActivo());
        System.out.println("└─────────────────┘    └─────────────────┘    └─────────────────┘");
        
        System.out.println("\n🎯 CONCLUSIÓN:");
        System.out.println("• Cada objeto ocupa su propio espacio en memoria");
        System.out.println("• Modificar variables en un objeto NO afecta a otros objetos");
        System.out.println("• Las variables de instancia son INDEPENDIENTES entre objetos");
        System.out.println("• Esto permite que cada objeto mantenga su propio estado");
        System.out.println();
    }
    
    public static void compararObjetos(VariablesDeInstancia... personas) {
        System.out.println("🔍 COMPARACIÓN DETALLADA DE TODOS LOS OBJETOS:");
        System.out.println();
        
        System.out.printf("%-3s %-4s %-20s %-4s %-7s %-25s %-7s%n", 
                         "N°", "ID", "NOMBRE", "EDAD", "ALTURA", "EMAIL", "ACTIVO");
        System.out.println("───────────────────────────────────────────────────────────────────────────");
        
        for (int i = 0; i < personas.length; i++) {
            VariablesDeInstancia p = personas[i];
            System.out.printf("%-3d %-4d %-20s %-4d %-7.2f %-25s %-7s%n",
                            (i + 1),
                            p.getNumeroIdentificacion(),
                            p.getNombre(),
                            p.getEdad(),
                            p.getAltura(),
                            p.getEmail(),
                            p.isActivo() ? "Sí" : "No");
        }
        
        System.out.println("\n💡 OBSERVACIONES:");
        System.out.println("• Cada fila representa un OBJETO DIFERENTE");
        System.out.println("• Cada objeto tiene sus PROPIOS VALORES para cada variable");
        System.out.println("• Los IDs son únicos (generados con variable estática)");
        System.out.println("• Cambiar valores en una fila NO afecta a las otras filas");
        System.out.println("• Esta es la esencia de las VARIABLES DE INSTANCIA");
    }
}

/*
RESUMEN: VARIABLES DE INSTANCIA

🎯 CARACTERÍSTICAS PRINCIPALES:

1. INDEPENDENCIA:
   • Cada objeto tiene su propia copia
   • Modificar en un objeto NO afecta a otros
   • Valores pueden ser diferentes entre objetos
   • Estado individual para cada instancia

2. MEMORIA:
   • Se almacenan en el HEAP
   • Cada objeto ocupa su propio espacio
   • Se crean cuando se instancia el objeto
   • Se destruyen cuando el objeto es recolectado por GC

3. ACCESO:
   • Solo a través de una instancia: objeto.variable
   • No se pueden acceder desde métodos estáticos directamente
   • Requieren la palabra clave 'this' dentro de la clase

4. INICIALIZACIÓN:
   • En el constructor del objeto
   • Con valores por defecto si no se especifican
   • Cada vez que se crea un nuevo objeto

🔄 CICLO DE VIDA:
1. Creación del objeto → Variables de instancia se inicializan
2. Uso del objeto → Variables mantienen estado individual
3. Modificación → Solo afecta al objeto específico
4. Destrucción del objeto → Variables de instancia se liberan

💡 CASOS DE USO TÍPICOS:
• Atributos de una persona (nombre, edad, altura)
• Estado de un objeto (saldo de cuenta, posición)
• Configuraciones específicas por instancia
• Datos que varían entre objetos de la misma clase

✅ VENTAJAS:
• Encapsulación de datos por objeto
• Flexibilidad para diferentes estados
• Facilita la programación orientada a objetos
• Cada objeto es independiente

⚠️ CONSIDERACIONES:
• Más uso de memoria (copia por objeto)
• Requieren instanciación para acceder
• No compartidas entre objetos
• Adecuadas para datos específicos de cada objeto
*/
