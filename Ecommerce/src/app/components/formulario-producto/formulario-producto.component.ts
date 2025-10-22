import { Component, OnInit, Output, EventEmitter, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms'; 
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
  imports: [ CommonModule, FormsModule, IonButton, IonInput, IonCard, IonCardHeader, IonCardTitle, IonCardContent, IonItem, IonLabel, IonList, IonAvatar, ReactiveFormsModule ]
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

  formProducto: FormGroup; 

  @Output() enviarACrear = new EventEmitter<Producto>();
  private formReactivo = inject(FormBuilder);

  constructor() { }

  ngOnInit() {}

    crearForm(){
      this.formProducto = this.formReactivo.group({
        producto: this.formReactivo.group({
          title: ['Ingrese el título del producto', [Validators.required, Validators.minLength(2), Validators.maxLength(25)]],
          price: ['Precio en COP', [Validators.required, Validators.minLength(2), Validators.maxLength(12)]],
          description: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(35)]],
          category: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(25)]],
          image: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(85)]]
        })
      })
    }

    guardarForm() {
      if(this.formProducto.valid)
        console.log('Formulario', this.formProducto);

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
