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
    this.traerProducto();
  }


    traerProducto() {
      this.productoService.getProducto().subscribe({
        next: (data) => {
          const locales = this.productoService.obtenerProductosLocal();
          this.listaVaciaProd = [...data, ...locales].sort((a, b) => b.id - a.id);
          console.log("Productos obtenidos del hijo:", data);
        }, 
        error: (err) => {
              console.error("Error al obtener productos:", err);
            }
      });
    }

    crearProducto(producto: Producto) {
      const nuevoProducto: Producto = {
        ...producto,
        id: Date.now(),
        rating: { rate: 0, count: 0 }
      };

      this.productoService.crearProducto(nuevoProducto).subscribe({
        next: (data) => {
          console.log('Producto creado satisfactoriamente:', data);
          this.productoService.guardarProductoLocal(nuevoProducto);
          this.listaVaciaProd.push(nuevoProducto);

          alert('Producto agregado a la lista');
        },
        error: (err) => console.error('Error al crear producto:', err)
      });
    }
 
}
