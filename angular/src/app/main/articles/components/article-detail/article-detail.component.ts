import { Component, Injector, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArticleModel } from '../../model/article-model.Model';
import { ArticleService } from './../../services/article-service.service';
import { ModalService } from 'src/app/modals/services/modal.service';
import { ToastrService } from 'ngx-toastr';
import { NavMenuService } from 'src/app/nav-menu/services/nav-menu.service';
import { AuthService } from 'src/app/auth/auth.service';
import {Location} from '@angular/common';


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
  isLogin = false;

  constructor(  private injector: Injector, 
                private route: ActivatedRoute,
                private router: Router,
                private modalService: ModalService,
                private toastr: ToastrService,
                private navMenuService: NavMenuService,
                private authService: AuthService,
                private _location: Location
                ) {
    this.route.params.subscribe((params) => {
      this.id = params.id;
    });
  }

  ngOnInit(): void {
    if(this.authService.getToken()) {
      this.isLogin = true;
    }

    this.article = this.articleService.show(this.id).subscribe((res:any) => {
      this.article = new ArticleModel().deserialize(res.data);
      this.createAtDate = new Date(this.article.created_at).toLocaleDateString('de-DE'); 
    });
  }

  onEdit() {
    this.router.navigate(['/article/edit/' + this.id]);
  }

  onBack() {
    // this.router.navigate(["/article/category/" + this.article.category.id]);
    this._location.back();
  }

  openConfirmDeleteDialog(): void {
    const dialogModal = this.modalService.confirm(
      'Sind Sie sicher?', 'Möchten Sie wirklich den Artikel löschen?'
    )

    dialogModal.then((decision) => {
      if(decision) {
        this.articleService.delete(this.id).toPromise().then((res) => {
          // this.router.navigate(["/article/category/" + this.article.category.id]);
          this._location.back();
          this.toastr.success('Der Artikel - ' + this.id + ' wurde erfolgreich gelöscht');
        });
      }
    });

  }
}
