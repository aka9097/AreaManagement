import { Location } from './location';

import { Address } from "./address";
import { Genie } from "./genie";

export class User
{
        public id!:number;	
		public  aadhar!: number;
		public userName!:string;
		public email!:string;
		public password!:string;
		public phone!:number;
		public role!:string;
		public location:Location=new Location();
		public genie!:Genie[];
		public address:Address=new Address() ;
	
   
}