function exibirSelecionados() {
    const input1 = document.getElementById('input1').value;
    document.getElementById('input5').textContent = "Caixa de Texto: "+input1;
    document.getElementById('input1').value = "";

    const textarea = document.getElementById('textarea').value;
    const input8Display = document.getElementById('input8Display');
    input8Display.textContent = "Textarea: "+textarea;
    document.getElementById('textarea').value = "";

    const checkboxes = document.querySelectorAll('.auxi input[type="checkbox"]');
    const selectedCheckboxes = [];
    checkboxes.forEach(checkbox => {
        if (checkbox.checked) {
            selectedCheckboxes.push(checkbox.value);
        }
    });
    document.getElementById('input6').value = "Checkboxes selecionados: "+selectedCheckboxes.join(', ');

    checkboxes.forEach(checkbox => {
        checkbox.checked = false;
    });

    const radioButtons = document.querySelectorAll('.radio-group input[type="radio"]');
    let selectedRadio = '';
    radioButtons.forEach(radio => {
        if (radio.checked) {
            selectedRadio = radio.value;
        }
    });
    document.getElementById('input7').value = "Radio Selecionado: "+selectedRadio;

    radioButtons.forEach(radio => {
        radio.checked = false;
    });
}


function addLine() {
    const nome = document.getElementById('input2').value;
    const idade = document.getElementById('input3').value;
    const email = document.getElementById('input4').value;

    if (nome === '' || idade === '' || email === '') {
        alert('Por favor, preencha todos os campos.');
        return;
    }

    const tableBody = document.querySelector('table tbody');
    const newRow = document.createElement('tr');

    const nomeCell = document.createElement('td');
    nomeCell.textContent = nome;
    newRow.appendChild(nomeCell);

    const idadeCell = document.createElement('td');
    idadeCell.textContent = idade;
    newRow.appendChild(idadeCell);

    const emailCell = document.createElement('td');
    emailCell.textContent = email;
    newRow.appendChild(emailCell);

    tableBody.appendChild(newRow);

    document.getElementById('input2').value = '';
    document.getElementById('input3').value = '';
    document.getElementById('input4').value = '';

    document.getElementById('input2').value = "";
    document.getElementById('input3').value = "";
    document.getElementById('input4').value = "";
}