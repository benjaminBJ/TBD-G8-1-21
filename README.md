# TBD-G8-1-21

//// Entrega 1 :

Instrucciónes para poder ejecutar el proyecto


Para correr el Backend:

1° Abrir una consola dentro del directorio de la carpeta Backend

Entrega1\Backend. Seguido de eso ejecutar

gradlew build y luego gradlew bootRun

Para Ejecutar los scripts y construir las Tablas y poblarlas:

1° Tener instalado la base de datos PostgreSQL ( Se ha ocupado la version 13.x)

Ingresar a postgreSQL

2° Cargar los scripts de dbCreate.sql y loadData.sql

Similar a la entrega anterior lo mas rapido es abrir una consola en el mismo directorio y ejecutar los comandos

Cargar DB y tablas
\i dbCreate.sql
Poblar tablas
\i loadData.sql


//// Pre Entrega 1:

Ingresar a postgres

Cargar DB y tablas
\i 'ruta_archivo/dbCreate.sql'
Poblar tablas
\i 'ruta_archivo/loadData.sql'
Correr Sentencias
\i 'ruta_archivo/runStatements.sql'

Enlace de video

https://youtu.be/u3CqWT7qSUk


# Frontend

# Requisitos previos: Tener instalado node.js.

# Para poder correr el Frontend de nuestro aplicativo web, lo primero es asegurar de que en esta misma carpeta se hayan corrido los comandos
# "npm install"
# "npm i -g @vue/cli"
# De esta manera se creará la carpeta node_modules que contiene los componentes necesarios para utilizar las dependencias de vue.

# luego para poder visualizar el aplicativo web, se debe correr los comandos.
# "npm build"
# "npm run dev"
# y con este último, en localhost:8081 se puede visualizar el Frontend. (Tener en cuenta que para que las funcionalidades corran, el Backend del proyecto debe estar corriendo).