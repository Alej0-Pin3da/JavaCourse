/**
 * CONCEPTO 3: Salida estándar (System.out)
 * 
 * Ejemplo: Casos prácticos y utilidades
 * Demuestra aplicaciones reales de System.out
 */
public class CasosPracticos {
    
    public static void main(String[] args) {
        // Caso 1: Sistema de menú
        mostrarMenu();
        
        // Caso 2: Reporte de ventas
        generarReporteVentas();
        
        // Caso 3: Factura
        generarFactura();
        
        // Caso 4: Progreso de carga simulado
        simularProgreso();
        
        // Caso 5: Debug de variables
        debugVariables();
    }
    
    static void mostrarMenu() {
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║          SISTEMA BANCARIO         ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║ 1. Consultar saldo                ║");
        System.out.println("║ 2. Realizar depósito              ║");
        System.out.println("║ 3. Realizar retiro                ║");
        System.out.println("║ 4. Transferir dinero              ║");
        System.out.println("║ 5. Ver historial                  ║");
        System.out.println("║ 0. Salir                          ║");
        System.out.println("╚═══════════════════════════════════╝");
        System.out.println("Seleccione una opción: ");
        System.out.println();
    }
    
    static void generarReporteVentas() {
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("                  REPORTE DE VENTAS MENSUAL            ");
        System.out.println("                    Marzo 2024                        ");
        System.out.println("═══════════════════════════════════════════════════════");
        
        // Encabezados
        System.out.printf("%-12s | %-20s | %10s | %12s%n", 
                         "FECHA", "PRODUCTO", "CANTIDAD", "TOTAL");
        System.out.println("─────────────┼──────────────────────┼────────────┼─────────────");
        
        // Datos de ejemplo
        System.out.printf("%-12s | %-20s | %10d | $%11.2f%n", 
                         "2024-03-01", "Laptop Dell XPS", 3, 3899.97);
        System.out.printf("%-12s | %-20s | %10d | $%11.2f%n", 
                         "2024-03-02", "Mouse Logitech", 15, 375.00);
        System.out.printf("%-12s | %-20s | %10d | $%11.2f%n", 
                         "2024-03-03", "Teclado Mecánico", 8, 600.00);
        System.out.printf("%-12s | %-20s | %10d | $%11.2f%n", 
                         "2024-03-05", "Monitor 24\"", 5, 1250.00);
        
        System.out.println("─────────────┼──────────────────────┼────────────┼─────────────");
        System.out.printf("%-35s | %10s | $%11.2f%n", 
                         "TOTAL GENERAL", "31", 6124.97);
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println();
    }
    
    static void generarFactura() {
        System.out.println("┌─────────────────────────────────────────────────┐");
        System.out.println("│                 TECNO STORE S.A.                │");
        System.out.println("│              Calle Principal #123              │");
        System.out.println("│          Tel: (555) 123-4567                   │");
        System.out.println("├─────────────────────────────────────────────────┤");
        System.out.printf("│ FACTURA #: %-8d                         │%n", 1001);
        System.out.printf("│ FECHA: %10s                            │%n", "15/03/2024");
        System.out.printf("│ CLIENTE: %-30s       │%n", "Juan Pérez García");
        System.out.println("├─────────────────────────────────────────────────┤");
        System.out.println("│ DESCRIPCIÓN          │ CANT │ PRECIO │  TOTAL  │");
        System.out.println("├──────────────────────┼──────┼────────┼─────────┤");
        System.out.printf("│ %-20s │ %4d │ $%6.2f │ $%7.2f │%n", 
                         "Laptop Gaming", 1, 1299.99, 1299.99);
        System.out.printf("│ %-20s │ %4d │ $%6.2f │ $%7.2f │%n", 
                         "Mouse RGB", 2, 45.50, 91.00);
        System.out.printf("│ %-20s │ %4d │ $%6.2f │ $%7.2f │%n", 
                         "Teclado Mecánico", 1, 120.00, 120.00);
        System.out.println("├──────────────────────┴──────┴────────┼─────────┤");
        System.out.printf("│                        SUBTOTAL: │ $%7.2f │%n", 1510.99);
        System.out.printf("│                        IVA (13%%): │ $%7.2f │%n", 196.43);
        System.out.printf("│                           TOTAL: │ $%7.2f │%n", 1707.42);
        System.out.println("└───────────────────────────────────────┴─────────┘");
        System.out.println("           ¡Gracias por su compra!               ");
        System.out.println();
    }
    
    static void simularProgreso() {
        System.out.println("=== SIMULANDO DESCARGA ===");
        System.out.println("Descargando archivo grande.zip...");
        
        try {
            for (int i = 0; i <= 100; i += 5) {
                // Crear barra de progreso visual
                int barras = i / 2; // 50 caracteres máximo
                StringBuilder progreso = new StringBuilder();
                
                progreso.append("[");
                for (int j = 0; j < 50; j++) {
                    if (j < barras) {
                        progreso.append("█");
                    } else {
                        progreso.append("░");
                    }
                }
                progreso.append("]");
                
                // \r hace que la siguiente salida sobrescriba la línea actual
                System.out.printf("\r%s %3d%% (%d MB / %d MB)", 
                                progreso.toString(), i, i * 10, 1000);
                
                Thread.sleep(200); // Pausa para efecto visual
            }
            
            System.out.println("\n✓ Descarga completada exitosamente!");
        } catch (InterruptedException e) {
            System.out.println("\nDescarga interrumpida.");
        }
        System.out.println();
    }
    
    static void debugVariables() {
        System.out.println("=== DEBUG DE VARIABLES ===");
        
        String usuario = "admin";
        int intentos = 3;
        boolean autenticado = false;
        double saldoCuenta = 1250.75;
        char nivelAcceso = 'A';
        
        // Técnica útil para debug: mostrar nombre y valor
        System.out.println("DEBUG -> usuario: '" + usuario + "'");
        System.out.println("DEBUG -> intentos: " + intentos);
        System.out.println("DEBUG -> autenticado: " + autenticado);
        System.out.println("DEBUG -> saldoCuenta: " + saldoCuenta);
        System.out.println("DEBUG -> nivelAcceso: " + nivelAcceso);
        
        // Formato alternativo para debug
        System.out.printf("DEBUG -> Estado del sistema:%n");
        System.out.printf("  - Usuario: %s%n", usuario);
        System.out.printf("  - Intentos restantes: %d%n", intentos);
        System.out.printf("  - Autenticado: %s%n", autenticado ? "SÍ" : "NO");
        System.out.printf("  - Saldo: $%.2f%n", saldoCuenta);
        System.out.printf("  - Nivel: %c%n", nivelAcceso);
        
        System.out.println();
        System.out.println("=== FIN DE EJEMPLOS PRÁCTICOS ===");
    }
}

/*
CASOS PRÁCTICOS DEMOSTRADOS:

1. MENÚ DE USUARIO
   - Uso de caracteres especiales para bordes
   - Formato consistente y atractivo
   - Clara presentación de opciones

2. REPORTES TABULARES  
   - Alineación de columnas con printf
   - Separadores visuales
   - Totales y subtotales

3. FACTURAS Y DOCUMENTOS
   - Formato profesional
   - Cálculos y presentación de montos
   - Información estructurada

4. BARRAS DE PROGRESO
   - Uso de \r para sobrescribir línea
   - Indicadores visuales con caracteres especiales
   - Actualización en tiempo real

5. DEBUG Y LOGGING
   - Mostrar nombres y valores de variables
   - Formato consistente para debug
   - Información útil para desarrollo

TÉCNICAS ÚTILES:
- \r para sobrescribir la línea actual
- printf para alineación precisa
- Caracteres Unicode para mejores visuales
- Formato consistente para legibilidad
*/
