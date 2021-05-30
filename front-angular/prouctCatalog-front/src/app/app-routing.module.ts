import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LandingPageComponent } from './views/landing-page/landing-page.component';
import { MainLayoutComponent } from './views/main-layout/main-layout.component';

const routes: Routes = [
  { path: '', component: MainLayoutComponent, children:[
    {path: '', component: LandingPageComponent}
  ] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
