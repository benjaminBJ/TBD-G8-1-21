<template>
    <v-container>
      <h1>Buscador de requisitos mas solicitados</h1>
      <br>
      <div>{{point}}
        <!--Modulo para seleccionar emergencia-->
        <v-select
            v-model="select"
            :hint="`${select.nombre}`"
            :items="emergencias"
            item-text="nombre"
            label="Escoja emergencia"
            persistent-hint
            return-object
            single-line
          ></v-select>
          <br>
          <v-text-field
                v-model="busqueda"
                append-icon="mdi-magnify"
                label="Numero de requisitos a mostrar"
            
            
              ></v-text-field>
          <br>
          <v-btn
                color="blue lighten-1"
                class="mr-4"
                @click="emergencia = select, idEmergencia = select.id, getXRequisitos()"
                
              >
                Mostrar
          </v-btn>
          <!--Modulo para seleccionar cuantos requisitos a mostrar-->
        <v-card>
            <v-card-title>
              
              
            </v-card-title>
            <v-data-table
              :headers="headers"
              :items="requisitos"
            
            ></v-data-table>
          </v-card>
      </div>
    
    </v-container>
</template>
<script>
  export default {
    data:()=>( {
      
      busqueda: null,
      headers: [
        {
          text: 'Id requisito',
          align: 'start',
          filterable: true,
          value: 'id',
        },
        { text: 'Descripcion', value: 'descrip' },
        { text: 'Llamado en emergencias', value: 'cant_tareas'},
    
      ],
      desserts: [
        {
          id: 'Frozen Yogurt',
          descrip: 159,
          cant_tareas: 6.0,

        },
        {
          id: 'Ice cream sandwich',
          descrip: 237,
          cant_tareas: 9.0,
        }
      ],
      habilidades: [],
      requisitos: [],
      idRequisito: [],
      emergencia: [],
      emergencias: [],
      idEmergencia: -1,
      select: { nombre: 'Emergencia', id_emergencia: '0'},
      selectedIndex: null
      
    }),
    methods:{
      getEmergencias: async function(){
           try {
               let response = await this.$axios.get('/emergencias');
               this.emergencias  = response.data;
               console.log(response)
               
           } catch (error) {
               console.log('error', error);
           }
       },
       getHabilidad: async function(){
           try {
               let response = await this.$axios.get('/habilidades');
               this.habilidades  = response.data;
               console.log(response)
               
           } catch (error) {
               console.log('error', error);
           }
       },
       //Función asíncrona para consultar los datos
      getIdData: async function(){
          try {
              let response = await this.$axios.get("/emergencias/"+this.idEmergencia);
              this.emergencia  = response.data;
              console.log(response)
          } catch (error) {
              console.log('error', error);
          }
      },
      
      forEach: async function(){

      },
      //Función asíncrona para consultar los datos
      getXRequisitos: async function(){
          try {
              let response = await this.$axios.get('/habilidades/'+this.idEmergencia+'/'+this.busqueda);
              this.requisitos  = response.data;
              console.log(response)
              
          } catch (error) {
              console.log('error', error);
          }
      }
    },
    created:function(){
      this.getEmergencias();
      this.getXRequisitos();
      this.getIdData();
      
    
       
    }
       
}

</script>
<style>

</style>