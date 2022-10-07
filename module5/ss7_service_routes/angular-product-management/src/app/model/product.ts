import {Category} from './category';

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  description?: string;
  dateImport: Date;
  dateProduce: Date;
  dateEnd: Date;
  category?: Category;
}
