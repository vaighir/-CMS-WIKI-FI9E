import { Component, OnInit } from '@angular/core';
import { ArticleModel } from '../../../model/article-model.Model';
import { ArticleServiceService } from '../../../services/article-service.service';

@Component({
  selector: 'app-article-item',
  templateUrl: './article-item.component.html',
  styleUrls: ['./article-item.component.scss']
})
export class ArticleItemComponent implements OnInit {
  article: ArticleModel = new ArticleModel();

  constructor(
    private articleService: ArticleServiceService
  ) { }

  ngOnInit(): void {
  }
}
