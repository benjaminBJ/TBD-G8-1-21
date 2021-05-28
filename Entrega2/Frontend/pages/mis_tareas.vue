<template>
  <v-container class="text-center grey lighten-5" >
        <img
            src="/blue-light-2020909_280.png"
            alt="Luz azul de emergencia"
            class="mb-5 ml-16"
        >
        <br>
        <v-layout class="ml-16" 
        row 
        wrap>
          <v-flex  
            v-for="(item, index) in items"
                  :key="item"
                  :to="item.to"
                  
                  
            >
              <br>
              <v-card
              flat
              class="pa-2"
              rounded
              color="blue lighten-3" 
              style="margin:25px; background-color: transparent;"
              min-width="135px"

              >
              <v-card
              color="blue lighten-5" 
              class="tarea mx-auto" 
              max-width="650"
              max-height="500"
              outlined
              rounded 
          >
              
              <v-list-item three-line>
              <v-list-item-content>
                  <div class="overline mb-3">
                  UBICACION: {{ item.localizacion }}
                  </div>
                  <v-list-item-title class="headline">
                  NOMBRE: {{ item.nombre }}
                  </v-list-item-title>
                  <br><br>
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
               @click="item.selectedIndex = index"
                
              >
              Detalles
              </v-btn>
              </v-card-actions>
              <v-expand-transition>
                <div v-show="index === item.selectedIndex">
                  <v-divider></v-divider>

                  <v-card-text>
                    DESCRIPCION: {{ item.historia }}
                  </v-card-text>
                  <v-btn class="mb-5 blue lighten-1"
                    outlined
                    rounded
                    @click="item.selectedIndex = null"
                  >
                    Cerrar
                  </v-btn>
                </div>
              </v-expand-transition>
          </v-card>
              </v-card>

      </v-flex>
    </v-layout>
  </v-container>
</template>
<script>
  export default {
    data: () => ({
      items: [
        {
          selectedIndex: null,
          justify: 'end',
          nombre: 'Incendio',
          localizacion: 'Rancagua',
          voluntarios: '10',
          fecha: 'mañana',
          historia: 'si'
        },
        {
          selectedIndex: null,
          justify: 'end',
          nombre: 'derrumbe',
          localizacion: 'A',
          voluntarios: '5',
          fecha: 'hoy',
          historia: 'no'
        },
        {
          selectedIndex: null,
          justify: 'end',
          nombre: 'Incendio',
          localizacion: 'Stgo',
          voluntarios: '9',
          fecha: 'ayer',
          historia: 'avece'
        },
        {
          selectedIndex: null,
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