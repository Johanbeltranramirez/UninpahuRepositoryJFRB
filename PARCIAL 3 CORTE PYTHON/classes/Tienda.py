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

    def registrar_celular(self):
        cod = int(input("Ingrese el número de código: "))
        nom = input("Ingrese el nombre del dipositivo: ")
        tm = input("Ingrese la marca del dispositivo: ")
        cost = int(input("Ingrese el valor del dispositivo en pesos (sin puntos): "))
        carga = int(input("Ingrese la camtidad de amperios de la bateria: "))
        cam = int(input("Ingrese la capacidad de megapixeles de la cámara: "))
        pro = int(input("Ingrese los puntos del procesador: "))   

        celular = Celular(0, "", "", 0, carga, cam, pro)
         
