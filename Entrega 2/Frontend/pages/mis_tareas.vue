<template>
  <v-container class="grey lighten-5">
        <img
            src="/blue-light-2020909_280.png"
            alt="Luz azul de emergencia"
            class="d-flex justify-space-around mb-5"
        >
        <br>
        <v-row
        v-for="(item, i) in items"
              :key="i"
              :to="item.to"
              router
              exact
        >
        <v-col
            
            md=""
        >
            <v-card
            class="pa-2"
            outlined
            tile
            >
            <v-card
            color="blue lighten-5" 
            class="tarea mx-auto" 
            max-width="600"
            max-height="600"
            outlined 
        >
            
            <v-list-item three-line>
            <v-list-item-content>
                <div class="overline mb-3">
                UBICACION: {{ item.localizacion }}
                </div>
                <v-list-item-title class="headline mb-1">
                NOMBRE: {{ item.nombre }}
                </v-list-item-title>
                
                <v-list-item-subtitle>Fecha inicio: {{ item.fecha }} </v-list-item-subtitle>
                <v-list-item-subtitle>Fecha fin: FECHA</v-list-item-subtitle>
            </v-list-item-content>
            
            <v-list-item-avatar
                tile
                size="80"
                color="grey"
            ></v-list-item-avatar>
            </v-list-item>

            <v-card-actions class="justify-center">
            <v-btn class="red lighten-2"
                outlined
                rounded
                text
                color="black"
            >
                Cancelar
            </v-btn>
            <v-btn class="green lighten-2"
                outlined
                rounded
                text
            >
                Terminar
            </v-btn>
            <v-btn class="blue lighten-1"
              outlined
              rounded
              @click="show = !show"
            >
            Detalles
            </v-btn>
            </v-card-actions>
            <v-expand-transition>
              <div v-show="show">
                <v-divider></v-divider>

                <v-card-text>
                  DESCRIPCION: {{ item.historia }}
                </v-card-text>
              </div>
            </v-expand-transition>
        </v-card>
            </v-card>

        </v-col>
    </v-row>
  </v-container>
</template>
<script>
  export default {
    data: () => ({
      show: false,
      items: [
        {
          show: false,
          justify: 'end',
          nombre: 'Incendio',
          localizacion: 'Rancagua',
          voluntarios: '10',
          fecha: 'mañana',
          historia: 'si'
        },
        {
          show: false,
          justify: 'end',
          nombre: 'derrumbe',
          localizacion: 'A',
          voluntarios: '5',
          fecha: 'hoy',
          historia: 'no'
        },
        {
          show: false,
          justify: 'end',
          nombre: 'Incendio',
          localizacion: 'Stgo',
          voluntarios: '9',
          fecha: 'ayer',
          historia: 'avece'
        },
        {
          show: false,
          justify: 'end',
          nombre: 'Incendio',
          localizacion: 'viña',
          voluntarios: '13',
          fecha: 'nose',
          historia: 'jaj'
        }
      ],
    }),
  }
</script>