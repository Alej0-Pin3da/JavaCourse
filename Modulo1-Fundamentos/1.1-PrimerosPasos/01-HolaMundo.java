/**
 * ARCHIVO 01: Repaso - Sintaxis básica de Java
 * 
 * CONCEPTOS EXPLICADOS:
 * - Estructura obligatoria de clases en Java
 * - El método main() como punto de entrada
 * - Diferencias clave con otros lenguajes
 * - Sensibilidad a mayúsculas/minúsculas
 * - Proceso de compilación a bytecode
 */
public class HolaMundo {
    
    /*
     * CONCEPTO 1: MÉTODO MAIN()
     * 
     * En Java, TODA aplicación ejecutable debe tener un método main con esta 
     * signatura exacta:
     * 
     * - public: Debe ser accesible desde cualquier lugar (la JVM lo necesita)
     * - static: No requiere crear una instancia de la clase para ejecutarlo
     * - void: No retorna ningún valor
     * - main: Nombre específico que busca la JVM al ejecutar el programa
     * - String[] args: Parámetros de línea de comandos como array de strings
     * 
     * DIFERENCIAS CON OTROS LENGUAJES:
     * - C/C++: int main() o int main(int argc, char* argv[])
     * - Python: if __name__ == "__main__":
     * - JavaScript: No hay punto de entrada fijo
     */
    public static void main(String[] args) {
        
        /*
         * CONCEPTO 2: ESTRUCTURA OBLIGATORIA DE CLASES
         * 
         * En Java, TODO el código debe estar dentro de una clase.
         * No existen funciones globales como en C/C++ o JavaScript.
         * 
         * El nombre del archivo DEBE coincidir exactamente con el nombre 
         * de la clase pública: 01-HolaMundo.java -> public class HolaMundo
         */
        
        /*
         * CONCEPTO 3: SYSTEM.OUT
         * 
         * System.out es un objeto de tipo PrintStream que representa 
         * la salida estándar (consola).
         * 
         * - println(): Imprime y agrega salto de línea
         * - print(): Imprime sin salto de línea  
         * - printf(): Imprime con formato (similar a C)
         */
        System.out.println("¡Hola Java!");
        
        /*
         * CONCEPTO 4: CASE SENSITIVITY
         * 
         * Java distingue entre mayúsculas y minúsculas:
         * - System ≠ system
         * - String ≠ string
         * - main ≠ Main
         * 
         * Esto es diferente a lenguajes como SQL o Visual Basic.
         */
        
        /*
         * CONCEPTO 5: COMPILACIÓN A BYTECODE
         * 
         * Proceso de ejecución en Java:
         * 1. Código fuente (.java) se compila con javac
         * 2. Se genera bytecode (.class) - código intermedio
         * 3. La JVM ejecuta el bytecode
         * 
         * Ventaja: "Write Once, Run Anywhere" (WORA)
         * El mismo .class funciona en Windows, Linux, Mac, etc.
         */
        System.out.printf("Versión: Java %d\n", 8);
        
        /*
         * CONCEPTO 6: FUERTEMENTE TIPADO
         * 
         * Java requiere declarar el tipo de cada variable:
         * - int numero = 10;  ✓ Correcto
         * - var numero = 10;  ✗ Error (var existe desde Java 10, con limitaciones)
         * 
         * Esto previene muchos errores en tiempo de compilación.
         */
        
        System.out.println("\n=== RESUMEN DE DIFERENCIAS ===");
        System.out.println("1. Todo debe estar en una clase");
        System.out.println("2. Método main() obligatorio y específico");
        System.out.println("3. Case sensitive");
        System.out.println("4. Fuertemente tipado");
        System.out.println("5. Compilado a bytecode (portable)");
        System.out.println("6. Orientado a objetos puro");
    }
}
