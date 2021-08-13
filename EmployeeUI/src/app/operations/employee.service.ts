import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Employee } from 'src/app/shared/models/employee';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private headers = new HttpHeaders({ 'Content-Type': 'application/json' })

  constructor(private http: HttpClient) { }

  addService(employeeToAdd: Employee): Observable<string> {
    return this.http.post<string>(environment.employeeAPIUrl, employeeToAdd, { responseType: 'text' as 'json' }).pipe(catchError(this.handleError))
  }

  viewService() {
    return this.http.get<Employee[]>(environment.employeeAPIUrl).pipe(catchError(this.handleError))
  }

  getService(employeeId: number) {
    return this.http.get<Employee>(environment.employeeAPIUrl + '/' + employeeId).pipe(catchError(this.handleError))
  }

  updateService(employee: Employee): Observable<string> {
    return this.http.put<string>(environment.employeeAPIUrl, employee, { responseType: 'text' as 'json' }).pipe(catchError(this.handleError))
  }

  deleteService(employeeId: number): Observable<string> {
    return this.http.delete<string>(environment.employeeAPIUrl + '/' + employeeId, { headers: this.headers, responseType: 'text' as 'json' }).pipe(catchError(this.handleError))
  }

  private handleError(error: HttpErrorResponse) {
    let errorMsg: string = ''
    if (error.status == 400)
      errorMsg = 'The request can not be processed at the moment. Please try again later or connect with administrator.'
    // else if (error.status == 404)
    //   errorMsg = 'The resources you are looking for is not available. Please try again later or connect with administrator.'
    else {
      if (error.error instanceof Error) 
        errorMsg = error.error.message
      else if (typeof error.message === 'string') 
        errorMsg = error.error
        // errorMsg = JSON.parse(error.error).message
      else {
        if (error.status == 0)
          errorMsg = 'A connection to backend cannot be established.'
        else
          errorMsg = error.error.message
      }
    }
    return throwError(errorMsg);
  }

}
