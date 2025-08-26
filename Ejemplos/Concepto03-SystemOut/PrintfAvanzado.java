/**
 * CONCEPTO 3: Salida estándar (System.out)
 * 
 * Ejemplo: Uso avanzado de printf()
 * Demuestra formateo con especificadores y modificadores
 */
public class PrintfAvanzado {
    
    public static void main(String[] args) {
        System.out.println("=== PRINTF BÁSICO ===");
        
        String nombre = "María";
        int edad = 28;
        double salario = 2500.75;
        boolean activo = true;
        
        // Especificadores básicos
        System.out.printf("Nombre: %s%n", nombre);
        System.out.printf("Edad: %d años%n", edad);  
        System.out.printf("Salario: $%.2f%n", salario);
        System.out.printf("Activo: %b%n", activo);
        
        System.out.printf("%n=== FORMATO DE NÚMEROS ===%n");
        
        double numero = 1234.56789;
        
        System.out.printf("Número original: %f%n", numero);
        System.out.printf("Con 2 decimales: %.2f%n", numero);
        System.out.printf("Con 4 decimales: %.4f%n", numero);
        System.out.printf("Sin decimales: %.0f%n", numero);
        
        // Formatos numéricos especiales
        int entero = 255;
        System.out.printf("Decimal: %d%n", entero);
        System.out.printf("Octal: %o%n", entero);
        System.out.printf("Hexadecimal: %x%n", entero);
        System.out.printf("Hexadecimal mayúscula: %X%n", entero);
        
        System.out.printf("%n=== ANCHO DE CAMPO ===%n");
        
        // Controlar ancho de campo
        System.out.printf("Sin ancho: '%s'%n", "Java");
        System.out.printf("Ancho 10: '%10s'%n", "Java");
        System.out.printf("Ancho 15: '%15s'%n", "Java");
        
        // Alineación (por defecto a la derecha para números, izquierda para texto)
        System.out.printf("Número a la derecha: '%5d'%n", 42);
        System.out.printf("Número a la izquierda: '%-5d'%n", 42);
        
        System.out.printf("%n=== TABLA FORMATEADA ===%n");
        
        // Crear tabla con printf
        System.out.printf("%-15s | %-8s | %10s | %8s%n", 
                         "PRODUCTO", "CÓDIGO", "PRECIO", "STOCK");
        System.out.printf("%-15s-+-%-8s-+-%10s-+-%8s%n", 
                         "---------------", "--------", "----------", "--------");
        
        System.out.printf("%-15s | %-8d | $%9.2f | %8d%n", 
                         "Laptop", 1001, 1299.99, 15);
        System.out.printf("%-15s | %-8d | $%9.2f | %8d%n", 
                         "Mouse", 1002, 25.50, 150);
        System.out.printf("%-15s | %-8d | $%9.2f | %8d%n", 
                         "Teclado", 1003, 75.00, 89);
        
        System.out.printf("%n=== RELLENO CON CEROS ===%n");
        
        int id = 42;
        System.out.printf("ID sin formato: %d%n", id);
        System.out.printf("ID con ceros: %05d%n", id);
        System.out.printf("ID con ceros: %08d%n", id);
        
        // Fechas con formato
        int dia = 5, mes = 3, año = 2024;
        System.out.printf("Fecha: %02d/%02d/%04d%n", dia, mes, año);
        
        System.out.printf("%n=== SIGNOS Y ESPACIOS ===%n");
        
        int positivo = 100;
        int negativo = -50;
        
        System.out.printf("Normal: %d, %d%n", positivo, negativo);
        System.out.printf("Con signo: %+d, %+d%n", positivo, negativo);
        System.out.printf("Con espacio: % d, % d%n", positivo, negativo);
        
        System.out.printf("%n=== NOTACIÓN CIENTÍFICA ===%n");
        
        double grande = 123456.789;
        double pequeño = 0.0000123;
        
        System.out.printf("Normal: %f, %f%n", grande, pequeño);
        System.out.printf("Científica: %e, %e%n", grande, pequeño);
        System.out.printf("Científica mayúscula: %E, %E%n", grande, pequeño);
        
        System.out.printf("%n=== CARACTERES ===%n");
        
        int codigoAscii = 65;
        char letra = 'A';
        
        System.out.printf("Código ASCII %d es el carácter: %c%n", codigoAscii, codigoAscii);
        System.out.printf("El carácter %c tiene código: %d%n", letra, (int)letra);
        
        System.out.printf("%n=== PORCENTAJE LITERAL ===%n");
        
        double porcentaje = 85.5;
        System.out.printf("Progreso: %.1f%%%n", porcentaje);  // %% imprime %
        
        System.out.printf("%n¡Ejemplos de printf completados!%n");
    }
}

/*
ESPECIFICADORES DE PRINTF MÁS IMPORTANTES:

%s  - String (cualquier objeto)
%d  - Entero decimal
%f  - Número flotante
%e  - Notación científica (minúsculas)  
%E  - Notación científica (mayúsculas)
%c  - Carácter
%b  - Boolean
%x  - Hexadecimal (minúsculas)
%X  - Hexadecimal (mayúsculas)
%o  - Octal
%%  - Símbolo % literal
%n  - Nueva línea (portable)

MODIFICADORES DE FORMATO:

%-   Alineación a la izquierda
%+   Mostrar signo siempre  
%    Espacio para números positivos
%0   Rellenar con ceros
%.n  Precisión decimal (n dígitos)
%n   Ancho mínimo de campo

EJEMPLOS DE PATRONES:
%5d     - Entero con ancho mínimo 5
%-10s   - String alineado a izquierda, ancho 10
%08d    - Entero con ceros, ancho 8
%.2f    - Flotante con 2 decimales
%+.2f   - Flotante con signo y 2 decimales
*/
