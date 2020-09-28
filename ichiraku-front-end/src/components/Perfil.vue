<template>
  <div class="Conteine">
    <Menu />
    <form class="form-perfil" action="">
      <p>Perfil</p>
      <div class="imageUser">
        <i class="fas fa-user-alt"></i>
      </div>
      <label>Nome: <input value="Emanoel"/></label>

      <label>Sobrenome:<input value="Alves"/></label>

      <label>Email: <input value="emanoel-alves@hotmail.com"/></label>

      <div class="divLine"></div>
      <p>Endereço</p>
      <label>Cidade: <input value="Poranga"/></label>

      <label>Bairro: <input value="Betânia"/></label>

      <label>Rua: <input value="Bernardino Gomes"/></label>

      <label style="margin-bottom: 5%">Número: <input value="000"/></label>
      <div class="buttonsContent">
        <!-- <button class="button-perfil button1"> -->
        <router-link class="button-perfil button1" to="/home"
          >Salvar</router-link
        >
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
  display: flex;
  flex-direction: column;
  width: 100%;
  overflow: auto;
  background: #dfdfdf;

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
