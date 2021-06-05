export class User {
    public readonly id? : number;
    public name: String;
    public email: String;
    public password: String;

    constructor(id?: number){
        this.id = id;
        this.name = '';
        this.email = '';
        this.password = '';
    }

    public static createFromObj(obj: Partial<User>): User {
        const user = new User(obj.id);
        user.name = obj.name || '';
        user.email = obj.email || '';
        user.password = obj.password || '';

        return user;
    }
}