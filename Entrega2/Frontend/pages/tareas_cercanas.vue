<template>
  <v-container class="text-center grey lighten-5" >

    <v-col class="text-center">
        
      <h1>Listado de tareas cercanas</h1>
       <v-select
          v-model="select"
          :hint="`${select.nombre}`"
          :items="reclutas"
          item-text="nombre"
          label="Usuario"
          persistent-hint
          return-object
          single-line
        ></v-select>
        <br>
        <v-text-field
            v-model="quantity"
            :rules="numberRules"
            :counter="2"
            label="Cantidad de tareas"
            required
        ></v-text-field>
        <v-btn
              color="blue lighten-1"
              class="mr-4"
              @click="voluntario = select, idVoluntario = select.id, getIdData(), getNearbyTasks()"
              
            >
              Mostrar
        </v-btn>
        <br>
      </v-col>
    <br>
    <v-layout class="ml-16" row wrap>
          <br>
          <v-container>
            <h1>Las {{quantity}} tareas más cercanas al voluntario son:</h1>
            <br>
            <v-flex class="d-flex justify-space-around mb-6"
                v-for="(tarea,index) in tareasCercanas"
                    :key="index">
                    <div v-if="tarea.id_estado === 3">
                      <v-card
                      flat
                      class="pa-2"
                      rounded
                      color="blue lighten-3" 
                      style="margin:5px; background-color: transparent;"
                      min-width="510"
                      min-height="120"
                      
                      >
                      <v-card
                      color="blue lighten-5" 
                      class="tarea mx-auto" 
                      min-width="500"
                      min-height="120"
                      outlined
                      rounded 
                      >
                        <h3>{{tarea.nombre}}</h3>
                        DESCRIPCIÓN: {{tarea.descrip}}
                        <br>
                        VOLUNTARIOS REQUERIDOS: {{tarea.vol_requeridos}}
                        <br>
                        FECHA DE INICIO: {{tarea.finicio}}
                        <br>
                        </v-card>
                    </v-card>
                  </div>
            </v-flex>
          </v-container>
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
      tareasCercanas: [],
      idVoluntario: -1,
      idTarea: -1,
      headers:[],
      quantity: '',
      numberRules: [
        v => !!v || 'Debe ingresar una cantidad de emergencias',
        v => v.length <= 2 || 'La cantidad de emergencias no debe ser mayor a 99',
      ],
      
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
       getNearbyTasks: async function(){
           try {
               let response = await this.$axios.get("/voluntario/"+this.idVoluntario+"/"+this.quantity);
               this.tareasCercanas = response.data;
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       },
   },
   //Función que se ejecuta al cargar el componente
   created:function(){
      this.getData();
      this.getTareasData();
      this.getIdData();
      this.getNearbyTasks();
       
    }
  }
</script>

