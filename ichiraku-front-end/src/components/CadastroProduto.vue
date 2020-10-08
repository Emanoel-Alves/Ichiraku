<template>
  <div class="main">
    <div class="sloganBox">
      <div class="slogan">
        <a><img src="../assets/logo.png" alt="naruto-font" border="0" /></a>
        <!-- <img class="imagemSlogan" src="../assets/lamen.png" alt="" /> -->
      </div>
    </div>

    <form @submit="checkForm" class="needs-validation formulario" novalidate>
      <label class="inputImag" for=""
        >Imagem do produto *
        <input
          name="imagem"
          id="file"
          ref="file"
          class="file_customizado form-control entrada"
          type="file"
          accept="image/png"
          required
        />
        <div class="invalid-feedback">
          Por favor, selecione uma imagem.
        </div></label
      >
      <label for=""
        >Nome do prato *
        <input
          v-model="inputNome"
          class="entrada nomeProduto form-control"
          name="nome"
          placeholder="Sushi, Shimeji na Manteiga, ..."
          type="text"
          required
        />
        <div class="invalid-feedback">
          * Por favor, digite o nome do prato válido.
        </div></label
      >
      <label for=""
        >Ingredientes *
        <input
          v-model="inputIngredientes"
          class="entrada form-control"
          name="ingredientes"
          placeholder="Arroz Para Sushi,  Linguado, Tilápia, Atum, ..."
          type="text"
          required
        />
        <div class="invalid-feedback">
          Por favor, digite os ingredientes.
        </div></label
      >
      <div
        style="display: flex; flex-direction: row; width: 80%; margin-left: 10%"
      >
        <label style="margin-right: 10%" for=""
          >Preço R$ *
          <input
            v-model="inputPreco"
            class="entrada form-control"
            name="preco"
            placeholder="0,00"
            type="text"
            required
          />
          <div class="invalid-feedback">
            Por favor, digite o preço corretamente.
          </div></label
        >
        <label style="width: 100%" id="categoria" for=""
          >Categoria *
          <div
            name="categoria"
            placeholder="Sashimi Salmão, Uramaki Califórnia, Hot Roll, ... "
            type="text"
            class="form-group col-md-4 entrada"
          >
            <select
              style="width: 228%; height: 35px; border: none"
              v-model="inputCategoria"
              id="inputState"
              class="custom-select"
              placeholder="asas"
              required
            >
              <option value="Selecione..." disabled selected="asasa">
                Selecione...
              </option>
              <option value="Shushi e Shashimis">Shushi e Shashimis</option>
              <option value="Pratos quentes">Pratos quentes</option>
              <option value="Sobremesas">Sobremesas</option>
            </select>
            <div style="width: 200%" class="invalid-feedback">
              Por favor, selecione uma categoria.
            </div>
          </div>
          <!-- <input
          v-model="inputCategoria"
          class="entrada"
          name="categoria"
          placeholder="Sashimi Salmão, Uramaki Califórnia, Hot Roll, ... "
          type="text"
      /> -->
        </label>
      </div>
      <div id="alerta"></div>

      <input
        @click="postProduto()"
        value="Cadastrar"
        class="add_produto"
        type="submit"
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
          <img :src="'uploads/produto/' + produto.id + '.png'" alt="" />
  
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
      inputCategoria: "",
      file: null,
      baseURI: "http://localhost:8080/ichiraku-back-and/api/produtos",
      baseUploadURI: "http://localhost:8080/ichiraku-back-and/upload",
    };
  },
  methods: {
    checkForm(event) {
      event.preventDefault();
      event.target.classList.add("was-validated");

      console.log("entrou\n\n::: " + this.inputNome.trim() === "");
      if (this.inputNome.trim() === "") {
        let inputt = document.querySelector(".nomeProduto");
        inputt.setAttribute("class", "entrada nomeProduto  is-invalid");
      } else {
        let inputt = document.querySelector(".nomeProduto");
        inputt.setAttribute(
          "class",
          "entrada form-control nomeProduto  is-valid"
        );
      }
    },
    handleFileUpload(id) {
      this.file = this.$refs.file.files[0];
      console.log("file: " + this.file.name);
      let obj = {
        resource: "produto",
        id: id,
      };
      let json = JSON.stringify(obj);

      let form = new FormData();
      form.append("obj", json);
      form.append("file", this.file);

      this.$http
        .post(this.baseUploadURI, form, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((result) => {
          console.log(result);
        });
    },
    postProduto() {
      this.produto.nome = this.inputNome;
      this.produto.ingredientes = this.inputIngredientes;
      this.produto.preco = Number(this.inputPreco);
      this.produto.categoria = this.inputCategoria;

      this.$http.post(this.baseURI, this.produto).then((result) => {
        this.produtos = this.getProdutos();
        this.handleFileUpload(result.data.id);
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
        this.produtos = result.data; //lembrar de adc o obj produto na rota e de atualizar a imagem tmb
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
  padding: 3px;
  color: #fff;
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
