var Employee = /** @class */ (function () {
    function Employee(id, name, gender, email, contact_no, password) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.contact_no = contact_no;
        this.password = password;
        this.vehicle = undefined;
        this.vehiclePass = undefined;
    }
    return Employee;
}());
