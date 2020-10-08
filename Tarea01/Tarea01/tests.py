# -*- coding: utf-8 -*-

import proyecto01
import unittest

"""
Pruebas para el proyecto01.
"""

class PruebasUnitarias(unittest.TestCase):

    def test_cache(self):
        diccionario = {'TLC':['193.371', '-99.566']}
        diccionario_vac = {}
        self.assertNotEqual(proyecto01.lectura('resources/dataset1.csv'),diccionario_vac)
        self.assertEqual(proyecto01.lectura('resources/dataset1.csv')['TLC'],diccionario['TLC'])
        self.assertRaises(FileNotFoundError, proyecto01.lectura,'hola.csv')

    def test_peticiones(self):
        d

if __name__ == '__main__':
    unittest.main()
