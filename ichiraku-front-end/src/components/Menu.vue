<template>
  <div class="Menu">
    <div class="infoPerfil">
      <img src="../assets/logo.png" alt="" class="img1" />

      <img v-if="usuarioPerfil.imagem === false" src="../assets/user.png" alt="Imagem perfil" class="img2" />
       <img v-else class="imageUser" :src="'../uploads/usuarios/' + usuarioPerfil.id + '.png'" alt="">

      <h4>{{ usuarioPerfil.nome }}</h4>
    </div>

    <div class="infoMenu">
      <div class="OpcoesMenu">

        <router-link to="/home">
         <i class="fas fa-vihara"></i> Home
        </router-link>

        <router-link to="/perfil">
          <i class="fas fa-user-alt"></i> Perfil
        </router-link>

        <router-link to="/cesta">
          <i class="fas fa-shopping-basket"></i> Cesta
        </router-link>

        
        <router-link to="/opcoes-do-dia">
          <i class="fas fa-utensils"></i> Cardápio
        </router-link>

        <!-- <a href="/opcoes-do-dia">
            <img src="../assets/menu.png" width="20px" alt="" /> Cardápio
          </a> -->

        <router-link to="/pedido">
         <i class="fas fa-truck"></i> Pedido
        </router-link>
      </div>

       <div class="MenuSair" @click="Logout()">
       <router-link to="/login" >
        <i class="fas fa-sign-out-alt"></i> Logout
        </router-link>
       </div>

    </div>
  </div>
</template>

<script >
export default {
  name: "Menu",
  data(){
    return {
      usuarioPerfil: {},
      baseURI: "http://localhost:8080/api/usuarios",
      id: "",
    }
  },
  components: {},

  methods: {
    Logout() {
        this.$session.destroy();
        location.reload();
    }, 
    getUsuario() {
      this.usuario = JSON.parse(this.$session.get("usuario"));
      this.id = this.usuario[0].id;

      console.log(this.usuario[0].id);

      this.$http.get(this.baseURI + "/" + this.id).then((result) => {
        this.usuarioPerfil = result.data;
        console.log(this.usuarioPerfil.name);
      });
    },
  },
  created: function () {
    this.getUsuario();
  },
};
</script>

<style scoped>
.Menu {
  width: 290px;
  height: 100vh;
}

.Menu .infoPerfil {
  width: 100%;
  height: 40%;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #840705;

  color: white;
}

.imageUser{
  width: 100px;
  height: 100px;
  border-radius: 100% ;
}

.Menu .infoMenu {
  width: 100%;
  height: 60%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;

  background-color: #840705;
  color: black;
}

.Menu .infoPerfil h2,
h4 {
  width: auto;
  margin: 8px auto;
  text-align: center;
  font-size: 20px;
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
  margin-bottom: 50px;
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



.Menu .infoMenu .MenuSair a {
  font-size: 18px;
  font-weight: 400;
  color:  white;
  text-decoration: none;
  margin: 15px 25px;
  transition: color 0.8s;
  text-align: left;
}

.Menu .infoMenu .MenuSair a:hover {
  color: #470303;
}
</style>
