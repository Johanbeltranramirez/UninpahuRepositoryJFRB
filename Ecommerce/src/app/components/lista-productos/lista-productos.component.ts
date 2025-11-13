import { CommonModule } from '@angular/common';
import { Component, Input, OnInit, inject } from '@angular/core';
import { IonContent, IonHeader, IonTitle, IonToolbar, IonButton, IonAvatar } from '@ionic/angular/standalone';
import { Producto } from 'src/app/data/interfaces/producto.model';
import { ProductoService } from 'src/app/data/services/producto-service';

@Component({
  selector: 'app-lista-productos',
  templateUrl: './lista-productos.component.html',
  styleUrls: ['./lista-productos.component.scss'],
  standalone: true,
  imports: [IonButton, CommonModule, IonAvatar]
})

export class ListaProductosComponent  implements OnInit {

  //activo: boolean = false;
 //persona: Persona;
  //listaFrutas: string[] = ["Pera", "Manzana", "Fresa", "Piña"];

  productoService = inject(ProductoService)
  constructor() { }

  ngOnInit() {}


  @Input() variableEntradaPadre: Producto[];
  @Input() modoCarrito: boolean = false;

comprarProducto(producto: Producto) {
    this.productoService.agregarAlCarrito(producto);
    console.log('Producto agregado al carrito:', producto.title);
    alert('¡Producto agregado al carrito!');
  }

  eliminarProducto(id: number) {
    this.productoService.eliminarDelCarrito(id);
    this.variableEntradaPadre = this.variableEntradaPadre.filter(p => p.id !== id);
    console.log('Producto eliminado del carrito:', id);
    alert('¡Producto eliminado del carrito!');
  }


}
