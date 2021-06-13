export class User {
    public id : number;
    public username: String;
    public email: String;
    public password: String;

    constructor() {
        this.id = 0;
        this.username = '';
        this.email = '';
        this.password = '';
    }

    public static createFromObj(obj: Partial<User>): User {
        const user = new User();
        user.id = obj.id || 0;
        user.username = obj.username || '';
        user.email = obj.email || '';
        user.password = obj.password || '';

        return user;
    }
}