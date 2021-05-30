import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './views/header/header.component';
import { LandingPageComponent } from './views/landing-page/landing-page.component';
import { MainLayoutComponent } from './views/main-layout/main-layout.component';
import { MenubarModule } from 'primeng/menubar';
import { TabViewModule } from 'primeng/tabview';
import { ListProductComponent } from './views/product/list/list-product/list-product.component';
import {TableModule} from 'primeng/table';
import {ToastModule} from 'primeng/toast';
import {CalendarModule} from 'primeng/calendar';
import {SliderModule} from 'primeng/slider';
import {MultiSelectModule} from 'primeng/multiselect';
import {ContextMenuModule} from 'primeng/contextmenu';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule} from 'primeng/button';
import {DropdownModule} from 'primeng/dropdown';
import {ProgressBarModule} from 'primeng/progressbar';
import {InputTextModule} from 'primeng/inputtext';
import {FileUploadModule} from 'primeng/fileupload';
import {ToolbarModule} from 'primeng/toolbar';
import {RatingModule} from 'primeng/rating';
import {RadioButtonModule} from 'primeng/radiobutton';
import {InputNumberModule} from 'primeng/inputnumber';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { InputTextareaModule } from 'primeng/inputtextarea';
import {MessagesModule} from 'primeng/messages';
import {MessageModule} from 'primeng/message';



@NgModule({
  declarations: [
    AppComponent,
    MainLayoutComponent,
    LandingPageComponent,
    HeaderComponent,
    ListProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,

    /* prime */
    MenubarModule,
    InputTextModule,
    ButtonModule,
    TabViewModule,
    BrowserModule,
    TableModule,
    CalendarModule,
		SliderModule,
		DialogModule,
		MultiSelectModule,
		ContextMenuModule,
		DropdownModule,
		ButtonModule,
		ToastModule,
    InputTextModule,
    ProgressBarModule,
    FileUploadModule,
    ToolbarModule,
    RatingModule,
    RadioButtonModule,
    InputNumberModule,
    ConfirmDialogModule,
    InputTextareaModule,
    MessagesModule,
    MessageModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
