import { Component, OnInit } from '@angular/core';
import { NavMenuService } from 'src/app/nav-menu/services/nav-menu.service';
import { ArticleModel } from '../../model/article-model.Model';
import { ArticleService } from '../../services/article-service.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {
  ArticleListByCategory?: any;
  articleList?: ArticleModel[];
  categoryId?: number;
  allArticles: boolean;  

  // checkIfAllArticles: string[];

  constructor(
    private articleService: ArticleService,
    private navMenuService: NavMenuService,
    private route: ActivatedRoute
    ) {
    this.allArticles = true;
  }

  ngOnInit(): void {
   
    this.navMenuService.currentCategoryId.subscribe(
      id => {
        this.getArticlesByCategoryId(id)
      })
      this.route.params.subscribe((params) => {
        if(params.id) {
          this.categoryId = +params['id'];
          this.navMenuService.updateCategoryId(this.categoryId);
        }
      });

  }

  getArticlesByCategoryId(id: number): void {
    if (id !== -1 && id !== undefined) {
      this.articleService.articleListByCategory(id)
        .subscribe(items => {
          this.articleList = items;
          this.allArticles = false;
        });
  
    } else {
      this.articleService.articleList()
      .subscribe(items => this.articleList = items);
    } 

  }


}
