import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  datoGuardado: string =""
  listaTexto: string[] = []

  guardarDato(dato: string){
    this.listaTexto.push(dato)
  }
}
