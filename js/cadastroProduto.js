function adicionar() {
  var inputs = document.getElementsByClassName("entrada");

  document.getElementById("lista_produtos").innerHTML += `<div class="Pratos">
  

  <div>
  <img src="../img/img1.png" alt="" />
    <div class="informacoes">
    <p>${inputs["nome"].value}</p>
    <p>${inputs["ingredientes"].value}</p>
    </div>
    <p>R$ ${inputs["preco"].value}</p> 

    <button href="../pages/InfoPrato.html"> Deletar </button>
  </div>
</div>`;
}
