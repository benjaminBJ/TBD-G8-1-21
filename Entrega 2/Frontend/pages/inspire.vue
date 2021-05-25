<template>
  <v-row justify="center" align="center">
    <v-col cols="50" sm="8" md="80">
      <div class="text-center">
      </div>
      <v-card>
        <v-card-title class="headline">
          Información Personal
        </v-card-title>
        <v-card-text>
          <p>Nombre: Juan Perez.</p>
          <p>Edad: 25. </p>
          <p>Especialidad: Construcción. </p>
          <p>Ubicación: Región Metropolitana. </p>
          <p>Tareas Asignadas: 5.</p>
          <p>Tareas Pendientes: 1</p>
          <div class="text-xs-right">
            <em><small>&mdash; John Leider</small></em>
          </div>
          <hr class="my-3">
          <a
            href="https://nuxtjs.org/"
            target="_blank"
            rel="noopener noreferrer"
          >
            Nuxt Documentation
          </a>
          <br>
          <a
            href="https://github.com/nuxt/nuxt.js"
            target="_blank"
            rel="noopener noreferrer"
          >
            Nuxt GitHub
          </a>
        </v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn
            color="primary"
            nuxt
            to="/inspire"
          >
            Continue
          </v-btn>
          <v-spacer />
          <v-btn
            color="primary"
            nuxt
            to="/inspire copy"
          >
            Continue
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>
