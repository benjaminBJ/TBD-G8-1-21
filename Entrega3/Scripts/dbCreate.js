conn = Mongo("localhost");
db = conn.getDB("voluntariado");
db.dropDatabase();


db.createCollection("emergencias");
db.createCollection("voluntarios");

db.emergencias.insertMany( [

    { "name":"emergencia1", "description" : "hola"},
    { "name":"emergencia2", "description" : "hola"},
    { "name":"emergencia3", "description" : "hola"},
    { "name":"emergencia4", "description" : "hola"},
    
] );

db.voluntarios.insertMany( [

    {  "name":"voluntario1","description" : "hola"},
    {  "name":"voluntario2","description" : "hola"},
    {  "name":"voluntario3","description" : "hola"},
    {  "name":"voluntario4","description" : "hola"},

] );