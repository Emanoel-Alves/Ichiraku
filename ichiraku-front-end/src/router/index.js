import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import CadastroProduto from "../views/CadastroProduto.vue";
import InformacoesPrato from "../views/InformacoesPrato.vue";
import OpcoesDoDia from "../views/OpcoesDoDia.vue";
import TelaLogin from "../views/TelaLogin.vue";
import TelaCadastro from "../views/TelaCadastro.vue";
import Perfil from "../views/Perfil.vue";
import Pedido from "../views/Pedido.vue";
import Cesta from "../views/Cesta.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "*",
    component: TelaLogin,
    meta: {
      title: "Ichiraku - Login",
    },
  },
  {
    path: "/home",
    name: "Home",
    component: Home,
    meta: {
      title: "Ichiraku - Home",
    },
  },
  {
    path: "/perfil",
    name: "Perfil",
    component: Perfil,
    meta: {
      title: "Ichiraku - Perfil",
    },
  },
  {
    path: "/cadastro-produto",
    name: "CadastroProduto",
    component: CadastroProduto,
    meta: {
      title: "Ichiraku - Cadastro de Produtos",
    },
  },
  {
    path: "/informacoes-prato/:idPrato",
    name: "InformacoesPrato",
    component: InformacoesPrato,
    props: true,
    meta: {
      title: "Ichiraku - Informações do Prato",
    },
  },
  {
    path: "/opcoes-do-dia",
    name: "OpcoesDoDia",
    props: true,
    component: OpcoesDoDia,
    meta: {
      title: "Ichiraku - Opções do Dia",
    },
  },
  {
    path: "/login",
    name: "TelaLogin",
    component: TelaLogin,
    meta: {
      title: "Ichiraku - Login",
    },
  },
  {
    path: "/cadastro",
    name: "TelaCadastro",
    component: TelaCadastro,
    meta: {
      title: "Ichiraku - Cadastro",
    },
  },
  {
    path: "/pedido",
    name: "Pedido",
    component: Pedido,
    meta: {
      title: "Ichiraku - Pedidos",
    },
  },
  {
    path: "/cesta",
    name: "Cesta",
    component: Cesta,
    meta: {
      title: "Ichiraku - Cesta",
    },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

router.beforeEach((to, from, next) => {
  document.title = to.meta.title;
  next();
}); // aqui ele altera o titulo da pagina de acordo com dado meta do component

export default router;
