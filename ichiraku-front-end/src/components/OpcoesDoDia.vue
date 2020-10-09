<template>
  <div class="Conteine">
    <Menu />

    <section class="Cardapio">
      <div class="Info">
        <h1>Nossas categorias populares</h1>
      </div>

      <div class="CardapioPratos">
        <router-link to="/opcoes-do-dia">
          <div class="box"><p>Sushi e sashimis</p></div></router-link
        >

        <router-link to="/opcoes-do-dia">
          <div class="box"><p>Pratos quentes</p></div></router-link
        >

        <router-link to="/opcoes-do-dia">
          <div class="box"><p>Sobremesas</p></div>
        </router-link>
      </div>

      <div class="OpcaoPratos">
        <div class="Pratos" v-for="prato in pratos" :key="prato.id">
          <img :src="'uploads/produto/' + prato.id + '.png'" alt="" />

          <div>
            <h4>{{ prato.nome }}</h4>

            <h5>R$ {{ prato.preco }}</h5>

            <router-link
              :to="{
                name: 'InformacoesPrato',
                path: '/informacoes-prato',
                params: { idPrato: prato.id },
              }"
            >
              Peça delivery
            </router-link>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import Menu from "@/components/Menu.vue";

export default {
  name: "Cardapio",

  data() {
    return {
      pratos: [],
      baseURI: "http://localhost:8080/ichiraku-back-and/api/produtos",
    };
  },
  components: {
    Menu,
  },
  methods: {
    getProdutos() {
      this.$http.get(this.baseURI).then((result) => {
        this.pratos = result.data;
      });
    },
  },
  mounted() {
    this.getProdutos();
  },
};
</script>

<style scoped>
.Conteine {
  width: 100%;
  display: flex;
  justify-content: center;
  align-content: center;
}

.Cardapio {
  width: calc(100% - 290px);
  height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #ebebeb;
  color: black;
  overflow: auto;
}

.Info {
  width: 80%;
  height: auto;
  margin: 30px auto;
}

.Info h1 {
  text-align: center;
  font-size: 33px;
  margin: 0;
}

.CardapioPratos {
  width: 80%;
  display: flex;
  justify-content: space-evenly;
  height: auto;
  margin: 5px auto;
}

.CardapioPratos a {
  width: 220px;
  height: 35px;
  position: relative;
  text-decoration: none;
}

.CardapioPratos .box {
  width: 220px;
  height: 35px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: white;
  text-align: center;
  position: absolute;
  color: black;
  transition: background-color 0.9s;
  border-radius: 4px;
}

.CardapioPratos .box p {
  margin: 0;
}

.CardapioPratos .box:hover {
  background-color: #403939;
  color: white;
}

.OpcaoPratos {
  width: 80%;
  display: grid;
  grid-template-columns: 220px 220px 220px;
  flex-direction: column;
  justify-content: space-evenly;
  height: auto;
  margin: 10px auto;
  margin-bottom: 30px;
}

.OpcaoPratos .Pratos {
  width: 100%;
  height: auto;
  margin: 10px 0;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  border-radius: 8px;
  background-color: white;
}

.Pratos div {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
}
.Pratos img {
  width: 130px;
  height: 130px;
  margin: 15px auto;
  border-radius: 8px;
}

.Pratos div h3,
h4 {
  margin: 8px 0;
}

.Pratos div a {
  width: 135px;
  border-radius: 3px;
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

.Pratos div a:hover {
  background-color: #b40707;
  border: 0.7px solid #b40707;
}
</style>