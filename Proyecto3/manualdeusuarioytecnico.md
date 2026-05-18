# Proyecto III - Programación III
## Manual de Usuario y Técnico

Nombre del estudiante: Estephanie Lisbeth Esquivel Guillén  
Curso: Programación III  
Fecha: 19/05/2026  

---

# Manual de Usuario

## Introducción
Este programa permite administrar una lista ortogonal de vehículos utilizando Java.  
El usuario puede insertar, buscar y eliminar vehículos desde un menú interactivo en consola.

## Requisitos
- Tener instalado **Java JDK 8 o superior**.
- Ejecutar el programa desde consola o un IDE (IntelliJ, NetBeans, Eclipse).

## Uso del Programa
1. Compilar el programa:
2. Ejecutar el programa:
3. Al iniciar, se muestra un menú con opciones:
- `1` Insertar vehículo
- `2` Buscar vehículo
- `3` Eliminar vehículo
- `4` Salir

4. Para **insertar**, el sistema pedirá:
- Placa
- Color
- Línea
- Modelo
- Propietario

5. Para **buscar**, se puede ingresar cualquier dato (ejemplo: placa, color, modelo, propietario).

6. Para **eliminar**, se debe ingresar la **placa** del vehículo.

## Ejemplo de Ejecución
--- MENU ---

Insertar vehículo

Buscar vehículo

Eliminar vehículo
---

# Manual Técnico

## Lenguaje
- Implementado en **Java**.
- Librerías utilizadas:
  - `java.util.Scanner` para entrada de datos.

## Estructura del Código
- **Clase Nodo**: Representa cada celda de la matriz ortogonal con datos del vehículo y enlaces `derecha` y `abajo`.
- **Clase MatrizOrtogonal**: Contiene métodos para:
  - `insertar()`: agrega un nuevo nodo.
  - `buscar()`: localiza un nodo por cualquier propiedad.
  - `eliminar()`: elimina un nodo por placa.
  - `mostrar()`: imprime todos los nodos.
- **Clase ProyectoIII (Main)**: Contiene el menú interactivo y gestiona la interacción con el usuario.

## Funciones Clave
- `Scanner.nextInt()` y `Scanner.nextLine()`: lectura de datos desde consola.  
- `equalsIgnoreCase()`: comparación de cadenas ignorando mayúsculas/minúsculas.  
- `do...while`: ciclo que mantiene el menú activo hasta que el usuario elija salir.  
- `switch`: estructura que ejecuta acciones según la opción seleccionada.  

## Ejecución
1. Compilar el programa:
2. Ejecutar el programa:

## Limitaciones
- La eliminación se realiza únicamente por **placa**.  
- La búsqueda puede hacerse por cualquier propiedad.  
- El programa está diseñado para ejecutarse en consola.  

## Posibles Mejoras
- Implementar almacenamiento en archivo para guardar los vehículos.  
- Extender la matriz ortogonal para manejar filas y columnas completas.  
- Agregar interfaz gráfica para mayor facilidad de uso.  

