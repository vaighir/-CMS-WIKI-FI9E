import { Component, OnInit, Input, EventEmitter } from '@angular/core';
import { Category } from '../../models/category.model';
import { NavMenuService } from '../../services/nav-menu.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {
  @Input() category?: any;
  constructor(
    private navMenuService: NavMenuService
  ) { 
  }

  ngOnInit(): void {
    //@TODO: category ids are undefined
    this.category.id = 2;

    console.log('category: ', this.category);

    this.navMenuService.updateCategoryId(this.category.id);

  }

}
