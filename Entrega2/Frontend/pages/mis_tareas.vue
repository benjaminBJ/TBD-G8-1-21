<template>
  <v-container class="text-center grey lighten-5" >
    <img
      src="/blue-light-2020909_280.png"
      alt="Luz azul de emergencia"
      class="mb-5
       ml-16"
    >
    <v-col class="text-center">
        <!--
        <v-list>
            <v-list-item-title>Cambiar usuario</v-list-item-title>
        </v-list>
        
        
        <v-select ref="recluta">
         <div v-for="(recluta, i) in reclutas" 
         v-bind:key="i">
          <v-option>
            {{ recluta.nombre }}
          </v-option>
        </div>
        </v-select>-->

  
            <h1>Cambiar usuario</h1>
   

       <v-select
          v-model="select"
          :hint="`${select.nombre}`"
          :items="reclutas"
          item-text="nombre"
          label="Select"
          persistent-hint
          return-object
          single-line
        ></v-select>
        <v-btn
              color="blue lighten-1"
              class="mr-4"
              @click="voluntario = select, idVoluntario = select.id, getIdData()"
              
            >
              Cambiar
        </v-btn>
        <br>
      </v-col>
    <br>
    <v-layout class="ml-16" 
    row 
      wrap>
          <v-flex  
              v-for="(tarea,index) in tareas"
                  :key="index">
            <div v-for="(item) in items"
                    :key="item.id"
                    :to="item.to">
                  <div v-if="item.id === tarea.id_tarea && tarea.id_estado === 3">
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
                        UBICACION: {{ item.ubicacion }}.
                        </div>
                        <v-list-item-title class="headline">
                        NOMBRE: {{ item.nombre }}
                        </v-list-item-title>
                        <br><br>
                        <v-list-item-subtitle>Fecha inicio: {{ item.finicio }} </v-list-item-subtitle>
                        <v-list-item-subtitle>Fecha fin:  {{ item.ffin }}</v-list-item-subtitle>
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
                        @click="headers = tarea, headers.id_estado = 2, cancelTask() "
                    >
                        Cancelar
                        
                    </v-btn>
                    <v-btn class="green lighten-2"
                        outlined
                        rounded
                        text
                        @click="idTarea = tarea.id_tarea, finishTask(), getIdData()"
                        >
                        Terminar
                        
                    </v-btn>
                    <v-btn class="blue lighten-1"
                      outlined
                      rounded
                    @click="selectedIndex = index"
                      
                    >
                    Detalles
                    </v-btn>
                    </v-card-actions>
                      <v-expand-transition>
                        <div v-show="index === selectedIndex">
                          <v-divider></v-divider>

                          <v-card-text>
                            DESCRIPCION: {{ item.descrip }}
                          </v-card-text>
                          <v-btn class="mb-5 blue lighten-1"
                            outlined
                            rounded
                            @click="selectedIndex = null"
                          >
                            Cerrar
                          </v-btn>
                        </div>
                      </v-expand-transition>
                      </v-card>
                    </v-card>
                  </div>
            </div>
          </v-flex>
    </v-layout>
  </v-container>
</template>
<script>
  export default {

    data: () => ({
      voluntario: null,
      select: { nombre: 'Usuario', id_tarea: '0', id: '0' },
      selectedIndex: null,
      justify: 'end',
      items: [],
      tareas: [],
      reclutas: [],
      idVoluntario: -1,
      idTarea: -1,
      headers:[],
      
    }),
    methods:{
       //Función asíncrona para consultar los datos
       getTareasData: async function(){
           try {
               let response = await this.$axios.get('/tareas');
               this.items  = response.data;
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       },
        //Función asíncrona para consultar los datos
       getIdData: async function(){
           try {
               let response = await this.$axios.get("/voluntarios_tarea2/"+this.idVoluntario);
               this.tareas  = response.data;
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       },
       getData: async function(){
           try {
               let response = await this.$axios.get('/voluntario');
               this.reclutas  = response.data;
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       },
       finishTask: async function(){
           try {
               let response = await this.$axios.put("/tareas/cerrar_tarea/"+this.idTarea+"/"+this.idVoluntario);
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       },
       cancelTask: async function(){
           try {
               let response = await this.$axios.put("/voluntarios_tarea/up", this.headers);
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       }
   },
   //Función que se ejecuta al cargar el componente
   created:function(){
      this.getData();
      this.getTareasData();
      this.getIdData();
       
    }
  }
</script>

