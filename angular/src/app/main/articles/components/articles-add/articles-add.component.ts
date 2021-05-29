import { Router, ActivatedRoute } from '@angular/router';
import { Component, Injector, OnInit } from '@angular/core';
import { ArticleModel } from '../../model/article-model.Model';
import { ArticleService } from '../../services/article-service.service';
import { Category } from 'src/app/nav-menu/models/category.model';
import { NavMenuService } from 'src/app/nav-menu/services/nav-menu.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-articles-add',
  templateUrl: './articles-add.component.html',
  styleUrls: ['./articles-add.component.scss']
})
export class ArticlesAddComponent implements OnInit {
  article: ArticleModel = new ArticleModel();
  private articleService = this.injector.get(ArticleService);
  private categoryService = this.injector.get(NavMenuService);
  isLoading: boolean = false;
  categoryList: Array<Category> = new Array();
  selectedCategory: number = 0;

  constructor(  private injector: Injector, 
                private router: Router, 
                private route: ActivatedRoute,
                private toastr: ToastrService) {}

  ngOnInit(): void {
    this.categoryService.categoryList().subscribe(items => this.categoryList = items);
  }

  onSave(): void {
    this.isLoading = true;
    this.article.category.id = this.selectedCategory;

    if(this.article.category.id <= 0) {
      this.toastr.info("Please select category");
      this.isLoading = false;
      return;
    }

    this.articleService.store(this.article).toPromise().then((res) => {
      this.article = new ArticleModel().deserialize(res);

      this.toastr.success("Article created");
    }).finally(() => {
      this.isLoading = false;
      this.router.navigate(['/article/edit/' + this.article.id]);
    });
  }

  onBack() {
    this.router.navigate([".."]);
  }
}
