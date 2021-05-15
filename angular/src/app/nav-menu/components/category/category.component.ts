import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {
  @Input() category: any;
  constructor() { 
    this.category = null;
  }

  ngOnInit(): void {
    console.log('category: ', this.category);
  }

}
