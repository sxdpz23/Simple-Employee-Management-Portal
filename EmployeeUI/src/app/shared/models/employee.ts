import { EmployeeTraining } from "./employeeTraining"

export class Employee {
    employeeId!: number
    name!: string
    location!: string
    phone1!: string
    phone2!: string
    email!: string
    training!: EmployeeTraining
}