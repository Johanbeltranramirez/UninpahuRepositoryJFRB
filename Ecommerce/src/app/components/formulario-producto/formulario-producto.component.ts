import { Component, OnInit, Output, EventEmitter, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms'; 
import { 
  IonButton, IonInput, IonCard, IonCardHeader, IonText, IonCardTitle, IonCardContent, 
  IonItem, IonLabel, IonList, IonAvatar 
} from '@ionic/angular/standalone';
import { Producto } from 'src/app/data/interfaces/producto.model';

@Component({
  selector: 'app-formulario-producto',
  templateUrl: './formulario-producto.component.html',
  styleUrls: ['./formulario-producto.component.scss'],
  standalone: true,
  imports: [ CommonModule, FormsModule, IonButton, IonInput, IonCard, IonCardHeader, IonText, IonCardTitle, IonCardContent, IonItem, IonLabel, IonList, IonAvatar, ReactiveFormsModule ]
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

  ngOnInit() {
    this.crearForm();
  }

    crearForm(){
      this.formProducto = this.formReactivo.group({
        producto: this.formReactivo.group({
          title: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(25), Validators.pattern(/^(?!\s*$)[a-zA-Z0-9\sáéíóúÁÉÍÓÚñÑ.,-]+$/)]],
          price: ['', [Validators.required, Validators.minLength(2), Validators.maxLength(12), Validators.pattern(/^[1-9]\d{0,11}(\.\d{1,2})?$/)]],
          description: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(35), Validators.pattern(/^(?!\s*$)[a-zA-Z0-9\sáéíóúÁÉÍÓÚñÑ.,;:()'"-]+$/)]],
          category: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(25), Validators.pattern(/^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/)]],
          image: ['', [Validators.required, Validators.minLength(10), Validators.pattern(/^(https?:\/\/.*\.(?:png|jpg|jpeg|gif|webp))(?:\?.*)?$/i)]]
        })
      })
    }

    control(nombre: string) {
      return this.formProducto.get(`producto.${nombre}`)!;
    }

    getCampoStatus(campo: string): string {
      const camp = this.control(campo);
      if (camp.valid) return 'Dato válido';
      return 'El dato ingresado no cumple con los requisitos';
    }

    guardarForm() {
      if (this.formProducto.invalid) {
        this.formProducto.markAllAsTouched();
        return;
      }
      
      const productoForm = this.formProducto.get('producto')!.value;
      this.enviarACrear.emit(productoForm);
      console.log('Enviando producto desde el hijo:', productoForm);

      this.formProducto.reset();
    }
}
