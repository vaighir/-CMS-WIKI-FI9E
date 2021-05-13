import { Component, Injector, OnInit } from '@angular/core';
import { ArticleModel } from '../../model/article-model.Model';
import { ArticleService } from '../../services/article-service.service';

@Component({
  selector: 'app-articles-add',
  templateUrl: './articles-add.component.html',
  styleUrls: ['./articles-add.component.scss']
})
export class ArticlesAddComponent implements OnInit {
  article: ArticleModel = new ArticleModel();
  private articleService = this.injector.get(ArticleService);

  constructor(private injector: Injector) {
    
  }

  ngOnInit(): void {

  }

  onSave(): void {
    this.articleService.store(this.article);
  }
}
