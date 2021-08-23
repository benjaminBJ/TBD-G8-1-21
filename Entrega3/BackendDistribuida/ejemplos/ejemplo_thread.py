import threading
def worker(count,resp):
    """funcion que realiza el trabajo en el thread"""
    print "Este es el %s trabajo que hago hoy para Genbeta Dev" % count
    resp[count]="thread-"+str(count)
    return

threads = []
resp=["","",""]
for i in range(3):
    process = threading.Thread(target=worker, args=(i,resp))
    threads.append(process)
    process.start()
    print(["fin",resp]) ##no est sincronizado


#sincronizacion de respuestas
for process in threads:
    process.join()

print(["fin",resp])
