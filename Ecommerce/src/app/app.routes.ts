import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'folder/:id',
    loadComponent: () =>
      import('./folder/folder.page').then((m) => m.FolderPage),
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
];
