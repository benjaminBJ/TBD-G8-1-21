<template>
  <v-app dark>
    <v-navigation-drawer class="cyan lighten-4"
      v-model="drawer"
      :mini-variant="miniVariant"
      :clipped="clipped"
      fixed
      app
    >
      <v-list>
        <v-list-item
          v-for="(item, i) in items"
          :key="i"
          :to="item.to"
          
          router
          exact
        >
          <v-list-item-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title v-text="item.title" />
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar class="cyan darken-1"
      :clipped-left="clipped"
      fixed
      app
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />    
     
      <v-toolbar-title v-text="title" class="font-italic font-weight-medium" />
      <v-spacer />
      <v-btn
        icon
        @click.stop="rightDrawer = !rightDrawer"
      >
        <v-icon>mdi-account</v-icon>
      </v-btn>
    </v-app-bar>
    <v-main>
      <v-container>
        <div>
          <nuxt />
        </div>
      </v-container>
    </v-main>


    <v-navigation-drawer
      v-model="rightDrawer"
      :right="right"
      temporary
      fixed
    >
     
    </v-navigation-drawer>
    <v-footer
      :absolute="!fixed"
      app
    >
      <span>&copy; {{ new Date().getFullYear() }}</span>
    </v-footer>
  </v-app>
</template>

<script>
export default {
  watch: {
    selected_json(newValue) {
      this.$store.commit("setSelectedJson", newValue)
    }
  },
  data () {
    return {
      clipped: true,
      drawer: false,
      fixed: false,
      select: { state: 'Florida', abbr: 'FL' },
      voluntario: [],
      reclutas:[],  
      items: [
        {
          icon: 'mdi-apps',
          title: 'Welcome',
          to: '/'
        },
        {
          icon: 'mdi-chart-bubble',
          title: 'Info Personal',
          to: '/datos'
        },
        {
          icon: 'mdi-plus',
          title: 'Mis Tareas',
          to: '/mis_tareas'
        },
        {
          icon: 'mdi-alert-plus',
          title: 'Nueva Emergencia',
          to: '/nueva_emergencia'
        },
        {
          icon: 'mdi-account-multiple-plus',
          title: 'Nuevo Voluntario',
          to: '/nuevo_voluntario'
        },
        {
          icon: 'mdi-folder-multiple-plus',
          title: 'Nueva Tarea',
          to: '/nueva_tarea'
        },
        {
          icon: 'mdi-plus',
<<<<<<< Updated upstream
          title: 'Requisitos',
          to: '/mas_solicitados'
=======
          title: 'Tareas cercanas',
          to: '/tareas_cercanas'
        },
        {
          icon: 'mdi-plus',
          title: 'Mapas',
          to: '/mapas'
>>>>>>> Stashed changes
        }
      ],
      miniVariant: false,
      right: true,
      rightDrawer: false,
      title: 'Sistema de Reclutas para Emergencias (SRE)'
    }
  },
  methods:{
       //Función asíncrona para consultar los datos
       getData: async function(){
           try {
               let response = await this.$axios.get('/voluntario');
               this.reclutas  = response.data;
               console.log(response)
           } catch (error) {
               console.log('error', error);
           }
       },
       //funcion asincrona para cambiar al usuario
       async cambiar () {
        
      }
   },
   //Función que se ejecuta al cargar el componente
   created:function(){
       this.getData();
    }
}
</script>
