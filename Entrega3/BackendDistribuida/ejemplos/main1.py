import json
from flask import Flask
import requests
import sys
import numpy as np


print 'Number of arguments:', len(sys.argv), 'arguments.'
print 'Argument List:', str(sys.argv)

configFile = sys.argv[1]

data=""
with open(configFile) as json_file:
    data = json.load(json_file)

print(data)
myId=data["myId"]
primaryId=data["primaryId"]
servers=data["servers"]
myHost=servers[myId]["host"]
myPort=servers[myId]["port"]
myAddr=myHost+":"+str(myPort)
nbrServers = len(servers)

print([myId,myHost,myPort,myAddr])

app= Flask(__name__)

@app.route('/')
def welcome():
    return "Consultas sobre Base de Datos Distribuida => myId ="+str(myId)+" ,primaryId="+str(primaryId)

@app.route('/employs/')
def get_employsp():
    if myId==primaryId:
        resp=[]
        for i in range(nbrServers):
            addr = servers[i]["host"]+":"+str(servers[i]["port"])
            r = requests.get(url = "http://"+addr+"/slave/employs/", params = "")
            d = r.json()

            if len(d["resp"])>0:
                resp=resp + d["resp"]

        return {"resp":resp}
    else:
        return {"error":"debe ejecutar en primaryId="+str(primaryId)}

@app.route('/slave/employs/')
def get_slave_employs():

    return {"resp":[{"id":myPort,"nombre":"luis"}]}


app.run(myHost,myPort, debug=True)
