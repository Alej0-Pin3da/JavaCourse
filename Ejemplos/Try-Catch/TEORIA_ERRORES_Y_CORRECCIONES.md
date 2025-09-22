# 📚 TEORÍA DE ERRORES Y CORRECCIONES EN JAVA

## 🎯 Guía para Principiantes: Try-Catch Explicado Paso a Paso

Este documento explica de manera **simple y clara** cómo manejar errores en Java usando try-catch, con ejemplos prácticos y fáciles de entender.

---

## 🔍 ¿QUÉ ES TRY-CATCH? (EXPLICACIÓN SIMPLE) {#teoria-fundamental}

### 🤔 **¿Por qué necesitamos Try-Catch?**

Imagina que estás cocinando y sigues una receta. A veces pueden ocurrir problemas:
- Se te acabó un ingrediente (archivo no encontrado)
- Se quemó la comida (error de cálculo)
- Se fue la luz (problema de conexión)

**Try-Catch** es como tener un **Plan B** para cuando algo sale mal en tu programa.

### 📝 **Analogía Simple: El Paraguas**

```java
// Es como salir de casa:
try {
    // "Voy a caminar al trabajo sin paraguas"
    caminarAlTrabajo();
} catch (LluviaException e) {
    // "Si llueve, usaré el paraguas"
    usarParaguas();
    caminarAlTrabajo();
}
```

### 🎯 **Definición Básica**

**Try-Catch** es una forma de decirle a Java:
1. **TRY (Intenta)**: "Haz esto..."
2. **CATCH (Atrapa)**: "Si algo sale mal, haz esto otro..."

Es como tener un **plan de emergencia** para cuando las cosas no salen como esperabas.

### 🧩 **Estructura Básica (Las Piezas del Rompecabezas)**

```java
try {
    // 1️⃣ AQUÍ pones el código que PUEDE fallar
    // Ejemplo: leer un archivo, hacer una división, conectarse a internet
    
} catch (TipoDeError e) {
    // 2️⃣ AQUÍ decides qué hacer SI algo sale mal
    // Ejemplo: mostrar mensaje, usar valor por defecto, intentar otra cosa
    
} finally {
    // 3️⃣ AQUÍ pones código que SIEMPRE se ejecuta
    // Ejemplo: cerrar archivos, limpiar memoria
    // (Esta parte es OPCIONAL)
}
```

### 🎭 **Los Diferentes Tipos de Problemas (Excepciones)**

Imagina que los errores en Java son como diferentes tipos de problemas en la vida real:

```java
// 🔢 PROBLEMA: Intentar dividir entre cero
try {
    int resultado = 10 / 0;  // ¡Esto va a fallar!
} catch (ArithmeticException e) {
    System.out.println("¡No puedes dividir entre cero!");
    // Solución: usar un valor por defecto
    int resultado = 0;
}

// 📁 PROBLEMA: Buscar un archivo que no existe
try {
    leerArchivo("archivo_inexistente.txt");
} catch (FileNotFoundException e) {
    System.out.println("El archivo no existe, creando uno nuevo...");
    // Solución: crear el archivo
    crearArchivoNuevo();
}

// 🌐 PROBLEMA: Sin conexión a internet
try {
    descargarDatos();
} catch (IOException e) {
    System.out.println("Sin internet, usando datos guardados...");
    // Solución: usar datos locales
    usarDatosLocales();
}
```

### ⚡ **¿Cómo Funciona? (Paso a Paso)**

```java
public void ejemploSimple() {
    System.out.println("1. Comenzando el programa...");
    
    try {
        System.out.println("2. Intentando algo arriesgado...");
        
        // Si ESTA línea falla, salta directamente al catch
        operacionQuePodriaFallar();
        
        System.out.println("3. ¡Todo salió bien!");
        
    } catch (Exception e) {
        System.out.println("4. ¡Ups! Algo salió mal, pero lo arreglé");
        
    } finally {
        System.out.println("5. Esto SIEMPRE se ejecuta, pase lo que pase");
    }
    
    System.out.println("6. El programa continúa normalmente...");
}
```

**Flujo cuando TODO sale bien:**
```
1 → 2 → 3 → 5 → 6
```

**Flujo cuando algo FALLA:**
```
1 → 2 → 4 → 5 → 6
```

### 🎯 **Analogía del Restaurante**

Imagina que eres un mesero en un restaurante:

```java
public void atenderCliente() {
    try {
        // Intentas servir el plato favorito del cliente
        servirPlatoFavorito();
        
    } catch (IngredienteAgotadoException e) {
        // Si no hay ingredientes, ofreces una alternativa
        System.out.println("Lo siento, ese plato se agotó. ¿Le gustaría probar esto otro?");
        servirPlatoAlternativo();
        
    } catch (CocinaLlenaException e) {
        // Si la cocina está ocupada, pides que espere
        System.out.println("La cocina está ocupada, ¿puede esperar 10 minutos?");
        ponerEnEspera();
        
    } finally {
        // Siempre agradeces al cliente, pase lo que pase
        System.out.println("¡Gracias por visitarnos!");
    }
}
```

### 📚 **Los Tipos de Errores más Comunes (Para Principiantes)**

Imagina los errores como diferentes tipos de problemas cotidianos:

```java
// 🚫 NULLPOINTEREXCEPTION: "No hay nada ahí"
// Como intentar abrir una puerta que no existe
String nombre = null;
try {
    int longitud = nombre.length();  // ¡Error! nombre es null
} catch (NullPointerException e) {
    System.out.println("El nombre está vacío, usando 'Anónimo'");
    nombre = "Anónimo";
}

// 🔢 NUMBERFORMATEXCEPTION: "Eso no es un número"
// Como intentar hacer matemáticas con letras
try {
    int numero = Integer.parseInt("abc");  // ¡Error! "abc" no es número
} catch (NumberFormatException e) {
    System.out.println("Eso no es un número válido, usando 0");
    numero = 0;
}

// 📁 FILENOTFOUNDEXCEPTION: "No encuentro ese archivo"
// Como buscar una foto que no existe en tu teléfono
try {
    leerArchivo("foto_vacaciones.jpg");
} catch (FileNotFoundException e) {
    System.out.println("La foto no existe, usando imagen por defecto");
    mostrarImagenPorDefecto();
}

// ➗ ARITHMETICEXCEPTION: "Error en matemáticas"
// Como intentar dividir una pizza entre 0 personas
try {
    int resultado = 10 / 0;  // ¡Error! No se puede dividir entre 0
} catch (ArithmeticException e) {
    System.out.println("No puedes dividir entre cero, usando 0 como resultado");
    resultado = 0;
}
```

### 🎯 **Reglas Simples para Principiantes**

#### **Regla #1: Nunca Dejes un Catch Vacío**
```java
// ❌ MAL - "Hacer como que no pasó nada"
try {
    hacerAlgo();
} catch (Exception e) {
    // Vacío = el error desaparece y no sabes qué pasó
}

// ✅ BIEN - "Al menos di qué pasó"
try {
    hacerAlgo();
} catch (Exception e) {
    System.out.println("Algo salió mal: " + e.getMessage());
    // O haz algo para arreglar el problema
}
```

#### **Regla #2: Sé Específico con los Errores**
```java
// ❌ MAL - "Atrapar todo sin saber qué"
try {
    leerArchivo();
    dividirNumeros();
} catch (Exception e) {  // Muy genérico
    System.out.println("Error");  // No sabemos cuál
}

// ✅ BIEN - "Maneja cada problema de manera diferente"
try {
    leerArchivo();
    dividirNumeros();
} catch (FileNotFoundException e) {
    System.out.println("El archivo no existe, creando uno nuevo");
    crearArchivo();
} catch (ArithmeticException e) {
    System.out.println("Error en matemáticas, usando valor por defecto");
    usarValorPorDefecto();
}
```

#### **Regla #3: Siempre Informa al Usuario Qué Pasó**
```java
// ❌ MAL - "Usuario no sabe qué pasó"
try {
    enviarEmail();
} catch (Exception e) {
    // Error silencioso
}

// ✅ BIEN - "Usuario sabe qué pasó y qué hacer"
try {
    enviarEmail();
} catch (Exception e) {
    System.out.println("No se pudo enviar el email. Verifica tu conexión a internet.");
    System.out.println("Intenta de nuevo en unos minutos.");
}
```

### � **Ejemplos Prácticos para Entender Mejor**

#### **Ejemplo 1: Calculadora Simple**
```java
public class CalculadoraSimple {
    
    public static void main(String[] args) {
        // Ejemplo: dividir dos números
        dividir(10, 2);  // Esto funcionará
        dividir(10, 0);  // Esto causará error, pero lo manejaremos
    }
    
    public static void dividir(int a, int b) {
        try {
            // Intentamos hacer la división
            int resultado = a / b;
            System.out.println(a + " ÷ " + b + " = " + resultado);
            
        } catch (ArithmeticException e) {
            // Si hay división entre cero, hacemos esto
            System.out.println("¡Error! No puedes dividir " + a + " entre " + b);
            System.out.println("Recuerda: no se puede dividir entre cero");
        }
    }
}

// SALIDA:
// 10 ÷ 2 = 5
// ¡Error! No puedes dividir 10 entre 0
// Recuerda: no se puede dividir entre cero
```

#### **Ejemplo 2: Leer Edad del Usuario**
```java
import java.util.Scanner;

public class LeerEdad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("¿Cuántos años tienes? ");
        String respuesta = scanner.nextLine();
        
        try {
            // Intentamos convertir la respuesta a número
            int edad = Integer.parseInt(respuesta);
            
            if (edad >= 18) {
                System.out.println("Eres mayor de edad (" + edad + " años)");
            } else {
                System.out.println("Eres menor de edad (" + edad + " años)");
            }
            
        } catch (NumberFormatException e) {
            // Si el usuario escribió algo que no es número
            System.out.println("¡Ups! '" + respuesta + "' no es un número válido");
            System.out.println("Por favor escribe solo números, ejemplo: 25");
        }
    }
}

// EJEMPLOS DE USO:
// Usuario escribe "25" → "Eres mayor de edad (25 años)"
// Usuario escribe "abc" → "¡Ups! 'abc' no es un número válido"
```

#### **Ejemplo 3: Buscar Archivo**
```java
import java.io.*;

public class BuscarArchivo {
    
    public static void abrirArchivo(String nombreArchivo) {
        try {
            // Intentamos abrir el archivo
            FileReader archivo = new FileReader(nombreArchivo);
            System.out.println("¡Archivo encontrado! Abriendo " + nombreArchivo);
            
            // Aquí leeríamos el contenido del archivo
            archivo.close();
            
        } catch (FileNotFoundException e) {
            // Si el archivo no existe
            System.out.println("No encontré el archivo: " + nombreArchivo);
            System.out.println("¿Estás seguro de que el nombre es correcto?");
            System.out.println("Verifica que el archivo esté en la carpeta correcta");
            
        } catch (IOException e) {
            // Si hay problemas al leer el archivo
            System.out.println("Hay un problema al leer el archivo");
            System.out.println("Puede que esté dañado o no tengas permisos");
        }
    }
}
```

### � **Cuándo Usar Try-Catch (Guía para Principiantes)**

#### **✅ SÍ uses Try-Catch cuando:**

1. **Trabajas con archivos**
   ```java
   try {
       leerArchivo("datos.txt");
   } catch (FileNotFoundException e) {
       System.out.println("Archivo no encontrado");
   }
   ```

2. **Conviertes texto a números**
   ```java
   try {
       int numero = Integer.parseInt(textoDelUsuario);
   } catch (NumberFormatException e) {
       System.out.println("Eso no es un número");
   }
   ```

3. **Haces operaciones matemáticas arriesgadas**
   ```java
   try {
       int resultado = a / b;
   } catch (ArithmeticException e) {
       System.out.println("No se puede dividir entre cero");
   }
   ```

4. **Te conectas a internet o bases de datos**
   ```java
   try {
       conectarAInternet();
   } catch (IOException e) {
       System.out.println("Sin conexión a internet");
   }
   ```

#### **❌ NO uses Try-Catch para:**

1. **Validaciones normales**
   ```java
   // ❌ MAL
   try {
       if (edad < 0) throw new Exception();
   } catch (Exception e) {
       System.out.println("Edad inválida");
   }
   
   // ✅ MEJOR
   if (edad < 0) {
       System.out.println("Edad no puede ser negativa");
   }
   ```

2. **Control de flujo normal**
   ```java
   // ❌ MAL - usar excepciones para decidir qué hacer
   // ✅ MEJOR - usar if/else normal
   ```

## 📖 TABLA DE CONTENIDOS (Guía Paso a Paso)

1. [🎯 ¿Qué es Try-Catch? (Explicación Simple)](#teoria-fundamental)
2. [🚫 Errores Comunes y Cómo Evitarlos](#errores-comunes)
3. [✅ Mejores Prácticas para Principiantes](#mejores-practicas)
4. [🔧 Ejercicios Prácticos](#ejercicios)
5. [📚 Casos de Estudio Simples](#casos-estudio)

---

## � ERRORES COMUNES Y CÓMO EVITARLOS {#errores-comunes}

### **Error #1: El Catch Vacío (¡El más peligroso!)**

#### 🤔 **¿Qué es?**
Es como **ignorar** que algo salió mal. Es como si tu carro hiciera un ruido extraño y tú simplemente subieras la música para no escucharlo.

```java
// ❌ ¡MUY MAL! - Catch vacío
try {
    int resultado = 10 / 0;  // Esto va a fallar
} catch (Exception e) {
    // Vacío = "Hacer como que no pasó nada"
    // ¡El error desaparece y nunca sabrás qué pasó!
}

// ✅ MUCHO MEJOR - Al menos di qué pasó
try {
    int resultado = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("¡Error! No puedes dividir entre cero");
    System.out.println("Detalles: " + e.getMessage());
    // Ahora sabes que pasó y puedes arreglarlo
}
```

#### 🎯 **¿Por qué es tan malo?**
- **No sabes qué falló**: El error desaparece silenciosamente
- **No puedes arreglar el problema**: Sin información, no puedes solucionarlo
- **Dificulta encontrar bugs**: Es como buscar algo con los ojos cerrados

### **Error #2: Atrapar Demasiado (Exception genérico)**

#### 🤔 **¿Qué es?**
Es como usar una red gigante para pescar cuando solo quieres un tipo específico de pez.

```java
// ❌ MAL - Muy genérico
try {
    leerArchivo("datos.txt");       // Puede fallar de una manera
    int numero = Integer.parseInt("abc");  // Puede fallar de otra manera
} catch (Exception e) {  // ¡Atrapa TODO tipo de errores!
    System.out.println("Algo salió mal");  // ¿Pero qué exactamente?
}

// ✅ MEJOR - Específico para cada problema
try {
    leerArchivo("datos.txt");
    int numero = Integer.parseInt("abc");
    
} catch (FileNotFoundException e) {
    System.out.println("No encontré el archivo datos.txt");
    System.out.println("Verifica que el archivo existe");
    
} catch (NumberFormatException e) {
    System.out.println("'abc' no es un número válido");
    System.out.println("Por favor usa solo números");
}
```

#### 🎯 **¿Por qué es mejor ser específico?**
- **Mensajes más útiles**: El usuario sabe exactamente qué está mal
- **Soluciones diferentes**: Cada problema tiene su propia solución
- **Más fácil de debuggear**: Sabes exactamente dónde buscar el problema

### **Error #3: No Validar Antes de Usar**

#### 🤔 **¿Qué es?**
Es como tratar de escribir con un lápiz sin verificar si tiene punta.

```java
// ❌ MAL - No verificar si existe
String nombre = null;  // Podría venir de una base de datos
try {
    int longitud = nombre.length();  // ¡BOOM! Error porque nombre es null
} catch (NullPointerException e) {
    System.out.println("El nombre está vacío");
}

// ✅ MEJOR - Verificar primero
String nombre = obtenerNombreDeBaseDatos();  // Podría ser null

if (nombre == null || nombre.trim().isEmpty()) {
    System.out.println("No hay nombre disponible, usando 'Anónimo'");
    nombre = "Anónimo";
}

// Ahora es seguro usar el nombre
int longitud = nombre.length();
```

#### 🎯 **Principio Simple**
**"Verificar antes de usar"** - Siempre revisa si las cosas existen antes de usarlas.

### **Error #4: Usar Try-Catch para Lógica Normal**

#### 🤔 **¿Qué es?**
Es como usar un martillo para abrir una puerta cuando tienes la llave.

```java
// ❌ MAL - Usar excepciones para lógica normal
public boolean esEdadValida(int edad) {
    try {
        if (edad < 0 || edad > 150) {
            throw new Exception("Edad inválida");
        }
        return true;
    } catch (Exception e) {
        return false;
    }
}

// ✅ MEJOR - Usar lógica normal (if/else)
public boolean esEdadValida(int edad) {
    if (edad < 0 || edad > 150) {
        System.out.println("La edad debe estar entre 0 y 150 años");
        return false;
    }
    return true;
}
```

---

## ✅ MEJORES PRÁCTICAS PARA PRINCIPIANTES {#mejores-practicas}

### **🎯 Práctica #1: Siempre Da Información Útil**

```java
// ✅ BUENA PRÁCTICA
public void leerArchivoSeguro(String nombreArchivo) {
    try {
        // Intentar leer el archivo
        FileReader archivo = new FileReader(nombreArchivo);
        System.out.println("Archivo leído exitosamente: " + nombreArchivo);
        
    } catch (FileNotFoundException e) {
        // Información útil para el usuario
        System.out.println("❌ No pude encontrar el archivo: " + nombreArchivo);
        System.out.println("💡 Sugerencias:");
        System.out.println("   - Verifica que el nombre sea correcto");
        System.out.println("   - Asegúrate de que el archivo esté en la carpeta correcta");
        System.out.println("   - Revisa que tengas permisos para acceder al archivo");
    }
}
```

### **🎯 Práctica #2: Maneja Cada Error de Manera Específica**

```java
// ✅ BUENA PRÁCTICA - Un plan diferente para cada problema
public void calcularPromedio(String[] numerosTexto) {
    try {
        double suma = 0;
        int cantidad = 0;
        
        for (String numeroTexto : numerosTexto) {
            double numero = Double.parseDouble(numeroTexto);
            suma += numero;
            cantidad++;
        }
        
        double promedio = suma / cantidad;
        System.out.println("El promedio es: " + promedio);
        
    } catch (NumberFormatException e) {
        System.out.println("❌ Hay un valor que no es número");
        System.out.println("💡 Todos los valores deben ser números, ejemplo: 1.5, 2.3, 4.7");
        
    } catch (ArithmeticException e) {
        System.out.println("❌ No puedo calcular promedio sin números");
        System.out.println("💡 Proporciona al menos un número válido");
        
    } catch (NullPointerException e) {
        System.out.println("❌ La lista de números está vacía");
        System.out.println("💡 Proporciona una lista con números");
    }
}
```

### **🎯 Práctica #3: Usar Finally para Limpiar**

```java
// ✅ BUENA PRÁCTICA - Siempre limpia al final
public void trabajarConArchivo(String archivo) {
    FileReader lector = null;
    
    try {
        // Abrir el archivo
        lector = new FileReader(archivo);
        System.out.println("Trabajando con el archivo...");
        // Hacer trabajo con el archivo
        
    } catch (FileNotFoundException e) {
        System.out.println("No encontré el archivo: " + archivo);
        
    } catch (IOException e) {
        System.out.println("Problema leyendo el archivo");
        
    } finally {
        // ESTO SIEMPRE SE EJECUTA - ¡Importante para limpiar!
        if (lector != null) {
            try {
                lector.close();
                System.out.println("Archivo cerrado correctamente");
            } catch (IOException e) {
                System.out.println("Problema cerrando el archivo");
            }
        }
    }
}
```

## 🔧 EJERCICIOS PRÁCTICOS {#ejercicios}

### **💪 Ejercicio 1: Arregla el Catch Vacío**

```java
// ❌ CÓDIGO CON PROBLEMA
public class EjercicioCatchVacio {
    public static void main(String[] args) {
        String numero = "abc";
        
        try {
            int resultado = Integer.parseInt(numero);
            System.out.println("El número es: " + resultado);
        } catch (NumberFormatException e) {
            // Catch vacío - ¡Arréglalo!
        }
    }
}

// ✅ SOLUCIÓN
public class EjercicioCatchVacioSolucion {
    public static void main(String[] args) {
        String numero = "abc";
        
        try {
            int resultado = Integer.parseInt(numero);
            System.out.println("El número es: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: '" + numero + "' no es un número válido");
            System.out.println("💡 Intenta con números como: 123, 456, -789");
            System.out.println("🔧 Usando 0 como valor por defecto");
            int resultado = 0;
        }
    }
}
```

### **💪 Ejercicio 2: Calculadora Segura**

Crea una calculadora que maneje todos los errores posibles:

```java
// ✅ SOLUCIÓN COMPLETA
import java.util.Scanner;

public class CalculadoraSegura {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CALCULADORA SEGURA ===");
        
        try {
            // Pedir primer número
            System.out.print("Ingresa el primer número: ");
            String numero1Texto = scanner.nextLine();
            double numero1 = Double.parseDouble(numero1Texto);
            
            // Pedir operación
            System.out.print("Ingresa la operación (+, -, *, /): ");
            String operacion = scanner.nextLine();
            
            // Pedir segundo número
            System.out.print("Ingresa el segundo número: ");
            String numero2Texto = scanner.nextLine();
            double numero2 = Double.parseDouble(numero2Texto);
            
            // Realizar cálculo
            double resultado = calcular(numero1, numero2, operacion);
            System.out.println("✅ Resultado: " + numero1 + " " + operacion + " " + numero2 + " = " + resultado);
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Solo se permiten números");
            System.out.println("💡 Ejemplos válidos: 123, -456, 78.9");
            
        } catch (ArithmeticException e) {
            System.out.println("❌ Error matemático: " + e.getMessage());
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
            System.out.println("💡 Por favor intenta de nuevo");
        }
    }
    
    public static double calcular(double a, double b, String operacion) {
        switch (operacion) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("No se puede dividir entre cero");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Operación inválida: " + operacion + 
                    ". Use +, -, * o /");
        }
    }
}
```

### **💪 Ejercicio 3: Lector de Archivos Inteligente**

```java
// ✅ SOLUCIÓN CON MÚLTIPLES ESTRATEGIAS
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivosInteligente {
    
    public static void leerArchivo(String nombreArchivo) {
        System.out.println("📁 Intentando leer: " + nombreArchivo);
        
        try {
            // Intentar leer el archivo
            List<String> lineas = leerLineasArchivo(nombreArchivo);
            
            System.out.println("✅ Archivo leído exitosamente");
            System.out.println("📊 Total de líneas: " + lineas.size());
            
            // Mostrar las primeras 3 líneas
            for (int i = 0; i < Math.min(3, lineas.size()); i++) {
                System.out.println("   Línea " + (i+1) + ": " + lineas.get(i));
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("❌ Archivo no encontrado: " + nombreArchivo);
            System.out.println("🔧 Intentando crear archivo por defecto...");
            
            try {
                crearArchivoPorDefecto(nombreArchivo);
                System.out.println("✅ Archivo creado exitosamente");
            } catch (IOException e2) {
                System.out.println("❌ No se pudo crear el archivo: " + e2.getMessage());
            }
            
        } catch (IOException e) {
            System.out.println("❌ Error leyendo archivo: " + e.getMessage());
            System.out.println("💡 Posibles causas:");
            System.out.println("   - El archivo está en uso por otro programa");
            System.out.println("   - No tienes permisos para leer el archivo");
            System.out.println("   - El archivo está dañado");
            
        } catch (SecurityException e) {
            System.out.println("❌ Sin permisos para acceder al archivo");
            System.out.println("💡 Contacta al administrador del sistema");
        }
    }
    
    private static List<String> leerLineasArchivo(String nombreArchivo) throws IOException {
        List<String> lineas = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea);
            }
        }
        
        return lineas;
    }
    
    private static void crearArchivoPorDefecto(String nombreArchivo) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            writer.println("# Archivo creado automáticamente");
            writer.println("# Fecha: " + new java.util.Date());
            writer.println("# Puedes editar este archivo y agregar tu contenido");
            writer.println("");
            writer.println("Línea de ejemplo 1");
            writer.println("Línea de ejemplo 2");
        }
    }
    
    public static void main(String[] args) {
        // Probar con archivo existente
        leerArchivo("datos.txt");
        
        // Probar con archivo que no existe
        leerArchivo("archivo_nuevo.txt");
    }
}
```

---

## 📚 CASOS DE ESTUDIO SIMPLES {#casos-estudio}

### **📋 Caso 1: Sistema de Login Simple**

```java
public class SistemaLogin {
    private static final String USUARIO_CORRECTO = "admin";
    private static final String PASSWORD_CORRECTO = "123456";
    
    public static boolean intentarLogin(String usuario, String password) {
        try {
            // Validar que no sean null
            if (usuario == null || password == null) {
                throw new IllegalArgumentException("Usuario y contraseña no pueden estar vacíos");
            }
            
            // Validar longitud mínima
            if (usuario.trim().length() < 3) {
                throw new IllegalArgumentException("El usuario debe tener al menos 3 caracteres");
            }
            
            if (password.length() < 6) {
                throw new IllegalArgumentException("La contraseña debe tener al menos 6 caracteres");
            }
            
            // Verificar credenciales
            boolean loginExitoso = usuario.equals(USUARIO_CORRECTO) && 
                                 password.equals(PASSWORD_CORRECTO);
            
            if (loginExitoso) {
                System.out.println("✅ Login exitoso. ¡Bienvenido " + usuario + "!");
                return true;
            } else {
                System.out.println("❌ Credenciales incorrectas");
                return false;
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error de validación: " + e.getMessage());
            return false;
            
        } catch (Exception e) {
            System.out.println("❌ Error inesperado durante login: " + e.getMessage());
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Casos de prueba
        System.out.println("=== PRUEBAS DE LOGIN ===");
        
        // Caso 1: Login exitoso
        intentarLogin("admin", "123456");
        
        // Caso 2: Usuario muy corto
        intentarLogin("ab", "123456");
        
        // Caso 3: Contraseña muy corta
        intentarLogin("admin", "123");
        
        // Caso 4: Credenciales incorrectas
        intentarLogin("usuario", "password");
        
        // Caso 5: Valores null
        intentarLogin(null, "123456");
    }
}
```

### **📋 Caso 2: Conversor de Temperaturas Robusto**

```java
public class ConversorTemperaturas {
    
    public static void convertirTemperatura(String temperaturaTexto, String unidadOrigen, String unidadDestino) {
        try {
            // Validar inputs
            validarInputs(temperaturaTexto, unidadOrigen, unidadDestino);
            
            // Convertir texto a número
            double temperatura = Double.parseDouble(temperaturaTexto.trim());
            
            // Validar rangos físicos
            validarRangosFisicos(temperatura, unidadOrigen);
            
            // Realizar conversión
            double resultado = realizarConversion(temperatura, unidadOrigen, unidadDestino);
            
            // Mostrar resultado
            System.out.printf("🌡️  %.2f°%s = %.2f°%s%n", 
                temperatura, unidadOrigen.toUpperCase(), 
                resultado, unidadDestino.toUpperCase());
            
        } catch (NumberFormatException e) {
            System.out.println("❌ '" + temperaturaTexto + "' no es un número válido");
            System.out.println("💡 Ejemplos: 25, -10, 98.6, 0");
            
        } catch (IllegalArgumentException e) {
            System.out.println("❌ " + e.getMessage());
            
        } catch (ArithmeticException e) {
            System.out.println("❌ Error en cálculo: " + e.getMessage());
            
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
        }
    }
    
    private static void validarInputs(String temp, String origen, String destino) {
        if (temp == null || temp.trim().isEmpty()) {
            throw new IllegalArgumentException("La temperatura no puede estar vacía");
        }
        
        if (origen == null || destino == null) {
            throw new IllegalArgumentException("Las unidades no pueden estar vacías");
        }
        
        String[] unidadesValidas = {"C", "F", "K"};
        boolean origenValido = false, destinoValido = false;
        
        for (String unidad : unidadesValidas) {
            if (unidad.equalsIgnoreCase(origen)) origenValido = true;
            if (unidad.equalsIgnoreCase(destino)) destinoValido = true;
        }
        
        if (!origenValido) {
            throw new IllegalArgumentException("Unidad origen inválida: " + origen + 
                ". Use C (Celsius), F (Fahrenheit) o K (Kelvin)");
        }
        
        if (!destinoValido) {
            throw new IllegalArgumentException("Unidad destino inválida: " + destino + 
                ". Use C (Celsius), F (Fahrenheit) o K (Kelvin)");
        }
    }
    
    private static void validarRangosFisicos(double temp, String unidad) {
        switch (unidad.toUpperCase()) {
            case "C":
                if (temp < -273.15) {
                    throw new IllegalArgumentException("Temperatura imposible: " + temp + "°C " +
                        "(menor que cero absoluto: -273.15°C)");
                }
                break;
            case "F":
                if (temp < -459.67) {
                    throw new IllegalArgumentException("Temperatura imposible: " + temp + "°F " +
                        "(menor que cero absoluto: -459.67°F)");
                }
                break;
            case "K":
                if (temp < 0) {
                    throw new IllegalArgumentException("Temperatura imposible: " + temp + "K " +
                        "(menor que cero absoluto: 0K)");
                }
                break;
        }
    }
    
    private static double realizarConversion(double temp, String origen, String destino) {
        // Si es la misma unidad, no hay conversión
        if (origen.equalsIgnoreCase(destino)) {
            return temp;
        }
        
        // Convertir todo a Celsius primero
        double celsius = temp;
        switch (origen.toUpperCase()) {
            case "F":
                celsius = (temp - 32) * 5.0 / 9.0;
                break;
            case "K":
                celsius = temp - 273.15;
                break;
        }
        
        // Convertir de Celsius a la unidad destino
        switch (destino.toUpperCase()) {
            case "C":
                return celsius;
            case "F":
                return celsius * 9.0 / 5.0 + 32;
            case "K":
                return celsius + 273.15;
            default:
                throw new IllegalArgumentException("Unidad destino no soportada: " + destino);
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== CONVERSOR DE TEMPERATURAS ===");
        
        // Casos de prueba
        convertirTemperatura("25", "C", "F");     // ✅ Debería funcionar
        convertirTemperatura("abc", "C", "F");    // ❌ No es número
        convertirTemperatura("100", "X", "F");    // ❌ Unidad inválida
        convertirTemperatura("-300", "C", "K");   // ❌ Temperatura imposible
        convertirTemperatura("", "C", "F");       // ❌ Temperatura vacía
    }
}
```

---

## 🎯 RESUMEN PARA PRINCIPIANTES

### **📝 Checklist de Buenas Prácticas**

✅ **Nunca dejes un catch vacío**
✅ **Siempre da información útil al usuario**
✅ **Sé específico con los tipos de error que atrapas**
✅ **Valida antes de usar (null checks)**
✅ **Usa finally para limpiar recursos**
✅ **No uses try-catch para lógica normal**

### **🚫 Qué NUNCA debes hacer**

❌ Catch vacío: `catch(Exception e) {}`
❌ Atrapar Exception genérico sin razón
❌ Ignorar errores sin dar información
❌ Usar excepciones para control de flujo normal

### **🎯 Recuerda Siempre**

1. **Try-Catch es tu Plan B** - Para cuando las cosas salen mal
2. **Cada error merece una respuesta específica** - No todos los errores son iguales
3. **El usuario necesita saber qué pasó** - Mensajes claros y útiles
4. **Prevenir es mejor que curar** - Valida antes de usar

¡Con estos conceptos básicos ya puedes escribir código Java más robusto y confiable! 🚀
