import {Http} from '@angular/http';
import {Injectable} from '@angular/core';

@Injectable()
export class JournalService {
  constructor(public http: Http) {
  }

  getTest() {
    return this.http.get('http://localhost:8888/music/journal/222');
  }

}