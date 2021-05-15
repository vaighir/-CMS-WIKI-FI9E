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

  constructor(
    private articleService: ArticleService,
    private navMenuService: NavMenuService
  ) { 
    this.allArticleList = null;
  }

  ngOnInit(): void {  
      this.navMenuService.currentCategoryId.subscribe(
      id => this.categoryId = id
    )

    console.log('id category: ',this.categoryId);

    if(this.categoryId !== -1 && this.categoryId !== undefined) {
      this.articleService.articleListByCategory(this.categoryId)
      .subscribe(items => this.articleList = items);
    } else {
      this.articleService.articleList()
      .subscribe(items => this.articleList = items);
    }
      
   

    console.log('articles by category: ',this.articleList);
  }

}
