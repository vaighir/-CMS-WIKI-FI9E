export class User {
    public readonly id? : number;
    public firstname: String;
    public lastname: String;
    public email: String;
    public password: String;
    public confirmPassword: String;

    constructor(id?: number){
        this.id = id;
        this.firstname = '';
        this.lastname = '';
        this.email = '';
        this.password = '';
        this.confirmPassword = '';
    }

    public static createFromObj(obj: Partial<User>): User {
        const user = new User(obj.id);
        user.firstname = obj.firstname || '';
        user.lastname = obj.lastname || '';
        user.email = obj.email || '';
        user.password = obj.password || '';
        user.confirmPassword = obj.confirmPassword || '';


        return user;
    }
}