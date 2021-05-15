import { Component, OnInit } from '@angular/core';
import { NavMenuService } from 'src/app/nav-menu/services/nav-menu.service';
import { ArticleModel } from '../../model/article-model.Model';
import { ArticleService } from '../../services/article-service.service';

@Component({
  selector: 'app-articles',
  templateUrl: './articles.component.html',
  styleUrls: ['./articles.component.scss']
})
export class ArticlesComponent implements OnInit {
  allArticleList: any;
  ArticleListByCategory?: any;
  articleList?: ArticleModel[];
  categoryId?: any;
  allArticles: boolean;

  constructor(
    private articleService: ArticleService,
    private navMenuService: NavMenuService
  ) {
    this.allArticleList = null;
    this.allArticles = true;
  }

  ngOnInit(): void {

    this.navMenuService.currentCategoryId.subscribe(
      id => this.getArticlesByCategoryId(id)
    )
  }

  getArticlesByCategoryId(id: number): void {
    if (id !== -1 && id !== undefined) {
      this.articleService.articleListByCategory(id)
        .subscribe(items => this.articleList = items);
      this.allArticles = false;
      this.categoryId = id;

    } else {
      this.articleService.articleList()
        .subscribe(items => this.articleList = items);
    }
  }


}
