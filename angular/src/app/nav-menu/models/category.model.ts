export class Category {
    public readonly id?: number;
    public name: String;
    public description: String;

    constructor(id?: number){
        this.id = id;
        this.name = '';
        this.description = '';
    }
    public static createFromObj(obj: Partial<Category>): Category{
        
        const category = new Category(obj.id);
        category.name = obj.name || '';
        category.description = obj.description || '';
       
        return category;
    }

}
