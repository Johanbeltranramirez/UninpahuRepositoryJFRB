from classes.Dispositivo import Dispositivo

class Laptop(Dispositivo):
    def __init__(self, codProd, nombre, marca, precio, ram_gb, procesador_puntos):
        super().__init__(codProd, nombre, marca, precio)
        self.__ram_gb = ram_gb
        self.__procesador_puntos = procesador_puntos

    def calcular_redimiento(self):
        rendimiento = (self.__ram_gb*self.__procesador_puntos)
        return rendimiento / self.get_precio
    
    def evaluar_costo_beneficio(self):
        calidad = self.calcular_redimiento()

        if calidad > 2.0:
            return "El laptop tiene excelente calidad con relación al precio"

        elif calidad > 1.0:
            return "El laptop tiene una calidad media"
        else:
            return "El laptop es de mala calidad con respecto al precio"

