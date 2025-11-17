from abc import ABC, abstractmethod

class Dispositivo(ABC):
    def __init__(self, codProd, nombre, marca, precio):
        self.__codProd = codProd
        self.__nombre = nombre
        self.__marca = marca
        self.__precio = precio

    def get_codProd(self):
        return self.__codProd
    def set_codProd(self, codProd):
        self.__codProd = codProd

    def get_nombre(self):
        return self.__nombre
    def set_nombre(self, nombre):
        self.__nombre = nombre
    
    def get_marca(self):
        return self.__marca
    def set_marca(self, marca):
        self.__marca = marca
    
    def get_precio(self):
        return self.__precio
    def set_precio(self, precio):
        self.__precio = precio
    
    @abstractmethod
    def calcular_redimiento(self):
        pass

    @abstractmethod
    def evaluar_costo_beneficio(self):
        pass
        