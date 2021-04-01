class Feedback {
    constructor(name, email, subject, message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }
}

function submitFeedback(e) {
    e.preventDefault();
    var submitFeedbackForm = document.getElementById("feedbackForm");
    var feedbackFullName = submitFeedbackForm['feedbackFullName'];
    var feedbackEmail = submitFeedbackForm['feedbackEmail'];
    var feedbackSubject = submitFeedbackForm['feedbackSubject'];
    var feedbackMessage = submitFeedbackForm['feedbackMessage'];
    if (!validate(feedbackFullName)) {
        alert("Invalid name ! \n\nNote : name must contain atleast two alphabets and does not contain any special character");
    } else if (!validate(feedbackEmail)) {
        alert("Wrong email id");
    } else if (!validate(feedbackSubject)) {
        alert("Subject must contain atleast 5 characters");
    } else if (!validate(feedbackMessage)) {
        alert("Message must contain atleast 10 characters");
    } else {
        var givenFeedback = new Feedback(feedbackFullName.value, feedbackEmail.value, feedbackSubject.value, feedbackMessage.value);
        alert("Sent feedback successfully");
        window.location.reload();
    }
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