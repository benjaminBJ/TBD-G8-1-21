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
            Localización: . 
          </p>
          <p>
            Cantidad de voluntarios necesarios: {{  item.vol_requeridos  }}.
          </p>
          <p>
            Fecha de inicio: {{  item.finicio  }}.
          </p>
          <p>Descripción: {{  item.descrip  }}</p>

          
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
      items: [],
    }
  },
  methods:{
       //Función asíncrona para consultar los datos
       getData: async function(){
           try {
               let response = await this.$axios.get('/tareas');
               this.items  = response.data;
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       }
   },
   //Función que se ejecuta al cargar el componente
   created:function(){
       this.getData();
    }
}

</script>
