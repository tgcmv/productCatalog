import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  items: MenuItem[] = [];

  ngOnInit() {
    this.items = [
      {
        label: 'Product',
        icon: 'pi pi-shopping-cart',
        items: [
          {
            label: 'New',
            icon: 'pi pi-fw pi-plus',

          },
          {
            label: 'Edit',
            icon: 'pi pi-fw pi-pencil',

          },
          {
            label: 'Delete',
            icon: 'pi pi-fw pi-trash',

          },
          {
            label: 'Search',
            icon: 'pi pi-fw pi-search',
            items: [
              {
                label: 'Filter',
                icon: 'pi pi-fw pi-filter',
              },
              {
                icon: 'pi pi-fw pi-bars',
                label: 'List'
              }
            ]
          }
        ]
      }
    ];
  }
}
