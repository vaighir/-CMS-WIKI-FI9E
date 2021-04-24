
export class ArticleModel {
  id: number = 0;
  name: String = "";
  slug: String = "";
  content: String = "";
  created_at: String = ""; //@TODO: mayber TypeScript Timestamp pendant?
  updated_at: String = "";

  //@TODO: add methods to convert datetime strings into //RFC 3339 format Dates
}
