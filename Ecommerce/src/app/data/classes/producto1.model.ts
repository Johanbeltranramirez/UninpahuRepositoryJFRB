export class Producto1{
    id: number;
    nombre: string;
    precio: number;

    constructor(id: number, nombre: string, precio: number){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    vender(){
        console.log("El producto se vendió");
    }

}

