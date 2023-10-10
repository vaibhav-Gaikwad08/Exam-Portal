import { Component, OnInit } from '@angular/core';
import { CategoryService } from 'src/app/services/category.service';
import { QuizService } from 'src/app/services/quiz.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-reports',
  templateUrl: './reports.component.html',
  styleUrls: ['./reports.component.css']
})
export class ReportsComponent implements OnInit {
  currentDate = new Date();
  categories = [];
  quizzes = [];
  

  attempt: Attempts = {
    candidate_name: "",
    quiz_title: "",
    maxMarks: "",
    obtainedMark: "",
    quiz_category: "",
    attempted_date: ""
  };

  constructor(private _category: CategoryService, private _quiz: QuizService) {}

  ngOnInit(): void {
    this._category.categories().subscribe(
      (data: any) => {
        //css
        this.categories = data;
        console.log(this.categories);
      },

      (error) => {
        //
        console.log(error);
        Swal.fire('Error !!', 'Error in loading data', 'error');
      }
    );

    this._quiz.quizzes().subscribe(
      (data: any) => {
        this.quizzes = data;
        console.log(this.quizzes);
      },
      (error) => {
        console.log(error);
        Swal.fire('Error !', 'Error in loading data !', 'error');
      }
    );
    this._quiz.getAttemptQuiz().subscribe(any=>{
      this.attempt = any;
    },er=>{
      console.log("Unable to load quiz attempts");
    })
  }
  
onSelect(category){
  this._quiz.getAttemptQuizByCategory(category).subscribe(any=>{
    this.attempt = any;
  });
}

onSelectQuizes(quiz){
  this._quiz.getAttemptQuizByQuizeName(quiz).subscribe(any=>{
    this.attempt = any;
  });
}
  deleteQuiz(qId) {
    Swal.fire({
      icon: 'info',
      title: 'Are you sure ?',
      confirmButtonText: 'Delete',
      showCancelButton: true,
    }).then((result) => {
      if (result.isConfirmed) {
        //delete...

        this._quiz.deleteQuiz(qId).subscribe(
          (data) => {
            this.quizzes = this.quizzes.filter((quiz) => quiz.qId != qId);
            Swal.fire('Success', 'Quiz deleted ', 'success');
          },
          (error) => {
            Swal.fire('Error', 'Error in deleting quiz', 'error');
          }
        );
      }
    });
  }
}



interface Attempts {
  candidate_name: String,
  quiz_title: String,
  maxMarks: String,
  obtainedMark: String,
  quiz_category: String,
  attempted_date: String
};