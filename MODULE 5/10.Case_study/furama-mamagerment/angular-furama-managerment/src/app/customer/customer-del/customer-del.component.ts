import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-customer-del',
  templateUrl: './customer-del.component.html',
  styleUrls: ['./customer-del.component.css']
})
export class CustomerDelComponent implements OnInit {
  id: number;
  constructor(
    public dialogRef: MatDialogRef<CustomerDelComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
  ) { }

  onNoClick(): void {
    this.dialogRef.close();
  }

  ngOnInit(): void {
    this.id= this.data;
  }

}
