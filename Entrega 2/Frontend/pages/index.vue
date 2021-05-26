<template>
  <v-row justify="center" align="center">
    <v-col cols="1" sm="10" md="100">
      <div class="text-center">
      </div>
      <h1>Bienvenido, Nombre!<img
        src="/add-person-2646097.png"
        alt="Luz azul de emergencia"
        class="ml-5 mt-5"
      ></h1>
      <br>
      <h2>Emergencias activas:</h2>
      <br>
      
      <v-card class="mb-5"
              v-for="(item, i) in items"
              :key="i"
              :to="item.to"
              router
              exact>
        <v-card-title class="headline">
          {{  item.nombre  }}
        </v-card-title>
        <v-card-text>
          
          <p>
            Localización: {{  item.localizacion  }}. 
          </p>
          <p>
            Cantidad de voluntarios necesarios: {{  item.voluntarios  }}.
          </p>
          <p>
            Fecha de inicio: {{  item.fecha  }}.
          </p>
          <p>Descripción: {{  item.historia  }}</p>

          
        </v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn
            color="primary"
            nuxt
            to="/datos"
          >
            Postular
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
      items: [
        {
          nombre: 'Incendio',
          localizacion: 'Rancagua',
          voluntarios: '10',
          fecha: 'mañana',
          historia: 'si'
        },
        {
          nombre: 'derrumbe',
          localizacion: 'A',
          voluntarios: '5',
          fecha: 'hoy',
          historia: 'no'
        },
        {
          nombre: 'Incendio',
          localizacion: 'Stgo',
          voluntarios: '9',
          fecha: 'ayer',
          historia: 'avece'
        },
        {
          nombre: 'Incendio',
          localizacion: 'viña',
          voluntarios: '13',
          fecha: 'nose',
          historia: 'jaj'
        }
      ],
    }
  }
  
}
</script>
