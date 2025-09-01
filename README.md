
# 📚 Teoría Fundamental de Java 8

## TL;DR

Esta sección cubre los conceptos esenciales para iniciar en Java 8: cómo escribir y ejecutar un programa, la estructura de clases, tipos primitivos y de referencia, control de flujo y buenas prácticas básicas.

## 📋 Índice de Contenidos

- [CONCEPTO 1: El método main() - Punto de entrada](#-concepto-1-el-método-main---punto-de-entrada)
- [CONCEPTO 2: Estructura de clases](#️-concepto-2--estructura-de-clases)
- [CONCEPTO 3: Salida estándar (System.out)](#️-concepto-3--salida-estándar-systemout)
- [CONCEPTO 4: Case Sensitivity](#-concepto-4-case-sensitivity)
- [CONCEPTO 5: Variables estáticas vs de instancia](#️-concepto-5-variables-estáticas-vs-de-instancia)
- [CONCEPTO INTERMEDIO: Interfaces - ¿Qué significa implements Runnable?](#-concepto-intermedio-interfaces---qué-significa-implements-runnable)
- [CONCEPTO 6: Strings inmutables](#-concepto-6--strings-inmutables)
- [CONCEPTO 7: Estructuras de control](#-concepto-7-estructuras-de-control)
- [CONCEPTO 8: Arrays](#-concepto-8--arrays)
- [CONCEPTO 9: Tipos de datos (primitivos y wrappers)](#-concepto-9--tipos-de-datos-primitivos-y-wrappers)
- [CONCEPTO 10: Reglas para variables, clases y palabras reservadas](#-concepto-10--reglas-para-variables-clases-y-palabras-reservadas)
- [CONCEPTO 11: Tipos de comentarios](#-concepto-11--tipos-de-comentarios)
- [CONCEPTO 12: Paso de parámetros](#-concepto-12--paso-de-parámetros)
- [CONCEPTO 13: Peculiaridades y diferencias](#-concepto-13-peculiaridades-y-diferencias)
- [PROYECTO INTEGRADOR: Sistema de Gestión de Biblioteca](#-proyecto-integrador-sistema-de-gestión-de-biblioteca)
- [CONCEPTOS AVANZADOS](#conceptos-avanzados)

---

## 📖 TEORÍA DETALLADA

### 🔥 **CONCEPTO 1: El método main() - Punto de entrada**

El método `main()` es el punto de entrada de cualquier aplicación Java ejecutable.

#### Firma obligatoria:
```java
public static void main(String[] args)
```

#### Desglose de componentes:
- **`public`**: Permite que la JVM invoque el método desde fuera de la clase
- **`static`**: No requiere crear una instancia de la clase para ejecutarse  
- **`void`**: No retorna ningún valor
- **`main`**: Nombre exacto que busca la JVM
- **`String[] args`**: Array que recibe los argumentos de línea de comandos

    ---

### 🏗️ **CONCEPTO 2: Estructura de clases**

Todo el código ejecutable debe estar dentro de clases y métodos. Solo una clase `public` por archivo y debe coincidir el nombre del archivo.

#### **Ejemplo mínimo:**
```java
public class HolaMundo {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
    }
}
```

---

## 📚 **CONCEPTOS FUNDAMENTALES: CLASE, VARIABLES Y MÉTODOS**

### 🏛️ **¿QUÉ ES UNA CLASE?**

Una **CLASE** es un **MOLDE o PLANTILLA** que define:
- Las **características** (variables/atributos) que tendrán los objetos
- Los **comportamientos** (métodos) que podrán realizar los objetos
- Es como un **plano arquitectónico** para construir objetos

#### **🏗️ Analogía:**
```
Clase = Plantilla/Molde para crear herramientas de ingeniería
Objeto = Herramienta específica creada usando esa plantilla

Ejemplo Real:
- Clase Funciones = Molde para crear utilidades de cálculo
- Objeto funciones1 = Calculadora específica con su propia memoria/estado
- Objeto funciones2 = Otra calculadora independiente
```

#### **📝 Sintaxis de una clase:**
```java
public class NombreClase {
    // Variables (características)
    // Métodos (comportamientos)
    // Constructor (cómo crear objetos)
}
```

#### **🔍 Ejemplo práctico:**
```java
public class ClaseBasica {
    // Constructor
    public ClaseBasica() {
        System.out.println("Objeto ClaseBasica creado");
    }
    
    // Método main
    public static void main(String[] args) {
        ClaseBasica objeto = new ClaseBasica(); // Crear objeto del molde
    }
}
```

---

### 🔧 **¿QUÉ SON LAS VARIABLES?**

Las **VARIABLES** son **ESPACIOS DE MEMORIA** que almacenan datos. Representan las **CARACTERÍSTICAS** o **PROPIEDADES** de los objetos.

#### **🎯 Tipos de variables en Java:**

##### **1. VARIABLES DE INSTANCIA (Atributos):**
- Pertenecen a cada objeto individual
- Cada objeto tiene su propia copia
- Se declaran dentro de la clase, fuera de métodos

```java
// Del archivo Funciones.java - Variables de instancia
public class Funciones implements Runnable {
    String hora, minutos, segundos, ampm;  // Variables de instancia
    Calendar calendario;                    // Variable de instancia
    // Cada objeto Funciones tendría sus propias copias
}
```

##### **2. VARIABLES LOCALES:**
- Se declaran dentro de métodos
- Solo existen mientras se ejecuta el método
- Deben inicializarse antes de usarse

```java
// Del archivo Funciones.java - Variables locales en el método redondear
public static double redondear(double numero, int decimales) {
    // 'numero' y 'decimales' son parámetros (variables locales)
    double factor = Math.pow(10, decimales);  // Variable local
    return Math.round(numero * factor) / factor;
    // 'factor' solo existe dentro de este método
}
```

##### **3. VARIABLES ESTÁTICAS (de clase):**
- Pertenecen a la clase, no a objetos individuales
- Una sola copia compartida por todos los objetos
- Se marcan con la palabra `static`

```java
// Del archivo Funciones.java - Variables estáticas reales
public class Funciones {
    public static int Tamano;                    // Variable estática
    public static String Ip = "", Equipo = "";  // Variables estáticas inicializadas
    public static File Archivo = null;          // Variable estática tipo File
    public static double[][] VpTaps;            // Array estático bidimensional
    
    // Constantes estáticas - valores fijos de ingeniería
    public static double C1wrwct = 7.2661 * Math.pow(10, -5);
    public static double C2wrwct = -2.9651 * Math.pow(10, -4);
    
    // Variables boolean estáticas para control de estados
    public static boolean advEmbalaje = false;
    public static boolean ULxEstandar = false;
}
```

#### **💡 Características principales:**
- **INDEPENDENCIA**: Cada objeto tiene su propia copia (instancia)
- **MEMORIA**: Se almacenan en diferentes áreas (Heap, Stack, Method Area)
- **ACCESO**: Diferentes formas de acceder según el tipo
- **INICIALIZACIÓN**: En diferentes momentos del ciclo de vida

---

### ⚙️ **¿QUÉ SON LOS MÉTODOS?**

Los **MÉTODOS** son **BLOQUES DE CÓDIGO** que definen los **COMPORTAMIENTOS** o **ACCIONES** que puede realizar un objeto o una clase.

#### **🎯 Componentes de un método:**
```java
[modificador] [static] tipoRetorno nombreMetodo([parámetros]) {
    // Cuerpo del método
    [return valor;]  // Si retorna algo
}
```

#### **🔧 Tipos de métodos:**

##### **1. MÉTODOS DE INSTANCIA:**
- Operan sobre objetos específicos
- Pueden acceder a variables de instancia
- Se llaman: `objeto.nombreMetodo()`

```java
// Del archivo Funciones.java - Métodos de instancia reales
public class Funciones {
    // Variables de instancia
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    
    // Método de instancia que opera sobre las variables de instancia
    public void calcula() {
        // IMPLEMENTACIÓN COMPLETA del archivo Funciones.java:
        Calendar calendario = new GregorianCalendar();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        DatosEntrada.Fecha=+ dia + "/" + (mes+1) + "/" + año;
        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        }else{
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
        if (minutos.equals("15") & segundos.equals("00") || minutos.equals("30") & segundos.equals("00")  || 
            minutos.equals("45") & segundos.equals("00") || minutos.equals("59") & segundos.equals("00")){
            System.out.println("Se ejecuto a los "+minutos+"");
            Consultas.TiempoOracle();
        }
    }
    
    // Otro método de instancia del sistema real
    public void reloj() {
        // Función que calcula la hora y fecha en tiempo real
        // Trabaja con las variables de instancia del objeto
    }
}
```

##### **2. MÉTODOS ESTÁTICOS:**
- Pertenecen a la clase, no a objetos
- Se marcan con `static`
- Se llaman: `NombreClase.nombreMetodo()`

```java
// Del archivo Funciones.java - Métodos estáticos del mundo real

// Validación de entrada - no requiere objeto
public static boolean esNumero(String string) {
    // Determina si un string es número o no
    // No necesita crear objeto de Funciones para usarse
}

// Validación de datos - IMPLEMENTACIÓN COMPLETA
public static boolean esNumero(String string) {
    // IMPLEMENTACIÓN REAL del archivo Funciones.java:
    try {
        Double.parseDouble(string);
    } catch (Exception e) {
        return false;
    }
    return true;
}

// Cálculo matemático - IMPLEMENTACIÓN COMPLETA  
public static double redondear(double numero, int decimales) {
    // IMPLEMENTACIÓN REAL del archivo Funciones.java:
    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
}

// Validación de eventos del teclado - IMPLEMENTACIÓN COMPLETA
public static void SoloNumeros(java.awt.event.KeyEvent evt) {
    // IMPLEMENTACIÓN REAL del archivo Funciones.java:
    int k = (int) evt.getKeyChar();
    if (k==44) {
        evt.consume();
        JOptionPane.showMessageDialog(null, "Separador con (.)!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
    }else if (!((k >= 48 && k <= 57) || k < 32 || k ==127 || k==46)) {
        evt.consume();
        JOptionPane.showMessageDialog(null, "No puede ingresar Letras!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
    }
}

// Cálculos de ingeniería específicos - IMPLEMENTACIÓN COMPLETA
public static double Calculo_wo(double B) {
    // IMPLEMENTACIÓN REAL del archivo Funciones.java:
    double Wo= (VariablesEntrada.pla+ VariablesEntrada.plc * B + 
            VariablesEntrada.ple * (Math.pow(B, 2)) + VariablesEntrada.plg * 
            (Math.pow(B, 3)))*2.205 / (1 + VariablesEntrada.plb * B + VariablesEntrada.pld * 
            (Math.pow(B, 2)) + VariablesEntrada.plf * (Math.pow(B, 3)));
    return Wo;
}
```

##### **3. CONSTRUCTOR:**
- Método especial para crear objetos
- Mismo nombre que la clase
- No tiene tipo de retorno

```java
// Del archivo Funciones.java - Constructor implícito
public class Funciones implements Runnable {
    // Java crea automáticamente un constructor por defecto:
    // public Funciones() {
    //     // Inicializa variables de instancia con valores por defecto
    //     hora = null;
    //     minutos = null;
    //     calendario = null;
    // }
    
    // Constructor personalizado (si fuera necesario):
    public Funciones() {
        // Inicialización específica para el sistema de transformadores
        calendario = new GregorianCalendar();
        hora = "";
        minutos = "";
        segundos = "";
        ampm = "";
    }
}
```

---

### 🏛️ **RELACIÓN ENTRE CLASE, VARIABLES Y MÉTODOS**

#### **📋 Estructura conceptual:**

```
CLASE = CONTENEDOR
├── VARIABLES = CARACTERÍSTICAS/PROPIEDADES
│   ├── ¿Qué datos almacena?
│   ├── ¿Qué información describe al objeto/clase?
│   └── Ejemplo: Ip, Equipo, Tamano, banderas de control
│
└── MÉTODOS = COMPORTAMIENTOS/ACCIONES  
    ├── ¿Qué puede hacer la clase?
    ├── ¿Cómo procesa los datos?
    └── Ejemplo: redondear(), esNumero(), calcula(), VentanaEntrada()
```

#### **🎯 Ejemplo Real - Clase Funciones del Sistema:**

```java
// Del archivo Funciones.java - Clase utilitaria real de ingeniería
public class Funciones implements Runnable {
    
    // VARIABLES ESTÁTICAS (Compartidas por toda la aplicación):
    public static String Ip = "";           // IP del servidor
    public static String Equipo = "";       // Nombre del equipo
    public static int Tamano;                // Tamaño de elementos
    public static File Archivo = null;      // Archivo de trabajo actual
    
    // Variables de control del sistema
    public static int bandera, bandera1, bandera2; // Estados de proceso
    public static boolean advEmbalaje = false;      // Advertencia de embalaje
    public static double[][] VpTaps;               // Datos de taps de voltaje
    
    // Constantes de ingeniería (fórmulas específicas)
    public static double C1wrwct = 7.2661 * Math.pow(10, -5);
    public static double C2wrwct = -2.9651 * Math.pow(10, -4);
    
    // VARIABLES DE INSTANCIA (Específicas de cada objeto):
    String hora, minutos, segundos, ampm;    // Tiempo actual
    Calendar calendario;                     // Calendario del objeto
    
    // MÉTODOS ESTÁTICOS (Utilidades que no requieren objetos):
    
    // Validación de datos - IMPLEMENTACIÓN COMPLETA
    public static boolean esNumero(String string) {
        try {
            Double.parseDouble(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    // Cálculos matemáticos de ingeniería - IMPLEMENTACIÓN COMPLETA
    public static double redondear(double numero, int decimales) {
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    }
    
    public static double Calculo_wo(double B) {
        // IMPLEMENTACIÓN COMPLETA del archivo Funciones.java:
        double Wo= (VariablesEntrada.pla+ VariablesEntrada.plc * B + 
                VariablesEntrada.ple * (Math.pow(B, 2)) + VariablesEntrada.plg * 
                (Math.pow(B, 3)))*2.205 / (1 + VariablesEntrada.plb * B + VariablesEntrada.pld * 
                (Math.pow(B, 2)) + VariablesEntrada.plf * (Math.pow(B, 3)));
        return Wo;
    }
    
    // Gestión de interfaz de usuario - IMPLEMENTACIÓN COMPLETA
    public static void VentanaEntrada(boolean band) {
        try{
            VariablesEntrada.VEntrada=0;
            if (Funciones.entrada==null) {
                Funciones.entrada=new Entrada();
                Funciones.AbrirVentanas(Funciones.entrada,true,band,true);
                bandera=1;            
                DatosEntrada.InicializarVariables();
            }else{
                Funciones.AbrirVentanas(Funciones.entrada,false,band,true);
            }     
        }catch(HeadlessException ex){}
    }
    
    public static void SoloNumeros(java.awt.event.KeyEvent evt) {
        // IMPLEMENTACIÓN COMPLETA del archivo Funciones.java:
        int k = (int) evt.getKeyChar();
        if (k==44) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Separador con (.)!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
        }else if (!((k >= 48 && k <= 57) || k < 32 || k ==127 || k==46)) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "No puede ingresar Letras!!!", "Error Datos", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // MÉTODOS DE INSTANCIA (Operan sobre datos del objeto):
    public void calcula() {
        // Calcula hora y fecha usando 'calendario' (variable de instancia)
        calendario = new GregorianCalendar();
        // Actualiza hora, minutos, segundos, ampm
    }
    
    public void reloj() {
        // Función de reloj en tiempo real
        // Usa las variables de instancia para mantener el tiempo
    }
}
```

#### **💻 Uso Real en el Sistema:**

```java
// Uso de métodos estáticos (sin crear objetos):
public class SistemaTransformadores {
    public static void main(String[] args) {
        // Validar entrada de usuario
        String entrada = "123.45";
        if (Funciones.esNumero(entrada)) {
            double valor = Double.parseDouble(entrada);
            
            // Redondear para mostrar en interfaz
            double valorRedondeado = Funciones.redondear(valor, 2);
            System.out.println("Valor: " + valorRedondeado);
            
            // Calcular pérdidas en transformador
            double perdidas = Funciones.Calculo_wo(1.7); // 1.7 KiloGauss
            System.out.println("Pérdidas: " + perdidas + " W/kg");
            
            // Abrir ventana de entrada
            Funciones.VentanaEntrada(true);
        }
        
        // Uso de métodos de instancia (requiere objeto):
        Funciones reloj = new Funciones();
        reloj.calcula();  // Calcula tiempo actual
        reloj.reloj();    // Inicia reloj en tiempo real
    }
}
```

#### **🎓 Ejemplo Práctico - Clase Funciones del Sistema Real:**

```java
public class Funciones implements Runnable {
    // VARIABLES DE INSTANCIA: Características específicas de cada instancia
    String hora, minutos, segundos, ampm;  // Estado del reloj
    Calendar calendario;                    // Calendario específico del objeto
    
    // VARIABLES DE CLASE (STATIC): Compartidas por todos los objetos
    public static String Ip = "";           // IP del servidor
    public static String Equipo = "";       // Equipo actual
    public static int Tamano;               // Tamaño estándar
    public static boolean advEmbalaje = false;  // Control global
    
    // CONSTRUCTOR: Inicializa nuevas instancias
    public Funciones() {
        calendario = new GregorianCalendar();  // Inicializar calendario
        calcula();                             // Calcular hora inicial
    }
    
    // MÉTODOS DE INSTANCIA: Operan sobre datos específicos del objeto
    public void calcula() {
        // IMPLEMENTACIÓN COMPLETA del archivo Funciones.java:
        Calendar calendario = new GregorianCalendar();
        int año = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        DatosEntrada.Fecha=+ dia + "/" + (mes+1) + "/" + año;
        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM":"PM";
        if(ampm.equals("PM")){
            int h = calendario.get(Calendar.HOUR_OF_DAY)-12;
            hora = h>9?""+h:"0"+h;
        }else{
            hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+calendario.get(Calendar.HOUR_OF_DAY); 
        }
        minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+calendario.get(Calendar.SECOND);
        if (minutos.equals("15") & segundos.equals("00") || minutos.equals("30") & segundos.equals("00")  || 
            minutos.equals("45") & segundos.equals("00") || minutos.equals("59") & segundos.equals("00")){
            System.out.println("Se ejecuto a los "+minutos+"");
            Consultas.TiempoOracle();
        }
    }
    
    public void reloj() {
        // Función de reloj que usa los datos de esta instancia
        SwingUtilities.invokeLater(this);  // Actualización de interfaz
    }
    
    // MÉTODOS ESTÁTICOS: Utilidades independientes, no necesitan objetos
    public static double redondear(double numero, int decimales) {
        // IMPLEMENTACIÓN COMPLETA del archivo Funciones.java:
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    }
    
    public static boolean esNumero(String string) {
        // IMPLEMENTACIÓN COMPLETA del archivo Funciones.java:
        try {
            Double.parseDouble(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static void VentanaEntrada(boolean band) {
        // IMPLEMENTACIÓN COMPLETA del archivo Funciones.java:
        try{
            VariablesEntrada.VEntrada=0;
            if (Funciones.entrada==null) {
                Funciones.entrada=new Entrada();
                Funciones.AbrirVentanas(Funciones.entrada,true,band,true);
                bandera=1;            
                DatosEntrada.InicializarVariables();
            }else{
                Funciones.AbrirVentanas(Funciones.entrada,false,band,true);
            }     
        }catch(HeadlessException ex){}
    }
            v.setVisible(true);
        }
    }
}
```

#### **💻 Uso Real en el Sistema:**
```java
public class SistemaTransformadores {
    public static void main(String[] args) {
        // USAR MÉTODOS ESTÁTICOS (sin crear objetos):
        // Validar entrada de usuario
        String entrada = "123.45";
        if (Funciones.esNumero(entrada)) {  // Método estático
            double valor = Double.parseDouble(entrada);
            
            // Redondear resultado
            double resultado = Funciones.redondear(valor, 2);  // Método estático
            System.out.println("Valor procesado: " + resultado);
            
            // Abrir ventana del sistema
            Funciones.VentanaEntrada(true);  // Método estático
        }
        
        // CREAR Y USAR OBJETOS (instancias):
        Funciones reloj1 = new Funciones();     // Reloj del panel principal
        Funciones reloj2 = new Funciones();     // Reloj del panel de reportes
        
        // Cada objeto mantiene su propia hora
        reloj1.calcula();  // Calcula hora en reloj1
        reloj2.calcula();  // Calcula hora en reloj2 (independiente)
        
        // Cada objeto tiene su propio hilo de ejecución
        new Thread(reloj1).start();  // Inicia reloj1
        new Thread(reloj2).start();  // Inicia reloj2
        
        // Variables estáticas son compartidas:
        System.out.println("IP del sistema: " + Funciones.Ip);      // Mismo para todos
        System.out.println("Equipo: " + Funciones.Equipo);          // Mismo para todos
    }
}
```

---

### 💡 **PUNTOS CLAVE PARA RECORDAR**

#### **🔹 CLASE:**
- Es el **MOLDE/PLANTILLA**
- Define **QUÉ** características y comportamientos tendrán los objetos
- Se escribe **UNA VEZ**, se usa **MUCHAS VECES**

#### **🔹 VARIABLES:**
- Almacenan **DATOS/INFORMACIÓN**
- Representan el **ESTADO** del objeto
- Responden a: **"¿Qué información tiene?"**

#### **🔹 MÉTODOS:**
- Definen **ACCIONES/COMPORTAMIENTOS**
- Operan sobre los datos (variables)
- Responden a: **"¿Qué puede hacer?"**

#### **🎯 REGLA DE ORO:**
```
CLASE = VARIABLES (datos) + MÉTODOS (acciones)
OBJETO = Una instancia específica de la clase con valores concretos
```

**Esta es la base fundamental de la Programación Orientada a Objetos en Java.**

---

## 🔍 **ANÁLISIS PRÁCTICO: MÉTODO REAL DE FUNCIONES.JAVA**

### **🧮 Ejemplo del mundo real: Método `redondear()`**

Vamos a analizar un método real del archivo `Funciones.java` para ver cómo se aplican los conceptos fundamentales en la práctica:

```java
/**
 * <B>Titulo:</B>redondear<br>.
 * <B>Descripción:</B>Funcion paa redondear un numero<br>
 * @param numero
 * @param decimales
 * @return 
 * @since 1.0 Feb 10, 2014.
 */
public static double redondear(double numero, int decimales) {
    // Cálculo del factor de redondeo
    double factor = Math.pow(10, decimales);
    
    // Aplicar redondeo matemático
    return Math.round(numero * factor) / factor;
}
```

#### **🏗️ ANÁLISIS DETALLADO:**

##### **📚 CLASE: `Funciones`**
- **Propósito**: Contenedor de utilidades matemáticas y funciones auxiliares
- **Tipo**: Clase utilitaria (contiene métodos estáticos)
- **Ubicación**: `package modelo;`
- **Responsabilidad**: Proporcionar funciones matemáticas reutilizables

##### **🔧 VARIABLES en el método:**

**1. PARÁMETROS (Variables de entrada):**
```java
double numero    // Número que se va a redondear
int decimales    // Cantidad de decimales deseados
```

**2. VARIABLES LOCALES:**
```java
double factor = Math.pow(10, decimales);  // Variable local calculada
```

**3. VARIABLE DE RETORNO:**
```java
return Math.round(numero * factor) / factor;  // Resultado calculado
```

##### **⚙️ MÉTODO: `redondear()`**

**Componentes del método:**
- **`public`**: Modificador de acceso - puede llamarse desde cualquier lugar
- **`static`**: Método de clase - no requiere crear objeto de `Funciones`
- **`double`**: Tipo de retorno - devuelve un número decimal
- **`redondear`**: Nombre descriptivo del comportamiento
- **`(double numero, int decimales)`**: Parámetros de entrada

#### **💻 EJEMPLOS DE USO EN LA PRÁCTICA:**

```java
// Llamadas al método desde otras partes del código
public class EjemplosDeUso {
    public static void main(String[] args) {
        // Redondear a 2 decimales
        double precio = 15.6789;
        double precioRedondeado = Funciones.redondear(precio, 2);
        System.out.println("Precio: $" + precioRedondeado); // Precio: $15.68
        
        // Redondear a 1 decimal
        double temperatura = 23.456;
        double tempRedondeada = Funciones.redondear(temperatura, 1);
        System.out.println("Temperatura: " + tempRedondeada + "°C"); // Temperatura: 23.5°C
        
        // Redondear a entero (0 decimales)
        double distancia = 127.89;
        double distanciaEntera = Funciones.redondear(distancia, 0);
        System.out.println("Distancia: " + distanciaEntera + " km"); // Distancia: 128.0 km
    }
}
```

#### **🎯 CONCEPTOS FUNDAMENTALES APLICADOS:**

##### **🏛️ CLASE como contenedor:**
```java
public class Funciones {
    // Contiene múltiples métodos utilitarios
    public static double redondear(double numero, int decimales) { ... }
    public static boolean esNumero(String string) { ... }
    public static double Calculo_wo(double B) { ... }
    // ... más métodos
}
```

##### **🔧 VARIABLES con diferentes alcances:**
```java
public class Funciones {
    // VARIABLES ESTÁTICAS (de clase) - compartidas
    public static int Tamano;
    public static String Ip = "";
    
    // MÉTODO con variables locales - IMPLEMENTACIÓN COMPLETA
    public static double redondear(double numero, int decimales) {
        // PARÁMETROS - reciben valores del exterior
        // numero y decimales son variables locales
        
        // IMPLEMENTACIÓN REAL del archivo Funciones.java:
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
        
        /* EXPLICACIÓN DE LA FÓRMULA:
         * 1. Math.pow(10, decimales) crea el factor de multiplicación
         *    Ejemplo: para 2 decimales = 10^2 = 100
         * 2. numero * factor desplaza decimales a la izquierda 
         *    Ejemplo: 3.14159 * 100 = 314.159
         * 3. Math.round() redondea al entero más cercano
         *    Ejemplo: Math.round(314.159) = 314
         * 4. Dividir por factor regresa los decimales a su lugar
         *    Ejemplo: 314 / 100 = 3.14
         */
        
        // VARIABLE DE RETORNO - resultado del método
        return Math.round(numero * factor) / factor;
    }
}
```

##### **⚙️ MÉTODO como comportamiento:**
```java
// El método define UNA ACCIÓN ESPECÍFICA: "redondear números"
public static double redondear(double numero, int decimales) {
    // ENTRADA: Recibe datos (número y decimales)
    // PROCESAMIENTO: Aplica lógica matemática
    // SALIDA: Devuelve resultado procesado
}
```

#### **📊 FLUJO DE EJECUCIÓN PASO A PASO:**

```java
// 1. LLAMADA AL MÉTODO
double resultado = Funciones.redondear(15.6789, 2);

// 2. ASIGNACIÓN DE PARÁMETROS
// numero = 15.6789
// decimales = 2

// 3. CREACIÓN DE VARIABLE LOCAL
// factor = Math.pow(10, 2) = 100.0

// 4. CÁLCULO DEL RESULTADO
// numero * factor = 15.6789 * 100 = 1567.89
// Math.round(1567.89) = 1568
// 1568 / factor = 1568 / 100 = 15.68

// 5. RETORNO DEL RESULTADO
// return 15.68
```

#### **🏆 CARACTERÍSTICAS DEL DISEÑO:**

##### **✅ Buenas prácticas aplicadas:**
- **Método estático**: No necesita instancia, es una utilidad pura
- **Parámetros claros**: `numero` y `decimales` son autodescriptivos  
- **Nombre descriptivo**: `redondear` indica exactamente qué hace
- **Tipo de retorno apropiado**: `double` para mantener precisión
- **Documentación**: JavaDoc completo con propósito y parámetros

##### **🎯 Uso en el contexto real:**
```java
// En la aplicación real se usa para:
// - Redondear cálculos de ingeniería
// - Formatear precios y costos
// - Ajustar medidas y dimensiones
// - Presentar resultados con precisión controlada

// Ejemplo del contexto de transformadores:
double perdidas = 1567.8934;  // Pérdidas calculadas
double perdidasRedondeadas = Funciones.redondear(perdidas, 2);
// Resultado: 1567.89 W (más legible para reportes)
```

#### **💡 LECCIONES CLAVE:**

1. **CLASE**: `Funciones` actúa como biblioteca de utilidades
2. **VARIABLES**: Diferentes tipos con diferentes alcances y propósitos
3. **MÉTODO**: Encapsula una funcionalidad específica y reutilizable
4. **STATIC**: Permite usar la funcionalidad sin crear objetos
5. **PARÁMETROS**: Entrada de datos para personalizar el comportamiento
6. **RETORNO**: Salida procesada para usar en otros lugares

**Este ejemplo demuestra cómo los conceptos teóricos se aplican en código real de producción.**

---

### 🖥️ **CONCEPTO 3: Salida estándar (System.out)**

#### **¿Qué es System.out?**
`System.out` es un objeto de tipo `PrintStream` que representa la **salida estándar** del programa, típicamente la consola o terminal. Es parte de la clase `System` en el paquete `java.lang` y es la forma más común de mostrar información al usuario en aplicaciones de consola.

#### **1. MÉTODOS PRINCIPALES**

##### **1.1 println() - Imprime con salto de línea**
```java
public class EjemplosPrintln {
    public static void main(String[] args) {
        System.out.println("Primera línea");
        System.out.println("Segunda línea");
        System.out.println(42);
        System.out.println(true);
        System.out.println(3.14159);
        
        // Salida:
        // Primera línea
        // Segunda línea
        // 42
        // true
        // 3.14159
    }
}
```

##### **1.2 print() - Imprime sin salto de línea**
```java
public class EjemplosPrint {
    public static void main(String[] args) {
        System.out.print("Hola ");
        System.out.print("Mundo ");
        System.out.print("desde ");
        System.out.print("Java");
        
        // Salida: Hola Mundo desde Java
    }
}
```

##### **1.3 printf() - Impresión con formato**
```java
public class EjemplosPrintf {
    public static void main(String[] args) {
        String nombre = "Juan";
        int edad = 25;
        double altura = 1.75;
        boolean estudiante = true;
        
        System.out.printf("Nombre: %s%n", nombre);
        System.out.printf("Edad: %d años%n", edad);
        System.out.printf("Altura: %.2f metros%n", altura);
        System.out.printf("¿Es estudiante? %b%n", estudiante);
        
        // Formato complejo en una línea
        System.out.printf("%-10s | %3d | %6.2f | %-10s%n", 
                         nombre, edad, altura, estudiante);
        
        // Salida:
        // Nombre: Juan
        // Edad: 25 años
        // Altura: 1.75 metros
        // ¿Es estudiante? true
        // Juan       |  25 |   1.75 | true      
    }
}
```

#### **2. ESPECIFICADORES DE FORMATO**

| Especificador | Tipo | Descripción | Ejemplo |
|---------------|------|-------------|---------|
| `%s` | String | Cadena de texto | `"Hola"` |
| `%d` | int/long | Entero decimal | `123` |
| `%o` | int/long | Entero octal | `173` (123 en octal) |
| `%x` / `%X` | int/long | Entero hexadecimal | `7b` / `7B` |
| `%f` | float/double | Punto flotante | `123.456000` |
| `%.2f` | float/double | Flotante con 2 decimales | `123.46` |
| `%e` / `%E` | float/double | Notación científica | `1.234560e+02` |
| `%c` | char/int | Carácter | `'A'` |
| `%b` | boolean | Booleano | `true` / `false` |
| `%n` | - | Nueva línea (independiente del SO) | Salto de línea |
| `%%` | - | Símbolo de porcentaje literal | `%` |

#### **3. MODIFICADORES DE FORMATO**

##### **3.1 Ancho de campo y alineación:**
```java
public class ModificadoresFormato {
    public static void main(String[] args) {
        String producto = "Laptop";
        int precio = 1500;
        
        // Alineación a la derecha (por defecto)
        System.out.printf("%10s: $%5d%n", producto, precio);
        
        // Alineación a la izquierda
        System.out.printf("%-10s: $%-5d%n", producto, precio);
        
        // Rellenar con ceros
        System.out.printf("%010d%n", precio);
        
        // Mostrar signo siempre
        System.out.printf("%+d%n", precio);
        
        // Salida:
        //     Laptop: $ 1500
        // Laptop    : $1500 
        // 0000001500
        // +1500
    }
}
```

#### **4. DIFERENCIAS IMPORTANTES**

##### **4.1 print() vs println():**
```java
public class DiferenciasPrint {
    public static void main(String[] args) {
        // Con println() cada salida va en nueva línea
        System.out.println("Línea 1");
        System.out.println("Línea 2");
        System.out.println("Línea 3");
        
        System.out.println("--- Separador ---");
        
        // Con print() todo va en la misma línea
        System.out.print("Palabra1 ");
        System.out.print("Palabra2 ");
        System.out.print("Palabra3");
        System.out.println(); // Salto manual
        
        // Salida:
        // Línea 1
        // Línea 2
        // Línea 3
        // --- Separador ---
        // Palabra1 Palabra2 Palabra3
    }
}
```

##### **4.2 printf() vs println() para números:**
```java
public class FormatoNumeros {
    public static void main(String[] args) {
        double numero = 3.141592653589793;
        
        System.out.println("Con println():");
        System.out.println(numero); // 3.141592653589793
        
        System.out.println("Con printf():");
        System.out.printf("2 decimales: %.2f%n", numero);  // 3.14
        System.out.printf("4 decimales: %.4f%n", numero);  // 3.1416
        System.out.printf("Notación científica: %.2e%n", numero); // 3.14e+00
        
        // Para precios
        double precio = 1234.5;
        System.out.printf("Precio: $%,.2f%n", precio); // $1,234.50
    }
}
```

#### **5. BUENAS PRÁCTICAS**

##### **5.1 Uso de %n en lugar de \n:**
```java
// ❌ Dependiente del sistema operativo
System.out.printf("Primera línea\nSegunda línea");

// ✅ Independiente del sistema operativo
System.out.printf("Primera línea%nSegunda línea");
```

##### **5.2 Validación de argumentos:**
```java
public class ValidacionFormato {
    public static void main(String[] args) {
        String nombre = null;
        Integer edad = null;
        
        // ❌ Puede causar excepción
        // System.out.printf("Nombre: %s, Edad: %d%n", nombre, edad);
        
        // ✅ Validación previa
        System.out.printf("Nombre: %s, Edad: %s%n", 
                         nombre != null ? nombre : "N/A",
                         edad != null ? edad.toString() : "N/A");
    }
}
```

##### **5.3 Constantes para formatos complejos:**
```java
public class ConstantesFormato {
    private static final String FORMATO_PRODUCTO = "%-15s | $%8.2f | %5d unidades%n";
    private static final String FORMATO_FECHA = "%02d/%02d/%04d %02d:%02d%n";
    
    public static void main(String[] args) {
        System.out.printf(FORMATO_PRODUCTO, "Laptop", 1299.99, 5);
        System.out.printf(FORMATO_PRODUCTO, "Mouse", 29.99, 25);
        
        System.out.printf(FORMATO_FECHA, 15, 8, 2024, 14, 30);
    }
}
```

### 🎯 **Ejercicios prácticos para System.out**

#### **Ejercicio 1: Menú de restaurante**
```java
public class EjercicioMenu {
    public static void main(String[] args) {
        // Crear un menú usando System.out.printf con formato de tabla
        System.out.printf("╔═══════════════════════════════════════════╗%n");
        System.out.printf("║           RESTAURANTE JAVA CAFÉ          ║%n");
        System.out.printf("╠═══════════════════════════════════════════╣%n");
        System.out.printf("║ %-25s | %8s ║%n", "PLATO", "PRECIO");
        System.out.printf("╠═══════════════════════════════════════════╣%n");
        System.out.printf("║ %-25s | $%7.2f ║%n", "Hamburguesa Clásica", 12.99);
        System.out.printf("║ %-25s | $%7.2f ║%n", "Pizza Margarita", 15.50);
        System.out.printf("║ %-25s | $%7.2f ║%n", "Ensalada César", 9.25);
        System.out.printf("╚═══════════════════════════════════════════╝%n");
        
        // Agregar resumen con totales
        double subtotal = 37.74;
        double impuesto = subtotal * 0.15;
        double total = subtotal + impuesto;
        
        System.out.printf("%n--- RESUMEN DE CUENTA ---%n");
        System.out.printf("Subtotal: $%6.2f%n", subtotal);
        System.out.printf("Impuesto: $%6.2f%n", impuesto);
        System.out.printf("Total:    $%6.2f%n", total);
    }
}
```

#### **Ejercicio 2: Debug con System.err**
```java
public class EjercicioDebug {
    public static void main(String[] args) {
        String usuario = "admin";
        String password = "123456";
        
        System.out.println("=== Sistema de Login ===");
        System.out.printf("Usuario: %s%n", usuario);
        
        // Simular validación
        if (password.length() < 8) {
            System.err.printf("ERROR: Contraseña muy corta. Mínimo 8 caracteres, actual: %d%n", 
                            password.length());
            System.err.println("NIVEL: CRÍTICO - Acceso denegado");
            return;
        }
        
        System.out.println("✅ Login exitoso");
        System.out.printf("Bienvenido %s, hora de acceso: %tT%n", usuario, 
                         java.time.LocalTime.now());
    }
}
```

#### **Ejercicio 3: Calculadora con formato**
```java
public class EjercicioCalculadora {
    public static void main(String[] args) {
        double num1 = 15.7;
        double num2 = 4.3;
        
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║            CALCULADORA               ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.printf("%nOperandos: %.2f y %.2f%n%n", num1, num2);
        
        // Realizar operaciones y mostrar con formato
        System.out.printf("Suma:          %6.2f + %6.2f = %8.2f%n", num1, num2, num1 + num2);
        System.out.printf("Resta:         %6.2f - %6.2f = %8.2f%n", num1, num2, num1 - num2);
        System.out.printf("Multiplicación:%6.2f × %6.2f = %8.2f%n", num1, num2, num1 * num2);
        System.out.printf("División:      %6.2f ÷ %6.2f = %8.2f%n", num1, num2, num1 / num2);
        System.out.printf("Módulo:        %6.2f %% %6.2f = %8.2f%n", num1, num2, num1 % num2);
        
        // Mostrar en notación científica
        double resultado = num1 * num2;
        System.out.printf("%nEn notación científica: %e%n", resultado);
    }
}
```

---

### 📝 **CONCEPTO 4: Case Sensitivity**

Java es un lenguaje **case-sensitive**, lo que significa que distingue entre mayúsculas y minúsculas en **todos** los identificadores. Esta característica afecta nombres de variables, métodos, clases, palabras clave y literales.

#### **¿Qué significa Case Sensitivity?**

En Java, cada carácter en mayúscula se considera diferente de su equivalente en minúscula. Esto significa que `Variable`, `variable`, `VARIABLE` y `VaRiAbLe` son cuatro identificadores completamente distintos.

#### **Ejemplos prácticos:**

##### **1. Variables:**
```java
// Todas estas son VARIABLES DIFERENTES:
int edad = 25;
int Edad = 30;
int EDAD = 35;
int EdAd = 40;

System.out.println(edad);  // 25
System.out.println(Edad);  // 30
System.out.println(EDAD);  // 35
System.out.println(EdAd);  // 40
```
 
 - Tabla de promoción automática en operaciones:
     - byte, short, char → int
     - int + long → long
     - int + float → float
     - float + double → double

#### **Conversiones de tipos (Casting)**

##### **Conversiones implícitas (seguras):**
```java
// Widening conversion - sin pérdida de datos
byte → short → int → long → float → double
char → int

public class ConversionesImplicitas {
    public static void main(String[] args) {
        byte byteVal = 100;
        short shortVal = byteVal;  // byte → short (automático)
        int intVal = shortVal;     // short → int (automático)
        long longVal = intVal;     // int → long (automático)
        float floatVal = longVal;  // long → float (automático)
        double doubleVal = floatVal; // float → double (automático)
        
        System.out.println("Cadena de conversiones: " + doubleVal); // 100.0
    }
}
```

##### **Conversiones explícitas (potencialmente peligrosas):**
```java
public class ConversionesExplicitas {
    public static void main(String[] args) {
        // Narrowing conversion - puede haber pérdida de datos
        
        // 1. Pérdida de precisión:
        double pi = 3.141592653589793;
        float piFloat = (float) pi;    // Pierde precisión
        int piInt = (int) pi;          // Trunca decimales: 3
        
        System.out.println("double: " + pi);        // 3.141592653589793
        System.out.println("float:  " + piFloat);   // 3.1415927 (menos precisión)
        System.out.println("int:    " + piInt);     // 3 (sin decimales)
        
        // 2. Overflow/Underflow:
        long numeroGrande = 3000000000L;           // Mayor que int MAX
        int overflow = (int) numeroGrande;         // Resultado impredecible por overflow
        
        System.out.println("Original: " + numeroGrande);  // 3000000000
        System.out.println("Con overflow: " + overflow);  // -1294967296 (valor "envuelto")
        
        // 3. Conversión entre tipos incompatibles:
        int numero = 65;
        char caracter = (char) numero;             // int → char (código ASCII)
        System.out.println("Número 65 como char: " + caracter); // 'A'
    }
}
```

#### **Verificación de tipos en compilación vs ejecución**

##### **Lo que Java verifica en COMPILACIÓN:**
```java
public class VerificacionCompilacion {
    public static void main(String[] args) {
        // Verificaciones que Java hace ANTES de ejecutar:
        
        String texto = "Hola";
        // int numero = texto;           // ❌ ERROR: incompatibilidad de tipos
        // texto.metodoInexistente();    // ❌ ERROR: método no existe
        // int[] array = new String[5];  // ❌ ERROR: tipo de array incompatible
        
        // Verificación de parámetros de métodos:
        // procesarNumero(texto);        // ❌ ERROR: String no es int
        procesarNumero(42);              // ✅ OK: int es compatible
    }
    
    public static void procesarNumero(int numero) {
        System.out.println("Procesando: " + numero);
    }
}
```

##### **Lo que se verifica en EJECUCIÓN:**
```java
public class VerificacionEjecucion {
    public static void main(String[] args) {
        // Cosas que solo se pueden verificar ejecutando:
        
        // 1. División por cero:
        int a = 10;
        int b = 0;
        // int resultado = a / b; // Compila OK, pero RuntimeException en ejecución
        
        // 2. Acceso a arrays:
        int[] numeros = {1, 2, 3};
        // int valor = numeros[5]; // Compila OK, pero IndexOutOfBoundsException
        
        // 3. Cast de objetos:
        Object objeto = "Hola";
        // Integer entero = (Integer) objeto; // Compila OK, pero ClassCastException
        
        // 4. Referencias nulas:
        String texto = null;
        // int longitud = texto.length(); // Compila OK, pero NullPointerException
    }
}
```

#### **Comparación con otros lenguajes**

##### **Java vs JavaScript (tipado débil/dinámico):**
```javascript
// JavaScript - Conversiones automáticas "mágicas"
console.log(5 + "3");        // "53" (número + string = concatenación)
console.log("5" - 3);        // 2 (string - número = resta matemática)
console.log(true + 1);       // 2 (boolean + número = suma)
console.log([] + {});        // "[object Object]" (¡comportamiento inesperado!)
```

```java
// Java - Conversiones explícitas y controladas
public class ComparacionJS {
    public static void main(String[] args) {
        // ❌ Java NO permite estas "conversiones mágicas":
        // System.out.println(5 + "3");     // OK: concatenación, pero resultado es String
        // System.out.println("5" - 3);     // ERROR: String no tiene operador -
        // System.out.println(true + 1);    // ERROR: boolean + int incompatible
        
        // ✅ Java requiere intención clara:
        System.out.println(5 + "3");                    // "53" (concatenación)
        System.out.println(Integer.parseInt("5") - 3);  // 2 (conversión + resta)
        System.out.println((true ? 1 : 0) + 1);        // 2 (conversión explícita boolean→int)
    }
}
```

##### **Java vs Python (tipado fuerte/dinámico):**
```python
# Python - Tipado fuerte pero dinámico
numero = 42        # int
numero = "cuarenta" # Ahora es str (cambio de tipo en ejecución)
numero = [1, 2, 3] # Ahora es list

# Error solo se descubre AL EJECUTAR:
def procesar(x):
    return x + 10

procesar(5)        # OK: 15
procesar("hola")   # ¡RuntimeError! Solo se descubre al llamar la función
```

```java
// Java - Tipado fuerte y estático
public class ComparacionPython {
    public static void main(String[] args) {
        int numero = 42;
        // numero = "cuarenta";  // ❌ ERROR DE COMPILACIÓN: tipo no puede cambiar
        
        // Los errores se detectan ANTES de ejecutar:
        // procesar("hola");     // ❌ ERROR DE COMPILACIÓN: String no es int
        procesar(5);             // ✅ OK: tipo verificado en compilación
    }
    
    public static int procesar(int x) {
        return x + 10;
    }
}
```

#### **Ventajas y desventajas**

##### **✅ Ventajas del tipado fuerte y estático:**

1. **Detección temprana de errores**
2. **Mejor rendimiento** (optimizaciones en compilación)
3. **Mejor soporte de herramientas** (IDEs, refactoring)
4. **Código autodocumentado** (los tipos son documentación)
5. **Mayor confiabilidad** en aplicaciones grandes
6. **Refactoring más seguro**

##### **❌ Desventajas potenciales:**

1. **Más verboso**: Requiere declaraciones explícitas de tipos
2. **Menos flexibilidad**: No permite cambios dinámicos de tipo
3. **Curva de aprendizaje**: Desarrolladores de lenguajes dinámicos necesitan adaptación
4. **Código más largo**: Conversiones explícitas requieren más líneas

#### **Mejores prácticas con el sistema de tipos**

##### **1. Usar tipos más específicos cuando sea posible:**
```java
// ❌ Menos específico:
Object dato = "Hola mundo";
List lista = new ArrayList();

// ✅ Más específico:
String mensaje = "Hola mundo";
List<String> nombres = new ArrayList<String>();
```

##### **2. Evitar castings innecesarios:**
```java
// ❌ Cast innecesario:
double resultado = (double) (10 + 20);  // 10 + 20 ya es double

// ✅ Mejor:
double resultado = 10.0 + 20;  // Promoción automática a double
```

##### **3. Validar antes de cast peligrosos:**
```java
// ❌ Cast directo (peligroso):
Object obj = obtenerObjeto();
String texto = (String) obj; // Puede lanzar ClassCastException

// ✅ Validación antes de cast:
Object obj = obtenerObjeto();
if (obj instanceof String) {
    String texto = (String) obj; // Seguro
    System.out.println("Texto: " + texto);
} else {
    System.out.println("El objeto no es un String");
}
```

El tipado fuerte y estático de Java es uno de sus pilares fundamentales, proporcionando seguridad, rendimiento y mantenibilidad, especialmente crucial en aplicaciones empresariales grandes y complejas.

### 🎯 **Ejercicios prácticos para Case Sensitivity**

#### **Ejercicio 1: Identificar errores de case sensitivity**
```java
public class EjercicioCaseSensitivity {
    public static void main(String[] args) {
        // ¿Cuáles de estas líneas compilan y cuáles no?
        String mensaje = "Hola Mundo";
        // STRING mensaje2 = "Error";        // ❌ Error: STRING no existe
        // string mensaje3 = "Error";        // ❌ Error: string no existe (debe ser String)
        
        int numero = 42;
        // INT numero2 = 43;                 // ❌ Error: INT no existe (debe ser int)
        
        // System.Out.println(mensaje);      // ❌ Error: Out debe ser out
        System.out.println(mensaje);         // ✅ Correcto
        
        // Public static void main...        // ❌ Error: Public debe ser public
        // SYSTEM.OUT.PRINTLN("Error");      // ❌ Error: todo debe estar en minúsculas apropiadas
        
        // ¿Estas variables son diferentes?
        String nombre = "Juan";
        String Nombre = "Pedro";
        String NOMBRE = "Ana";
        String NoMbRe = "Luis";
        
        System.out.println("nombre: " + nombre);   // Juan
        System.out.println("Nombre: " + Nombre);   // Pedro
        System.out.println("NOMBRE: " + NOMBRE);   // Ana
        System.out.println("NoMbRe: " + NoMbRe);   // Luis
    }
}
```

#### **Ejercicio 2: Convenciones de nombres**
```java
public class EjercicioConvenciones {
    // Variables: camelCase
    private String nombreCompleto = "Juan Pérez";
    private int edadPersona = 25;
    private boolean estaActivo = true;
    
    // Constantes: UPPER_SNAKE_CASE  
    private static final String NOMBRE_APLICACION = "Mi App";
    private static final int MAXIMO_INTENTOS = 3;
    private static final double PI_VALOR = 3.141592653589793;
    
    // Métodos: camelCase
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Edad: " + edadPersona);
        System.out.println("Activo: " + estaActivo);
    }
    
    public int calcularAniosParaJubilacion() {
        final int EDAD_JUBILACION = 65;
        return EDAD_JUBILACION - edadPersona;
    }
    
    // Método main: punto de entrada
    public static void main(String[] args) {
        EjercicioConvenciones persona = new EjercicioConvenciones();
        persona.mostrarInformacion();
        
        System.out.println("Años para jubilación: " + 
                         persona.calcularAniosParaJubilacion());
        System.out.println("Aplicación: " + NOMBRE_APLICACION);
        System.out.println("Valor de PI: " + PI_VALOR);
    }
}
```

#### **Ejercicio 3: Errores comunes de principiantes**
```java
public class ErroresComunesCaseSensitivity {
    public static void main(String[] args) {
        // ERROR 1: Confundir palabras reservadas
        // string texto = "Error";          // ❌ string no existe, debe ser String
        String texto = "Correcto";          // ✅ String con S mayúscula
        
        // ERROR 2: Métodos de String mal escritos  
        String saludo = "hola mundo";
        // saludo.ToUpperCase();            // ❌ ToUpperCase no existe
        System.out.println(saludo.toUpperCase()); // ✅ toUpperCase con t minúscula
        
        // ERROR 3: Confundir System.out
        // system.out.println("Error");     // ❌ system debe ser System
        // System.Out.println("Error");     // ❌ Out debe ser out
        System.out.println("Correcto");    // ✅ System.out
        
        // ERROR 4: Clases vs instancias
        // math.sqrt(25);                   // ❌ math no existe
        System.out.println(Math.sqrt(25));  // ✅ Math con M mayúscula
        
        // ERROR 5: Variables vs métodos
        String nombre = "Java";
        // System.out.println(Nombre);      // ❌ Nombre no existe (variable es nombre)
        System.out.println(nombre);         // ✅ Variable correcta
        // System.out.println(nombre.Length); // ❌ Length no existe
        System.out.println(nombre.length()); // ✅ length() con l minúscula
    }
}
```

---

### 🏷️ **CONCEPTO 5: Variables estáticas vs de instancia**

En Java existen dos tipos principales de variables en las clases: **variables de instancia** (pertenecen a objetos individuales) y **variables estáticas** (pertenecen a la clase como un todo). Entender esta diferencia es fundamental para el diseño orientado a objetos.

#### **Variables de instancia (Non-static)**

##### **Definición y características:**
- Pertenecen a **objetos específicos** (instancias de la clase)
- Cada objeto tiene su **propia copia** de la variable
- Se crean cuando se instancia un objeto con `new`
- Se destruyen cuando el objeto es recolectado por el Garbage Collector
- **NO** pueden accederse sin crear un objeto primero

##### **Ejemplo básico:**
```java
public class Estudiante {
    // Variables de instancia
    private String nombre;        // Cada estudiante tiene su propio nombre
    private int edad;            // Cada estudiante tiene su propia edad  
    private double promedio;     // Cada estudiante tiene su propio promedio
    
    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;    // 'this' se refiere a esta instancia específica
        this.edad = edad;
        this.promedio = 0.0;
    }
    
    // Métodos de instancia (pueden acceder a variables de instancia)
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + ", Edad: " + edad);
    }
    
    // Getters y Setters
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }
}
```

##### **Uso de variables de instancia:**
```java
public class EjemploInstancia {
    public static void main(String[] args) {
        // Crear múltiples objetos - cada uno tiene SUS PROPIAS variables
        Estudiante student1 = new Estudiante("Ana", 20);
        Estudiante student2 = new Estudiante("Carlos", 22);
        Estudiante student3 = new Estudiante("María", 19);
        
        // Modificar variables de instancia independientemente
        student1.setPromedio(8.5);
        student2.setPromedio(9.2);
        student3.setPromedio(7.8);
        
        // Cada objeto mantiene sus propios valores
        System.out.println(student1.getNombre() + " - Promedio: " + student1.getPromedio()); // Ana - 8.5
        System.out.println(student2.getNombre() + " - Promedio: " + student2.getPromedio()); // Carlos - 9.2
        System.out.println(student3.getNombre() + " - Promedio: " + student3.getPromedio()); // María - 7.8
        
        // Cada objeto es independiente:
        System.out.println("Objetos en memoria:");
        System.out.println("student1: " + student1); // Estudiante@15db9742
        System.out.println("student2: " + student2); // Estudiante@6d06d69c  
        System.out.println("student3: " + student3); // Estudiante@7852e922
    }
}
```

#### **Variables estáticas (Static)**

##### **Definición y características:**
- Pertenecen a **la clase**, no a objetos específicos
- **Una sola copia** compartida por todos los objetos de la clase
- Se crean cuando la clase se carga por primera vez en memoria
- Existen durante toda la vida del programa
- Se pueden acceder **sin crear objetos**: `Clase.variableEstatica`
- También llamadas "variables de clase"

##### **Ejemplo básico:**
```java
public class Contador {
    // Variable estática - COMPARTIDA por todas las instancias
    private static int totalObjetos = 0;
    
    // Variable de instancia - ÚNICA para cada objeto
    private int numeroObjeto;
    
    public Contador() {
        totalObjetos++;                    // Incrementa el contador GLOBAL
        this.numeroObjeto = totalObjetos;  // Asigna número único a ESTA instancia
    }
    
    // Método estático - puede acceder solo a variables estáticas
    public static int getTotalObjetos() {
        return totalObjetos;
        // return numeroObjeto; // ❌ ERROR: no puede acceder a variables de instancia
    }
    
    // Método de instancia - puede acceder a ambos tipos de variables
    public int getNumeroObjeto() {
        return numeroObjeto;               // Variable de instancia - OK
    }
    
    public static int getTotalObjetosMetodoInstancia() {
        return totalObjetos;               // Variable estática - OK
    }
    
    public void mostrarInfo() {
        System.out.println("Soy el objeto #" + numeroObjeto + 
                          " de un total de " + totalObjetos + " objetos");
    }
}
```

##### **Uso de variables estáticas:**
```java
public class EjemploEstatico {
    public static void main(String[] args) {
        // Acceso a variable estática SIN crear objetos
        System.out.println("Objetos iniciales: " + Contador.getTotalObjetos()); // 0
        
        // Crear objetos - la variable estática se comparte
        Contador obj1 = new Contador();
        System.out.println("Después de crear obj1: " + Contador.getTotalObjetos()); // 1
        
        Contador obj2 = new Contador();
        System.out.println("Después de crear obj2: " + Contador.getTotalObjetos()); // 2
        
        Contador obj3 = new Contador();
        System.out.println("Después de crear obj3: " + Contador.getTotalObjetos()); // 3
        
        // Todos los objetos ven el MISMO valor estático
        obj1.mostrarInfo(); // Soy el objeto #1 de un total de 3 objetos
        obj2.mostrarInfo(); // Soy el objeto #2 de un total de 3 objetos  
        obj3.mostrarInfo(); // Soy el objeto #3 de un total de 3 objetos
        
        // Variables de instancia son independientes:
        System.out.println("obj1 número: " + obj1.getNumeroObjeto()); // 1
        System.out.println("obj2 número: " + obj2.getNumeroObjeto()); // 2
        System.out.println("obj3 número: " + obj3.getNumeroObjeto()); // 3
    }
}
```

#### **Comparación detallada**

##### **Tabla comparativa:**

| Aspecto | Variables de Instancia | Variables Estáticas |
|---------|----------------------|-------------------|
| **Declaración** | `private int edad;` | `private static int contador;` |
| **Pertenencia** | Objeto específico | Toda la clase |
| **Memoria** | Una copia por objeto | Una copia total |
| **Acceso** | `objeto.variable` | `Clase.variable` |
| **Creación** | Con `new Objeto()` | Al cargar la clase |
| **Destrucción** | Con Garbage Collection | Al finalizar programa |
| **Acceso desde métodos estáticos** | ❌ NO | ✅ SÍ |
| **Acceso desde métodos de instancia** | ✅ SÍ | ✅ SÍ |

##### **Ejemplo completo comparativo:**
```java
public class EjemploCompleto {
    // Variable estática - compartida por todas las instancias
    private static String institucion = "Universidad Central";
    private static int totalEstudiantes = 0;
    
    // Variables de instancia - únicas para cada objeto
    private String nombre;
    private int id;
    private double promedio;
    
    // Constructor
    public EjemploCompleto(String nombre, double promedio) {
        this.nombre = nombre;
        this.promedio = promedio;
        
        totalEstudiantes++;        // Incrementa contador global
        this.id = totalEstudiantes; // ID único basado en contador
    }
    
    // Método estático - solo accede a variables estáticas
    public static void mostrarInfoInstitucion() {
        System.out.println("Institución: " + institucion);
        System.out.println("Total estudiantes: " + totalEstudiantes);
        // System.out.println(nombre); // ❌ ERROR: no puede acceder a variables de instancia
    }
    
    // Método de instancia - puede acceder a ambos tipos
    public void mostrarInfoCompleta() {
        System.out.println("=== INFORMACIÓN COMPLETA ===");
        System.out.println("Institución: " + institucion);      // Variable estática - OK
        System.out.println("Total estudiantes: " + totalEstudiantes); // Variable estática - OK
        System.out.println("ID: " + id);                        // Variable de instancia - OK
        System.out.println("Nombre: " + nombre);                // Variable de instancia - OK
        System.out.println("Promedio: " + promedio);            // Variable de instancia - OK
    }
    
    // Método estático para cambiar datos de la institución
    public static void cambiarInstitucion(String nuevaInstitucion) {
        institucion = nuevaInstitucion; // Afecta a TODOS los estudiantes
    }
    
    // Getters
    public String getNombre() { return nombre; }
    public int getId() { return id; }
    public static int getTotalEstudiantes() { return totalEstudiantes; }
}
```

La comprensión de variables estáticas vs de instancia es esencial para diseñar clases eficientes y escribir código Java orientado a objetos correcto y mantenible.

---

## 🖥️ **CONCEPTO 3: Salida estándar (System.out)**

`System.out` es la forma más común de mostrar información en la consola en Java. Es un objeto de tipo `PrintStream` que representa la **salida estándar** del programa.

### **¿Qué es System.out?**

```java
System.out  // Objeto estático para salida estándar
  ↳ System     // Clase del sistema Java
  ↳ out        // Campo estático de tipo PrintStream  
  ↳ println()  // Método para imprimir con salto de línea
```

### **🎯 Métodos principales de System.out**

#### **1. println() - Imprimir con salto de línea**

```java
public class EjemplosPrintln {
    public static void main(String[] args) {
        // Imprimir texto simple
        System.out.println("¡Hola, Mundo!");
        
        // Imprimir variables
        String nombre = "Juan";
        int edad = 25;
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        
        // Imprimir expresiones matemáticas
        System.out.println("5 + 3 = " + (5 + 3));
        
        // Imprimir diferentes tipos de datos
        System.out.println(true);           // boolean
        System.out.println(3.14159);        // double
        System.out.println('A');            // char
        
        // Línea vacía
        System.out.println();  // Solo salto de línea
    }
}
```

**💡 Salida esperada:**
```
¡Hola, Mundo!
Nombre: Juan
Edad: 25
5 + 3 = 8
true
3.14159
A

```

#### **2. print() - Imprimir sin salto de línea**

```java
public class EjemplosPrint {
    public static void main(String[] args) {
        // print() no agrega salto de línea
        System.out.print("Hola ");
        System.out.print("Mundo ");
        System.out.println("Java!");  // Esta sí hace salto
        
        // Útil para contadores o progreso
        System.out.print("Cargando");
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            // En aplicación real harías Thread.sleep(500);
        }
        System.out.println(" ¡Completo!");
        
        // Crear líneas formateadas
        System.out.print("Nombre: ");
        System.out.print("María García");
        System.out.print(" | Edad: ");
        System.out.println("28");
    }
}
```

**💡 Salida esperada:**
```
Hola Mundo Java!
Cargando..... ¡Completo!
Nombre: María García | Edad: 28
```

#### **3. printf() - Imprimir con formato específico**

```java
public class EjemplosPrintf {
    public static void main(String[] args) {
        // Variables de ejemplo
        String nombre = "Ana";
        int edad = 30;
        double altura = 1.65;
        boolean estudiante = true;
        
        // Formato básico
        System.out.printf("Hola %s%n", nombre);
        
        // Múltiples variables
        System.out.printf("Nombre: %s, Edad: %d años%n", nombre, edad);
        
        // Números decimales con precisión
        System.out.printf("Altura: %.2f metros%n", altura);
        
        // Formato completo
        System.out.printf("Perfil: %s (%d años, %.2f m) - ¿Estudiante? %b%n", 
                         nombre, edad, altura, estudiante);
        
        // Formato de tabla
        System.out.printf("%-15s | %5s | %8s%n", "NOMBRE", "EDAD", "ALTURA");
        System.out.printf("%-15s | %5d | %8.2f%n", "Ana García", 30, 1.65);
        System.out.printf("%-15s | %5d | %8.2f%n", "Luis Martín", 25, 1.78);
        
        // Formato de moneda
        double precio = 1234.56;
        System.out.printf("Precio: $%,.2f%n", precio);
    }
}
```

**💡 Salida esperada:**
```
Hola Ana
Nombre: Ana, Edad: 30 años
Altura: 1.65 metros
Perfil: Ana (30 años, 1.65 m) - ¿Estudiante? true
NOMBRE          |  EDAD |   ALTURA
Ana García      |    30 |     1.65
Luis Martín     |    25 |     1.78
Precio: $1,234.56
```

### **📋 Especificadores de formato más comunes**

| Especificador | Tipo | Descripción | Ejemplo |
|---------------|------|-------------|---------|
| `%s` | String | Cadena de texto | `"Hola"` |
| `%d` | int/long | Número entero | `123` |
| `%f` | float/double | Número decimal | `3.14159` |
| `%.2f` | float/double | Decimal con 2 decimales | `3.14` |
| `%c` | char | Carácter individual | `'A'` |
| `%b` | boolean | Valor verdadero/falso | `true` |
| `%n` | - | Salto de línea | Nueva línea |
| `%%` | - | Símbolo % literal | `%` |

### **🎨 Modificadores de formato avanzados**

```java
public class FormatosAvanzados {
    public static void main(String[] args) {
        int numero = 42;
        
        // Ancho de campo
        System.out.printf("|%5d|%n", numero);        // |   42|
        System.out.printf("|%-5d|%n", numero);       // |42   |
        System.out.printf("|%05d|%n", numero);       // |00042|
        
        // Números grandes con separadores
        int grande = 1234567;
        System.out.printf("Número: %,d%n", grande);   // 1,234,567
        
        // Hexadecimal y octal
        System.out.printf("Decimal: %d, Hex: %x, Octal: %o%n", 255, 255, 255);
        // Decimal: 255, Hex: ff, Octal: 377
        
        // Fechas y tiempo (básico)
        System.out.printf("Año actual: %tY%n", new java.util.Date());
    }
}
```

### **🔧 Casos de uso prácticos en desarrollo**

#### **1. Debugging y desarrollo:**
```java
public class DebugEjemplo {
    public static void main(String[] args) {
        int[] numeros = {10, 20, 30, 40, 50};
        
        // Debug: mostrar estado de variables
        System.out.println("=== INICIO PROCESO ===");
        System.out.println("Array length: " + numeros.length);
        
        int suma = 0;
        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i];
            // Debug: mostrar progreso
            System.out.printf("Paso %d: %d + %d = %d%n", 
                            i+1, suma-numeros[i], numeros[i], suma);
        }
        
        System.out.println("=== RESULTADO FINAL ===");
        System.out.printf("Suma total: %d%n", suma);
        System.out.printf("Promedio: %.2f%n", (double)suma / numeros.length);
    }
}
```

#### **2. Interfaz de usuario básica:**
```java
public class MenuEjemplo {
    public static void main(String[] args) {
        // Mostrar menú de opciones
        System.out.println("╔══════════════════════════╗");
        System.out.println("║      CALCULADORA         ║");
        System.out.println("╠══════════════════════════╣");
        System.out.println("║ 1. Sumar                 ║");
        System.out.println("║ 2. Restar                ║");
        System.out.println("║ 3. Multiplicar           ║");
        System.out.println("║ 4. Dividir               ║");
        System.out.println("║ 0. Salir                 ║");
        System.out.println("╚══════════════════════════╝");
        System.out.print("Seleccione una opción: ");
        
        // En aplicación real, aquí leerías la entrada del usuario
    }
}
```

#### **3. Reportes y tablas:**
```java
public class ReporteEjemplo {
    public static void main(String[] args) {
        // Datos de ejemplo
        String[][] productos = {
            {"Laptop", "1200.00", "5"},
            {"Mouse", "25.99", "20"},
            {"Teclado", "75.50", "12"}
        };
        
        // Encabezado del reporte
        System.out.println("REPORTE DE INVENTARIO");
        System.out.println("=====================");
        System.out.printf("%-10s | %10s | %8s | %10s%n", 
                         "PRODUCTO", "PRECIO", "STOCK", "VALOR");
        System.out.println("-".repeat(45));
        
        double totalValor = 0;
        for (String[] producto : productos) {
            double precio = Double.parseDouble(producto[1]);
            int stock = Integer.parseInt(producto[2]);
            double valor = precio * stock;
            totalValor += valor;
            
            System.out.printf("%-10s | $%9.2f | %8d | $%9.2f%n", 
                             producto[0], precio, stock, valor);
        }
        
        System.out.println("-".repeat(45));
        System.out.printf("TOTAL INVENTARIO: $%,10.2f%n", totalValor);
    }
}
```

### **⚠️ Consideraciones importantes**

#### **1. Rendimiento:**
```java
// ❌ Ineficiente para muchas impresiones
for (int i = 0; i < 10000; i++) {
    System.out.println("Línea " + i);  // Lento
}

// ✅ Mejor para muchas impresiones
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append("Línea ").append(i).append("\n");
}
System.out.print(sb.toString());  // Una sola llamada
```

#### **2. Manejo de caracteres especiales:**
```java
public class CaracteresEspeciales {
    public static void main(String[] args) {
        // Caracteres de escape
        System.out.println("Comillas: \"Hola\"");           // "Hola"
        System.out.println("Apostrofe: 'Mundo'");           // 'Mundo'
        System.out.println("Barra invertida: \\Java\\");    // \Java\
        System.out.println("Nueva línea: Línea1\nLínea2");  
        System.out.println("Tabulación: Col1\tCol2");       
        
        // Unicode
        System.out.println("Símbolos: \u2764 \u2665 \u2666"); // ♥ ♦
    }
}
```

### **🎯 Ejercicios prácticos**

#### **Ejercicio 1: Calculadora de información personal**
```java
// Crea un programa que muestre tu información usando printf
public class MiInformacion {
    public static void main(String[] args) {
        // TODO: Completa con tus datos
        String nombre = "Tu Nombre";
        int edad = 0;
        double altura = 0.0;
        char inicial = 'X';
        boolean programador = false;
        
        // Usa printf para mostrar la información formateada
        System.out.printf("=== MI PERFIL ===%n");
        // Completar aquí...
    }
}
```

#### **Ejercicio 2: Tabla de multiplicar**
```java
// Crea una tabla de multiplicar del 1 al 10 bien formateada
public class TablaMultiplicar {
    public static void main(String[] args) {
        int numero = 7; // Cambia este número
        
        System.out.printf("TABLA DE MULTIPLICAR DEL %d%n", numero);
        System.out.println("========================");
        
        // TODO: Crear la tabla usando printf
        // Formato: "7 x 1 = 7"
    }
}
```

La comprensión de variables estáticas vs de instancia es esencial para diseñar clases eficientes y escribir código Java orientado a objetos correcto y mantenible.

### 🎯 **Ejercicios prácticos para Variables estáticas vs de instancia**

#### **Ejercicio 1: Contador de objetos**
```java
public class ContadorVehiculos {
    // Variable estática - compartida por todos los vehículos
    private static int totalVehiculos = 0;
    private static String concesionario = "AutoMax";
    
    // Variables de instancia - únicas para cada vehículo
    private String marca;
    private String modelo;
    private int numeroSerie;
    private double precio;
    
    public ContadorVehiculos(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        
        // Cada vez que se crea un vehículo, incrementa el contador
        totalVehiculos++;
        this.numeroSerie = totalVehiculos;
    }
    
    // Método estático - accede solo a variables estáticas
    public static void mostrarEstadisticasConcesionario() {
        System.out.println("=== ESTADÍSTICAS DEL CONCESIONARIO ===");
        System.out.println("Concesionario: " + concesionario);
        System.out.println("Total vehículos registrados: " + totalVehiculos);
        // System.out.println(marca); // ❌ Error: no puede acceder a variables de instancia
    }
    
    // Método de instancia - accede a ambos tipos de variables
    public void mostrarDetallesVehiculo() {
        System.out.println("--- Vehículo #" + numeroSerie + " ---");
        System.out.println("Concesionario: " + concesionario);  // Variable estática
        System.out.println("Marca: " + marca);                  // Variable de instancia
        System.out.println("Modelo: " + modelo);                // Variable de instancia
        System.out.println("Precio: $" + precio);               // Variable de instancia
        System.out.println("Total en inventario: " + totalVehiculos); // Variable estática
    }
    
    public static void main(String[] args) {
        // Mostrar estadísticas iniciales
        ContadorVehiculos.mostrarEstadisticasConcesionario();
        
        // Crear vehículos
        ContadorVehiculos auto1 = new ContadorVehiculos("Toyota", "Corolla", 22000);
        ContadorVehiculos auto2 = new ContadorVehiculos("Honda", "Civic", 24000);
        ContadorVehiculos auto3 = new ContadorVehiculos("Ford", "Focus", 21000);
        
        // Mostrar detalles individuales
        auto1.mostrarDetallesVehiculo();
        auto2.mostrarDetallesVehiculo();
        auto3.mostrarDetallesVehiculo();
        
        // Estadísticas finales
        ContadorVehiculos.mostrarEstadisticasConcesionario();
    }
}
```

#### **Ejercicio 2: Sistema bancario**
```java
public class CuentaBancaria {
    // Variables estáticas - información del banco
    private static String nombreBanco = "Banco Java";
    private static double tasaInteresBase = 0.02; // 2% anual
    private static int totalCuentasCreadas = 0;
    
    // Variables de instancia - información específica de la cuenta
    private String numeroCuenta;
    private String titular;
    private double saldo;
    private String tipoCuenta;
    
    public CuentaBancaria(String titular, String tipoCuenta, double saldoInicial) {
        this.titular = titular;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldoInicial;
        
        // Generar número de cuenta único
        totalCuentasCreadas++;
        this.numeroCuenta = "JAVA-" + String.format("%06d", totalCuentasCreadas);
    }
    
    // Método estático para cambiar configuración del banco
    public static void configurarBanco(String nuevoNombre, double nuevaTasa) {
        nombreBanco = nuevoNombre;
        tasaInteresBase = nuevaTasa;
        System.out.println("Configuración del banco actualizada:");
        System.out.println("Nombre: " + nombreBanco);
        System.out.println("Nueva tasa: " + (nuevaTasa * 100) + "%");
    }
    
    // Método de instancia para operaciones de cuenta
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.printf("Depósito realizado: $%.2f. Nuevo saldo: $%.2f%n", 
                            cantidad, saldo);
        }
    }
    
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.printf("Retiro realizado: $%.2f. Nuevo saldo: $%.2f%n", 
                            cantidad, saldo);
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida");
        }
    }
    
    public void calcularIntereses() {
        double interes = saldo * tasaInteresBase; // Usa variable estática
        saldo += interes;
        System.out.printf("Intereses aplicados: $%.2f. Nuevo saldo: $%.2f%n", 
                        interes, saldo);
    }
    
    // Método para mostrar información completa
    public void mostrarInformacionCompleta() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║              INFORMACIÓN DE CUENTA           ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.printf("║ Banco:        %-30s ║%n", nombreBanco);
        System.out.printf("║ Cuenta:       %-30s ║%n", numeroCuenta);
        System.out.printf("║ Titular:      %-30s ║%n", titular);
        System.out.printf("║ Tipo:         %-30s ║%n", tipoCuenta);
        System.out.printf("║ Saldo:        $%-29.2f ║%n", saldo);
        System.out.printf("║ Tasa interés: %-30.2f%% ║%n", tasaInteresBase * 100);
        System.out.println("╚══════════════════════════════════════════════╝");
    }
    
    public static void main(String[] args) {
        System.out.println("Total cuentas iniciales: " + totalCuentasCreadas);
        
        // Crear cuentas
        CuentaBancaria cuenta1 = new CuentaBancaria("Ana García", "Ahorro", 1000);
        CuentaBancaria cuenta2 = new CuentaBancaria("Luis Martín", "Corriente", 500);
        
        // Operaciones individuales
        cuenta1.depositar(200);
        cuenta1.calcularIntereses();
        cuenta1.mostrarInformacionCompleta();
        
        cuenta2.retirar(100);
        cuenta2.calcularIntereses();
        cuenta2.mostrarInformacionCompleta();
        
        // Cambiar configuración del banco (afecta a todas las cuentas)
        CuentaBancaria.configurarBanco("Banco Super Java", 0.025);
        
        // Los intereses ahora se calculan con la nueva tasa
        System.out.println("\n--- Después del cambio de configuración ---");
        cuenta1.calcularIntereses();
        cuenta2.calcularIntereses();
        
        System.out.println("Total cuentas creadas: " + totalCuentasCreadas);
    }
}
```

#### **Ejercicio 3: Juego con puntuación global**
```java
public class JuegoArcade {
    // Variables estáticas - información global del juego
    private static String nombreJuego = "Super Java Adventure";
    private static int recordMundial = 0;
    private static String poseedorRecord = "Ninguno";
    private static int totalPartidas = 0;
    
    // Variables de instancia - información del jugador
    private String nombreJugador;
    private int puntuacion;
    private int nivel;
    private boolean juegoTerminado;
    
    public JuegoArcade(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.puntuacion = 0;
        this.nivel = 1;
        this.juegoTerminado = false;
        totalPartidas++;
        
        System.out.println("¡Nuevo juego iniciado para " + nombreJugador + "!");
    }
    
    // Método estático para mostrar estadísticas globales
    public static void mostrarEstadisticasGlobales() {
        System.out.println("════════════════════════════════════════");
        System.out.println("        " + nombreJuego.toUpperCase());
        System.out.println("════════════════════════════════════════");
        System.out.println("Record mundial: " + recordMundial + " pts");
        System.out.println("Poseedor: " + poseedorRecord);
        System.out.println("Total partidas: " + totalPartidas);
        System.out.println("════════════════════════════════════════");
    }
    
    // Métodos de instancia para gameplay
    public void ganarPuntos(int puntos) {
        if (!juegoTerminado) {
            puntuacion += puntos;
            System.out.printf("%s ganó %d puntos. Total: %d%n", 
                            nombreJugador, puntos, puntuacion);
            
            // Verificar si es nuevo record
            if (puntuacion > recordMundial) {
                recordMundial = puntuacion;
                poseedorRecord = nombreJugador;
                System.out.println("🎉 ¡NUEVO RECORD MUNDIAL! 🎉");
            }
        }
    }
    
    public void subirNivel() {
        if (!juegoTerminado) {
            nivel++;
            int bonus = nivel * 50;
            puntuacion += bonus;
            System.out.printf("¡%s subió al nivel %d! Bonus: %d puntos%n", 
                            nombreJugador, nivel, bonus);
        }
    }
    
    public void terminarJuego() {
        juegoTerminado = true;
        System.out.printf("Juego terminado para %s%n", nombreJugador);
        System.out.printf("Puntuación final: %d puntos, Nivel: %d%n", 
                        puntuacion, nivel);
        
        if (puntuacion == recordMundial) {
            System.out.println("¡Tienes el record mundial!");
        } else {
            System.out.printf("Te faltan %d puntos para el record%n", 
                            recordMundial - puntuacion);
        }
    }
    
    public void mostrarEstadoJugador() {
        System.out.println("--- Estado del Jugador ---");
        System.out.println("Jugador: " + nombreJugador);
        System.out.println("Puntuación: " + puntuacion);
        System.out.println("Nivel: " + nivel);
        System.out.println("Estado: " + (juegoTerminado ? "Terminado" : "Jugando"));
        System.out.println("Record a superar: " + recordMundial);
    }
    
    public static void main(String[] args) {
        // Mostrar estadísticas iniciales
        JuegoArcade.mostrarEstadisticasGlobales();
        
        // Primer jugador
        JuegoArcade jugador1 = new JuegoArcade("Mario");
        jugador1.ganarPuntos(100);
        jugador1.subirNivel();
        jugador1.ganarPuntos(150);
        jugador1.mostrarEstadoJugador();
        jugador1.terminarJuego();
        
        System.out.println();
        
        // Segundo jugador
        JuegoArcade jugador2 = new JuegoArcade("Luigi");
        jugador2.ganarPuntos(80);
        jugador2.subirNivel();
        jugador2.ganarPuntos(200);
        jugador2.subirNivel();
        jugador2.ganarPuntos(300);
        jugador2.mostrarEstadoJugador();
        jugador2.terminarJuego();
        
        // Estadísticas finales
        JuegoArcade.mostrarEstadisticasGlobales();
    }
}
```

---

## 🔌 **CONCEPTO INTERMEDIO: INTERFACES - ¿Qué significa `implements Runnable`?**

### **¿Qué es una Interfaz en Java?**

Una **interfaz** es como un contrato que una clase debe cumplir. Define **qué métodos** debe tener una clase, pero no **cómo** deben implementarse. Es una forma de lograr herencia múltiple de comportamiento en Java.

```java
// Definición básica de una interfaz
public interface MiInterfaz {
    // Métodos que deben ser implementados (abstractos por defecto)
    void metodoObligatorio();
    int otroMetodo(String parametro);
    
    // Desde Java 8: métodos con implementación por defecto
    default void metodoConImplementacion() {
        System.out.println("Este método ya tiene código");
    }
}
```

### **La Interfaz Runnable: Un caso especial**

`Runnable` es una interfaz predefinida en Java que se usa para **multihilos** (threading). Su definición es muy simple:

```java
// Así está definida la interfaz Runnable en Java
public interface Runnable {
    public abstract void run();  // Un solo método abstracto
}
```

### **¿Por qué `implements Runnable` en nuestros ejemplos?**

Cuando ves `public class Funciones implements Runnable`, significa que:

1. **La clase `Funciones` DEBE implementar el método `run()`**
2. **La clase puede ser ejecutada en un hilo separado** 
3. **Es una técnica común en aplicaciones Java empresariales**

#### **Ejemplo práctico de por qué se usa:**

```java
// Clase que implementa Runnable para poder ejecutarse en paralelo
public class Funciones implements Runnable {
    
    // Variables de instancia para el hilo
    private String nombreHilo;
    private int tareasDeProceso;
    
    public Funciones(String nombre) {
        this.nombreHilo = nombre;
        this.tareasDeProceso = 0;
    }
    
    // MÉTODO OBLIGATORIO: debe implementarse por la interfaz Runnable
    @Override
    public void run() {
        // Este método se ejecuta cuando el hilo inicia
        System.out.println("🚀 Hilo iniciado: " + nombreHilo);
        
        for (int i = 1; i <= 5; i++) {
            System.out.printf("⚙️  %s procesando tarea %d/5%n", nombreHilo, i);
            tareasDeProceso++;
            
            try {
                Thread.sleep(1000); // Simula trabajo pesado (1 segundo)
            } catch (InterruptedException e) {
                System.err.println("❌ Hilo interrumpido: " + nombreHilo);
                return;
            }
        }
        
        System.out.printf("✅ %s completado. Tareas procesadas: %d%n", 
                         nombreHilo, tareasDeProceso);
    }
    
    // Otros métodos normales de la clase
    public static double redondear(double numero, int decimales) {
        double factor = Math.pow(10, decimales);
        return Math.round(numero * factor) / factor;
    }
    
    public void mostrarEstado() {
        System.out.printf("Hilo: %s, Tareas completadas: %d%n", 
                         nombreHilo, tareasDeProceso);
    }
}
```

#### **Cómo usar una clase que implementa Runnable:**

```java
public class EjemploMultihilos {
    public static void main(String[] args) {
        System.out.println("🎬 Iniciando ejemplo de multihilos...");
        
        // Crear instancias de la clase Funciones
        Funciones proceso1 = new Funciones("Calculadora-1");
        Funciones proceso2 = new Funciones("Calculadora-2");
        Funciones proceso3 = new Funciones("Calculadora-3");
        
        // Crear hilos usando las instancias Runnable
        Thread hilo1 = new Thread(proceso1);
        Thread hilo2 = new Thread(proceso2);
        Thread hilo3 = new Thread(proceso3);
        
        // Iniciar todos los hilos AL MISMO TIEMPO
        hilo1.start();  // Llama automáticamente al método run()
        hilo2.start();  // Llama automáticamente al método run()
        hilo3.start();  // Llama automáticamente al método run()
        
        // El hilo principal continúa ejecutándose
        System.out.println("📊 Hilos iniciados desde el hilo principal");
        
        try {
            // Esperar que terminen todos los hilos
            hilo1.join();
            hilo2.join();
            hilo3.join();
            
            System.out.println("🏁 Todos los hilos han terminado");
            
            // Mostrar estado final
            proceso1.mostrarEstado();
            proceso2.mostrarEstado();
            proceso3.mostrarEstado();
            
        } catch (InterruptedException e) {
            System.err.println("❌ Error esperando hilos: " + e.getMessage());
        }
    }
}
```

### **Salida esperada del programa:**

```
🎬 Iniciando ejemplo de multihilos...
📊 Hilos iniciados desde el hilo principal
🚀 Hilo iniciado: Calculadora-1
🚀 Hilo iniciado: Calculadora-2
🚀 Hilo iniciado: Calculadora-3
⚙️  Calculadora-1 procesando tarea 1/5
⚙️  Calculadora-2 procesando tarea 1/5
⚙️  Calculadora-3 procesando tarea 1/5
⚙️  Calculadora-1 procesando tarea 2/5
⚙️  Calculadora-2 procesando tarea 2/5
⚙️  Calculadora-3 procesando tarea 2/5
... (continúa hasta que todos terminen)
✅ Calculadora-1 completado. Tareas procesadas: 5
✅ Calculadora-2 completado. Tareas procesadas: 5
✅ Calculadora-3 completado. Tareas procesadas: 5
🏁 Todos los hilos han terminado
Hilo: Calculadora-1, Tareas completadas: 5
Hilo: Calculadora-2, Tareas completadas: 5
Hilo: Calculadora-3, Tareas completadas: 5
```

### **¿Por qué es útil esto en aplicaciones reales?**

#### **1. Procesamiento paralelo:**
```java
// Ejemplo: procesar múltiples cálculos matemáticos simultáneamente
public class CalculadoraParalela implements Runnable {
    private double[] numeros;
    private double resultado;
    
    public CalculadoraParalela(double[] numeros) {
        this.numeros = numeros;
    }
    
    @Override
    public void run() {
        // Cada hilo procesa una parte de los cálculos
        resultado = 0;
        for (double num : numeros) {
            resultado += Math.sqrt(num * num + Math.PI);
            // Simulación de cálculo complejo
        }
        System.out.printf("✅ Cálculo terminado. Resultado: %.2f%n", resultado);
    }
    
    public double getResultado() { return resultado; }
}
```

#### **2. Tareas en segundo plano:**
```java
// Ejemplo: guardar datos mientras el usuario sigue trabajando
public class GuardadoAutomatico implements Runnable {
    private String datosParaGuardar;
    
    public GuardadoAutomatico(String datos) {
        this.datosParaGuardar = datos;
    }
    
    @Override
    public void run() {
        System.out.println("💾 Guardando datos en segundo plano...");
        
        try {
            Thread.sleep(2000); // Simula escritura a disco
            // Aquí iría el código real de guardado
            System.out.println("✅ Datos guardados exitosamente");
        } catch (InterruptedException e) {
            System.err.println("❌ Error en guardado automático");
        }
    }
}
```

### **Diferencias importantes:**

#### **Extender Thread vs Implementar Runnable:**

```java
// OPCIÓN 1: Extender Thread (menos flexible)
class MiHilo extends Thread {
    @Override
    public void run() {
        System.out.println("Ejecutándose como Thread");
    }
}

// OPCIÓN 2: Implementar Runnable (más flexible) ⭐ RECOMENDADO
class MiTarea implements Runnable {
    @Override  
    public void run() {
        System.out.println("Ejecutándose como Runnable");
    }
}

// Uso:
public class ComparacionHilos {
    public static void main(String[] args) {
        // Opción 1: Thread directo
        MiHilo hilo1 = new MiHilo();
        hilo1.start();
        
        // Opción 2: Runnable (más versátil)
        MiTarea tarea = new MiTarea();
        Thread hilo2 = new Thread(tarea);
        hilo2.start();
        
        // También se puede usar con lambda (Java 8+)
        Thread hilo3 = new Thread(() -> {
            System.out.println("Ejecutándose con lambda");
        });
        hilo3.start();
    }
}
```

### **¿Por qué usar Runnable es mejor?**

1. **✅ Flexibilidad**: Tu clase puede extender otra clase y aún implementar Runnable
2. **✅ Reutilización**: La misma instancia Runnable puede usarse en múltiples hilos
3. **✅ Separación de responsabilidades**: La lógica de negocio está separada del manejo de hilos
4. **✅ Compatibilidad**: Funciona bien con ExecutorService y ThreadPools modernos

### **En el contexto de nuestros ejemplos:**

Cuando veas `public class Funciones implements Runnable` en los ejemplos del README, ahora sabes que:

- **La clase puede ejecutarse en hilos paralelos** 
- **Debe implementar obligatoriamente el método `run()`**
- **Es una práctica común en aplicaciones Java empresariales**
- **Permite que las funciones matemáticas se ejecuten simultáneamente**

### 🎯 **Ejercicio práctico con Runnable:**

```java
public class CalculadoraAvanzada implements Runnable {
    private String operacion;
    private double num1, num2;
    private double resultado;
    
    public CalculadoraAvanzada(String op, double a, double b) {
        this.operacion = op;
        this.num1 = a;
        this.num2 = b;
    }
    
    @Override
    public void run() {
        System.out.printf("🔢 Iniciando %s: %.2f y %.2f%n", operacion, num1, num2);
        
        try {
            Thread.sleep(500); // Simula procesamiento complejo
            
            switch (operacion.toLowerCase()) {
                case "suma":
                    resultado = num1 + num2;
                    break;
                case "multiplicacion":
                    resultado = num1 * num2;
                    break;
                case "potencia":
                    resultado = Math.pow(num1, num2);
                    break;
                case "raiz":
                    resultado = Math.sqrt(num1);
                    break;
                default:
                    resultado = 0;
            }
            
            System.out.printf("✅ %s completada: %.2f%n", operacion, resultado);
            
        } catch (InterruptedException e) {
            System.err.println("❌ Cálculo interrumpido: " + operacion);
        }
    }
    
    public double getResultado() { return resultado; }
    
    public static void main(String[] args) throws InterruptedException {
        // Crear múltiples operaciones
        CalculadoraAvanzada suma = new CalculadoraAvanzada("suma", 15, 25);
        CalculadoraAvanzada multiplicacion = new CalculadoraAvanzada("multiplicacion", 7, 8);
        CalculadoraAvanzada potencia = new CalculadoraAvanzada("potencia", 2, 10);
        CalculadoraAvanzada raiz = new CalculadoraAvanzada("raiz", 144, 0);
        
        // Ejecutar todas las operaciones EN PARALELO
        Thread[] hilos = {
            new Thread(suma),
            new Thread(multiplicacion),
            new Thread(potencia),
            new Thread(raiz)
        };
        
        // Iniciar todos los hilos
        for (Thread hilo : hilos) {
            hilo.start();
        }
        
        // Esperar que terminen todos
        for (Thread hilo : hilos) {
            hilo.join();
        }
        
        // Mostrar resultados finales
        System.out.println("\n📊 RESULTADOS FINALES:");
        System.out.printf("Suma: %.2f%n", suma.getResultado());
        System.out.printf("Multiplicación: %.2f%n", multiplicacion.getResultado());
        System.out.printf("Potencia: %.2f%n", potencia.getResultado());
        System.out.printf("Raíz: %.2f%n", raiz.getResultado());
    }
}
```

**Ahora entiendes completamente qué significa `implements Runnable` y por qué es tan poderoso en Java para aplicaciones que necesitan ejecutar tareas en paralelo.**

---

### 📝 **CONCEPTO 6: Strings inmutables**

Los `String` en Java son objetos inmutables: una vez creado un `String`, su contenido no puede cambiar.

¿Qué significa esto en la práctica?
- Cualquier operación que parezca "modificar" un `String` en realidad crea un nuevo objeto `String`.

Ejemplo:
```java
String s = "Java";           // objeto A
String t = s.toUpperCase();   // crea objeto B con "JAVA"; s sigue siendo "Java"
```

Ventajas de la inmutabilidad:
- Seguridad en concurrencia: múltiples hilos pueden compartir el mismo `String` sin sincronización.
- Caching y rendimiento en lecturas: el valor (y su hash) puede computarse una vez.
- Uso eficiente del String Pool (ver más abajo).

String Pool e `intern()`:
- Literales de `String` se colocan en un pool (permite reutilizar la misma instancia para literales idénticos).
- `String.intern()` fuerza que una cadena tenga su versión canonical en el pool y devuelve esa referencia.

```java
String a = "hola";                // internado por literal
String b = new String("hola");    // objeto distinto en heap
String c = b.intern();              // c referencia la instancia del pool (igual a a)
System.out.println(a == c);         // true
```

Igualdad: `==` vs `equals()`
- `==` compara referencias (misma instancia).
- `equals()` compara contenido del `String` (uso recomendado para comparar textos).

```java
String x = new String("x");
String y = new String("x");
System.out.println(x == y);        // false
System.out.println(x.equals(y));   // true
```

Rendimiento y concatenación
- En concatenaciones simples y literales, el compilador optimiza `+` en tiempo de compilación.
- En bucles o concatenaciones intensivas, usar `StringBuilder` (no `String`) para evitar crear muchos objetos temporales.

Ejemplo comparativo:
```java
// Ineficiente: crea muchos Strings temporales
String r = "";
for (int i = 0; i < 1000; i++) {
    r += i + ",";
}

// Eficiente: reutiliza el mismo buffer
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i).append(',');
}
String result = sb.toString();
```

Buenas prácticas resumidas
- Usa `StringBuilder` en loops o concatenaciones grandes.
- Usa `equals()` para comparar contenido.
- Aprovecha literales y `intern()` sólo cuando realmente necesites canonicalizar referencias (uso avanzado).
- Evita dependencias en comportamiento histórico (por ejemplo, detalles de implementación de `substring` que cambiaron en versiones antiguas de Java).

---

### 🔄 **CONCEPTO 7: Estructuras de control**

Las estructuras de control permiten alterar el flujo de ejecución del programa basándose en condiciones o repeticiones. Java ofrece estructuras condicionales, de selección múltiple y de repetición.

#### **ESTRUCTURAS CONDICIONALES**

##### **IF-ELSE - Condicional básica:**
```java
// Forma básica
if (condicion) {
    // Se ejecuta si la condición es true
    System.out.println("Condición verdadera");
}

// Con else
if (edad >= 18) {
    System.out.println("Es mayor de edad");
} else {
    System.out.println("Es menor de edad");
}

// Con else if (múltiples condiciones)
if (nota >= 90) {
    System.out.println("Excelente");
} else if (nota >= 80) {
    System.out.println("Muy bueno");
} else if (nota >= 70) {
    System.out.println("Bueno");
} else if (nota >= 60) {
    System.out.println("Suficiente");
} else {
    System.out.println("Insuficiente");
}
```

**⚠️ Importante en Java:**
```java
// ❌ ERROR - Java requiere boolean explícito (no int como C)
int numero = 5;
if (numero) { ... }  // Error de compilación

// ✅ CORRECTO - Comparación explícita
if (numero != 0) { ... }  // OK

// ❌ ERROR - Asignación en lugar de comparación
if (numero = 5) { ... }  // Error de compilación

// ✅ CORRECTO - Comparación
if (numero == 5) { ... }  // OK
```

##### **Operador ternario (? :):**
```java
// Sintaxis: condición ? valorSiTrue : valorSiFalse
String resultado = (edad >= 18) ? "Mayor" : "Menor";

// Equivale a:
String resultado;
if (edad >= 18) {
    resultado = "Mayor";
} else {
    resultado = "Menor";
}

// Ejemplos prácticos
int max = (a > b) ? a : b;  // Máximo de dos números
String mensaje = (saldo > 0) ? "Cuenta positiva" : "Cuenta en números rojos";
```

#### **SWITCH - Selección múltiple**

##### **Switch tradicional (Java 8):**
```java
switch (variable) {
    case valor1:
        // Código para valor1
        break;  // ⚠️ Importante: sin break continúa al siguiente case
    case valor2:
        // Código para valor2
        break;
    case valor3:
    case valor4:  // Múltiples casos con la misma lógica
        // Código para valor3 y valor4
        break;
    default:  // Opcional: caso por defecto
        // Código si no coincide ningún case
        break;
}
```

**Tipos permitidos en switch:**
```java
// ✅ PERMITIDOS en Java 8:
switch (entero) { ... }     // int, byte, short, char
switch (caracter) { ... }   // char
switch (cadena) { ... }     // String (desde Java 7)
switch (enumValue) { ... }  // enum

// ❌ NO PERMITIDOS:
switch (numeroLong) { ... }     // long
switch (numeroFloat) { ... }    // float
switch (numeroDouble) { ... }   // double
switch (booleano) { ... }       // boolean
```

**Ejemplos prácticos:**
```java
// Switch con String
switch (dia.toUpperCase()) {
    case "LUNES":
    case "MARTES":
    case "MIÉRCOLES":
    case "JUEVES":
    case "VIERNES":
        System.out.println("Día laboral");
        tipoJornada = "trabajo";
        break;
    case "SÁBADO":
    case "DOMINGO":
        System.out.println("Fin de semana");
        tipoJornada = "descanso";
        break;
    default:
        System.out.println("Día no reconocido");
        tipoJornada = "indefinido";
}

// Switch con enum
public enum Estado {
    ACTIVO, INACTIVO, SUSPENDIDO, BLOQUEADO
}

switch (usuario.getEstado()) {
    case ACTIVO:
        permitirAcceso();
        break;
    case INACTIVO:
        mostrarMensajeActivacion();
        break;
    case SUSPENDIDO:
        mostrarMensajeSuspension();
        break;
    case BLOQUEADO:
        denegarAcceso();
        break;
}
```

**⚠️ Cuidado con el fall-through:**
```java
// Comportamiento fall-through (continúa sin break)
int puntos = 0;
switch (nivel) {
    case 1:
        puntos += 10;  // Si nivel = 1, suma 10
    case 2:
        puntos += 20;  // Si nivel = 1 o 2, suma 20
    case 3:
        puntos += 30;  // Si nivel = 1, 2 o 3, suma 30
        break;
}
// Si nivel = 1, puntos = 60 (10+20+30)
// Si nivel = 2, puntos = 50 (20+30)
// Si nivel = 3, puntos = 30
```

#### **BUCLES - Estructuras de repetición**

##### **FOR - Bucle con contador:**
```java
// Sintaxis básica
for (inicialización; condición; incremento) {
    // Código a repetir
}

// Ejemplo típico
for (int i = 0; i < 10; i++) {
    System.out.println("Iteración: " + i);
}

// Múltiples variables
for (int i = 0, j = 10; i < j; i++, j--) {
    System.out.println("i = " + i + ", j = " + j);
}

// Bucle decreciente
for (int i = 10; i >= 0; i--) {
    System.out.println("Cuenta regresiva: " + i);
}

// Incremento personalizado
for (int i = 0; i < 100; i += 5) {
    System.out.println("Múltiplo de 5: " + i);
}
```

##### **FOR-EACH (Enhanced For Loop):**
```java
// Para arrays
int[] numeros = {1, 2, 3, 4, 5};
for (int numero : numeros) {
    System.out.println("Número: " + numero);
}

// Para colecciones
List<String> nombres = Arrays.asList("Ana", "Luis", "María");
for (String nombre : nombres) {
    System.out.println("Nombre: " + nombre);
}

// ⚠️ Limitación: no puedes modificar la colección durante la iteración
List<Integer> lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
for (Integer numero : lista) {
    if (numero % 2 == 0) {
        lista.remove(numero);  // ❌ ConcurrentModificationException
    }
}

// ✅ Solución: usar Iterator
Iterator<Integer> it = lista.iterator();
while (it.hasNext()) {
    Integer numero = it.next();
    if (numero % 2 == 0) {
        it.remove();  // OK
    }
}
```

##### **WHILE - Bucle con condición previa:**
```java
// Sintaxis básica
while (condición) {
    // Código a repetir
}

// Ejemplo: leer entrada hasta que sea válida
Scanner scanner = new Scanner(System.in);
int numero = 0;
while (numero <= 0) {
    System.out.print("Ingrese un número positivo: ");
    numero = scanner.nextInt();
    if (numero <= 0) {
        System.out.println("Número inválido, intente de nuevo.");
    }
}

// Bucle infinito (cuidado)
while (true) {
    // Código
    if (condicionSalida) {
        break;  // Salir del bucle
    }
}
```

##### **DO-WHILE - Bucle con condición posterior:**
```java
// Sintaxis básica
do {
    // Código a repetir (se ejecuta AL MENOS UNA VEZ)
} while (condición);

// Ejemplo: menú que se muestra al menos una vez
Scanner scanner = new Scanner(System.in);
int opcion;
do {
    System.out.println("\n=== MENÚ ===");
    System.out.println("1. Opción A");
    System.out.println("2. Opción B");
    System.out.println("3. Salir");
    System.out.print("Seleccione una opción: ");
    opcion = scanner.nextInt();
    
    switch (opcion) {
        case 1:
            System.out.println("Ejecutando opción A");
            break;
        case 2:
            System.out.println("Ejecutando opción B");
            break;
        case 3:
            System.out.println("Saliendo...");
            break;
        default:
            System.out.println("Opción inválida");
    }
} while (opcion != 3);
```

#### **CONTROL DE FLUJO**

##### **BREAK - Salir de bucles o switch:**
```java
// Break en bucles
for (int i = 0; i < 100; i++) {
    if (i == 50) {
        break;  // Sale del bucle cuando i = 50
    }
    System.out.println(i);
}

// Break con etiquetas (para bucles anidados)
exterior: for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if (i * j > 6) {
            break exterior;  // Sale del bucle exterior
        }
        System.out.println("i=" + i + ", j=" + j);
    }
}
```

##### **CONTINUE - Saltar a la siguiente iteración:**
```java
// Continue en bucles
for (int i = 0; i < 10; i++) {
    if (i % 2 == 0) {
        continue;  // Salta los números pares
    }
    System.out.println("Número impar: " + i);
}

// Continue con etiquetas
exterior: for (int i = 0; i < 5; i++) {
    for (int j = 0; j < 5; j++) {
        if (j == 2) {
            continue exterior;  // Continúa con la siguiente iteración del bucle exterior
        }
        System.out.println("i=" + i + ", j=" + j);
    }
}
```

##### **RETURN - Salir de métodos:**
```java
public boolean esPrimo(int numero) {
    if (numero <= 1) {
        return false;  // Sale inmediatamente del método
    }
    
    for (int i = 2; i <= Math.sqrt(numero); i++) {
        if (numero % i == 0) {
            return false;  // Sale inmediatamente si encuentra un divisor
        }
    }
    
    return true;  // Solo llega aquí si es primo
}
```

#### **PATRONES COMUNES Y MEJORES PRÁCTICAS**

##### **1. Validación de entrada:**
```java
public static int leerEnteroEnRango(Scanner scanner, int min, int max) {
    int numero;
    do {
        System.out.printf("Ingrese un número entre %d y %d: ", min, max);
        while (!scanner.hasNextInt()) {
            System.out.println("Error: debe ingresar un número entero.");
            scanner.next(); // Descartar entrada inválida
        }
        numero = scanner.nextInt();
        if (numero < min || numero > max) {
            System.out.printf("Error: el número debe estar entre %d y %d.\n", min, max);
        }
    } while (numero < min || numero > max);
    
    return numero;
}
```

##### **2. Procesamiento de arrays:**
```java
// Encontrar el máximo
int[] numeros = {5, 2, 8, 1, 9, 3};
int maximo = numeros[0];
for (int i = 1; i < numeros.length; i++) {
    if (numeros[i] > maximo) {
        maximo = numeros[i];
    }
}

// Contar elementos que cumplen condición
int contador = 0;
for (int numero : numeros) {
    if (numero % 2 == 0) {
        contador++;
    }
}

// Buscar un elemento
boolean encontrado = false;
int elementoBuscado = 8;
for (int numero : numeros) {
    if (numero == elementoBuscado) {
        encontrado = true;
        break;
    }
}
```

##### **3. Anidación de bucles (matrices):**
```java
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Recorrer matriz
for (int fila = 0; fila < matriz.length; fila++) {
    for (int columna = 0; columna < matriz[fila].length; columna++) {
        System.out.printf("%d ", matriz[fila][columna]);
    }
    System.out.println(); // Nueva línea después de cada fila
}

// Con for-each
for (int[] fila : matriz) {
    for (int elemento : fila) {
        System.out.printf("%d ", elemento);
    }
    System.out.println();
}
```

#### **ERRORES COMUNES Y CÓMO EVITARLOS**

##### **1. Off-by-one errors:**
```java
// ❌ ERROR común
for (int i = 0; i <= array.length; i++) {  // IndexOutOfBoundsException
    System.out.println(array[i]);
}

// ✅ CORRECTO
for (int i = 0; i < array.length; i++) {
    System.out.println(array[i]);
}
```

##### **2. Bucles infinitos:**
```java
// ❌ PELIGROSO
int i = 0;
while (i < 10) {
    System.out.println(i);
    // Falta: i++; ¡Bucle infinito!
}

// ✅ CORRECTO
int i = 0;
while (i < 10) {
    System.out.println(i);
    i++;
}
```

##### **3. Modificar colecciones durante iteración:**
```java
List<String> lista = new ArrayList<>();
lista.add("A");
lista.add("B");
lista.add("C");

// ❌ ERROR
for (String elemento : lista) {
    if (elemento.equals("B")) {
        lista.remove(elemento);  // ConcurrentModificationException
    }
}

// ✅ CORRECTO - usar Iterator
Iterator<String> it = lista.iterator();
while (it.hasNext()) {
    String elemento = it.next();
    if (elemento.equals("B")) {
        it.remove();
    }
}
```

---

### 📊 **CONCEPTO 8: Arrays**
Arrays en Java son objetos de tamaño fijo que almacenan elementos del mismo tipo y exponen la propiedad `.length` para conocer su tamaño.

Características clave:
- Tamaño fijo: una vez creado, no cambia su longitud.
- Índices base 0: el primer elemento está en la posición 0 y el último en `length - 1`.
- Pueden ser de tipos primitivos (p. ej. `int[]`) o de referencia (p. ej. `String[]`).
- Son objetos y, por tanto, se almacenan en el heap.

Declaración y creación:
```java
// Declarar
int[] a;            // variable que puede apuntar a un array de int

// Crear con tamaño
a = new int[5];     // [0,0,0,0,0]

// Crear e inicializar
int[] b = {1, 2, 3};
String[] names = new String[]{"Ana", "Luis"};
```

Acceso y modificación:
```java
int x = b[0];       // leer (1)
b[1] = 42;          // asignar
int len = b.length; // obtener tamaño
```

Recorrido:
```java
// for clásico
for (int i = 0; i < b.length; i++) {
    System.out.println(b[i]);
}

// for-each (más legible, no permite conocer el índice directamente)
for (int v : b) {
    System.out.println(v);
}
```

Arrays multidimensionales:
```java
int[][] matriz = new int[3][2];     // matriz 3x2 (todas las filas mismo tamaño)
int[][] jagged = new int[3][];      // filas con tamaños distintos
jagged[0] = new int[2];
jagged[1] = new int[4];
```

API y utilidades importantes:

- `java.util.Arrays` (métodos clave):
    - `Arrays.toString(array)` / `Arrays.deepToString(array)` — representación legible de arrays (deep para arrays anidados).
    - `Arrays.sort(array)` — ordena in-place en tiempo O(n log n).
    - `Arrays.parallelSort(array)` — ordena en paralelo aprovechando múltiples cores (útil para arrays grandes).
    - `Arrays.binarySearch(array, key)` — búsqueda binaria (requiere array previamente ordenado).
    - `Arrays.copyOf(array, newLength)` / `Arrays.copyOfRange(array, from, to)` — copiar y redimensionar de forma segura.
    - `Arrays.fill(array, value)` — rellena todo el array con un único valor (útil para inicializar/limpiar).
    - `Arrays.equals(a,b)` / `Arrays.deepEquals(a,b)` — comparación por contenido.
    - `Arrays.asList(array)` — crea una vista fija tipo `List` sobre el array; la lista resultante es de tamaño fijo y refleja cambios en el array.
    - `Arrays.setAll(array, i -> f(i))` / `Arrays.parallelSetAll(array, i -> f(i))` — inicialización mediante función (Java 8+).
    - `Arrays.mismatch(a, b)` (Java 9+) — devuelve el primer índice donde difieren o -1 si son iguales.

- `System.arraycopy(src, srcPos, dest, destPos, length)` — copia de bloques entre arrays muy eficiente (mejor rendimiento que copiar elemento a elemento en Java puro).

- Otras utilidades relacionadas:
    - `Collections` y `List` (por ejemplo, `new ArrayList<>(Arrays.asList(array))` para obtener una lista mutable).
    - `java.util.concurrent` collections para uso concurrente (p. ej. `CopyOnWriteArrayList`) si múltiples hilos modifican la estructura.

Streams y procesamiento funcional (resumen):

Un Stream en Java representa una secuencia de elementos sobre la cual podemos aplicar operaciones funcionales (map, filter, reduce, collect). Los Streams permiten escribir pipelines declarativos y pueden ser secuenciales o paralelos.

- Características clave:
    - Operaciones intermedias (map, filter, sorted) son perezosas y devuelven otro Stream.
    - Operaciones terminales (forEach, collect, reduce, sum) disparan la ejecución y producen un resultado o efecto lateral.
    - Los Streams no almacenan datos: son una vista computacional sobre una fuente (arrays, colecciones, I/O).

- Tipos de Streams:
    - `Stream<T>` para referencias.
    - `IntStream`, `LongStream`, `DoubleStream` para tipos primitivos (evitan boxing).

- Ejemplo básico:
```java
int[] nums = {1,2,3,4,5};
int sum = Arrays.stream(nums)
                                .filter(n -> n % 2 == 0)
                                .map(n -> n * 2)
                                .sum();
```

- Ejemplo con objetos y collector:
```java
String[] names = {"Ana", "Luis", "María"};
List<String> upper = Arrays.stream(names)\n+        .map(String::toUpperCase)
        .filter(s -> s.length() > 3)
        .collect(Collectors.toList());
```

- Paralelismo:
    - `Arrays.stream(array).parallel()` o `parallelStream()` en colecciones; útil para operaciones CPU-bound en arrays grandes, pero cuidado con efectos laterales y overhead de particionado.

Consideraciones de rendimiento:
- Streams pueden ser legibles y concisos; para hot paths donde la alocación y boxing son críticos, usa `IntStream`/`LongStream` o APIs de arrays (System.arraycopy, Arrays methods).

Ejemplos:
```java
int[] c = Arrays.copyOf(b, 5);               // copia y extiende con ceros
System.arraycopy(b, 0, c, 0, Math.min(b.length, c.length));
Arrays.sort(c);                              // ordenar
int idx = Arrays.binarySearch(c, 42);        // buscar (array debe estar ordenado)
System.out.println(Arrays.toString(c));     // representación legible

// Rellenar con un valor
Arrays.fill(c, 0);

// Comparar arrays
int[] x = {1,2,3};
int[] y = {1,2,3};
System.out.println(Arrays.equals(x,y)); // true

// Convertir a stream y sumar
int sum = Arrays.stream(c).sum();
```


Errores comunes:
- Off-by-one: usar `i < array.length` y no `<=`.
- IndexOutOfBounds: acceder a índices negativos o >= length.
- Intentar cambiar el tamaño del array (usar `ArrayList` o crear uno nuevo con `Arrays.copyOf`).
- Modificar elementos mientras iteras con for-each (usa índices o `List` cuando debas eliminar).

#### Vaciar o reutilizar un array ya inicializado

Una vez que un array ha sido creado e inicializado con valores, no existe un método "vaciar" que cambie su longitud; las estrategias dependen del objetivo:

1) Reutilizar el mismo array y sobrescribir valores
```java
Arrays.fill(arr, 0);          // para tipos primitivos: rellena con el valor por defecto/indicado
Arrays.fill(objArr, null);    // para arrays de referencia: establece todas las referencias a null
```
Ventaja: mantiene la misma referencia (útil si otros objetos mantienen punteros al array).

2) Crear un nuevo array y reasignar la referencia
```java
arr = new int[originalLength];   // crea un array vacío (con ceros)
```
Ventaja: sencillo y claro; cualquier referencia antigua seguirá apuntando al array previo.

3) Mantener un contador lógico de elementos (simular una 'longitud' variable)
```java
int size = 0;          // número de elementos válidos en el array
arr[size++] = value;   // añadir
// 'vaciar' lógicamente: size = 0;
```
Ventaja: evita reallocs constantes; patrón útil en estructuras de alto rendimiento.

4) Usar `Arrays.copyOf` para truncar o expandir
```java
arr = Arrays.copyOf(arr, newLength);
```
Esto crea un nuevo array con la longitud indicada y copia los elementos hasta el nuevo tamaño.

Consideraciones sobre referencias y concurrencia:
- Si otras partes del código apuntan al mismo array, reasignar la variable local no afecta a esas referencias.
- Si necesitas invalidar contenido por seguridad (por ejemplo, limpiar datos sensibles), usa `Arrays.fill(objArr, null)` o sobreescribe con valores neutros.
- Para entornos concurrentes, sincroniza cuando múltiples hilos lean/escriban el array o usa estructuras concurrentes (p. ej. `CopyOnWriteArrayList`).

Rendimiento y recomendaciones:
- Para colecciones dinámicas, prefiere `ArrayList<T>` en lugar de arrays si necesitas tamaño variable.
- Para operaciones intensivas de lectura/escritura indexada, los arrays son muy eficientes (menos overhead que `ArrayList`).
- Evita crear arrays muy grandes sin control de memoria; usa streams o procesamiento por bloques cuando sea necesario.

Buenas prácticas:
- Usa `Arrays.asList()` cuando necesites una vista fija basada en un array (no soporta operaciones de tamaño).
- Prefiere `Arrays.copyOf()` o `System.arraycopy()` para copiar en vez de bucles manuales por claridad y rendimiento.
- Documenta si un array puede contener `null` para tipos de referencia.

---

### 🎯 **CONCEPTO 9: Tipos de datos (primitivos y wrappers)**
Los tipos de datos en Java se dividen en primitivos y tipos de referencia (objetos). Los primitivos son más eficientes en memoria y rendimiento; las clases wrapper permiten tratarlos como objetos (necesario en colecciones y APIs que requieren objetos).

Tabla resumen de primitivos:

| Tipo | Tamaño | Rango | Valor por defecto | Wrapper |
|------|--------|-------|-------------------|---------|
| byte | 8 bits | -128 a 127 | 0 | `Byte` |
| short | 16 bits | -32,768 a 32,767 | 0 | `Short` |
| int | 32 bits | -2,147,483,648 a 2,147,483,647 | 0 | `Integer` |
| long | 64 bits | -9.22e18 a 9.22e18 | 0L | `Long` |
| float | 32 bits | ±3.4e38 (approx) | 0.0f | `Float` |
| double | 64 bits | ±1.7e308 (approx) | 0.0d | `Double` |
| boolean | 1 bit (práctico) | true/false | false | `Boolean` |
| char | 16 bits | ' ' (0..65535) | '\u0000' | `Character` |

Wrappers y autoboxing/unboxing:
- Desde Java 5 existe autoboxing: el compilador convierte automáticamente entre primitivos y wrappers cuando es necesario.
    ```java
    Integer i = 42;     // autoboxing: int -> Integer
    int j = i;          // unboxing: Integer -> int
    ```

Peligros y puntos a considerar:
- Performance: autoboxing crea objetos; en bucles intensivos puede afectar rendimiento y memoria.
- `==` con wrappers compara referencias; para comparar valores usa `equals()` o unboxing.
    ```java
    Integer a = 127, b = 127;  // puede estar cacheado
    Integer c = 128, d = 128;  // no cacheado
    System.out.println(a == b); // true (cache)
    System.out.println(c == d); // false
    System.out.println(c.equals(d)); // true
    ```
- NullPointerException: al hacer unboxing de un `null` (Integer i = null; int x = i;) se lanza NPE.

Cuándo usar cada uno:
- Usa primitivos (`int`, `double`, etc.) para variables locales, contadores y cálculos numéricos intensivos.
- Usa wrappers cuando necesites almacenar en colecciones (`List<Integer>`) o cuando una API requiera objetos.
- Para flags booleanas en objetos, wrapper `Boolean` permite `null` como estado "no especificado".

Conversión entre tipos:
- Conversión implícita: se permite entre tipos compatibles (p. ej. `int` -> `long`).
- Conversión explícita (casting) necesaria para pérdidas de precisión: `(int) 3.14`.

Operaciones aritméticas y precauciones:
- Cuidado con overflow en enteros; usa `long` cuando esperes valores grandes.
- Para operaciones de precisión decimal usa `BigDecimal` en lugar de `double` cuando la exactitud es crítica (finanzas).

Ejemplos prácticos:
```java
int sum = 0;
for (int i = 0; i < 1_000_000; i++) sum += i; // eficiente

List<Integer> list = new ArrayList<>();
list.add(1); // autoboxing: int -> Integer
```

---

### 📝 **CONCEPTO 10: Reglas para variables, clases y palabras reservadas**

Variables
- Formato: camelCase (lowerCamelCase)
    - Ejemplos: `nombreUsuario`, `contadorTotal`, `estaActivo`
    - Variables booleanas: prefijos `es/esta/tiene` (p.ej. `estaVacio`, `tieneSiguiente`).
    - Constantes: `static final` en UPPER_CASE con guiones bajos, p.ej. `MAXIMO_INTENTOS`.
    - Reglas prácticas:
        - No uses abreviaturas no obvias.
        - Para contadores temporales en bucles está bien `i`, `j`, `k`.
        - Evita nombres que oculten el propósito: `temporal` o `tmp` solo cuando es claramente temporal.

Clases
- Formato: PascalCase (UpperCamelCase)
    - Ejemplos: `Cliente`, `ServicioPedidos`, `ManejadorSolicitudHttp`.
    - Deben ser sustantivos o sustantivo+complemento (no verbos): `GeneradorReporte` (bien), no `generarReporte`.
    - Evita colisiones con clases estándar (`String`, `List`, etc.).

Palabras reservadas (no usables como identificadores)
- Java reserva palabras clave que no pueden emplearse como nombres de variables, clases o métodos. Entre ellas:

```
abstract  assert      boolean   break    byte
case      catch       char      class    const
continue  default     do        double   else
enum      extends     final     finally  float
for       goto        if        implements import
instanceof int        interface long     native
new       package     private   protected public
return    short       static    strictfp synchronized
super     switch      this      throw    throws
transient try         void      volatile while
```

- Además, literales `true`, `false` y `null` no son válidos como identificadores.

Regla práctica: elige nombres descriptivos y consistentes; si dudas, prefiere claridad. Mantén una guía de estilo del proyecto y aplica herramientas automáticas (Checkstyle) si quieres forzar reglas en CI.

---

### 💬 **CONCEPTO 11: Tipos de comentarios**

Java ofrece tres tipos principales de comentarios, cada uno con propósitos específicos y mejores prácticas asociadas. Los comentarios son fundamentales para la documentación del código y la comunicación entre desarrolladores.

#### **1. Comentarios de línea simple (`//`)**

Los comentarios de línea simple se extienden desde `//` hasta el final de la línea y son ideales para explicaciones breves.

##### **Usos principales:**
```java
public class EjemploComentarios {
    // Variable para almacenar el contador principal
    private int contador = 0;
    
    public void metodoEjemplo() {
        contador++; // Incrementar contador después de cada operación
        
        // TODO: Implementar validación de rango
        if (contador > 100) {
            reset(); // Reiniciar si supera el límite
        }
        
        // FIXME: Este algoritmo es O(n²), optimizar
        for (int i = 0; i < contador; i++) {
            // Procesamiento interno
            procesarElemento(i);
        }
    }
}
```

##### **Etiquetas especiales comunes:**
```java
// TODO: Funcionalidad pendiente de implementar
// FIXME: Error conocido que necesita corrección
// HACK: Solución temporal, revisar en futuras versiones
// NOTE: Información importante para mantener
// WARNING: Código crítico, modificar con cuidado
// OPTIMIZE: Oportunidad de mejora de rendimiento
// REVIEW: Código que necesita revisión por pares
```

#### **2. Comentarios multilínea (`/* */`)**

Los comentarios multilínea se extienden desde `/*` hasta `*/` y pueden abarcar múltiples líneas. Son útiles para explicaciones extensas o para comentar bloques de código temporalmente.

##### **Formato recomendado:**
```java
/*
 * Este método implementa el algoritmo de ordenamiento QuickSort
 * optimizado para arrays de enteros.
 * 
 * Complejidad temporal: O(n log n) promedio, O(n²) peor caso
 * Complejidad espacial: O(log n) debido a la recursión
 * 
 * @param arr Array a ordenar
 * @param low Índice inferior del rango
 * @param high Índice superior del rango
 */
public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
```

##### **Comentar código temporalmente:**
```java
public void procesarDatos() {
    // Versión nueva (en desarrollo)
    procesamientoOptimizado();
    
    /*
    // Versión anterior (comentada temporalmente)
    for (int i = 0; i < datos.length; i++) {
        if (datos[i] != null) {
            procesarItem(datos[i]);
        }
    }
    */
}
```

##### **Comentarios de bloque para licencias/headers:**
```java
/*
 * Copyright (c) 2025 Mi Empresa
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package com.miempresa.proyecto;
```

#### **3. Comentarios JavaDoc (`/** */`)**

Los comentarios JavaDoc son una forma especializada de comentarios multilínea que generan documentación HTML automáticamente. Siguen el formato `/** */` y utilizan etiquetas especiales.

##### **Estructura básica:**
```java
/**
 * Breve descripción del método, clase o campo.
 * 
 * Descripción más detallada que puede incluir múltiples párrafos,
 * ejemplos de uso, consideraciones especiales, etc.
 * 
 * @param nombreParametro descripción del parámetro
 * @return descripción de lo que retorna el método
 * @throws TipoExcepcion cuándo y por qué se lanza la excepción
 * @since versión en que se agregó
 * @author nombre del autor
 * @deprecated si el método está obsoleto
 */
```

##### **Ejemplo completo de clase documentada:**
```java
/**
 * Representa una cuenta bancaria básica con operaciones de depósito,
 * retiro y consulta de saldo.
 * 
 * <p>Esta clase proporciona las funcionalidades esenciales para
 * manejar una cuenta bancaria, incluyendo validaciones de seguridad
 * y registro de transacciones.</p>
 * 
 * <p><strong>Ejemplo de uso:</strong></p>
 * <pre>
 * CuentaBancaria cuenta = new CuentaBancaria("123456789", 1000.0);
 * cuenta.depositar(500.0);
 * cuenta.retirar(200.0);
 * System.out.println("Saldo: " + cuenta.getSaldo()); // Saldo: 1300.0
 * </pre>
 * 
 * @author Juan Pérez
 * @version 2.1
 * @since 1.0
 */
public class CuentaBancaria {
    /**
     * Número único que identifica la cuenta bancaria.
     * 
     * @since 1.0
     */
    private final String numeroCuenta;
    
    /**
     * Saldo actual de la cuenta en la moneda base.
     * 
     * @since 1.0
     */
    private double saldo;
    
    /**
     * Crea una nueva cuenta bancaria con el número y saldo inicial especificados.
     * 
     * @param numeroCuenta el número único de la cuenta (no puede ser null o vacío)
     * @param saldoInicial el saldo inicial de la cuenta (debe ser >= 0)
     * @throws IllegalArgumentException si el número de cuenta es inválido
     * @throws IllegalArgumentException si el saldo inicial es negativo
     * @since 1.0
     */
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    
    /**
     * Deposita una cantidad específica en la cuenta.
     * 
     * <p>El monto a depositar debe ser positivo. Esta operación
     * incrementa el saldo actual de la cuenta.</p>
     * 
     * @param monto la cantidad a depositar (debe ser > 0)
     * @return el nuevo saldo después del depósito
     * @throws IllegalArgumentException si el monto es menor o igual a cero
     * @since 1.0
     */
    public double depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a depositar debe ser positivo");
        }
        
        saldo += monto;
        return saldo;
    }
    
    /**
     * Retira una cantidad específica de la cuenta si hay fondos suficientes.
     * 
     * @param monto la cantidad a retirar (debe ser > 0)
     * @return el nuevo saldo después del retiro
     * @throws IllegalArgumentException si el monto es menor o igual a cero
     * @throws IllegalStateException si no hay fondos suficientes
     * @since 1.0
     */
    public double retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto a retirar debe ser positivo");
        }
        if (monto > saldo) {
            throw new IllegalStateException("Fondos insuficientes");
        }
        
        saldo -= monto;
        return saldo;
    }
    
    /**
     * Obtiene el saldo actual de la cuenta.
     * 
     * @return el saldo actual de la cuenta
     * @since 1.0
     */
    public double getSaldo() {
        return saldo;
    }
    
    /**
     * Obtiene el número de cuenta.
     * 
     * @return el número único de la cuenta
     * @since 1.0
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
}
```

#### **Etiquetas JavaDoc más utilizadas**

##### **Para métodos:**
```java
/**
 * @param nombreParam descripción del parámetro
 * @return descripción de lo que retorna
 * @throws ExceptionType cuándo se lanza esta excepción
 * @see ClaseRelacionada#metodoRelacionado()
 * @since versión en que se agregó
 * @deprecated desde versión X.X, usar {@link #nuevoMetodo()} en su lugar
 */
```

##### **Para clases:**
```java
/**
 * @author Nombre del Autor
 * @version 1.2.3
 * @since 1.0
 * @see ClaseRelacionada
 * @deprecated desde versión 2.0, usar {@link NuevaClase} en su lugar
 */
```

##### **Para campos:**
```java
/**
 * @since versión en que se agregó
 * @deprecated si está obsoleto
 */
```

#### **Etiquetas HTML permitidas en JavaDoc**

JavaDoc permite ciertas etiquetas HTML para formatear la documentación:

```java
/**
 * <p>Este es un párrafo separado.</p>
 * 
 * <ul>
 * <li>Primer elemento de lista</li>
 * <li>Segundo elemento de lista</li>
 * </ul>
 * 
 * <ol>
 * <li>Primer elemento numerado</li>
 * <li>Segundo elemento numerado</li>
 * </ol>
 * 
 * <pre>
 * // Ejemplo de código formateado
 * int resultado = calcular(10, 20);
 * System.out.println(resultado);
 * </pre>
 * 
 * <code>variable</code> - para resaltar código inline
 * <strong>texto importante</strong> - para texto en negritas
 * <em>texto enfatizado</em> - para texto en cursiva
 * 
 * <table>
 * <tr><th>Parámetro</th><th>Tipo</th><th>Descripción</th></tr>
 * <tr><td>x</td><td>int</td><td>Primer operando</td></tr>
 * <tr><td>y</td><td>int</td><td>Segundo operando</td></tr>
 * </table>
 */
```

#### **Referencias cruzadas en JavaDoc**

```java
/**
 * Este método utiliza el algoritmo implementado en {@link #ordenarArray(int[])}.
 * 
 * Para más información sobre ordenamiento, consultar:
 * {@link java.util.Arrays#sort(int[])}
 * 
 * @see #metodoRelacionado()
 * @see OtraClase#otroMetodo()
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/">Java 8 API</a>
 */
```

#### **Generación de documentación**

##### **Comando básico:**
```bash
# Generar documentación para todos los archivos Java
javadoc *.java

# Generar en directorio específico
javadoc -d docs *.java

# Incluir información de autor y versión
javadoc -d docs -author -version *.java

# Para paquetes específicos
javadoc -d docs -sourcepath src com.miempresa.proyecto
```

##### **Opciones avanzadas:**
```bash
# Documentación completa con enlaces a JDK
javadoc -d docs \
        -author \
        -version \
        -link https://docs.oracle.com/javase/8/docs/api/ \
        -windowtitle "Mi Proyecto API" \
        -doctitle "Mi Proyecto Documentation" \
        -header "<b>Mi Proyecto v1.0</b>" \
        -footer "<i>Copyright 2025 Mi Empresa</i>" \
        *.java
```

#### **Mejores prácticas para comentarios**

##### **✅ Qué hacer:**
```java
// ✅ Explica el "por qué", no el "qué"
// Usar caché para mejorar rendimiento en consultas frecuentes
Map<String, Object> cache = new HashMap<>();

// ✅ Documenta decisiones de diseño importantes
/**
 * Implementa lazy loading para optimizar el uso de memoria.
 * Los datos se cargan solo cuando se acceden por primera vez.
 */
private List<String> datosLazy;

// ✅ Explica algoritmos complejos
/**
 * Implementa el algoritmo de Dijkstra para encontrar el camino más corto.
 * Complejidad: O((V + E) log V) donde V = vértices, E = aristas
 */
public List<Node> encontrarCaminoMasCorto(Node origen, Node destino) {
    // Implementación...
}

// ✅ Documenta precondiciones y postcondiciones
/**
 * @param array debe estar ordenado ascendentemente
 * @return índice del elemento o -1 si no se encuentra
 * @throws IllegalArgumentException si el array es null
 */
public int busquedaBinaria(int[] array, int elemento) {
    // Implementación...
}
```

##### **❌ Qué evitar:**
```java
// ❌ Comentarios obvios (ruido)
int contador = 0; // Inicializar contador en 0

// ❌ Comentarios desactualizados
/**
 * Retorna el nombre del usuario
 * @return el nombre como String
 */
public int getUserId() { // Método retorna int, no String!
    return this.userId;
}

// ❌ Comentarios que duplican el código
// Incrementar i en 1
i++;

// ❌ Comentarios largos para código simple
/**
 * Este método suma dos números enteros utilizando
 * el operador de suma aritmética básica implementado
 * en el procesador de la máquina virtual de Java
 * para realizar la operación matemática fundamental...
 */
public int sumar(int a, int b) {
    return a + b; // Un simple return bastaría sin tanto comentario
}
```

#### **Comentarios para diferentes audiencias**

##### **Para desarrolladores del equipo:**
```java
// TEAM: Este workaround es temporal hasta que el API v2 esté disponible
// PERFORMANCE: Este método se llama frecuentemente, optimizar si es posible
// SECURITY: Validación adicional requerida por auditoría de seguridad
```

##### **Para mantenimiento futuro:**
```java
/**
 * IMPORTANTE: Este método modifica el estado global de la aplicación.
 * Cualquier cambio aquí debe coordinarse con el equipo de arquitectura.
 * 
 * Última modificación: 2025-08-26 por Juan Pérez
 * Motivo: Optimización de memoria según ticket #2347
 */
```

##### **Para usuarios de la API:**
```java
/**
 * <h3>Uso típico:</h3>
 * <pre>
 * // Crear instancia
 * ProcessorService processor = new ProcessorService();
 * 
 * // Configurar opciones
 * processor.setOption("timeout", 5000);
 * processor.setOption("retries", 3);
 * 
 * // Procesar datos
 * Result result = processor.process(inputData);
 * </pre>
 * 
 * <h3>Consideraciones importantes:</h3>
 * <ul>
 * <li>Este método es thread-safe</li>
 * <li>El timeout predeterminado es 30 segundos</li>
 * <li>Se recomienda reutilizar instancias para mejor rendimiento</li>
 * </ul>
 */
```

Los comentarios efectivos mejoran significativamente la mantenibilidad del código y facilitan la colaboración en equipos de desarrollo. El uso apropiado de cada tipo de comentario según el contexto es clave para una documentación de calidad.

---

### ⚡ **CONCEPTO 12: Paso de parámetros**

    Java pasa por valor; las referencias a objetos se copian (no se pasa un puntero manipulable externamente).

    ---

    ## Próximos pasos

    1) `1.2 Variables y Tipos de Datos`
    2) `2.1 Operadores`
    3) `2.2 Estructuras de Control (avanzado)`

    ---

    Nota: la copia completa anterior se guardó en `README_BACKUP.md` antes de la limpieza.

| Lenguaje | Punto de entrada |
|----------|------------------|
| **Java** | `public static void main(String[] args)` |
| **C/C++** | `int main()` o `int main(int argc, char* argv[])` |
| **Python** | `if __name__ == "__main__":` |
| **JavaScript** | No hay punto de entrada fijo |
| **C#** | `static void Main(string[] args)` |

---

### 🚨 **CONCEPTO 13: Peculiaridades y diferencias**

#### 1. No hay punteros explícitos:
```java
// ❌ NO existe en Java:
int* ptr = &variable;
ptr++;

// ✅ Solo referencias:
String ref = "Hola";
// No hay aritmética de referencias
```

#### 2. Garbage Collection automático:
```java
// ❌ NO necesario en Java:
Object obj = malloc(sizeof(Object));
free(obj);

// ✅ Automático:
Object obj = new Object();  // Se libera automáticamente
```

#### 3. Array.length es atributo:
```java
int[] array = {1, 2, 3};

// ✅ CORRECTO:
int size = array.length;    // Atributo (sin paréntesis)

// ❌ INCORRECTO:
int size = array.length();  // Error: no es método
```

#### 4. Boolean es tipo específico:
```java
// ❌ NO funciona (como en C):
int flag = 1;
if (flag) { ... }  // Error: incompatible types

// ✅ CORRECTO:
boolean flag = true;
if (flag) { ... }  // OK
```

---

## 🎯 RESUMEN DE CONCEPTOS CLAVE

### ✅ **Lo que DEBES recordar:**

1. **Método main específico**: `public static void main(String[] args)`
2. **Todo en clases**: No hay funciones globales
3. **Case sensitive**: Java distingue mayúsculas/minúsculas
4. **Fuertemente tipado**: Declaración explícita de tipos
5. **Bytecode portable**: "Write Once, Run Anywhere"
6. **Strings inmutables**: Cada "modificación" crea nuevo objeto
7. **Autoboxing automático**: Conversión primitivo ↔ wrapper class
8. **Arrays son objetos**: Con atributo `.length`
9. **Pool de strings**: Optimización automática de memoria
10. **Paso por valor**: Siempre se pasan copias

### ❌ **Errores comunes a evitar:**

1. Usar `==` para comparar Strings → Usar `.equals()`
2. Concatenar strings en loops → Usar `StringBuilder`
3. Confundir `array.length` con `array.length()`
4. Olvidar `break` en `switch` statements
5. Intentar usar int como boolean en condiciones
6. No validar arrays/referencias antes de usar (NullPointerException)

---

## 📋 **CHECKLIST DE DOMINIO**

### Nivel Básico ⭐
- [ ] Puedo escribir un programa Java básico sin ayuda
- [ ] Entiendo por qué todo debe estar en una clase
- [ ] Sé compilar y ejecutar desde línea de comandos
- [ ] Comprendo la diferencia entre primitivos y objetos

### Nivel Intermedio ⭐⭐
- [ ] Entiendo la diferencia entre Stack y Heap
- [ ] Sé cuándo usar StringBuilder vs concatenación simple
- [ ] Comprendo el autoboxing/unboxing
- [ ] Puedo explicar por qué los Strings son inmutables

### Nivel Avanzado ⭐⭐⭐
- [ ] Entiendo el pool de strings y sus implicaciones
- [ ] Conozco las trampas del Integer cache
- [ ] Puedo explicar cómo funciona el paso de parámetros
- [ ] Domino las diferencias con otros lenguajes de programación

---

## 🔗 **RECURSOS ADICIONALES**

### Documentación Oficial:
- [Java Language Specification](https://docs.oracle.com/javase/specs/jls/se8/html/)
- [Java SE 8 API Documentation](https://docs.oracle.com/javase/8/docs/api/)

### Herramientas:
- [Oracle JDK](https://www.oracle.com/java/technologies/downloads/)
- [OpenJDK](https://openjdk.java.net/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Eclipse IDE](https://www.eclipse.org/)

---

## 🚀 **PROYECTO INTEGRADOR: SISTEMA DE GESTIÓN DE BIBLIOTECA**

### **Objetivo del proyecto:**

Crear un sistema completo que integre todos los conceptos fundamentales aprendidos: entrada/salida, variables estáticas vs instancia, case sensitivity, strings inmutables, estructuras de control, arrays y tipos de datos.

### **Funcionalidades a implementar:**

1. **Gestión de libros** (variables estáticas vs instancia)
2. **Sistema de usuarios** (arrays y strings)
3. **Interfaz de consola** (System.out con formato)
4. **Validaciones** (case sensitivity y tipos de datos)
5. **Reportes estadísticos** (estructuras de control)

### **Implementación completa:**

```java
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Clase principal del sistema
public class SistemaBiblioteca {
    // Variables estáticas - información global del sistema
    private static final String NOMBRE_BIBLIOTECA = "Biblioteca Central Java";
    private static final String VERSION_SISTEMA = "v2.0";
    private static final int CAPACIDAD_MAXIMA = 1000;
    private static int totalLibrosRegistrados = 0;
    private static int totalUsuariosRegistrados = 0;
    
    // Arrays para almacenar datos
    private static Libro[] inventarioLibros = new Libro[CAPACIDAD_MAXIMA];
    private static Usuario[] listaUsuarios = new Usuario[CAPACIDAD_MAXIMA];
    
    // Scanner global para entrada de datos
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        mostrarBienvenida();
        inicializarDatosDemo();
        
        boolean sistemaActivo = true;
        while (sistemaActivo) {
            mostrarMenuPrincipal();
            int opcion = leerOpcionMenu();
            
            switch (opcion) {
                case 1:
                    gestionarLibros();
                    break;
                case 2:
                    gestionarUsuarios();
                    break;
                case 3:
                    realizarPrestamo();
                    break;
                case 4:
                    generarReportes();
                    break;
                case 5:
                    mostrarEstadisticasGlobales();
                    break;
                case 0:
                    sistemaActivo = false;
                    mostrarDespedida();
                    break;
                default:
                    System.err.println("❌ Opción inválida. Intente nuevamente.");
            }
            
            if (sistemaActivo) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
    
    // Método estático para mostrar bienvenida
    private static void mostrarBienvenida() {
        System.out.println("╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                              ║");
        System.out.printf("║  %s%-38s%s  ║%n", "🏛️  ", NOMBRE_BIBLIOTECA, " 📚");
        System.out.printf("║  %-58s  ║%n", "Sistema de Gestión Integral " + VERSION_SISTEMA);
        System.out.println("║                                                              ║");
        System.out.println("║  Desarrollado como proyecto integrador de Java 8            ║");
        System.out.println("║  Integrando conceptos fundamentales del lenguaje            ║");
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        System.out.printf("%nFecha del sistema: %s%n", 
                         LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println();
    }
    
    private static void mostrarMenuPrincipal() {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("               MENÚ PRINCIPAL");
        System.out.println("═".repeat(50));
        System.out.println("1. 📚 Gestión de Libros");
        System.out.println("2. 👥 Gestión de Usuarios");
        System.out.println("3. 🔄 Realizar Préstamo");
        System.out.println("4. 📊 Generar Reportes");
        System.out.println("5. 📈 Estadísticas Globales");
        System.out.println("0. 🚪 Salir del Sistema");
        System.out.println("═".repeat(50));
        System.out.print("Seleccione una opción: ");
    }
    
    private static int leerOpcionMenu() {
        try {
            String entrada = scanner.nextLine().trim();
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            return -1; // Opción inválida
        }
    }
    
    private static void gestionarLibros() {
        System.out.println("\n🔹 GESTIÓN DE LIBROS 🔹");
        System.out.println("1. Agregar nuevo libro");
        System.out.println("2. Buscar libro");
        System.out.println("3. Listar todos los libros");
        System.out.print("Opción: ");
        
        int subOpcion = leerOpcionMenu();
        
        switch (subOpcion) {
            case 1:
                agregarNuevoLibro();
                break;
            case 2:
                buscarLibro();
                break;
            case 3:
                listarLibros();
                break;
            default:
                System.out.println("Opción inválida en gestión de libros");
        }
    }
    
    private static void agregarNuevoLibro() {
        if (totalLibrosRegistrados >= CAPACIDAD_MAXIMA) {
            System.err.println("❌ Capacidad máxima alcanzada. No se pueden agregar más libros.");
            return;
        }
        
        System.out.println("\n--- AGREGAR NUEVO LIBRO ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine().trim();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine().trim();
        
        System.out.print("ISBN (13 dígitos): ");
        String isbn = scanner.nextLine().trim();
        
        System.out.print("Año de publicación: ");
        int anioPublicacion = 0;
        try {
            anioPublicacion = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.err.println("❌ Año inválido. Libro no agregado.");
            return;
        }
        
        // Validaciones usando conceptos de case sensitivity y strings
        if (titulo.isEmpty() || autor.isEmpty()) {
            System.err.println("❌ Título y autor no pueden estar vacíos.");
            return;
        }
        
        if (!validarISBN(isbn)) {
            System.err.println("❌ ISBN inválido. Debe tener 13 dígitos numéricos.");
            return;
        }
        
        // Crear nuevo libro
        Libro nuevoLibro = new Libro(titulo, autor, isbn, anioPublicacion);
        inventarioLibros[totalLibrosRegistrados] = nuevoLibro;
        totalLibrosRegistrados++;
        
        System.out.printf("✅ Libro agregado exitosamente. ID: %d%n", nuevoLibro.getId());
        System.out.printf("Total de libros en sistema: %d%n", totalLibrosRegistrados);
    }
    
    private static boolean validarISBN(String isbn) {
        // Implementación de validación usando conceptos de strings y case sensitivity
        if (isbn == null || isbn.length() != 13) {
            return false;
        }
        
        // Verificar que solo contenga dígitos
        for (int i = 0; i < isbn.length(); i++) {
            char c = isbn.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
    
    private static void buscarLibro() {
        System.out.println("\n--- BUSCAR LIBRO ---");
        System.out.print("Ingrese término de búsqueda (título o autor): ");
        String termino = scanner.nextLine().trim().toLowerCase();
        
        boolean encontrado = false;
        System.out.printf("%n%-5s | %-30s | %-25s | %-13s | %-6s%n", 
                         "ID", "TÍTULO", "AUTOR", "ISBN", "AÑO");
        System.out.println("─".repeat(85));
        
        for (int i = 0; i < totalLibrosRegistrados; i++) {
            Libro libro = inventarioLibros[i];
            // Demostración de case sensitivity en búsquedas
            if (libro.getTitulo().toLowerCase().contains(termino) || 
                libro.getAutor().toLowerCase().contains(termino)) {
                
                System.out.printf("%-5d | %-30s | %-25s | %-13s | %-6d%n",
                                libro.getId(),
                                libro.getTitulo(),
                                libro.getAutor(),
                                libro.getIsbn(),
                                libro.getAnioPublicacion());
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("❌ No se encontraron libros con ese término de búsqueda.");
        }
    }
    
    private static void listarLibros() {
        if (totalLibrosRegistrados == 0) {
            System.out.println("📖 No hay libros registrados en el sistema.");
            return;
        }
        
        System.out.printf("%n=== CATÁLOGO COMPLETO (%d libros) ===%n", totalLibrosRegistrados);
        System.out.printf("%-5s | %-35s | %-25s | %-6s%n", "ID", "TÍTULO", "AUTOR", "AÑO");
        System.out.println("─".repeat(80));
        
        for (int i = 0; i < totalLibrosRegistrados; i++) {
            Libro libro = inventarioLibros[i];
            System.out.printf("%-5d | %-35s | %-25s | %-6d%n",
                            libro.getId(),
                            libro.getTitulo(),
                            libro.getAutor(),
                            libro.getAnioPublicacion());
        }
    }
    
    private static void gestionarUsuarios() {
        System.out.println("\n👤 GESTIÓN DE USUARIOS");
        System.out.printf("Usuarios registrados: %d%n", totalUsuariosRegistrados);
        // Implementación simplificada
        System.out.println("Funcionalidad en desarrollo...");
    }
    
    private static void realizarPrestamo() {
        System.out.println("\n📋 REALIZAR PRÉSTAMO");
        // Implementación simplificada
        System.out.println("Funcionalidad en desarrollo...");
    }
    
    private static void generarReportes() {
        System.out.println("\n📊 GENERAR REPORTES");
        
        // Reporte por década usando estructuras de control
        System.out.println("\n--- LIBROS POR DÉCADA ---");
        
        // Contadores por década
        int[] librosPorDecada = new int[10]; // 1950-2029
        String[] etiquetasDecadas = {
            "1950-1959", "1960-1969", "1970-1979", "1980-1989", "1990-1999",
            "2000-2009", "2010-2019", "2020-2029", "Otros", "Sin fecha"
        };
        
        for (int i = 0; i < totalLibrosRegistrados; i++) {
            int anio = inventarioLibros[i].getAnioPublicacion();
            
            if (anio >= 1950 && anio <= 2029) {
                int indice = (anio - 1950) / 10;
                if (indice < 8) {
                    librosPorDecada[indice]++;
                } else {
                    librosPorDecada[8]++; // Otros
                }
            } else {
                librosPorDecada[9]++; // Sin fecha válida
            }
        }
        
        for (int i = 0; i < etiquetasDecadas.length; i++) {
            if (librosPorDecada[i] > 0) {
                System.out.printf("%-12s: %3d libro(s) %s%n", 
                                etiquetasDecadas[i], 
                                librosPorDecada[i],
                                "■".repeat(librosPorDecada[i]));
            }
        }
    }
    
    // Método estático para mostrar estadísticas globales
    private static void mostrarEstadisticasGlobales() {
        System.out.println("\n📈 ESTADÍSTICAS GLOBALES DEL SISTEMA");
        System.out.println("═".repeat(60));
        System.out.printf("🏛️  Biblioteca:           %s%n", NOMBRE_BIBLIOTECA);
        System.out.printf("💾  Versión del sistema:  %s%n", VERSION_SISTEMA);
        System.out.printf("📚  Total libros:         %d / %d%n", totalLibrosRegistrados, CAPACIDAD_MAXIMA);
        System.out.printf("👥  Total usuarios:       %d / %d%n", totalUsuariosRegistrados, CAPACIDAD_MAXIMA);
        System.out.printf("📊  Ocupación:            %.1f%%%n", 
                         ((double) totalLibrosRegistrados / CAPACIDAD_MAXIMA) * 100);
        System.out.printf("🗓️  Fecha consulta:       %s%n", 
                         LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("═".repeat(60));
        
        if (totalLibrosRegistrados > 0) {
            System.out.println("\n🏆 TOP DÉCADAS CON MÁS LIBROS:");
            generarReportes();
        }
    }
    
    private static void inicializarDatosDemo() {
        // Agregar algunos libros de demostración
        inventarioLibros[0] = new Libro("Effective Java", "Joshua Bloch", "9780134685991", 2017);
        inventarioLibros[1] = new Libro("Clean Code", "Robert Martin", "9780132350884", 2008);
        inventarioLibros[2] = new Libro("Java: The Complete Reference", "Herbert Schildt", "9781260440235", 2020);
        inventarioLibros[3] = new Libro("Spring in Action", "Craig Walls", "9781617294945", 2018);
        inventarioLibros[4] = new Libro("Head First Java", "Kathy Sierra", "9780596009205", 2005);
        
        totalLibrosRegistrados = 5;
        
        System.out.printf("✅ Sistema inicializado con %d libros de demostración.%n", 
                         totalLibrosRegistrados);
    }
    
    private static void mostrarDespedida() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                              ║");
        System.out.println("║                    ¡Gracias por usar!                       ║");
        System.out.printf("║  %s%-54s  ║%n", "", NOMBRE_BIBLIOTECA);
        System.out.println("║                                                              ║");
        System.out.println("║  Sistema desarrollado como proyecto integrador              ║");
        System.out.println("║  Aplicando conceptos fundamentales de Java 8                ║");
        System.out.println("║                                                              ║");
        System.out.printf("║  📊 Estadísticas de la sesión:                              ║%n");
        System.out.printf("║     • Libros registrados: %-8d                       ║%n", totalLibrosRegistrados);
        System.out.printf("║     • Usuarios registrados: %-6d                       ║%n", totalUsuariosRegistrados);
        System.out.println("║                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        System.out.printf("%n🕐 Sesión finalizada: %s%n", 
                         java.time.LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }
}

// Clase para representar un libro (demostración de variables de instancia)
class Libro {
    // Variable estática - contador de libros creados
    private static int contadorLibros = 0;
    
    // Variables de instancia
    private int id;
    private String titulo;
    private String autor;
    private String isbn;
    private int anioPublicacion;
    private boolean prestado;
    
    // Constructor
    public Libro(String titulo, String autor, String isbn, int anioPublicacion) {
        contadorLibros++;
        this.id = contadorLibros;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.prestado = false;
    }
    
    // Getters y setters (demostración de case sensitivity)
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public boolean isPrestado() { return prestado; }
    
    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
    
    // Método para mostrar información completa
    public void mostrarInformacion() {
        System.out.printf("📖 Libro ID: %d%n", id);
        System.out.printf("   Título: %s%n", titulo);
        System.out.printf("   Autor: %s%n", autor);
        System.out.printf("   ISBN: %s%n", isbn);
        System.out.printf("   Año: %d%n", anioPublicacion);
        System.out.printf("   Estado: %s%n", prestado ? "Prestado" : "Disponible");
    }
    
    // Método estático
    public static int getTotalLibrosCreados() {
        return contadorLibros;
    }
}

// Clase para representar un usuario
class Usuario {
    private static int contadorUsuarios = 0;
    
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    
    public Usuario(String nombre, String email, String telefono) {
        contadorUsuarios++;
        this.id = contadorUsuarios;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }
    
    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    
    public static int getTotalUsuarios() {
        return contadorUsuarios;
    }
}
```

### **📋 Conceptos aplicados en el proyecto:**

1. **✅ El método main()**: Punto de entrada del programa con lógica principal
2. **✅ Estructura de clases**: Clases `Libro`, `Usuario` y `SistemaBiblioteca`
3. **✅ System.out**: Uso extensivo de `println()`, `printf()` con formatos complejos
4. **✅ Case Sensitivity**: Validaciones, métodos con nombres precisos, variables diferenciadas
5. **✅ Variables estáticas vs instancia**: Contadores globales vs datos específicos de objetos
6. **✅ Strings inmutables**: Manipulación de cadenas, búsquedas, validaciones
7. **✅ Estructuras de control**: `while`, `switch`, `for`, `if-else` anidados
8. **✅ Arrays**: Almacenamiento de libros y usuarios, reportes estadísticos
9. **✅ Tipos de datos**: Manejo de `int`, `String`, `boolean`, `double`
10. **✅ Comentarios**: Documentación clara del código

### **🎯 Ejercicios de extensión:**

1. **Agregar funcionalidad de préstamos**: Implementar sistema completo de préstamos y devoluciones
2. **Validaciones avanzadas**: Email, teléfono, fechas de vencimiento
3. **Reportes adicionales**: Por autor, por año, libros más prestados
4. **Persistencia**: Guardar y cargar datos de archivos
5. **Interfaz mejorada**: Colores en consola, menús más intuitivos

---

## 🏭 **CONCEPTOS AVANZADOS: EJEMPLOS DE CÓDIGO REAL DE PRODUCCIÓN**

### 📊 **ANÁLISIS DE CÓDIGO EMPRESARIAL REAL**

Los siguientes ejemplos provienen de un sistema real de ingeniería para diseño de transformadores eléctricos. Analicemos cómo se aplican los conceptos fundamentales en software de producción:

---

### 🔧 **CONCEPTO AVANZADO 1: INTERFACES Y MULTIHILOS**

#### **🎯 Implementación de Interfaces:**
```java
// Del archivo Funciones.java - Implementación real de Runnable
public class Funciones implements Runnable {
    // Variables de instancia para el hilo
    String hora, minutos, segundos, ampm;
    Calendar calendario;
    
    // Implementación obligatoria del método run()
    @Override
    public void run() {
        // Lógica que se ejecuta en el hilo separado
        // Actualización de reloj en tiempo real
        while (true) {
            calcula();  // Actualizar hora
            reloj();    // Mostrar en interfaz
            try {
                Thread.sleep(1000);  // Pausa de 1 segundo
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
```

**💡 Explicación:**
- **Interface `Runnable`**: Contrato que obliga a implementar el método `run()`
- **Multihilos**: Permite ejecutar el reloj en paralelo sin bloquear la interfaz
- **Implementación real**: El sistema actualiza varios relojes simultáneamente

---

### 🗃️ **CONCEPTO AVANZADO 2: BASES DE DATOS Y MANEJO DE EXCEPCIONES**

#### **🎯 Consultas a Base de Datos con Manejo Robusto:**
```java
// Del archivo Consultas.java - Método real para cargar usuarios
public static void llenarUsuarios() {
    ServiciosBD.ConsultaGenereal("idusuario,login,contra,email,nombre,apellido,rol,ruta_firma", 
                                "usuarios", "Order By Idusuario","");
    DefaultTableModel modelo = new DefaultTableModel();
    Administracion.jtQuery.setModel(modelo);
    
    try {
        ResultSetMetaData rsMd = ServiciosBD.resultado.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();
        
        // Configurar cabeceras de tabla dinámicamente
        for (int i = 1; i <= cantidadColumnas; i++) {
            modelo.addColumn(rsMd.getColumnLabel(i));
        }
        
        // Llenar datos fila por fila
        while (ServiciosBD.resultado.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                fila[i] = ServiciosBD.resultado.getObject(i+1);
            }
            modelo.addRow(fila);
        }
        ServiciosBD.resultado.close();
        
    } catch (SQLException ex) {
        // Logging profesional del error
        log.error(usuarioLogin.getNombre() + usuarioLogin.getApellido() + ex);
        
        // Notificación al usuario
        JOptionPane.showMessageDialog(null, ex, "Error en la consulta llenar usuarios", 
                                    JOptionPane.WARNING_MESSAGE);
        
        // Envío automático de reporte de error
        Email.Lanzar("Consultas.LlenarUsuarios", ex.toString(), 0);
    }
}
```

**💡 Conceptos Aplicados:**
- **Excepciones**: Manejo profesional con `try-catch`
- **Logging**: Registro de errores para debugging
- **Interfaz Gráfica**: Integración con tablas Swing
- **Base de Datos**: Consultas SQL con metadatos dinámicos

---

### 📐 **CONCEPTO AVANZADO 3: CÁLCULOS DE INGENIERÍA CON VALIDACIÓN**

#### **🎯 Método Complejo de Cálculo Real:**
```java
// Del archivo Consultas.java - Cálculo de aislamientos eléctricos
public static void CapAislamientos(Double emin, Double vc2, String TipoPapel, int nReferencias) {        
    // Query SQL compleja para cálculos de ingeniería
    ServiciosBD.ConsultaGenereal(
        "CAPACIDAD_AISLAMIENTOS_J.*," +
        "(CP08*DPP0075+CP13*DPP013+CP18*DPP018+CP25*DPP025+" +
        "CDPE13*DPE013+CDPE15*DPE015+CDPE20*DPE020+" +
        "CDPE25*DPE025+CDPE30*DPE030) as COSTO",
        
        "CAPACIDAD_AISLAMIENTOS_J," +
        "(select * from(select items_unoe" + DatosFactores.CostoMes + ".ITEM as item," +
        "espesor,proyeccion from items_unoe" + DatosFactores.CostoMes + "," +
        "kits_papel_epox where kits_papel_epox.item=items_unoe" + DatosFactores.CostoMes + 
        ".item) PIVOT(avg(proyeccion*espesor) for item in (" + 
        (TipoPapel.contains("TuFlex") ? "38074" : "13152") + " as CP08," +
        "514 as CP13,515 as CP18,516 as CP25," +
        "51890 as CDPE13,51890 as CDPE15,51890 as CDPE20," +
        "51892 as CDPE25,51893 as CDPE30)))",
        
        "WHERE cap >= " + vc2 + " AND tipo = '" + TipoPapel + "' AND DPP0038 = 0 " +
        "AND DPP0050 = 0 AND DPE013 = 0 " +
        (!Aislamientos.habilitarPapel013 ? "AND DPP013 = 0" : "") + 
        " AND ep >= " + emin + " AND NREFERENCIAS <= " + nReferencias + 
        " ORDER by ep, cap desc, costo", "");
}
```

**💡 Conceptos Aplicados:**
- **Parámetros múltiples**: Método con 4 parámetros de diferentes tipos
- **Condicionales complejas**: Uso de operador ternario en SQL
- **Concatenación de strings**: Construcción dinámica de consultas
- **Validaciones**: Filtros basados en variables de estado
- **Ingeniería real**: Cálculos de capacidad de aislamiento eléctrico

---

### 📋 **CONCEPTO AVANZADO 4: MANEJO DE METADATOS Y TABLAS DINÁMICAS**

#### **🎯 Construcción Dinámica de Interfaces:**
```java
// Del archivo Consultas.java - Tabla dinámica de precálculos
public static void TablaPrecalculo() {
    // Query con formateo de moneda y campos condicionales
    ServiciosBD.ConsultaGenereal(
        "IDD,TO_CHAR(CEVF,'$999,999,999.00') as CEVF,PCU,PO,PT,TCC,IO,RIO,LAMINA," +
        (DatosEntrada.TCons == 5 || DatosEntrada.TCons == 6 ? "DN,AC" : "AI,BIF") + "," +
        "BFO,N2,HC2,EC2,SC2,AWG1,HTB,DIT,DAV,EFICIENCIA," +
        "TO_CHAR(CCF,'$999,999,999.00') as CCF,ac,bc,gtotal,at,bt,ht,SC", 
        "Precalculo", "Order By CEVF", "");
        
    precalculo = new DefaultTableModel();
    Precalculos.jTable1.setModel(precalculo);
    Precalculos.jTable1.setRowSorter(new TableRowSorter(precalculo));
    
    try {
        ResultSetMetaData rsMd = ServiciosBD.resultado.getMetaData();
        int cantidadColumnas = rsMd.getColumnCount();
        
        // Cabeceras dinámicas
        for (int i = 1; i <= cantidadColumnas; i++) {
            precalculo.addColumn(rsMd.getColumnLabel(i));
        }
        
        // Procesamiento condicional por columna
        while (ServiciosBD.resultado.next()) {
            Object[] fila = new Object[cantidadColumnas];
            for (int i = 0; i < cantidadColumnas; i++) {
                switch (i) {
                    case 0:  // ID
                    case 2:  // PCU 
                    case 3:  // PO
                    case 4:  // PT
                    case 11: // Otros campos numéricos
                        // Procesamiento específico para números
                        fila[i] = ServiciosBD.resultado.getObject(i + 1);
                        break;
                    default:
                        // Procesamiento genérico
                        fila[i] = ServiciosBD.resultado.getString(i + 1);
                }
            }
            precalculo.addRow(fila);
        }
    } catch (SQLException ex) {
        // Manejo de excepciones...
    }
}
```

**💡 Conceptos Aplicados:**
- **Metadatos**: Uso de `ResultSetMetaData` para estructura dinámica
- **Formateo SQL**: `TO_CHAR` para formato de moneda
- **Condicionales**: Campos diferentes según tipo de consulta
- **Switch statements**: Procesamiento específico por tipo de columna
- **Ordenamiento**: Integración con `TableRowSorter` para interfaz

---

### ⚡ **CONCEPTO AVANZADO 5: VARIABLES ESTÁTICAS COMPLEJAS**

#### **🎯 Sistema de Estado Global:**
```java
// Del archivo Funciones.java - Variables estáticas del sistema real
public class Funciones implements Runnable {
    // Control de estado de ventanas
    public static int bandera, bandera1, bandera2, bandera3, bandera4, bandera5, 
                     bandera6, bandera7, bandera8, BanderaVemergente, IndexVemergente, band = 0;
    
    // Configuración del sistema
    public static String Ip = "", Equipo = "";
    public static File Archivo = null;
    public static int Tamano;
    
    // Matrices de datos técnicos
    public static double[][] VpTaps;  // Datos de taps de voltaje
    public static String Dis[][];     // Diseños disponibles
    public static double[][] ai_bi_Solid;  // Coeficientes sólidos
    
    // Constantes de ingeniería (fórmulas específicas)
    public static double C1wrwct = 7.2661 * Math.pow(10, -5);
    public static double C2wrwct = -2.9651 * Math.pow(10, -4);
    public static double C3wrwct = 4.7827 * Math.pow(10, -5);
    public static double C4wrwct = -2.83954 * Math.pow(10, -4);
    public static double C1wco = 4.4357 * Math.pow(10, -5);
    public static double C2wco = -3.26986 * Math.pow(10, -4);
    
    // Variables de control de proceso
    public static boolean advEmbalaje = false, embalajeXestandar = false;
    public static boolean ULxEstandar = false, aceiteXestandar = false;
    
    // Hilos de ejecución
    public static Thread h1;
    
    // Variables para cálculos específicos
    public static double tcc = 0, XL = 0, r = 0;  // Regulación en prediseño
    public static double espirasAntesTapMedio = 0;
}
```

**💡 Conceptos Aplicados:**
- **Variables de estado**: Control global del flujo de aplicación
- **Matrices multidimensionales**: Almacenamiento de datos técnicos complejos
- **Constantes calculadas**: Valores de ingeniería con `Math.pow()`
- **Referencias a objetos**: `File`, `Thread` como variables estáticas
- **Naming conventions**: Nombres descriptivos para dominio específico

---

### 🎯 **LECCIONES DE CÓDIGO PROFESIONAL**

#### **✅ Buenas Prácticas Observadas:**

1. **Separación de responsabilidades**:
   - `Funciones.java`: Utilidades generales
   - `Consultas.java`: Acceso a datos específico

2. **Manejo robusto de errores**:
   - Try-catch específicos por tipo de operación
   - Logging detallado para debugging
   - Notificaciones automáticas de errores

3. **Flexibilidad**:
   - Consultas SQL dinámicas
   - Interfaces que se adaptan a diferentes datos
   - Configuraciones mediante variables estáticas

4. **Documentación profesional**:
   - JavaDoc completo con autor y versión
   - Comentarios explicativos en lógica compleja
   - Nombres de variables autodescriptivos

#### **🔧 Patrones de Diseño Aplicados:**

- **Singleton implícito**: Variables estáticas para estado global
- **Factory pattern**: Construcción dinámica de tablas
- **Observer pattern**: Interfaces que reaccionan a cambios de datos
- **Thread pattern**: Ejecución concurrente para interfaces responsivas

**Estos ejemplos demuestran cómo los conceptos básicos de Java se combinan para crear software empresarial robusto y funcional.**

---

## 🔄 **COMPARATIVA: DE LOS CONCEPTOS BÁSICOS AL CÓDIGO PROFESIONAL**

### 📊 **Evolución del Conocimiento**

| Concepto Básico | Aplicación en Producción | Ejemplo del Sistema Real |
|-----------------|-------------------------|--------------------------|
| **Variables simples** | **Estado global complejo** | `public static int bandera1, bandera2, bandera3...` |
| **Métodos básicos** | **APIs especializadas** | `CapAislamientos()`, `TablaPrecalculo()` |
| **System.out.println** | **Logging profesional** | `log.error()`, `Email.Lanzar()` |
| **If-else simple** | **Condicionales complejas** | `(DatosEntrada.TCons==5\|\|DatosEntrada.TCons==6?"DN,AC":"AI,BIF")` |
| **Arrays básicos** | **Matrices multidimensionales** | `double[][] VpTaps`, `String Dis[][]` |
| **Strings concatenación** | **Construcción dinámica SQL** | Query SQL de 500+ caracteres |
| **Try-catch básico** | **Manejo integral errores** | Logging + Notificación + Email automático |

### 🎯 **Progresión de Complejidad**

#### **🟢 NIVEL BÁSICO (Conceptos 1-5):**
```java
// Lo que aprendes primero
public class MiClase {
    public static void main(String[] args) {
        System.out.println("Hola Mundo");
    }
}
```

#### **🟡 NIVEL INTERMEDIO (Conceptos 6-10):**
```java
// Agregando lógica y control
public class CalculadoraBasica {
    public static double sumar(double a, double b) {
        return a + b;
    }
}
```

#### **🟠 NIVEL AVANZADO (Conceptos 11-13):**
```java
// Manejo de excepciones y validaciones
public class ValidadorDatos {
    public static boolean validar(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
```

#### **🔴 NIVEL PROFESIONAL (Código Real de Producción):**
```java
// Sistema completo con múltiples responsabilidades
public class Funciones implements Runnable {
    public static void CapAislamientos(Double emin, Double vc2, String TipoPapel, int nReferencias) {
        // 20+ líneas de SQL complejo
        // Manejo de metadatos dinámicos
        // Integración con interfaces gráficas
        // Sistema de logging y notificaciones
    }
}
```

### 🚀 **Camino de Aprendizaje Recomendado**

#### **Fase 1: Fundamentos (Semanas 1-2)**
1. ✅ Dominar conceptos 1-5 del README
2. ✅ Practicar con ejemplos básicos
3. ✅ Entender compilación y ejecución

#### **Fase 2: Estructuras (Semanas 3-4)**
1. 📖 Estudiar conceptos 6-10
2. 🛠️ Implementar calculadoras simples
3. 🎯 Practicar arrays y strings

#### **Fase 3: Control Avanzado (Semanas 5-6)**
1. 📚 Conceptos 11-13 + excepciones
2. 🔧 Crear validadores y utilidades
3. 🧪 Testing y debugging

#### **Fase 4: Código Real (Semanas 7-8)**
1. 🏭 Analizar código de `Funciones.java` y `Consultas.java`
2. 🔍 Entender patrones de diseño aplicados
3. 💼 Implementar mini-proyectos similares

### 💡 **Reflexiones Finales**

#### **🎓 Lo que Aprendiste:**
- **Fundamentos sólidos**: Base teórica completa de Java 8
- **Ejemplos reales**: Código de producción auténtico
- **Progresión natural**: Del "Hola Mundo" a sistemas empresariales
- **Buenas prácticas**: Patrones observados en software real

#### **🚀 Próximos Pasos:**
- **Frameworks**: Spring, Hibernate, Maven
- **Bases de Datos**: JDBC, JPA, conexiones reales
- **Interfaces Gráficas**: Swing avanzado, JavaFX
- **Arquitectura**: Patrones de diseño, clean code

#### **🏆 Objetivo Cumplido:**
Has visto la **evolución completa** desde conceptos básicos hasta implementaciones profesionales. El código de `Funciones.java` y `Consultas.java` no son ejercicios académicos - son **herramientas reales** usadas en la industria para resolver **problemas complejos de ingeniería**.

**¡Ahora tienes las bases para construir software profesional en Java!**

---

### Práctica Adicional:
- [CodingBat Java](https://codingbat.com/java)
- [HackerRank Java](https://www.hackerrank.com/domains/java)
- [LeetCode](https://leetcode.com/)

---