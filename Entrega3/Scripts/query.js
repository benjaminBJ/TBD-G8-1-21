
conn = Mongo("localhost");
db = conn.getDB("voluntariado");

printjson(db.emergencias.aggregate([
    {
        //Extrae las relaciones 1 a muchos con el campo "foraneo"
        //emergencia en coleccion tareas y lo dejamos en un capo llamado "tareas"
        //dentro de cada emergencia
        $lookup:{
            from:"tareas",
            localField:"nombre",
            foreignField:"emergencia",
            as:"tareas"
        }
        
    },
    //"aplanamos" los arrays con unwind por el campo "tareas"
    {$unwind:'$tareas'},
    
    //Agrupamos para mostrar las tareas de una emergencia
    {$group:
        { _id:{nombre:"$nombre"},
          tareas_emergencia:{
              $addToSet:'$tareas' 
            }  
        },
    }

]));
