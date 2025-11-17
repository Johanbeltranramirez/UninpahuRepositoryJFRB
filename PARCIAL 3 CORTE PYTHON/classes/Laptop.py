from classes.Dispositivo import Dispositivo

class Laptop(Dispositivo):
    def __init__(self, codProd, nombre, marca, precio, ram_gb, procesador_puntos):
        super().__init__(codProd, nombre, marca, precio)
        self.__ram_gb = ram_gb
        self.__procesador_puntos = procesador_puntos

    def get_ram_gb(self):
        return self.__ram_gb
    def set_ram_gb(self, ram_gb):
        self.__ram_gb = ram_gb

    def get_procesador_puntos(self):
        return self.__procesador_puntos
    def set_procesador_puntos(self, procesador_puntos):
        self.__procesador_puntos = procesador_puntos

    def calcular_redimiento(self):
        rendimiento = (self.__ram_gb*self.__procesador_puntos)
        return rendimiento / self.get_precio
    
    def evaluar_costo_beneficio(self):
        calidad = self.calcular_redimiento()

        if calidad > 2.0:
            return "El laptop tiene excelente calidad con relación al precio xb"

        elif calidad > 1.0:
            return "El laptop tiene una calidad media ;D"
        else:
            return "El laptop es de mala calidad con respecto al precio :("

    def calcular_nivel(self):

        nivel = (self.__ram_gb*2) + self.__procesador_puntos


        if nivel >= 32:
            return "Es multitarea con nivel alto."
        elif nivel >= 16:
            return "Es multitarea con nivel medio."
        else:
            return "Es multitarea con nivel bajo."

