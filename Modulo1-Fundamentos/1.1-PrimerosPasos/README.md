# 1.1 Primeros Pasos - Repaso de Java

## 📋 Objetivos de esta sección
Al completar esta sección, los programadores con experiencia previa podrán:
- [ ] Identificar las diferencias clave entre Java y otros lenguajes
- [ ] Repasar la sintaxis específica de Java
- [ ] Comprender los tipos de datos primitivos y wrapper classes
- [ ] Dominar las estructuras de control en Java
- [ ] Reconocer las peculiaridades del lenguaje (inmutabilidad, referencias, etc.)

## 📚 Orden de estudio recomendado

1. **`01-HolaMundo.java`** - Comenzar con lo básico y diferencias fundamentales
2. **`02-EstructuraBasica.java`** - Conceptos de memoria y referencias
3. **`03-TiposComentarios.java`** - Buenas prácticas de documentación
4. **`04-RepasoSintaxis.java`** - Repaso completo (archivo principal de esta sección)
5. **`05-VariacionesHelloWorld.java`** - Práctica adicional y refuerzo

## 📁 Archivos de ejemplo incluidos

### 1. `01-HolaMundo.java`
- **Propósito**: Sintaxis básica y diferencias con otros lenguajes
- **Conceptos clave**: 
  - Estructura obligatoria de clase
  - Método `main()` específico
  - Compilación a bytecode

### 2. `02-EstructuraBasica.java`
- **Propósito**: Diferencias conceptuales importantes
- **Conceptos clave**:
  - Variables estáticas vs de instancia
  - Pool de strings vs creación explícita
  - Stack vs Heap
  - Autoboxing/unboxing

### 3. `03-TiposComentarios.java`
- **Propósito**: Documentación y buenas prácticas
- **Conceptos clave**:
  - JavaDoc para documentación automática
  - Etiquetas especiales (TODO, FIXME)
  - Comentarios que el compilador ignora

### 4. `04-RepasoSintaxis.java`
- **Propósito**: Repaso completo de sintaxis fundamental
- **Conceptos clave**:
  - 8 tipos primitivos de Java
  - Wrapper classes y autoboxing
  - Strings inmutables y StringBuilder
  - Estructuras de control (if, switch, loops)
  - Arrays y matrices
  - Peculiaridades específicas de Java

### 5. `05-VariacionesHelloWorld.java`
- **Propósito**: Diferentes enfoques y práctica adicional
- **Conceptos clave**:
  - Variaciones creativas del Hello World
  - Uso de argumentos de línea de comandos
  - Formato avanzado de strings
  - Múltiples métodos en una clase

## 🎯 Ejercicios de repaso sugeridos

### Ejercicio 1: Comparación de lenguajes
Listar 5 diferencias específicas entre Java y tu lenguaje de programación anterior favorito.

### Ejercicio 2: Tipos de datos
Crear un programa que demuestre:
- Overflow en tipos primitivos
- Diferencia entre `==` y `.equals()` en Strings
- Autoboxing y unboxing

### Ejercicio 3: Estructuras de control
Implementar los mismos algoritmos usando:
- for tradicional vs for-each
- if-else vs switch
- while vs do-while

## ⚡ Conceptos clave para recordar

### Diferencias con otros lenguajes:
| Aspecto | Java | Otros lenguajes |
|---------|------|-----------------|
| **Gestión de memoria** | Garbage collection automático | Manual (C/C++) o automático |
| **Tipado** | Fuertemente tipado, estático | Puede ser dinámico |
| **Punteros** | Referencias (sin aritmética) | Punteros explícitos |
| **Compilación** | Bytecode (portable) | Nativo o interpretado |
| **Estructura** | Todo en clases | Funciones globales permitidas |

### Tipos primitivos (8):
- **Enteros**: `byte`, `short`, `int`, `long`
- **Flotantes**: `float`, `double`
- **Otros**: `boolean`, `char`

### Particularidades de Java:
- Strings son **inmutables**
- Arrays son **objetos** con atributo `.length`
- **Autoboxing/unboxing** automático
- **Case-sensitive**
- Paso por **valor** (incluso referencias)

## 🚨 Trampas comunes para programadores experimentados

| Problema | Causa | Solución |
|----------|-------|----------|
| `String == String` da false | Compara referencias | Usar `.equals()` |
| Modificar String en loop es lento | String inmutable | Usar `StringBuilder` |
| `NullPointerException` | Referencias null | Validar antes de usar |
| Array index fuera de rango | Arrays base 0 | Usar `.length - 1` |

## 📝 Diferencias sintácticas importantes

```java
// Java (obligatorio)
public class MiPrograma {
    public static void main(String[] args) {
        // código aquí
    }
}

// vs otros lenguajes que permiten:
// function main() { ... }
// def main(): ...
// int main() { ... }
```

## 🎯 Autoevaluación

- [ ] Puedo explicar por qué todo debe estar en una clase en Java
- [ ] Entiendo la diferencia entre primitivos y objetos
- [ ] Sé cuándo usar StringBuilder vs concatenación simple
- [ ] Comprendo las diferencias entre `==` y `.equals()`
- [ ] Puedo identificar cuándo ocurre autoboxing/unboxing

## ➡️ Siguiente paso
Una vez completado este repaso, continuar con **1.2 Variables y Tipos de Datos** para profundizar en conceptos más avanzados.
