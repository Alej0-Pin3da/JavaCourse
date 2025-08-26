
# 📚 1.1 Primeros Pasos — Teoría Fundamental de Java 8

## 🎯 Información General

**Sección:** 1.1 Primeros Pasos  
**Módulo:** Fundamentos de Java  
**Duración estimada:** 2-3 horas de estudio  
**Nivel:** Repaso para programadores con experiencia  
**Prerrequisitos:** Conocimientos básicos de programación en cualquier lenguaje  

---

## TL;DR

Esta sección cubre los conceptos esenciales para iniciar en Java 8: cómo escribir y ejecutar un programa, la estructura de clases, tipos primitivos y de referencia, control de flujo y buenas prácticas básicas.

## 🎯 Objetivos de aprendizaje

- Entender el punto de entrada `main()` y la estructura básica de una clase Java.
- Distinguir entre tipos primitivos y tipos de referencia (wrappers) y cuándo usarlos.
- Conocer diferencias clave (strings inmutables, autoboxing) y errores comunes a evitar.
- Saber compilar y ejecutar ejemplos sencillos con `javac` y `java`.

## 📋 Índice de Contenidos

- [CONCEPTO 1: El método main() - Punto de entrada](#concepto-1-el-m%C3%A9todo-main---punto-de-entrada)
- [CONCEPTO 2: Estructura de clases](#concepto-2---estructura-de-clases)
- [CONCEPTO 3: Salida estándar (System.out)](#concepto-3---salida-est%C3%A1ndar-systemout)
- [CONCEPTO 4: CASE SENSITIVITY](#concepto-4-case-sensitivity)
- [CONCEPTO 6: Tipado fuerte y estático](#concepto-6-tipado-fuerte-y-est%C3%A1tico)
- [CONCEPTO 7: Variables estáticas vs de instancia](#concepto-7-variables-est%C3%A1ticas-vs-de-instancia)
- [CONCEPTO 11: Strings inmutables](#concepto-11-strings-inmutables)
- [CONCEPTO 12: Estructuras de control](#concepto-12-estructuras-de-control)
- [CONCEPTO 13: Arrays en Java](#concepto-13-arrays-en-java)
- [CONCEPTO 14: Tipos de datos en Java 8](#concepto-14-tipos-de-datos-en-java-8)
- [CONCEPTO 15: Reglas para nombres de variables](#concepto-15-reglas-para-nombres-de-variables)
- [CONCEPTO 16: Tipos de comentarios](#concepto-16-tipos-de-comentarios)
- [CONCEPTO 17: Paso de parámetros](#concepto-17-paso-de-par%C3%A1metros)

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

    Ejemplo mínimo:

    ```java
    public class HolaMundo {
        public static void main(String[] args) {
            System.out.println("Hola Mundo");
        }
    }
    ```

    ---

### 🖥️ CONCEPTO 3 — Salida estándar (System.out)

    Usa `System.out.println`, `System.out.print` y `System.out.printf` para mostrar información por consola.

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
        
        // Tabla de promoción automática en operaciones:
        // byte, short, char → int
        // int + long → long
        // int + float → float
        // float + double → double
    }
}
```

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
double resultado = (double) (10 + 20);  // 10 + 20 ya es int

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

### 🏷️ **CONCEPTO 7: VARIABLES ESTÁTICAS VS DE INSTANCIA**

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

### 📝 CONCEPTO 11 — Strings inmutables

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

### 🔄 **CONCEPTO 12: ESTRUCTURAS DE CONTROL**

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

### 📊 CONCEPTO 13 — Arrays
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
List<String> upper = Arrays.stream(names)"+
        .map(String::toUpperCase)
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

### 🎯 CONCEPTO 14 — Tipos de datos (primitivos y wrappers)
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

### 📝 CONCEPTO 15 — Reglas para variables, clases y palabras reservadas

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

### 💬 CONCEPTO 16 — Tipos de comentarios

    `//` línea, `/* ... */` multilínea, `/** ... */` JavaDoc.

    ---

### ⚡ CONCEPTO 17 — Paso de parámetros

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

### �🏗️ **CONCEPTO 2: ESTRUCTURA OBLIGATORIA DE CLASES**

#### ¿Por qué todo debe estar en una clase?
Java es un lenguaje **puramente orientado a objetos**. A diferencia de lenguajes como C++ o JavaScript, Java no permite:
- Funciones globales
- Variables globales fuera de clases
- Código ejecutable fuera de métodos

#### Reglas fundamentales:
1. **Un archivo `.java` puede contener múltiples clases**, pero solo una puede ser `public`
2. **La clase pública debe tener el mismo nombre que el archivo**
3. **Toda funcionalidad debe estar encapsulada en métodos de clases**

#### Ejemplo de estructura básica:
```java
// Archivo: MiPrograma.java
public class MiPrograma {           // Clase pública
    private static String mensaje;  // Campo de clase
    
    public static void main(String[] args) {  // Método principal
        // Código ejecutable aquí
    }
    
    private static void otroMetodo() {        // Método auxiliar
        // Más código aquí
    }
}
```

---

### 🖥️ **CONCEPTO 3: SYSTEM.OUT - SALIDA ESTÁNDAR**

#### ¿Qué es System.out?
`System.out` es un objeto de tipo `PrintStream` que representa la **salida estándar** (típicamente la consola o terminal).

#### Métodos principales:

**`println()`** - Imprime y agrega salto de línea
```java
System.out.println("Hola"); // Imprime "Hola" + nueva línea
```

**`print()`** - Imprime sin salto de línea
```java
System.out.print("Hola ");
System.out.print("Mundo"); // Resultado: "Hola Mundo"
```

**`printf()`** - Imprime con formato (estilo C)
```java
System.out.printf("Nombre: %s, Edad: %d\n", "Juan", 25);
// Resultado: "Nombre: Juan, Edad: 25"
```

#### Especificadores de formato comunes:
| Especificador | Tipo | Ejemplo |
|---------------|------|---------|
| `%s` | String | `"Hola"` |
| `%d` | Entero decimal | `42` |
| `%f` | Float/Double | `3.14` |
| `%c` | Carácter | `'A'` |
| `%b` | Boolean | `true` |
| `%n` | Nueva línea (independiente del SO) | - |

---
// ❌ INCORRECTO - No se permite:
var numero = 42;        // 'var' limitado desde Java 10
numero = "texto";       // Error: incompatible types
```

#### Beneficios:
1. **Detección temprana de errores** (en compilación, no ejecución)
2. **Mejor rendimiento** (no hay verificación de tipos en runtime)
3. **Código más legible** y autodocumentado
4. **Mejor soporte de IDEs** (autocompletado, refactoring)

#### Comparación:
| Lenguaje | Tipado | Ejemplo |
|----------|--------|---------|
| **Java** | Fuerte, estático | `int x = 5;` |
| **JavaScript** | Débil, dinámico | `var x = 5;` |
| **Python** | Fuerte, dinámico | `x = 5` |
| **C++** | Fuerte, estático | `int x = 5;` |

---

### 🧠 **CONCEPTO 7: VARIABLES ESTÁTICAS VS DE INSTANCIA**

#### Variables de clase (static):
- Pertenecen a la **clase**, no a instancias específicas
- Se **comparten** entre todas las instancias
- Se almacenan en el **área de métodos** de la JVM
- Se inicializan cuando se **carga la clase**

```java
public class Contador {
    private static int totalInstancias = 0;  // Variable de clase
    private int miNumero;                     // Variable de instancia
    
    public Contador() {
        totalInstancias++;  // Incrementa para todas las instancias
        miNumero = totalInstancias;  // Único para cada instancia
    }
}
```

#### Variables de instancia:
- Pertenecen a **cada objeto individual**
- Cada instancia tiene su **propia copia**
- Se almacenan en el **heap**
- Se inicializan al **crear el objeto**

---

### 📝 **CONCEPTO 11: STRINGS INMUTABLES**

#### ¿Qué significa inmutable?
Una vez que se crea un String, **no puede modificarse**. Cualquier operación que "modifica" un String en realidad crea un **nuevo objeto String**.

#### Ejemplo de inmutabilidad:
```java
String original = "Java";
String mayuscula = original.toUpperCase();

System.out.println(original);   // "Java" (no cambió)
System.out.println(mayuscula);  // "JAVA" (nuevo objeto)
```

#### Problema en concatenación múltiple:
```java
// ❌ INEFICIENTE en loops:
String resultado = "";
for (int i = 0; i < 1000; i++) {
    resultado += i + " ";  // Crea 1000 objetos String temporales
}
```

#### Solución con StringBuilder:
```java
// ✅ EFICIENTE:
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 1000; i++) {
    sb.append(i).append(" ");  // Modifica el mismo objeto
}
String resultado = sb.toString();
```

#### ¿Por qué son inmutables?
1. **Thread Safety**: Múltiples hilos pueden usar el mismo String sin sincronización
2. **Hash Code Caching**: El hash se calcula una vez y se reutiliza
3. **String Pool**: Permite el pool de strings compartidos
4. **Seguridad**: Previene modificaciones accidentales

---

### 🔄 **CONCEPTO 12: ESTRUCTURAS DE CONTROL**

#### IF-ELSE:
```java
// Condición DEBE ser boolean (no int como en C)
if (numero > 0) {
    System.out.println("Positivo");
} else if (numero < 0) {
    System.out.println("Negativo");
} else {
    System.out.println("Cero");
}
```

#### SWITCH (Java 8 - Tradicional):
**Tipos permitidos:**
- `int`, `byte`, `short`, `char`
- `String` (desde Java 7)
- `enum`

**NO permitidos:** `long`, `float`, `double`, `boolean`

```java
switch (dia) {
    case "LUNES":
    case "MARTES":
        System.out.println("Día laboral");
        break;  // ⚠️ IMPORTANTE: sin break continúa
    case "SÁBADO":
        System.out.println("Fin de semana");
        break;
    default:
        System.out.println("Día no reconocido");
}
```

#### FOR tradicional:
```java
for (int i = 0; i < 10; i++) {
    if (i == 5) continue;  // Salta a la siguiente iteración
    if (i == 8) break;     // Sale del bucle
    System.out.println(i);
}
```

#### FOR-EACH (Enhanced For Loop):
```java
String[] nombres = {"Ana", "Luis", "María"};

// Más legible, menos propenso a errores
for (String nombre : nombres) {
    System.out.println(nombre);
}

// Equivale a:
for (int i = 0; i < nombres.length; i++) {
    System.out.println(nombres[i]);
}
```

---

### 📊 **CONCEPTO 13: ARRAYS EN JAVA**

#### Características fundamentales:
1. **Son objetos** (no tipos primitivos como en C)
2. **Tamaño fijo** una vez creados
3. **Tienen atributo `.length`** (no método `length()`)
4. **Índices base 0**
5. **Se inicializan con valores por defecto**

#### Valores por defecto:
| Tipo | Valor por defecto |
|------|-------------------|
| Enteros | `0` |
| Flotantes | `0.0` |
| boolean | `false` |
| char | `'\u0000'` |
| Referencias | `null` |

#### Formas de crear arrays:
```java
// Inicialización directa
int[] numeros1 = {1, 2, 3, 4, 5};

// Con tamaño específico
int[] numeros2 = new int[10];  // Inicializado con ceros

// Con new e inicialización
int[] numeros3 = new int[]{10, 20, 30};
```

#### Arrays multidimensionales:
```java
// Array bidimensional regular
int[][] matriz = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// Array "jagged" (filas de diferentes tamaños)
int[][] jagged = new int[3][];
jagged[0] = new int[2];    // Primera fila: 2 elementos
jagged[1] = new int[4];    // Segunda fila: 4 elementos
jagged[2] = new int[3];    // Tercera fila: 3 elementos
```

---

### 🎯 **CONCEPTO 14: TIPOS DE DATOS EN JAVA 8 - PRIMITIVOS Y OBJETOS**

Java 8 maneja dos categorías fundamentales de tipos de datos:
1. **Tipos Primitivos** (8 tipos básicos)
2. **Tipos de Referencia** (Objetos, incluyendo Wrapper Classes)

---

#### **PARTE A: TIPOS PRIMITIVOS - LOS 8 FUNDAMENTALES**

Los tipos primitivos son los **bloques de construcción básicos** de Java. No son objetos y se almacenan directamente en el stack.

##### **1. TIPOS ENTEROS (4 tipos):**

| Tipo | Tamaño | Rango | Valor por defecto | Ejemplo |
|------|--------|-------|-------------------|---------|
| `byte` | 8 bits (1 byte) | -128 a 127 | `0` | `byte edad = 25;` |
| `short` | 16 bits (2 bytes) | -32,768 a 32,767 | `0` | `short año = 2024;` |
| `int` | 32 bits (4 bytes) | -2,147,483,648 a 2,147,483,647 | `0` | `int poblacion = 1_000_000;` |
| `long` | 64 bits (8 bytes) | -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807 | `0L` | `long distancia = 384_400_000L;` |

**Características importantes:**
```java
// Literales enteros
int decimal = 42;           // Base 10
int octal = 052;           // Base 8 (prefijo 0)
int hexadecimal = 0x2A;    // Base 16 (prefijo 0x)
int binario = 0b101010;    // Base 2 (prefijo 0b) - Java 7+

// Underscores para legibilidad (Java 7+)
int millon = 1_000_000;
long billón = 1_000_000_000_000L;

// Suffix obligatorio para long
long grande = 9223372036854775807L;  // L o l (recomendado L)
```

##### **2. TIPOS DE PUNTO FLOTANTE (2 tipos):**

... (contenido restante no cambiado) 
// Literales de carácter
char letra = 'A';                    // Comillas simples
char numero = '5';                   // Carácter, no número
char unicode = '\u0041';             // Unicode para 'A'
char tab = '\t';                     // Carácter de tabulación
char nuevaLinea = '\n';              // Carácter de nueva línea

// char es numérico (puede hacer aritmética)
char a = 'A';
char b = (char)(a + 1);              // b = 'B'
System.out.println((int)a);         // Imprime: 65

// Caracteres especiales (escape sequences)
char comillaSimple = '\'';           // \'
char comillaDoble = '"';             // " (sin escape en char)
char backslash = '\\';               // \\
char retornoCarro = '\r';            // \r
```

---

#### **PARTE B: TIPOS DE REFERENCIA (OBJETOS)**

A diferencia de los tipos primitivos, los tipos de referencia:
- **Son objetos** (se almacenan en el heap)
- **Tienen métodos y atributos**
- **Pueden ser `null`**
- **Se pasan por referencia** (copia de la referencia)

##### **1. WRAPPER CLASSES - ENVOLTURAS DE PRIMITIVOS**

Cada tipo primitivo tiene su clase wrapper correspondiente:

| Primitivo | Wrapper Class | Paquete | Ejemplo de creación |
|-----------|---------------|---------|---------------------|
| `byte` | `Byte` | `java.lang` | `Byte b = Byte.valueOf(100);` |
| `short` | `Short` | `java.lang` | `Short s = Short.valueOf(1000);` |
| `int` | `Integer` | `java.lang` | `Integer i = Integer.valueOf(42);` |
| `long` | `Long` | `java.lang` | `Long l = Long.valueOf(42L);` |
| `float` | `Float` | `java.lang` | `Float f = Float.valueOf(3.14f);` |
| `double` | `Double` | `java.lang` | `Double d = Double.valueOf(3.14);` |
| `boolean` | `Boolean` | `java.lang` | `Boolean bool = Boolean.valueOf(true);` |
| `char` | `Character` | `java.lang` | `Character c = Character.valueOf('A');` |

**¿Por qué existen las Wrapper Classes?**
1. **Colecciones**: `ArrayList<Integer>` (no acepta `ArrayList<int>`)
2. **Métodos útiles**: `Integer.parseInt("123")`, `Double.isNaN()`
3. **Valores null**: Los primitivos no pueden ser `null`
4. **Genéricos**: Necesarios para `List<T>`, `Map<K,V>`, etc.

##### **2. AUTOBOXING Y UNBOXING EN JAVA 8**

**Autoboxing** (primitivo → wrapper automáticamente):
```java
// Automático desde Java 5
Integer obj1 = 42;               // Equivale a: Integer.valueOf(42)
Double obj2 = 3.14;              // Equivale a: Double.valueOf(3.14)
Boolean obj3 = true;             // Equivale a: Boolean.valueOf(true)

// En colecciones
List<Integer> numeros = new ArrayList<>();
numeros.add(42);                 // Autoboxing: int → Integer
numeros.add(100);                // Autoboxing: int → Integer
```

**Unboxing** (wrapper → primitivo automáticamente):
```java
Integer objInt = 42;
int primitivo = objInt;          // Equivale a: objInt.intValue()

// En operaciones aritméticas
Integer a = 10, b = 20;
int suma = a + b;                // Unboxing automático para la suma
```

**⚠️ CUIDADOS CON AUTOBOXING:**

```java
// 1. PERFORMANCE - Crear objetos es costoso
List<Integer> lista = new ArrayList<>();
for (int i = 0; i < 1_000_000; i++) {
    lista.add(i);  // 1 millón de autoboxings (lento)
}

// 2. NULL POINTER EXCEPTION
Integer obj = null;
int primitivo = obj;  // ¡NullPointerException en runtime!

// 3. INTEGER CACHE (-128 a 127)
Integer a = 127, b = 127;    // Mismo objeto (cache)
Integer c = 128, d = 128;    // Objetos diferentes

System.out.println(a == b);  // true (misma referencia)
System.out.println(c == d);  // false (referencias diferentes) ⚠️
System.out.println(c.equals(d)); // true (mismo valor) ✅
```

##### **3. MÉTODOS ÚTILES DE WRAPPER CLASSES**

```java
// INTEGER
int valor = Integer.parseInt("123");        // String → int
Integer obj = Integer.valueOf("123");       // String → Integer
String str = Integer.toString(123);         // int → String
String binario = Integer.toBinaryString(10); // "1010"
String hex = Integer.toHexString(255);      // "ff"
int max = Integer.MAX_VALUE;                // 2147483647
int min = Integer.MIN_VALUE;                // -2147483648

// DOUBLE
double d = Double.parseDouble("3.14");      // String → double
boolean esNaN = Double.isNaN(d);            // Verificar NaN
boolean esInfinito = Double.isInfinite(d);  // Verificar infinito
String str = Double.toString(3.14);         // double → String

// CHARACTER
boolean esLetra = Character.isLetter('A');      // true
boolean esDigito = Character.isDigit('5');      // true
boolean esMayus = Character.isUpperCase('A');   // true
char mayus = Character.toUpperCase('a');        // 'A'
char minus = Character.toLowerCase('A');        // 'a'

// BOOLEAN  
Boolean obj = Boolean.valueOf("true");      // String → Boolean
boolean primitivo = Boolean.parseBoolean("false"); // String → boolean
```

##### **4. COMPARACIÓN: PRIMITIVOS VS OBJETOS**

| Aspecto | Primitivos | Objetos (Wrapper Classes) |
|---------|------------|---------------------------|
| **Ubicación** | Stack | Heap |
| **Velocidad** | Muy rápido | Más lento |
| **Memoria** | Mínima | Más memoria (overhead) |
| **Valores null** | ❌ No permitido | ✅ Permitido |
| **Métodos** | ❌ No tienen | ✅ Muchos métodos útiles |
| **Colecciones** | ❌ No compatible | ✅ Compatible |
| **Genéricos** | ❌ No compatible | ✅ Compatible |
| **Comparación** | `==` compara valor | `==` compara referencias |
| **Inmutabilidad** | N/A | ✅ Son inmutables |

##### **5. CUÁNDO USAR CADA TIPO**

**Usa PRIMITIVOS cuando:**
```java
// Variables simples y operaciones aritméticas
int contador = 0;
double precio = 19.99;
boolean activo = true;

// Loops y cálculos intensivos
for (int i = 0; i < 1_000_000; i++) {
    // Operaciones rápidas
}
```

**Usa WRAPPER CLASSES cuando:**
```java
// Colecciones
List<Integer> numeros = new ArrayList<>();
Map<String, Double> precios = new HashMap<>();

// Necesitas null
Integer edad = null;  // Indica "no especificado"
if (edad != null) {
    // Procesar edad
}

// Métodos de utilidad
String numero = "123";
try {
    Integer valor = Integer.valueOf(numero);
} catch (NumberFormatException e) {
    // Manejar error
}

// Genéricos
Optional<Double> resultado = calcular();
```

---

#### **PARTE C: TIPOS ESPECIALES EN JAVA 8**

##### **1. STRING - EL TIPO MÁS USADO**
```java
// String es una CLASE, no primitivo
String texto = "Hola Mundo";        // Literal (pool de strings)
String texto2 = new String("Hola"); // Objeto explícito (heap)

// Características clave
String inmutable = "Java";
inmutable.toUpperCase();             // No modifica 'inmutable'
String nuevo = inmutable.toUpperCase(); // Crea nuevo String

// Métodos importantes
int longitud = texto.length();       // 10
char caracter = texto.charAt(0);     // 'H'
boolean contiene = texto.contains("Mundo"); // true
String[] partes = texto.split(" ");  // ["Hola", "Mundo"]
```

##### **2. ARRAYS - OBJETOS ESPECIALES**
```java
// Arrays SON objetos (no primitivos)
int[] numeros = {1, 2, 3, 4, 5};    // Array de primitivos
Integer[] objetos = {1, 2, 3, 4, 5}; // Array de objetos

// Propiedades de arrays
System.out.println(numeros.length);  // 5 (atributo, no método)
System.out.println(numeros instanceof Object); // true

// Arrays multidimensionales
int[][] matriz = new int[3][4];      // 3 filas, 4 columnas
String[][] tabla = {
    {"A", "B", "C"},
    {"D", "E", "F"}
};
```

##### **3. ENUM - TIPO ESPECIAL (Java 5+)**
```java
// Enums son clases especiales
public enum Dia {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
}

// Uso
Dia hoy = Dia.LUNES;
if (hoy == Dia.LUNES) {
    System.out.println("Inicio de semana");
}

// En switch (Java 8)
switch (hoy) {
    case LUNES:
    case MARTES:
        System.out.println("Día laboral");
        break;
    case SABADO:
    case DOMINGO:
        System.out.println("Fin de semana");
        break;
}
```

---

#### **PARTE D: CONVERSIONES DE TIPOS EN JAVA 8**

##### **1. CONVERSIONES IMPLÍCITAS (WIDENING)**
Java permite conversiones automáticas cuando no hay pérdida de datos:

```java
// Jerarquía de conversiones automáticas:
// byte → short → int → long → float → double
// char → int → long → float → double

byte b = 10;
short s = b;     // ✅ Automático: byte → short
int i = s;       // ✅ Automático: short → int  
long l = i;      // ✅ Automático: int → long
float f = l;     // ✅ Automático: long → float
double d = f;    // ✅ Automático: float → double

char c = 'A';
int ascii = c;   // ✅ Automático: char → int (valor 65)
```

##### **2. CONVERSIONES EXPLÍCITAS (NARROWING)**
Requieren casting explícito cuando puede haber pérdida de datos:

```java
// Casting explícito (puede perder datos)
double d = 3.14159;
float f = (float) d;    // Pérdida de precisión
int i = (int) f;        // i = 3 (pierde decimales)
short s = (short) i;    // Posible pérdida si i > 32767
byte b = (byte) s;      // Posible pérdida si s > 127

// Overflow en conversiones
int grande = 130;
byte pequeño = (byte) grande;  // pequeño = -126 (overflow)
```

##### **3. CONVERSIONES CON STRINGS**
```java
// String → primitivos
String numero = "123";
int entero = Integer.parseInt(numero);
double decimal = Double.parseDouble("3.14");
boolean bool = Boolean.parseBoolean("true");

// primitivos → String
String str1 = String.valueOf(123);    // "123"
String str2 = Integer.toString(123);  // "123" 
String str3 = "" + 123;               // "123" (concatenación)
String str4 = String.format("%d", 123); // "123" (formato)
```

---

#### **PARTE E: MEJORES PRÁCTICAS EN JAVA 8**

##### **1. ELECCIÓN DE TIPOS:**
```java
// ✅ BUENAS PRÁCTICAS:
int contador = 0;              // int para contadores normales
long timestamp = System.currentTimeMillis(); // long para timestamps
double precio = 19.99;         // double para dinero (o BigDecimal)
boolean activo = true;         // boolean para flags
String mensaje = "Hola";       // String para texto

// ⚠️ EVITAR:
float dinero = 19.99f;         // float tiene poca precisión
byte contador = 0;             // byte innecesario para contadores simples
```

##### **2. COMPARACIONES SEGURAS:**
```java
// ✅ CORRECTO para objetos:
String a = "Hola", b = "Hola";
if (a.equals(b)) { ... }       // Compara contenido

Integer x = 1000, y = 1000;
if (x.equals(y)) { ... }       // Compara valor

// ✅ CORRECTO para primitivos:
int p = 42, q = 42;
if (p == q) { ... }            // Compara valor

// ❌ PELIGROSO:
if (a == b) { ... }            // Compara referencias (puede fallar)
if (x == y) { ... }            // Compara referencias (fallará fuera del cache)
```

##### **3. MANEJO DE NULL:**
```java
// ✅ VERIFICACIÓN SEGURA:
Integer numero = obtenerNumero(); // Puede retornar null
if (numero != null) {
    int valor = numero;        // Unboxing seguro
    // usar valor
}

// ❌ PELIGROSO:
int valor = numero;            // NullPointerException si numero es null
```

Este conocimiento profundo de los tipos de datos es fundamental para dominar Java 8 y escribir código eficiente y seguro.

---

### 📝 **CONCEPTO 15: REGLAS PARA NOMBRES DE VARIABLES EN JAVA 8**

El naming (nomenclatura) en Java es fundamental para escribir código legible, mantenible y profesional. Java tiene reglas estrictas y convenciones ampliamente aceptadas.

---

#### **PARTE A: REGLAS OBLIGATORIAS (SINTÁCTICAS)**

Estas son las reglas que **DEBE** cumplir todo identificador en Java para que el código compile:

##### **1. CARACTERES PERMITIDOS:**
```java
// ✅ PERMITIDO - Letras (a-z, A-Z)
int edad = 25;
String nombre = "Juan";
boolean ACTIVO = true;

// ✅ PERMITIDO - Dígitos (0-9) DESPUÉS del primer carácter
int numero1 = 100;
String texto123 = "test";
double precio2024 = 19.99;

// ✅ PERMITIDO - Underscore (_) en cualquier posición
int _contador = 0;
String mi_variable = "test";
boolean __interno = true;
int precio_ = 100;

// ✅ PERMITIDO - Símbolo de dólar ($) en cualquier posición
int $precio = 50;
String nombre$completo = "Juan Pérez";
boolean flag$ = false;

// ✅ PERMITIDO - Caracteres Unicode
String niño = "Pedro";    // ñ es válida
int café = 1;             // é es válida
String montaña = "Everest"; // ñ es válida
```

##### **2. CARACTERES NO PERMITIDOS:**
```java
// ❌ NO PERMITIDO - Espacios
int mi variable = 10;      // Error de compilación

// ❌ NO PERMITIDO - Caracteres especiales
int precio-total = 100;    // Error: - no permitido
String email@domain = "";  // Error: @ no permitido
double valor#1 = 3.14;     // Error: # no permitido
boolean test&flag = true;  // Error: & no permitido

// ❌ NO PERMITIDO - Empezar con dígito
int 1contador = 0;         // Error de compilación
String 2024año = "2024";   // Error de compilación
```

##### **3. LONGITUD:**
```java
// ✅ PERMITIDO - Sin límite oficial de longitud
int a = 1;  // 1 carácter válido
String esteEsUnNombreMuyLargoParaUnaVariablePeroPerfectamenteValido = "test";

// ⚠️ RECOMENDACIÓN: Máximo 20-25 caracteres para legibilidad
```

##### **4. PALABRAS RESERVADAS (KEYWORDS):**
Java tiene 50 palabras reservadas que **NO** pueden usarse como nombres de variables:

```java
// ❌ PALABRAS RESERVADAS - NO PERMITIDAS:
abstract, assert, boolean, break, byte, case, catch, char, class, const,
continue, default, do, double, else, enum, extends, false, final, finally,
float, for, goto, if, implements, import, instanceof, int, interface, long,
native, new, null, package, private, protected, public, return, short, static,
strictfp, super, switch, synchronized, this, throw, throws, transient, true,
try, void, volatile, while

// Ejemplos de errores:
int class = 5;        // ❌ Error: 'class' es palabra reservada
String new = "test";  // ❌ Error: 'new' es palabra reservada  
boolean true = false; // ❌ Error: 'true' es palabra reservada
```

##### **5. CASE SENSITIVITY:**
```java
// Java distingue mayúsculas y minúsculas - TODAS SON DIFERENTES:
int variable = 1;
int Variable = 2;
int VARIABLE = 3;
int VaRiAbLe = 4;

System.out.println(variable);  // 1
System.out.println(Variable);  // 2
System.out.println(VARIABLE);  // 3
System.out.println(VaRiAbLe);  // 4
```

---

#### **PARTE B: CONVENCIONES DE JAVA (ESTILO ORACLE/SUN)**

Estas no son obligatorias para compilar, pero son **estándares de la industria**:

##### **1. VARIABLES LOCALES Y CAMPOS DE INSTANCIA - camelCase:**
```java
// ✅ CORRECTO - Primera letra minúscula, resto en camelCase
int edad = 25;
String nombreCompleto = "Juan Pérez";
boolean estaActivo = true;
double precioTotal = 159.99;
List<String> listaNombres = new ArrayList<>();

// ❌ INCORRECTO (compila, pero rompe convenciones):
int Edad = 25;              // Primera letra mayúscula
String nombre_completo = ""; // Underscores (estilo C/Python)
boolean esta_activo = true;  // Underscores
double PRECIO_TOTAL = 99;    // Todo mayúsculas
```

##### **2. CONSTANTES - UPPER_CASE con underscores:**
```java
// ✅ CORRECTO para constantes (static final)
public static final int MAX_INTENTOS = 3;
public static final String MENSAJE_ERROR = "Error de conexión";
public static final double PI = 3.14159265359;
private static final boolean DEBUG_ACTIVO = true;

// Constantes locales también usan mayúsculas
final int LIMITE_EDAD = 18;
final String FORMATO_FECHA = "dd/MM/yyyy";
```

##### **3. CLASES - PascalCase (UpperCamelCase):**
```java
// ✅ CORRECTO - Cada palabra inicia con mayúscula
public class MiClase { }
public class CalculadoraPrecios { }  
public class GestorBaseDatos { }
public class ValidadorEmail { }
```

##### **4. MÉTODOS - camelCase:**
```java
// ✅ CORRECTO 
public void calcularTotal() { }
public String obtenerNombreCompleto() { }
public boolean esValido() { }
public void establecerPrecio(double precio) { }
```

##### **5. PAQUETES - todo en minúsculas:**
```java
// ✅ CORRECTO
package com.empresa.proyecto.util;
package org.miorganizacion.modulo.dao;

// ❌ INCORRECTO
package com.Empresa.Proyecto.Util;
package Com.MiEmpresa.MiProyecto;
```

---

#### **PARTE C: MEJORES PRÁCTICAS Y RECOMENDACIONES**

##### **1. NOMBRES DESCRIPTIVOS:**
```java
// ✅ EXCELENTE - Nombres claros y descriptivos
int cantidadEstudiantes = 25;
String direccionEmail = "user@example.com";
boolean esUsuarioVIP = true;
double saldoCuentaBancaria = 1500.50;
List<Producto> productosEnCarrito = new ArrayList<>();

// ❌ MALO - Nombres poco descriptivos
int x = 25;           // ¿Qué es x?
String s = "email";   // ¿Qué tipo de string?
boolean flag = true;  // ¿Flag de qué?
double d = 1500.50;   // ¿Qué representa d?
List<Producto> lista = new ArrayList<>(); // ¿Lista de qué?
```

##### **2. EVITAR ABREVIACIONES CONFUSAS:**
```java
// ✅ BUENO - Claro y completo
String numeroTelefono = "123-456-7890";
int cantidadProductos = 10;
boolean estaDisponible = true;

// ⚠️ ACEPTABLE - Abreviaciones muy conocidas
String url = "http://example.com";
int id = 1001;
String html = "<div>content</div>";

// ❌ MALO - Abreviaciones confusas
String numTel = "123-456-7890";  // ¿numTel = número de teléfono?
int cantProd = 10;               // ¿cantProd = cantidad productos?
boolean estaDisp = true;         // ¿estaDisp = está disponible?
```

##### **3. CONTEXTO Y ÁMBITO:**
```java
public class CalculadoraImpuestos {
    
    // ✅ BUENO - Nombres cortos en ámbito pequeño
    public double calcular(double precio, double tasa) {
        double impuesto = precio * tasa;  // OK: ámbito pequeño
        double total = precio + impuesto;  // OK: ámbito pequeño
        return total;
    }
    
    // ✅ BUENO - Nombres más descriptivos en ámbito mayor
    private static final double TASA_IVA_GENERAL = 0.21;
    private List<FacturaImpuesto> facturasProcedasEsteAño = new ArrayList<>();
}
```

##### **4. PREFIJOS Y SUFIJOS ÚTILES:**
```java
// ✅ BUENO - Prefijos para booleans
boolean esValido = true;
boolean tienePermiso = false;
boolean puedeEditar = true;
boolean estaCompleto = false;

// ✅ BUENO - Sufijos descriptivos
String nombreArchivo = "documento.pdf";
int numeroLinea = 45;
Date fechaCreacion = new Date();
List<String> listaNombres = new ArrayList<>();
Map<String, Integer> mapaEdades = new HashMap<>();

// ✅ BUENO - Contexto en nombres
int contadorUsuarios = 0;
String mensajeError = "Archivo no encontrado";
double porcentajeDescuento = 0.15;
```

---

#### **PARTE D: PATRONES COMUNES DE NOMBRES**

##### **1. CONTADORES Y BUCLES:**
```java
// ✅ TRADICIONAL - Variables de bucle
for (int i = 0; i < lista.size(); i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        // i, j, k son estándar para índices
    }
}

// ✅ MEJOR - Nombres descriptivos cuando sea necesario
for (int fila = 0; fila < matriz.length; fila++) {
    for (int columna = 0; columna < matriz[fila].length; columna++) {
        matriz[fila][columna] = calcularValor(fila, columna);
    }
}
```

##### **2. VARIABLES TEMPORALES:**
```java
// ✅ ACEPTABLE en contextos muy específicos
String temp = procesarTexto(input);
int aux = valor1;
valor1 = valor2;
valor2 = aux;

// ✅ MEJOR - Nombres que indican propósito
String textoPreparado = procesarTexto(input);
int valorTemporal = valor1;
valor1 = valor2;
valor2 = valorTemporal;
```

##### **3. VARIABLES DE CONFIGURACIÓN:**
```java
// ✅ EXCELENTE - Configuración clara
public class ConfiguracionAplicacion {
    public static final int TIMEOUT_CONEXION_SEGUNDOS = 30;
    public static final String RUTA_ARCHIVOS_LOG = "/var/log/app";
    public static final boolean MODO_DEBUG_ACTIVADO = false;
    public static final int MAX_INTENTOS_LOGIN = 3;
    
    private String rutaBaseDatos = "localhost:5432/miapp";
    private int puertoServidor = 8080;
}
```

---

#### **PARTE E: ERRORES COMUNES Y CÓMO EVITARLOS**

##### **1. ERRORES SINTÁCTICOS:**
```java
// ❌ ERRORES COMUNES:
int 2contador = 0;        // No puede empezar con dígito
String mi variable = "";  // No puede contener espacios
boolean class = true;     // No puede usar palabras reservadas
double precio-total = 0;  // Guión no permitido

// ✅ CORRECCIONES:
int contador2 = 0;        
String miVariable = "";   
boolean esClase = true;   
double precioTotal = 0;   
```

##### **2. ERRORES DE CONVENCIÓN:**
```java
// ❌ ROMPE CONVENCIONES:
int EDAD = 25;            // Variable no debería ser mayúsculas
String Nombre = "Juan";   // Primera letra no debería ser mayúscula
final int limite = 100;   // Constante debería ser mayúsculas

// ✅ SIGUIENDO CONVENCIONES:
int edad = 25;
String nombre = "Juan";
final int LIMITE = 100;
```

##### **3. NOMBRES PROBLEMÁTICOS:**
```java
// ❌ NOMBRES PROBLEMÁTICOS:
int data = 42;           // ¿Qué tipo de datos?
String info = "texto";   // ¿Qué información?
boolean flag1 = true;    // ¿Flag de qué?
List lista = new ArrayList(); // ¿Lista de qué?

// ✅ NOMBRES MEJORADOS:
int cantidadVentas = 42;
String mensajeUsuario = "texto";  
boolean esUsuarioAutenticado = true;
List<Producto> productosCarrito = new ArrayList<>();
```

---

#### **PARTE F: HERRAMIENTAS Y VERIFICACIÓN**

##### **1. IDEs MODERNOS:**
Los IDEs como IntelliJ IDEA, Eclipse y VS Code ayudan con:
- **Resaltado de sintaxis** para palabras reservadas
- **Advertencias** sobre convenciones no seguidas  
- **Refactoring automático** para renombrar variables
- **Inspecciones de código** que sugieren mejores nombres

##### **2. CHECKSTYLE Y HERRAMIENTAS DE CALIDAD:**
```xml
<!-- Configuración típica de Checkstyle para nombres -->
<module name="LocalVariableName">
    <property name="format" value="^[a-z][a-zA-Z0-9]*$"/>
</module>
<module name="ConstantName">
    <property name="format" value="^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$"/>
</module>
```

##### **3. ANÁLISIS ESTÁTICO:**
Herramientas como SonarQube, PMD y SpotBugs pueden detectar:
- Nombres muy cortos o muy largos
- Nombres poco descriptivos
- Variables no utilizadas
- Violaciones de convenciones

---

#### **RESUMEN: CHECKLIST DE NOMBRES DE VARIABLES**

##### **✅ REGLAS OBLIGATORIAS:**
- [ ] Solo letras, dígitos, underscore (_) y símbolo de dólar ($)
- [ ] No empezar con dígito
- [ ] No usar palabras reservadas
- [ ] No usar espacios ni caracteres especiales

##### **✅ CONVENCIONES RECOMENDADAS:**
- [ ] Variables: camelCase (ej: `miVariable`)
- [ ] Constantes: UPPER_CASE (ej: `MAX_VALOR`)  
- [ ] Clases: PascalCase (ej: `MiClase`)
- [ ] Paquetes: minúsculas (ej: `com.empresa.proyecto`)

##### **✅ BUENAS PRÁCTICAS:**
- [ ] Nombres descriptivos y claros
- [ ] Evitar abreviaciones confusas
- [ ] Usar contexto apropiado
- [ ] Prefijos útiles para booleans (`es`, `tiene`, `puede`)
- [ ] Longitud apropiada (ni muy corto ni muy largo)

Seguir estas reglas y convenciones hace que tu código Java sea más legible, mantenible y profesional.

---

### 📝 **CONCEPTO 16: TIPOS DE COMENTARIOS**

#### 1. Comentarios de una línea (`//`):
```java
// Esto es un comentario de una línea
int x = 42; // También puede ir al final de la línea
```

#### 2. Comentarios multilínea (`/* */`):
```java
/*
 * Este es un comentario multilínea
 * Útil para explicaciones largas
 * o para comentar bloques de código
 */
```

#### 3. Comentarios JavaDoc (`/** */`):
```java
/**
 * Este método suma dos números enteros.
 * 
 * @param a el primer número
 * @param b el segundo número
 * @return la suma de a y b
 * @throws IllegalArgumentException si algún parámetro es negativo
 * @since 1.0
 * @author Tu Nombre
 */
public int sumar(int a, int b) {
    return a + b;
}
```

#### Etiquetas especiales:
```java
// TODO: Implementar validación de entrada
// FIXME: Este algoritmo es ineficiente
// HACK: Solución temporal hasta la próxima versión
// NOTE: Este comportamiento cambió en Java 8
// XXX: Código crítico - no modificar
```

#### Generación de documentación:
```bash
# Generar documentación HTML
javadoc *.java

# Con opciones específicas
javadoc -d docs -author -version *.java
```

---

### ⚠️ **CONCEPTO 17: PASO DE PARÁMETROS**

#### Java SIEMPRE pasa por valor:
```java
public static void main(String[] args) {
    int numero = 42;
    String texto = "Original";
    
    modificar(numero, texto);
    
    System.out.println(numero); // 42 (no cambió)
    System.out.println(texto);  // "Original" (no cambió)
}

public static void modificar(int n, String s) {
    n = 100;           // Solo cambia la copia local
    s = "Modificado";  // Solo cambia la copia local de la referencia
}
```

#### Con objetos mutables:
```java
public static void modificarArray(int[] array) {
    array[0] = 999;  // SÍ modifica el contenido del objeto
    array = new int[]{1, 2, 3}; // NO cambia la referencia original
}
```

---

### 🚨 **CONCEPTO 18: PECULIARIDADES Y DIFERENCIAS**

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

## ➡️ **PRÓXIMOS PASOS**

Una vez que domines completamente esta sección, estarás listo para:

1. **1.2 Variables y Tipos de Datos** - Profundización en tipos avanzados
2. **2.1 Operadores** - Aritmética, lógica y comparación
3. **2.2 Estructuras de Control** - Patrones avanzados de control de flujo
4. **Programación Orientada a Objetos** - El corazón de Java

¡Felicidades por completar los fundamentos de Java! 🎉
