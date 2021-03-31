class Feedback {
    constructor(name, email, subject, message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
}

let submitFeedback = (e) => {
    e.preventDefault();
    let submitFeedbackForm = document.getElementById("feedbackForm");
    let feedbackFullName = submitFeedbackForm['feedbackFullName'];
    let feedbackEmail = submitFeedbackForm['feedbackEmail'];
    let feedbackSubject = submitFeedbackForm['feedbackSubject'];
    let feedbackMessage = submitFeedbackForm['feedbackMessage'];
    if (validate(feedbackFullName) && validate(feedbackEmail) && validate(feedbackSubject) && validate(feedbackMessage)) {
        let givenFeedback = new Feedback(feedbackFullName.value, feedbackEmail.value, feedbackSubject.value, feedbackMessage.value);
        alert("Sent feedback successfully");
        window.location.reload();
    } else {
        alert("Some Fields are invalid");
    }

}


let validate = (element) => {
    let isValid = undefined;
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