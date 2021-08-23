from flask import Flask
from common import *


def create_app():
    _app = Flask(__name__)
    return _app


#CONSTANTE DEL SISTEMA
app = create_app()

@app.route('/')
def welcome():
    return "Consultas sobre Base de Datos Distribuida => myId ="+str(myId)+" ,primaryId="+str(primaryId)

from controller import general
from controller import parallelInsert
from controller import parallelDelete
from controller import parallelByPrimary
from controller import parallelByBSP


def run_app():
    app.run(myHost,myPort,debug=True, threaded=True)