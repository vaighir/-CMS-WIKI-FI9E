import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-confirm-modal',
  templateUrl: './confirm-modal.component.html',
  styleUrls: ['./confirm-modal.component.scss']
})
export class ConfirmModalComponent implements OnInit {
  dialog: {
    header: string;
    message: string
  }

  constructor(
    public activeModal: NgbActiveModal,
    private router: Router
  ) { 
    this.dialog = {
      header: '',
      message: ''
    }
  }

  ngOnInit(): void {
  }
  confirm(): void {
    this.activeModal.close(true);
  }

}
