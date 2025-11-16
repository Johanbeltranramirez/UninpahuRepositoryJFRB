import { Routes } from '@angular/router';

export const routes: Routes = [

  {
    path: '',
    redirectTo: 'info-usuario',
    pathMatch: 'full',
  },
  {
    path: 'info-usuario',
    loadComponent: () => import('./pages/info-usuario/info-usuario.page').then( m => m.InfoUsuarioPage)
  },
  {
    path: 'home',
    loadComponent: () => import('./pages/home/home.page').then( m => m.HomePage)
  },
  {
    path: 'shop-products',
    loadComponent: () => import('./pages/shop-products/shop-products.page').then( m => m.ShopProductsPage)
  },
  {
    path: 'crear-producto',
    loadComponent: () => import('./pages/crear-producto/crear-producto.page').then( m => m.CrearProductoPage)
  },
  {
    path: 'carrito-compras',
    loadComponent: () => import('./pages/carrito-compras/carrito-compras.page').then( m => m.CarritoComprasPage)
  },

];
