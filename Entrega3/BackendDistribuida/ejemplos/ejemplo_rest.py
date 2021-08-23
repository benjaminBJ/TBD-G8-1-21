from flask import Flask
from flask import request

app= Flask(__name__)

@app.route('/')
def hello_world():
    return "hola"

@app.route('/articulos/<id>')
def get_articles(id):

    return {"dato":"yo"+str(id),"params":request.query_string}

app.run('0.0.0.0', 5000, debug=True)


###################################################
from flask import Flask
from flask import request
import requests

app= Flask(__name__)

@app.route('/')
def welcome():
    return "Consultas sobre Base de Datos Distribuida"

@app.route('/employs/')
def get_employsp():
    r = requests.get(url = 'http://localhost:5000/slave/employs/', params = "")
    return r.json()

@app.route('/slave/employs/')
def get_slave_employs():

    return {"data":[{"id":1,"nombre":"luis"}]}

app.run('0.0.0.0', 5000, debug=True)

