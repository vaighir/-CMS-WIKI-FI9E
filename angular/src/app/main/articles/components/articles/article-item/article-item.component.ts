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
  createAtDate: String = "";

  constructor(
    private articleService: ArticleService
  ) { 
    this.articleContent = '';
  }

  ngOnInit(): void {
    if(this.article) {
      this.articleContent = this.article?.content ? this.article.content.toString() : "";
      this.createAtDate = "";//ArticleModel.getCreatedAt(this.article.created_at.toString());
      console.log(this.article?.created_at);
    }
  }
}
