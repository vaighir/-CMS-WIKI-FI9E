import { Component, OnInit, Input, EventEmitter } from '@angular/core';
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
    console.log(this.category.id);
  }

  updateCategory(id: number) {
    this.navMenuService.updateCategoryId(id);
  }
}
