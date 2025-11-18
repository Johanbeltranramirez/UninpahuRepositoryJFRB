from classes.Dispositivo import Dispositivo

class Tablet(Dispositivo):
    def __init__(self, codProd, nombre, marca, precio, resolucion_ppi):
        super().__init__(codProd, nombre, marca, precio)
        self.__resolucion_ppi = resolucion_ppi

    def get_resolucion_ppi(self):
        return self.__resolucion_ppi
    def set_resolucion_ppi(self, resolucion_ppi):
        self.__resolucion_ppi = resolucion_ppi

    def calcular_redimiento(self):

        rendimiento = (self.__resolucion_ppi**2)
        return rendimiento / self.get_precio()
    
    def evaluar_costo_beneficio(self):

        calidad = self.calcular_redimiento()

        if calidad > 1.0:
            return "La tableta tiene excelente calidad con relación al precio xb"
        elif calidad > 0.5:
            return "La tableta tiene una calidad media ;D"
        else:
            return "La tavbleta es de mala calidad con respecto al precio :("