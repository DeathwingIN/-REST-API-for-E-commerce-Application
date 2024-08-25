import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import{LoginPageComponent} from './components/login-page/login-page.component';
import{DashboardComponent} from './components/dashboard/dashboard.component';
import{CustomersComponent} from './components/customers/customers.component';
import{ProductsComponent} from './components/products/products.component';

const routes: Routes = [
  {path:'',redirectTo:'/login',pathMatch:'full'},
  {path:'login',component:LoginPageComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'customers',component:CustomersComponent},
  {path:'products',component:ProductsComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
