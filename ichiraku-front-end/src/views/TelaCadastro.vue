<template>
  <div class="content">
    <div class="coluna">
      <div class="logo"><img src="../assets/logo1.png" alt="logo" /></div>
    </div>

    <div class="verticalLine"></div>

    <div class="coluna">
      <form class="form1">
        <p>Cadastro</p>

        <label for=""
          >Nome *
          <input v-model="nome" placeholder="Nome do usuário" type="text"
        /></label>

        <label for=""
          >Email *
          <input v-model="email" placeholder="exemplo@exem.com" type="text"
        /></label>

        <label for=""
          >Senha * <p style="font-size:10px">Mínimo 8 caracteres</p><input v-model="senha" placeholder="Senha" type="password"
        /></label>

        <input
          class="botao"
          type="button"
          @click="getUsuarios()"
          value="Cadastrar"
        />

        <label style="display: flex; flex-direction: row" for=""
          >Já é cadastrado?
          <router-link to="login">Entrar</router-link>
          <!-- <rou href="/login">Entrar</a> -->
        </label>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "cadastrar",
  data() {
    return {
      error: false,
      nome: "",
      email: "",
      senha: "",
      usuario: {},
      usuarios: null,
      baseURI: "http://localhost:8080/api/usuarios",
      //reg: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,24}))$/
    };
  },

  methods: {
    // isEmailValid: function() {
    //   return (this.email == "")? "" : (this.reg.test(this.email)) ? 'has-success' : 'has-error';
    // },

    getUsuarios: function () {
      if (
        this.nome.trim() !== "" &&
        this.email.trim() !== "" &&
        this.senha.trim() !== ""
      ) {
        if (this.nome.length > 4) {
          if (this.email.indexOf("@") != -1) {
            if (this.senha.length > 7) {
              this.$http
                .get(this.baseURI + "/search?email=" + this.email)
                .then((result) => {
                  this.usuarios = result.data;
                  console.log(this.usuarios);
                  if (this.usuarios.length == 0) {
                    this.postUsuarios();
                  } else {
                    alert(
                      "Usuário com email já existente, digite outro email!"
                    );
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
        alert("Digite os dados corretamente!");
      }
    },

    postUsuarios: function () {
      console.log(
        this.nome.trim() !== "" &&
          this.email.trim() !== "" &&
          this.senha.trim() !== ""
      );

      this.usuario.nome = this.nome;
      this.usuario.email = this.email;
      this.usuario.senha = this.senha;
      this.usuario.sobrenome = "";
      this.usuario.cidade = "";
      this.usuario.bairro = "";
      this.usuario.rua = "";
      this.usuario.numero = "";

      alert("Usuário cadastrado!");
      this.$http.post(this.baseURI, this.usuario).then((result) => {
        this.$router.push("/home");
      });
    },
  },
};
</script>

<style scoped>
* {
  padding: 0;
  margin: 0;
}

.content {
  display: flex;
  flex-direction: row;

  width: 100vw;
  height: 100vh;

  background-color: #eee9e9;
}
.coluna {
  display: flex;
  flex-direction: column;

  width: 50vw;
}

.coluna > .logo {
  margin-top: 13vw;
}

.verticalLine {
  height: 80%;

  border-left: 2px solid;
  border-color: #aaaaaa;

  margin-top: 5%;
}
.form1 {
  display: flex;
  flex-direction: column;

  font-family: Helvetica, sans-serif, Arial;
  align-items: center;

  margin-top: 10%;
}

.form1 > p {
  font-size: 4rem;
  font-weight: bold;

  color: #7e7c7c;
}
.form1 > label {
  display: flex;
  flex-direction: column;
  align-items: initial;

  margin-bottom: 4%;
}

.form1 > label > a {
  margin-left: 5px;
  text-decoration: none;
}

.form1 > i {
  font-size: 110px;
  margin-bottom: 5%;
  color: #aaaaaa;
}

.form1 > label > input {
  width: 366px;
  height: 45px;

  border: none;
  border-radius: 10px;

  background-color: #aaaaaa;
  outline-color: #840705;

  margin-top: 5px;
  padding-left: 15px;
}

.form1 > .botao {
  background-color: #840705;
  color: #dfdfdf;

  width: 366px;
  height: 45px;

  border: none;
  border-radius: 10px;

  font-weight: bold;
  letter-spacing: 0.3px;

  margin-top: 2%;
  margin-bottom: 6%;
}

@media screen and (max-width: 920px) {
  .content {
    flex-direction: column;
    height: 100%;
  }
  .coluna {
    flex-direction: column;
    width: 100vw;
  }
  .verticalLine {
    width: 80%;
    height: 0;

    border-top: 2px solid;
    border-color: #aaaaaa;

    margin-left: 10%;
  }

  .form1 > button {
    margin-bottom: 6%;
  }
}

@media screen and (max-width: 400px) {
  .content {
    flex-direction: column;
    height: 100%;
  }
  .coluna {
    flex-direction: column;
    width: 100vw;
  }
  .verticalLine {
    width: 80%;
    height: 0;

    margin-left: 10%;
    margin-top: 10%;

    border-top: 2px solid;
    border-color: #aaaaaa;
  }

  .form1 > label > input {
    width: 325px;
    height: 45px;
  }

  .form1 > button {
    width: 325px;
    margin-bottom: 6%;
  }
}
</style>