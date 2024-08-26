import {Component, inject} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ProductService} from '../../../../service/product/product.service'
import {MatDialogRef} from '@angular/material/dialog';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-new-product',
  templateUrl: './new-product.component.html',
  styleUrl: './new-product.component.scss'
})
export class NewProductComponent {

  readonly dialogRef = inject(MatDialogRef<NewProductComponent>)
  readonly productService = inject(ProductService);


  form = new FormGroup({
    qty: new FormControl('', [Validators.required]),
    unitPrice: new FormControl('', [Validators.required]),
    description: new FormControl('', [Validators.required]),
  })

  create() {
    const obj = {
      qty: this.form.value.qty,
      unitPrice: this.form.value.unitPrice,
      description: this.form.value.description,
    }
    this.productService.create(obj).subscribe(
      response => {
        this.dialogRef.close(true)
      },
      (error: HttpErrorResponse) => {
        console.error('Error status:', error.status);
        console.error('Error message:', error.message);
        console.error('Error details:', error);
      }
    );

  }

  close() {
    this.dialogRef.close(false);
  }


}
