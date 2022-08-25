let itemsContainer = document.getElementById("items-container");
let user;
let items;

window.addEventListener("load", async () => {
    
    let response = await fetch("/api/session");
    
    let responseBody = await response.json();
    
    if(!responseBody.successful){
        window.location = "../";
    }

    user = responseBody.data;

    items = await getAllItems();
    displayItems();
});


async function getAllItems(){
    let response = await fetch("/api/item");

    let responseBody = await response.json();

    return responseBody.data;
}


let logoutBtn = document.getElementById("logout-btn");
logoutBtn.addEventListener("click", () => {
    fetch("/api/session", { method: "DELETE" });
    window.location = "../";
});


/* 
    <div class="item">
        <div class="item-name-container">
            <div class="item-name">2 Sliced Cheese</div>
        </div>
        
        <button class="btn btn-danger">Delete</button>
    </div>
*/
function displayItems(){
    

    items.forEach(item => {
        let itemElem = document.createElement("div");
        itemElem.className = "item";
        itemElem.id = `item-${item.id}`;

        let itemNameContElem = document.createElement("div");
        itemNameContElem.className = "item-name-container";

        let itemNameElem = document.createElement("div");
        itemNameElem.className = "item-name";      
        itemNameElem.innerText = `${item.qty} ${item.name}`;  
        console.log(item);

        //mark items in cart
        if(item.inCart){
            itemNameElem.style.textDecoration = "line-through";
        }

        //if name is clicked, send http request for marking item in cart
        itemNameElem.addEventListener("click", async () => {
            await fetch(`/api/item/${item.id}`, {
                method: "PATCH"
            });
            
            itemNameElem.style.textDecoration = "line-through";
        })

        let deleteBtnElem = document.createElement("button");
        deleteBtnElem.className = "btn btn-danger";
        deleteBtnElem.innerText = "Delete";

        deleteBtnElem.addEventListener("click", async () => {
            let response = await fetch(`/api/item/${item.id}`, {
                method: "DELETE"
            });

            let responseBody = await response.json();

            if(responseBody.successful){
                let itemToDelete = document.getElementById(`item-${item.id}`);
                itemToDelete.remove();

                /* itemsContainer.innerHTML = "";
                getAllItems();
                displayItems(); */
            }

        });

        //relating all of these elements together
        itemElem.appendChild(itemNameContElem);
        itemElem.appendChild(deleteBtnElem);
        itemNameContElem.appendChild(itemNameElem);
        itemsContainer.appendChild(itemElem);
    });
}


let addItemFormElem = document.getElementById("add-item-form");
    addItemFormElem.addEventListener("submit", async (event) => {
    event.preventDefault();

    let nameToCreateElem = document.getElementById("name-to-create");
    let qtyToCreateElem = document.getElementById("qty-to-create");

    let response = await fetch("/api/item", {
        method: "POST",
        body: JSON.stringify({
            "name": nameToCreateElem.value,
            "qty": qtyToCreateElem.value
        })
    })

    let responseBody = await response.json();
    
    
    itemsContainer.innerHTML = "";
    items = await getAllItems();
    displayItems();

})



