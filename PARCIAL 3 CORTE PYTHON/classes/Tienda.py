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
            print("3.Registro de tablets.")
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
                self.buscar_codigo()
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

        tablet = Tablet(cod, nom, tm, cost, res)
        self.dispositivos.append(tablet)
        print("Tablet ingresado correctamente.")

    def registrar_laptop(self):
        cod = int(input("Ingrese el número de código: "))
        nom = input("Ingrese el nombre del dipositivo: ")
        tm = input("Ingrese la marca del dispositivo: ")
        cost = int(input("Ingrese el valor del dispositivo en pesos (sin puntos): "))
        ramgb = int(input("Ingrese las gigas de RAM: "))
        pro = int(input("Ingrese los puntos del procesador: "))

        laptop = Laptop(cod, nom, tm, cost, ramgb, pro)
        self.dispositivos.append(laptop)
        print("Laptop ingresado correctamente.")

    def datos_dispositivo(self, dispositivo):
        cod = dispositivo.get_codProd()
        nombre = dispositivo.get_nombre()
        cost = dispositivo.get_precio()
        tipo = dispositivo.__class__.__name__
        rendimiento = dispositivo.calcular_redimiento()
        evaluacion = dispositivo.evaluar_costo_beneficio()
        print(f"* #{cod} ,Nombre: {nombre}, Precio: ${cost} ,Tipo: {tipo}, Rendimiento: {rendimiento:.2f}, Calidad: {evaluacion} *")

    def mostrar_dispositivos(self):
        if not self.dispositivos:
            print("No hay registros en el sistema...")
            return
        print("\n Dispositivos registrados:\n")
        for dis in self.dispositivos:
            self.datos_dispositivo(dis)

    def buscar_codigo(self):
        entrada = input("Ingrese el código del dispositivo que quiere encontrar: ")
        codigo_busqueda = entrada.strip().upper()
        encontrado = False
        for i in range(len(self.dispositivos)):
            dis = self.dispositivos[i]
            if hasattr(dis, "get_codProd()"):
                cod_actual = dis.get_codProd().strip().upper()
                if cod_actual == codigo_busqueda:
                    print(f"\n **********Dispositivo encontrado**********")
                    self.mostrar_dispositivo(dis)
                    encontrado = True
                    break
        if not encontrado:
            print("No hay datos para mostrar :(")

    def ordenar_criterio(self, criterio):

        if criterio != "precio" and criterio != "nombre" and criterio != "rendimiento":
            print("Criterio no es válido")
            return
        print(f"\n Ordenando dispositivos por {criterio}...\n")

        cantidad = len(self.dispositivos)
        for pasada in range(cantidad):
            for i in range(cantidad - pasada - 1):
                primero = self.dispositivos[i]
                segundo = self.dispositivos[i + 1]

                if criterio == "precio":
                    if primero.get_precio() > segundo.get_precio():

                        self.dispositivos[i], self.dispositivos[i + 1] = segundo, primero

                elif criterio == "nombre":
                    nombre1 = primero.get_nombre().lower()
                    nombre2 = segundo.get_nombre().lower()
                    if nombre1 > nombre2:
                        self.dispositivos[i], self.dispositivos[i + 1] = segundo, primero

                elif criterio == "rendimiento":
                    rend1 = primero.calcular_redimiento()
                    rend2 = segundo.calcular_redimiento()
                    if rend1 < rend2:
                        self.dispositivos[i], self.dispositivos[i + 1] = segundo, primero
        self.mostrar_dispositivos()

    def mostrar_mayor_rendimiento(self):
        if not self.dispositivos:
            print("No hay datos en el sistema...")
            return
        ordenados = []
        for i in range(len(self.dispositivos)):
            actual = self.dispositivos[i]
            insertado = False
            if not ordenados:
                ordenados.append(actual)
                continue

            for n in range(len(ordenados)):
                rendimiento_actual = actual.calcular_redimiento()
                comparamiento = ordenados[n].calcular_redimiento()
                if rendimiento_actual > comparamiento:
                    izq = ordenados[:n]
                    der = ordenados[n:]
                    ordenados = izq +[actual]+ der
                    insertado = True
                    break
            if not insertado:
                ordenados += [actual]
        mayor = ordenados[0]

        print("\n ¿Cuál tiene mejor rendimiento?")
        print(f"Tipo del dispositivo: {mayor.__class__.__name__}")
        print(f"Su rendimiento es de: {mayor.calcular_redimiento()}")
        print(f"Su calidad: {mayor.evaluar_costo_beneficio()}")


    
