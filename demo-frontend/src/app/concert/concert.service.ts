import {Injectable} from "@angular/core";
import { Http, Response }          from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import {Concert} from "./concert";

@Injectable()
export class ConcertService {

  private concertsUrl = 'http://localhost:8080/demo/resources/concerts';  // URL to web API
  constructor(private http: Http) {
  }

  getConcerts(): Observable<Concert[]> {
    return this.http.get(this.concertsUrl)
      .map(this.extractData)
      .catch(this.handleError);
  }

  private extractData(res: Response) {

    let body = res.json();

    return body || {};
  }

  private handleError(error: Response | any) {

    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }
}
