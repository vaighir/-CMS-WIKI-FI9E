import { Component, Input, OnInit } from '@angular/core';
import { Tag } from '../../models/tag.model';

@Component({
  selector: 'app-tag',
  templateUrl: './tag.component.html',
  styleUrls: ['./tag.component.scss']
})
export class TagComponent implements OnInit {
  @Input() tag: any;
  constructor() { 
    this.tag = null;
  }

  ngOnInit(): void {
    console.log('tag', this.tag);
  }

}
