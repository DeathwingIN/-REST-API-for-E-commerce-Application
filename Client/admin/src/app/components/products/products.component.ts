import { Component } from '@angular/core';
import {MatDialog} from "@angular/material/dialog";
import {NewProductComponent} from "./inner-pages/new-product/new-product.component"
import {UpdateProductComponent} from "./inner-pages/update-product/update-product.component"
import{ManageProdcutImagesComponent} from "./inner-pages/manage-prodcut-images/manage-prodcut-images.component"

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrl: './products.component.scss'
})
export class ProductsComponent {

  constructor(private matDialog: MatDialog) { }
  openNewProductDialogForm() {
    let matDialogRef = this.matDialog.open(NewProductComponent,{
      width:'500px',
      disableClose:true
    });


    matDialogRef.afterClosed().subscribe(response=>{
      if(response){
        this.localAllProducts();
      }
    })
  }

  private localAllProducts(){

  }


  openUpdateProductDialogForm(product:any) {
    let matDialogRef = this.matDialog.open(UpdateProductComponent,{
      width:'500px',
      disableClose:true,
      data:product,
    });


    matDialogRef.afterClosed().subscribe(response=>{
      if(response){
        this.localAllProducts();
      }
    })
  }

  openProductImageForm(product:any) {
    let matDialogRef = this.matDialog.open(ManageProdcutImagesComponent,{
      width:'500px',
      disableClose:true,
      data:product,
    });


    matDialogRef.afterClosed().subscribe(response=>{
      if(response){
        this.localAllProducts();
      }
    })
  }



}
