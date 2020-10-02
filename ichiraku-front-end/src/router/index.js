import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../components/Home.vue";
import CadastroProduto from "../components/CadastroProduto.vue";
import InformacoesPrato from "../components/InformacoesPrato.vue";
import OpcoesDoDia from "../components/OpcoesDoDia.vue";
import TelaLogin from "../components/TelaLogin.vue";
import TelaCadastro from "../components/TelaCadastro.vue";
import Perfil from "../components/Perfil.vue";
import Pedido from "../components/Pedido.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "*",
    component: Home,
    meta: {
      title: "Ichiraku - Home",
    },
  },
  {
    path: "/",
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
    path: "/informacoes-prato",
    name: "InformacoesPrato",
    component: InformacoesPrato,
    meta: {
      title: "Ichiraku - Informações do Prato",
    },
  },
  {
    path: "/opcoes-do-dia",
    name: "OpcoesDoDia",
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
