
export class CategoryButtons {
    title!: string
    operation!: string
    icon!: string
    navigation!: string

    constructor(title: string, operation: string, icon: string, navigation: string) { 
        this.title = title
        this.operation = operation
        this.icon = icon
        this.navigation = navigation
    }
}