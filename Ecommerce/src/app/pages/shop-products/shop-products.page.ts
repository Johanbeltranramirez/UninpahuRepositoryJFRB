import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonButtons,IonMenuButton,IonContent, IonHeader, IonTitle, IonToolbar } from '@ionic/angular/standalone';
import { ListaProductosComponent } from 'src/app/components/lista-productos/lista-productos.component';
import { Producto } from 'src/app/data/interfaces/producto.model';
import { ProductoService } from 'src/app/data/services/producto-service';

@Component({
  selector: 'app-shop-products',
  templateUrl: './shop-products.page.html',
  styleUrls: ['./shop-products.page.scss'],
  standalone: true,
  imports: [IonButtons,IonMenuButton,IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, ListaProductosComponent]
})
export class ShopProductsPage implements OnInit {

 /* listaProductos: Producto [] = [
  {
    id: 1,
    title: "Lápices",
    price: 1500,
    description: "Madera, Grafito",
    category: "Faber-Castell",
    image: "https://panamericana.vtexassets.com/arquivos/ids/269941-1200-auto?v=636386591068470000&width=1200&height=auto&aspect=true"
  },
  {
    id: 2,
    title: "Cartuchera",
    price: 18000,
    description: "Tela",
    category: "Totto",
    image: "https://tottoco.vtexassets.com/arquivos/ids/579828/AC52ECO003-2426Z-6YX_1.jpg?v=638654849853130000"
  },
  {
    id: 3,
    title: "Tijeras",
    price: 6500,
    description: "Acero, Plástico",
    category: "Maped",
    image: "https://www.grafitos.com.co/wp-content/uploads/2021/07/tijeras-grafitos-su040-1.jpg"
  },
  {
    id: 4,
    title: "Monedero",
    price: 25000,
    description: "Cuero sintético",
    category: "Bosi",
    image: "https://bosico.vtexassets.com/arquivos/ids/2034647-1200-auto?v=638628716222600000&width=1200&height=auto&aspect=true"
  },
  {
    id: 5,
    title: "Cuaderno Maluma",
    price: 8000,
    description: "Papel, Cartón",
    category: "Norma",
    image: "https://http2.mlstatic.com/D_NQ_NP_2X_929851-MCO82060326631_012025-F.webp"
  },
  {
    id: 6,
    title: "Esfero",
    price: 1200,
    description: "Plástico",
    category: "BIC",
    image: "https://acdn-us.mitiendanube.com/stores/399/204/products/esfero-faber-castell-trilux-negro1-b6a915d19ffb0701de16807341262646-640-0.jpg"
  },
  {
    id: 7,
    title: "Regla 30CM",
    price: 3000,
    description: "Plástico",
    category: "Staedtler",
    image: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9_XMjFYSsv0Zy0-sodRLnlt052SB2XVKXbA&s"
  },
  {
    id: 8,
    title: "Calculadora",
    price: 45000,
    description: "Plástico, Componentes electrónicos",
    category: "Casio",
    image: "https://lagarza.com.co/rails/active_storage/representations/proxy/eyJfcmFpbHMiOnsiZGF0YSI6MjE1OTE0NiwicHVyIjoiYmxvYl9pZCJ9fQ==--4e36f1a1cb714b73e13ab2e372964e58f03536a0/eyJfcmFpbHMiOnsiZGF0YSI6eyJmb3JtYXQiOiJQTkciLCJyZXNpemVfdG9fZml0IjpbODAwLDgwMF19LCJwdXIiOiJ2YXJpYXRpb24ifX0=--5bc749b878ff7aeaa8c5e47bd558bf4c834c3584/casio%20fx570es%20plus.PNG?locale=es"
  },
  {
    id: 9,
    title: "Papel Resma",
    price: 55800,
    description: "Papel",
    category: "ResmaPlus",
    image: "https://www.suescun.com.co/wp-content/uploads/2021/06/Resma-de-Papel-Oficio-200x200.jpg"
  },
  {
    id: 10,
    title: "Colores",
    price: 22000,
    description: "Madera, Grafito",
    category: "Norma",
    image: "https://acdn-us.mitiendanube.com/stores/399/204/products/441-588d55a131f037487c16351970324577-640-0.webp"
  }
  
  ]*/

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

}
