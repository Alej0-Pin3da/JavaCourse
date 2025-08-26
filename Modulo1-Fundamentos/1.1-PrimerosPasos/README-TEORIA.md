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

### 🎯 **CONCEPTO 14: TIPOS PRIMITIVOS - LOS 8 BÁSICOS**

#### Tipos enteros:
| Tipo | Tamaño | Rango | Ejemplo |
|------|--------|-------|---------|
| `byte` | 8 bits | -128 a 127 | `byte b = 100;` |
| `short` | 16 bits | -32,768 a 32,767 | `short s = 1000;` |
| `int` | 32 bits | -2³¹ a 2³¹-1 | `int i = 42;` |
| `long` | 64 bits | -2⁶³ a 2⁶³-1 | `long l = 42L;` |

#### Tipos de punto flotante:
| Tipo | Tamaño | Precisión | Ejemplo |
|------|--------|-----------|---------|
| `float` | 32 bits | ~7 dígitos | `float f = 3.14f;` |
| `double` | 64 bits | ~15 dígitos | `double d = 3.14159;` |

#### Otros tipos:
| Tipo | Tamaño | Valores | Ejemplo |
|------|--------|---------|---------|
| `boolean` | - | `true`, `false` | `boolean flag = true;` |
| `char` | 16 bits | Unicode 0-65535 | `char c = 'A';` |

#### Notaciones especiales:
```java
// Underscores para legibilidad (Java 7+)
int millon = 1_000_000;
long grande = 9_223_372_036_854_775_807L;

// Diferentes bases numéricas
int decimal = 26;        // Base 10
int octal = 032;         // Base 8 (prefijo 0)
int hexadecimal = 0x1A;  // Base 16 (prefijo 0x)
int binario = 0b11010;   // Base 2 (prefijo 0b, Java 7+)
```

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
