# Arquitectura Hexagonal vs Capas

## Quickstart

- Linux/MacOS:

        ./mvnw spring-boot:run

- Windows:

         mvnw.cmd spring-boot:run

## Vídeo en youtube

Este repositorio corresponde a un tutorial de Youtube: https://www.youtube.com/watch?v=BKyiJaYdtSg

## Repositorio didáctico

Este es un repositorio meramente didáctico, para mostrar la diferencia entre la arquitectura hexagonal y 
la arquitectura en capas.

Básicamente consiste en:

- Carpeta `layered`: Implementación de una arquitectura por capas clásica de Spring Boot. Endpoint expuesto tipo `/layer/products/:id`
- Carpeta `hexagonal`: Implementación de una arquitectura hexagonal. Endpoint expuesto tipo `/hexagonal/products/:id`


Cada una funciona como endpoint y arquitectura independientes. Se han englobado en el mismo proyecto para
facilitar su comparación, pero cualquiera de las dos se podría eliminar y el proyecto aún funcionaría.

## Componentes duplicados, proyectos independientes

Se han duplicado algunos objetos y componentes, tanto en la carpeta `hexagonal` como en la carpeta `layered`, (por
ejemplo `ProductEntity.java`) para que cada proyecto quede como independiente y no alterar la estructura de carpetas que
uno esperaría encontrar en cada una de las arquitecturas (esto es, que en hexagonal se encuentre  `ProductEntity.java`
en la carpeta donde deberías encontrarla, y lo mismo para la arquitectura por capas).

Únicamente se han extraído/compartido algunos objetos de tipo utilidad (y la DTO de entrada) en la carpeta `common`.


## Endpoints disponibles

Los endpoints disponibles los puedes consultar en la carpeta `/http-requests/products.http`
Llevan formato para poder disparar las llamadas desde el mismo intelliJ. 

## Tests

En la carpeta de test se incluye una batería de tests unitarios y un test de aceptación.

