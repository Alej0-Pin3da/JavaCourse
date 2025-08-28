
# 📚 Teoría Fundamental de Java 8

## TL;DR

Esta sección cubre los conceptos esenciales para iniciar en Java 8: cómo escribir y ejecutar un programa, la estructura de clases, tipos primitivos y de referencia, control de flujo y buenas prácticas básicas.

## 📋 Índice de Contenidos

- [CONCEPTO 1: El método main() - Punto de entrada](#-concepto-1-el-método-main---punto-de-entrada)
- [CONCEPTO 2: Estructura de clases](#️-concepto-2--estructura-de-clases)
- [CONCEPTO 3: Salida estándar (System.out)](#️-concepto-3--salida-estándar-systemout)
- [CONCEPTO 4: CASE SENSITIVITY](#-concepto-4-case-sensitivity)
- [CONCEPTO 5: Variables estáticas vs de instancia](#️-concepto-5-variables-estáticas-vs-de-instancia)
- [CONCEPTO 6: Strings inmutables](#-concepto-6--strings-inmutables)
- [CONCEPTO 7: Estructuras de control](#-concepto-7-estructuras-de-control)
- [CONCEPTO 8: Arrays](#-concepto-8--arrays)
- [CONCEPTO 9: Tipos de datos (primitivos y wrappers)](#-concepto-9--tipos-de-datos-primitivos-y-wrappers)
- [CONCEPTO 10: Reglas para variables, clases y palabras reservadas](#-concepto-10--reglas-para-variables-clases-y-palabras-reservadas)
- [CONCEPTO 11: Tipos de comentarios](#-concepto-11--tipos-de-comentarios)
- [CONCEPTO 12: Paso de parámetros](#-concepto-12--paso-de-parámetros)
- [CONCEPTO 13: Peculiaridades y diferencias](#-concepto-13-peculiaridades-y-diferencias)

---

## 📖 TEORÍA DETALLADA

### 🔥 CONCEPTO 1: El método main() - Punto de entrada

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

### 🏗️ CONCEPTO 2 — Estructura de clases

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
Clase = Plano de una casa
Objeto = Casa real construida siguiendo el plano
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
public class Persona {
    String nombre;     // Variable de instancia
    int edad;         // Variable de instancia
    double altura;    // Variable de instancia
}
```

##### **2. VARIABLES LOCALES:**
- Se declaran dentro de métodos
- Solo existen mientras se ejecuta el método
- Deben inicializarse antes de usarse

```java
public void saludar() {
    String mensaje = "Hola";  // Variable local
    System.out.println(mensaje);
}
```

##### **3. VARIABLES ESTÁTICAS (de clase):**
- Pertenecen a la clase, no a objetos individuales
- Una sola copia compartida por todos los objetos
- Se marcan con la palabra `static`

```java
public class Contador {
    static int total = 0;  // Variable estática
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
public void caminar() {
    System.out.println("Estoy caminando");
}
```

##### **2. MÉTODOS ESTÁTICOS:**
- Pertenecen a la clase, no a objetos
- Se marcan con `static`
- Se llaman: `NombreClase.nombreMetodo()`

```java
public static void mostrarInfo() {
    System.out.println("Información de la clase");
}
```

##### **3. CONSTRUCTOR:**
- Método especial para crear objetos
- Mismo nombre que la clase
- No tiene tipo de retorno

```java
public ClaseBasica() {
    System.out.println("Objeto creado");
}
```

---

### 🏛️ **RELACIÓN ENTRE CLASE, VARIABLES Y MÉTODOS**

#### **📋 Estructura conceptual:**

```
CLASE = CONTENEDOR
├── VARIABLES = CARACTERÍSTICAS/PROPIEDADES
│   ├── ¿Qué datos almacena?
│   ├── ¿Qué información describe al objeto?
│   └── Ejemplo: nombre, edad, color, tamaño
│
└── MÉTODOS = COMPORTAMIENTOS/ACCIONES  
    ├── ¿Qué puede hacer el objeto?
    ├── ¿Cómo interactúa con otros objetos?
    └── Ejemplo: caminar(), hablar(), calcular(), mostrar()
```

#### **🎯 Analogía completa - Clase Auto:**

```java
class Auto {
    // VARIABLES (Características):
    String marca;
    String color;  
    int velocidad;
    boolean encendido;
    
    // MÉTODOS (Comportamientos):
    public void encender() { encendido = true; }
    public void acelerar() { velocidad += 10; }
    public void frenar() { velocidad -= 10; }
    public void tocarBocina() { System.out.println("¡BEEP!"); }
}

// Usar la clase:
Auto miAuto = new Auto();  // Crear objeto
miAuto.encender();         // Usar comportamiento
miAuto.acelerar();         // Usar comportamiento
```

#### **🎓 Ejemplo expandido - Clase Estudiante:**

```java
public class Estudiante {
    // VARIABLES DE INSTANCIA: Características de cada estudiante
    private String nombre;
    private int edad;
    private double promedio;
    
    // CONSTRUCTOR: Cómo crear un estudiante
    public Estudiante(String nombre, int edad, double promedio) {
        this.nombre = nombre;      // Asignar características
        this.edad = edad;
        this.promedio = promedio;
    }
    
    // MÉTODOS: Comportamientos/acciones del estudiante
    public void estudiar() {
        System.out.println(nombre + " está estudiando");
    }
    
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + ", Edad: " + edad);
    }
    
    public double getPromedio() {
        return promedio;  // Retorna información
    }
    
    // MÉTODO ESTÁTICO: Pertenece a la clase, no a objetos individuales
    public static void mostrarReglasEstudio() {
        System.out.println("Reglas: Ser puntual, participar, hacer tareas");
    }
}
```

#### **💻 Uso de la clase:**
```java
public static void main(String[] args) {
    // CREAR OBJETOS (instancias de la clase)
    Estudiante ana = new Estudiante("Ana", 20, 8.5);
    Estudiante carlos = new Estudiante("Carlos", 19, 9.2);
    
    // USAR MÉTODOS DE INSTANCIA
    ana.estudiar();        // Ana está estudiando
    carlos.mostrarInfo();  // Estudiante: Carlos, Edad: 19
    
    // USAR MÉTODO ESTÁTICO (desde la clase)
    Estudiante.mostrarReglasEstudio();  // Sin crear objeto
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

### 🖥️ CONCEPTO 3 — Salida estándar (System.out)

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

---

### 📝 **CONCEPTO 4: CASE SENSITIVITY**

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

---

### 🏷️ **CONCEPTO 5: VARIABLES ESTÁTICAS VS DE INSTANCIA**

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

    ---

### 📝 CONCEPTO 6 — Strings inmutables

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

### 🔄 **CONCEPTO 7: ESTRUCTURAS DE CONTROL**

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

### 📊 CONCEPTO 8 — Arrays
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

### 🎯 CONCEPTO 9 — Tipos de datos (primitivos y wrappers)
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

### 📝 CONCEPTO 10 — Reglas para variables, clases y palabras reservadas

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

### 💬 CONCEPTO 11 — Tipos de comentarios

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

### ⚡ CONCEPTO 12 — Paso de parámetros

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

### 🚨 **CONCEPTO 13: PECULIARIDADES Y DIFERENCIAS**

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

### Práctica Adicional:
- [CodingBat Java](https://codingbat.com/java)
- [HackerRank Java](https://www.hackerrank.com/domains/java)
- [LeetCode](https://leetcode.com/)

---