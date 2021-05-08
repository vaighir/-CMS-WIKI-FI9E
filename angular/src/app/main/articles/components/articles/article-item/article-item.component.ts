import { Component, OnInit } from '@angular/core';
import { ArticleModelModule } from '../../../article-model/article-model.module';
import { ArticleServiceService } from '../../../services/article-service.service';

@Component({
  selector: 'app-article-item',
  templateUrl: './article-item.component.html',
  styleUrls: ['./article-item.component.scss']
})
export class ArticleItemComponent implements OnInit {
  article: ArticleModelModule = new ArticleModelModule();

  constructor(
    private articleService: ArticleServiceService
  ) { }

  ngOnInit(): void {
  }
}
