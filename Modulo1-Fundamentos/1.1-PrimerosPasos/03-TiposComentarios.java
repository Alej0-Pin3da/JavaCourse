/**
 * ARCHIVO 03: Tipos de comentarios y documentación en Java
 * 
 * CONCEPTOS EXPLICADOS:
 * - Comentarios de una línea (//)
 * - Comentarios multilínea (/* */)
 * - Comentarios JavaDoc (/** */)
 * - Etiquetas especiales para desarrollo
 * - Buenas prácticas de documentación
 * - Generación automática de documentación
 * 
 * @author Tu Nombre
 * @version 1.0
 * @since Java 8
 */
public class TiposComentarios {
    
    /*
     * CONCEPTO 1: IMPORTANCIA DE LOS COMENTARIOS
     * 
     * Los comentarios son ESENCIALES para:
     * 1. Explicar el propósito del código
     * 2. Documentar parámetros y valores de retorno
     * 3. Advertir sobre comportamientos especiales
     * 4. Facilitar el mantenimiento del código
     * 5. Generar documentación automática (JavaDoc)
     * 
     * NOTA IMPORTANTE: Los comentarios se eliminan durante la compilación
     * y NO afectan el rendimiento del programa ejecutable.
     */
    
    public static void main(String[] args) {
        
        System.out.println("=== DEMOSTRACIÓN DE TIPOS DE COMENTARIOS ===\n");
        
        // ========================================
        // TIPO 1: COMENTARIOS DE UNA SOLA LÍNEA
        // ========================================
        
        /*
         * CONCEPTO 2: COMENTARIOS DE UNA LÍNEA (//)
         * 
         * - Inician con doble slash //
         * - Todo lo que sigue en esa línea se ignora
         * - Útiles para explicaciones breves
         * - Pueden ir al final de una línea de código
         * - Son los más comunes para comentarios internos
         */
        
        // Este es un comentario de una sola línea
        int numero = 42; // Comentario al final de línea
        
        // Los comentarios de una línea son ideales para:
        // - Explicaciones cortas
        // - Desactivar temporalmente código
        // - Aclaraciones rápidas
        
        System.out.println("Número: " + numero);
        
        
        // ========================================
        // TIPO 2: COMENTARIOS MULTILÍNEA
        // ========================================
        
        /*
         * CONCEPTO 3: COMENTARIOS MULTILÍNEA (/* */)
         * 
         * - Inician con /* y terminan con */
         * - Pueden abarcar múltiples líneas
         * - Útiles para explicaciones largas
         * - Pueden anidar en el código
         * - NO se pueden anidar (/* /* */ NO funciona)
         */
        
        /* 
         * Este es un comentario multilínea.
         * Puede abarcar varias líneas y es útil para
         * explicaciones más detalladas sobre algoritmos,
         * lógica compleja, o documentación interna.
         */
        
        /* También puede escribirse en una sola línea */
        
        /*
        USOS COMUNES:
        - Documentar algoritmos complejos
        - Explicar decisiones de diseño
        - Comentar bloques de código temporalmente
        - Headers de archivos
        */
        
        String mensaje = "Tipos de comentarios";
        System.out.println("Mensaje: " + mensaje);
        
        /*
        CÓDIGO COMENTADO (desactivado temporalmente):
        
        System.out.println("Este código no se ejecuta");
        int temporal = 100;
        System.out.println("Temporal: " + temporal);
        */
        
        
        // ========================================
        // TIPO 3: COMENTARIOS JAVADOC
        // ========================================
        
        /*
         * CONCEPTO 4: COMENTARIOS JAVADOC (/** */)
         * 
         * - Inician con /** y terminan con */
         * - Se usan para generar documentación automática
         * - Deben colocarse ANTES de clases, métodos, campos
         * - Utilizan etiquetas especiales (@param, @return, etc.)
         * - El comando 'javadoc' genera HTML desde estos comentarios
         */
        
        // Llamada a método documentado
        String resultado = ejemploMetodoDocumentado("Java", 8);
        System.out.println("Resultado del método: " + resultado);
        
        // Demostración de etiquetas especiales
        demostracionEtiquetasEspeciales();
    }
    
    /**
     * CONCEPTO 5: MÉTODO DOCUMENTADO CON JAVADOC
     * 
     * Este método demuestra cómo documentar apropiadamente un método
     * usando comentarios JavaDoc con etiquetas especiales.
     * 
     * @param lenguaje el nombre del lenguaje de programación (no debe ser null)
     * @param version la versión del lenguaje (debe ser positiva)
     * @return un mensaje formateado combinando lenguaje y versión
     * 
     * @throws IllegalArgumentException si lenguaje es null o version es negativa
     * @see String#format(String, Object...)
     * @since 1.0
     * @author Instructor del curso
     * 
     * @deprecated Este método es solo para demostración.
     *             En producción, usar métodos más robustos.
     */
    public static String ejemploMetodoDocumentado(String lenguaje, int version) {
        /*
         * CONCEPTO 6: VALIDACIÓN DE PARÁMETROS
         * 
         * Es buena práctica validar los parámetros de entrada
         * y documentar qué pasa si son inválidos.
         */
        
        // Validación básica (se verá más en módulos posteriores)
        if (lenguaje == null) {
            throw new IllegalArgumentException("El lenguaje no puede ser null");
        }
        if (version < 0) {
            throw new IllegalArgumentException("La versión debe ser positiva");
        }
        
        /* 
         * Construcción del resultado usando formato
         * String.format() es más eficiente que concatenación múltiple
         */
        String resultado = String.format("Lenguaje: %s versión %d", lenguaje, version);
        System.out.println("Método ejecutado: " + resultado);
        
        return resultado; // Retorna el mensaje formateado
    }
    
    /*
     * CONCEPTO 7: ETIQUETAS ESPECIALES PARA DESARROLLO
     * 
     * Estas etiquetas ayudan durante el desarrollo y mantenimiento:
     */
    private static void demostracionEtiquetasEspeciales() {
        
        System.out.println("\n--- Demostración de etiquetas especiales ---");
        
        // TODO: Implementar validación más robusta de entrada
        // Esta etiqueta indica trabajo pendiente
        
        // FIXME: Este algoritmo podría optimizarse para mejor rendimiento
        // Esta etiqueta indica código que necesita corrección
        
        // HACK: Solución temporal hasta tener la implementación correcta
        // Esta etiqueta indica código que no es la solución ideal
        
        // NOTE: Este comportamiento es específico de Java 8
        // Esta etiqueta proporciona información importante
        
        // XXX: Código crítico - no modificar sin pruebas exhaustivas  
        // Esta etiqueta marca código especialmente sensible
        
        /*
         * CONCEPTO 8: HERRAMIENTAS Y IDEs
         * 
         * Los IDEs modernos (IntelliJ, Eclipse, VS Code) reconocen
         * estas etiquetas y las muestran en listas especiales:
         * - Panel "TODO"
         * - Lista de tareas pendientes
         * - Resaltado visual especial
         */
        
        System.out.println("Las etiquetas especiales ayudan en el desarrollo");
    }
}

/*
 * CONCEPTO 9: BUENAS PRÁCTICAS DE COMENTARIOS
 * 
 * QUÉ COMENTAR:
 * ✓ POR QUÉ se hace algo (no QUÉ se hace)
 * ✓ Decisiones de diseño importantes
 * ✓ Algoritmos complejos
 * ✓ Parámetros y valores de retorno
 * ✓ Excepciones que se pueden lanzar
 * ✓ Precondiciones y postcondiciones
 * 
 * QUÉ NO COMENTAR:
 * ✗ Código obvio (int x = 5; // asigna 5 a x)
 * ✗ Código que se explica por sí mismo
 * ✗ Comentarios que repiten el código
 * ✗ Comentarios obsoletos o incorrectos
 * 
 * GENERACIÓN DE DOCUMENTACIÓN:
 * 
 * Para generar documentación HTML desde JavaDoc:
 * 1. javadoc *.java
 * 2. Se crea carpeta 'doc' con archivos HTML
 * 3. Abrir index.html en navegador
 * 
 * Opciones útiles:
 * - javadoc -d docs *.java  (especifica directorio)
 * - javadoc -private *.java (incluye miembros privados)
 * - javadoc -author -version *.java (incluye autor y versión)
 */
