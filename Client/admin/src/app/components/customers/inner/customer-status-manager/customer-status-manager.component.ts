import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-customer-status-manager',
  templateUrl: './customer-status-manager.component.html',
  styleUrl: './customer-status-manager.component.scss'
})
export class CustomerStatusManagerComponent {
  @Input() customer: any;

}
