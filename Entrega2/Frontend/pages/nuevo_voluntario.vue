<template>
    <v-container>
    <div class="home">
        <h1>Ingresar Nuevo Voluntario</h1>
        <br>
        <div>
        <v-form v-model="valid">
            <v-container>
            <v-row>
                <v-col
                >
                <v-text-field
                    v-model="firstname"
                    :rules="nameRules"
                    :counter="100"
                    label="Nombre"
                    required
                ></v-text-field>
                </v-col>

                <v-col
                >
                <v-text-field
                    v-model="rut"
                    :rules="rutRules"
                    :counter="12"
                    label="Rut"
                    required
                ></v-text-field>
                </v-col>

                <v-col
                >
                <v-text-field
                    v-model="email"
                    :rules="emailRules"
                    :counter="100"
                    label="Email"
                    required
                ></v-text-field>
                </v-col>

                <v-col
                >
                <v-text-field
                    v-model="telefono"
                    :rules="telefonoRules"
                    :counter="12"
                    label="Teléfono"
                    required
                ></v-text-field>
                </v-col>

            </v-row>
            </v-container>
        </v-form>
        <v-btn color="blue lighten-1" class="mr-4" @click="createPoint">Crear</v-btn>
        </div>
        <br>
        <h3>Ingrese su ubicación:</h3>
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
      mymap:null, //objeto de mapa(DIV)
      //FORMULARIO
      valid: false,
      firstname: '',
      rut: '',
      email: '',
      telefono: '',
      nameRules: [
        v => !!v || 'Nombre es requerido',
        v => v.length <= 100 || 'Nombre debe contener menos de 100 caracteres',
      ],
      rutRules: [
        v => !!v || 'Rut es requerido',
        v => v.length <= 12 || 'Rut debe contener menos de 12 caracteres',
      ],
      emailRules: [
        v => !!v || 'E-mail es requerido',
        v => /.+@.+/.test(v) || 'E-mail debe ser válido',
      ],
      telefonoRules: [
        v => !!v || 'Teléfono es requerido',
        v => v.length <= 12 || 'Teléfono debe contener menos de 12 caracteres',
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

    successMessage:function(){
      alert("La Emergencia fue guardada correctamente.")
    },

    async createPoint(){ //Crear un nuevo punto
      this.message = '';

      let newPoint ={
        nombre: this.firstname,
        rut: this.rut,
        email: this.email,
        telefono: this.telefono,
        latitude: this.latitude,
        longitude: this.longitude
      }
      
      try {
        //se llama el servicio para crear un nuevo voluntario
        let response = await axios.post('http://localhost:8080/voluntario/create' ,newPoint);
        console.log('response', response.data);
        let id = response.data.id;
        this.message = `${this.firstname} fue creado con éxito con id: ${id}`;
        
        //limpiar
        this.firstname = ' ';
        this.rut = ' ';
        this.email = ' @ ';
        this.telefono = ' ';
        this.clearMarkers(this.mymap);
        this.getPoints(this.mymap);
        this.successMessage();
      }
      catch (error) {
       console.log('error', error); 
       this.message = 'Ocurrió un error'
      }
    },

     async getPoints(map){
      try {
        //se llama el servicio para obtener las emergencias vigentes
        let response = await axios.get('http://localhost:8080/voluntario');
        let dataPoints = response.data;
        //Se itera por los puntos
        dataPoints.forEach(point => {

          //Se crea un marcador por cada punto
          let p =[point.latitude, point.longitude]
          let marker = L.marker(p, {icon:myIcon}) //se define el ícono del marcador
          .bindPopup(point.nombre) //Se agrega un popup con el nombre, atributo de clase
          
          //Se agrega a la lista
          this.points.push(marker);
        });

        //Los puntos de la lista se agregan al mapa
        this.points.forEach(p=>{
          p.addTo(map)
        })
      }
      catch (error) {
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