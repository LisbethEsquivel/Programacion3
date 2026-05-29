# Portada

**Universidad Mariano Gálvez**  
**Facultad de Ingeniería en Sistemas**  
**Curso: Programación III**  
**Proyecto Final – Mini Excel en Java con MySQL**

**Estudiante:** Estephanie  Esquivel
**Fecha:** Mayo 29, 2026
# Proyecto Final Programación 3
## Informe Técnico y Manual de Usuario

---

# Manual de Usuario

### Introducción
El proyecto consiste en una aplicación tipo **mini Excel en Java**, que permite al usuario trabajar con hojas de cálculo básicas. Se pueden ingresar valores numéricos, aplicar fórmulas sencillas y visualizar resultados de manera inmediata. Además, los datos se guardan en una base de datos MySQL para asegurar persistencia.

### Requisitos Previos
- Tener instalado **Java JDK 8 o superior**.
- Contar con **MySQL Server** y **MySQL Workbench**.
- Crear la base de datos `ProyectoProgra3` y la tabla `celdas`.

### Uso del Programa
- Al ejecutar el programa se abre una ventana con pestañas de hojas.
- El usuario puede escribir números directamente en las celdas.
- Las fórmulas disponibles son: `SUMA`, `RESTA`, `MULT`, `DIV`.
- Para aplicar una fórmula se escribe en la barra de fórmulas y se seleccionan las celdas correspondientes.
- Existe un botón que permite visualizar la **tabla hash** con los valores almacenados.

---

# Manual Técnico

### Lenguaje y Librerías
El proyecto está desarrollado en **Java**, utilizando:
- **Swing** para la interfaz gráfica.
- **JDBC** para la conexión con MySQL.

### Arquitectura
- **Libro**: administra las hojas.
- **Hoja**: contiene las celdas.
- **Celda**: almacena valor y fórmula.
- **HojaVista**: interfaz gráfica con pestañas y barra de fórmulas.
- **HojaControlador**: gestiona la lógica, interpreta fórmulas y guarda datos en la base.
- **ConexionBD**: establece la conexión con MySQL.

### Ejecución del Proyecto
1. Compilar el código fuente con `javac`.
2. Ejecutar la clase principal con `java Main`.
3. El sistema abrirá la interfaz gráfica con las hojas disponibles.

### Funcionalidades
- Ingreso de valores numéricos en celdas.
- Aplicación de fórmulas básicas.
- Almacenamiento automático en la base de datos.
- Visualización de tabla hash para análisis de valores.

### Limitaciones
- Solo admite valores numéricos.
- Las fórmulas deben escribirse en formato estándar (`=SUMA(A1,B1)`).
- No se manejan errores avanzados como división entre cero.

### Posibles Mejoras
- Incorporar más funciones matemáticas.
- Exportar datos a formatos externos como Excel (`.xlsx`).
- Mejorar la interfaz gráfica con estilos y colores.

---



