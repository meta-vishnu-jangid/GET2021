class Employee {
    public id: Number;
    public name: String;
    public gender: String;
    public email: String;
    public contact_no: String;
    public password: String;
    public vehicle: Object;
    public vehiclePass: Object;

    public constructor(id: Number, name: String, gender: String, email: String, contact_no: String, password: String) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.contact_no = contact_no;
        this.password = password;
        this.vehicle = undefined;
        this.vehiclePass = undefined;
    }
}