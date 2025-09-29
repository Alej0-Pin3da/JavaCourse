# 🚀 Tutorial de Comandos Básicos de GitLab

## 📋 Guía Completa para Principiantes

Este tutorial te enseñará paso a paso cómo usar GitLab desde la línea de comandos para conectarte y trabajar con el repositorio remoto: `http://172.16.206.15/idi/sdm/sdm`

---

## 📖 Tabla de Contenidos

1. [🎯 Configuración Inicial](#-configuración-inicial)
2. [🔗 Conexión al Repositorio](#-conexión-al-repositorio)
3. [📥 Comandos de Descarga](#-comandos-de-descarga)
4. [📝 Comandos de Trabajo Diario](#-comandos-de-trabajo-diario)
5. [📤 Comandos de Subida](#-comandos-de-subida)
6. [🌿 Trabajo con Ramas (Branches)](#-trabajo-con-ramas-branches)
7. [🔄 Comandos de Sincronización](#-comandos-de-sincronización)
8. [🆘 Comandos de Emergencia](#-comandos-de-emergencia)
9. [💡 Mejores Prácticas](#-mejores-prácticas)
10. [🎯 Flujo de Trabajo Completo](#-flujo-de-trabajo-completo)

---

## 🎯 Configuración Inicial

### **Paso 1: Configurar tu identidad en Git**

Antes de empezar, necesitas configurar tu nombre y email (solo haces esto una vez):

```bash
# Configurar tu nombre (aparecerá en los commits)
git config --global user.name "Tu Nombre Completo"

# Configurar tu email
git config --global user.email "tu.email@empresa.com"

# Verificar la configuración
git config --list
```

### **Paso 2: Configurar editor por defecto (opcional)**

```bash
# Para usar VS Code como editor por defecto
git config --global core.editor "code --wait"

# Para usar nano (más simple)
git config --global core.editor "nano"
```

### **Paso 3: Verificar que Git está instalado**

```bash
# Verificar versión de Git
git --version

# Debería mostrar algo como: git version 2.40.0
```

---

## 🔗 Conexión al Repositorio

### **🔧 Método 1: Clonar un repositorio existente (Recomendado para principiantes)**

```bash
# Navegar a la carpeta donde quieres el proyecto
cd Documents
# o
cd C:\Users\tu_usuario\Documents

# Clonar el repositorio desde GitLab
git clone http://172.16.206.15/idi/sdm/sdm.git

# Entrar al directorio del proyecto
cd sdm

# Verificar la conexión
git remote -v
```

**💡 Resultado esperado:**
```
origin  http://172.16.206.15/idi/sdm/sdm.git (fetch)
origin  http://172.16.206.15/idi/sdm/sdm.git (push)
```

### **🔧 Método 2: Conectar un proyecto local existente**

Si ya tienes un proyecto y quieres conectarlo a GitLab:

```bash
# Entrar a tu carpeta del proyecto
cd ruta/a/tu/proyecto

# Inicializar Git (si no está inicializado)
git init

# Agregar el repositorio remoto
git remote add origin http://172.16.206.15/idi/sdm/sdm.git

# Verificar la conexión
git remote -v

# Configurar la rama principal
git branch -M main
```

---

## 📥 Comandos de Descarga

### **📋 Obtener los últimos cambios del servidor**

```bash
# Descargar cambios SIN fusionar (recomendado)
git fetch origin

# Ver qué cambios hay disponibles
git log HEAD..origin/main --oneline

# Descargar Y fusionar automáticamente (¡cuidado!)
git pull origin main
```

### **🔍 Verificar estado antes de descargar**

```bash
# Ver el estado actual
git status

# Ver diferencias con el servidor
git diff HEAD origin/main

# Ver historial de commits remotos
git log origin/main --oneline -10
```

**💡 Tip:** Siempre usa `git fetch` primero para ver qué cambios hay antes de hacer `git pull`.

---

## 📝 Comandos de Trabajo Diario

### **📊 Verificar el estado de tu trabajo**

```bash
# Ver estado general (archivos modificados, nuevos, etc.)
git status

# Ver diferencias detalladas de archivos modificados
git diff

# Ver diferencias de un archivo específico
git diff archivo.java

# Ver historial de commits
git log --oneline -10
```

### **➕ Agregar archivos al área de preparación (staging)**

```bash
# Agregar un archivo específico
git add MiArchivo.java

# Agregar todos los archivos modificados
git add .

# Agregar todos los archivos Java
git add *.java

# Agregar una carpeta completa
git add src/

# Ver qué archivos están en staging
git status
```

### **💾 Hacer commit (guardar cambios)**

```bash
# Commit con mensaje descriptivo
git commit -m "Agregado: nueva funcionalidad de login"

# Commit con mensaje más detallado
git commit -m "Fix: corregido bug en cálculo de impuestos

- Solucionado error de división por cero
- Agregadas validaciones de entrada
- Mejorados mensajes de error"

# Ver el commit recién creado
git log -1
```

**💡 Buenas prácticas para mensajes de commit:**
- **Agregado:** para nuevas funcionalidades
- **Fix:** para corrección de errores
- **Actualizado:** para mejoras en código existente
- **Eliminado:** para código o archivos removidos

---

## 📤 Comandos de Subida

### **🚀 Subir cambios al servidor**

```bash
# Subir commits al repositorio remoto
git push origin main

# Primera vez subiendo una rama nueva
git push -u origin nueva-rama

# Forzar push (¡PELIGROSO! - usar con cuidado)
git push --force origin main
```

### **🔍 Verificar antes de subir**

```bash
# Ver qué commits se van a subir
git log origin/main..HEAD --oneline

# Ver diferencias que se van a subir
git diff origin/main HEAD

# Verificar que no hay conflictos
git status
```

---

## 🌿 Trabajo con Ramas (Branches)

### **📋 Comandos básicos de ramas**

```bash
# Ver todas las ramas
git branch -a

# Crear una nueva rama
git branch nueva-funcionalidad

# Cambiar a una rama
git checkout nueva-funcionalidad

# Crear Y cambiar a una rama nueva (en un comando)
git checkout -b nueva-funcionalidad

# Ver en qué rama estás
git branch
```

### **🔄 Trabajar con ramas**

```bash
# Subir una rama nueva al servidor
git push -u origin nueva-funcionalidad

# Fusionar una rama en main
git checkout main
git merge nueva-funcionalidad

# Eliminar una rama local
git branch -d nueva-funcionalidad

# Eliminar una rama del servidor
git push origin --delete nueva-funcionalidad
```

### **📥 Descargar ramas remotas**

```bash
# Ver ramas remotas disponibles
git branch -r

# Descargar y crear una rama remota localmente
git checkout -b rama-remota origin/rama-remota

# Actualizar lista de ramas remotas
git fetch origin
```

---

## 🔄 Comandos de Sincronización

### **⚡ Mantener tu proyecto actualizado**

```bash
# Flujo recomendado para sincronizar
git fetch origin                    # Descargar cambios
git status                         # Verificar estado
git pull origin main               # Fusionar cambios si es seguro

# O usando rebase (más limpio)
git fetch origin
git rebase origin/main
```

### **🔄 Resolver conflictos**

```bash
# Cuando hay conflictos después de pull/merge
git status                         # Ver archivos en conflicto

# Editar archivos manualmente para resolver conflictos
# Buscar marcas como: <<<<<<< ======= >>>>>>>

# Después de resolver conflictos
git add archivo-resuelto.java
git commit -m "Resuelto: conflicto en archivo-resuelto.java"

# Continuar con rebase si estabas haciendo uno
git rebase --continue
```

**💡 Ejemplo de conflicto:**
```java
<<<<<<< HEAD
String nombre = "versión local";
=======
String nombre = "versión remota";
>>>>>>> origin/main
```

**Resolución:**
```java
String nombre = "versión final combinada";
```

---

## 🆘 Comandos de Emergencia

### **🔙 Deshacer cambios**

```bash
# Deshacer cambios en un archivo (antes de commit)
git checkout archivo.java

# Deshacer TODOS los cambios locales
git reset --hard HEAD

# Deshacer el último commit (pero mantener cambios)
git reset --soft HEAD~1

# Deshacer el último commit completamente
git reset --hard HEAD~1

# Ver historial para saber a dónde volver
git log --oneline -10
```

### **🔍 Investigar problemas**

```bash
# Ver quién modificó cada línea de un archivo
git blame archivo.java

# Ver historial de un archivo específico
git log -p archivo.java

# Buscar en el historial de commits
git log --grep="palabra clave"

# Ver diferencias entre commits
git diff commit1 commit2
```

### **💾 Guardar trabajo temporalmente**

```bash
# Guardar cambios sin hacer commit
git stash

# Ver lista de stash
git stash list

# Recuperar el último stash
git stash pop

# Recuperar un stash específico
git stash apply stash@{0}

# Eliminar un stash
git stash drop stash@{0}
```

---

## 💡 Mejores Prácticas

### **✅ Haz esto SIEMPRE:**

1. **🔍 Verificar estado antes de cualquier operación:**
   ```bash
   git status
   ```

2. **📥 Descargar cambios antes de empezar a trabajar:**
   ```bash
   git fetch origin
   git pull origin main
   ```

3. **💾 Hacer commits frecuentes con mensajes claros:**
   ```bash
   git add .
   git commit -m "Agregado: validación de email en formulario"
   ```

4. **🔄 Subir cambios regularmente:**
   ```bash
   git push origin main
   ```

### **❌ NUNCA hagas esto:**

1. **❌ No hagas `git push --force` a menos que sepas exactamente qué estás haciendo**
2. **❌ No hagas commit de archivos temporales o de configuración personal**
3. **❌ No subas contraseñas o información sensible**
4. **❌ No trabajes directamente en la rama `main` si es un proyecto compartido**

### **📋 Lista de archivos a IGNORAR (.gitignore):**

Crea un archivo `.gitignore` con este contenido:

```gitignore
# Archivos compilados de Java
*.class
*.jar
*.war

# Archivos de IDE
.vscode/
.idea/
*.iml

# Archivos de sistema
.DS_Store
Thumbs.db

# Logs
*.log

# Archivos temporales
*~
*.tmp
*.temp

# Configuración personal
config.properties
```

---

## 🎯 Flujo de Trabajo Completo

### **🌅 Rutina diaria típica:**

```bash
# 1. Comenzar el día - actualizar proyecto
cd ruta/a/tu/proyecto
git status                          # Ver estado
git fetch origin                    # Descargar cambios
git pull origin main                # Fusionar cambios

# 2. Crear rama para nueva funcionalidad
git checkout -b nueva-funcionalidad

# 3. Trabajar en tu código
# ... editar archivos ...

# 4. Revisar cambios
git status                          # Ver qué cambió
git diff                           # Ver diferencias

# 5. Preparar y guardar cambios
git add .                          # Agregar archivos
git commit -m "Agregado: nueva funcionalidad X"

# 6. Subir trabajo
git push -u origin nueva-funcionalidad

# 7. Volver a main y actualizar
git checkout main
git pull origin main

# 8. Fusionar tu trabajo (opcional si usas merge requests)
git merge nueva-funcionalidad
git push origin main

# 9. Limpiar
git branch -d nueva-funcionalidad
```

### **🔄 Flujo con Merge Requests (Recomendado):**

```bash
# 1. Crear y trabajar en rama
git checkout -b mi-nueva-feature
# ... trabajar ...
git add .
git commit -m "Agregado: nueva característica"
git push -u origin mi-nueva-feature

# 2. Ir a GitLab web y crear Merge Request
# 3. Después de aprobación, fusionar desde GitLab
# 4. Actualizar local
git checkout main
git pull origin main
git branch -d mi-nueva-feature
```

---

## 🏆 Comandos de Referencia Rápida

### **📋 Comandos Esenciales:**

| Comando | Descripción |
|---------|-------------|
| `git status` | Ver estado actual |
| `git add .` | Agregar todos los cambios |
| `git commit -m "mensaje"` | Guardar cambios |
| `git push origin main` | Subir al servidor |
| `git pull origin main` | Descargar del servidor |
| `git fetch origin` | Descargar sin fusionar |
| `git branch` | Ver ramas |
| `git checkout rama` | Cambiar de rama |
| `git log --oneline -10` | Ver últimos commits |
| `git diff` | Ver diferencias |

### **📋 Comandos Intermedios:**

| Comando | Descripción |
|---------|-------------|
| `git stash` | Guardar trabajo temporal |
| `git reset --hard HEAD` | Deshacer cambios locales |
| `git rebase origin/main` | Rebasar cambios |
| `git merge rama` | Fusionar rama |
| `git cherry-pick commit` | Aplicar commit específico |
| `git reflog` | Ver historial de referencias |

---

## 🎓 Ejercicios Prácticos

### **💪 Ejercicio 1: Primer contacto**

1. Clona el repositorio:
   ```bash
   git clone http://172.16.206.15/idi/sdm/sdm.git
   cd sdm
   ```

2. Crea un archivo de prueba:
   ```bash
   echo "Hola GitLab" > prueba.txt
   ```

3. Súbelo al repositorio:
   ```bash
   git add prueba.txt
   git commit -m "Agregado: archivo de prueba"
   git push origin main
   ```

### **💪 Ejercicio 2: Trabajo con ramas**

1. Crea una nueva rama:
   ```bash
   git checkout -b mi-primera-rama
   ```

2. Modifica el archivo:
   ```bash
   echo "Trabajo en rama" >> prueba.txt
   ```

3. Guarda y sube los cambios:
   ```bash
   git add prueba.txt
   git commit -m "Actualizado: archivo desde rama"
   git push -u origin mi-primera-rama
   ```

4. Vuelve a main y fusiona:
   ```bash
   git checkout main
   git merge mi-primera-rama
   git push origin main
   ```

### **💪 Ejercicio 3: Simulando conflictos**

1. Modifica el mismo archivo en dos ramas diferentes
2. Intenta fusionarlas
3. Resuelve el conflicto manualmente
4. Completa la fusión

---

## 🆘 Ayuda y Recursos Adicionales

### **📞 ¿Necesitas ayuda?**

```bash
# Ayuda general de Git
git help

# Ayuda para un comando específico
git help push
git help merge

# Versión corta de ayuda
git push --help
```

### **🔗 Enlaces Útiles:**

- **GitLab del proyecto:** http://172.16.206.15/idi/sdm/sdm
- **Documentación oficial de Git:** https://git-scm.com/doc
- **Tutorial interactivo:** https://learngitbranching.js.org/

### **📱 Herramientas Gráficas Recomendadas:**

- **GitKraken:** Cliente gráfico fácil de usar
- **SourceTree:** Gratis y potente
- **VS Code:** Con extensión GitLens
- **IntelliJ IDEA:** Git integrado

---

## 🎯 Resumen Final

### **🏆 Lo más importante que debes recordar:**

1. **Siempre `git status` antes de hacer cualquier cosa**
2. **`git fetch` antes de `git pull`**
3. **Commits pequeños y frecuentes**
4. **Mensajes de commit descriptivos**
5. **Crear ramas para nuevas funcionalidades**
6. **Nunca subas información sensible**

### **🚀 Flujo básico diario:**

```bash
git status          # ¿Qué tengo?
git fetch origin    # ¿Qué hay nuevo?
git pull origin main # Actualizar
# ... trabajar ...
git add .           # Preparar
git commit -m "..."  # Guardar
git push origin main # Subir
```