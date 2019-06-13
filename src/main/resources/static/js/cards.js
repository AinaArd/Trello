function changeType(event){
    var cardId = event.target.id;
    var cardName = document.getElementById("name" + cardId);
    var childBefore = document.getElementById("ul-id$" + cardId);
    var ul = document.getElementById("cards");

    cardName.remove();

    //TODO: create input

    var editInput = document.createElement('input');
    editInput.type = 'text';
    editInput.id = cardId;
    ul.insertBefore(editInput,childBefore);


}