import random
import requests
import time
import datetime

###############################################################################
current_milli_time = lambda: int(round(time.time() * 1000))


###############################################################################
def run_http_func(http_func,action, url, data=None):
    res = eval(http_func)(url, json=data)
    if res.ok:
        print ([action,data,"ok", len(res.json()["resp"]) ])
        #for row in res.json()["resp"]:
        #    print(row)
    else:
        print ([action,data,"error",0])

###############################################################################
def create_comunas(amount):
    for i in range(amount):
        data = {"codcom":i, "nombre": "comuna_"+str(i)}
        run_http_func("requests.post","insert_comuna", 'http://localhost:5000/api/parallelInsert/comuna/',data)


###############################################################################
def delete_tablas():
    run_http_func("requests.delete","delete_comunas", 'http://localhost:5000/api/parallelDelete/comuna/all/',None)
    run_http_func("requests.delete","delete_salas", 'http://localhost:5000/api/parallelDelete/sala/all/',None)
    run_http_func("requests.delete","delete_personas", 'http://localhost:5000/api/parallelDelete/persona/all/',None)
    run_http_func("requests.delete","delete_reuniones", 'http://localhost:5000/api/parallelDelete/reunion/all/',None)
    run_http_func("requests.delete","delete_invitados", 'http://localhost:5000/api/parallelDelete/invitado/all/',None)

###############################################################################
def get_data(cols, x):
    data={}
    for key, value in cols.items():
        v=None
        if value["type"]=="num":
            v = x
        elif value["type"]=="txt":
            v = value["value"].replace("X",str(x))
        elif value["type"]=="dep":
            v = random.randrange(value["value"][0],value["value"][1])
        data[key]=v
    return data

###############################################################################
def create_tabla(amount,data_template,action, url):
    for i in range(amount):
        data = get_data(data_template, i)
        run_http_func("requests.post",action, url,data)


###############################################################################
def create_tablas(tables):
    create_tabla(tables["comuna"],
                 {"codcom":{"type":"num","value":0}, "nombre": {"type":"txt","value":"COMUNA_X"}},
                 "insert_comuna", 'http://localhost:5000/api/parallelInsert/comuna/')

    create_tabla(tables["sala"],
                 {"codsala":{"type":"num","value":0},
                  "descrip": {"type":"txt","value":"SALA_X"},
                  "codcom": {"type":"dep","value":[0,(tables["comuna"]-1)]}
                  },
                 "insert_sala", 'http://localhost:5000/api/parallelInsert/sala/')

    create_tabla(tables["persona"],
                 {"rut":{"type":"num","value":0},
                  "nombre": {"type":"txt","value":"PERSONA_X"},
                  "codcom": {"type":"dep","value":[0,(tables["comuna"]-1)]}
                  },
                 "insert_persona", 'http://localhost:5000/api/parallelInsert/persona/')


    create_tabla(tables["reunion"],
                 {"codreu":{"type":"num","value":0},
                  "descripc": {"type":"txt","value":"REUNION_X"},
                  "codsala": {"type":"dep","value":[0,(tables["sala"]-1)]}
                  },
                 "insert_reunion", 'http://localhost:5000/api/parallelInsert/reunion/')


    create_tabla(tables["invitado"],
                 {"rut":{"type":"dep","value":[0,(tables["persona"]-1)]},
                  "codreu": {"type":"dep","value":[0,(tables["reunion"]-1)]},
                  "flgasiste": {"type":"dep","value":[1,3]}
                  },
                 "insert_invitado", 'http://localhost:5000/api/parallelInsert/invitado/')

###############################################################################
def select_personasPorReunionPP():
    run_http_func("requests.get","select_personasPorReunion",
                  'http://localhost:5000/api/parallelByPrimary/personasPorReunion/',None)

###############################################################################
def select_personasInvitadasReunionPP():
    run_http_func("requests.get","select_personasInvitadasReunion",
                  'http://localhost:5000/api/parallelByPrimary/personasInvitadasReunion/',None)

###############################################################################
def select_reunionesConSalaPP():
    run_http_func("requests.get","personasPorReunion2",
                  'http://localhost:5000/api/parallelByPrimary/reunionesConSala/',None)


###############################################################################
def select_personasPorReunionBSP():
    run_http_func("requests.get","select_personasPorReunion",
                  'http://localhost:5000/api/parallelByBSP/personasPorReunion/',None)

###############################################################################
def select_reunionesConAsistentesBSP():
    run_http_func("requests.get","select_reunionesConAsistentesBSP",
                  'http://localhost:5000/api/parallelByBSP/reunionesConAsistentes/',None)

###############################################################################
def select_reunionesConAsistentesBSP2():
    run_http_func("requests.get","select_reunionesConAsistentesBSP2",
                  'http://localhost:5000/api/parallelByBSP/reunionesConAsistentes2/',None)

def check_time(function, params):
    iniTime = current_milli_time()
    if params==None:
        eval(function)()
    else:
        eval(function)(params)
    print( function+" => time ms:"+str((current_milli_time() - iniTime))  )
    raw_input("Press Enter to continue... \n")


def main():
    #delete_tablas()
    #create_tablas({"comuna":10,"sala":10,"persona":1000,"reunion":30,"invitado":2000 })

    check_time("select_personasPorReunionPP",None)
    check_time("select_personasInvitadasReunionPP",None)
    check_time("select_reunionesConSalaPP",None)

    check_time("select_personasPorReunionBSP",None)
    check_time("select_reunionesConAsistentesBSP",None)
    check_time("select_reunionesConAsistentesBSP2",None)



main()

