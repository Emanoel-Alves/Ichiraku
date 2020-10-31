<template>
  <div class="Conteine">
    <Menu />
    <form class="form-perfil" action="">
      <p>Perfil</p>
      <div class="imageUser">
        <i class="fas fa-user-alt"></i>
        <label class="inputImag" for=""
        ><input
        value="text"
          name="imagem"
          id="file"
          ref="file"
          class="file_customizado"
          type="file"
          accept="image/*"
          required
        />
        <div class="invalid-feedback">
          Por favor, selecione uma imagem.
        </div></label
      >
      </div>
      
      <label
        >Nome: <input v-model="usuarioPerfil.nome" value="Emanoel"
      /></label>

      <label
        >Sobrenome:<input v-model="usuarioPerfil.sobrenome" value="Alves"
      /></label>

<<<<<<< HEAD:ichiraku-front-end/src/views/Perfil.vue
      <label
        >Email:
        <input v-model="usuarioPerfil.email" value="emanoel-alves@hotmail.com"
      /></label>

      <label
        >Senha: <input v-model="usuarioPerfil.senha" type="password"
      /></label>
=======
      <label>Email: <input value="emanoel-alves@hotmail.com" /></label>
>>>>>>> issue2:ichiraku-front-end/src/components/Perfil.vue

      <div class="divLine"></div>
      <p>Endereço</p>
      <label>Cidade: <input v-model="usuarioPerfil.id" /></label>

      <label
        >Bairro: <input v-model="usuarioPerfil.bairro" value="Betânia"
      /></label>

      <label
        >Rua: <input v-model="usuarioPerfil.rua" value="Bernardino Gomes"
      /></label>

<<<<<<< HEAD:ichiraku-front-end/src/views/Perfil.vue
      <label style="margin-bottom: 5%"
        >Número: <input v-model="usuarioPerfil.numero" value="000"
      /></label>
=======
      <label style="margin-bottom: 5%" >Número: <input value="000"/></label>
>>>>>>> issue2:ichiraku-front-end/src/components/Perfil.vue
      <div class="buttonsContent">
        <!-- <button class="button-perfil button1"> -->
        <input
          type="button"
          class="button-perfil button1"
          @click="putUsuario()"
          value="Salvar"
        />

        <!-- </button> -->

        <router-link class="button-perfil button2" to="/home"
          >Cancelar</router-link
        >
      </div>
    </form>
  </div>
</template>

<script>
import Menu from "@/components/Menu.vue";

export default {
  name: "Perfil",
  components: {
    Menu,
  },
  data() {
    return {
      usuario: {},
      id: "",
      usuarioPerfil: {},
      baseURI: "http://localhost:8080/api/usuarios",
    };
  },

  methods: {
    getUsuario() {
      this.usuario = JSON.parse(this.$session.get("usuario"));
      this.id = this.usuario[0].id;
      //console.log(this.usuario[0].id);
      this.$http.get(this.baseURI + "/" + this.id).then((result) => {
        this.usuarioPerfil = result.data;
      });
    },
    putUsuario() {
      if (
        this.usuarioPerfil.nome.trim() !== "" &&
        this.usuarioPerfil.email.trim() !== "" &&
        this.usuarioPerfil.senha.trim() !== ""
      ) {
        if (this.usuarioPerfil.nome.length > 4) {
          if (this.usuarioPerfil.email.indexOf("@") != -1) {
            if (this.usuarioPerfil.senha.length > 7) {
              this.$http
                .put(
                  this.baseURI + "/" + this.usuarioPerfil.id,
                  this.usuarioPerfil
                )
                .then((result) => {
                  if (result.status === 200) {
                    alert("Perfil atualizado");
                  }
                });
            } else {
              alert("Senha inválida");
            }
          } else {
            alert("Email inválido");
          }
        } else {
          alert("Nome inválido");
        }
      } else {
        alert("Digite os dados nome, email ou senha corretamente!");
      }
    },
  },
  created: function () {
    this.getUsuario();
  },
};
</script>

<style scoped>
.Conteine {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-content: center;
}
.form-perfil {
  width: calc(100% - 290px);
  display: flex;
  flex-direction: column;
  overflow: auto;
  background: #EBEBEB;

  /* align-items: center; */
}

.form-perfil > label > input {
  border: none;
  margin-top: 5px;
  /* margin-left: 15%; */
  background-color: #c0c0c0;
  border-radius: 7px;
  width: 410px;
  height: 38px;
  flex-direction: column;
  padding-left: 10px;
  outline-color: #840705;
  font-size: 15px;
  font-family: Helvetica, sans-serif, Arial;
}

.file_customizado {
  margin-top: 15px;
  /* width: 50; */
}

.form-perfil > label {
  display: flex;
  margin-bottom: 10px;
  margin-left: 19%;
  flex-direction: column;
  align-items: flex-start;
  font-family: Helvetica, sans-serif, Arial;
}

.divLine {
  /* height: 20px; */
  margin-left: 10%;
  width: 80%;
  /* background-color: #c0c0c0; */
  margin-top: 4%;
  border-top: 1.5px solid;
  border-color: #aaaaaa;
}

.form-perfil > p {
  /* margin-left: 50%; */
  font-size: 2.1rem;
  font-family: Arial, Helvetica, sans-serif;
  margin-top: 4%;
}

p:nth-child(1) {
  margin-bottom: 4%;
  /* margin-top: 6%; */
}

p:nth-child(2) {
  margin-bottom: 40%;
}

/* -------------------------- */

.button-perfil {
  /* background-color: #4caf50; Green */
  border: none;
  color: white;
  padding: 6px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  /* margin: 4px 2px; */
  transition-duration: 0.4s;
  cursor: pointer;
  width: 100px;
  border-radius: 4px;
}

.imageUser {
  display: flex;
  flex-direction: column;
  margin-top: 0%;
  border-radius: 100%;
  margin-bottom: 4%;
  /* margin-top: 20%; */
}

.imageUser > i {
  font-size: 5rem;
}

.userName {
  color: #d6d6d6;
  font-family: Arial, Helvetica, sans-serif;
  margin-top: 5%;
  font-size: 16px;
  display: flex;
}

.button-perfil {
  /* background-color: #4caf50; Green */
  border: none;
  color: white;
  padding: 6px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  /* margin: 4px 2px; */
  transition-duration: 0.4s;
  cursor: pointer;
  width: 100px;
  border-radius: 4px;
}

.button1 {
  background-color: #c0c0c0;
  color: black;
  border: 2px solid #4c7a34;
}

.button1:hover {
  background-color: #4c7a34;
  color: white;
}

.button2 {
  background-color: #c0c0c0;
  color: black;
  border: 2px solid #f44336;
  margin-left: 12%;
}

.button2:hover {
  background-color: #f44336;
  color: white;
}

.buttonsContent {
  margin-bottom: 40px;
}
</style>
