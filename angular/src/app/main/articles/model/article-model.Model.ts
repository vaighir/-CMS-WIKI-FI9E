import { Deserializable } from "src/app/interfaces/deserializable.model";
import { Category } from "src/app/nav-menu/models/category.model";

export class ArticleModel implements Deserializable {
    id: number = 0;
    name: String = "";
    slug: String = "";
    category: Category = new Category();
    content: String = "";
    created_at: String = "";
    updated_at: String = "";

    deserialize(input: any) : ArticleModel {
        Object.assign(this, input);
        
        return this;
    }

    static getCreatedAt(dateString: string) : String {
        return new Date(dateString).toLocaleDateString('de-DE');
    }
}