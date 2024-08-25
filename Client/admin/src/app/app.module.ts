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
import {MatIconButton} from "@angular/material/button";
import { CustomerStatusManagerComponent } from './components/customers/inner/customer-status-manager/customer-status-manager.component';
import {MatSlideToggle} from "@angular/material/slide-toggle";
import { ProductsComponent } from './components/products/products.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    LoginPageComponent,
    CustomersComponent,
    CustomerStatusManagerComponent,
    ProductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterLink,
    MatIconModule,
    MatTooltip,
    MatIconButton,
    MatSlideToggle,
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
