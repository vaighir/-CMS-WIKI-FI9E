import { Router, ActivatedRoute } from '@angular/router';
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

  constructor(  private injector: Injector, 
                private router: Router, 
                private route: ActivatedRoute) {
      //
  }

  ngOnInit(): void {
    //
  }

  onSave(): void {
    this.isLoading = true;
    this.articleService.store(this.article).toPromise().then((res) => {
      this.article = new ArticleModel().deserialize(res);
      console.log(this.article);
    }).finally(() => {
      this.isLoading = false;
      this.router.navigate(['/article/edit/' + this.article.id]);
    });
  }

  onBack() {
    this.router.navigate([".."]);
  }
}
