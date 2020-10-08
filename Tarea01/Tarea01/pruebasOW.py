import requests
import json
import csv
import waiter

llave_api = '56de92f593ea497ac17dd421c9fed113'
url_base = 'http://api.openweathermap.org/data/2.5/weather?'


def main():
    print("Hola Mundo")

def peticiones(diccionario):
    cont = 0
    nuevo_diccionario = { }
    for ciudad in diccionario.keys():
        if cont >= 30:
            waiter.wait([1] * 30)
            cont = 0
        url = url_base + "q=" + "Guadalajara" + "&units=metric&appid=" + llave_api
        respuesta = requests.get(url)
        if respuesta.status_code() != 404:
            nuevo_diccionario[ciudad] = respuesta.json()
            cont+= 1
            print('Success!')
        else:
            latitud = diccionario[ciudad][0]
            longitud = diccionario[ciudad][1]
            url = url_base + "lat=" + latitud + "&lon=" + longitud + "&units=metric&appid=" + llave_api
            respuesta = requests.get(url)
            nuevo_diccionario[ciudad] = respuesta.json()
            cont += 1
            print('Not Found.')


if __name__ == "__main__":
    main()
