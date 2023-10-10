import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  constructor(private userService: UserService, private snack: MatSnackBar) {}

  public user = {
    username: '',
    password: '',
    firstName: '',
    lastName: '',
    email: '',
    phone: '',
  };

  ngOnInit(): void {}

  formSubmit() {
    console.log(this.user);
    if (!this.validateUserName(this.user.username)) {
      // alert('User is required !!');
      this.snack.open('Enter valid User Name !! ', '', {
        duration: 3000,
      });
      return;
    }

    if (!this.validatePassword(this.user.password)) {
      // alert('User is required !!');
      this.snack.open('Enter valid Password !! ', '', {
        duration: 3000,
      });
      return;
    }
    if (!this.validateName(this.user.firstName)) {
      this.snack.open('Invalid first name!', '', {
        duration: 3000,
      });
      return;
    }

    if (!this.validateName(this.user.lastName)) {
      this.snack.open('Invalid last name!', '', {
        duration: 3000,
      });
      return;
    }

    if (!this.validateEmail(this.user.email)) {
      this.snack.open('Invalid Email Address!', '', {
        duration: 3000,
      });
      return;
    }

    if (!this.validatePhone(this.user.phone)) {
      this.snack.open('Enter only 10 digit phone no.!', '', {
        duration: 3000,
      });
      return;
    }
    
    

    //validate

    //addUser: userservice
    this.userService.addUser(this.user).subscribe(
      (data: any) => {
        //success
        console.log(data);
        //alert('success');
        Swal.fire('Successfully done !!', 'User id is ' + data.id, 'success');
      },
      (error) => {
        //error
        console.log(error);
        // alert('something went wrong');
        this.snack.open(error.error.text, '', {
          duration: 3000,
        });
      }
    );
  }
  validateUserName(name: string): boolean {
    // Regular expression pattern to match only letters (uppercase or lowercase) and spaces
    const pattern = /^[a-zA-Z0-9_-]{4,16}$/;
    return pattern.test(name);
  }
  validatePassword(password: string): boolean {
    // Regular expression pattern to match only letters (uppercase or lowercase) and spaces
    const pattern = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])/;
    return pattern.test(password);
  }
  validateName(name: string): boolean {
    // Regular expression pattern to match only letters (uppercase or lowercase) and spaces
    const pattern = /^[a-zA-Z\s]+$/;
    return pattern.test(name);
  }
  validateEmail(name: string): boolean {
    // Regular expression pattern to match only letters (uppercase or lowercase) and spaces
    const pattern = /^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$/;
    return pattern.test(name);
  }
  validatePhone(phone: string): boolean {
    // Regular expression pattern to match 10 digits
    const pattern = /^\d{10}$/;
    return pattern.test(phone);
  }
  //this.user
}

