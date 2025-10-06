import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/angular/standalone';
import { ListaProductosComponent } from 'src/app/components/lista-productos/lista-productos.component';
import { Producto } from 'src/app/data/interfaces/producto.model';
import { ProductoService } from 'src/app/data/services/producto-service';


@Component({
  selector: 'app-carrito-compras',
  templateUrl: './carrito-compras.page.html',
  styleUrls: ['./carrito-compras.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, ListaProductosComponent]
})
export class CarritoComprasPage implements OnInit {

  productosCarrito: Producto[] = [];

  productoService = inject(ProductoService)

  constructor() { }

  ngOnInit() {
    this.productosCarrito = this.productoService.obtenerCarrito();
  }

}
