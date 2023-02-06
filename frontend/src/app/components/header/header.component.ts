import {Component} from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  product = {
    name: 'iPhone',
    price: 1000,
    description: 'This is a phone'
  }


  constructor() {
  }


}
