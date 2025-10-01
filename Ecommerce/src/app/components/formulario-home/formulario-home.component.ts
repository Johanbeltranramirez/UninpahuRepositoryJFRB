import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms'; 
import { 
  IonButton, IonInput, IonCard, IonCardHeader, IonCardTitle, IonCardContent, 
  IonItem, IonLabel, IonList, IonAvatar 
} from '@ionic/angular/standalone';

@Component({
  selector: 'app-formulario-home',
  templateUrl: './formulario-home.component.html',
  styleUrls: ['./formulario-home.component.scss'],
  standalone: true,
  imports: [ CommonModule, FormsModule, IonButton, IonInput, IonCard, IonCardHeader, IonCardTitle, IonCardContent, IonItem, IonLabel, IonList, IonAvatar ]
})
export class FormularioHomeComponent  implements OnInit {

  logo: string = 'https://png.pngtree.com/png-clipart/20220213/original/pngtree-e-letter-logo-ecommerce-shop-store-design-png-image_7265997.png';
  nombreApp: string = 'E - Store Company';

  usuario: string = '';
  direccion: string = '';
  pais: string = '';
  ciudad: string = '';
  idioma: string = '';
  moneda: string = '';

  guardarForm() {
    console.log('**INFORMACIÓN DEL CLIENTE**');
    console.log('Usuario:', this.usuario);
    console.log('Dirección:', this.direccion);
    console.log('País:', this.pais);
    console.log('Ciudad:', this.ciudad);
    console.log('Idioma:', this.idioma);
    console.log('Moneda:', this.moneda);
  }


  constructor() { }

  ngOnInit() {}

}
