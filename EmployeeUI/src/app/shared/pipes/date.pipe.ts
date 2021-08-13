import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'datePipe'
})
export class DatePipe implements PipeTransform {

  transform(value: string): string {
    if(value == null) 
      return '';
    const array = value.split('-')
    const monthNames = ["January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December" ];
    return ''+array[2]+' '+monthNames[parseInt(array[1])]+' '+array[0]
  }

}
