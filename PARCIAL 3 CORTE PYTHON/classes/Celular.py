from classes.Dispositivo import Dispositivo

class Celular(Dispositivo):
    def __init__(self, codProd, nombre, marca, precio, bateria_amp, camara_mp, procesador_puntos):
        super().__init__(codProd, nombre, marca, precio)
        self.__bateria_amp = bateria_amp
        self.__camara_mp = camara_mp
        self.__procesador_puntos = procesador_puntos

    def calcular_redimiento(self):
        rendimiento = ((self.__bateria_amp*0.4) + (self.__camara_mp*0.3) + (self.__procesador_puntos*0.3))
        return rendimiento / self.get_precio()

    def evaluar_costo_beneficio(self):
        calidad = self.calcular_redimiento()

        if calidad > 1.5:
            return "El celular tiene excelente calidad con relación al precio"
        elif calidad > 1.0:
            return "El celular tiene una calidad media"
        else:
            return "El celular es de mala calidad con respecto al precio"
