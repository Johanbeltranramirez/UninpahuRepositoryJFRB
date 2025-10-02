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

  guardarProducto(producto: Producto){
    this.listaVaciaProd.push(producto);
  }
}
