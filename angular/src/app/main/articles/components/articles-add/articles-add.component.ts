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
  isLoading: boolean = false;

  constructor(private injector: Injector) {
    //
  }

  ngOnInit(): void {

  }

  onSave(): void {
    this.isLoading = true;
    console.log(this.isLoading);
    setTimeout(() => {
      this.isLoading = false;
      console.log(this.isLoading);
    }, 200);
    this.articleService.store(this.article).toPromise().finally(() => {
      console.log("laoded...");
    });
  }
}
