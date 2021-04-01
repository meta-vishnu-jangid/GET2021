class Vehicle {
    constructor(vehicleCompany, vehicleModel, vehicleType, vehicleNo, identification) {
        this.vehicleCompany = vehicleCompany;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.vehicleNo = vehicleNo;
        this.identification = identification;
    }
}

class VehiclePass {
    constructor(vehicleType, duration, totalPrice) {
        this.time = new Date();
        this.vehicleType = vehicleType;
        this.duration = duration;
        this.totalPrice = totalPrice;
    }
}

class Employee {
    constructor(id, name, gender, email, contact_no, password) {
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

var activeForm = 0;
var activeInput = 0;
var employeeIdCount = 1;

var currencyConversion = { "usd-inr": 75, "usd-yen": 60 };
var priceList = { "fourWheeler": { "day": 20, "month": 500, "year": 3500 }, "cycle": { "day": 5, "month": 100, "year": 500 }, "motorCycle": { "day": 10, "month": 200, "year": 1000 } };

var employeeName = undefined;
var addedEmployee = undefined;
var addedVehicle = undefined;


var helpText = document.getElementsByClassName("helpText")[activeForm];
var collapsibleForms = document.getElementsByClassName("collapsible");
var inputTags = document.getElementsByTagName("input");
var textAreaTags = document.getElementsByTagName("textarea");

for (index = 0; index < textAreaTags.length; index++) {
    textAreaTags[index].addEventListener("keyup", function(event) {
        if (event.key === "Enter") {
            increamentActiveInput();
        }
    });
}

for (index = 0; index < inputTags.length; index++) {
    inputTags[index].addEventListener("keyup", function(event) {
        if (event.key === "Enter") {
            if (validate(event.target)) {
                if (event.target.getAttribute("type") == "password" && event.target.getAttribute("name") == "rePassword") {
                    if (validateConfirmPassword(event.target)) {
                        increamentActiveInput();
                    } else {
                        alert("Passwords Does Not Match");
                    }
                } else if (event.target.getAttribute("type") == "password") {
                    if (validatePassword(event.target)) {
                        increamentActiveInput();
                    } else {
                        alert("Passwords does not match criteria");
                    }
                } else {
                    if (activeForm == 0 && activeInput == 0) {
                        employeeName = document.getElementById("addEmployeeForm")['fullName'].value;
                    }
                    increamentActiveInput();
                }
            } else {
                alert("Wrong Input");
            }
        }
    });
}

collapseFormExceptActiveForm(activeForm, collapsibleForms);
collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms);

function collapseFormExceptActiveForm(activeForm, collapsibleForms) {
    for (index = 0; index < collapsibleForms.length; index++) {
        if (activeForm != index) {
            collapsibleForms[index].classList.add("collapsed");
        } else {
            collapsibleForms[index].classList.remove("collapsed");
        }
    }
}

function collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms) {
    var formInputs = collapsibleForms[activeForm].querySelectorAll(".form-input");
    helpText = document.getElementsByClassName("helpText")[activeForm]
    for (index = 0; index < formInputs.length; index++) {
        if (index == activeInput) {
            if (activeForm != 2) {
                if (employeeName != undefined) {
                    helpText.innerText = "Hi " + employeeName + "! " + formInputs[index].getAttribute("title");
                } else {
                    helpText.innerText = formInputs[index].getAttribute("title");
                }
                formInputs[index].style.display = "inline-block";
                formInputs[index].focus();
            }

        } else {
            formInputs[index].style.display = "none";
        }
    }
}

function addEmployee(e) {
    e.preventDefault();
    var addEmployeeForm = document.getElementById("addEmployeeForm");
    var name = addEmployeeForm['fullName'].value;
    var gender = addEmployeeForm['gender'].value;
    var email = addEmployeeForm['email'].value;
    var password = addEmployeeForm['password'].value;
    var contactNo = addEmployeeForm['contactNo'].value;
    addedEmployee = new Employee(employeeIdCount, name, gender, email, contactNo, password);
    var addVehicleForm = document.getElementById("addVehicleForm");
    console.log(addVehicleForm);
    addVehicleForm['employeeId'].value = employeeIdCount;
    employeeIdCount++;
    activeForm++;
    activeInput = 0;
    alert("Your Employee ID : " + addedEmployee.id);
    collapseFormExceptActiveForm(activeForm, collapsibleForms);
    collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms);
}

function addVehicle(e) {
    e.preventDefault();
    var addVehicleForm = document.getElementById("addVehicleForm");
    var employeeId = addVehicleForm['employeeId'].value;
    if (employeeId == addedEmployee.id) {
        var vehicleCompany = addVehicleForm['vehicleCompany'].value;
        var vehicleModel = addVehicleForm['vehicleModel'].value;
        var vehicleType = addVehicleForm['vehicleType'].value;
        var vehicleNo = addVehicleForm['vehicleNo'].value;
        var identification = addVehicleForm['identification'].value;
        addedVehicle = new Vehicle(vehicleCompany, vehicleModel, vehicleType, vehicleNo, identification);
        addedEmployee.vehicle = addedVehicle;
        console.log(addedEmployee);
        activeForm++;
        activeInput = 0;
        updatePrice("day", "usd");
        updatePrice("month", "usd");
        updatePrice("year", "usd");
        collapseFormExceptActiveForm(activeForm, collapsibleForms);
        collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms);
    } else {
        alert("Wrong Employee ID");
    }
}

function updatePrice(duration, currency) {
    var newPrice = undefined;
    if (currency == "usd") {
        newPrice = "$ " + priceList[addedVehicle.vehicleType][duration];
    } else if (currency == "inr") {
        newPrice = "&#x20b9; " + (priceList[addedVehicle.vehicleType][duration] * currencyConversion["usd-inr"]);
    } else if (currency == "yen") {
        newPrice = "&#165;" + (priceList[addedVehicle.vehicleType][duration] * currencyConversion["usd-yen"]);
    }
    if (duration == "day") {
        document.getElementById("dayPrice").innerHTML = newPrice;
    } else if (duration == "year") {
        document.getElementById("yearPrice").innerHTML = newPrice;
    } else if (duration == "month") {
        document.getElementById("monthPrice").innerHTML = newPrice;
    }
}

function buyPass(duration) {
    var addedPass = undefined;
    if (duration == "day") {
        addedPass = new VehiclePass(addedVehicle.vehicleType, 'day', priceList[addedVehicle.vehicleType][duration]);
    } else if (duration == "year") {
        addedPass = new VehiclePass(addedVehicle.vehicleType, 'day', priceList[addedVehicle.vehicleType][duration]);
    } else if (duration == "month") {
        addedPass = new VehiclePass(addedVehicle.vehicleType, 'day', priceList[addedVehicle.vehicleType][duration]);
    }
    console.log(addedPass);
    addedEmployee.vehiclePass = addedPass;
    activeForm++;
    activeInput = 0;
    alert("Pass purchased successfully");
    window.location.href = "http://127.0.0.1:5500/feedback.html#feedbackSection";
}

function increamentActiveInput() {
    activeInput++;
    collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms);
}

function validate(element) {
    var isValid = undefined;
    if (element.checkValidity() && element.value != "") {
        element.classList.add("border-success");
        element.classList.remove("border-danger");
        isValid = true;
    } else {
        element.classList.remove("border-success");
        element.classList.add("border-danger");
        isValid = false;
    }
    return isValid;
}

var password = undefined;

function validatePassword(element) {
    var isValid = undefined;
    if (element.checkValidity() && element.value != "" && /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/.test(element.value)) {
        password = element.value;
        element.classList.add("border-success");
        element.classList.remove("border-danger");
        isValid = true;
    } else {
        element.classList.remove("border-success");
        element.classList.add("border-danger");
        isValid = false;
    }
    return isValid;
}

function validateConfirmPassword(element) {
    if (element.value == password) {
        return true;
    } else {
        return false;
    }
}