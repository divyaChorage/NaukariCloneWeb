import { Component } from '@angular/core';
import { ApplydriveComponent } from '../applydrive.component';

@Component({
  selector: 'app-viewapplycompany',
  templateUrl: './viewapplycompany.component.html',
  styleUrls: ['./viewapplycompany.component.css']
})
export class ViewapplycompanyComponent {

  loadAppliedCompanies:any
  constructor(private applydrivw:ApplydriveComponent)
  {
    this.loadAppliedCompanies=this.applydrivw.loadAppliedCompanies
  }
}
