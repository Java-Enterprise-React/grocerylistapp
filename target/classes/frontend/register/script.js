window.onload = async () => {
    let response = await fetch("http://localhost:9000/api/session");

    let responseBody = await response.json();

    if(responseBody.successful){
        window.location = "../dashboard"
    }
}


let registerFormElem = document.getElementById("register-form");

registerFormElem.addEventListener("submit", (event) => {
    event.preventDefault();

    //get values inputted
    let credentials = {
        "username": document.getElementById("username-input").value,
        "password": document.getElementById("password-input").value,
        "firstname": document.getElementById("firstname-input").value,
        "lastname": document.getElementById("lastname-input").value
    }


    sendRegisterRequest(credentials);

});


async function sendRegisterRequest(userCredentials){
    let response = await fetch("http://localhost:9000/api/user", {
        method: "POST",
        body: JSON.stringify(userCredentials)
    });

    let responseBody = await response.json();

    if(responseBody.successful){
        //do successful stuff
        window.location = "../";
    }else{
        //do unsuccessful stuff
        let messageElem = document.getElementById("message");

        messageElem.innerText = responseBody.message;
        messageElem.style.display = "block";
    }

}


