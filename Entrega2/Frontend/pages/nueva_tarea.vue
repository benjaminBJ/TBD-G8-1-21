<template>
    <v-container>
    <div class="home">
        <h1>Ingresar Nueva Tarea</h1>
        <br>
        <div>
        <h3>Seleccione la Emergencia.</h3>
        <v-form v-model="valid">
            <v-select
            v-model="select"
            :items="emergencias"
            item-text="nombre"
            label="Select"
            persistent-hint
            return-object
            single-line
            
            ></v-select>
            <v-btn
                color="blue lighten-1"
                class="mr-4"
                @click="clearMarkers(), getPoints(mymap)"
                
                >
                Mostrar Tareas
            </v-btn>
            <v-container>
            <v-row>
                <v-col
                >
                <v-text-field
                    v-model="taskName"
                    :rules="nameRules"
                    :counter="100"
                    label="Nombre Tarea"
                    required
                ></v-text-field>
                </v-col>

                <v-col
                >
                <v-text-field
                    v-model="description"
                    :rules="descripRules"
                    :counter="400"
                    label="Descripción"
                    required
                ></v-text-field>
                </v-col>
                
                <v-col
                >
                <v-text-field
                    v-model="voluntariosReq"
                    :rules="voluntariosRules"
                    :counter="3"
                    label="Voluntarios Requeridos"
                    required
                ></v-text-field>
                </v-col>

            </v-row>
            </v-container>
        </v-form>
        <v-btn color="blue lighten-1" class="mr-4" @click="createPoint">Crear</v-btn>
        </div>
        <br>
        <h3>Ingrese la ubicación de la Emergencia:</h3>
        {{point}}
        <br>
        <div>{{message}}</div>
        <div id="mapid"></div>
    </div>
    </v-container>
</template>
<script>
//Importaciones
import 'leaflet/dist/leaflet'; //librería leaflet
import 'leaflet/dist/leaflet.css'; //css leaflet
var icon = require('leaflet/dist/images/marker-icon.png'); //ícono de marcadores
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
          options: {iconSize:[25, 41], iconAnchor:[12, 41], popupAnchor: [-3, -41]}
      });
var myIcon = new LeafIcon({iconUrl: icon});

var today = new Date();
//librería axios
import axios from 'axios';
export default {
  name: 'Home',
  data:function(){
    return{
      marcada: null,
      select: { nombre: 'Terremoto', id_tarea: '0', id: '0' },
      latitude:null, //Datos de nuevo punto
      longitude:null,
      taskName:'',
      emergencias:[], //colección de puntos cargados de la BD
      points:[],
      message:'', 
      mymap:null, //objeto de mapa(DIV)
      fecha: today,
      //FORMULARIO
      valid: false,
      description: '',
      nameRules: [
        v => !!v || 'Nombre es requerido',
        v => v.length <= 100 || 'Nombre debe contener menos de 100 caracteres',
      ],
      descripRules: [
        v => !!v || 'Descripción es requerida',
        v => v.length <= 400 || 'Descripción debe contener menos de 400 caracteres',
      ],
      voluntariosReq: null,
      voluntariosRules: [
        v => !!v || 'Número de voluntarios es requerido',
        v => v > 0 || 'Número de voluntarios debe ser mayor a 0',
        v => v < 100 || 'Número de voluntarios debe ser menor a 100',
      ],
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

      let newPoint2 ={
        nombre: this.taskName,
        descrip: this.description,
        vol_requeridos: this.voluntariosReq,
        id_emergencia: this.select.id,
        finicio: this.fecha,
        id_estado: 3,
        latitude: this.latitude,
        longitude: this.longitude
      }
      
      try {
        //se llama el servicio para crear un punto perro 
        let response = await axios.post('http://localhost:8080/tareas/create' ,newPoint2);
        //let response = await axios.post('http://localhost:8080/dogs/create' ,newPoint);
        console.log('response', response.data);
        let id = response.data.id;
        this.message = `${this.taskName} fue creado con éxito con id: ${id}`;
        
        //this.message = `${this.name} fue creado con éxito con id: ${id}`;
        //limpiar
        this.taskName = '';
        this.description = '';
        this.voluntariosReq = null;
        this.latitude = null;
        this.longitude = null;
        //this.name = '';
        this.clearMarkers(this.mymap);
        this.getPoints(this.mymap)

      } catch (error) {
       console.log('error', error); 
       this.message = 'Ocurrió un error'
      }
    },
    async getEmergency(){
      try {
        //se llama el servicio para obtener perros 
        //let response = await axios.get('http://localhost:8080/dogs');
        let response = await axios.get('http://localhost:8080/emergencias');
        this.emergencias = response.data;
        console.log(response);
      } catch (error) {
       console.log('error', error); 
      }
      
    },
    async getPoints(map){
      let id = this.select.id;
      try {
        //se llama el servicio para obtener perros 
        //let response = await axios.get('http://localhost:8080/dogs');
        let response = await axios.get('http://localhost:8080/tareas');
        let dataPoints = response.data;
        //Se itera por los puntos
        dataPoints.forEach(point => {
          if(id == point.id_emergencia && point.id_estado == 3){
            //Se crea un marcador por cada punto
            let p =[point.latitude, point.longitude]
            let marker = L.marker(p, {icon:myIcon}) //se define el ícono del marcador
            .bindPopup(point.nombre) //Se agrega un popup con el nombre, atributo de clase
            //.bindPopup(point.name) //Se agrega un popup con el nombre, atributo de clase
            
            //Se agrega a la lista
            this.points.push(marker);
          }
        });

        //Los puntos de la lista se agregan al mapa
        this.points.forEach(p=>{
          p.addTo(map)
        })
      } catch (error) {
       console.log('error', error); 
      }
      
    }
  },
  mounted:function(){
    let _this = this;
    //Se asigna el mapa al elemento con id="mapid"
     this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
    //Se definen los mapas de bits de OSM
    L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
    	attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
    	maxZoom: 20
    }).addTo(this.mymap);

    //Evento click obtiene lat y long actual
    this.mymap.on('click', function(e) {
      _this.latitude = e.latlng.lat;
      _this.longitude =e.latlng.lng;
    });
    this.getEmergency();
    //Se agregan los puntos mediante llamada al servicio
    this.getPoints(this.mymap);
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
  height: 700px; 
  width: 1200px;
}
</style>