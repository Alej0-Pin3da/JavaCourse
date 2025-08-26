/**
 * CONCEPTO 3: Salida estándar (System.out)
 * 
 * Ejemplo: Métodos básicos de salida
 * Demuestra println(), print() y sus diferencias
 */
public class MetodosBasicos {
    
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRANDO println() ===");
        
        // println() agrega automáticamente salto de línea
        System.out.println("Primera línea");
        System.out.println("Segunda línea");
        System.out.println("Tercera línea");
        
        System.out.println("\n=== DEMOSTRANDO print() ===");
        
        // print() NO agrega salto de línea
        System.out.print("Todo ");
        System.out.print("en ");
        System.out.print("la ");
        System.out.print("misma ");
        System.out.print("línea");
        System.out.println(); // Salto de línea manual
        
        System.out.println("\n=== IMPRIMIENDO DIFERENTES TIPOS ===");
        
        // println() puede imprimir cualquier tipo de dato
        System.out.println("String: Hola Mundo");
        System.out.println("Entero: " + 42);
        System.out.println("Decimal: " + 3.14159);
        System.out.println("Boolean: " + true);
        System.out.println("Carácter: " + 'A');
        
        // Impresión directa de tipos primitivos
        System.out.println(100);           // int
        System.out.println(99.99);         // double  
        System.out.println(false);         // boolean
        System.out.println('Z');           // char
        
        System.out.println("\n=== CONCATENACIÓN ===");
        
        String nombre = "Juan";
        int edad = 25;
        double altura = 1.75;
        
        // Concatenación con operador +
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Altura: " + altura + " metros");
        
        // Múltiples concatenaciones
        System.out.println("Perfil completo: " + nombre + ", " + edad + " años, " + altura + "m");
        
        System.out.println("\n=== CARACTERES ESPECIALES ===");
        
        // Caracteres de escape
        System.out.println("Texto con \"comillas\"");
        System.out.println("Ruta: C:\\Usuario\\Documentos");
        System.out.println("Línea 1\nLínea 2");           // \n = nueva línea
        System.out.println("Columna1\tColumna2");          // \t = tabulación
        
        System.out.println("\n¡Programa completado exitosamente!");
    }
}

/*
MÉTODOS BÁSICOS DE System.out:

1. println(valor)
   - Imprime el valor y agrega salto de línea
   - Equivale a: print(valor) + nueva línea

2. print(valor)  
   - Imprime el valor sin salto de línea
   - Útil para construir líneas pieza por pieza

3. println() [sin parámetros]
   - Solo imprime un salto de línea
   - Equivale a imprimir una línea vacía

TIPOS DE DATOS SOPORTADOS:
- String, int, double, float, long, boolean, char
- Cualquier objeto (usa toString() automáticamente)
- null se imprime como "null"

CARACTERES DE ESCAPE COMUNES:
- \" = comillas dobles
- \\ = backslash
- \n = nueva línea  
- \t = tabulación
- \r = retorno de carro
*/
