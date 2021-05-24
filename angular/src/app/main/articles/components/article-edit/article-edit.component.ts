import { ActivatedRoute, Router } from '@angular/router';
import { ArticleService } from './../../services/article-service.service';
import { ArticleModel } from './../../model/article-model.Model';
import { Component, OnInit, Injector } from '@angular/core';
import { ToastrService } from 'ngx-toastr';
import { NavMenuService } from 'src/app/nav-menu/services/nav-menu.service';
import { Category } from 'src/app/nav-menu/models/category.model';

@Component({
  selector: 'app-article-edit',
  templateUrl: './article-edit.component.html',
  styleUrls: ['./article-edit.component.scss']
})
export class ArticleEditComponent implements OnInit {
  article: ArticleModel = new ArticleModel();
  private articleService = this.injector.get(ArticleService);
  private categoryService = this.injector.get(NavMenuService);
  categoryList: Array<Category> = new Array();
  selectedCategory: number = 0;
  isLoading: boolean = false;
  id: number = 0;

  constructor(private injector: Injector, private route: ActivatedRoute, private router: Router, private toastr: ToastrService) {
    route.params.subscribe((params) => {
      if (params.id > 0) {
        this.id = params.id;
      }
    })
  }

  ngOnInit(): void {
    this.load();
    this.categoryService.categoryList().subscribe(items => this.categoryList = items);
  }

  load() {
    this.isLoading = true;

    this.articleService.show(this.id).toPromise()
      .then((res) => {
        this.article = new ArticleModel().deserialize(res);
        this.selectedCategory = this.article.category?.id ? this.article.category.id : 0;
        console.log(this.article);
      })
      .finally(() => {
        this.isLoading = false;
      });
  }

  onSave() {
    this.isLoading = true;

    this.article.category.id = this.selectedCategory;

    this.articleService.update(this.article).toPromise().then((res) => {
      this.article = new ArticleModel().deserialize(res);
      this.selectedCategory = this.article.category?.id ? this.article.category.id : 0;
      this.toastr.success("Article saved.");
    })
      .finally(() => this.isLoading = false);
  }

  onBack() {
    this.router.navigate(["/article/" + this.id]);
  }

}
