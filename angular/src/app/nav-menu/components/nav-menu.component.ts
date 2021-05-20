import { Component, OnInit } from '@angular/core';
import { Category } from '../models/category.model';
import { NavMenuService } from '../services/nav-menu.service';

@Component({
  selector: 'app-nav-menu',
  templateUrl: './nav-menu.component.html',
  styleUrls: ['./nav-menu.component.scss']
})
export class NavMenuComponent implements OnInit {

  categoryList?: Category[];

  constructor(
    private navMenuService: NavMenuService 
  ) { }

  ngOnInit(): void {
    this.navMenuService.categoryList()
    .subscribe(items => this.categoryList = items);

    console.log('list: ', this.categoryList);
    
  }

  resetCategoryId(): void {
    this.navMenuService.updateCategoryId(-1);
  }

}
