import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tutor } from './tutor';

@Injectable({
  providedIn: 'root'
})
export class TutorService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getTutors(): Observable<Tutor[]> {
    return this.http.get<Tutor[]>(`${this.apiServerUrl}/tutor/find-all`);
  }

  public addTutor(tutor: Tutor): Observable<Tutor> {
    return this.http.post<Tutor>(`${this.apiServerUrl}/tutor/add`, tutor);
  }

  public updateTutor(tutor: Tutor): Observable<Tutor> {
    return this.http.put<Tutor>(`${this.apiServerUrl}/tutor/update`, tutor);
  }

  public deleteTutor(tutorId: number): Observable<Tutor> {
    return this.http.delete<Tutor>(`${this.apiServerUrl}/tutor/remove/${tutorId}`);
  }


}
