<template>
  <div class="Menu">
      <div class="infoPerfil">
        <img src="../assets/logo.png" alt="" class="img1" />

        <img src="../assets/user.png" alt="Imagem perfil" class="img2" />

        <h4>Nome do usuário</h4>
      </div>

      <div class="infoMenu">
        <div class="OpcoesMenu">
          <router-link  to="/opcoes-do-dia">
            <img src="../assets/login.png" width="20px" alt="" /> Perfil
          </router-link>

          <router-link  to="/opcoes-do-dia">
            <img src="../assets/cesta.png" width="20px" alt="" /> Cesta
          </router-link>

          <router-link  to="/opcoes-do-dia">
            <img src="../assets/combo.png" width="18px" alt="" /> Combos
          </router-link>

          <router-link  to="/opcoes-do-dia"> 
             <img src="../assets/menu.png" width="20px" alt="" /> Cardápio
          </router-link>

          <!-- <a href="/opcoes-do-dia">
            <img src="../assets/menu.png" width="20px" alt="" /> Cardápio
          </a> -->

          <router-link  to="/opcoes-do-dia">
            <img src="../assets/delivery-truck.png" width="23px" alt="" />
            Perdido
           </router-link>
        </div>
      </div>
    </div>
</template>

<script>
export default {
name: "Menu",
  components: {
  },
};
</script>

<style>
.Menu {
  width: 290px;
  height: 100vh;
}

.Menu .infoPerfil {
  width: 100%;
  height: 40%;
  display: flex;
  flex-direction: column;
  align-content: center;
  background-color: #840705;

  color: white;
}

.Menu .infoMenu {
  width: 100%;
  height: 60%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  background-color: #840705;
  color: black;
}

.Menu .infoPerfil h2,
h4 {
  width: auto;
  margin: 8px auto;
  text-align: center;
}

.Menu .infoPerfil .img2 {
  width: 70px;
  height: 70px;
  margin: 0 auto;
  border-radius: 50%;
}

.Menu .infoPerfil .img1 {
  width: 130px;
  height: 42px;
  margin: 10px auto;
  margin-bottom: 70px;
}

.Menu .infoMenu .OpcoesMenu {
  width: 80%;
  display: flex;
  flex-direction: column;
  align-content: center;
  justify-content: center;
}

.Menu .infoMenu .OpcoesMenu a {
  font-size: 22px;
  font-weight: 400;
  color: white;
  text-decoration: none;
  margin: 15px 25px;
  transition: color 0.8s;
  text-align: left;
}

.Menu .infoMenu .OpcoesMenu a:hover {
  color: #470303;
}

.Menu .infoMenu .OpcoesMenu img {
  margin: auto;
}


</style>