
let userId;
let roleId;

window.onload = function(){
    const urlParams = new URLSearchParams(window.location.search);
    userId = urlParams.get('userId');
    roleId = urlParams.get('roleId');

    getAllPastTickets();
    
}

async function getAllPastTickets(){

    let response = await fetch(`http://localhost:9000/displayReimb/${userId}`);

    let responseBody = await response.json();


    let lists = responseBody.data;

    let reimbContainerElem = document.getElementById("reimb-container");
    lists.forEach(ticket => {
        let reimbElem = createReimb(ticket);
        
        reimbContainerElem.appendChild(reimbElem);

    });
    

}

function createReimb(ticket){
  
   
    let reimbElem = document.createElement("div");
    reimbElem.className = "row-container";
  
    reimbElem.innerHTML = `
      <div class="col">${ticket.firstName}</div>
      <div class="col">${ticket.lastName}</div>
      <div class="col">${ticket.userRole}</div>
      <div class="col">${ticket.amount}</div>
      <div class="col">${ticket.type}</div>
      <div class="col">${ticket.status}</div>
      <div class="col">${ticket.discription}</div>
      <div class="col">${ticket.submittedDate}</div>
    `;
  
    return reimbElem;
  
}


async function createNewReimb(event){
    event.preventDefault();

    let firstnameInputElem = document.getElementById("firstname");
    let lastnameInputElem = document.getElementById("lastname");
    let userroleInputElem = document.getElementById("userrole");
    let amountInputElem = document.getElementById("amount");
    let typeInputElem = document.getElementById("type");
    let statusInputElem = document.getElementById("status");
    let descriptionInputElem = document.getElementById("description");

    //send request to create list
    let userReimb = {
        userId: 0,
        firstName: firstnameInputElem.value,
        lastName: lastnameInputElem.value,
        userRole: userroleInputElem.value,
        amount: amountInputElem.value,
        type: typeInputElem.value,
        status: statusInputElem.value,
        discription: descriptionInputElem.value
    }

    //send the http request
    let response = await fetch(`http://localhost:9000/createReimb`,{
        method: "POST",
        body: JSON.stringify(userReimb)
    })

    let responseBody = await response.json();
    console.log(responseBody);

    createReimb(responseBody.data);
    
    firstnameInputElem.value = ""
    lastnameInputElem.value = ""
    userroleInputElem.value = ""
    amountInputElem.value = ""
    typeInputElem.value = ""
    statusInputElem.value = ""
    descriptionInputElem.value = ""
}





 
 
