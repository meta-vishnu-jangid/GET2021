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
var passwordCriteriaDiv = document.getElementById("passwordCriteria");


var prevButtons = document.getElementsByClassName("prev-btn");
var nextButtons = document.getElementsByClassName("next-btn");


function refreshNavigationButtons() {
    if (activeForm < 2) {
        if (activeInput == 0) {
            prevButtons[activeForm].style.visibility = 'hidden';
        } else if (activeInput == 1) {
            prevButtons[activeForm].style.visibility = 'visible';
        } else if (activeForm == 0 && activeInput == 6) {
            nextButtons[activeForm].style.visibility = 'hidden';
        } else if (activeForm == 0 && activeInput == 5) {
            nextButtons[activeForm].style.visibility = 'visible';
        } else if (activeForm == 1 && activeInput == 6) {
            nextButtons[activeForm].style.visibility = 'hidden';
        } else if (activeForm == 1 && activeInput == 5) {
            nextButtons[activeForm].style.visibility = 'visible';
        }
    }
}

function collapseFormExceptActiveForm(activeForm, collapsibleForms) {
    for (index = 0; index < collapsibleForms.length; index++) {
        if (activeForm != index) {
            collapsibleForms[index].classList.add("collapsed");
        } else {
            collapsibleForms[index].classList.remove("collapsed");
        }
    }
    refreshNavigationButtons();
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

function showOrHidePasswordCriteria() {
    if (activeForm == 0 && activeInput == 4) {
        passwordCriteriaDiv.style.display = 'block';
    } else {
        passwordCriteriaDiv.style.display = 'none';
    }
}

function increamentActiveInput() {
    activeInput++;
    showOrHidePasswordCriteria();
    collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms);
}

function decrementActiveInput() {
    activeInput--;
    showOrHidePasswordCriteria();
    collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms);
}

refreshNavigationButtons();
collapseFormExceptActiveForm(activeForm, collapsibleForms);
collapseInputExceptActiveInput(activeForm, activeInput, collapsibleForms);

function showMessageIfNotValid(element) {
    if (validate(element)) {
        if (element.getAttribute("type") == "password" && element.getAttribute("name") == "rePassword") {
            if (validateConfirmPassword(element)) {
                increamentActiveInput();
            } else {
                alert("Confirm password does not match with password");
            }
        } else if (element.getAttribute("type") == "password") {
            if (validatePassword(element)) {
                increamentActiveInput();
            } else {
                alert("Password does not match criteria \n\n Note : Password must contain -> \n1. Minimum 8 characters \n2. 1 Uppercase Letter\n3. 1 Lowercase Letter \n4. 1 Special Character ");
            }
        } else {
            if (activeForm == 0 && activeInput == 0) {
                employeeName = document.getElementById("addEmployeeForm")['fullName'].value;
            }
            increamentActiveInput();
        }
    } else {
        if (element.getAttribute("name").toLowerCase().includes("name")) {
            alert("Wrong name ! \n\n Note : Name can only contain alphabets and space.");
        } else if (element.getAttribute("name").toLowerCase().includes("email")) {
            alert("Wrong Email !");
        } else if (element.getAttribute("name").toLowerCase().includes("contact")) {
            alert("Wrong Contact Number ! \n\n Note : Require minimum 8 digits");
        } else if (element.getAttribute("name").toLowerCase().includes("vehiclecompany")) {
            alert("Invalid Manufacturer name ! must have 2 or more alphabets");
        } else if (element.getAttribute("name").toLowerCase().includes("vehiclemodel")) {
            alert("Invalid Vehicle Model ! must have length 2 or greater then 2");
        } else if (element.getAttribute("name").toLowerCase().includes("vehicleno")) {
            alert("Invalid Vehicle Number ! \n\n Note : can contain only digits and numbers and have minimum length 8");
        } else if (element.getAttribute("name").toLowerCase().includes("employeeid")) {
            alert("Invalid Employee ID ! \n\n Note : can only contain digits");
        } else if (element.getAttribute("name").toLowerCase().includes("identification")) {
            alert("must contain 2 letters");
        }
    }
}

function goAhead() {
    var inputTag = collapsibleForms[activeForm].querySelectorAll(".form-input")[activeInput];
    if (inputTag.tagName == 'DIV') {
        if (activeForm == 0) {
            if (collapsibleForms[activeForm]['gender'].value == "") {
                alert("Please Select Gender");
            } else {
                increamentActiveInput();
            }
        } else if (activeForm == 1) {
            if (collapsibleForms[activeForm]['vehicleType'].value == "") {
                alert("Please Select Vehicle Type");
            } else {
                increamentActiveInput();
            }
        }

    } else { showMessageIfNotValid(inputTag); }
    refreshNavigationButtons();
}



function goBack() {
    if (activeInput != 0) {
        decrementActiveInput();
    }
    refreshNavigationButtons();
}

for (index = 0; index < inputTags.length; index++) {
    inputTags[index].addEventListener("keyup", function(event) {
        if (event.key === "Enter") {
            showMessageIfNotValid(event.target);
        }
        refreshNavigationButtons();
    });
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