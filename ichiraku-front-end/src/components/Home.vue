<template>
  <div class="Conteine">
    <div class="Menu">
      <div class="infoPerfil">
        <img src="../assets/logo.png" alt="" class="img1" />

        <img src="../assets/user.png" alt="Imagem perfil" class="img2" />

        <h4>Nome do usuário</h4>
      </div>

      <div class="infoMenu">
        <div class="OpcoesMenu">
          <a href="">
            <img src="../assets/login.png" width="20px" alt="" /> Perfil
          </a>

          <a href="">
            <img src="../assets/cesta.png" width="20px" alt="" /> Cesta
          </a>

          <a href="">
            <img src="../assets/combo.png" width="18px" alt="" /> Combos
          </a>

          <a href="../pages/opcoesDoDia.html">
            <img src="../assets/menu.png" width="20px" alt="" /> Cardápio
          </a>

          <a href="">
            <img src="../assets/delivery-truck.png" width="23px" alt="" />
            Perdido
          </a>
        </div>
      </div>
    </div>

    <section>
      <div class="Info">
        <h1>Bem-Vindo</h1>

        <h3>SÓ AQUI VOÇÊ ENCONTRA O MELHOR DA CULINÁRIA ASIÁTICA</h3>
      </div>

      <div class="logoHome">
        <img src="../assets/logo-home.png" alt="" />
      </div>
    </section>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "Home",
  components: {
    HelloWorld,
  },
};
</script>
<style scoped>
html,
body {
  margin: 0;
  padding: 0;
  width: 100%;
  font-family: "Roboto", sans-serif;
}

.Conteine {
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-content: center;
}

section {
  width: calc(100% - 290px);
  height: auto;
  display: flex;
  align-items: center;
  background-color: #ebebeb;
  color: black;
}

.Info {
  width: 50%;
  height: auto;
  margin: 30px auto;
  text-align: center;
}

.Info h3 {
  text-align: left;
  font-size: 20px;
  margin-top: 10px;
  margin-left: 40px;
}

.Info h1 {
  text-align: left;
  font-size: 70px;
  margin: 10px;
  margin-left: 40px;
  color: #b51616;
}

.logoHome {
  width: 50%;
  height: auto;
  display: flex;
  justify-content: flex-end;
  margin: 30px auto;
}

.logoHome img {
  width: 400px;
}
</style>
