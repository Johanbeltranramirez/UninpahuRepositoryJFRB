# Lista de nombres
names = ["Juan", "Felipe", "Angie"]


for i in range(len(names)):
    print(f"names[{i}]: {names[i]}")


#Lista de valores
values = [10, 20, 30, 40, 50]

media = sum(values) / len(values)

variance = sum((x - media) ** 2 for x in values) / len(values)

#resultados
print(f"Valores: {values}")
print(f"Media {media}")
print(f"Varianza: {variance}")

print(f"Promedio de la varianza: {variance}")
