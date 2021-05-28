<template>
  <v-row justify="center" align="center">
    <v-col cols="40" sm="8" md="80">
      <div class="text-center">
      </div>
      <br>
      <v-card>
        <v-card-title class="headline">
          Información Personal
        </v-card-title>
        <v-card-text>
          <p>Nombre: {{ nombre }}.</p>
          <p>Edad: {{ edad }}. </p>
          <p>Especialidad: {{ especialidad}}. </p>
          <p>Ubicación: {{ localizacion}}. </p>
          <p>Tareas Asignadas: {{ tareas }}.</p>
          <p>Tareas Pendientes: {{ pendientes }}</p>
          
          <hr class="my-3">
          
        </v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn
            color="primary"
            nuxt
            to="/datos"
          >
            Actualizar
          </v-btn>

        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>
<script>

export default {
  data () {
    return {
        nombre: 'Juan Perez',
        edad: '34',
        localizacion: 'Rancagua',
        especialidad: 'Contrucción',
        tareas: '5',
        pendientes: '3'
    }
  }
  
}
</script>
