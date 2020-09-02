var id = 0;

function adicionar() {
  var inputs = document.getElementsByClassName("entrada");
  id++;

  console.log();
  document.getElementById("lista_produtos").innerHTML += `
  <div class="Pratos" id="${id}">

  <div>
  <img src="../img/${inputs["imagem"].files[0].name}" alt="" />
    <div class="informacoes">
    <p>${inputs["nome"].value}</p>
    <p>${inputs["ingredientes"].value}</p>
    <p><strong>Categoria:</strong> ${inputs["categoria"].value}</p>
    </div>
    <p>R$ ${inputs["preco"].value}</p> 

    <button onclick="deletar(${id})" > Deletar </button>
  </div>
</div>`;
}

function deletar(id) {
  document.getElementById(id).remove();
}
