# 📚 1.1 Primeros Pasos - Teoría Completa

## 🎯 Información General

**Sección:** 1.1 Primeros Pasos  
**Módulo:** Fundamentos de Java  
**Duración estimada:** 2-3 horas de estudio  
**Nivel:** Repaso para programadores con experiencia  
**Prerrequisitos:** Conocimientos básicos de programación en cualquier lenguaje  

---

## 📖 TEORÍA DETALLADA

### 🔥 **CONCEPTO 1: EL MÉTODO MAIN() - PUNTO DE ENTRADA**

#### ¿Qué es el método main()?
El método `main()` es el **punto de entrada** de cualquier aplicación Java ejecutable. Es el primer método que la JVM (Java Virtual Machine) busca y ejecuta cuando inicias un programa.

#### Anatomía del método main():
```java
public static void main(String[] args)
```

**Análisis de cada palabra clave:**

- **`public`**: Modificador de acceso que permite que la JVM acceda al método desde cualquier lugar
- **`static`**: Permite que el método sea llamado sin crear una instancia de la clase
- **`void`**: Indica que el método no retorna ningún valor
- **`main`**: Nombre específico que la JVM busca (sensible a mayúsculas/minúsculas)
- **`String[] args`**: Array de strings que contiene argumentos de línea de comandos

#### Comparación con otros lenguajes:
| Lenguaje | Punto de entrada |
|----------|------------------|
| **Java** | `public static void main(String[] args)` |
| **C/C++** | `int main()` o `int main(int argc, char* argv[])` |
| **Python** | `if __name__ == "__main__":` |
| **JavaScript** | No hay punto de entrada fijo |
| **C#** | `static void Main(string[] args)` |

---

### 🏗️ **CONCEPTO 2: ESTRUCTURA OBLIGATORIA DE CLASES**

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

### 🔤 **CONCEPTO 4: CASE SENSITIVITY (SENSIBILIDAD A MAYÚSCULAS)**

#### Java es Case-Sensitive
Java distingue estrictamente entre mayúsculas y minúsculas:

```java
// Estas son todas variables DIFERENTES:
int numero = 5;
int Numero = 10;
int NUMERO = 15;
int nUmErO = 20;
```

#### Ejemplos de errores comunes:
```java
// ❌ INCORRECTO:
system.out.println("Hola");  // 'system' debe ser 'System'
String.length();             // 'length' debe ser 'length()'
Public class Mi Clase {      // 'Public' debe ser 'public'

// ✅ CORRECTO:
System.out.println("Hola");
string.length();
public class MiClase {
```

#### Diferencia con otros lenguajes:
- **SQL**: Generalmente no es case-sensitive (`SELECT` = `select`)
- **HTML**: No es case-sensitive (`<DIV>` = `<div>`)
- **Visual Basic**: No es case-sensitive
- **Python**: Es case-sensitive (similar a Java)

---

### ⚙️ **CONCEPTO 5: COMPILACIÓN A BYTECODE**

#### El proceso de compilación Java:

1. **Código fuente** (`.java`) → Escribes tu programa
2. **Compilador javac** → Traduce a bytecode
3. **Bytecode** (`.java`) → Código intermedio portable
4. **JVM** → Ejecuta el bytecode en el sistema operativo específico

```
MiPrograma.java  →  javac  →  MiPrograma.class  →  JVM  →  Ejecución
   (Fuente)                     (Bytecode)
```

#### Ventajas del bytecode:
- **Portabilidad**: "Write Once, Run Anywhere" (WORA)
- **Seguridad**: El bytecode es verificado antes de la ejecución
- **Optimización**: La JVM puede optimizar el código en tiempo de ejecución

#### Comandos básicos:
```bash
# Compilar
javac MiPrograma.java  # Genera MiPrograma.class

# Ejecutar
java MiPrograma        # Ejecuta el bytecode
```

---

### 💪 **CONCEPTO 6: FUERTEMENTE TIPADO**

#### ¿Qué significa "fuertemente tipado"?
Java requiere que declares explícitamente el tipo de cada variable y verifica la compatibilidad de tipos en **tiempo de compilación**.

#### Ejemplos:
```java
// ✅ CORRECTO - Declaración explícita:
int numero = 42;
String texto = "Hola";
boolean activo = true;

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

### 🗄️ **CONCEPTO 8: POOL DE STRINGS (STRING INTERNING)**

#### ¿Qué es el pool de strings?
Java optimiza el uso de memoria almacenando strings literales en un área especial llamada **string pool** o **string intern pool**.

#### Funcionamiento:
```java
String str1 = "Hola";           // Se crea en el pool
String str2 = "Hola";           // Reutiliza del pool
String str3 = new String("Hola"); // Crea NUEVO objeto en heap

System.out.println(str1 == str2);  // true (misma referencia)
System.out.println(str1 == str3);  // false (referencias diferentes)
System.out.println(str1.equals(str3)); // true (mismo contenido)
```

#### Beneficios del pool:
- **Ahorro de memoria**: Strings duplicados se almacenan una sola vez
- **Mejor rendimiento**: Comparaciones de referencias son más rápidas
- **Optimización automática**: JVM gestiona el pool automáticamente

#### Cuándo usar cada forma:
```java
// ✅ PREFERIDO - Usa el pool:
String mensaje = "Hola Mundo";

// ⚠️ EVITAR - Crea objeto innecesario:
String mensaje = new String("Hola Mundo");
```

---

### 💾 **CONCEPTO 9: STACK VS HEAP**

#### Stack (Pila):
**¿Qué se almacena?**
- Variables locales (primitivos)
- Referencias a objetos
- Parámetros de métodos
- Direcciones de retorno de métodos

**Características:**
- **Acceso rápido** (LIFO - Last In, First Out)
- **Tamaño limitado** (StackOverflowError si se llena)
- **Limpieza automática** al salir del scope
- **Thread-specific** (cada hilo tiene su propio stack)

#### Heap (Montículo):
**¿Qué se almacena?**
- Objetos
- Arrays
- Variables de instancia
- Pool de strings

**Características:**
- **Acceso más lento** que el stack
- **Mayor tamaño** que el stack
- **Limpiado por Garbage Collector**
- **Compartido** entre todos los threads

#### Ejemplo visual:
```java
public void metodo() {
    int x = 42;              // x va al STACK
    String str = "Hola";     // str (referencia) va al STACK
                            // "Hola" va al HEAP (pool de strings)
    
    int[] array = {1,2,3};   // array (referencia) va al STACK  
                            // {1,2,3} va al HEAP
}
```

---

### 📦 **CONCEPTO 10: AUTOBOXING Y UNBOXING**

#### ¿Qué es el boxing?
Es la conversión automática entre **tipos primitivos** y sus **wrapper classes** correspondientes.

#### Mapping de tipos:
| Primitivo | Wrapper Class |
|-----------|---------------|
| `byte` | `Byte` |
| `short` | `Short` |
| `int` | `Integer` |
| `long` | `Long` |
| `float` | `Float` |
| `double` | `Double` |
| `boolean` | `Boolean` |
| `char` | `Character` |

#### Autoboxing (primitivo → objeto):
```java
Integer obj = 42;  // Equivale a: Integer obj = Integer.valueOf(42);
```

#### Unboxing (objeto → primitivo):
```java
Integer obj = 42;
int primitivo = obj;  // Equivale a: int primitivo = obj.intValue();
```

#### ⚠️ Cuidado con el Integer Cache:
```java
Integer a = 127, b = 127;  // true (cache -128 a 127)
Integer c = 128, d = 128;  // false (fuera del cache)

System.out.println(a == b);  // true
System.out.println(c == d);  // false ⚠️
System.out.println(c.equals(d)); // true ✅
```

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

| Tipo | Tamaño | Precisión | Rango aproximado | Valor por defecto | Ejemplo |
|------|--------|-----------|------------------|-------------------|---------|
| `float` | 32 bits | ~7 dígitos decimales | ±3.40282347E+38 | `0.0f` | `float precio = 19.99f;` |
| `double` | 64 bits | ~15 dígitos decimales | ±1.7976931348623157E+308 | `0.0d` | `double pi = 3.141592653589793;` |

**Características importantes:**
```java
// Literales flotantes
float f1 = 3.14f;          // Suffix f obligatorio
float f2 = 3.14F;          // F también válido
double d1 = 3.14;          // Tipo por defecto para decimales
double d2 = 3.14d;         // Suffix d opcional

// Notación científica
double pequeno = 1.23e-4;  // 0.000123
double grande = 1.23e+4;   // 12300.0

// Valores especiales
double positiveInf = Double.POSITIVE_INFINITY;
double negativeInf = Double.NEGATIVE_INFINITY;
double notANumber = Double.NaN;

// Verificaciones
if (Double.isInfinite(positiveInf)) { ... }
if (Double.isNaN(notANumber)) { ... }
```

##### **3. TIPO BOOLEANO (1 tipo):**

| Tipo | Tamaño | Valores | Valor por defecto | Ejemplo |
|------|--------|---------|-------------------|---------|
| `boolean` | No definido* | `true`, `false` | `false` | `boolean activo = true;` |

**Características únicas de boolean:**
```java
// Solo acepta true/false (NO como en C donde 0 = false, 1 = true)
boolean flag = true;       // ✅ Correcto
boolean otro = false;      // ✅ Correcto

// ❌ ESTOS NO FUNCIONAN:
// boolean malo = 1;       // Error de compilación
// boolean peor = 0;       // Error de compilación
// if (1) { ... }          // Error de compilación

// ✅ USO CORRECTO:
if (flag) { ... }          // Correcto
if (numero > 0) { ... }    // Correcto (expresión boolean)
```

*La especificación Java no define el tamaño exacto de boolean, depende de la JVM.

##### **4. TIPO CARÁCTER (1 tipo):**

| Tipo | Tamaño | Rango | Valor por defecto | Ejemplo |
|------|--------|-------|-------------------|---------|
| `char` | 16 bits | 0 a 65,535 (Unicode UTF-16) | `'\u0000'` | `char letra = 'A';` |

**Características especiales de char:**
```java
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

### 📝 **CONCEPTO 18: REGLAS PARA NOMBRES DE VARIABLES EN JAVA 8**

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

### 📝 **CONCEPTO 15: TIPOS DE COMENTARIOS**

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

### ⚠️ **CONCEPTO 16: PASO DE PARÁMETROS**

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

### 🚨 **CONCEPTO 17: PECULIARIDADES Y DIFERENCIAS**

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
