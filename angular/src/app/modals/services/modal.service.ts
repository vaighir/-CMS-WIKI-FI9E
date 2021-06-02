import { Injectable } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ConfirmModalComponent } from '../confirm-modal/confirm-modal.component';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

  constructor(
    private modal: NgbModal
  ) { }

  confirm(header: string, message: string): Promise<any>{
    const dialogModal = this.modal.open(ConfirmModalComponent);
    dialogModal.componentInstance.dialog.header = header;
    dialogModal.componentInstance.dialog.message = message;

    return dialogModal.result;
  }
}
