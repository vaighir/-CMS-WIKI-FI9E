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
  }

  updateCategory(id: number) {
    this.navMenuService.updateCategoryId(id);
  }
}
