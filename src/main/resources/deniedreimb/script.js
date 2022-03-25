
let userId;
let roleId;
 
    

window.onload = function(){
    const urlParams = new URLSearchParams(window.location.search);
    userId = urlParams.get('userId');
    roleId = urlParams.get('roleId');
    if(roleId == 1){
        alert("you are not finance manager");
    }else{
        getAllReimbursList();

    }
 
}

async function getAllReimbursList(){
    console.log("before");
    let response = await fetch("http://localhost:9000/displayallReimb");

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
  
   if (ticket.status != 'Pending' && ticket.status != 'Approved'){
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
   }else{
       reimbElem.innerHTML = "";
   }
  
    return reimbElem;
  
}



