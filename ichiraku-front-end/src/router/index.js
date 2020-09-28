import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../components/Home.vue";
import CadastroProduto from "../components/CadastroProduto.vue";
import InformacoesPrato from "../components/InformacoesPrato.vue";
import OpcoesDoDia from "../components/OpcoesDoDia.vue";
import TelaLogin from "../components/TelaLogin.vue";
import TelaCadastro from "../components/TelaCadastro.vue";
import Perfil from "../components/Perfil.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "*",
    component: Home,
  },
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/perfil",
    name: "Perfil",
    component: Perfil,
  },
  {
    path: "/cadastro-produto",
    name: "CadastroProduto",
    component: CadastroProduto,
  },
  {
    path: "/informacoes-prato",
    name: "InformacoesPrato",
    component: InformacoesPrato,
  },
  {
    path: "/opcoes-do-dia",
    name: "OpcoesDoDia",
    component: OpcoesDoDia,
  },
  {
    path: "/login",
    name: "TelaLogin",
    component: TelaLogin,
  },
  {
    path: "/cadastro",
    name: "TelaCadastro",
    component: TelaCadastro,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
