# -*- coding: utf-8 -*-

import proyecto01
import unittest

"""
Pruebas para el proyecto01.
"""

class PruebasUnitarias(unittest.TestCase):

    #test_cache que prueba la integridad de los diccionarios usados para
    #el modelado del cache
    def test_cache(self):
        diccionario = {'TLC':['193.371', '-99.566']}
        diccionario_vac = {}
        self.assertNotEqual(proyecto01.lectura('resources/dataset1.csv'),diccionario_vac)
        self.assertEqual(proyecto01.lectura('resources/dataset1.csv')['TLC'],diccionario['TLC'])
        self.assertRaises(FileNotFoundError, proyecto01.lectura,'hola.csv')

    #test_is_empty que prubea la correctitud del método is_empty para
    #estructuras de datos vacías.
    def test_is_empty(self):
        diccionario = {'llave':'clave'}
        diccionario_vac = {}
        self.assertEqual(proyecto01.is_empty(diccionario), False)
        self.assertEqual(proyecto01.is_empty(diccionario_vac), True)

    #test_peticiones que prueba que las peticiones a la API de OpenWeatherMap
    #se hagan de manera correcta.
    def test_peticiones(self):
        invalido = {'MXN': []}
        invalido_uno = {'MXN': ['1a','3']}
        error_m = {'MXN': {'cod': '404', 'message': 'city not found'}}
        error_l = {'MXN': {'cod': '400', 'message': 'wrong latitude'}}

        self.assertEqual(proyecto01.peticiones(invalido), error_m)
        self.assertEqual(proyecto01.peticiones(invalido_uno),error_l)


if __name__ == '__main__':
    unittest.main()
