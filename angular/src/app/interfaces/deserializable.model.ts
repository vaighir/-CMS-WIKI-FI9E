import { ArticleModel } from "../main/articles/model/article-model.Model";

export interface Deserializable {
    deserialize(input: any): ArticleModel;
}