# -*- coding: utf-8 -*-

import csv

"""
Proyecto 01.
El programa recibe un documento en formato csv con ciudades
origen y destino pertenecientes a una aerolínea en la ciudad de México.
EL programa devuelve en la salida estandar la ciudad, la descripción del clima,
la temperatura mínima, la temperatura máxima y la humedad.
"""

llave_api = '56de92f593ea497ac17dd421c9fed113'
url_base = 'api.openweathermap.org/data/2.5/weather?'

def main():
    diccionario_ciudades = lectura('resources/dataset1.csv')  #Lectura de csv1
    diccionario_ciudades_uno = lectura('resources/dataset2.csv') #Lectura de csv2

    #Por hacer:
    #Peticiones a OpenWeatherMap, se proponen 30 cada 30 segundos. Utilizar waiters
    #Si hay error con clave en vuelos internacionales se procede a intentar con
    #Latitudes y longitudes si ningna opción funciona se regresa el error
    #Devolver datos del clima [Ciudad, descripción del clima, temp. mínima, temp. Máxima, Humedad]
    #Pruebas. Al menos 3.
    #EXTRA: Procesar la información de manera simultanea
    #      y limitar peticiones concurrentes a web service para no saturarlo

"""
Función para leer el csv.
Devulve un diccionario con la información del csv.
"""
def lectura(hoja):
    try:
        
        #Calusula en caso de que no se reciba el archivo correcto
        with open(hoja, newline='') as csvFile:
            reader = csv.DictReader(csvFile)

        if hoja == 'resources/dataset1.csv':
            with open(hoja, newline='') as csvFile: #Leemos el csv
                diccionario = {}
                reader = csv.DictReader(csvFile)
                for row in reader:  #Leemos cada diccionario generado
                    lista_o = [row['origin_latitude'], row['origin_longitude']]
                    origen = row['origin']
                    lista_d = [row['destination_latitude'], row['destination_longitude']]
                    destino = row['destination']
                    diccionario[origen] = lista_o
                    diccionario[destino] = lista_d
                return diccionario

        if hoja == 'resources/dataset2.csv':
            with open(hoja, newline='') as csvFile:
                diccionario = {}
                reader = csv.DictReader(csvFile)
                for row in reader:
                    valor = []
                    destino = row['destino']
                    diccionario[destino] = valor
                return diccionario

    except FileNotFoundError as e:
        #Lo que se imprime en caso de que no se encuentre el archivo
        print('Archivo no encontrado.')

if __name__ == '__main__':
    main()
