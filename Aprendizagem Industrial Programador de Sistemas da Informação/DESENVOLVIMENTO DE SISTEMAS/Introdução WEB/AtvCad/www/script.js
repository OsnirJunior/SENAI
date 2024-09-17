var clearButton = document.getElementById('clearButton').addEventListener('click', clearClicked)
var adsButton = document.getElementById('addButton').addEventListener('click', adsButton)
var inputName = document.getElementById('name')
var inputEmail = document.getElementById('email')
var inputTelefone = document.getElementById('phone')
var inputAdd = document.getElementById('addres')
var inputCity = document.getElementById('city')
var inputState = document.getElementById('state')
var inputMessage = document.getElementById('message')

function clearClicked() {
    inputName.value = ""
    inputEmail.value = ""
    inputTelefone.value = ""
    inputAdd.value = ""
    inputCity.value = ""
    inputState.value = ""
    inputMessage.value = ""
}

function adsButton() {
    if(inputName.value != "" && inputEmail.value != "" && inputTelefone.value != "" && inputAdd.value != "" && inputCity.value != "" && inputState.value != "") {
        alert("Enviado!")
        clearClicked()
    }
    else {
        alert("Preencha todos os campos necessários!")
    }
}
