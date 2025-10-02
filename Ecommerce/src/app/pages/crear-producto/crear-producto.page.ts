import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/angular/standalone';
import { FormularioProductoComponent } from 'src/app/components/formulario-producto/formulario-producto.component';
import { ListaProductosComponent } from 'src/app/components/lista-productos/lista-productos.component';
import { Producto } from 'src/app/data/interfaces/producto.model';
import { ProductoService } from 'src/app/data/services/producto-service';

@Component({
  selector: 'app-crear-producto',
  templateUrl: './crear-producto.page.html',
  styleUrls: ['./crear-producto.page.scss'],
  standalone: true,
  imports: [IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, FormularioProductoComponent, ListaProductosComponent]
})
export class CrearProductoPage implements OnInit {

  listaVaciaProd: Producto[] = [];


  productoService = inject(ProductoService)
  constructor() { }

  ngOnInit() {
    this.listaVaciaProd = this.productoService.listaVaciaProd
  }

    recibirProducto(producto: Producto) {
    console.log('Se recibió el producto en el padre:', producto);

    const nuevoId = this.listaVaciaProd.length > 0
      ? Math.max(...this.listaVaciaProd.map(p => p.id)) + 1
      : 1;

    const nuevoProducto: Producto = {
      ...producto,
      id: nuevoId
    };

   this.productoService.guardarProducto(nuevoProducto);

}

  
}
