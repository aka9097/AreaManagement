import { User } from "./User";

export class Genie
{
	public id!: number;
    public name!:string ;
	public severity!:string ;
	public description!:string ;
	public date!:Date ;
	public status!:boolean ;
    public users!:User;
}