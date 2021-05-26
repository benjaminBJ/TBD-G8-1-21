<template>
  <v-container class="grey lighten-5">
        <img
            src="/blue-light-2020909_280.png"
            alt="Luz azul de emergencia"
            class="d-flex justify-space-around mb-5"
        >
        <v-row
        v-for="j in justify"
        :key="j"
        :justify="j"
        >
        <v-col
            v-for="k in 2"
            :key="k"
            md="6"
        >
            <v-card
            class="pa-2"
            outlined
            tile
            >
            <v-card
            class="tarea mx-auto"
            max-width="600"
            max-height="600"
            outlined
        >
            
            <v-list-item three-line>
            <v-list-item-content>
                <div class="overline mb-3">
                Estacion Central
                </div>
                <v-list-item-title class="headline mb-1">
                NOMBRE 
                </v-list-item-title>
                <v-list-item-subtitle color="black">Descripcion</v-list-item-subtitle>
                <v-list-item-subtitle>Fecha inicio</v-list-item-subtitle>
                <v-list-item-subtitle>Fecha fin</v-list-item-subtitle>
            </v-list-item-content>
            
            <v-list-item-avatar
                tile
                size="80"
                color="grey"
            ></v-list-item-avatar>
            </v-list-item>

            <v-card-actions class="justify-center">
            <v-btn
                outlined
                rounded
                text
            >
                Cancelar
            </v-btn>
            <v-btn
                outlined
                rounded
                text
            >
                Terminar
            </v-btn>
            </v-card-actions>
        </v-card>
            </v-card>

        </v-col>
    </v-row>
  </v-container>
</template>
<script>
  export default {
    data: () => ({
      justify: [
        'end',
        'end',
        'end'

      ],
    }),
  }
</script>