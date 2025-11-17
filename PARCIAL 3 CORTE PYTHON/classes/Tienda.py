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

    def mostrar_menu(self):
        while True:
            print("\n ---------------------Opciones: --------------------")
            print("1.Registro de celulares.")
            print("2.Registro de laptops.")
            print("3.Registro de tabletas.")
            print("4.Mostrar todos los dispositivos.")
            print("5.Busqueda por código.")
            print("6.Ordenamiento por criterio especifico.")
            print("7.Mostrar dispositivo con mejor rendimiento.")
            print("0.Salir del sistema.")

            opcion = input("Seleccione una opción (sólo numero): ")
            if opcion == "1":
                self.registrar_celular()
            elif opcion == "2":
                self.registrar_laptop()
            elif opcion == "3":
                self.registrar_tablet()
            elif opcion == "4":
                self.mostrar_dispositivos()
            elif opcion == "5":
                self.buscar_por_codigo()
            elif opcion == "6":
                criterio = input("Criterio (precio, nombre, rendimiento): ").lower()
                self.ordenar_criterio(criterio)
            elif opcion == "7":
                self.mostrar_mayor_rendimiento()
            elif opcion == "0":
                print("..Fin del programa..")
                break
            else:
                print("Esta opción NO EXISTE")

    def insertar_dispositivos(self, dispositivo):
        self.dispositivos = [*self.dispositivos, dispositivo]
        print("Se ingresó correctamente el dispositivo")

    def mostrar_mayor_rendimiento(self):
        if not self.dispositivos:
            print("No hay datos en el sistema...")
            return

        dispositivos_orden = []

        for i in range(len(self.dispositivos)):
            actual = self.dispositivos[i]
            insertado = False

            if not dispositivos_orden:
                dispositivos_orden.append(actual)
                continue

            for n in range(len(dispositivos_orden)):
                rendimiento_actual = actual.calcular_redimiento()
                rendimiento_comparado = dispositivos_orden[j].calcular_redimiento()

                if rendimiento_actual > rendimiento_comparado:
                    parte_izquierda = dispositivos_orden[:j]
                    parte_derecha = dispositivos_orden[j:]
                    dispositivos_orden = parte_izquierda + [actual] + parte_derecha
                    insertado = True
                    break

            if not insertado:
                dispositivos_orden += [actual]

        mejor = dispositivos_orden[0]

        print("\n ¿Cuál tiene mejor rendimiento?")
        print(f"Tipo del dispositivo: {mejor.__class__.__name__}")
        print(f"Su rendimiento es de: {mejor.calcular_redimiento():.2f}")
        print(f"Evaluación: {mejor.evaluar_costo_beneficio()}")


    def registrar_celular(self):
        cod = int(input("Ingrese el número de código: "))
        nom = input("Ingrese el nombre del dipositivo: ")
        tm = input("Ingrese la marca del dispositivo: ")
        cost = int(input("Ingrese el valor del dispositivo en pesos (sin puntos): "))
        carga = int(input("Ingrese la camtidad de amperios de la bateria: "))
        cam = int(input("Ingrese la capacidad de megapixeles de la cámara: "))
        pro = int(input("Ingrese los puntos del procesador: "))   

        celular = Celular(cod, nom, tm, cost, carga, cam, pro)
        self.dispositivos.append(celular)
        print("Celular ingresado correctamente.")

    def registrar_tablet(self):
        cod = int(input("Ingrese el número de código: "))
        nom = input("Ingrese el nombre del dipositivo: ")
        tm = input("Ingrese la marca del dispositivo: ")
        cost = int(input("Ingrese el valor del dispositivo en pesos (sin puntos): "))
        res = int(input("Ingrese la cantidad de PPI de resolución: "))

        tablet = Celular(cod, nom, tm, cost, res)
        self.dispositivos.append(tablet)
        print("Tablet ingresado correctamente.")

    def registrar_laptop(self):
        cod = int(input("Ingrese el número de código: "))
        nom = input("Ingrese el nombre del dipositivo: ")
        tm = input("Ingrese la marca del dispositivo: ")
        cost = int(input("Ingrese el valor del dispositivo en pesos (sin puntos): "))
        res = int(input("Ingrese la cantidad de PPI de resolución: "))

        tablet = Celular(cod, nom, tm, cost, res)
        self.dispositivos.append(tablet)
        print("Celular ingresado correctamente.")

        


    
