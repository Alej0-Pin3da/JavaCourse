/**
 * CONCEPTO 1: El método main() - Punto de entrada
 * 
 * Ejemplo: Variaciones válidas de la firma del método main()
 * Demuestra diferentes formas sintácticamente correctas
 */
public class VariacionesMain {
    
    // ✅ Forma estándar y recomendada
    public static void main(String[] args) {
        System.out.println("=== Método main() estándar ===");
        System.out.println("Esta es la forma recomendada");
        
        // Llamar otros métodos main para demostrar que todos funcionan
        main2(args);
        main3(args);
        main4(args);
    }
    
    // ✅ Variación: array después del nombre del parámetro
    public static void main2(String args[]) {
        System.out.println("\n=== Variación con String args[] ===");
        System.out.println("Sintaxis válida pero menos común");
    }
    
    // ✅ Variación: nombre diferente del parámetro
    public static void main3(String[] parametros) {
        System.out.println("\n=== Variación con nombre 'parametros' ===");
        System.out.println("El nombre del parámetro puede cambiar");
    }
    
    // ✅ Variación: modificador final
    public static void main4(final String[] args) {
        System.out.println("\n=== Variación con 'final' ===");
        System.out.println("Se puede usar 'final' en el parámetro");
        // args = new String[0]; // Esto daría error por 'final'
    }
    
    // ❌ ESTAS NO FUNCIONAN COMO PUNTO DE ENTRADA:
    /*
    private static void main(String[] args) { } // private - no public
    public void main(String[] args) { }         // no static
    public static int main(String[] args) { }   // no void
    public static void main() { }               // sin parámetros
    public static void main(String args) { }    // no es array
    public static void main(int[] args) { }     // no es String[]
    */
}

/*
PUNTOS CLAVE:
1. Debe ser: public static void
2. Nombre exacto: main
3. Parámetro: String[] (el nombre puede variar)
4. El orden de 'public static' no importa: 'static public' también funciona
5. Solo puede haber UN método main que actúe como punto de entrada
*/
