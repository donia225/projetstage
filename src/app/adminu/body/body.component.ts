import { Component,OnInit } from '@angular/core';

@Component({
  selector: 'app-body',
  templateUrl: './body.component.html',
  styleUrls: ['./body.component.css']
})
export class BodyComponent implements OnInit {
  isBodyPage = false; 

  constructor(){
    console.log('isBodyPage:',this.isBodyPage);
  }
  ngOnInit(): void {}
 

}
