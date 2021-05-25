<template>
  <v-row>
    <v-col class="text-center">
     

      <!-- Comment --> 
      <img
            src="/blue-light-2020909_280.png"
            alt="Luz azul de emergencia"
            class="mb-5"
      >

      <v-divider> </v-divider>
      
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
              Recoleccion de mercaderia
            </v-list-item-title>
            <v-list-item-subtitle>Greyhound divisely hello coldly fonwderfully</v-list-item-subtitle>
          </v-list-item-content>
          
          <v-list-item-avatar
            tile
            size="80"
            color="grey"
          ></v-list-item-avatar>
        </v-list-item>

        <v-card-actions>
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
      <v-container>
          <v-row dense>
            <v-col cols="12">
              <v-card
                color="#385F73"
                dark
              >
                <v-card-title class="text-h5">
                  Unlimited music now
                </v-card-title>

                <v-card-subtitle>Listen to your favorite artists and albums whenever and wherever, online and offline.</v-card-subtitle>

                <v-card-actions>
                  <v-btn text>
                    Listen Now
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-col>

            <v-col
              v-for="(item, i) in items"
              :key="i"
              cols="12"
            >
              <v-card
                :color="item.color"
                dark
              >
                <div class="d-flex flex-no-wrap justify-space-between">
                  <div>
                    <v-card-title
                      class="text-h5"
                      v-text="item.title"
                    ></v-card-title>

                    <v-card-subtitle v-text="item.artist"></v-card-subtitle>

                    <v-card-actions>
                      <v-btn
                        v-if="item.artist === 'Ellie Goulding'"
                        class="ml-2 mt-3"
                        fab
                        icon
                        height="40px"
                        right
                        width="40px"
                      >
                        <v-icon>mdi-play</v-icon>
                      </v-btn>

                      <v-btn
                        v-else
                        class="ml-2 mt-5"
                        outlined
                        rounded
                        small
                      >
                        START RADIO
                      </v-btn>
                    </v-card-actions>
                  </div>

                  <v-avatar
                    class="ma-3"
                    size="125"
                    tile
                  >
                    <v-img :src="item.src"></v-img>
                  </v-avatar>
                </div>
              </v-card>
            </v-col>
          </v-row>
        </v-container>

    </v-col>
  </v-row>
</template>
