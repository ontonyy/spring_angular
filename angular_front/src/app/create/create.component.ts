import {Component, OnInit} from '@angular/core';
import { Hero } from '../hero';
import {RequestService} from "../services/request.service";

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  hero: Hero = {
    id: 1,
    name: 'Windstorm'
  };
  hello: String = "";

  constructor(private requestService: RequestService) { }

  ngOnInit(): void {
  }

  async click() {
    console.log("clicked")
    this.requestService.getHelloResponse().subscribe(data => {
      this.hello = data.text
    });
  }
}
