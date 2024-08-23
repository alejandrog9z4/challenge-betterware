# challenge-betterware
# Proyecto Spring Boot - Betteware API

## Descripción del Proyecto

Este proyecto es una aplicación **Spring Boot 3.3.3** construida con **Java 17** que implementa dos funcionalidades clave:

1. **Agrupar Asociados** (`agruparAsociados`): Agrupa las asociadas por distribuidoras en función de los datos proporcionados.
2. **Año con más personas vivas (INEGI)** (`inegi`): Devuelve el primer año en el que hubo más personas vivas, dado un conjunto de intervalos de nacimiento y muerte.

El proyecto utiliza **Gradle** como herramienta de construcción y está preparado para ser ejecutado dentro de un contenedor **Docker**.

## Requisitos Previos

- **Java 17**
- **Spring Boot 3.3.3**
- **Gradle 7+**
- **Docker (opcional para el despliegue en contenedor)**

## Arquitectura y Stack Tecnológico

### Tecnologías Utilizadas:

![Java](https://img.shields.io/badge/Java-17-brightgreen.svg?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.3-brightgreen.svg?style=for-the-badge&logo=spring-boot)
![Gradle](https://img.shields.io/badge/Gradle-7+-brightgreen.svg?style=for-the-badge&logo=gradle)
![Docker](https://img.shields.io/badge/Docker-19+-brightgreen.svg?style=for-the-badge&logo=docker)

---

## Endpoints

### 1. **Agrupar Asociados**

- **URL:** `/betteware/agrupar/asociados`
- **Método:** `POST`
- **Descripción:** Este método recibe un conjunto de asociadas y sus distribuidoras correspondientes, y devuelve un mapa donde cada distribuidora agrupa a sus asociadas.

#### Entrada:

El formato de entrada es un **JSON** donde las claves son los nombres de las asociadas y los valores son las distribuidoras a las que pertenecen. Ejemplo:

```json
{
    "Asoc1": "Dist1",
    "Asoc2": "Dist2",
    "Asoc3": "Dist1",
    "Asoc4": "Dist2"
}
```
#### Salida:
```json
{
    "Dist1": ["Asoc1", "Asoc3"],
    "Dist2": ["Asoc2", "Asoc4"]
}

```
### 2. **INEGI - Año con más personas vivas**

- **URL:** `/betteware/inegi`
- **Método:** `POST`
- **Descripción:** Este método recibe un arreglo bidimensional de intervalos de años de nacimiento y muerte, y devuelve el primer año en el que hubo más personas vivas.

#### Entrada:

El formato de entrada es un **arreglo bidimensional** de enteros, donde cada subarreglo contiene el año de nacimiento y el año de muerte de una persona:

```json
[
    [1951, 2018],
    [1981, 2000],
    [1980, 1982],
    [1983, 1984],
    [2000, 2018]
]
```
#### Salida:

La salida será un **arreglo** con un único valor que indica el primer año en el que hubo más personas vivas:

```json
[1981]
```
## Comó Ejecutar el Proyecto

#### Usando Gradle

### 1. Clona este repositorio:
```bash
git clone https://github.com/alejandrog9z4/challenge-betterware.git
```
### 2. Entra en el directorio del proyecto:
```bash
cd betterware
```
### 3. Construye el proyecto:
```bash
gradle clean
gradle build
```
### 4. Ejecuta la applicacion:
```bash
gradle bootRun
```
La aplicación estará disponible en **http://localhost:8080**

## Usando Docker
 #### Para la ejecucion de docker se debe realizar el paso 3 **(construye el proyecto)**

### 1. Construye la imagen Docker:
```bash
gradle buildDockerImage
```

### 2. Ejecuta el Contenedor de Docker:
```bash
docker run -d -p 8080:8080 challenge-agudinoz-betterware:latest
```
