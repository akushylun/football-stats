import {Component, OnInit} from '@angular/core';
import {Http, Response, RequestOptions, Headers} from '@angular/http';

@Component({
  selector: 'app-teams-list',
  templateUrl: './teams-list.component.html'
})
export class TeamsListComponent implements OnInit {

  loading: boolean;
  data: object;

  constructor(private http: Http) {
  }

  makeRequest(): void {
    const username = 'admin';
    const password = 'pass';
    const headers: Headers = new Headers();

    headers.append('Authorization', 'Basic ' + btoa(username + ':' + password));
    headers.append('Content-Type', 'application/x-www-form-urlencoded');

    const opts: RequestOptions = new RequestOptions();
    opts.headers = headers;

    this.loading = true;
    this.http.request('http://localhost:8080/teams', opts)
      .subscribe((res: Response) => {
        this.data = res.json();
        this.loading = false;
      });
  }

  ngOnInit() {
  }

}
