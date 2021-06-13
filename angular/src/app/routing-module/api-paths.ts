import { HttpHeaders } from "@angular/common/http";
import { environment } from "src/environments/environment";

export const HeadersForms = { headers: {
  'Accept': 'application/json',
  'Content-Type': 'application/x-www-form-urlencoded',
}};

export const HeadersJSON = { headers: {
  'Accept': 'application/json',
  'Content-Type': 'application/json',
}};

//defines all API paths we need in app
export abstract class ApiRoutes {
  //change this to localhost, for prod!
  private static host: string = environment.host;
  private static api_path: string = "/RestAPI/v1/";
  
  public static uri = {
    CATEGORYLIST_SHOW: ApiRoutes.path(),
    
    ARTICLE_ADD: ApiRoutes.path() + "article/add",//Method: POST
    ARTICLE_SHOW: ApiRoutes.path() + "article/", //+id | Method: GET
    ARTICLELIST_SHOW: ApiRoutes.path() + "article/all", // | Method: GET
    ARTICLELISTBYCATEGORY_SHOW: ApiRoutes.path() + "article/category/", // +categoryId| Method: GET
    ARTICLE_UPDATE: ApiRoutes.path() + "article/", //+id | Method: PUT
    ARTICLE_DELETE: ApiRoutes.path() + "article/", //+id | Method: DELETE
    
    LOGIN: ApiRoutes.path() + "login", //form with credentials
    REGISTER: ApiRoutes.path() + "register", //form with credentials
    LOGOUT: ApiRoutes.path() + "logout",
    
    USERLIST_SHOW: ApiRoutes.path() + "user/all", // | Method: GET
    USER_ADD: ApiRoutes.path() + "user/register",//Method: POST

  }

  private static path() {
    return this.host + this.api_path;
  }
}