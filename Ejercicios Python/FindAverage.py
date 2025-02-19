import math
# Lista de nombres
names = ["Johan", "Mateo", "Luisa"]


for i in range(len(names)):
    print(f"names[{i}]: {names[i]}")


#Lista de valores
values = [10, 20, 30, 40, 50]

media = sum(values) / len(values)

variance = sum((x - media) ** 2 for x in values) / len(values)
desv_estandar = math.sqrt(variance)
#resultados
print(f"Valores: {values}")
print(f"Media {media}")
print(f"Varianza: {variance}")
print(f"Desviación estándar: {desv_estandar}")
