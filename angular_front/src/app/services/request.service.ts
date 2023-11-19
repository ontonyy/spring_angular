import {Injectable} from '@angular/core';
import {HelloResponse} from "../models/models";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RequestService {
  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/api/tripto/user';
  }

  public getHelloResponse(): Observable<HelloResponse> {
    return this.http.get<HelloResponse>(this.usersUrl + "/hello");
  }
}
