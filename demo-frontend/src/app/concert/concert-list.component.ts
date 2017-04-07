import {OnInit, Component} from "@angular/core";
import {Concert} from "./concert";
import {ConcertService} from "./concert.service";
@Component({
  selector: 'concert-list',
  templateUrl: './concert-list.component.html'

})

export class ConcertListComponent implements OnInit {
  errorMessage: string;
  concerts: Concert[];


  constructor(private concertService: ConcertService) {
  }

  ngOnInit() {
    this.getConcerts();
    console.log(this.getConcerts());
  }

  getConcerts() {

    this.concertService.getConcerts()
      .subscribe(
        concerts => this.concerts = concerts,
        error => this.errorMessage = <any>error);
  }

}
