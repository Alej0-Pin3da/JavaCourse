# 🔧 EJEMPLOS PRÁCTICOS DE CORRECCIONES - FUNCIONES.JAVA

## 🎯 Correcciones Específicas Basadas en Código Real

Este archivo contiene correcciones prácticas y específicas para los errores identificados en `Funciones.java`, mostrando el antes y después de cada corrección.

---

## 📖 ÍNDICE DE CORRECCIONES

1. [Corrección del Método esNumero()](#correccion-esnumero)
2. [Manejo de InterruptedException](#correccion-interrupted)
3. [Manejo de HeadlessException](#correccion-headless)
4. [Corrección de IOException con System.out](#correccion-iostream)
5. [Eliminación de Catch Genéricos](#correccion-catch-generico)
6. [Implementación de Logging Profesional](#implementacion-logging)
7. [Refactorización de Validaciones](#refactorizacion-validaciones)

---

## 1. 🔢 CORRECCIÓN DEL MÉTODO ESNUMERO() {#correccion-esnumero}

### ❌ **Código Original (Línea 244-250):**
```java
public static boolean esNumero(String string) {
    try {
        Double.parseDouble(string);
    } catch (Exception e) {
        return false;
    }
    return true;
}
```

### ✅ **Código Corregido con Mejores Prácticas:**
```java
/**
 * Verifica si una cadena representa un número válido de punto flotante.
 * 
 * MEJORAS IMPLEMENTADAS:
 * - Validación defensiva contra null/vacío
 * - Catch específico en lugar de Exception genérica
 * - Documentación completa del comportamiento
 * - Manejo de espacios en blanco
 * 
 * @param string la cadena a verificar (puede ser null)
 * @return true si la cadena es un número válido, false en caso contrario
 * @since 2.0 - Versión mejorada con validación defensiva
 */
public static boolean esNumero(String string) {
    // ✅ VALIDACIÓN DEFENSIVA: Prevenir NullPointerException
    if (string == null || string.trim().isEmpty()) {
        return false;
    }
    
    try {
        Double.parseDouble(string.trim());
        return true;
    } catch (NumberFormatException e) {    // ✅ ESPECÍFICO: Solo errores de parsing
        return false;
    }
    // NOTA: Ya no capturamos Exception porque no esperamos otros tipos de errores
}

/**
 * Versión avanzada que retorna tanto el resultado como información del error.
 * Útil para debugging y mensajes de usuario más informativos.
 */
public static class ResultadoNumero {
    private final boolean esNumero;
    private final Double valor;
    private final String mensajeError;
    
    private ResultadoNumero(boolean esNumero, Double valor, String mensajeError) {
        this.esNumero = esNumero;
        this.valor = valor;
        this.mensajeError = mensajeError;
    }
    
    public boolean esNumero() { return esNumero; }
    public Double getValor() { return valor; }
    public String getMensajeError() { return mensajeError; }
    
    public static ResultadoNumero exito(Double valor) {
        return new ResultadoNumero(true, valor, null);
    }
    
    public static ResultadoNumero error(String mensaje) {
        return new ResultadoNumero(false, null, mensaje);
    }
}

/**
 * Método avanzado para parsing con información detallada de errores.
 */
public static ResultadoNumero analizarNumero(String string) {
    if (string == null) {
        return ResultadoNumero.error("La cadena no puede ser null");
    }
    
    String limpia = string.trim();
    if (limpia.isEmpty()) {
        return ResultadoNumero.error("La cadena no puede estar vacía");
    }
    
    try {
        double numero = Double.parseDouble(limpia);
        
        // Validaciones adicionales para casos especiales
        if (Double.isNaN(numero)) {
            return ResultadoNumero.error("El resultado es NaN (Not a Number)");
        }
        if (Double.isInfinite(numero)) {
            return ResultadoNumero.error("El resultado es infinito");
        }
        
        return ResultadoNumero.exito(numero);
        
    } catch (NumberFormatException e) {
        return ResultadoNumero.error("Formato inválido: '" + string + 
                                   "' no es un número válido");
    }
}
```

### 🎓 **Explicación de las Mejoras:**

1. **Validación Defensiva**: Previene `NullPointerException` verificando null y vacío
2. **Catch Específico**: Solo captura `NumberFormatException`, no todas las excepciones
3. **Documentación JavaDoc**: Explica comportamiento, parámetros y valores de retorno
4. **Manejo de Espacios**: Usa `trim()` para ignorar espacios en blanco
5. **Versión Avanzada**: Proporciona información detallada del error para debugging

---

## 2. 🧵 CORRECCIÓN DE INTERRUPTEDEXCEPTION {#correccion-interrupted}

### ❌ **Código Original (Línea 705):**
```java
try {
    Thread.sleep(200);
}catch(InterruptedException e) {}  // ❌ Catch vacío rompe protocolo de interrupción
```

### ✅ **Código Corregido:**
```java
/**
 * TEORÍA: InterruptedException es parte del mecanismo cooperativo de cancelación de Java.
 * Ignorarla rompe este protocolo y puede causar deadlocks o hilos zombi.
 */
try {
    Thread.sleep(200);
} catch(InterruptedException e) {
    // ✅ STEP 1: Restaurar el flag de interrupción
    Thread.currentThread().interrupt();
    
    // ✅ STEP 2: Logging para diagnóstico
    Logger.getLogger(Funciones.class.getName()).log(Level.INFO, 
        "Hilo interrumpido durante sleep - operación cancelada", e);
    
    // ✅ STEP 3: Decidir estrategia de salida apropiada
    // Opción A: Terminar método temprano
    return;
    
    // Opción B: Lanzar RuntimeException si es crítico continuar
    // throw new RuntimeException("Operación cancelada por interrupción", e);
    
    // Opción C: Marcar flag y continuar (si es apropiado)
    // interrupted = true;
}
```

### 🎓 **Explicación Detallada:**

```java
/**
 * PROTOCOLO DE INTERRUPCIÓN EN JAVA:
 * 
 * 1. Thread.interrupt() establece un flag interno de interrupción
 * 2. Métodos como sleep(), wait(), join() verifican este flag
 * 3. Si el flag está activo, lanzan InterruptedException y LIMPIAN el flag
 * 4. El catch debe restaurar el flag para mantener el protocolo
 * 
 * CONSECUENCIAS DE NO RESTAURAR EL FLAG:
 * - Otros métodos no sabrán que el hilo fue interrumpido
 * - Puede causar deadlocks en shutdown de aplicaciones
 * - Viola el principio de "least surprise"
 */

// ✅ EJEMPLO COMPLETO CON DIFERENTES ESTRATEGIAS
public void operacionConSleep() {
    boolean operacionCompletada = false;
    
    try {
        // Operación que puede ser interrumpida
        Thread.sleep(5000);
        operacionCompletada = true;
        
    } catch (InterruptedException e) {
        // Restaurar flag de interrupción
        Thread.currentThread().interrupt();
        
        Logger.getLogger(getClass().getName()).log(Level.INFO, 
            "Operación interrumpida - limpiando recursos", e);
        
        // Limpiar recursos si es necesario
        limpiarRecursos();
        
        // Estrategia según el contexto:
        if (esOperacionCritica()) {
            throw new RuntimeException("Operación crítica interrumpida", e);
        } else {
            // Terminar graciosamente
            Logger.getLogger(getClass().getName()).log(Level.INFO, 
                "Terminando operación no crítica por interrupción");
            return;
        }
    }
    
    if (operacionCompletada) {
        Logger.getLogger(getClass().getName()).log(Level.INFO, 
            "Operación completada exitosamente");
    }
}
```

---

## 3. 💻 CORRECCIÓN DE HEADLESSEXCEPTION {#correccion-headless}

### ❌ **Código Original (Múltiples líneas: 1075, 1101, 1120, etc.):**
```java
try {
    // Operaciones de interfaz gráfica
    mostrarVentana();
} catch(HeadlessException ex){}  // ❌ Catch vacío oculta información importante
```

### ✅ **Código Corregido:**
```java
/**
 * TEORÍA: HeadlessException ocurre cuando se intenta usar GUI en entornos sin soporte gráfico
 * (servidores, contenedores Docker, etc.). Aunque puede ser esperada, debe manejarse apropiadamente.
 */
try {
    // Operaciones de interfaz gráfica
    mostrarVentana();
    
} catch(HeadlessException ex) {
    // ✅ LOGGING: Registrar el evento para diagnóstico
    Logger.getLogger(Funciones.class.getName()).log(Level.INFO, 
        "Interfaz gráfica no disponible en entorno headless - usando modo consola", ex);
    
    // ✅ FUNCIONALIDAD ALTERNATIVA: Proporcionar modo texto
    mostrarMensajeConsola("Operación realizada en modo texto");
    
    // ✅ CONFIGURAR FLAG: Para evitar futuros intentos GUI
    configurarModoHeadless(true);
    
    // ✅ ESTRATEGIA ALTERNATIVA: Ejecutar versión sin GUI
    ejecutarVersionConsola();
}

/**
 * Método mejorado que detecta el entorno antes de intentar operaciones GUI
 */
public static void mostrarInterfazSegura() {
    if (GraphicsEnvironment.isHeadless()) {
        // ✅ DETECCIÓN PREVENTIVA: Evitar la excepción completamente
        Logger.getLogger(Funciones.class.getName()).log(Level.INFO, 
            "Entorno headless detectado - usando interfaz de consola");
        ejecutarVersionConsola();
        return;
    }
    
    try {
        // Solo intentar GUI si el entorno lo soporta
        mostrarVentana();
        
    } catch (HeadlessException ex) {
        // Esto NO debería ocurrir después de la verificación, pero por robustez:
        Logger.getLogger(Funciones.class.getName()).log(Level.WARNING, 
            "HeadlessException inesperada después de verificación", ex);
        ejecutarVersionConsola();
    }
}

/**
 * Implementaciones de métodos auxiliares
 */
private static void mostrarMensajeConsola(String mensaje) {
    System.out.println("=".repeat(50));
    System.out.println("MODO CONSOLA: " + mensaje);
    System.out.println("=".repeat(50));
}

private static void configurarModoHeadless(boolean headless) {
    // Guardar configuración para evitar futuros intentos GUI
    System.setProperty("java.awt.headless", String.valueOf(headless));
}

private static void ejecutarVersionConsola() {
    // Implementar funcionalidad equivalente sin GUI
    System.out.println("Ejecutando en modo consola...");
    // Lógica alternativa aquí
}
```

---

## 4. 📝 CORRECCIÓN DE IOSTREAM CON SYSTEM.OUT {#correccion-iostream}

### ❌ **Código Original (Línea 728):**
```java
try {
    // Operación de red o archivo
    conectarServidor();
} catch (IOException ex) { 
    System.out.println(ex);  // ❌ Usar System.out no es profesional
}
```

### ✅ **Código Corregido:**
```java
/**
 * TEORÍA: IOException indica problemas de entrada/salida que requieren manejo específico
 * según el tipo de operación (red, archivo, etc.)
 */
private static final Logger logger = Logger.getLogger(Funciones.class.getName());

try {
    conectarServidor();
    
} catch (ConnectException ex) {
    // ✅ ESPECÍFICO: Error de conexión - puede reintentarse
    logger.log(Level.WARNING, 
        "Error de conexión al servidor - verificar red y configuración", ex);
    
    // Estrategia de reintento
    if (deberiasReintentar()) {
        programarReintento();
    } else {
        notificarUsuario("No se pudo conectar al servidor. Verifique su conexión.");
    }
    
} catch (SocketTimeoutException ex) {
    // ✅ ESPECÍFICO: Timeout - problema de red lenta
    logger.log(Level.WARNING, 
        "Timeout en conexión - red lenta o servidor sobrecargado", ex);
    
    aumentarTimeout();
    programarReintento();
    
} catch (FileNotFoundException ex) {
    // ✅ ESPECÍFICO: Archivo no encontrado
    logger.log(Level.SEVERE, 
        "Archivo de configuración no encontrado", ex);
    
    crearArchivoConfiguracionPorDefecto();
    
} catch (IOException ex) {
    // ✅ GENÉRICO: Otros errores de I/O
    logger.log(Level.SEVERE, 
        "Error de entrada/salida no específico", ex);
    
    // Análisis adicional del error
    analizarTipoErrorIO(ex);
    
    throw new ServiceException("Operación de I/O falló", ex);
}

/**
 * Método auxiliar para análisis detallado de IOException
 */
private static void analizarTipoErrorIO(IOException ex) {
    String mensaje = ex.getMessage();
    String tipoError = "Desconocido";
    
    if (mensaje != null) {
        if (mensaje.contains("Connection refused")) {
            tipoError = "Conexión rechazada - servidor no disponible";
        } else if (mensaje.contains("Host unreachable")) {
            tipoError = "Host inalcanzable - problema de red";
        } else if (mensaje.contains("Permission denied")) {
            tipoError = "Permisos insuficientes";
        } else if (mensaje.contains("No space left")) {
            tipoError = "Espacio en disco insuficiente";
        }
    }
    
    logger.log(Level.INFO, "Análisis de IOException: " + tipoError);
    
    // Métricas para monitoreo
    incrementarContadorErrores(tipoError);
}

/**
 * Sistema de reintentos inteligente
 */
private static void programarReintento() {
    // Implementar backoff exponencial
    long delay = calcularDelayReintento();
    
    logger.log(Level.INFO, 
        "Programando reintento en " + delay + " milisegundos");
    
    // Usar ScheduledExecutorService para reintento asíncrono
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    scheduler.schedule(() -> {
        try {
            conectarServidor();
            logger.log(Level.INFO, "Reconexión exitosa");
        } catch (IOException e) {
            logger.log(Level.WARNING, "Reintento de conexión falló", e);
        }
    }, delay, TimeUnit.MILLISECONDS);
}
```

---

## 5. 🚫 ELIMINACIÓN DE CATCH GENÉRICOS {#correccion-catch-generico}

### ❌ **Código Original (Múltiples líneas):**
```java
try {
    // Operación compleja con múltiples puntos de falla
    validarDatos();
    procesarInformacion();
    guardarResultados();
} catch(Exception ex) {  // ❌ Muy genérico - oculta tipos específicos
    // Manejo genérico inadecuado
}
```

### ✅ **Código Corregido:**
```java
/**
 * TEORÍA: Catch específicos permiten manejo diferenciado según el tipo de error
 * y proporcionan mejor información para debugging y recuperación
 */
private static final Logger logger = Logger.getLogger(Funciones.class.getName());

try {
    validarDatos();
    procesarInformacion();
    guardarResultados();
    
} catch (ValidationException ex) {
    // ✅ ESPECÍFICO: Error de validación - informar al usuario
    logger.log(Level.WARNING, 
        "Datos de entrada inválidos: " + ex.getMessage(), ex);
    
    mostrarErroresValidacion(ex.getErrores());
    return false; // Permitir corrección por parte del usuario
    
} catch (ProcessingException ex) {
    // ✅ ESPECÍFICO: Error de procesamiento - puede reintentarse
    logger.log(Level.SEVERE, 
        "Error en procesamiento de datos", ex);
    
    if (ex.esRecuperable()) {
        intentarRecuperacion();
    } else {
        notificarAdministrador("Error crítico en procesamiento", ex);
        throw new SystemException("Procesamiento falló irrecuperablemente", ex);
    }
    
} catch (SQLException ex) {
    // ✅ ESPECÍFICO: Error de base de datos - estrategia de persistencia
    logger.log(Level.SEVERE, 
        "Error de base de datos durante guardado", ex);
    
    if (esErrorConexion(ex)) {
        intentarReconectarBD();
    } else if (esErrorIntegridad(ex)) {
        manejarConflictoIntegridad(ex);
    } else {
        throw new DataAccessException("Error de base de datos no recuperable", ex);
    }
    
} catch (SecurityException ex) {
    // ✅ ESPECÍFICO: Error de seguridad - auditoria y notificación
    logger.log(Level.SEVERE, 
        "Violación de seguridad detectada", ex);
    
    auditarViolacionSeguridad(ex);
    notificarEquipoSeguridad(ex);
    throw new SecurityViolationException("Acceso denegado", ex);
    
} catch (IllegalStateException ex) {
    // ✅ ESPECÍFICO: Estado inválido - problema de programación
    logger.log(Level.SEVERE, 
        "Sistema en estado inválido - posible bug", ex);
    
    diagnosticarEstadoSistema();
    throw new SystemException("Estado del sistema inconsistente", ex);
    
} catch (RuntimeException ex) {
    // ✅ RUNTIME EXCEPTIONS: Errores de programación no esperados
    logger.log(Level.SEVERE, 
        "Error de runtime no manejado específicamente", ex);
    
    analizarRuntimeException(ex);
    throw new SystemException("Error inesperado en runtime", ex);
}

/**
 * Métodos auxiliares para manejo específico de errores
 */
private static void mostrarErroresValidacion(List<String> errores) {
    StringBuilder mensaje = new StringBuilder("Errores de validación encontrados:\n");
    for (int i = 0; i < errores.size(); i++) {
        mensaje.append(String.format("%d. %s\n", i + 1, errores.get(i)));
    }
    
    // Mostrar al usuario de forma amigable
    JOptionPane.showMessageDialog(null, mensaje.toString(), 
                                 "Errores de Validación", 
                                 JOptionPane.WARNING_MESSAGE);
}

private static boolean esErrorConexion(SQLException ex) {
    // Códigos de error específicos de conexión
    return ex.getErrorCode() == 1042 || // Connection refused
           ex.getErrorCode() == 1043 || // Bad handshake
           ex.getMessage().contains("Communications link failure");
}

private static boolean esErrorIntegridad(SQLException ex) {
    // Códigos de error de integridad referencial
    return ex.getErrorCode() == 1452 || // Foreign key constraint
           ex.getErrorCode() == 1062 || // Duplicate entry
           ex.getErrorCode() == 1048;   // Column cannot be null
}

private static void analizarRuntimeException(RuntimeException ex) {
    String tipoError = ex.getClass().getSimpleName();
    String contexto = obtenerContextoEjecucion();
    
    logger.log(Level.INFO, 
        String.format("Análisis RuntimeException: Tipo=%s, Contexto=%s", 
                     tipoError, contexto));
    
    // Enviar métricas para monitoreo
    enviarMetricasError(tipoError, contexto);
}
```

---

## 6. 📊 IMPLEMENTACIÓN DE LOGGING PROFESIONAL {#implementacion-logging}

### ✅ **Sistema de Logging Completo:**

```java
/**
 * Configuración profesional de logging para la clase Funciones
 */
public class LoggingConfig {
    private static final Logger logger = Logger.getLogger(Funciones.class.getName());
    private static boolean configurado = false;
    
    /**
     * Configura el sistema de logging según el entorno
     */
    public static void configurarLogging() {
        if (configurado) return;
        
        try {
            // Configuración diferente según entorno
            if (esEntornoProduccion()) {
                configurarLoggingProduccion();
            } else {
                configurarLoggingDesarrollo();
            }
            
            configurado = true;
            logger.info("Sistema de logging configurado correctamente");
            
        } catch (Exception e) {
            System.err.println("Error configurando logging: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void configurarLoggingProduccion() throws IOException {
        // En producción: archivo rotativo + consola solo para errores graves
        FileHandler fileHandler = new FileHandler("logs/funciones-%g.log", 
                                                  10 * 1024 * 1024, // 10MB
                                                  5, // 5 archivos de rotación
                                                  true); // append
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.INFO);
        
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.SEVERE);
        consoleHandler.setFormatter(new ConsoleFormatter());
        
        logger.addHandler(fileHandler);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.INFO);
    }
    
    private static void configurarLoggingDesarrollo() {
        // En desarrollo: consola con más detalle
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        consoleHandler.setFormatter(new DetailedFormatter());
        
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.FINE);
    }
    
    private static boolean esEntornoProduccion() {
        return "production".equals(System.getProperty("environment", "development"));
    }
    
    /**
     * Formatter personalizado para consola en desarrollo
     */
    public static class DetailedFormatter extends Formatter {
        private static final String FORMAT = "[%1$tF %1$tT] [%2$-7s] [%3$s] %4$s %n";
        
        @Override
        public String format(LogRecord record) {
            return String.format(FORMAT,
                new Date(record.getMillis()),
                record.getLevel().getLocalizedName(),
                record.getSourceClassName() + "." + record.getSourceMethodName(),
                record.getMessage()
            );
        }
    }
    
    /**
     * Formatter simplificado para consola en producción
     */
    public static class ConsoleFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return String.format("%1$tT [%2$s] %3$s%n",
                new Date(record.getMillis()),
                record.getLevel(),
                record.getMessage()
            );
        }
    }
}

/**
 * Métodos de utilidad para logging estructurado
 */
public class LoggingUtils {
    private static final Logger logger = Logger.getLogger(Funciones.class.getName());
    
    /**
     * Log de entrada a método con parámetros
     */
    public static void logEntradaMetodo(String nombreMetodo, Object... parametros) {
        if (logger.isLoggable(Level.FINE)) {
            StringBuilder sb = new StringBuilder();
            sb.append("ENTRADA -> ").append(nombreMetodo).append("(");
            
            for (int i = 0; i < parametros.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(parametros[i] != null ? parametros[i].toString() : "null");
            }
            
            sb.append(")");
            logger.fine(sb.toString());
        }
    }
    
    /**
     * Log de salida de método con resultado
     */
    public static void logSalidaMetodo(String nombreMetodo, Object resultado) {
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("SALIDA <- " + nombreMetodo + " = " + 
                       (resultado != null ? resultado.toString() : "null"));
        }
    }
    
    /**
     * Log de excepción con contexto completo
     */
    public static void logExcepcion(Level nivel, String operacion, 
                                   Map<String, Object> contexto, Exception ex) {
        StringBuilder mensaje = new StringBuilder();
        mensaje.append("ERROR en ").append(operacion);
        
        if (contexto != null && !contexto.isEmpty()) {
            mensaje.append(" | Contexto: ");
            contexto.forEach((key, value) -> 
                mensaje.append(key).append("=").append(value).append(" "));
        }
        
        logger.log(nivel, mensaje.toString(), ex);
        
        // Escalamiento automático para errores críticos
        if (nivel == Level.SEVERE) {
            notificarErrorCritico(operacion, contexto, ex);
        }
    }
    
    private static void notificarErrorCritico(String operacion, 
                                            Map<String, Object> contexto, 
                                            Exception ex) {
        // Implementar notificación a administradores
        // Email, SMS, webhook, etc.
        System.err.println("ERROR CRÍTICO DETECTADO - Revisar logs inmediatamente");
    }
}

// ✅ EJEMPLO DE USO EN MÉTODO REFACTORIZADO
public static boolean validarVaciosEntrada() {
    LoggingUtils.logEntradaMetodo("validarVaciosEntrada");
    
    try {
        boolean tieneVacios = false;
        Map<String, String> camposVacios = new HashMap<>();
        
        // Validación con logging detallado
        if (Entrada.TxtPosNominal.getText().isEmpty()) {
            tieneVacios = true;
            camposVacios.put("PosNominal", "vacío");
        }
        
        if (Entrada.TxtCargaL.getText().isEmpty()) {
            tieneVacios = true;
            camposVacios.put("CargaL", "vacío");
        }
        
        // Log del resultado
        if (tieneVacios) {
            logger.warning("Validación falló - campos vacíos: " + camposVacios);
        } else {
            logger.info("Validación exitosa - todos los campos completos");
        }
        
        LoggingUtils.logSalidaMetodo("validarVaciosEntrada", tieneVacios);
        return tieneVacios;
        
    } catch (Exception ex) {
        Map<String, Object> contexto = Map.of(
            "timestamp", System.currentTimeMillis(),
            "thread", Thread.currentThread().getName()
        );
        
        LoggingUtils.logExcepcion(Level.SEVERE, "validarVaciosEntrada", contexto, ex);
        throw new ValidationException("Error en validación de campos", ex);
    }
}
```

---

## 7. 🔧 REFACTORIZACIÓN DE VALIDACIONES {#refactorizacion-validaciones}

### ✅ **Sistema de Validación Mejorado:**

```java
/**
 * Sistema de validación robusto y extensible
 */
public class SistemaValidacion {
    private static final Logger logger = Logger.getLogger(SistemaValidacion.class.getName());
    
    public static class ResultadoValidacion {
        private final boolean valido;
        private final List<String> errores;
        private final List<String> advertencias;
        private final Map<String, Object> metadatos;
        
        public ResultadoValidacion(boolean valido, List<String> errores, 
                                 List<String> advertencias, Map<String, Object> metadatos) {
            this.valido = valido;
            this.errores = new ArrayList<>(errores);
            this.advertencias = new ArrayList<>(advertencias);
            this.metadatos = new HashMap<>(metadatos);
        }
        
        // Getters
        public boolean esValido() { return valido; }
        public List<String> getErrores() { return new ArrayList<>(errores); }
        public List<String> getAdvertencias() { return new ArrayList<>(advertencias); }
        public Map<String, Object> getMetadatos() { return new HashMap<>(metadatos); }
        
        // Métodos de utilidad
        public boolean tieneAdvertencias() { return !advertencias.isEmpty(); }
        public int getNumeroErrores() { return errores.size(); }
        public String getResumenCompleto() {
            StringBuilder sb = new StringBuilder();
            if (!errores.isEmpty()) {
                sb.append("Errores (").append(errores.size()).append("): ");
                sb.append(String.join("; ", errores));
            }
            if (!advertencias.isEmpty()) {
                if (sb.length() > 0) sb.append(" | ");
                sb.append("Advertencias (").append(advertencias.size()).append("): ");
                sb.append(String.join("; ", advertencias));
            }
            return sb.toString();
        }
    }
    
    /**
     * Validación completa con reporte detallado
     */
    public static ResultadoValidacion validarEntradaCompleta() {
        List<String> errores = new ArrayList<>();
        List<String> advertencias = new ArrayList<>();
        Map<String, Object> metadatos = new HashMap<>();
        
        metadatos.put("timestamp", System.currentTimeMillis());
        metadatos.put("validador", "SistemaValidacion.validarEntradaCompleta");
        
        try {
            // Validación por fases
            validarCamposObligatorios(errores);
            validarFormatosNumericos(errores, advertencias);
            validarRangosValores(errores, advertencias);
            validarCompatibilidadCampos(errores, advertencias);
            validarReglasNegocio(errores, advertencias);
            
            boolean esValido = errores.isEmpty();
            metadatos.put("resultado", esValido ? "VALIDO" : "INVALIDO");
            metadatos.put("num_errores", errores.size());
            metadatos.put("num_advertencias", advertencias.size());
            
            // Logging del resultado
            if (esValido) {
                if (!advertencias.isEmpty()) {
                    logger.info("Validación exitosa con advertencias: " + 
                              String.join("; ", advertencias));
                } else {
                    logger.info("Validación completamente exitosa");
                }
            } else {
                logger.warning("Validación falló con " + errores.size() + 
                             " errores: " + String.join("; ", errores));
            }
            
            return new ResultadoValidacion(esValido, errores, advertencias, metadatos);
            
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error durante proceso de validación", ex);
            errores.add("Error interno durante validación: " + ex.getMessage());
            metadatos.put("error_interno", true);
            metadatos.put("excepcion", ex.getClass().getSimpleName());
            
            return new ResultadoValidacion(false, errores, advertencias, metadatos);
        }
    }
    
    private static void validarCamposObligatorios(List<String> errores) {
        // Definir campos obligatorios con validación específica
        Map<String, Supplier<String>> camposObligatorios = Map.of(
            "Potencia Nominal", () -> Entrada.TxtPosNominal.getText(),
            "Carga", () -> Entrada.TxtCargaL.getText(),
            "Factor de Potencia", () -> Entrada.TxtFp.getText(),
            "Frecuencia", () -> Entrada.TxtF.getText(),
            "Temperatura Ambiente", () -> Entrada.TxtTa.getText()
        );
        
        camposObligatorios.forEach((nombre, proveedor) -> {
            try {
                String valor = proveedor.get();
                if (valor == null || valor.trim().isEmpty()) {
                    errores.add("Campo obligatorio vacío: " + nombre);
                }
            } catch (Exception ex) {
                errores.add("Error accediendo campo " + nombre + ": " + ex.getMessage());
                logger.log(Level.WARNING, "Error accediendo campo GUI: " + nombre, ex);
            }
        });
    }
    
    private static void validarFormatosNumericos(List<String> errores, List<String> advertencias) {
        // Validar campos numéricos con información detallada
        Map<String, Supplier<String>> camposNumericos = Map.of(
            "Potencia Nominal", () -> Entrada.TxtPosNominal.getText(),
            "Carga", () -> Entrada.TxtCargaL.getText(),
            "Factor de Potencia", () -> Entrada.TxtFp.getText(),
            "Frecuencia", () -> Entrada.TxtF.getText()
        );
        
        camposNumericos.forEach((nombre, proveedor) -> {
            try {
                String valor = proveedor.get();
                if (valor != null && !valor.trim().isEmpty()) {
                    ResultadoNumero resultado = analizarNumero(valor);
                    if (!resultado.esNumero()) {
                        errores.add("Formato inválido en " + nombre + ": " + 
                                  resultado.getMensajeError());
                    } else {
                        // Validaciones adicionales según el campo
                        double numero = resultado.getValor();
                        validarRangoEspecifico(nombre, numero, errores, advertencias);
                    }
                }
            } catch (Exception ex) {
                errores.add("Error validando formato numérico en " + nombre);
                logger.log(Level.WARNING, "Error en validación numérica: " + nombre, ex);
            }
        });
    }
    
    private static void validarRangoEspecifico(String campo, double valor, 
                                             List<String> errores, List<String> advertencias) {
        switch (campo) {
            case "Potencia Nominal":
                if (valor <= 0) {
                    errores.add("Potencia debe ser mayor que cero");
                } else if (valor > 10000) {
                    advertencias.add("Potencia muy alta (" + valor + " kVA) - verificar especificaciones");
                }
                break;
                
            case "Factor de Potencia":
                if (valor < 0 || valor > 1) {
                    errores.add("Factor de potencia debe estar entre 0 y 1");
                } else if (valor < 0.8) {
                    advertencias.add("Factor de potencia bajo (" + valor + ") - puede requerir compensación");
                }
                break;
                
            case "Frecuencia":
                if (valor != 50 && valor != 60) {
                    advertencias.add("Frecuencia no estándar (" + valor + " Hz) - verificar aplicación");
                }
                break;
        }
    }
    
    private static void validarCompatibilidadCampos(List<String> errores, List<String> advertencias) {
        // Validar lógica de negocio entre campos
        try {
            String norma = (String) Entrada.CmbNorma.getSelectedItem();
            String pais = (String) Entrada.CmbPais.getSelectedItem();
            
            if (norma != null && pais != null) {
                if (!esNormaCompatibleConPais(norma, pais)) {
                    errores.add("Norma " + norma + " no es compatible con país " + pais);
                }
            }
            
            // Más validaciones de compatibilidad...
            
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Error en validación de compatibilidad", ex);
            advertencias.add("No se pudo verificar compatibilidad entre campos");
        }
    }
    
    private static void validarReglasNegocio(List<String> errores, List<String> advertencias) {
        // Implementar reglas específicas del dominio
        try {
            // Ejemplo: Regla de potencia mínima según voltaje
            String voltajeStr = Entrada.TxtVoltaje.getText();
            String potenciaStr = Entrada.TxtPosNominal.getText();
            
            if (!voltajeStr.isEmpty() && !potenciaStr.isEmpty()) {
                ResultadoNumero voltajeResult = analizarNumero(voltajeStr);
                ResultadoNumero potenciaResult = analizarNumero(potenciaStr);
                
                if (voltajeResult.esNumero() && potenciaResult.esNumero()) {
                    double voltaje = voltajeResult.getValor();
                    double potencia = potenciaResult.getValor();
                    
                    // Regla ejemplo: Potencia mínima según voltaje
                    double potenciaMinima = calcularPotenciaMinima(voltaje);
                    if (potencia < potenciaMinima) {
                        advertencias.add("Potencia baja para el voltaje especificado. " +
                                       "Mínimo recomendado: " + potenciaMinima + " kVA");
                    }
                }
            }
            
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Error en validación de reglas de negocio", ex);
            advertencias.add("No se pudieron verificar todas las reglas de negocio");
        }
    }
    
    private static double calcularPotenciaMinima(double voltaje) {
        // Lógica simplificada - ajustar según especificaciones reales
        if (voltaje < 1000) return 10;      // Baja tensión
        if (voltaje < 35000) return 100;    // Media tensión
        return 1000;                        // Alta tensión
    }
    
    private static boolean esNormaCompatibleConPais(String norma, String pais) {
        // Implementar matriz de compatibilidad
        Map<String, Set<String>> compatibilidad = Map.of(
            "IEC", Set.of("COLOMBIA", "ECUADOR", "PERU", "CHILE"),
            "IEEE", Set.of("USA", "CANADA", "MEXICO"),
            "ANSI", Set.of("USA", "CANADA")
        );
        
        return compatibilidad.getOrDefault(norma, Set.of()).contains(pais.toUpperCase());
    }
}
```

---

## 🎯 RESUMEN DE MEJORAS IMPLEMENTADAS

### **🔧 Principios Aplicados:**

1. **✅ Fail-Fast**: Validación temprana y exhaustiva
2. **✅ Especificidad**: Catch específicos para cada tipo de error
3. **✅ Transparencia**: Logging completo y estructurado
4. **✅ Recuperación**: Múltiples estrategias de fallback
5. **✅ Observabilidad**: Métricas y monitoreo integrado

### **📊 Mejoras Técnicas:**

1. **Manejo de Excepciones**: Reemplazados catches genéricos por específicos
2. **Logging Profesional**: Sistema de logging configurable por entorno
3. **Validación Robusta**: Sistema de validación por capas con reportes detallados
4. **Recuperación de Errores**: Estrategias diferenciadas según tipo de error
5. **Documentación**: JavaDoc completo con explicaciones teóricas

### **🎓 Beneficios Obtenidos:**

- **Debugging**: Información detallada para resolver problemas
- **Mantenibilidad**: Código más claro y fácil de modificar
- **Robustez**: Sistema más resistente a fallos
- **Monitoreo**: Capacidad de observar el sistema en producción
- **Experiencia de Usuario**: Mensajes de error más informativos

Estas correcciones transforman el código de un nivel básico a un nivel profesional, siguiendo las mejores prácticas de la industria.
