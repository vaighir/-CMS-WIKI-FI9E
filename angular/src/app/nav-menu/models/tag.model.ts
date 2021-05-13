export class Tag {
    public readonly id?: number;
    public name: String;

    constructor(id?: number){
        this.id = id;
        this.name = '';
    }
    public static createFromObj(obj: Partial<Tag>): Tag{
        const tag = new Tag(obj.id);
    
        tag.name = obj.name || '';
       
        return tag;

    }
}
