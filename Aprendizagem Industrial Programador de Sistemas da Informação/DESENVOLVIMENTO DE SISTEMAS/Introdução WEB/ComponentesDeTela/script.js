function escreve() {
    const input = document.getElementById('inputText').value;
    const textArea = document.getElementById('textArea');
    
    textArea.value += input + "\n";
    
    document.getElementById('inputText').value = '';
}
