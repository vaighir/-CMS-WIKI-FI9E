import { Component, Injector, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleModel } from '../../model/article-model.Model';
import { ArticleService } from './../../services/article-service.service'

@Component({
  selector: 'app-article-detail',
  templateUrl: './article-detail.component.html',
  styleUrls: ['./article-detail.component.scss']
})
export class ArticleDetailComponent implements OnInit {
  id: number = 0;
  private articleService = this.injector.get(ArticleService);
  article: any = {};
  createAtDate: string = "";

  constructor(  private injector: Injector, 
                private route: ActivatedRoute,
                private router: Router) {
    route.params.subscribe((params) => {
      this.id = params.id;
    });
  }

  ngOnInit(): void {
    this.article = this.articleService.show(this.id).subscribe((res) => {
      this.article = new ArticleModel().deserialize(res);
      this.createAtDate = new Date(this.article.created_at).toLocaleDateString('de-DE'); 
    });
  }

  onEdit() {
    this.router.navigate(['/article/edit/' + this.id]);
  }

  onBack() {
    this.router.navigate([".."]);
  }
}
