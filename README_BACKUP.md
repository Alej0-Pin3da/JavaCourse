# 📚 1.1 Primeros Pasos - Teoría Completa

## 🎯 Información General

**Sección:** 1.1 Primeros Pasos  
**Módulo:** Fundamentos de Java  
**Duración estimada:** 2-3 horas de estudio  
**Nivel:** Repaso para programadores con experiencia  
**Prerrequisitos:** Conocimientos básicos de programación en cualquier lenguaje  

---

## TL;DR

Breve resumen: esta sección cubre los conceptos esenciales para iniciar en Java 8: cómo escribir y ejecutar un programa, la estructura de clases, tipos primitivos y de referencia, control de flujo y buenas prácticas básicas.

## Objetivos de aprendizaje

- Entender el punto de entrada `main()` y la estructura básica de una clase Java.
- Distinguir entre tipos primitivos y tipos de referencia (wrappers) y cuándo usarlos.
- Conocer diferencias clave (strings inmutables, autoboxing) y errores comunes a evitar.
- Saber compilar y ejecutar ejemplos sencillos con `javac` y `java`.

## Índice (Table of Contents)

- 📖 TEORÍA DETALLADA
    - CONCEPTO 1: El método main() - Punto de entrada
    - CONCEPTO 2: Estructura obligatoria de clases
    - CONCEPTO 3: System.out - Salida estándar
    - CONCEPTO 4: Case sensitivity
    - CONCEPTO 5: Compilación a bytecode
    - CONCEPTO 6: Fuertemente tipado
    - CONCEPTO 7: Variables estáticas vs de instancia
    - CONCEPTO 11: Strings inmutables
    - CONCEPTO 12: Estructuras de control
    - CONCEPTO 13: Arrays en Java
    - CONCEPTO 14: Tipos de datos en Java 8
    - CONCEPTO 15: Reglas para nombres de variables
    - CONCEPTO 16: Tipos de comentarios
    - CONCEPTO 17: Paso de parámetros


## 📖 TEORÍA DETALLADA

### 🔥 CONCEPTO 1: EL MÉTODO MAIN() - PUNTO DE ENTRADA

El método `main()` es el punto de entrada de cualquier aplicación Java ejecutable.

```java
public static void main(String[] args)
```

Explicación breve: `public` permite acceso desde la JVM; `static` evita instanciar la clase; `void` no devuelve valor; `String[] args` recibe argumentos de línea de comandos.

---

### CONCEPTO 2: ESTRUCTURA OBLIGATORIA DE CLASES

Java organiza todo en clases: no hay funciones globales ni código ejecutable fuera de métodos.

Reglas clave:
- Un archivo `.java` puede contener varias clases, solo una `public`.
- La clase `public` debe tener el mismo nombre que el archivo.

---

### CONCEPTO 3: SYSTEM.OUT - SALIDA ESTÁNDAR

Usa `System.out.println`, `System.out.print` y `System.out.printf` para mostrar salida en consola.

---

### CONCEPTO 4: CASE SENSITIVITY

Java distingue mayúsculas y minúsculas; `System` ≠ `system`.

---

### CONCEPTO 5: COMPILACIÓN A BYTECODE

Compila con `javac MiPrograma.java` y ejecuta con `java MiPrograma`.

---

### CONCEPTO 6: FUERTEMENTE TIPADO

Java requiere tipos explícitos; detecta errores en compilación.

---

### CONCEPTO 7: VARIABLES ESTÁTICAS VS DE INSTANCIA

`static` pertenece a la clase; variables de instancia pertenecen a cada objeto.

---

### CONCEPTO 11: STRINGS INMUTABLES

Los Strings son inmutables; para concatenaciones intensivas usa `StringBuilder`.

---

### CONCEPTO 12: ESTRUCTURAS DE CONTROL

`if/else`, `switch` (con tipos permitidos), `for`, `for-each` y uso de `break/continue`.

---

### CONCEPTO 13: ARRAYS EN JAVA

Arrays son objetos con tamaño fijo y atributo `.length`.

---

### CONCEPTO 14: TIPOS DE DATOS EN JAVA 8

Incluye primitivos (byte, short, int, long, float, double, boolean, char) y tipos de referencia (objetos, wrappers).

---

### CONCEPTO 15: REGLAS PARA NOMBRES DE VARIABLES

Convenciones: camelCase para variables/métodos, PascalCase para clases, UPPER_CASE para constantes.

---

### CONCEPTO 16: TIPOS DE COMENTARIOS

`//` para una línea, `/* */` para multilínea y `/** */` para JavaDoc.

---

### CONCEPTO 17: PASO DE PARÁMETROS

Java pasa siempre por valor; las referencias se copian (no hay punteros explícitos).

---

## ▶ Próximos pasos

1. 1.2 Variables y Tipos de Datos
2. 2.1 Operadores
3. 2.2 Estructuras de Control (avanzado)

¡Listo: copia de seguridad creada en `README_BACKUP.md`.
