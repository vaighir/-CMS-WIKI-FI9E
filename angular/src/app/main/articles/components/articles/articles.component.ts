import { Component, OnInit } from '@angular/core';
import { NavMenuService } from 'src/app/nav-menu/services/nav-menu.service';
import { ArticleModel } from '../../model/article-model.Model';
import { ArticleService } from '../../services/article-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import { AuthService } from 'src/app/auth/auth.service';

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
  isLogin = false;

  // checkIfAllArticles: string[];

  constructor(
    private articleService: ArticleService,
    private navMenuService: NavMenuService,
    private route: ActivatedRoute,
    private authService: AuthService
    ) {
    this.allArticles = true;
  }

  ngOnInit(): void {
    if(this.authService.getToken()) {
      this.isLogin = true;
    }
   
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
        .subscribe(res => {
          this.articleList = res.data;
          this.allArticles = false;
        });
    } else {
      this.articleService.articleList()
      .subscribe(res => this.articleList = res.data);
    } 

  }


}
