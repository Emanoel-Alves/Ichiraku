var id = 0;
var flag = 0;

function adicionar() {
  var inputs = document.getElementsByClassName("entrada");
  id++;

  const button_adc = document.querySelector("#button_adc");
  button_adc.setAttribute("type", "button");

  if (inputs["imagem"].files[0] == undefined) {
    inputs["imagem"].focus();
    if (flag === 0) {
      flag = msg_Erro();
    }
  } else if (
    (inputs["nome"].value.trim() === "") |
    (inputs["nome"].value == null)
  ) {
    inputs["nome"].focus();
    if (flag === 0) {
      flag = msg_Erro();
    }
  } else if (
    (inputs["ingredientes"].value.trim() === "") |
    (inputs["ingredientes"].value == null)
  ) {
    inputs["ingredientes"].focus();
    if (flag === 0) {
      flag = msg_Erro();
    }
  } else if (
    (inputs["preco"].value.trim() === "") |
    (inputs["preco"].value == null) |
    isNaN(inputs["preco"].value.replace(",", "."))
  ) {
    inputs["preco"].focus();
    if (flag === 0) {
      flag = msg_Erro();
    }
  } else if (
    (inputs["categoria"].value.trim() === "") |
    (inputs["categoria"].value == null)
  ) {
    inputs["categoria"].focus();
    if (flag === 0) {
      flag = msg_Erro();
    }
  } else {
    document.getElementById("lista_produtos").innerHTML += `
    <div class="Pratos" id="${id}">
    <div>
    <img src="../img/${inputs["imagem"].files[0].name}" alt="" />
      <div class="informacoes">
      <p>${inputs["nome"].value}</p>
      <p>${inputs["ingredientes"].value}</p>
      <p><strong>Categoria:</strong> ${inputs["categoria"].value}</p>
      </div>
      <p>R$ ${inputs["preco"].value.replace(".", ",")}</p> 
  
      <button onclick="deletar(${id})" > Deletar </button>
    </div>
  </div>`;
    if (flag === 1) {
      document.getElementById("alerta_text").remove();
      flag = 0;
    }
    const button_adc = document.querySelector("#button_adc");
    button_adc.setAttribute("type", "reset");
    flag = 0;
  }
}

function deletar(id) {
  document.getElementById(id).remove();
}

function msg_Erro() {
  document.getElementById("alerta").innerHTML +=
    "<p id='alerta_text' style='color:#840705'>* preencha todos os campos corretamente</p>";
  return 1;
}
