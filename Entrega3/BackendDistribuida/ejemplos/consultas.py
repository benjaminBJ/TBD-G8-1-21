import time
import psycopg2
from psycopg2.extras import RealDictCursor
import json
import random
import time
import datetime

###############################################################################
current_milli_time = lambda: int(round(time.time() * 1000))


###############################################################################
def get_connection_db(conn):
    return psycopg2.connect(user=conn["user"],
                            password=conn["pass"],
                            host=conn["host"],
                            port=conn["port"],
                            database=conn["dbname"])

###############################################################################
def select_data(sqlStatement,connData):
    resp=[]
    try:
        connection = get_connection_db(connData)
        cursor = connection.cursor()

        cursor.execute(sqlStatement)
        colnames = [desc[0] for desc in cursor.description]
        lenColnames = len(colnames)

        print("Selecting rows from mobile table using cursor.fetchall")
        records = cursor.fetchall()

        print("Print each row and it's columns values")
        for row in records:
            obj={}
            for i in range(lenColnames):
                obj[ colnames[i] ] = str(row[i])
            resp.append(obj)

    except (Exception, psycopg2.Error) as error :
        if(connection):
            print("Failed > ", error)

    finally:
        if(connection):
            cursor.close()
            connection.close()
            print("PostgreSQL connection is closed")

    return resp
###############################################################################


dbConnConfig={"user":"postgres","pass":"A1b2c3Z0", "host":"127.0.0.1", "port":"5432", "dbname":"reunionesdb0"}
iniTime = current_milli_time()
tempTable = select_data("select * from persona where rut <= 2",dbConnConfig)

print([tempTable, (current_milli_time() - iniTime) ])