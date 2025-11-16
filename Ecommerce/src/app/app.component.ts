
import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { IonApp, IonSplitPane, IonMenu, IonContent, IonList, IonListHeader, IonNote, IonMenuToggle, IonItem, IonIcon, IonLabel, IonRouterOutlet, IonRouterLink } from '@ionic/angular/standalone';
import { addIcons } from 'ionicons';
import { personCircleOutline, personCircleSharp,homeOutline, homeSharp, storefrontOutline, storefrontSharp, cartOutline, cartSharp, createOutline, createSharp } from 'ionicons/icons';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
  imports: [RouterLink, RouterLinkActive, IonApp, IonSplitPane, IonMenu, IonContent, IonList, IonListHeader, IonNote, IonMenuToggle, IonItem, IonIcon, IonLabel, IonRouterLink, IonRouterOutlet],
})
export class AppComponent {
  public appPages = [
    { title: 'User', url: '/info-usuario', icon: 'person-circle' },
    { title: 'Home', url: '/home', icon: 'home' },
    { title: 'Shop', url: '/shop-products', icon: 'storefront' },
    { title: 'Shopping cart', url: '/carrito-compras', icon: 'cart' },
    { title: 'Create', url: '/crear-producto', icon: 'create' },

  ];

  constructor() {
    addIcons({ personCircleOutline, personCircleSharp, homeOutline, homeSharp, storefrontOutline, storefrontSharp, cartOutline, cartSharp, createOutline, createSharp });
  }
}
