# TBD-G8-1-21

## Entrega 2:

Instrucciónes para poder ejecutar el proyecto

### Para correr el Frontend:

Requisitos previos: Tener instalado node.js

Para poder correr el Frontend de nuestro aplicativo web, lo primero es asegurar de que en esta misma carpeta se hayan corrido los comandos.

- "npm install"
- "npm i -g @vue/cli"

De esta manera se creará la carpeta node_modules que contiene los componentes necesarios para utilizar las dependencias de vue.

luego para poder visualizar el aplicativo web, se debe correr los comandos.
- "npm run build"
- "npm run dev"

Con este último, en localhost:8081 se puede visualizar el Frontend. (Tener en cuenta que para que las funcionalidades corran, el Backend del proyecto debe estar corriendo).

### Para correr el Backend:

Abrir una consola dentro del directorio de la carpeta Backend, Entrega1\Backend, seguido de eso ejecutar :

- gradlew build
- gradlew bootRun

Para Ejecutar los scripts , construir las Tablas y poblarlas:

Requisitos previos: Tener instalado la base de datos PostgreSQL 

- Ingresar a postgreSQL
    - Cargar los scripts de dbCreate.sql y loadData.sql
    - Similar a la entrega anterior lo mas rapido es abrir una consola en el mismo directorio y ejecutar los comandos
        - Cargar DB y tablas: \i dbCreate.sql
        - Poblar tablas: \i loadData.sql

Enlace de video:

- https://youtu.be/tnRK8tKIBcM


## Entrega 1:

Instrucciónes para poder ejecutar el proyecto

### Para correr el Frontend:

Requisitos previos: Tener instalado node.js

Para poder correr el Frontend de nuestro aplicativo web, lo primero es asegurar de que en esta misma carpeta se hayan corrido los comandos.

- "npm install"
- "npm i -g @vue/cli"

De esta manera se creará la carpeta node_modules que contiene los componentes necesarios para utilizar las dependencias de vue.

luego para poder visualizar el aplicativo web, se debe correr los comandos.
- "npm run build"
- "npm run dev"

Con este último, en localhost:8081 se puede visualizar el Frontend. (Tener en cuenta que para que las funcionalidades corran, el Backend del proyecto debe estar corriendo).

### Para correr el Backend:

Abrir una consola dentro del directorio de la carpeta Backend, Entrega1\Backend, seguido de eso ejecutar :

- gradlew build
- gradlew bootRun

Para Ejecutar los scripts , construir las Tablas y poblarlas:

Requisitos previos: Tener instalado la base de datos PostgreSQL 

- Ingresar a postgreSQL
    - Cargar los scripts de dbCreate.sql y loadData.sql
    - Similar a la entrega anterior lo mas rapido es abrir una consola en el mismo directorio y ejecutar los comandos
        - Cargar DB y tablas: \i dbCreate.sql
        - Poblar tablas: \i loadData.sql

Enlace de video:

- https://youtu.be/Ff_4DyVlbp4


## Pre entrega 1:

Ingresar a postgres

- Cargar DB y tablas: \i 'ruta_archivo/dbCreate.sql'
- Poblar tablas: \i 'ruta_archivo/loadData.sql'
- Correr Sentencias: \i 'ruta_archivo/runStatements.sql'

Enlace de video:

- https://youtu.be/u3CqWT7qSUk
