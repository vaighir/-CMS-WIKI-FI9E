
//defines all API paths we need in app
export abstract class ApiRoutes {
  //change this to localhost, for prod!
  private static host: string = "http://localhost:4200";
  private static api_path: string = "/RestAPI/v1/";
  
  public static uri = {
    ARTICLE_ADD: ApiRoutes.path() + "article/add",
    ARTICLE_SHOW: ApiRoutes.path() + "article/", //+id
    TAGLIST_SHOW: ApiRoutes.path()
  }

  private static path() {
    return this.host + this.api_path;
  }
}