conn = Mongo("localhost");
db = conn.getDB("voluntariado");
db.dropDatabase();

//Crear colecciones
db.createCollection("emergencias", {
    validator:{
        $jsonSchema: {
            bsonType: "object",
            required: [ "nombre", "descrip", "finicio", "ffin"],
            properties: {

                nombre: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"
                },
                descrip: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"   
                },
                finicio: {
                    bsonType: "string",
                    description: "debe ser una string y es requerido"
                },
                ffin: {
                    bsonType: "string",
                    description: "debe ser una string y es requerido"    
                }, 
            } 
        }
    }
});

db.createCollection("voluntarios", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nombre","rut","email","telefono"],
            properties: {
                nombre: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"
                },
                rut: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"
                },
                email: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"
                },
                telefono: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"
                }
            } 
        }
    }
});

db.createCollection("tareas", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            required: ["nombre","descrip","vol_requeridos","finicio","emergencia"],
            properties: {
                nombre: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"
                },
                descrip: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido"   
                },
                vol_requeridos: {
                    bsonType: "int",
                    description: "debe ser un entero y es requerido"
                },
                finicio: {
                    bsonType: "string",
                    description: "debe ser una fecha y es requerido"
                },
                ffin: {
                    bsonType: "null",
                    description: "debe ser una fecha"    
                },
                emergencia: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido" 
                }
            }
        }   
    }
});


db.createCollection("vol_habilidad", {
    validator: {
        $jsonSchema: {
            bsonType: "object",
            
            required: ["voluntario","habilidad"],
            properties: {

                voluntario: {
                    bsonType: "string",
                    description: "debe ser un id de objeto y es requerido"
                },
                habilidad: {
                    bsonType: "string",
                    description: "debe ser un string y es requerido" 
                }

            }
            
        }   
    }
});




//Insertar elementos

db.emergencias.insertMany( [
    { nombre:'Terremoto', 
      descrip:'Sismo de mediana a alta magnitud en las cercanias', 
      finicio:'2021-05-23', 
      ffin:'2020-05-28'
    },
    { nombre:'Incendio', descrip:'Incendio que cubre varias manzanas a la redonda', finicio:'2021-05-28', ffin:'2020-05-30'},
    { nombre:'Tsunami', descrip:'Alerta Tsunami decretada por la onemi', finicio:'2021-05-23', ffin:'2020-05-26'},
    { nombre:'Erupcion de volcan', descrip:'Erupcion de volcan dentro de la zona', finicio:'2021-06-14', ffin:'2020-06-26'},
    { nombre:'Inundacion', descrip:'Comunidad devastada por una inundacion', finicio:'2021-06-14', ffin:'2020-06-16'}
] );

db.tareas.insertMany( [
    { nombre:'Tarea 1', 
      descrip:'Limpieza de escombros', 
      vol_requeridos:3, 
      finicio:'2021-05-23', ffin:null, 
      emergencia:'Terremoto'
    },
    { nombre:'Tarea 2', descrip:'Manejo de maquinaria', vol_requeridos:4, finicio:'2021-05-23', ffin:null, emergencia:'Terremoto'},
    { nombre:'Tarea 3', descrip:'Busqueda terrestre', vol_requeridos:3, finicio:'2021-05-23', ffin:null, emergencia:'Tsunami'},
    { nombre:'Tarea 4', descrip:'Busqueda de sobrevivientes', vol_requeridos:3, finicio:'2021-05-23', ffin:null, emergencia:'Terremoto'},
    { nombre:'Tarea 5', descrip:'Coordinacion de personal', vol_requeridos:1, finicio:'2021-05-23', ffin:null, emergencia:'Tsunami'},
    { nombre:'Tarea 6', descrip:'Controlar incendios', vol_requeridos:3, finicio:'2021-05-23', ffin:null, emergencia:'Incendio'},
    { nombre:'Tarea 7', descrip:'Preparacion de equipos', vol_requeridos:2, finicio:'2021-05-23', ffin:null, emergencia:'Incendio'},
    { nombre:'Tarea 8', descrip:'Busqueda de supervivientes', vol_requeridos:2, finicio:'2021-05-20', ffin:null, emergencia:'Incendio'},
    { nombre:'Tarea 9', descrip:'Proveer primeros auxilios', vol_requeridos:3, finicio:'2021-05-20', ffin:null, emergencia:'Incendio'},
    { nombre:'Tarea 10', descrip:'Apagar amago de incendio', vol_requeridos:4, finicio:'2021-05-20', ffin:null, emergencia:'Terremoto'},
    { nombre:'Tarea 11', descrip:'Limpieza de escombros', vol_requeridos:1, finicio:'2021-03-14', ffin:null, emergencia:'Inundacion'},
    { nombre:'Tarea 12', descrip:'Busqueda maritima', vol_requeridos:1, finicio:'2021-03-14', ffin:null, emergencia:'Erupcion de volcan'},
    { nombre:'Tarea 13', descrip:'Coordinacion de busqueda maritima', vol_requeridos:1, finicio:'2021-03-14', ffin:null, emergencia:'Inundacion'},
    { nombre:'Tarea 14', descrip:'Coordinacion de recursos', vol_requeridos:1, finicio:'2021-03-14', ffin:null, emergencia:'Erupcion de volcan'},
    { nombre:'Tarea 15', descrip:'Alertar a la poblacion', vol_requeridos:1, finicio:'2021-03-14', ffin:null, emergencia:'Erupcion de volcan'}
    
] )

db.voluntarios.insertMany( [
    { nombre:'Hector Campos', 
      rut:'20467238-5', 
      email:'tbrahim.amin.9630@gmail.com', 
      telefono:'25252655'
    },
    { nombre:'Edgar Ruiz', rut:'10134071-6', email:'jmalik1127c@live.cl', telefono:'11225443'},
    { nombre:'Arturo Garrido', rut:'22420886-3', email:'cfilipe@googleappsmail.com', telefono:'88451111'},
    { nombre:'Dorotea Morales', rut:'8190374-3', email:'t4roka@hotmail.cl', telefono:'25202222'},
    { nombre:'Asunción Moreno', rut:'20595637-9', email:'npetq@gmail.com', telefono:'65565221'},
    { nombre:'Reinaldo Mendez', rut:'9822228-6', email:'pmeera.meen@hotmail.cl', telefono:'85545451'},
    { nombre:'Raul Suarez', rut:'16267818-3', email:'zasdl593@dtecet.com', telefono:'12125414'},
    { nombre:'Juan Ferrer', rut:'12339396-1', email:'4achraf_2000@dunsoi.com', telefono:'14526385'},
    { nombre:'Fermin Pascual', rut:'12659418-6', email:'jhamalogo@webmhouse.com', telefono:'25112441'},
    { nombre:'Alberto Esteban', rut:'18864964-5', email:'zalooshalsmawi9@rackabzar.com', telefono:'55212332'},
    { nombre:'Simón Perez', rut:'24936172-0', email:'rbruno.b@poki.us', telefono:'85554411'},
    { nombre:'Marina Mora', rut:'6826443-k', email:'isubin@audiophileusa.net', telefono:'66332214'},
    { nombre:'Almudena Hidalgo', rut:'15652736-k', email:'0moham@rifo.ru', telefono:'65252515'},
    { nombre:'Manuela Ruiz', rut:'17053702-5', email:'9rbnm@horizen.cf', telefono:'78452102'},
    { nombre:'Cirino Gutierrez', rut:'18186122-3', email:'urehammansourrh@tubidu.com', telefono:'56322412'},
    { nombre:'Rufo Jiménez', rut:'14885956-6', email:'wzaidjnpn@greendike.com', telefono:'25143214'},
    { nombre:'Ricardo Saez', rut:'15989338-3', email:'2bihnam.attallahr@litrt.site', telefono:'85454512'},
    { nombre:'Ramiro Méndez', rut:'18569098-9', email:'jerdenechuluun_eu@klttec.com', telefono:'62625145'},
    { nombre:'Efren Gomez', rut:'19132415-3', email:'pjoce_fs22w@freeallapp.com', telefono:'25145555'},
    { nombre:'Eulalia Saez', rut:'13340059-1', email:'anaka@cuenmex.com', telefono:'20332000'}
] );


db.vol_habilidad.insertMany( [
    { voluntario:'Hector Campos', 
      habilidad:'Primeros auxilios'
    },
    { voluntario:'Hector Campos', habilidad:'Excavacion'},
    { voluntario:'Hector Campos', habilidad:'Preparacion canina'},
    { voluntario:'Edgar Ruiz', habilidad:'Capacitacion'},
    { voluntario:'Edgar Ruiz', habilidad:'Afinidad con los animales'},
    { voluntario:'Juan Ferrer', habilidad:'Liderazgo'},
    { voluntario:'Eulalia Saez', habilidad:'Creatividad'},
    { voluntario:'Eulalia Saez', habilidad:'Comunicacion efectiva'},
    { voluntario:'Ricardo Saez', habilidad:'Responsabilidad'},
    { voluntario:'Ricardo Saez', habilidad:'Preparacion canina'},
] );
