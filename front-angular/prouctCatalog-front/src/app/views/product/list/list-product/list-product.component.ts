import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import { Product } from 'src/models/Product';
import { ProductService } from 'src/app/service/product.service';


@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.scss'],
  providers: [ProductService, MessageService, ConfirmationService]
})
export class ListProductComponent implements OnInit {

  productDialog: boolean = false;

  products: Product[] = [];

  product: Product = { description: '', name: '', price: 0.00 };

  submitted: boolean = false;

  constructor(private productService: ProductService, private messageService: MessageService, private confirmationService: ConfirmationService) {}

  ngOnInit() {
    this.productService.get().toPromise().then(data => this.products = data);
  }

  openNew() {
    this.product = { description: '', name: '', price: 0.00 };
    this.submitted = false;
    this.productDialog = true;
  }


  editProduct(product: Product) {
    this.product = { ...product };
    this.productDialog = true;
  }

  deleteProduct(product: Product) {
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete ' + product.name + '?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        
        this.productService.delete(product.id!).subscribe(r => console.log('delete'));
        this.products = this.products.filter(val => val.id !== product.id);
        this.product = { description: '', name: '', price: 0.00 };
        this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Deleted', life: 3000 });
      }
    });
  }

  hideDialog() {
    this.productDialog = false;
    this.submitted = false;
  }

  saveProduct() {
    this.submitted = true;

    if (this.product.name.trim()) {
      if (this.product.id) {
        this.productService.put(this.product, this.product.id).toPromise()
          .then(prod => {
            console.log(prod)
            this.products[this.findIndexById(this.product.id!)] = prod;
            this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Updated', life: 3000 });
          })
          .catch(e => this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Product Updated fail', life: 3000 }));
      }
      else {
        this.productService.post(this.product).toPromise()
        .then(prod => {
            this.products.push(prod);
            this.products = [...this.products];
            this.messageService.add({ severity: 'success', summary: 'Successful', detail: 'Product Created', life: 3000 });
          })
          .catch(e => this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Product Updated fail', life: 3000 }));
      }

      this.productDialog = false;
      this.product = { description: '', name: '', price: 0.00 };
    }
  }

  findIndexById(id: string): number {
    let index = -1;
    for (let i = 0; i < this.products.length; i++) {
      if (this.products[i].id === id) {
        index = i;
        break;
      }
    }

    return index;
  }
}

