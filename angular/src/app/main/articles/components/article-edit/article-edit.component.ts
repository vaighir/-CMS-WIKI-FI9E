import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from './../../services/article-service.service';
import { ArticleModel } from './../../model/article-model.Model';
import { Component, OnInit, Injector } from '@angular/core';

@Component({
  selector: 'app-article-edit',
  templateUrl: './article-edit.component.html',
  styleUrls: ['./article-edit.component.scss']
})
export class ArticleEditComponent implements OnInit {
  article: ArticleModel = new ArticleModel();
  private articleService = this.injector.get(ArticleService);
  isLoading: boolean = false;
  id: number = 0;

  constructor(private injector: Injector, private route: ActivatedRoute,  private router: Router) {
    route.params.subscribe((params) => {
      if (params.id > 0) {
        this.id = params.id;
      }
    })
  }

  ngOnInit(): void {
    this.load();
  }

  load() {
    this.isLoading = true;

    this.articleService.show(this.id).toPromise()
      .then((res) => {
        this.article = new ArticleModel().deserialize(res);
      })
      .finally(() => {
        this.isLoading = false;
      });
  }

  onSave() {
    this.isLoading = true;

    this.articleService.update(this.article).toPromise().then((res) => {
      this.article = new ArticleModel().deserialize(res);
    })
      .finally(() => this.isLoading = false);
  }

  onBack() {
    this.router.navigate(["/article/"+this.id]);
  }

}
