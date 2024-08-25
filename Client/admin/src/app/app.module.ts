import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { RouterLink } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginPageComponent } from './components/login-page/login-page.component';
import { CustomersComponent } from './components/customers/customers.component';
import { MatIconModule } from '@angular/material/icon';
import {MatTooltip} from "@angular/material/tooltip";
import {MatButton, MatIconButton} from "@angular/material/button";
import { CustomerStatusManagerComponent } from './components/customers/inner/customer-status-manager/customer-status-manager.component';
import {MatSlideToggle} from "@angular/material/slide-toggle";
import { ProductsComponent } from './components/products/products.component';
import { NewProductComponent } from './components/products/inner-pages/new-product/new-product.component';
import { UpdateProductComponent } from './components/products/inner-pages/update-product/update-product.component';
import { ManageProdcutImagesComponent } from './components/products/inner-pages/manage-prodcut-images/manage-prodcut-images.component';
import {MatDialogActions, MatDialogClose, MatDialogContent, MatDialogTitle} from "@angular/material/dialog";
import { OrdersComponent } from './components/orders/orders.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginPageComponent,
    CustomersComponent,
    CustomerStatusManagerComponent,
    ProductsComponent,
    NewProductComponent,
    UpdateProductComponent,
    ManageProdcutImagesComponent,
    OrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterLink,
    MatIconModule,
    MatTooltip,
    MatIconButton,
    MatSlideToggle,
    MatDialogContent,
    MatDialogActions,
    MatDialogClose,
    MatButton,
    MatDialogTitle,
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
