import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TripsComponent} from "./trips/trips.component";
import {HistoryComponent} from "./history/history.component";
import {CreateComponent} from "./create/create.component";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'trips', component: TripsComponent },
  { path: 'history', component: HistoryComponent },
  { path: 'create', component: CreateComponent },
  { path: 'login', component: LoginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
