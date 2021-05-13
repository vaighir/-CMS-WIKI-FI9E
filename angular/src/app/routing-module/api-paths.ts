
//defines all API paths we need in app
export abstract class ApiRoutes {
  //change this to localhost, for prod!
  private static host: string = "http://localhost:4200";
  private static api_path: string = "/RestAPI/v1/";
  
  public static uri = {
    TAGLIST_SHOW: ApiRoutes.path(),
    ARTICLE_ADD: ApiRoutes.path() + "article/add",//Method: POST
    ARTICLE_SHOW: ApiRoutes.path() + "article/", //+id | Method: GET
    ARTICLE_UPDATE: ApiRoutes.path() + "article/", //+id | Method: PUT
    ARTICLE_DELETE: ApiRoutes.path() + "article/", //+id | Method: DELETE
  }

  private static path() {
    return this.host + this.api_path;
  }
}