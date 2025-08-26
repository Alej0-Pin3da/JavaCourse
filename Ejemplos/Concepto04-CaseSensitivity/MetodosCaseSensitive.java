/**
 * CONCEPTO 4: CASE SENSITIVITY
 * 
 * Ejemplo: Métodos y case sensitivity
 * Demuestra cómo los nombres de métodos también son case sensitive
 */
public class MetodosCaseSensitive {
    
    // Estos son métodos DIFERENTES porque Java es case sensitive
    public static void mostrarMensaje() {
        System.out.println("Método: mostrarMensaje()");
    }
    
    public static void MostrarMensaje() {
        System.out.println("Método: MostrarMensaje()");
    }
    
    public static void MOSTRARMENSAJE() {
        System.out.println("Método: MOSTRARMENSAJE()");
    }
    
    public static void MoStRaRmEnSaJe() {
        System.out.println("Método: MoStRaRmEnSaJe()");
    }
    
    // Métodos con funcionalidades diferentes basados en case sensitivity
    public static int sumar(int a, int b) {
        System.out.println("Ejecutando método: sumar()");
        return a + b;
    }
    
    public static int Sumar(int a, int b) {
        System.out.println("Ejecutando método: Sumar() - Con logging");
        int resultado = a + b;
        System.out.println("Resultado de la suma: " + resultado);
        return resultado;
    }
    
    public static int SUMAR(int a, int b) {
        System.out.println("Ejecutando método: SUMAR() - Con validación");
        if (a < 0 || b < 0) {
            System.out.println("ADVERTENCIA: Números negativos detectados");
        }
        return a + b;
    }
    
    // Métodos de saludo con diferentes comportamientos
    public static void saludar(String nombre) {
        System.out.println("Hola, " + nombre);
    }
    
    public static void Saludar(String nombre) {
        System.out.println("¡Buenos días, " + nombre + "!");
    }
    
    public static void SALUDAR(String nombre) {
        System.out.println("¡¡¡HOLA " + nombre.toUpperCase() + "!!!");
    }
    
    // Métodos de conversión
    public static String convertir(String texto) {
        System.out.println("Método convertir(): convierte a minúsculas");
        return texto.toLowerCase();
    }
    
    public static String Convertir(String texto) {
        System.out.println("Método Convertir(): convierte a mayúsculas");
        return texto.toUpperCase();
    }
    
    public static String CONVERTIR(String texto) {
        System.out.println("Método CONVERTIR(): alterna mayúsculas y minúsculas");
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (i % 2 == 0) {
                resultado.append(Character.toUpperCase(c));
            } else {
                resultado.append(Character.toLowerCase(c));
            }
        }
        return resultado.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("=== MÉTODOS CASE SENSITIVE ===");
        System.out.println("Llamando a métodos con nombres similares pero diferentes:");
        
        // Llamando a los métodos de mostrar mensaje
        mostrarMensaje();      // minúsculas
        MostrarMensaje();      // PascalCase  
        MOSTRARMENSAJE();      // MAYÚSCULAS
        MoStRaRmEnSaJe();      // MixedCase
        
        System.out.println("\n=== MÉTODOS DE SUMA CON DIFERENTES COMPORTAMIENTOS ===");
        
        int num1 = 10;
        int num2 = 5;
        
        // Tres métodos diferentes con comportamientos distintos
        int resultado1 = sumar(num1, num2);        // Suma simple
        int resultado2 = Sumar(num1, num2);        // Suma con logging
        int resultado3 = SUMAR(-3, num2);          // Suma con validación
        
        System.out.println("Resultado sumar(): " + resultado1);
        System.out.println("Resultado Sumar(): " + resultado2);
        System.out.println("Resultado SUMAR(): " + resultado3);
        
        System.out.println("\n=== MÉTODOS DE SALUDO ===");
        
        String nombre = "Ana";
        
        saludar(nombre);     // Saludo simple
        Saludar(nombre);     // Saludo formal
        SALUDAR(nombre);     // Saludo enfático
        
        System.out.println("\n=== MÉTODOS DE CONVERSIÓN ===");
        
        String texto = "Hola Mundo";
        
        System.out.println("Texto original: " + texto);
        System.out.println("convertir(): " + convertir(texto));
        System.out.println("Convertir(): " + Convertir(texto));
        System.out.println("CONVERTIR(): " + CONVERTIR(texto));
        
        System.out.println("\n=== DEMOSTRANDO LA IMPORTANCIA ===");
        
        // En un proyecto real, podrías tener métodos como:
        System.out.println("Ejemplo de uso práctico:");
        
        // Método para obtener datos (sin formatear)
        obtenerDatos();
        
        // Método para obtener datos formateados
        ObtenerDatos();
        
        // Método para obtener datos con validación
        OBTENERDATOS();
        
        System.out.println("\n=== ERRORES COMUNES ===");
        System.out.println("¡Cuidado! Estos son métodos DIFERENTES:");
        System.out.println("- calcular() vs Calcular() vs CALCULAR()");
        System.out.println("- validar() vs Validar() vs VALIDAR()");
        System.out.println("- procesar() vs Procesar() vs PROCESAR()");
        System.out.println("\nSi llamas al método equivocado, obtienes comportamiento diferente!");
        
        System.out.println("\n=== DEMOSTRACIÓN FINAL ===");
        demostracionFinal();
    }
    
    // Métodos auxiliares para los ejemplos
    public static void obtenerDatos() {
        System.out.println("obtenerDatos(): Devolviendo datos sin procesar...");
    }
    
    public static void ObtenerDatos() {
        System.out.println("ObtenerDatos(): Devolviendo datos formateados...");
    }
    
    public static void OBTENERDATOS() {
        System.out.println("OBTENERDATOS(): Validando y devolviendo datos seguros...");
    }
    
    public static void demostracionFinal() {
        System.out.println("Los nombres de métodos en Java son CASE SENSITIVE:");
        System.out.println("- Cada variación de mayúsculas/minúsculas es un método DIFERENTE");
        System.out.println("- Pueden tener parámetros, comportamientos y valores de retorno distintos");
        System.out.println("- Es importante ser consistente con las convenciones de nombres");
    }
}

/*
PUNTOS CLAVE SOBRE CASE SENSITIVITY EN MÉTODOS:

1. NOMBRES DE MÉTODOS:
   - mostrarMensaje() ≠ MostrarMensaje() ≠ MOSTRARMENSAJE()
   - Son métodos completamente diferentes
   - Pueden coexistir en la misma clase
   - Cada uno puede tener comportamiento diferente

2. SOBRECARGA vs CASE SENSITIVITY:
   - La sobrecarga se basa en parámetros diferentes
   - Case sensitivity se basa en nombres diferentes
   - Son conceptos independientes

3. CONVENCIONES ESTÁNDAR:
   - Métodos: camelCase (miMetodo, calcularTotal)
   - Evitar métodos que solo difieren en mayúsculas/minúsculas
   - Mantener consistencia en todo el proyecto

4. ERRORES COMUNES:
   - Crear métodos con nombres que solo difieren en case
   - Llamar al método equivocado por error de escritura
   - Problemas de mantenimiento con nombres similares

5. BUENAS PRÁCTICAS:
   - Usar nombres descriptivos y consistentes
   - Seguir convenciones de naming de Java
   - Evitar confusión con nombres similares
   - Documentar métodos cuando sea necesario

6. IMPLICACIONES:
   - Un error de mayúsculas/minúsculas = método diferente
   - Puede causar errores de compilación o lógica
   - Importante para el mantenimiento del código
*/
