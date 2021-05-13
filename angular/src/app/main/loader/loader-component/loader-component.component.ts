import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-loader-component',
  templateUrl: './loader-component.component.html',
  styleUrls: ['./loader-component.component.scss']
})
export class LoaderComponent implements OnInit {
  @Input() isLoading: boolean = false;

  constructor() {
    //
  }

  ngOnInit(): void {
    //
  }

}
