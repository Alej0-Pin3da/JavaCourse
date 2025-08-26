/**
 * CONCEPTO 2: Estructura de clases
 * 
 * Ejemplo: Múltiples clases en el mismo archivo
 * Demuestra las reglas para múltiples clases y visibilidad
 */

// CLASE PRINCIPAL (public) - debe tener el mismo nombre que el archivo
public class MultiplesClases {
    
    public static void main(String[] args) {
        System.out.println("=== Demostrando múltiples clases ===");
        
        // Usar las otras clases del mismo archivo
        ClaseHelper helper = new ClaseHelper();
        helper.ayudar();
        
        ClaseUtilidad utilidad = new ClaseUtilidad();
        String resultado = utilidad.formatearTexto("hola mundo");
        System.out.println("Texto formateado: " + resultado);
        
        // Usar clase con constructor
        Configuracion config = new Configuracion("MiApp", "1.0");
        config.mostrarConfiguracion();
    }
}

// CLASE AUXILIAR (package-private) - sin modificador public
class ClaseHelper {
    
    void ayudar() {
        System.out.println("Esta es una clase auxiliar en el mismo archivo");
    }
    
    void procesarDatos() {
        System.out.println("Procesando datos internos...");
    }
}

// OTRA CLASE AUXILIAR
class ClaseUtilidad {
    
    String formatearTexto(String texto) {
        if (texto == null || texto.isEmpty()) {
            return "Texto vacío";
        }
        
        // Capitalizar primera letra de cada palabra
        String[] palabras = texto.split(" ");
        StringBuilder resultado = new StringBuilder();
        
        for (String palabra : palabras) {
            if (palabra.length() > 0) {
                resultado.append(Character.toUpperCase(palabra.charAt(0)));
                if (palabra.length() > 1) {
                    resultado.append(palabra.substring(1).toLowerCase());
                }
                resultado.append(" ");
            }
        }
        
        return resultado.toString().trim();
    }
}

// CLASE CON CONSTRUCTOR Y ESTADO
class Configuracion {
    private String nombreApp;
    private String version;
    
    // Constructor
    public Configuracion(String nombreApp, String version) {
        this.nombreApp = nombreApp;
        this.version = version;
    }
    
    void mostrarConfiguracion() {
        System.out.println("Aplicación: " + nombreApp + " v" + version);
    }
}

/*
REGLAS PARA MÚLTIPLES CLASES EN UN ARCHIVO:

1. ✅ Solo UNA clase puede ser public por archivo
2. ✅ La clase public debe tener el mismo nombre que el archivo
3. ✅ Las demás clases son package-private (sin modificador)
4. ✅ Todas las clases del archivo están en el mismo paquete
5. ✅ Las clases no-public solo son visibles dentro del mismo paquete

CUÁNDO USAR MÚLTIPLES CLASES EN UN ARCHIVO:
- Clases auxiliares pequeñas
- Clases helper íntimamente relacionadas
- Clases que solo usa la clase principal

BUENAS PRÁCTICAS:
- Una clase por archivo para clases importantes
- Nombres descriptivos para todas las clases
- Mantener clases auxiliares simples y enfocadas
*/
