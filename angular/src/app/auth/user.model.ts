export class User {
    id: Number = 0;
    email: string = "";
    username: string = "";
    isExpiredToken: boolean = true;
    
    isLoggedIn() {
        return this.id > 0 && !this.isExpiredToken;
    }
}