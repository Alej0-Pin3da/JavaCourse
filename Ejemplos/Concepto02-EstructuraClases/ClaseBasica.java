/**
 * CONCEPTO 2: Estructura de clases
 * 
 * Ejemplo: Clase básica con estructura mínima
 * Demuestra los componentes esenciales de una clase Java
 */
public class ClaseBasica {
    
    // Constructor por defecto (opcional - Java lo crea automáticamente si no existe)
    public ClaseBasica() {
        System.out.println("Objeto ClaseBasica creado");
    }
    
    // Método main - punto de entrada
    public static void main(String[] args) {
        System.out.println("=== Estructura de Clase Básica ===");
        
        // Crear una instancia de la propia clase
        ClaseBasica objeto = new ClaseBasica();
        
        System.out.println("Clase ejecutándose correctamente");
    }
}

/*
ESTRUCTURA MÍNIMA DE UNA CLASE JAVA:

1. Declaración de la clase: public class NombreClase
2. Cuerpo de la clase: { ... }
3. Para ser ejecutable: método main()

REGLAS IMPORTANTES:
- El nombre del archivo debe coincidir exactamente con el nombre de la clase
- Solo puede haber una clase public por archivo
- La clase public debe tener el mismo nombre que el archivo
*/
