# -*- coding: utf-8 -*-

import csv
import json
import requests
import waiter

"""
Proyecto 01.
El programa recibe un documento en formato csv con ciudades
origen y destino pertenecientes a una aerolínea en la ciudad de México.
EL programa devuelve en la salida estandar la ciudad, la descripción del clima,
la temperatura mínima, la temperatura máxima y la humedad.
"""

#Llave para usar OpenWeatherMap
llave_api = {YOUR_API_KEY}
#URL raiz para hacer peticiones
url_base = 'http://api.openweathermap.org/data/2.5/weather?'

def main():
    try:
        diccionario_ciudades = lectura('resources/dataset1.csv')  #Lectura de csv1
        diccionario_ciudades.update(lectura('resources/dataset2.csv')) #Lectura de csv2

        climas = peticiones(diccionario_ciudades)

    except FileNotFoundError as e:

        #Lo que se imprime en caso de que no se encuentre el archivo.
        print('Archivo no encontrado.')

"""
Método peticiones.
Recibe un diccionario con las ciudades de las cuales se quiere obtener el clima.
Regresa un diccionario cuyas llaves son las ciudades y están emparejadas con su clima.
"""
def peticiones(diccionario):
    #Crea un contador para dosificar las peticiones
    cont = 0
    #Crea un nuevo diccionario para emparejar las ciudades con su clima,
    #este diccionario se regresará para impresión.
    nuevo_diccionario = { }

    #Ciclo para recorrer todo el diccionario recibido.
    for ciudad in diccionario.keys():
        if cont >= 30:
            #Despuñes de 30 peticiones, el programa espera 30 segundos.
            waiter.wait([1] * 30)
            #Reinicia el contador.
            cont = 0
        #Se realiza la petición a OpenWeather con el nombre de la ciudad y
        #se recibe la respuesta.
        url = url_base + "q=" + ciudad + "&units=metric&lang=es&appid=" + llave_api
        respuesta = requests.get(url)

        if respuesta.status_code != 404:
            #Si la petición es exitosa, se empareja el nombre de la ciudades
            #con el clima obtenido en la petición.
            nuevo_diccionario[ciudad] = respuesta.json()
            #Actualiza el contador al terminar la petición.
            cont+= 1

        if not is_empty(diccionario[ciudad]):
            #Si la petición no tiene exito y la ciudad tiene cordenadas,
            #se realiza una petición con ellas.
            latitud = diccionario[ciudad][0]
            longitud = diccionario[ciudad][1]
            url = url_base + "lat=" + latitud + "&lon=" + longitud + "&units=metric&lang=es&appid=" + llave_api
            respuesta = requests.get(url)
            #Se empareja la ciudad con el clima recuperado.
            nuevo_diccionario[ciudad] = respuesta.json()
            #Actualiza el contador al terminar la petición.
            cont += 1
        else:
            continue
    #Regresa el dicionario que empareja todas las ciudades con sus climas.
    return nuevo_diccionario

    #Por hacer:
    #Devolver datos del clima [Ciudad, descripción del clima, temp. mínima, temp. Máxima, Humedad]
    #Pruebas. Al menos faltan 2.
    #EXTRA: Procesar la información de manera simultanea
    #      y limitar peticiones concurrentes a web service para no saturarlo

"""
Función para leer el csv.
Devulve un diccionario con la información del csv.
"""
def lectura(hoja):

    #Diccionaro para guardar las ciudades (cache)
    diccionario = {}

    if hoja == 'resources/dataset1.csv':
        with open(hoja, newline='') as csvFile: #Leemos el csv
            reader = csv.DictReader(csvFile)
            for row in reader:
                lista_o = [row['origin_latitude'], row['origin_longitude']]
                origen = row['origin']
                lista_d = [row['destination_latitude'], row['destination_longitude']]
                destino = row['destination']
                diccionario[origen] = lista_o
                diccionario[destino] = lista_d
            return diccionario

    elif hoja == 'resources/dataset2.csv':
        with open(hoja, newline='') as csvFile:
            reader = csv.DictReader(csvFile)
            for row in reader:
                valor = []
                destino = row['destino']
                diccionario[destino] = valor
            return diccionario

    #Calusula en caso de que no se reciba el archivo correcto
    else:
        raise FileNotFoundError

def is_empty(data_structure):
    if data_structure:
        return False
    else:
        return True

"""
Función para imprimir la lista de ciudades con su clima.
Imprime en la terminal el nombre de cada ciudad seguido de una ficha con la
información del clima.
"""
def impresion(dicionario):
    #Ciclo para recorrer todas las ciudades del diccionario dado.
    for ciudad in diccionario:
        #Accede al clima de cada ciudad y la guarda en una variable para
        #acceder a ella después.
        clima = diccionario[ciudad]

        #Se hace casting a todas las variables con un tipo de dato diferente
        #a String.
        temperatura = str(clima['main']['temp'])
        sens_ter = str(clima['main']['feels_like'])
        temp_min = str(clima['main']['temp_min'])
        temp_max = str(clima['main']['temp_max'])
        presion = str(clima['main']['pressure'])
        humedad = str(clima['main']['pressure'])

        #Ficha de impresión para cada clima. Se incluyen sólo los datos
        #más generales y se agregan las unidades.
        print( ciudad +
               "\n Ciudad/Aeropuerto: " + clima['name'] + ", " + clima['sys']['country'] +
               "\n Clima general: " + clima['weather'][0]['main'] +
               "\n Descripción: " + clima['weather'][0]['description'] +
               "\n Temperatura: " + temperatura + " ºC" +
               "\n Sensación térmica: " + sens_ter + " ºC" +
               "\n Temp. mínima: " + temp_min + " ºC" +
               "\n Temp. máxima: " + temp_max + " ºC" +
               "\n Presión: " + presion + " nPa" +
               "\n Humedad: " + humedad + "%" +
               "\n -------------------------------------"
               )

if __name__ == '__main__':
    main()
