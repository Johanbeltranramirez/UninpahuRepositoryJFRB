import { Component, inject, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IonButtons,IonMenuButton,IonContent, IonHeader, IonTitle, IonToolbar, IonButton } from '@ionic/angular/standalone';

@Component({
  selector: 'app-info-usuario',
  templateUrl: './info-usuario.page.html',
  styleUrls: ['./info-usuario.page.scss'],
  standalone: true,
  imports: [IonButtons,IonMenuButton,IonContent, IonHeader, IonTitle, IonToolbar, CommonModule, FormsModule, IonButton]
})

export class InfoUsuarioPage implements OnInit {

   usuario = {
    nombres: 'Johan',
    apellidos: 'Ramírez Beltrán',
    cargo: 'Analista de Nómina',
    unidad: 'Contabilidad de Incapacidades',
    email: 'johan.ramirez@gmail.com',
    fechaNacimiento: '2005-04-20',
    foto: './assets/img_johan.jpg',
    activo: true,
    dato: ''
  };

  prueba(){
      alert("¡Se Agregó con éxito!")
      this.usuario.foto = './assets/prueba.jpeg'
    }

    inactivar(){
      this.usuario.activo = false
      alert("INACTIVO")
      ;
    }

    imprimir(){
      alert(this.usuario.activo)
    }

  constructor() { }

  ngOnInit() {
  }

}
