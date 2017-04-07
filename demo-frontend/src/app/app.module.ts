import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {HttpModule} from "@angular/http";
import {AppComponent} from "./app.component";
import {ConcertListComponent} from "./concert/concert-list.component";
import {ConcertService} from "./concert/concert.service";
import {DataTableModule} from "primeng/components/datatable/datatable";

@NgModule({
  declarations: [
    AppComponent , ConcertListComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,DataTableModule
  ],
  providers: [ConcertService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
