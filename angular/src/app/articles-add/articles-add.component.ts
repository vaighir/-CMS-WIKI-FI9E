import { Component, OnInit } from '@angular/core';
import { ArticleModelModule } from '../article-model/article-model.module';
import { ArticleServiceService } from '../article-service.service';

@Component({
  selector: 'app-articles-add',
  templateUrl: './articles-add.component.html',
  styleUrls: ['./articles-add.component.scss']
})
export class ArticlesAddComponent implements OnInit {
  article: ArticleModelModule = new ArticleModelModule();

  constructor( private articleService: ArticleServiceService) { }

  ngOnInit(): void {

  }

  onSave(): void {
    this.articleService.addArticle(this.article);
  }
}
