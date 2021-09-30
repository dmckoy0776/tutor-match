import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Tutor } from './tutor';
import { TutorService } from './tutor.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'tutor-match-app';
  public tutors: Tutor[] =[];

  constructor(private tutorService: TutorService) {}

  ngOnInit(){
    this.getTutors();
  }

  public getTutors(): void {
    this.tutorService.getTutors().subscribe(
      (response: Tutor[]) => {
        this.tutors = response;
      },
      (error : HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }


}
