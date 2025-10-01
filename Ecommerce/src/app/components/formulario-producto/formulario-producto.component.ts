import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'; 
import { 
  IonButton, IonInput, IonCard, IonCardHeader, IonCardTitle, IonCardContent, 
  IonItem, IonLabel, IonList, IonAvatar 
} from '@ionic/angular/standalone';
import { Producto } from 'src/app/data/interfaces/producto.model';

@Component({
  selector: 'app-formulario-producto',
  templateUrl: './formulario-producto.component.html',
  styleUrls: ['./formulario-producto.component.scss'],
  standalone: true,
  imports: [ CommonModule, FormsModule, IonButton, IonInput, IonCard, IonCardHeader, IonCardTitle, IonCardContent, IonItem, IonLabel, IonList, IonAvatar ]
})
export class FormularioProductoComponent  implements OnInit {

producto: Producto = {
    id: 0,
    title: '',
    price: 0,
    description: '',
    category: '',
    image: ''
  };

  @Output() enviarACrear = new EventEmitter<Producto>();

  constructor() { }

  ngOnInit() {}

    guardarForm() {
      console.log('Enviando producto desde el hijo:', this.producto);
      this.enviarACrear.emit(this.producto);

      this.producto = {
      id: 0,
      title: '',
      price: 0,
      description: '',
      category: '',
      image: ''
    };
    }
}
