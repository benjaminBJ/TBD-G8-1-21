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
      <div id="map-wrap" style="height: 100vh">
 <client-only>
   <l-map :zoom=7 :center="[-33.456,-70.648]">
     <l-tile-layer url="http://{s}.tile.osm.org/{z}/{x}/{y}.png"></l-tile-layer>
     <l-marker :lat-lng="[-33.456,-70.648]"></l-marker>
   </l-map>
 </client-only>
</div>
    <!-- No funciona con nuxt , se de be adaptar
    <div class="home">
    <h1>Ejemplo Mapas</h1>
    <div>{{point}} 
      <input type="text" v-model="name" placeholder="nombre" />
      <button type="button" @click="createPoint">Crear</button>
    </div>
    <div>{{message}}</div>
    <div id="mapid"></div>
  </div>
  -->

      <!--
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
      -->
    </v-col>
  </v-row>
</template>

<script>

import L from 'leaflet';
import { LMap, LTileLayer, LMarker } from 'vue2-leaflet';

//Importaciones
import 'leaflet/dist/leaflet'; //librería leaflet
import 'leaflet/dist/leaflet.css'; //css leaflet
var icon = require('leaflet/dist/images/marker-icon.png'); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
          options: {iconSize:[25, 41], iconAnchor:[12, 41], popupAnchor: [-3, -41]}
      });
var myIcon = new LeafIcon({iconUrl: icon});

//librería axios
import axios from 'axios';
export default {
  name: 'Home',
  data:function(){
    return{
      latitude:null, //Datos de nuevo punto
      longitude:null,
      name:'',
      points:[], //colección de puntos cargados de la BD
      message:'', 
      mymap:null //objeto de mapa(DIV)
    }
  },
  computed:{
    point(){ // función computada para representar el punto seleccionado
      if(this.latitude && this.longitude){
        let lat = this.latitude.toFixed(3);
        let lon = this.longitude.toFixed(3);
        return `(${lat}, ${lon})`;
      }else{
        return '';
      }
    }
  },
  methods:{
    clearMarkers:function(){ //eliminar marcadores
    
      this.points.forEach(p=>{
        this.mymap.removeLayer(p);
      })
      this.points = [];
    },
    async createPoint(){ //Crear un nuevo punto
      this.message = '';

      let newPoint ={
        name: this.name,
        latitude: this.latitude,
        longitude: this.longitude
      }
      
      try {
        let response = await axios.post('http://localhost:3000/dogs' ,newPoint);
        console.log('response', response.data);
        let id = response.data.id;
        this.message = `${this.name} fue creado con éxito con id: ${id}`;
        this.name = '';
        this.clearMarkers(this.mymap);
        this.getPoints(this.mymap)

      } catch (error) {
       console.log('error', error); 
       this.message = 'Ocurrió un error'
      }
    },
    async getPoints(map){
      try {
        //se llama el servicio 
        let response = await axios.get('http://localhost:3000/dogs');
        let dataPoints = response.data;
        //Se itera por los puntos
        dataPoints.forEach(point => {

          //Se crea un marcador por cada punto
          let p =[point.latitude, point.longitude]
          let marker = L.marker(p, {icon:myIcon}) //se define el ícono del marcador
          .bindPopup(point.name) //Se agrega un popup con el nombre
          
          //Se agrega a la lista
          this.points.push(marker);
        });

        //Los puntos de la lista se agregan al mapa
        this.points.forEach(p=>{
          p.addTo(map)
        })
      } catch (error) {
       console.log('error', error); 
      }
      
    },
    mounted:function(){
    let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
     this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    	attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
    	maxZoom: 10
    }).addTo(this.mymap);

    //Evento click obtiene lat y long actual
    this.mymap.on('click', function(e) {
      _this.latitude = e.latlng.lat;
      _this.longitude =e.latlng.lng;
    });

    //Se agregan los puntos mediante llamada al servicio
    this.getPoints(this.mymap);
  },
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


<style>
.home{
  display:flex;
  flex-direction: column;
  align-items: center;
}
/* Estilos necesarios para definir el objeto de mapa */
#mapid { 
  height:400px; 
  width:600px;
}
</style>
