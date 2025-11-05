import { inject, Injectable } from '@angular/core';
import { Producto } from '../interfaces/producto.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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

 private http = inject(HttpClient)
 apiUrl = "https://fakestoreapi.com/docs#tag/Products/"

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

  getProducto(): Observable<Producto[]>{
    return this.http.get<Producto[]>(this.apiUrl);
  }
 
  crearProducto(producto: Producto): Observable<any>{
    return this.http.post<any>(this.apiUrl, producto)
  }
  
}
 