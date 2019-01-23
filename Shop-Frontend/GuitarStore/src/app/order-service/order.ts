import {Orders_details} from './order_details';

export class Orders {
  id: number;
  orderDate: Date;
  user: number;
  state: number;
  ordersDetails: Orders_details;
}
