import { Injectable } from '@angular/core';
import { Producto } from '../interfaces/producto.model';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  /*datoGuardado: string =""
  listaTexto: string[] = []

  guardarDato(dato: string){
    this.listaTexto.push(dato)
  }*/
 listaVaciaProd: Producto[] = [];
 listaCarrito: Producto[] = [];

  guardarProducto(producto: Producto){
    this.listaVaciaProd.push(producto);
  }

  agregarAlCarrito(producto: Producto) {
    const existe = this.listaCarrito.find(p => p.id === producto.id);
    if (!existe) {
      this.listaCarrito.push(producto);
    }
  }

  eliminarDelCarrito(id: number) {
    this.listaCarrito = this.listaCarrito.filter(p => p.id !== id);
  }

  obtenerCarrito(): Producto[] {
    return this.listaCarrito;
  }

  limpiarCarrito() {
    this.listaCarrito = [];
  }
  
}
 