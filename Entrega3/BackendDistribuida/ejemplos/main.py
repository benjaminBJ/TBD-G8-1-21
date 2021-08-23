import json
from flask import Flask, request
import requests
import sys
import threading


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


def run_http_get(_url,_params,_id,_resp):
    r = requests.get(url = _url , params = _params)
    d = r.json()
    if d["status"]=="ok" and len(d["content"])>0:
        _resp[_id] = d["content"]

    return

def get_url(server,urlBase):
    addr = server["host"]+":"+str(server["port"])
    return urlBase.replace("ADDR", addr)

def send_to_all(servers,nbrServers,urlBase,params):
        threads = []
        respThreads=[""]*nbrServers
        resp=[]
        for i in range(nbrServers):
            _url = get_url(servers[i],urlBase)
            process = threading.Thread(target=run_http_get, args=(_url,params,i,respThreads))
            threads.append(process)
            process.start()

        for process in threads:
            process.join()

        for i in range(nbrServers):
            if respThreads[i]!="":
                resp=resp+respThreads[i]


        return resp

@app.route('/employs/')
@app.route('/employs/<id>')
def get_employsp(id=None):
    if myId==primaryId:
        urlBase = "http://ADDR/slave/employs/"

        params=id
        if id!=None:
            params={"id":id}

        resp = send_to_all(servers,nbrServers,urlBase,params)

        return {"status":"ok","content":resp}
    else:
        return {"status":"error","content":"debe ejecutar en primaryId="+str(primaryId)}

@app.route('/slave/employs/')
def get_slave_employs():
    id = request.args.get("id")

    resp = [{"id":myPort,"nombre":"luis"}]

    if id!=None and id==str(myPort):
        resp.append({"id":myPort,"nombre":"luis veas"})
    return {"status":"ok","content":resp }


app.run(myHost,myPort, debug=True)
