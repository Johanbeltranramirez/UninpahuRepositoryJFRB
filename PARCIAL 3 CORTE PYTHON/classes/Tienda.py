from classes.Celular import Celular
from classes.Laptop import Laptop
from classes.Tablet import Tablet

class Tienda:
    def __init__(self):
        self.dispositivos = []
        self.usuario = ""
    def iniciar(self):
        self.usuario = input("Uusuario: ")
        print(f"Bienvenido {self.usuario}\n")
        self.mostrar_menu()

    def insertar_dispositivos(self, dispositivo):
        self.dispositivos = [*self.dispositivos, dispositivo]
        print("Se ingresó correctamente el dispositivo")

    #def registrar_dispositivos 



 