# 📚 TEORÍA DE ERRORES Y CORRECCIONES EN JAVA

## 🎯 Basado en el análisis de Funciones.java y patrones Try-Catch

Este documento proporciona una explicación teórica profunda de los errores comunes encontrados en el manejo de excepciones y sus correcciones apropiadas, tomando como base ejemplos reales del código.

---

## 🔍 TEORÍA FUNDAMENTAL: ¿QUÉ ES TRY-CATCH? {#teoria-fundamental}

### 📚 **Definición Conceptual**

El **Try-Catch** es un mecanismo de control de flujo en Java diseñado para manejar situaciones excepcionales que pueden ocurrir durante la ejecución de un programa. No es simplemente una herramienta para "atrapar errores", sino un sistema completo de gestión de estados excepcionales del programa.

### 🎯 **Anatomía del Try-Catch**

```java
try {
    // BLOQUE TRY: Código que puede generar una excepción
    // - Operaciones riesgosas
    // - Llamadas a métodos que pueden fallar
    // - Acceso a recursos externos
} catch (TipoExcepcion1 e) {
    // BLOQUE CATCH: Manejo específico de un tipo de excepción
    // - Recuperación del error
    // - Logging y diagnóstico
    // - Acciones alternativas
} catch (TipoExcepcion2 e) {
    // MÚLTIPLES CATCH: Manejo diferenciado por tipo
} finally {
    // BLOQUE FINALLY: Siempre se ejecuta
    // - Limpieza de recursos
    // - Operaciones de cierre
    // - Código que debe ejecutarse sin importar el resultado
}
```

### 🧠 **Modelo Mental: Estados del Programa**

```java
/**
 * TEORÍA: El programa puede estar en diferentes estados durante la ejecución
 */
public enum EstadoPrograma {
    NORMAL,      // Flujo esperado sin problemas
    EXCEPCIONAL, // Situación inesperada pero manejable
    ERROR_FATAL  // Fallo crítico que requiere terminación
}

// Try-Catch nos permite manejar transiciones entre estos estados
try {
    // ESTADO: NORMAL - intentamos operación esperada
    resultado = operacionNormal();
    
} catch (RecoverableException e) {
    // TRANSICIÓN: NORMAL → EXCEPCIONAL → NORMAL
    // Manejamos la excepción y continuamos
    resultado = operacionAlternativa();
    
} catch (FatalException e) {
    // TRANSICIÓN: NORMAL → EXCEPCIONAL → ERROR_FATAL
    // No podemos recuperarnos, debemos fallar controladamente
    throw new SystemException("Error irrecuperable", e);
}
```

### ⚡ **Flujo de Ejecución en Try-Catch**

```java
/**
 * PASO A PASO: Cómo Java procesa un bloque try-catch
 */
public void ejemploFlujoEjecucion() {
    System.out.println("1. Antes del try-catch");
    
    try {
        System.out.println("2. Entrando al bloque try");
        
        // Si esto lanza excepción, el flujo salta inmediatamente al catch apropiado
        operacionRiesgosa();
        
        System.out.println("3. Operación exitosa - continuando en try");
        
    } catch (SpecificException e) {
        System.out.println("4a. Excepción específica capturada");
        // El flujo continúa aquí si se lanza SpecificException
        
    } catch (GeneralException e) {
        System.out.println("4b. Excepción general capturada");
        // Solo se ejecuta si no fue capturada por el catch anterior
        
    } finally {
        System.out.println("5. Finally - SIEMPRE se ejecuta");
        // Se ejecuta independientemente de si hubo excepción o no
    }
    
    System.out.println("6. Después del try-catch");
}
```

### 🎨 **Tipos de Excepciones: Jerarquía Semántica**

```java
/**
 * TEORÍA: La jerarquía de excepciones tiene significado semántico
 */

// THROWABLE (raíz de todas las excepciones)
//   ├── ERROR (errores del sistema - no catchear)
//   │    ├── OutOfMemoryError
//   │    ├── StackOverflowError
//   │    └── VirtualMachineError
//   │
//   └── EXCEPTION (excepciones de aplicación - sí catchear)
//        ├── RuntimeException (excepciones no verificadas)
//        │    ├── NullPointerException      // Error de programación
//        │    ├── IllegalArgumentException  // Datos inválidos
//        │    ├── IllegalStateException     // Estado inválido
//        │    └── ArithmeticException       // Error matemático
//        │
//        └── Checked Exceptions (excepciones verificadas)
//             ├── IOException               // Problemas de E/O
//             ├── SQLException              // Errores de BD
//             ├── ClassNotFoundException    // Problemas de carga
//             └── InterruptedException      // Concurrencia

/**
 * PRINCIPIO FUNDAMENTAL: Cada nivel tiene una estrategia de manejo diferente
 */
public void manejoSegunJerarquia() {
    try {
        operacionCompleja();
        
    } catch (IllegalArgumentException e) {
        // PROGRAMACIÓN: Validar entrada y rechazar
        logger.warning("Entrada inválida proporcionada: " + e.getMessage());
        throw new ValidationException("Datos de entrada inválidos", e);
        
    } catch (IllegalStateException e) {
        // PROGRAMACIÓN: Bug del sistema, fallar rápido
        logger.severe("Estado del sistema inconsistente - posible bug");
        throw new SystemException("Sistema en estado inválido", e);
        
    } catch (IOException e) {
        // INFRAESTRUCTURA: Reintentar o usar alternativa
        logger.warning("Problema de E/O - intentando recuperación");
        return recuperarDeError(e);
        
    } catch (SQLException e) {
        // DATOS: Estrategia específica de base de datos
        logger.severe("Error de base de datos");
        return manejarErrorBD(e);
    }
}
```

### 🔄 **Patrones de Control de Flujo**

#### **A) Patrón de Validación**
```java
/**
 * USO CORRECTO: Try-catch para validación cuando el parsing es la validación
 */
public boolean esNumero(String entrada) {
    try {
        Double.parseDouble(entrada);  // La validación ES el parsing
        return true;
    } catch (NumberFormatException e) {
        return false;  // No es excepción, es resultado esperado
    }
}

// TEORÍA: Aquí el try-catch NO es control de flujo, es delegación de validación
```

#### **B) Patrón de Recuperación**
```java
/**
 * USO CORRECTO: Try-catch para recuperación de errores
 */
public String obtenerConfiguracion() {
    try {
        return leerConfiguracionRemota();  // Intento principal
    } catch (IOException e) {
        logger.warning("Config remota no disponible, usando local");
        return leerConfiguracionLocal();   // Recuperación
    } catch (ConfigurationException e) {
        logger.warning("Config local corrupta, usando por defecto");
        return obtenerConfiguracionPorDefecto();  // Fallback final
    }
}
```

#### **C) Patrón de Limpieza de Recursos**
```java
/**
 * USO CORRECTO: Try-catch-finally para gestión de recursos
 */
public void procesarArchivo(String archivo) {
    FileInputStream stream = null;
    try {
        stream = new FileInputStream(archivo);
        procesarContenido(stream);
        
    } catch (FileNotFoundException e) {
        logger.severe("Archivo no encontrado: " + archivo);
        throw new ProcessingException("No se puede procesar archivo inexistente", e);
        
    } catch (IOException e) {
        logger.warning("Error leyendo archivo, intentando recuperación");
        recuperarLectura(archivo, e);
        
    } finally {
        // CRÍTICO: Limpiar recursos independientemente del resultado
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                logger.warning("Error cerrando stream: " + e.getMessage());
            }
        }
    }
}

// MODERNO: Try-with-resources es preferible
public void procesarArchivoModerno(String archivo) {
    try (FileInputStream stream = new FileInputStream(archivo)) {
        procesarContenido(stream);
        // El stream se cierra automáticamente
        
    } catch (FileNotFoundException e) {
        logger.severe("Archivo no encontrado: " + archivo);
        throw new ProcessingException("No se puede procesar archivo inexistente", e);
    }
}
```

### 🚫 **Anti-Patrones Comunes**

#### **A) Control de Flujo Inapropiado**
```java
// ❌ MAL USO: Usar excepciones para lógica normal
public int buscarElemento(int[] array, int elemento) {
    try {
        for (int i = 0; ; i++) {  // Bucle infinito intencional
            if (array[i] == elemento) {
                return i;
            }
        }
    } catch (ArrayIndexOutOfBoundsException e) {
        return -1;  // ¡ESTO ESTÁ MAL!
    }
}

// ✅ CORRECTO: Usar condiciones normales
public int buscarElemento(int[] array, int elemento) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == elemento) {
            return i;
        }
    }
    return -1;
}
```

#### **B) Ocultamiento de Excepciones**
```java
// ❌ MAL USO: Catch vacío oculta problemas
try {
    operacionCritica();
} catch (Exception e) {
    // Silencio total - ¡PELIGROSO!
}

// ✅ CORRECTO: Manejo apropiado
try {
    operacionCritica();
} catch (SpecificException e) {
    logger.log(Level.WARNING, "Operación falló, usando alternativa", e);
    usarOperacionAlternativa();
} catch (FatalException e) {
    logger.log(Level.SEVERE, "Error crítico en operación", e);
    throw new SystemException("Sistema no puede continuar", e);
}
```

### 🎓 **Principios Teóricos Fundamentales**

#### **1. Principio de Especificidad**
```java
// Catch más específico ANTES que genérico
try {
    operacion();
} catch (FileNotFoundException e) {     // MÁS específico
    // manejo específico
} catch (IOException e) {               // MENOS específico
    // manejo general
} catch (Exception e) {                 // GENÉRICO (evitar)
    // último recurso
}
```

#### **2. Principio de Responsabilidad Única**
```java
// Cada catch debe manejar UNA responsabilidad
try {
    validarDatos();
    procesarDatos();
    guardarResultados();
} catch (ValidationException e) {
    // SOLO manejo de validación
} catch (ProcessingException e) {
    // SOLO manejo de procesamiento
} catch (PersistenceException e) {
    // SOLO manejo de persistencia
}
```

#### **3. Principio de Transparencia**
```java
// Las excepciones deben proporcionar información útil
try {
    operacion();
} catch (SpecificException e) {
    // Logging con contexto completo
    logger.log(Level.WARNING, 
        "Operación falló en contexto: usuario=" + usuario + 
        ", operación=" + operacionId + ", timestamp=" + timestamp, e);
    
    // Acción apropiada con información clara
    notificarUsuario("La operación no pudo completarse: " + e.getLocalizedMessage());
}
```

---

## �📖 TABLA DE CONTENIDOS

1. [Fundamentos Teóricos del Manejo de Excepciones](#fundamentos)
2. [Análisis de Errores Específicos en Funciones.java](#analisis-errores)
3. [Teoría de Correcciones y Mejores Prácticas](#teoria-correcciones)
4. [Patrones de Diseño para Manejo de Errores](#patrones-diseno)
5. [Casos de Estudio Prácticos](#casos-estudio)

---

## 1. 🔧 FUNDAMENTOS TEÓRICOS DEL MANEJO DE EXCEPCIONES {#fundamentos}

### 🎓 **Principios Fundamentales**

#### **A) Principio de Responsabilidad Única en Excepciones**
```java
// ❌ VIOLACIÓN: Un catch maneja múltiples responsabilidades
try {
    conectarBaseDatos();
    validarDatos();
    procesarTransaccion();
} catch (Exception e) {
    // ¿Error de conexión? ¿Validación? ¿Procesamiento?
    manejarError(e); // Respuesta genérica inapropiada
}

// ✅ CORRECTO: Separación de responsabilidades
try {
    conectarBaseDatos();
} catch (SQLException e) {
    manejarErrorConexion(e);
}

try {
    validarDatos();
} catch (ValidationException e) {
    manejarErrorValidacion(e);
}

try {
    procesarTransaccion();
} catch (TransactionException e) {
    manejarErrorTransaccion(e);
}
```

#### **B) Principio de Falla Rápida (Fail-Fast)**
```java
// ❌ INCORRECTO: Ocultar errores permite corrupción de estado
public void procesarDatos(String[] datos) {
    try {
        for (String dato : datos) {
            procesarDato(dato); // Puede fallar silenciosamente
        }
    } catch (Exception e) {
        // Continuar con datos corruptos
    }
}

// ✅ CORRECTO: Fallar rápido preserva integridad
public void procesarDatos(String[] datos) {
    // Validación defensiva ANTES de procesamiento
    if (datos == null || datos.length == 0) {
        throw new IllegalArgumentException("Datos no pueden ser null o vacíos");
    }
    
    for (String dato : datos) {
        if (dato == null || dato.trim().isEmpty()) {
            throw new IllegalArgumentException("Dato individual no puede ser null/vacío");
        }
        procesarDato(dato); // Falla rápido si hay problemas
    }
}
```

#### **C) Principio de Transparencia**
```java
// ❌ VIOLACIÓN: Información perdida
try {
    operacionCompleja();
} catch (Exception e) {
    return false; // ¿Qué pasó? ¿Por qué falló?
}

// ✅ CORRECTO: Transparencia total
try {
    operacionCompleja();
    return true;
} catch (SQLException e) {
    Logger.getLogger(getClass().getName()).log(Level.SEVERE, 
        "Error de base de datos en operación compleja", e);
    throw new ServiceException("Falla en acceso a datos", e);
} catch (ValidationException e) {
    Logger.getLogger(getClass().getName()).log(Level.WARNING, 
        "Datos inválidos en operación compleja", e);
    throw new ServiceException("Datos proporcionados son inválidos", e);
}
```

---

## 2. 🔍 ANÁLISIS DE ERRORES ESPECÍFICOS EN FUNCIONES.JAVA {#analisis-errores}

### **ERROR 1: Método esNumero() - Análisis Teórico**

#### 📊 **Código Actual:**
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

#### 🎓 **Análisis Teórico del Problema:**

**A) Uso Correcto de Try-Catch para Validación:**
- **✅ Semánticamente apropiado**: `parseDouble()` lanza excepción cuando el string no es numérico
- **✅ Delega validación**: Aprovecha la lógica robusta incorporada en Java
- **✅ Performance aceptable**: Para validaciones ocasionales, no en bucles críticos

**B) Problemas Identificados:**
- **❌ Captura genérica**: `Exception` es demasiado amplio
- **❌ Sin validación null**: `NullPointerException` no manejada explícitamente
- **❌ Sin documentación**: Comportamiento con null no especificado

#### 🔧 **Teoría de la Corrección:**

```java
/**
 * Verifica si una cadena representa un número válido de punto flotante.
 * 
 * TEORÍA APLICADA:
 * - Validación defensiva: Verificar precondiciones antes de operaciones costosas
 * - Especificidad en catch: Solo capturar NumberFormatException esperada
 * - Transparencia: Documentar todos los comportamientos posibles
 * 
 * @param string la cadena a verificar (puede ser null o vacía)
 * @return true si la cadena representa un número válido, false en caso contrario
 * @implNote Utiliza Double.parseDouble() para validación exhaustiva
 */
public static boolean esNumero(String string) {
    // PRINCIPIO: Fail-Fast con validación defensiva
    if (string == null || string.trim().isEmpty()) {
        return false;
    }
    
    try {
        Double.parseDouble(string.trim());
        return true;
    } catch (NumberFormatException e) {
        // PRINCIPIO: Especificidad - solo errores de parsing numérico
        return false;
    }
    // NOTA: No capturamos Exception porque no esperamos otros tipos de errores
}
```

### **ERROR 2: Catch Vacíos - Análisis Teórico**

#### 📊 **Problemas Identificados en Funciones.java:**
```java
// Línea 705: InterruptedException silenciada
}catch(InterruptedException e) {}

// Líneas 1075, 1101, 1120: HeadlessException silenciada  
catch(HeadlessException ex){}
```

#### 🎓 **Teoría del Problema:**

**A) Violación del Principio de Transparencia:**
```java
// ❌ ANTIPATRÓN: "Swallowing Exceptions"
catch(InterruptedException e) {}

// PROBLEMAS TEÓRICOS:
// 1. Rompe el protocolo de interrupción de Java
// 2. Oculta información vital para debugging
// 3. Puede causar deadlocks en aplicaciones multihilo
// 4. Viola el principio de "least surprise"
```

**B) Impacto en el Modelo de Concurrencia de Java:**
```java
// TEORÍA: InterruptedException es un mecanismo cooperativo
// - Thread.interrupt() establece una flag de interrupción
// - Métodos como Thread.sleep() verifican esta flag
// - Si se lanza InterruptedException, la flag se limpia automáticamente
// - El catch vacío impide restaurar la flag, rompiendo el protocolo
```

#### 🔧 **Teoría de la Corrección:**

```java
// ✅ PATRÓN CORRECTO: Restaurar estado de interrupción
catch(InterruptedException e) {
    // TEORÍA: Restaurar flag de interrupción para protocolo cooperativo
    Thread.currentThread().interrupt();
    
    // TEORÍA: Logging para observabilidad del sistema
    Logger.getLogger(Funciones.class.getName()).log(Level.INFO, 
        "Operación interrumpida por solicitud de cancelación", e);
    
    // TEORÍA: Decidir estrategia de salida apropiada
    throw new RuntimeException("Operación cancelada por interrupción", e);
}

// ✅ PATRÓN CORRECTO: HeadlessException informativa
catch(HeadlessException ex) {
    // TEORÍA: Aunque esperada en entornos sin GUI, debe registrarse
    Logger.getLogger(Funciones.class.getName()).log(Level.INFO, 
        "Operación GUI no disponible en entorno headless - usando alternativa", ex);
    
    // TEORÍA: Proporcionar funcionalidad alternativa
    ejecutarModoConsola();
}
```

### **ERROR 3: Captura Genérica de Exception - Análisis Teórico**

#### 📊 **Problema en Funciones.java (líneas múltiples):**
```java
}catch(Exception ex){
    // Captura demasiado amplia sin manejo específico
}
```

#### 🎓 **Teoría del Problema:**

**A) Violación del Principio de Especificidad:**
```java
// ❌ PROBLEMÁTICO: Catch "catch-all"
try {
    operacionCompleja();
} catch (Exception e) {
    // ¿SQLException? ¿IOException? ¿NullPointerException? ¿RuntimeException?
    // Respuesta genérica para problemas muy diferentes
}

// PROBLEMAS TEÓRICOS:
// 1. Puede capturar errores de programación (NPE, IllegalStateException)
// 2. Dificulta el debugging (información insuficiente)
// 3. Impide manejo diferenciado según el tipo de error
// 4. Puede ocultar bugs serios bajo "manejo de errores"
```

**B) Impacto en la Mantenibilidad:**
```java
// TEORÍA: La jerarquía de excepciones tiene propósito semántico
Exception
├── RuntimeException (errores de programación)
│   ├── NullPointerException
│   ├── IllegalArgumentException
│   └── IllegalStateException
├── SQLException (errores de base de datos)
├── IOException (errores de E/O)
└── InterruptedException (errores de concurrencia)

// Capturar Exception pierde esta información semántica valiosa
```

#### 🔧 **Teoría de la Corrección:**

```java
// ✅ PATRÓN CORRECTO: Múltiples catch específicos
try {
    operacionCompleja();
} catch (SQLException e) {
    // TEORÍA: Error de persistencia - estrategia de reintento
    Logger.getLogger(getClass()).log(Level.SEVERE, 
        "Error de base de datos", e);
    intentarRecuperacionBD(e);
    
} catch (ValidationException e) {
    // TEORÍA: Error de datos - informar al usuario
    Logger.getLogger(getClass()).log(Level.WARNING, 
        "Datos inválidos proporcionados", e);
    notificarUsuario("Datos inválidos: " + e.getMessage());
    
} catch (IllegalStateException e) {
    // TEORÍA: Error de programación - fallar rápido
    Logger.getLogger(getClass()).log(Level.SEVERE, 
        "Estado inconsistente del sistema", e);
    throw new SystemException("Sistema en estado inválido", e);
    
} catch (IOException e) {
    // TEORÍA: Error de E/O - estrategia de reintentos
    Logger.getLogger(getClass()).log(Level.WARNING, 
        "Error de comunicación", e);
    programarReintento(e);
}

// PRINCIPIO: Cada tipo de error recibe manejo apropiado a su naturaleza
```

---

## 3. 🛠️ TEORÍA DE CORRECCIONES Y MEJORES PRÁCTICAS {#teoria-correcciones}

### **A) Patrón de Validación Defensiva**

#### 🎓 **Fundamento Teórico:**
La validación defensiva es un principio de programación que establece verificar todas las precondiciones antes de ejecutar operaciones costosas o riesgosas.

```java
// ✅ PATRÓN IMPLEMENTADO: Validación por capas
public static void operacionSegura(String datos, Object configuracion) {
    // CAPA 1: Validación de argumentos (Fail-Fast)
    if (datos == null) {
        throw new IllegalArgumentException("Datos no pueden ser null");
    }
    if (configuracion == null) {
        throw new IllegalArgumentException("Configuración no puede ser null");
    }
    
    // CAPA 2: Validación de estado del sistema
    if (!sistemaInicializado()) {
        throw new IllegalStateException("Sistema no ha sido inicializado");
    }
    
    // CAPA 3: Validación de formato/contenido
    if (!validarFormatoDatos(datos)) {
        throw new ValidationException("Formato de datos inválido: " + datos);
    }
    
    // OPERACIÓN: Solo proceder después de todas las validaciones
    try {
        procesarDatosValidados(datos, configuracion);
    } catch (ProcessingException e) {
        // Error en procesamiento, no en validación
        Logger.getLogger(getClass()).log(Level.SEVERE, 
            "Error en procesamiento después de validación exitosa", e);
        throw new ServiceException("Procesamiento falló", e);
    }
}
```

### **B) Patrón de Logging Estructurado**

#### 🎓 **Fundamento Teórico:**
El logging estructurado proporciona información consistente y útil para debugging, monitoreo y análisis de sistemas en producción.

```java
// ✅ PATRÓN IMPLEMENTADO: Logger configurado profesionalmente
private static final Logger logger = Logger.getLogger(Funciones.class.getName());

// Configuración de niveles de logging
static {
    // En desarrollo: mostrar todo
    // En producción: solo WARNING y SEVERE
    ConsoleHandler handler = new ConsoleHandler();
    handler.setLevel(Level.INFO);
    logger.addHandler(handler);
    logger.setLevel(Level.INFO);
}

/**
 * Patrón estándar para logging de excepciones con contexto completo
 */
private static void logearExcepcionEstructurada(Level nivel, String operacion, 
                                               Map<String, Object> contexto, 
                                               Exception excepcion) {
    // TEORÍA: Información estructurada para análisis posterior
    StringBuilder mensaje = new StringBuilder();
    mensaje.append("Error en operación: ").append(operacion);
    
    if (contexto != null && !contexto.isEmpty()) {
        mensaje.append(" | Contexto: ");
        contexto.forEach((key, value) -> 
            mensaje.append(key).append("=").append(value).append(" "));
    }
    
    mensaje.append(" | Excepción: ").append(excepcion.getMessage());
    
    logger.log(nivel, mensaje.toString(), excepcion);
    
    // TEORÍA: Escalamiento automático para errores críticos
    if (nivel == Level.SEVERE) {
        notificarAdministrador(mensaje.toString(), excepcion);
    }
}

// Uso del patrón
try {
    operacionRiesgosa();
} catch (SQLException e) {
    Map<String, Object> contexto = Map.of(
        "usuario", getCurrentUser(),
        "timestamp", System.currentTimeMillis(),
        "operacion_id", getOperationId()
    );
    
    logearExcepcionEstructurada(Level.SEVERE, "acceso_base_datos", contexto, e);
}
```

### **C) Patrón de Recuperación por Capas**

#### 🎓 **Fundamento Teórico:**
La recuperación por capas implementa múltiples estrategias de fallback para mantener la funcionalidad del sistema incluso cuando ocurren errores.

```java
// ✅ PATRÓN IMPLEMENTADO: Recuperación escalonada
public static <T> T operacionConRecuperacion(Supplier<T> operacionPrincipal, 
                                            Supplier<T> operacionBackup,
                                            Supplier<T> operacionPorDefecto) {
    // CAPA 1: Intento principal
    try {
        T resultado = operacionPrincipal.get();
        logger.info("Operación principal exitosa");
        return resultado;
        
    } catch (PrimaryOperationException e) {
        logger.warning("Operación principal falló, intentando backup: " + e.getMessage());
        
        // CAPA 2: Operación de backup
        try {
            T resultado = operacionBackup.get();
            logger.info("Operación backup exitosa");
            return resultado;
            
        } catch (BackupOperationException e2) {
            logger.warning("Operación backup falló, usando valor por defecto: " + e2.getMessage());
            
            // CAPA 3: Valor por defecto (nunca falla)
            T resultado = operacionPorDefecto.get();
            logger.info("Usando valor por defecto");
            return resultado;
        }
    }
}

// Ejemplo de uso:
String configuracion = operacionConRecuperacion(
    () -> leerConfiguracionRemota(),    // Operación principal
    () -> leerConfiguracionLocal(),     // Backup
    () -> obtenerConfiguracionDefecto() // Por defecto
);
```

---

## 4. 🎨 PATRONES DE DISEÑO PARA MANEJO DE ERRORES {#patrones-diseno}

### **A) Patrón Result (Try/Either)**

#### 🎓 **Fundamento Teórico:**
El patrón Result encapsula tanto el éxito como el fallo en un tipo de dato, evitando excepciones para control de flujo.

```java
// ✅ IMPLEMENTACIÓN DEL PATRÓN RESULT
public class Result<T, E> {
    private final T valor;
    private final E error;
    private final boolean exito;
    
    private Result(T valor, E error, boolean exito) {
        this.valor = valor;
        this.error = error;
        this.exito = exito;
    }
    
    public static <T, E> Result<T, E> exito(T valor) {
        return new Result<>(valor, null, true);
    }
    
    public static <T, E> Result<T, E> error(E error) {
        return new Result<>(null, error, false);
    }
    
    public boolean esExito() { return exito; }
    public T getValor() { return valor; }
    public E getError() { return error; }
    
    // Métodos funcionales para composición
    public <U> Result<U, E> map(Function<T, U> mapper) {
        return exito ? exito(mapper.apply(valor)) : error(error);
    }
    
    public <U> Result<U, E> flatMap(Function<T, Result<U, E>> mapper) {
        return exito ? mapper.apply(valor) : error(error);
    }
}

// USO DEL PATRÓN RESULT
public static Result<Double, String> esNumeroSeguro(String entrada) {
    if (entrada == null || entrada.trim().isEmpty()) {
        return Result.error("Entrada no puede ser null o vacía");
    }
    
    try {
        double numero = Double.parseDouble(entrada.trim());
        return Result.exito(numero);
    } catch (NumberFormatException e) {
        return Result.error("Formato numérico inválido: " + entrada);
    }
}

// Composición funcional sin excepciones
String entrada = "42.5";
String resultado = esNumeroSeguro(entrada)
    .map(numero -> numero * 2)          // Solo si es éxito
    .map(numero -> "Resultado: " + numero)
    .map(String::toUpperCase)
    .getValor();  // "RESULTADO: 85.0"
```

### **B) Patrón Circuit Breaker**

#### 🎓 **Fundamento Teórico:**
El Circuit Breaker protege el sistema de fallos en cascada deteniendo temporalmente operaciones que están fallando consistentemente.

```java
// ✅ IMPLEMENTACIÓN SIMPLE DE CIRCUIT BREAKER
public class CircuitBreaker<T> {
    private enum Estado { CERRADO, ABIERTO, MEDIO_ABIERTO }
    
    private Estado estado = Estado.CERRADO;
    private int contadorFallos = 0;
    private long tiempoUltimoFallo = 0;
    private final int umbralFallos;
    private final long timeoutRecuperacion;
    
    public CircuitBreaker(int umbralFallos, long timeoutRecuperacion) {
        this.umbralFallos = umbralFallos;
        this.timeoutRecuperacion = timeoutRecuperacion;
    }
    
    public Result<T, String> ejecutar(Supplier<T> operacion) {
        // TEORÍA: Verificar estado antes de ejecutar
        if (estado == Estado.ABIERTO) {
            if (System.currentTimeMillis() - tiempoUltimoFallo > timeoutRecuperacion) {
                estado = Estado.MEDIO_ABIERTO;
                logger.info("Circuit breaker pasando a estado MEDIO_ABIERTO");
            } else {
                return Result.error("Circuit breaker ABIERTO - operación bloqueada");
            }
        }
        
        try {
            T resultado = operacion.get();
            
            // TEORÍA: Éxito restaura el estado
            if (estado == Estado.MEDIO_ABIERTO) {
                estado = Estado.CERRADO;
                contadorFallos = 0;
                logger.info("Circuit breaker CERRADO - operación recuperada");
            }
            
            return Result.exito(resultado);
            
        } catch (Exception e) {
            // TEORÍA: Fallo incrementa contador y puede abrir circuito
            contadorFallos++;
            tiempoUltimoFallo = System.currentTimeMillis();
            
            if (contadorFallos >= umbralFallos) {
                estado = Estado.ABIERTO;
                logger.warning("Circuit breaker ABIERTO después de " + contadorFallos + " fallos");
            }
            
            return Result.error("Operación falló: " + e.getMessage());
        }
    }
}

// USO DEL CIRCUIT BREAKER
CircuitBreaker<String> protectorBD = new CircuitBreaker<>(3, 5000); // 3 fallos, 5 segundos

Result<String, String> resultado = protectorBD.ejecutar(() -> {
    return consultarBaseDatos("SELECT * FROM usuarios");
});

if (resultado.esExito()) {
    procesarDatos(resultado.getValor());
} else {
    logger.warning("Operación protegida falló: " + resultado.getError());
    usarDatosCache();
}
```

---

## 5. 📚 CASOS DE ESTUDIO PRÁCTICOS {#casos-estudio}

### **CASO 1: Refactorización del Método esNumero()**

#### 📊 **Evolución del Código:**

```java
// ❌ VERSIÓN ORIGINAL
public static boolean esNumero(String string) {
    try {
        Double.parseDouble(string);
    } catch (Exception e) {
        return false;
    }
    return true;
}

// 🔄 VERSIÓN MEJORADA BÁSICA
public static boolean esNumero(String string) {
    if (string == null || string.trim().isEmpty()) {
        return false;
    }
    
    try {
        Double.parseDouble(string.trim());
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

// ✅ VERSIÓN PROFESIONAL CON RESULT
public static Result<Double, String> parseNumero(String entrada) {
    // Validación defensiva completa
    if (entrada == null) {
        return Result.error("Entrada no puede ser null");
    }
    
    String limpia = entrada.trim();
    if (limpia.isEmpty()) {
        return Result.error("Entrada no puede estar vacía");
    }
    
    try {
        double numero = Double.parseDouble(limpia);
        
        // Validaciones adicionales según contexto
        if (Double.isNaN(numero)) {
            return Result.error("Resultado es NaN (Not a Number)");
        }
        if (Double.isInfinite(numero)) {
            return Result.error("Resultado es infinito");
        }
        
        return Result.exito(numero);
        
    } catch (NumberFormatException e) {
        return Result.error("Formato numérico inválido: '" + entrada + 
                          "' - " + e.getMessage());
    }
}

// Método de compatibilidad con versión anterior
public static boolean esNumero(String string) {
    return parseNumero(string).esExito();
}
```

### **CASO 2: Sistema de Validación Robusto**

#### 📊 **Implementación Completa:**

```java
// ✅ SISTEMA DE VALIDACIÓN PROFESIONAL
public class ValidadorEntradas {
    private static final Logger logger = Logger.getLogger(ValidadorEntradas.class.getName());
    
    public static class ResultadoValidacion {
        private final boolean valido;
        private final List<String> errores;
        private final List<String> advertencias;
        
        public ResultadoValidacion(boolean valido, List<String> errores, List<String> advertencias) {
            this.valido = valido;
            this.errores = new ArrayList<>(errores);
            this.advertencias = new ArrayList<>(advertencias);
        }
        
        // Getters y métodos de utilidad
        public boolean esValido() { return valido; }
        public List<String> getErrores() { return new ArrayList<>(errores); }
        public List<String> getAdvertencias() { return new ArrayList<>(advertencias); }
        public String getMensajeCompleto() {
            StringBuilder sb = new StringBuilder();
            if (!errores.isEmpty()) {
                sb.append("Errores: ").append(String.join(", ", errores));
            }
            if (!advertencias.isEmpty()) {
                if (sb.length() > 0) sb.append(" | ");
                sb.append("Advertencias: ").append(String.join(", ", advertencias));
            }
            return sb.toString();
        }
    }
    
    /**
     * Valida todos los campos de entrada con reporte detallado
     */
    public static ResultadoValidacion validarEntradaCompleta() {
        List<String> errores = new ArrayList<>();
        List<String> advertencias = new ArrayList<>();
        
        // Validación de campos requeridos
        validarCamposRequeridos(errores);
        
        // Validación de rangos numéricos
        validarRangosNumericos(errores, advertencias);
        
        // Validación de compatibilidad entre campos
        validarCompatibilidad(errores, advertencias);
        
        // Validación de normas y estándares
        validarNormativas(advertencias);
        
        boolean esValido = errores.isEmpty();
        
        // Logging del resultado
        if (!esValido) {
            logger.log(Level.WARNING, "Validación falló: " + String.join("; ", errores));
        }
        
        return new ResultadoValidacion(esValido, errores, advertencias);
    }
    
    private static void validarCamposRequeridos(List<String> errores) {
        // Implementación con validación específica por campo
        if (Entrada.TxtPosNominal.getText().isEmpty()) {
            errores.add("Potencia nominal es requerida");
        }
        
        if (Entrada.TxtCargaL.getText().isEmpty()) {
            errores.add("Carga es requerida");
        }
        
        // Validación con parseNumero para campos numéricos
        String voltajeText = Entrada.TxtVoltaje.getText();
        Result<Double, String> voltajeResult = parseNumero(voltajeText);
        if (!voltajeResult.esExito()) {
            errores.add("Voltaje inválido: " + voltajeResult.getError());
        }
    }
    
    private static void validarRangosNumericos(List<String> errores, List<String> advertencias) {
        // Validación de rangos con Result pattern
        Result<Double, String> potenciaResult = parseNumero(Entrada.TxtPosNominal.getText());
        if (potenciaResult.esExito()) {
            double potencia = potenciaResult.getValor();
            if (potencia <= 0) {
                errores.add("Potencia debe ser mayor que cero");
            } else if (potencia > 1000) {
                advertencias.add("Potencia muy alta (>" + potencia + "kVA) - verificar especificaciones");
            }
        }
    }
    
    private static void validarCompatibilidad(List<String> errores, List<String> advertencias) {
        // Validación de lógica de negocio
        String norma = (String) Entrada.CmbNorma.getSelectedItem();
        String pais = (String) Entrada.CmbPais.getSelectedItem();
        
        if (norma != null && pais != null) {
            if (!esNormaCompatibleConPais(norma, pais)) {
                errores.add("Norma " + norma + " no es compatible con país " + pais);
            }
        }
    }
    
    private static void validarNormativas(List<String> advertencias) {
        // Validaciones específicas de normativas técnicas
        // Implementar según requerimientos específicos
    }
    
    private static boolean esNormaCompatibleConPais(String norma, String pais) {
        // Lógica de compatibilidad según base de datos de normas
        return true; // Placeholder
    }
}
```

---

## 🎯 CONCLUSIONES Y APLICACIÓN PRÁCTICA

### **Principios Clave Aplicados:**

1. **🔧 Fail-Fast**: Validar antes de procesar
2. **🎯 Especificidad**: Catch específicos según el tipo de error
3. **📝 Transparencia**: Logging completo y estructurado
4. **🔄 Recuperación**: Múltiples estrategias de fallback
5. **🛡️ Defensividad**: Validación de todas las precondiciones

### **Herramientas Implementadas:**

1. **Result Pattern**: Para operaciones que pueden fallar
2. **Circuit Breaker**: Para protección contra fallos en cascada
3. **Validación por Capas**: Para entrada de datos robusta
4. **Logging Estructurado**: Para observabilidad del sistema

### **Aplicación al Código Existente:**

Los patrones y principios presentados pueden aplicarse gradualmente al código de `Funciones.java`, priorizando:

1. Métodos críticos para la funcionalidad
2. Operaciones de E/O y base de datos
3. Validaciones de entrada de usuario
4. Cálculos matemáticos complejos

Esta refactorización mejorará significativamente la robustez, mantenibilidad y capacidad de debugging del sistema.
