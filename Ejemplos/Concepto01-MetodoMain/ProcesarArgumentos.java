/**
 * CONCEPTO 1: El método main() - Punto de entrada
 * 
 * Ejemplo: Procesando argumentos de línea de comandos
 * Demuestra cómo usar String[] args
 */
public class ProcesarArgumentos {
    
    public static void main(String[] args) {
        // Verificar si se pasaron argumentos
        if (args.length == 0) {
            System.out.println("No se pasaron argumentos.");
            System.out.println("Uso: java ProcesarArgumentos <nombre> <edad> <ciudad>");
            return;
        }
        
        // Mostrar información sobre los argumentos
        System.out.println("Número de argumentos: " + args.length);
        System.out.println("Argumentos recibidos:");
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("  args[" + i + "] = " + args[i]);
        }
        
        // Procesar argumentos específicos si hay suficientes
        if (args.length >= 3) {
            String nombre = args[0];
            String edad = args[1];
            String ciudad = args[2];
            
            System.out.println("\n--- INFORMACIÓN PROCESADA ---");
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad + " años");
            System.out.println("Ciudad: " + ciudad);
        }
    }
}

/*
EJEMPLOS DE EJECUCIÓN:

1. Sin argumentos:
   cd C:\\Users\\alejandropineda\\Documents\\JavaCourse/Ejemplos/Concepto01-MetodoMain ; /usr/bin/env C:\\Program\ Files\\Java\\jdk1.8.0_301\\bin\\java.exe -agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:51073 -cp C:\\Users\\alejandropineda\\AppData\\Roaming\\Code\\User\\workspaceStorage\\8a04df9295bdb249accf22630e0bfcad\\redhat.java\\jdt_ws\\JavaCourse_6494a371\\bin java ProcesarArgumentos
   
2. Con argumentos:
   cd C:\\Users\\alejandropineda\\Documents\\JavaCourse/Ejemplos/Concepto01-MetodoMain ; /usr/bin/env C:\\Program\ Files\\Java\\jdk1.8.0_301\\bin\\java.exe -agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:51073 -cp C:\\Users\\alejandropineda\\AppData\\Roaming\\Code\\User\\workspaceStorage\\8a04df9295bdb249accf22630e0bfcad\\redhat.java\\jdt_ws\\JavaCourse_6494a371\\bin java ProcesarArgumentos Juan 25 Pereira
   
3. Con espacios (usar comillas):
   cd C:\\Users\\alejandropineda\\Documents\\JavaCourse/Ejemplos/Concepto01-MetodoMain ; /usr/bin/env C:\\Program\ Files\\Java\\jdk1.8.0_301\\bin\\java.exe -agentlib:jdwp=transport=dt_socket,server=n,suspend=y,address=localhost:51073 -cp C:\\Users\\alejandropineda\\AppData\\Roaming\\Code\\User\\workspaceStorage\\8a04df9295bdb249accf22630e0bfcad\\redhat.java\\jdt_ws\\JavaCourse_6494a371\\bin java ProcesarArgumentos "Carlos Andres" 25 "San José"
*/
