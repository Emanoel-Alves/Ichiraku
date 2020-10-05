<template>
  <div class="main">
    <div class="sloganBox">
      <div class="slogan">
        <a><img src="../assets/logo.png" alt="naruto-font" border="0" /></a>
        <!-- <img class="imagemSlogan" src="../assets/lamen.png" alt="" /> -->
      </div>
    </div>

    <form action="" class="formulario">
      <label class="inputImag" for=""
        >Imagem do produto *
        <input
          v-bind="inputUrl"
          name="imagem"
          class="file_customizado entrada"
          type="file"
          accept="image/*"
      /></label>
      <label for=""
        >Nome do prato *
        <input
          v-model="inputNome"
          class="entrada"
          name="nome"
          placeholder="Sushi, Shimeji na Manteiga, ..."
          type="text"
      /></label>
      <label for=""
        >Ingredientes *
        <input
          v-model="inputIngredientes"
          class="entrada"
          name="ingredientes"
          placeholder="Arroz Para Sushi,  Linguado, Tilápia, Atum, ..."
          type="text"
      /></label>
      <label for=""
        >Preço R$ *
        <input
          v-model="inputPreco"
          class="entrada"
          name="preco"
          placeholder="0,00"
          type="text"
      /></label>
      <label id="categoria" for=""
        >Categoria *
        <div
          name="categoria"
          placeholder="Sashimi Salmão, Uramaki Califórnia, Hot Roll, ... "
          type="text"
          class="form-group col-md-4 entrada"
        >
          <select
            v-model="inputCategoria"
            id="inputState"
            class="form-control entrada-select"
          >
            <option value="Shushi e Shashimis">Shushi e Shashimis</option>
            <option value="Pratos quentes">Pratos quentes</option>
            <option value="Sobremesas">Sobremesas</option>
            <option value="Selecione..." selected>Selecione...</option>
          </select>
        </div>
        <!-- <input
          v-model="inputCategoria"
          class="entrada"
          name="categoria"
          placeholder="Sashimi Salmão, Uramaki Califórnia, Hot Roll, ... "
          type="text"
      /> -->
      </label>
      <div id="alerta"></div>

      <input
        @click="postProduto()"
        value="Cadastrar"
        class="add_produto"
        type="button"
        id="button_adc"
      />
    </form>

    <div class="lista_produtos" id="lista_produtos">
      <p>Produtos</p>
      <div
        class="Pratos"
        :id="produto.id"
        v-for="produto in produtos"
        :key="produto.id"
      >
        <div>
          <img :src="produto.url" alt="" />

          <div class="informacoes">
            <p>{{ produto.nome }}</p>
            <p>{{ produto.ingredientes }}</p>
            <p><strong>Categoria:</strong> {{ produto.categoria }}</p>
          </div>
          <p>R$ {{ produto.preco }}</p>

          <div class="buttons-config">
            <a
              @click="deleteProduto(produto.id)"
              class="btn btn-danger button-delete"
              role="button"
              aria-disabled="true"
              ><i class="far fa-trash-alt"></i
            ></a>
            <a
              @click="putProduto(produto.id)"
              class="btn btn-primary button-edit"
              role="button"
              aria-disabled="true"
              ><i class="fas fa-pencil-alt"></i
            ></a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "CadastroProduto",

  data() {
    return {
      produtos: [],
      produto: {},
      inputNome: "",
      inputIngredientes: "",
      inputPreco: null,
      inputCategoria: "Selecione...",
      inputUrl: "",
      baseURI: "http://localhost:8080/ichiraku-back-and/api/produtos",
    };
  },
  methods: {
    postProduto() {
      this.produto.nome = this.inputNome;
      this.produto.ingredientes = this.inputIngredientes;
      this.produto.preco = Number(this.inputPreco);
      this.produto.categoria = this.inputCategoria;

      this.$http.post(this.baseURI, this.produto).then((result) => {
        this.produtos.push(result.data);
      });
    },
    deleteProduto(id) {
      this.$http.delete(this.baseURI + "/" + id).then((result) => {
        this.produtos = this.getProdutos();
      });
    },
    getProdutos() {
      this.$http.get(this.baseURI).then((result) => {
        this.produtos = result.data;
      });
    },
    putProduto(id) {
      this.$http.put(this.baseURI + "/" + id).then((result) => {
        this.produtos = result.data;
      });
    },
  },
  mounted() {
    this.getProdutos();
  },
};
</script>

<style scoped>
* {
  margin: 0px;
  padding: 0px;
}

.button-delete {
  width: 50px;
  height: 30px;
  padding: 3px;
  color: #fff;
  background-color: #ec1b1b;
  margin: 5px;
}

.button-edit {
  width: 50px;
  height: 30px;
}

.main {
  width: 100%;
  height: 100%;
  background-color: #840705;
  display: flex;
  flex-direction: column;
  align-items: center;
  overflow: hidden;
}

.sloganBox {
  background-color: #840705;
  height: 20%;
  width: 100vw;
  align-items: center;
  text-align: center;
}

.slogan {
  width: 50%;
  display: flex;
  align-items: center;
  flex-direction: row;
  margin-left: 40%;
  margin-top: 30px;
  margin-bottom: 10px;
}

.slogan > a > img {
  width: 280px;
}

.formulario {
  display: flex;
  width: 70%;
  height: 60%;
  background-color: #e5e5e5;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 20px;
  border-radius: 5px;
}

.imagemSlogan {
  width: 100px;
  height: 100px;
  float: right;
  margin-left: 70px;
}

.inputImag {
  margin-top: 40px;
}

.inputImag > input {
  padding-left: 0px;
}

.file_customizado::-webkit-file-upload-button {
  background-color: #840705;
  border: none;
  color: #fff;
  height: 35px;
  border-right: 2px solid #111;
}

.add_produto {
  background-color: #156711;
  color: #fff;
  width: 110px;
  text-align: center;
  padding: 0px;
  margin: 20px;
  outline-color: #e5e5e5;
}

.add_produto:hover {
  outline-color: #156711;
  border: 2px solid #e5e5e5;
}

select {
  width: 150%;
  padding-left: 5px;
}

input {
  background-color: #fff;
  border-color: #fff;
  border: 0px;
  width: 100%;
  height: 35px;
  align-items: center;
  padding-left: 10px;
  border-radius: 5px;
  outline-color: #840705;
}

.lista_produtos {
  display: flex;
  width: 70%;
  height: 100%;
  background-color: #e5e5e5;
  flex-wrap: wrap;
  align-items: center;
  margin: 20px;
  border-radius: 5px;
  padding: 10px;
  padding-left: 20px;
  padding-right: 20px;
}

.lista_produtos > p {
  width: 100%;
  text-align: center;
  font-size: 35px;
  margin-bottom: 5px;
}

label {
  text-align: left;

  font-size: 15px;
  width: 70%;
  margin-top: 10px;
  font-family: "Roboto", sans-serif;
  outline-color: #840705;
}

.Pratos {
  width: 100%;
  background-color: #fff;
  margin-bottom: 20px;
  border-radius: 10px;
}

.Pratos > div {
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
  align-items: center;
}

.Pratos img {
  width: 130px;
  height: 130px;
  margin-top: 10px;
  margin-bottom: 10px;
  border-radius: 8px;
  margin-left: 10px;
}

.Pratos div button {
  width: 135px;
  border-radius: 8px;
  background-color: #f42d2d;
  border: 0.7px solid #ec1b1b;
  color: white;
  margin: 8px 0;
  margin-bottom: 25px;
  appearance: button;
  text-align: center;
  text-decoration: none;
  padding: 5px 0;
  transition: background-color 0.5s;
}

.Pratos div button:hover {
  background-color: #b40707;
  border: 0.7px solid #b40707;
}
.Pratos > div > button {
  margin-right: 15px;
}

.Pratos > div > p {
  margin-right: 15px;
  flex-direction: row;
  width: 20%;
  font-weight: bold;
  font-size: 20px;
}

.informacoes {
  text-align: left;
  display: flex;
  flex-direction: column;
  width: 70%;
  padding: 15px;
}

.informacoes > p {
  margin-bottom: 0px;
}

.informacoes > p:nth-child(1) {
  font-weight: bold;
  font-size: 18px;
}

#alerta {
  height: 10px;
}
</style>
