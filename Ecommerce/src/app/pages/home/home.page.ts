import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonButtons,IonMenuButton,IonContent, IonHeader, IonTitle, IonToolbar, IonButton } from '@ionic/angular/standalone';
import { FormularioHomeComponent } from 'src/app/components/formulario-home/formulario-home.component';
import { ProductoService } from 'src/app/data/services/producto-service';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
  standalone: true,
  imports: [IonButtons,IonMenuButton,CommonModule, FormsModule, IonContent, IonHeader, IonTitle, IonToolbar, IonButton, FormularioHomeComponent]

})
export class HomePage implements OnInit {

  //productoService = inject(ProductoService)
  //datoObtenido : string = ""

  constructor() { }

  ngOnInit() {
    //this.datoObtenido = this.productoService.datoGuardado
  }

}
