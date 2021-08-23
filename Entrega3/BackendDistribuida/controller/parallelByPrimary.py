from flask import jsonify,request, make_response
from common import *
from controller import app, general
from model import *

@app.route('/api/parallelByPrimary/personasInvitadasReunion/')
def select_personasInvitadasReunion():
    if myId == primaryId:
        data = request.json
        urlBase = "http://ADDR/api/parallelByPrimary/slave/personasInvitadasReunion/"
        responses = general.send_to_all("requests.get",servers,nbrServers,urlBase,data)
        print(responses)

        return {"resp":general.union_responses_list(responses)}
    else:
        return "deje ejecutar en el nodo primary"


@app.route('/api/parallelByPrimary/slave/personasInvitadasReunion/',methods=['GET'])
def select_slavePersonasInvitadasReunion():

    resp = select_data("SELECT a.rut, a.nombre"
    +" FROM persona a, invitado b"
    +" where"
    +" a.rut=b.rut"
    +" group by a.rut, a.nombre",dbConnConfig)

    print (["select_slavePersonasInvitadasReunion",myId,resp])
    return {"resp" : resp, "server":myId }


@app.route('/api/parallelByPrimary/personasPorReunion/')
def select_personasPorReunion():
    if myId == primaryId:
        data = request.json

        urlBase = "http://ADDR/api/parallelByPrimary/slave/personasPorReunion-paso1/"
        responses = general.send_to_all("requests.get",servers,nbrServers,urlBase,data)
        tmpTableReuniones = general.union_responses_list(responses)

        urlBase = "http://ADDR/api/parallelByPrimary/slave/personasPorReunion-paso2/"
        responses = general.send_to_all("requests.get",servers,nbrServers,urlBase,data)
        tmpTableSalas = general.union_responses_list(responses)

        tempTable = general.join_tables(tmpTableReuniones,tmpTableSalas,"codsala")

        urlBase = "http://ADDR/api/parallelByPrimary/slave/personasPorReunion-paso3/"
        responses = general.send_to_all("requests.get",servers,nbrServers,urlBase,data)
        tmpTablePersonas = general.union_responses_list(responses)

        return {"resp":general.join_tables(tempTable,tmpTablePersonas,"codreu")}
    else:
        return "deje ejecutar en el nodo primary"


@app.route('/api/parallelByPrimary/slave/personasPorReunion-paso1/',methods=['GET'])
def select_slaveReuniones():

    resp = select_data("select a.codreu, a.descripc descripreu, a.codsala from reunion a",dbConnConfig)

    #print (["select_slaveReuniones",myId,resp])
    return {"resp" : resp, "server":myId }


@app.route('/api/parallelByPrimary/slave/personasPorReunion-paso2/',methods=['GET'])
def select_slaveSalas():

    resp = select_data("SELECT a.codsala, a.descrip descripsala, a.codcom FROM sala a",dbConnConfig)

    print (["select_slaveSalas",myId,resp])
    return {"resp" : resp, "server":myId }

@app.route('/api/parallelByPrimary/slave/personasPorReunion-paso3/',methods=['GET'])
def select_slavePersonasReunion():

    resp = select_data("SELECT a.rut, a.nombre, b.codreu, b.flgasiste"
                        +" FROM persona a, invitado b"
                        +" where"
                        +" a.rut=b.rut and"
                        +" b.flgasiste=2",dbConnConfig)

    return {"resp" : resp, "server":myId }


##################################################################################################
@app.route('/api/parallelByPrimary/reunionesConSala/')
def select_reunionesConSala():
    if myId == primaryId:
        data = request.json

        urlBase = "http://ADDR/api/parallelByPrimary/slave/personasPorReunion-paso1/"
        responses = general.send_to_all("requests.get",servers,nbrServers,urlBase,data)
        tmpTableReuniones = general.union_responses_list(responses)

        urlBase = "http://ADDR/api/parallelByPrimary/slave/reunionesConSala/"
        responses = general.distribute_table("requests.get",servers,nbrServers,urlBase,tmpTableReuniones,"sala")
        tmpTableSalas = general.union_responses_list(responses)

        return {"resp":tmpTableSalas}
    else:
        return "deje ejecutar en el nodo primary"

@app.route('/api/parallelByPrimary/slave/reunionesConSala/',methods=['GET'])
def select_slaveReunionesConSala():
    tempTable1=request.json
    txtIn = get_txtInByCol(tempTable1, "codsala")
    print(["select_slaveReunionesConSala",txtIn])
    tempTable2= select_data("SELECT a.codsala, a.descrip descripsala, a.codcom "
                            +" FROM sala a"
                            +" where a.codsala in ("+txtIn+")",dbConnConfig)


    resp=general.join_tables(tempTable1,tempTable2,"codsala")

    return {"resp" : resp, "server":myId }