import { Component, OnInit } from '@angular/core';
import { Tag } from '../models/tag.model';
import { NavMenuService } from '../services/nav-menu.service';

@Component({
  selector: 'app-nav-menu',
  templateUrl: './nav-menu.component.html',
  styleUrls: ['./nav-menu.component.scss']
})
export class NavMenuComponent implements OnInit {

  tagList?: Tag[];

  constructor(
    private navMenuService: NavMenuService 
  ) { }

  ngOnInit(): void {
    this.navMenuService.tagList()
    .subscribe(items => this.tagList = items);

    console.log(this.tagList);
    
  }

}
