import { Component, OnInit } from '@angular/core';
import { ArticleModel } from '../../../model/article-model.Model';
import { ArticleService } from '../../../services/article-service.service';

@Component({
  selector: 'app-article-item',
  templateUrl: './article-item.component.html',
  styleUrls: ['./article-item.component.scss']
})
export class ArticleItemComponent implements OnInit {

  constructor(
    private articleService: ArticleService
  ) { }

  ngOnInit(): void {
  }
}
