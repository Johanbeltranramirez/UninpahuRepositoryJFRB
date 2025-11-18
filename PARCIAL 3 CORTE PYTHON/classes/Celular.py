from classes.Dispositivo import Dispositivo

class Celular(Dispositivo):
    def __init__(self, codProd, nombre, marca, precio, bateria_amp, camara_mp, procesador_puntos):
        super().__init__(codProd, nombre, marca, precio)
        self.__bateria_amp = bateria_amp
        self.__camara_mp = camara_mp
        self.__procesador_puntos = procesador_puntos

    def get_bateria_amp(self):
        return self.__bateria_amp
    def set_bateria_amp(self, bateria_amp):
        self.__bateria_amp = bateria_amp

    def get_camara_mp(self):
        return self.__camara_mp
    def set_camara_mp(self, camara_mp):
        self.__camara_mp = camara_mp

    def get_procesador_puntos(self):
        return self.__procesador_puntos
    def set_procesador_puntos(self, procesador_puntos):
        self.__procesador_puntos = procesador_puntos

    def calcular_redimiento(self):

        rendimiento = ((self.__bateria_amp*0.4)+(self.__camara_mp*0.3)+( self.__procesador_puntos*0.3))
        return rendimiento / self.get_precio()

    def evaluar_costo_beneficio(self):

        calidad = self.calcular_redimiento()

        if calidad > 0.7:
            return "El celular tiene excelente calidad con relación al precio xb"
        elif calidad > 0.3:
            return "El celular tiene una calidad media ;D"
        else:
            return "El celular es de mala calidad con respecto al precio :("

