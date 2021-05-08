
//defines all API paths we need in app
export abstract class ApiRoutes {
  private static host: string = "http://localhost:8080";
  private static api_path: string = "/RestAPI/v1/";
  
  public static uri = {
    ARTICLE_ADD: ApiRoutes.path() + "article/add"
  }

  private static path() {
    return this.host + this.api_path;
  }
}