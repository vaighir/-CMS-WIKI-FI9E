import { Component, Input, OnInit } from '@angular/core';
import { ArticleModel } from '../../../model/article-model.Model';
import { ArticleService } from '../../../services/article-service.service';

@Component({
  selector: 'app-article-item',
  templateUrl: './article-item.component.html',
  styleUrls: ['./article-item.component.scss']
})
export class ArticleItemComponent implements OnInit {
  @Input() article?: ArticleModel;
  articleContent?: string;
  constructor(
    private articleService: ArticleService
  ) { 
    this.articleContent = '';
  }

  ngOnInit(): void {
    let content = this.article?.content ? this.article.content.toString() : "...";
    this.articleContent = content;
  }
}
