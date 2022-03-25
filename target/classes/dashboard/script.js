let userId;
let roleId;

window.onload = function(){
    const urlParams = new URLSearchParams(window.location.search);
    userId = urlParams.get('userId');
    roleId = urlParams.get('roleId');
}

document.getElementById("reimb-1").addEventListener("click", async function login(event){
    event.preventDefault();

    window.location = `/pastreimb?userId=${userId}&roleId=${roleId}`

})

// document.getElementById("reimb-2").addEventListener("click", async function login(event){
//     event.preventDefault();

//     window.location = `/addreimb?userId=${userId}&roleId=${roleId}`

// })



document.getElementById("reimb-3").addEventListener("click", async function login(event){
    event.preventDefault();

    window.location = `/allreimburslist?userId=${userId}&roleId=${roleId}`

})

document.getElementById("reimb-4").addEventListener("click", async function login(event){
    event.preventDefault();

    window.location = `/pendingreimb?userId=${userId}&roleId=${roleId}`

})

document.getElementById("reimb-5").addEventListener("click", async function login(event){
    event.preventDefault();

    window.location = `/approvedreimb?userId=${userId}&roleId=${roleId}`

})

document.getElementById("reimb-6").addEventListener("click", async function login(event){
    event.preventDefault();

    window.location = `/deniedreimb?userId=${userId}&roleId=${roleId}`

})














 














