import requests
import json
import csv
import waiter

llave_api = '56de92f593ea497ac17dd421c9fed113'
url_base = 'api.openweathermap.org/data/2.5/weather?'


def main():
    print("Hola Mundo")

def peticiones(diccionario):
    cont = 0
    nuevo_diccionario = { }
    for ciudad in diccionario.keys():
        url = url_base + "q=" + ciudad + "&appid=" + llave_api
        if cont >= 30:
            waiter.wait([1] * 30)
            cont = 0
        respuesta = requests.get(url)
        if respuesta.status_code() == 200:
            print('Success!')
        elif respuesta.status_code() == 404:
            print('Not Found.')


if __name__ == "__main__":
    main()
