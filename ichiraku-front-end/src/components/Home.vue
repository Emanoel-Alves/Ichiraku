<template>
  <div class="Conteine">
    
    <Menu/>

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
import Menu from "@/components/Menu.vue";

export default {
  name: "Home",
  components: {
    Menu,
    HelloWorld
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
