addreimb

document.getElementById("addreimb").addEventListener("submit", async function (event){
    //this is to stop the form from reloading 

    //this is to stop the form from reloading 
    event.preventDefault();
    
    //retrieve input elements from the dom
    let amountInputElem = document.getElementById("amount");
    let discriptionInputElem = document.getElementById("discription");
    let statusIdInputElem = document.getElementById("statusId");
    let typeIdInputElem = document.getElementById("typeId");
    let authorIdInputElem = document.getElementById("authorId");
    let resolverIdInputElem = document.getElementById("resolverId");

    //get values from the input elements and put it into an object
    let reimbursement ={
        amount: amountInputElem.value,
        discription: discriptionInputElem.value,
        statusId: statusIdInputElem.value,
        typeId: typeIdInputElem.value,
        authorId: authorIdInputElem.value,
        resolverId: resolverIdInputElem.value
    }

    let response = await fetch(`http://localhost:9000/createReimb`, {
        method: "POST",
        body: JSON.stringify(reimbursement)
    })

    //retrieve the response body
    let responseBody = await response.json();

    //logic after response body
    if(responseBody.success == false){
        let messageElem = document.getElementById("message");
        messageElem.innerText = responseBody.message;
    }
    
})

