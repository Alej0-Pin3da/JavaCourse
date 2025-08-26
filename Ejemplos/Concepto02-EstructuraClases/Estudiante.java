/**
 * CONCEPTO 2: Estructura de clases
 * 
 * Ejemplo: Clase completa con todos los componentes
 * Demuestra una clase con atributos, constructor, métodos y encapsulación
 */
public class Estudiante {
    
    // ATRIBUTOS (Variables de instancia)
    private String nombre;        // Encapsulado con private
    private int edad;
    private String carrera;
    private double promedio;
    
    // CONSTRUCTOR con parámetros
    public Estudiante(String nombre, int edad, String carrera) {
        this.nombre = nombre;     // 'this' para distinguir parámetro de atributo
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = 0.0;      // Valor inicial
    }
    
    // MÉTODOS GETTER (para acceder a atributos privados)
    public String getNombre() {
        return nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    // MÉTODOS SETTER (para modificar atributos privados)
    public void setPromedio(double promedio) {
        if (promedio >= 0.0 && promedio <= 10.0) {
            this.promedio = promedio;
        } else {
            System.out.println("Promedio inválido. Debe estar entre 0.0 y 10.0");
        }
    }
    
    // MÉTODOS DE COMPORTAMIENTO
    public void estudiar(String materia) {
        System.out.println(nombre + " está estudiando " + materia);
    }
    
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL ESTUDIANTE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
    }
    
    // MÉTODO MAIN para probar la clase
    public static void main(String[] args) {
        System.out.println("=== Creando estudiantes ===");
        
        // Crear objetos usando el constructor
        Estudiante estudiante1 = new Estudiante("Ana García", 20, "Ingeniería en Sistemas");
        Estudiante estudiante2 = new Estudiante("Carlos López", 19, "Medicina");
        
        // Usar métodos setter
        estudiante1.setPromedio(8.5);
        estudiante2.setPromedio(9.2);
        
        // Mostrar información
        estudiante1.mostrarInformacion();
        System.out.println();
        estudiante2.mostrarInformacion();
        
        // Usar métodos de comportamiento
        System.out.println();
        estudiante1.estudiar("Algoritmos");
        estudiante2.estudiar("Anatomía");
        
        // Demostrar encapsulación
        System.out.println("\n=== Demostrando encapsulación ===");
        System.out.println("Nombre de estudiante1: " + estudiante1.getNombre());
        // estudiante1.nombre = "Nuevo nombre"; // ERROR: no es accesible
    }
}

/*
COMPONENTES DE UNA CLASE COMPLETA:

1. ATRIBUTOS: Variables que definen el estado del objeto
2. CONSTRUCTOR: Método especial para inicializar objetos
3. MÉTODOS GETTER/SETTER: Para acceso controlado a atributos privados
4. MÉTODOS DE COMPORTAMIENTO: Definen qué puede hacer el objeto
5. ENCAPSULACIÓN: Usar private para proteger datos internos

PRINCIPIOS APLICADOS:
- Encapsulación: Atributos privados con acceso controlado
- Abstracción: Interfaz pública limpia
- Responsabilidad única: La clase maneja solo información de estudiantes
*/
