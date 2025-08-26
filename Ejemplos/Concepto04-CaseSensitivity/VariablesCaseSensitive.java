/**
 * CONCEPTO 4: CASE SENSITIVITY
 * 
 * Ejemplo: Variables y case sensitivity
 * Demuestra cómo Java distingue entre mayúsculas y minúsculas
 */
public class VariablesCaseSensitive {
    
    public static void main(String[] args) {
        System.out.println("=== JAVA ES CASE SENSITIVE ===");
        System.out.println("Todas estas son VARIABLES DIFERENTES:");
        
        // Estas son 4 variables completamente diferentes
        int edad = 25;
        int Edad = 30;
        int EDAD = 35;  
        int EdAd = 40;
        
        System.out.println("edad = " + edad);    // 25
        System.out.println("Edad = " + Edad);    // 30
        System.out.println("EDAD = " + EDAD);    // 35
        System.out.println("EdAd = " + EdAd);    // 40
        
        System.out.println("\n=== STRINGS CASE SENSITIVE ===");
        
        String nombre = "juan";
        String Nombre = "María";
        String NOMBRE = "CARLOS";
        String NoMbRe = "Ana";
        
        System.out.println("nombre = " + nombre);    // juan
        System.out.println("Nombre = " + Nombre);    // María  
        System.out.println("NOMBRE = " + NOMBRE);    // CARLOS
        System.out.println("NoMbRe = " + NoMbRe);    // Ana
        
        System.out.println("\n=== CARACTERES CASE SENSITIVE ===");
        
        char minuscula = 'a';
        char mayuscula = 'A';
        
        System.out.println("minuscula = " + minuscula);    // a
        System.out.println("mayuscula = " + mayuscula);    // A
        System.out.println("¿Son iguales? " + (minuscula == mayuscula)); // false
        
        // Códigos ASCII diferentes
        System.out.println("Código ASCII de 'a': " + (int)minuscula);  // 97
        System.out.println("Código ASCII de 'A': " + (int)mayuscula);  // 65
        
        System.out.println("\n=== BOOLEANS CASE SENSITIVE ===");
        
        boolean activo = true;
        boolean Activo = false;
        boolean ACTIVO = true;
        
        System.out.println("activo = " + activo);    // true
        System.out.println("Activo = " + Activo);    // false  
        System.out.println("ACTIVO = " + ACTIVO);    // true
        
        System.out.println("\n=== EJEMPLOS PRÁCTICOS ===");
        
        // Casos que pueden confundir a principiantes
        String usuario = "admin";
        String Usuario = "guest";  
        String USUARIO = "root";
        
        System.out.println("Sistema de usuarios diferentes:");
        System.out.println("- Usuario básico: " + usuario);
        System.out.println("- Usuario invitado: " + Usuario);
        System.out.println("- Usuario administrador: " + USUARIO);
        
        // Contadores independientes
        int contador = 0;
        int Contador = 10;
        int CONTADOR = 100;
        
        contador++;
        Contador += 5;
        CONTADOR *= 2;
        
        System.out.println("\nContadores independientes:");
        System.out.println("contador = " + contador);    // 1
        System.out.println("Contador = " + Contador);    // 15
        System.out.println("CONTADOR = " + CONTADOR);    // 200
        
        System.out.println("\n=== DEMOSTRACIÓN DE ERRORES COMUNES ===");
        
        // Ejemplo de error común
        String password = "secreto123";
        // String Password = "admin456";  // Variable diferente!
        
        System.out.println("Password original: " + password);
        
        // Si intentáramos hacer esto (común error de principiantes):
        // if (password.equals(Password)) {  // Compararía variables diferentes!
        //     System.out.println("Coinciden");
        // }
        
        // Correcto sería comparar con el valor esperado:
        if (password.equals("secreto123")) {
            System.out.println("Password correcto");
        }
        
        System.out.println("\n¡Recuerda: Java distingue TODAS las mayúsculas y minúsculas!");
    }
}

/*
PUNTOS CLAVE SOBRE CASE SENSITIVITY:

1. VARIABLES:
   - edad, Edad, EDAD, EdAd son variables DIFERENTES
   - Cada una ocupa su propio espacio en memoria
   - Pueden tener valores y tipos diferentes

2. STRINGS:
   - "Hola" ≠ "hola" ≠ "HOLA"
   - Son objetos String completamente diferentes
   - Para comparar sin case sensitivity: str1.equalsIgnoreCase(str2)

3. CARACTERES:
   - 'A' ≠ 'a'
   - Tienen códigos ASCII diferentes (65 vs 97)
   - Para convertir: Character.toLowerCase() / toUpperCase()

4. ERRORES COMUNES:
   - Definir variables con nombres similares pero diferente case
   - Confundir variables al usarlas
   - Problemas de debug por variables "parecidas"

5. BUENAS PRÁCTICAS:
   - Usar convenciones consistentes (camelCase)
   - Evitar nombres que solo difieren en mayúsculas/minúsculas
   - Ser cuidadoso con los nombres de variables

CONVENCIONES ESTÁNDAR:
- Variables y métodos: camelCase (miVariable, miMetodo)
- Constantes: UPPER_SNAKE_CASE (MI_CONSTANTE)
- Clases: PascalCase (MiClase)
*/
