import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonContent, IonHeader, IonTitle, IonToolbar, IonButton } from '@ionic/angular/standalone';
import { FormularioHomeComponent } from 'src/app/components/formulario-home/formulario-home.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.page.html',
  styleUrls: ['./home.page.scss'],
  standalone: true,
  imports: [ CommonModule, FormsModule, IonContent, IonHeader, IonTitle, IonToolbar, IonButton, FormularioHomeComponent
  ]

})
export class HomePage implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
