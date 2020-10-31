<template>
  <div class="content">
    <div class="coluna">
      <form class="form1" action="">
        <p>Login</p>

        <label for=""
          >Email *
          <input v-model="email" placeholder="exemplo@exem.com" type="text"
        /></label>

        <label for=""
          >Senha *<input
            v-model="senha"
            placeholder="Password..."
            type="password"
          />
        </label>

        <input
          class="botao"
          type="button"
          @click="checkForm()"
          value="Entrar"
        />

        <label style="display: flex; flex-direction: row" for=""
          >Não é cadastrado? <a href="/cadastro">Cadastre-se</a></label
        >
      </form>
    </div>

    <div class="verticalLine"></div>

    <div class="coluna">
      <div class="logo"><img src="../assets/logo1.png" alt="logo" /></div>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      errors: [],
      email: null,
      senha: null,
      usuario: {},
      usuarios: [],
      logged: false,
      baseURI: "http://localhost:8080/api/usuarios",
    };
  },

  

  methods: {
    checkForm: function () {
      this.errors = [];
      if (this.email.trim() !== "" && this.senha.trim() !== "") {
        this.getUsuario();
      } else {
        alert("Insira os dados, por favor");
      }
    },

    getUsuario() {
      this.$http
        .get(this.baseURI + "/search?email=" + this.email)
        .then((result) => {
          this.usuarios = result.data;
          //console.log(this.usuarios);
          // console.log(this.usuarios[0].email);
          if (this.usuarios.length != 0) {
            if (this.senha !== this.usuarios[0].senha) {
              alert("A Senha não corresponde ao email informado!");
            } else {
              if (result.status === 200) {
                this.$session.start();
                this.$session.set("usuario", JSON.stringify(result.data));
                this.$router.push("/home");
              }
            }
          } else {
            alert("Usuário com email não existe");
          }
        });
    },
  },
 mounted() {
   
    if (this.$session.exists()) {
        this.$router.push("/home");
    }   
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
  align-items: baseline;
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